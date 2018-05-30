main:
	docker build --no-cache -t my-java-app .
build:
	docker run --rm -v `pwd`:/usr/src/myapp -w /usr/src/myapp openjdk:7 javac de/uniheidelberg/cl/prog2/io/NodeReader.java de/uniheidelberg/cl/prog2/node/Node.java de/uniheidelberg/cl/prog2/node/NonTerminalNode.java de/uniheidelberg/cl/prog2/node/TerminalNode.java
