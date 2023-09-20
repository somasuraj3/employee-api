Employee API Service

Description :
- Employee REST API application, without database. (Uses simple list to manage employees with 3 default employee details in the list)
- Application runs on port 8080.
- Employee API provide 5 endpoints
  1. GET /employees : Returns all employees.
  2. GET /employees/{eid} : Returns single employee, if exists.
  3. POST /employees | Request body {eid:longValue, name:stringValue} : Adds employee to list.
  4. PUT /employees | Request body {eid:longValue, name:stringValue} : Updates employee name, if exists.
  5. DELETE /employees/{eid} : Deletes employee, if exists.


How to run application on local development server
- mvn spring-boot:run

How to build application
- mvn clean package

How to build docker image
- docker image build -t {optional_repo_name}/{image_name}:{optional_tag_name}

How to run docker image
- docker container run -d -p {host_port}:8080 -e podIp={value} -e podNodeIp={value} -e clusterName={value} -e nodeName={value} {optional_repo_name}/{image_name}:{tag_name}

How to use already built image, which is available publically
- docker container run -d -p {host_port}:8080 -e podIp={value} -e podNodeIp={value} -e clusterName={value} -e nodeName={value} somasuraj/employee-api:latest
- Replace placeholders with values, before running above command.