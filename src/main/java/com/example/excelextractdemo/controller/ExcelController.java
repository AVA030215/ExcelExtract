package com.example.excelextractdemo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.example.excelextractdemo.model.Employee;
import com.example.excelextractdemo.service.ExcelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ExcelController {
    @Autowired
    ExcelService excelService;

    @GetMapping("/excel")
    public ResponseEntity<byte[]> downloadExcel() throws IOException {

        List<Employee> employees = Arrays.asList(
                new Employee("Ava Lee", "chaechae0215@gmail.com", "HR"),
                new Employee("Chaeeun Lee", "bluemoon3_00@naver.com", "IT"),
                new Employee("John Doe", "john.doe@example.com", "HR"),
                new Employee("Jane Smith", "jane.smith@example.com", "IT"),
                new Employee("Selena Lee", "selena.lee@example.com", "Finance"));

        byte[] excelBytes = excelService.generateExcel(employees);

        return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=employee.xlsx").body(excelBytes);
    }
}
