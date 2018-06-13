main:
	docker build --no-cache -t my-java-app .
build:
	docker run --rm -v `pwd`:/usr/src/myapp -w /usr/src/myapp openjdk:7 javac MyDate.java Name.java Person.java PersonTester.java 
