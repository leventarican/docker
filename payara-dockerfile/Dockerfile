# payara image

# base image
FROM azul/zulu-openjdk:8u222

LABEL maintainer="levent@protonmail.com"

# Set labels used in OpenShift to describe the builder image
LABEL io.k8s.description="Platform for serving java apps - powered by payara" \
      io.k8s.display-name="payara server full 5.194" \
      io.openshift.expose-services="8080:http" \
      io.openshift.tags="payara server full profile 5.194, java, microprofile"

# https://github.com/payara/docker-payaraserver-full/blob/master/Dockerfile
# https://github.com/AdamBien/docklands/blob/master/payara-s2i/Dockerfile

# Default payara ports to expose
# 4848: admin console
# 9009: debug port (JPDA)
# 8080: http
# 8181: https
EXPOSE 4848 9009 8080 8181

RUN groupadd -g 1000 payara && \
    useradd -u 1000 -M -s /bin/bash -d /opt/payara5 payara -g payara && \
    echo payara:payara | chpasswd
    # user_name:password

# assumes that you provide a payara.zip
# otherwise use wget to retrieve it
# maybe use ADD with tar extract
COPY --chown=payara:payara payara.zip .
COPY --chown=payara:payara start.sh /opt/payara5/

RUN apt-get update -y && \
    apt-get install -y unzip && \
    # apt-get install -y wget && \
    # wget https://search.maven.org/remotecontent?filepath=fish/payara/distributions/payara/5.194/payara-5.194.zip -O payara.zip && \
    unzip -d /opt payara.zip && \
    chmod +x /opt/payara5/start.sh && \
    ls /opt/payara5 && \
    cd /opt/payara5

# Configure the password file for configuring Payara
ENV DOMAIN_NAME=domain1\
    ADMIN_USER=admin\
    ADMIN_PASSWORD=admin
RUN echo "AS_ADMIN_PASSWORD=\nAS_ADMIN_NEWPASSWORD=${ADMIN_PASSWORD}" > /tmp/tmpfile && \
    echo "AS_ADMIN_PASSWORD=${ADMIN_PASSWORD}" >> /opt/payara5/passwordFile && \
    /opt/payara5/bin/asadmin --user ${ADMIN_USER} --passwordfile=/tmp/tmpfile change-admin-password --domain_name=${DOMAIN_NAME} && \
    /opt/payara5/bin/asadmin --user=${ADMIN_USER} --passwordfile=/opt/payara5/passwordFile start-domain ${DOMAIN_NAME} && \
    /opt/payara5/bin/asadmin --user=${ADMIN_USER} --passwordfile=/opt/payara5/passwordFile enable-secure-admin && \
    /opt/payara5/bin/asadmin --user=${ADMIN_USER} --passwordfile=/opt/payara5/passwordFile stop-domain ${DOMAIN_NAME}

RUN chown -R payara: /opt/payara5

WORKDIR /opt/payara5
USER payara

CMD /opt/payara5/start.sh