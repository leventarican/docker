FROM node:14
# you local TZ: cat /etc/timezone
# ENV TZ="Europe/Amsterdam"
# copy file from local file system to image file system
COPY server.js /src/
# switch to user node. prevent executing as root user.
USER node
# node /src/server.js
CMD ["node", "/src/server.js"]