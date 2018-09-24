FROM openjdk:8
COPY . /Users/wirthjan/notes/lectures/progII
WORKDIR /Users/wirthjan/notes/lectures/progII
# RUN javac -classpath . de/uniheidelberg/cl/prog2/node/Node.java
# RUN java -ea  de.uniheidelberg.cl.prog2.node.Node
# RUN javac -classpath . de/uniheidelberg/cl/prog2/io/NodeReader.java
# RUN java -ea  de.uniheidelberg.cl.prog2.io.NodeReader parse-trees.txt
# RUN ls -la /usr/share
RUN javac -cp '.:junit.jar:.:hamcrest.jar' GraphTest.java
RUN java -cp junit.jar:hamcrest-core.jar:. org.junit.runner.JUnitCore GraphTest
