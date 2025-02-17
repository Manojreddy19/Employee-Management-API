package service;

import dto.EmployeeDto;
import entity.Employee;
import lombok.AllArgsConstructor;
import mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import repository.EmployeeRespository;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRespository employeeRespository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapTOEmployee(employeeDto);
        Employee savedEmployee=employeeRespository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}