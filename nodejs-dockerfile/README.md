# Node.js

* we want to create a docker __container__. for this we need an docker image. the container will derived then by this image.
* image we create a `Dockerfile`.
* build docker image with: `docker build -t nodejs .`
* run docker image as a container: `docker run -p 8080:8080 nodejs`
* stop with: `docker stop CONTAINER-ID`