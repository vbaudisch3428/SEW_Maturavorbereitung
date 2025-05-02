from Model import Model
from View import View  # Make sure this import is at the top


class Controller:
    """Handles communication between Model and View."""

    def __init__(self):
        self.model = Model()
        self.view = View(self)  # This now works because View is imported
        self.view.show()

        # Connect signals
        self.view.startButton.clicked.connect(self.handle_start)
        self.view.resetButton.clicked.connect(self.handle_reset)

    def handle_start(self):
        """Handle start button click."""
        try:
            if self.view.checkBox.isChecked():
                response = self.model.fetch_response(all=True)
            else:
                input_text = self.view.input.text() or "Hallo"
                count = self.view.spinBox.value()
                response = self.model.fetch_response(input_text, count)

            if response:
                self.view.output.setHtml(self.model.format_response(response))
            else:
                self.view.output.setText(f"Error: {self.model.last_error}")

        except Exception as e:
            self.view.output.setText(f"Error: {str(e)}")

    def handle_reset(self):
        """Handle reset button click."""
        self.view.reset()