from flask import Flask
from flask import request

app = Flask(__name__)

@app.route('/')
def index():
    return 'flask (python) in container'

@app.route("/ping")
def ping():
    return "pong"

@app.route("/webhook", methods=['GET', 'POST'])
def webhook():
    commit_user = None
    if request.method == 'POST':
        data = request.get_json()
        commit_user = data['user']
        print(f'webhook received. commit from {commit_user}.')
    return "webhook" + str(commit_user)

if __name__ == '__main__':
    app.run(host='0.0.0.0') # on localhost: bind ip