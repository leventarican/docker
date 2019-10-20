# docker and jdk (java 13)
* TODO: create dockerfile

## compile and run app inside container
* compile with preview and release flag (e.g. 13) `docker run --rm -v "$PWD":/development -w /development openjdk:13 javac --enable-preview --release 13 Main.java`
* this will create the machine code: Main.class
* run `docker run --rm -v "$PWD":/development -w /development openjdk:13 java --enable-preview Main`
* result 
```
hello docker.
java13Features: java13Features 200
javaLegacy: 100
```
