# model.py
import requests

class HandballModel:
    """Das Modell für die Handball-Daten (Vorhersagen und Ranglisten)"""

    BASE_URL = "http://127.0.0.1:5000/handball"

    def __init__(self):
        self.last_response = None
        self.last_error = None

    def fetch_match_prediction(self, is_women=True, home_team="Austria", away_team="Germany"):
        """Lädt eine Vorhersage für ein Handball-Match"""
        params = {
            'frauen': str(is_women).lower(),
            'staat1': home_team,
            'staat2': away_team,
            'liste': 'false'
        }
        return self._make_request(params)

    def fetch_ranking(self, is_women=True, start=1, end=10):
        """Lädt die Handball-Rangliste"""
        params = {
            'frauen': str(is_women).lower(),
            'liste': 'true',
            'start': start,
            'ende': end
        }
        return self._make_request(params)

    def _make_request(self, params):
        """Hilfsfunktion für HTTP-Anfragen"""
        try:
            response = requests.get(self.BASE_URL, params=params)
            response.raise_for_status()
            self.last_response = response.json()
            self.last_error = None
            return self.last_response
        except requests.exceptions.RequestException as e:
            self.last_error = str(e)
            self.last_response = None
            return None

    def format_match_prediction(self, data):
        """Formatieren der Vorhersage als HTML"""
        if not data:
            return "Fehler bei der Vorhersage"

        return f"Ergebnis für das geplante Spiel: {data['Staat1']} vs {data['Staat2']} -> Vorhersage: {data['ToreGG']}:{data['ToreGast']}"

    def format_ranking(self, data):
        """Formatieren der Rangliste als HTML"""
        if not data:
            return "Fehler bei der Rangliste"

        html = f"Rangliste für Handball {('Frauen' if data['Frauen'] else 'Männer')} Teams:<br/>"
        for item in data['Rangliste']:
            html += f"Platz {item['Platz']}: {item['Land']}<br/>"
        return html
