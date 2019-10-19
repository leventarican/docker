# this base image is around < 100MB large
FROM ubuntu

MAINTAINER levent

ENV PI 314

RUN echo "container is running"

ADD /resources /resources

CMD echo 'start and sleep for 60s' && sleep 60s && echo end