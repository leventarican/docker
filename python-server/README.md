run python-server with python
-----------------------------
* server serves under port 8080
* do a server request
```
curl -i localhost:8080
```

run python-server with container
--------------------------------
* create image
```
docker build -t python-server .
```
* create and run container
* we need to do a port mapping ex. `8080 -> 9090`
```
docker run -p 9090:8080 python-server
```
* do a server request
```
curl -i localhost:9090
```