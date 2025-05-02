import requests


class Model:
    """
    Handles communication with the webservice and response formatting.
    """

    BASE_URL = "http://127.0.0.1:5000/chat"

    def __init__(self):
        self.last_response = None
        self.last_error = None

    def fetch_response(self, input_text="Hallo", count=1, all=False):
        """Fetch response from the webservice.

        Args:
            input_text (str): Input sentence (default: "Hallo")
            count (int): Number of responses (default: 1)
            all (bool): Get entire knowledge base (default: False)

        Returns:
            dict: JSON response from the webservice or None if error occurred
        """
        params = {
            "input": input_text,
            "count": count,
            "all": "true" if all else "false"
        }
        return self.make_request(params)

    def make_request(self, params):
        """Make HTTP request to the webservice.

        Args:
            params (dict): Request parameters

        Returns:
            dict: JSON response or None if error occurred
        """
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

    def format_response(self, data):
        """Format the response as HTML.

        Args:
            data (dict): Response data from webservice

        Returns:
            str: HTML formatted response
        """
        if not data:
            return "Error: No response data available"

        if "response" not in data:
            return "Error: Invalid response format"

        response = data["response"]
        input_text = data.get("input", "")

        if isinstance(response, list):
            # Multiple responses
            html_responses = "<br/>".join([f"<b>{r}</b>" for r in response])
            return f"Für die Eingabe <i>'{input_text}'</i> haben wir folgende Antworten erhalten:<br/>{html_responses}"
        elif isinstance(response, dict):
            # Entire knowledge base
            html = "Aktuelle Wissensdatenbank mit allen Stichwörtern und Antwortmöglichkeiten<br/>"
            for key, answers in response.items():
                html += f"<b>{key}:</b><br/>"
                html += "<br/>".join(answers) + "<br/><br/>"
            return html
        else:
            # Single response
            return f"Für die Eingabe <i>'{input_text}'</i> haben wir die Antwort<br/><b>{response}</b><br/>erhalten!"


if __name__ == "__main__":
    # Test the Model class
    model = Model()

    # Test default request
    print("Testing default request:")
    response = model.fetch_response()
    print(response)
    print(model.format_response(response))

    # Test multiple responses
    print("\nTesting multiple responses:")
    response = model.fetch_response("Ich habe Probleme", count=2)
    print(response)
    print(model.format_response(response))

    # Test entire knowledge base
    print("\nTesting entire knowledge base:")
    response = model.fetch_response(all=True)
    print(response)
    print(model.format_response(response))