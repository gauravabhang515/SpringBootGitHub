package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")

    public ResponseEntity<Employee> saveData(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getaldata")

    public ResponseEntity<List<Employee>> getAllData() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @DeleteMapping("/deletedatabyid/{empId}")

    public ResponseEntity<String> deleteDataById(@PathVariable int empId) {
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("DEleteeddddddddd");
    }

    @DeleteMapping("/deletealldata")

    public ResponseEntity<String> deleteAllData() {
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("DEleteeddddddddd all data");
    }
    @GetMapping("/sortByName")
    public ResponseEntity <List<Employee>>sorByName(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted((c1,c2)->c1.getEmpName().compareTo(c2.getEmpName())).collect(Collectors.toList()));
    }
    @GetMapping("/sosdgfsrtByName")
    public ResponseEntity <List<Employee>>sdfsfs(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted((c1,c2)->c1.getEmpName().compareTo(c2.getEmpName())).collect(Collectors.toList()));
    }

    @GetMapping("/hi")
    public ResponseEntity <String>hi(){
        return ResponseEntity.ok("hiiiiiiiiiiiiiiiiii");
    }
}
