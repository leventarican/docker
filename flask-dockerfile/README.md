# flask (python) docker container
* build: `docker build -t leventarican/flask .`
* run (bind host port): `docker run -p 5000:5000 leventarican/flask`

## example calls
```
curl -v 0.0.0.0:5000/ping

curl localhost:5000/webhook -d '{"user":"foobar", "lang":"python"}' -H "Content-Type: application/json"

curl localhost:5000/linux
curl localhost:5000/git
curl localhost:5000/python
```