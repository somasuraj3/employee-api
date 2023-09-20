package com.cybage.myjavaapp.controller;

import com.cybage.myjavaapp.model.Employee;
import com.cybage.myjavaapp.model.ErrorResponse;
import com.cybage.myjavaapp.model.GroupResponse;
import com.cybage.myjavaapp.model.InfraDetails;
import com.cybage.myjavaapp.model.Message;
import com.cybage.myjavaapp.model.Response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    
    List<Employee> employees;

    @Value("${podIp}")
    private String podIp;

    @Value("${podNodeIp}")
    private String podNodeIp;

    @Value("${clusterName}")
    private String clusterName;

    @Value("${nodeName}")
    private String nodeName;

    public EmployeeController () {
        employees = List.of(
            new Employee(1L, "John"),
            new Employee(2L, "Jane"),
            new Employee(3L, "Jack")
        );
    }
    
    @GetMapping("/employees")
    public ResponseEntity<Object> getAllEmployees() {
        return new ResponseEntity<Object>(new GroupResponse(employees, new InfraDetails(podIp, podNodeIp, LocalDateTime.now().toString(), clusterName, nodeName)), HttpStatus.OK);
    }

    @GetMapping("/employees/{eid}")
    public ResponseEntity<Object> getEmployee(@PathVariable Long eid) {
        Employee employee = employees.stream().filter(e -> e.getEid().equals(eid)).findFirst().get();
        if (employee == null) {
            return new ResponseEntity<Object>(new ErrorResponse(new Message("Employee not found"), new InfraDetails(podIp, podNodeIp, LocalDateTime.now().toString(), clusterName, nodeName)), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(new Response(employee, new InfraDetails(podIp, podNodeIp, podIp, clusterName, nodeName)), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return new ResponseEntity<Object>(new GroupResponse(employees, new InfraDetails(podIp, podNodeIp, podIp, clusterName, nodeName)), HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        if (!employees.stream().filter(e -> e.getEid().equals(employee.getEid())).findAny().isPresent()) {
            return new ResponseEntity<Object>(new ErrorResponse(new Message("Employee with the given id is not present"), new InfraDetails(podIp, podNodeIp, podIp, clusterName, nodeName)), HttpStatus.BAD_REQUEST);
        }
        employees.add(employee);
        return new ResponseEntity<Object>(new GroupResponse(employees, new InfraDetails(podIp, podNodeIp, podIp, clusterName, nodeName)), HttpStatus.OK);
    }

    @PutMapping("/employees/{eid}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long eid) {
        if (!employees.stream().filter(null).findAny().isPresent()) {
            return new ResponseEntity<Object>(new ErrorResponse(new Message("Employee with the given id is not present"), new InfraDetails(podIp, podNodeIp, podIp, clusterName, nodeName)), HttpStatus.BAD_REQUEST);
        }
        employees.removeIf(e -> e.getEid().equals(id));
        return new ResponseEntity<Object>(new GroupResponse(employees, new InfraDetails(podIp, podNodeIp, podIp, clusterName, nodeName)), HttpStatus.OK);
    }

}