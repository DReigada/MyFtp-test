CLNVERSION = 1.0-SNAPSHOT
SRVVERSION = 1.0-SNAPSHOT
CLNOUTJAR = client.jar
SRVOUTJAR = server.jar


all: client.jar server.jar

client.jar:
	cd client ; mvn clean compile package
	cp client/target/socket-client-${CLNVERSION}-jar-with-dependencies.jar ${CLNOUTJAR}

server.jar:
	cd server ; mvn clean compile package
	cp server/target/socket-server-${SRVVERSION}-jar-with-dependencies.jar ${SRVOUTJAR}


clean:
	cd client; mvn clean
	cd server; mvn clean
	rm -f ${SRVOUTJAR} ${CLNOUTJAR}
