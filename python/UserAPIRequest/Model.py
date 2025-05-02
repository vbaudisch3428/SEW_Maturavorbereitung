import requests

class MyModel:
    base_url = "https://dummyjson.com/users"
    def __init__(self):
        pass

    def fetchUrlById(self, userId):
        try:
            new_url = f"{self.base_url}/{userId}"
            response = requests.get(new_url)
            response.raise_for_status()
            data = response.json()
            return f"{data}"
        except Exception as e:
            print(e)
            return None

    def fetchUrlByName(self, name):
        try:
            new_url = f"{self.base_url}/search?q={name}"
            response = requests.get(new_url)
            response.raise_for_status()
            data = response.json()
            return f"{data}"
        except Exception as e:
            print(e)
            return None