package com.springsoapapi.controller;

import com.springsoapapi.employee.GetEmployeeRequest;
import com.springsoapapi.employee.GetEmployeeResponse;
import com.springsoapapi.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Dang Dim
 * Date     : 3/15/2019, 3:05 PM
 * Email    : d.dim@gl-f.com
 */

@Endpoint
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;


    private static final String NAME_SPACE = "http://springsoapapi.com/employee/";


    @PayloadRoot(namespace = NAME_SPACE, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {

        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(employeeRepo.findEmployee(request.getId()));
        return response;
    }

}
