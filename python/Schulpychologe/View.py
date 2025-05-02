from PyQt5.QtWidgets import QMainWindow
from PyQt5.QtCore import Qt
from PyQt5 import uic


class View(QMainWindow):
    def __init__(self, controller):
        super().__init__()
        self.controller = controller
        uic.loadUi('psychologe.ui', self)

        # Set default values
        self.input.setPlaceholderText("Hallo")  # Shows hint text
        self.spinBox.setValue(1)  # Default count
        self.checkBox.setChecked(False)  # Default unchecked

        # Connect signals
        self.checkBox.stateChanged.connect(self.state_has_changed)
        self.startButton.clicked.connect(self.controller.handle_start)
        self.resetButton.clicked.connect(self.controller.handle_reset)

    def state_has_changed(self, state):
        is_checked = state == Qt.Checked
        self.spinBox.setEnabled(not is_checked)
        self.input.setEnabled(not is_checked)

    def reset(self):
        """Reset to default values"""
        self.input.clear()
        self.spinBox.setValue(1)
        self.checkBox.setChecked(False)
        self.output.clear()
        self.input.setFocus()  # Put cursor back in input field