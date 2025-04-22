import sys
from PyQt5.QtWidgets import QApplication
from view import MainWindow
from controller import Controller

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = MainWindow()
    controller = Controller(window)
    window.show()
    sys.exit(app.exec())
