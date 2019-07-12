package contracts;

org.springframework.cloud.contract.spec.Contract.make {
    description: "Should create an employee"
    request{
        url "/api/v1/employees"
        method POST()
        body (
            firstName: 'testFirstName',
            lastName: 'testLastName',
            emailId: 'emailaddress@gmail.com'
        )
        headers {
			header 'Content-Type', 'application/json'
		}
    }
    response{
        status 200
        body(
            id: value(producer(regex('[0-9]'))),
            firstName: 'testFirstName',
            lastName: 'testLastName',
            emailId: 'emailaddress@gmail.com'
        )
    }
}