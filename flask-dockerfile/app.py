from flask import Flask
from flask import request
from subprocess import check_output

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

@app.route("/linux")
def linux():
    stdout = check_output(['uname', '-a']).decode('utf-8')
    return stdout

@app.route("/git")
def git():
    stdout = check_output(['git', 'version']).decode('utf-8')
    return stdout

@app.route("/python")
def python_version():
    stdout = check_output(['python', '--version']).decode('utf-8')
    return stdout

if __name__ == '__main__':
    app.run(host='0.0.0.0') # on localhost: bind ip