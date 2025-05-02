# view.py
from PyQt5.QtWidgets import QMainWindow, QCheckBox, QSpinBox, QComboBox, QTextEdit, QPushButton, QStatusBar
from PyQt5 import uic
from PyQt5.QtCore import Qt

class HandballView(QMainWindow):
    """GUI für die Handball Vorhersage-App basierend auf handball.ui"""

    # Definiere alle Widgets als Klassenvariablen für bessere Autovervollständigung
    checkFrauen: QCheckBox
    checkListe: QCheckBox
    startPos: QSpinBox
    endPos: QSpinBox
    gastgeber: QComboBox
    gast: QComboBox
    output: QTextEdit
    startbutton: QPushButton
    resetbutton: QPushButton
    closebutton: QPushButton
    statusbar: QStatusBar

    def __init__(self):
        super().__init__()
        uic.loadUi('handball.ui', self)  # Lade das UI-File und binde alle Widgets direkt an self

        # Initialisierungen und Verbindungen
        self.statusbar.showMessage("Bereit")  # Anfangszustand der Statusleiste

        # Checkbox-Verhalten verbinden (Liste oder Vorhersage)
        self.checkListe.stateChanged.connect(self.toggle_ranking_mode)

    def toggle_ranking_mode(self, state):
        """Aktiviere/Deaktiviere Eingabefelder je nach Auswahl"""
        is_ranking = state == Qt.Checked
        self.startPos.setEnabled(is_ranking)
        self.endPos.setEnabled(is_ranking)
        self.gastgeber.setEnabled(not is_ranking)
        self.gast.setEnabled(not is_ranking)

        if is_ranking:
            self.statusbar.showMessage("Weltranglistenmodus aktiviert")
        else:
            self.statusbar.showMessage("Spielvorhersagemodus aktiviert")
