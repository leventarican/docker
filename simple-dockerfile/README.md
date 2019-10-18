# simple Dockerfile
* we are using a python base image
* we have also a simple python program

## steps
* build it: `docker build .` or with tag `docker build -t python-container .`
* run it: `docker run python-container`

## further docker commands
* list images: `docker images`
* list container: `docker container ls` or `docker ps` 
* remove container: `docker rm CONTAINERID` or force `docker rm -f CONTAINERID`
* remove image: `docker rmi IMAGEID`
* connect to container with bash: `docker exec -it CONTAINERID bash`
* run container and dont kill it for 10s: `docker run -d python sleep 10`