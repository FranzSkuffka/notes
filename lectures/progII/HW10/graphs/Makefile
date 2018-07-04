main:
	docker build --no-cache -t my-java-app .
build:
	docker run --rm -v `pwd`:/usr/src/myapp -w /usr/src/myapp openjdk:8 javac Document.java SearchEngine.java StringSimilarity.java TFIDFCalculator.java
