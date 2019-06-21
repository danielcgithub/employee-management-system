dir ?= ~/workspaces/employee-management-system/employee-management-system-server
legacy:
	docker run --name mysql-ems -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=users_database -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=Passw0rd -p 3306:3306 -d mysql/mysql-server:latest \
	&& mvn clean install -f $(dir)/pom.xml && java -jar $(dir)/target/employee-management-system-server-0.0.1-SNAPSHOT.jar

buildbackend: 
	cd employee-management-system-server && docker build -t danicudocker/employee-management-system-server:v1 . \
	&& docker push danicudocker/employee-management-system-server:v1

