import sys
from PyQt5.QtWidgets import QApplication
from Controller import Controller

def main():
    """Main application entry point."""
    app = QApplication(sys.argv)
    controller = Controller()
    sys.exit(app.exec_())

if __name__ == '__main__':
    main()