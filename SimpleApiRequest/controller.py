from model import fetch_recipe_by_id

class Controller:
    def __init__(self, view):
        self.view = view
        self.setup_connections()

    def setup_connections(self):
        self.view.pushButton.clicked.connect(self.call_api)
        self.view.checkboxDefault.stateChanged.connect(self.toggle_input_field)
        self.view.input.setPlaceholderText("Gib die ID hier ein")
        self.view.output.setReadOnly(True)

    def toggle_input_field(self):
        self.view.input.setDisabled(self.view.checkboxDefault.isChecked())

    def call_api(self):
        if self.view.checkboxDefault.isChecked():
            recipe_id = "1"
        else:
            recipe_id = self.view.input.toPlainText().strip()
            if not recipe_id.isdigit():
                self.view.input.setPlaceholderText("Bitte eine gültige ID eingeben!")
                return

        self.view.input.setPlainText("")

        try:
            data = fetch_recipe_by_id(recipe_id)

            if self.view.checkboxHtml.isChecked():
                html = (f"<b>Name:</b> {data['name']}<br>"
                        f"<b>Ingredients:</b> {', '.join(data['ingredients'])}<br>"
                        f"<b>Servings:</b> {data['servings']}<br>"
                        f"<b>Calories per serving:</b> {data['caloriesPerServing']}<br>"
                        f"<b>Instructions:</b> {data['instructions']}")
                self.view.output.setHtml(html)
            else:
                plain = (f"Name: {data['name']}\n"
                         f"Ingredients: {data['ingredients']}\n"
                         f"Servings: {data['servings']}\n"
                         f"Calories per serving: {data['caloriesPerServing']}\n"
                         f"Instructions: {data['instructions']}")
                self.view.output.setPlainText(plain)

            self.view.checkboxDefault.setChecked(False)
            self.view.checkboxHtml.setChecked(False)
            self.view.statusBar().showMessage("Abfrage erfolgreich")

        except Exception as e:
            self.view.output.setPlainText(f"Fehler: {e}")
            self.view.statusBar().showMessage("Abfrage nicht erfolgreich")
