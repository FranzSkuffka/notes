main:
	docker build --no-cache -t my-java-app .
build:
	docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp openjdk:7 javac *.java
