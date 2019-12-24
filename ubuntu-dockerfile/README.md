# ubuntu based Dockerfile
__build__
* build: `docker build -t leventarican/ubuntu-container .`
    * tag convention: username/repository

__run__
* run: `docker run leventarican/ubuntu-container`
* or run in detached mode: `docker run -t -d leventarican/ubuntu-container` 
* _HINT_: use TAB for REPOSITORY autocompletion

__shell__
* connect to container with bash: `docker exec -it CONTAINERID bash`

__list__
* images: `docker images` 
* container: `docker ps`

__remove__
* image with force: `docker image rm -f IMAGE-ID`
* container with force: `docker rm -f CONTAINER-ID`

__bash__
* connect to container: `docker exec -it CONTAINER-ID /bin/bash`