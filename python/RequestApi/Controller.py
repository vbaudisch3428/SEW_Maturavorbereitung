from Model import MyModel
from View import Ui_MainWindow

class MyController:
    def __init__(self):
        self.model = MyModel()
        self.view = Ui_MainWindow(self)
        self.reset()
        self.view.show()

    def reset(self):
        self.view.reset()

    def makeRequest(self):
        use_html = self.view.checkboxHtml.isChecked()

        if self.view.fetchAll.isChecked():
            result = self.model.fetch_all()
        else:
            comment_id = "1" if self.view.checkboxDefault.isChecked() else self.view.inputField.toPlainText().strip()
            if not comment_id:
                self.view.output.setText("Bitte eine ID eingeben oder 'Default ID' auswählen.")
                return
            result = self.model.fetch_url(comment_id, html=use_html)

        if use_html:
            self.view.output.setHtml(result)
        else:
            self.view.output.setText(result)
