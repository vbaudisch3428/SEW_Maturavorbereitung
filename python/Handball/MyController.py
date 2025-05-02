# controller.py
from PyQt5.QtCore import QObject
from MyModel import HandballModel


class HandballController(QObject):
    """Controller, der zwischen View und Model vermittelt"""

    def __init__(self, view):
        super().__init__()
        self.view = view
        self.model = HandballModel()

        # Verbindung der Buttons mit den entsprechenden Methoden
        self.view.startbutton.clicked.connect(self.handle_start)
        self.view.resetbutton.clicked.connect(self.handle_reset)
        self.view.closebutton.clicked.connect(self.view.close)

    def handle_start(self):
        """Verarbeitet den Start-Button und holt entweder Rangliste oder Vorhersage"""
        try:
            if self.view.checkListe.isChecked():
                # Rangliste holen
                result = self.model.fetch_ranking(
                    is_women=self.view.checkFrauen.isChecked(),
                    start=self.view.startPos.value(),
                    end=self.view.endPos.value()
                )

                if self.model.last_error:
                    self.view.output.setHtml(f"<b>Fehler:</b> {self.model.last_error}")
                    self.view.statusbar.showMessage("Fehler beim Abrufen der Rangliste")
                else:
                    self.view.output.setHtml(self.model.format_ranking(result))
                    self.view.statusbar.showMessage("Rangliste erfolgreich abgerufen")
            else:
                # Vorhersage holen
                result = self.model.fetch_match_prediction(
                    is_women=self.view.checkFrauen.isChecked(),
                    home_team=self.view.gastgeber.currentText(),
                    away_team=self.view.gast.currentText()
                )

                if self.model.last_error:
                    self.view.output.setHtml(f"<b>Fehler:</b> {self.model.last_error}")
                    self.view.statusbar.showMessage("Fehler bei der Vorhersage")
                else:
                    self.view.output.setHtml(self.model.format_match_prediction(result))
                    self.view.statusbar.showMessage("Vorhersage erfolgreich abgerufen")
        except Exception as e:
            self.view.output.setHtml(f"<b>Unerwarteter Fehler:</b> {str(e)}")
            self.view.statusbar.showMessage("Fehler aufgetreten")

    def handle_reset(self):
        """Setzt alle Eingabefelder zurück"""
        self.view.checkFrauen.setChecked(True)
        self.view.checkListe.setChecked(False)
        self.view.startPos.setValue(1)
        self.view.endPos.setValue(10)
        self.view.gastgeber.setCurrentIndex(0)
        self.view.gast.setCurrentIndex(0)
        self.view.output.clear()
        self.view.statusbar.showMessage("Felder zurückgesetzt")
