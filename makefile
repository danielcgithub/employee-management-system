buildbackend: 
	cd employee-management-system-server && docker build -t danicudocker/employee-management-system-server:v1 . \
	&& docker push danicudocker/employee-management-system-server:v1

