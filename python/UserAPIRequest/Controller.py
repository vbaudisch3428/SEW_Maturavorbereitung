from PyQt6.QtWidgets import QApplication, QMainWindow
from Model import MyModel
from View import Ui_MainWindow

class MyController:
    def __init__(self):
        self.model = MyModel()
        self.mainWindow = QMainWindow()
        self.view = Ui_MainWindow()
        self.view.setupUi(self.mainWindow, self)
        self.reset()
        self.mainWindow.show()

    def reset(self):
        self.view.reset()

    def make_request(self):
        if self.view.input.toPlainText().strip() == "":
            spinboxvalue = self.view.spinBox.value()
            self.view.output.setHtml(self.model.fetchUrlById(spinboxvalue))
        else:
            textfieldvalue = self.view.input.toPlainText().strip()
            self.view.output.setHtml(self.model.fetchUrlByName(textfieldvalue))

if __name__ == "__main__":
    import sys
    app = QApplication(sys.argv)
    c = MyController()
    sys.exit(app.exec())

