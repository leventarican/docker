# docker and jdk

## use Dockerfile
* we are using openjdk version 8
* we have just a simple Main.java class
* build: `docker build -t java-container .`
* run: `docker run java-container`

## compile and run app inside container

__Compile__
* compile with preview and release flag (e.g. 13) `docker run --rm -v "$PWD":/development -w /development openjdk:13 javac --enable-preview --release 13 Main.java`
* this will create the machine code: Main.class
* other jdk versions
```
docker run --rm -v "$PWD":/development -w /development openjdk:15 javac --enable-preview --release 15 Main.java
```

__Run__
* `docker run --rm -v "$PWD":/development -w /development openjdk:13 java --enable-preview Main`
* used docker run Options:
    * `--rm Automatically remove the container when it exits`
    * `-v, --volume list Bind mount a volume`
    * `-w, --workdir string                 Working directory inside the container`

```
docker run --rm -v "$PWD":/development -w /development openjdk:15 java --enable-preview Main
```

__Output__
```
hello docker.
java13Features: java13Features 200
javaLegacy: 100
```
