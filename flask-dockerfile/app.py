from flask import Flask
app = Flask(__name__)

@app.route('/')
def index():
    return 'flask (python) in container'

@app.route("/ping")
def ping():
    return "pong"

if __name__ == '__main__':
    app.run(host='0.0.0.0') # on localhost: bind ip