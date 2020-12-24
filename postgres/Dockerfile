FROM postgres 
ENV POSTGRES_PASSWORD postgres 
ENV POSTGRES_DB developer-db 
COPY init.sql /docker-entrypoint-initdb.d/
