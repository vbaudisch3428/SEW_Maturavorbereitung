from PyQt5.QtWidgets import QMainWindow, QTextEdit, QPushButton, QCheckBox
from PyQt5 import uic

class MainWindow(QMainWindow):

    pushButton: QPushButton
    output: QTextEdit
    input: QTextEdit
    checkboxDefault: QCheckBox
    checkboxHtml: QCheckBox

    def __init__(self):
        super().__init__()
        uic.loadUi("mainwindow.ui", self)
