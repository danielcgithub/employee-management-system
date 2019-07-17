package contracts;

org.springframework.cloud.contract.spec.Contract.make {
    description: "Should create an employee"
    request{
        url "/api/v1/employees"
        method POST()
        body ''' {"firstName": "testFirstName", "lastName": "testLastName", "emailId": "emailaddress@gmail.com"} '''
        headers {
            contentType(applicationJson())
        }
    }
    response{
        status 200
    }
}