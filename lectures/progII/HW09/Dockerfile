FROM openjdk:8
COPY . /Users/wirthjan/notes/lectures/progII
WORKDIR /Users/wirthjan/notes/lectures/progII
# RUN javac -classpath . de/uniheidelberg/cl/prog2/node/Node.java
# RUN java -ea  de.uniheidelberg.cl.prog2.node.Node
# RUN javac -classpath . de/uniheidelberg/cl/prog2/io/NodeReader.java
# RUN java -ea  de.uniheidelberg.cl.prog2.io.NodeReader parse-trees.txt
RUN javac -cp . SearchEngine.java
RUN java -cp . -ea SearchEngine
