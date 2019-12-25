# payara Dockerfile
__build__
* build: `docker build -t leventarican/payara .`
    * tag convention: username/repository

__run__
* run with port forwarding: `docker run -p 8080:8080 -p 4848:4848 leventarican/payara`
* or run in detached mode: `docker run -t -d leventarican/payara` 
* _HINT_: use TAB for REPOSITORY autocompletion

__shell__
* connect to container with bash: `docker exec -it CONTAINERID bash`

__list__
* images: `docker images` 
* container: `docker ps`

__remove__
* image with force: `docker image rm -f IMAGE-ID`
    * or: `docker rmi IMAGE-ID`
* container with force: `docker rm -f CONTAINER-ID`
* delete all stopped container: `docker rm $(docker ps -a -q)`

__stop container__
* stop: `docker stop CONTAINER-ID`

__bash__
* connect to container: `docker exec -it CONTAINER-ID /bin/bash`