package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // This automatically generates a constructor for final fields
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Map DTO to Entity
        Employee employee = EmployeeMapper.mapTOEmployee(employeeDto);

        // Save the employee entity
        Employee savedEmployee = employeeRepository.save(employee);

        // Map saved entity back to DTO
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
