package contracts;

import org.springframework.cloud.contract.spec.Contract 

Contract.make {
    description: "Should return a list of employees"
    request {
        url "/api/v1/employees"
        method GET()
    }
    response {
        status 200
        body([])
    }

}