import sys
from PyQt6.QtWidgets import QApplication
from Controller import MyController

if __name__ == "__main__":
    app = QApplication(sys.argv)
    c = MyController()
    sys.exit(app.exec())
