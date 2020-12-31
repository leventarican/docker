# Docker Compose: Python Flask and Redis
* https://docs.docker.com/compose/gettingstarted/
* create a `docker-compose.yml`: the compose file defines two services: _web (flask)_ and _cache (redis)_
* create also `Dockerfile` for the image

## start
```
docker-compose up

Starting flask-redis-compose_web_1   ... done
Starting flask-redis-compose_redis_1 ... done
...
redis_1  | 1:M 31 Dec 2020 22:59:21.966 * Ready to accept connections
web_1    |  * Running on http://0.0.0.0:5000/ 
```

## stop
```
docker-compose stop

Stopping flask-redis-compose_redis_1 ... done
Stopping flask-redis-compose_web_1   ... done
```