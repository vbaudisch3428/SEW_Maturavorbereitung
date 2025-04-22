import requests

def fetch_recipe_by_id(recipe_id):
    url = f"https://dummyjson.com/recipes/{recipe_id}"
    response = requests.get(url)
    response.raise_for_status()
    return response.json()
