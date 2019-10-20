FROM openjdk:13

COPY Main.java /app/Main.java

WORKDIR /app

RUN javac --enable-preview --release 13 Main.java

CMD ["java", "--enable-preview", "Main"]