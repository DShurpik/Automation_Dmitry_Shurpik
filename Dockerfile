FROM markhobson/maven-chrome:jdk-11

# create project folder
RUN mkdir project
RUN ls
WORKDIR project

COPY . .

RUN mvn clean test -Dconfig="saucedemo" -DsuiteXml="Task_11"