# Apache 

* we want to create a docker __container__. for this we need an docker image. the container will derived then by this image.
* image we create a `Dockerfile`.
* for demo purpose we use php. check `index.php`
* build docker image with: `docker build -t apache-php .`
* run docker image as a container: `docker run -p 8080:80 apache-php`
