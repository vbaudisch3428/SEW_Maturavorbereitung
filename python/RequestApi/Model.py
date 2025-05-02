import requests

class MyModel:
    url = "https://dummyjson.com/comments"

    def fetch_url(self, comment_id, html=False):
        try:
            response = requests.get(f"{self.url}/{comment_id}")
            response.raise_for_status()
            data = response.json()
            if html:
                return (
                    f"<b>Comment</b>: {data['body']}<br>"
                    f"<b>PostID</b>: {data['postId']}<br>"
                    f"<b>Likes</b>: {data['likes']}<br>"
                    f"<b>User</b>: {data['user']['fullName']}"
                )
            return (
                f"Comment: {data['body']}\n"
                f"PostID: {data['postId']}\n"
                f"Likes: {data['likes']}\n"
                f"User: {data['user']['fullName']}"
            )
        except Exception as e:
            return f"<b>Error</b>: {e}" if html else f"Error: {e}"

    def fetch_all(self):
        try:
            response = requests.get(self.url)
            response.raise_for_status()
            return str(response.json())
        except Exception as e:
            return f"Error: {e}"
