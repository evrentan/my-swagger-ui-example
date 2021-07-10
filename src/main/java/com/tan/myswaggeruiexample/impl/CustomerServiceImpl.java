package com.tan.myswaggeruiexample.impl;

import com.tan.myswaggeruiexample.dto.Customer;
import com.tan.myswaggeruiexample.dto.CustomerRef;
import com.tan.myswaggeruiexample.entity.CustomerEntity;
import com.tan.myswaggeruiexample.mapper.CustomerMapper;
import com.tan.myswaggeruiexample.repository.CustomerRepository;
import com.tan.myswaggeruiexample.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

  private final CustomerMapper customerMapper;
  private final CustomerRepository customerRepository;

  public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
    this.customerMapper = customerMapper;
    this.customerRepository = customerRepository;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public Customer createCustomer(Customer customer) {
    CustomerEntity customerEntity = this.customerMapper.toEntity(customer);
    customerEntity = this.customerRepository.save(customerEntity);

    return this.customerMapper.toDto(customerEntity);
  }

  @Override
  @Transactional(propagation =  Propagation.REQUIRED)
  public List<CustomerRef> getAllCustomerRefs() {
    return this.customerMapper.toDtoRefList(this.customerRepository.findAll());
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public Customer getCustomerById(String id) {
    Optional<CustomerEntity> customerEntity = this.customerRepository.findById(id);

    return customerEntity.map(this.customerMapper::toDto).orElse(null);
  }
}
