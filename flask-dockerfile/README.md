# flask (python) docker container
* build: `docker build -t leventarican/flask .`
* run (bind host port): `docker run -p 5000:5000 leventarican/flask`
* call: `curl -v 0.0.0.0:5000/ping`