# payara Dockerfile

* you have to provide your own `payara.zip` in order to get work this example.

__build__
* build: `docker build -t leventarican/payara .`
    * tag convention: username/repository

__run__
* run with port forwarding: `docker run -p 8080:8080 -p 4848:4848 leventarican/payara`
* or run in detached mode: `docker run -t -d leventarican/payara` 
* _HINT_: use TAB for REPOSITORY autocompletion
