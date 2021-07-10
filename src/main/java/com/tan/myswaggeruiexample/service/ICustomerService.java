package com.tan.myswaggeruiexample.service;

import com.tan.myswaggeruiexample.dto.Customer;
import com.tan.myswaggeruiexample.dto.CustomerRef;

import java.util.List;

public interface ICustomerService {

  /**
   * create a customer instance in the database
   *
   * @param customer customer to be created
   * @return Customer
   */
  Customer createCustomer(Customer customer);

  /**
   * return all customer ref instances in the database
   *
   * @return List<CustomerRef>
   */
  List<CustomerRef> getAllCustomerRefs();

  /**
   * return a customer instance by using its id in the database
   *
   * @param id customer id to be filtered
   * @return Customer
   */
  Customer getCustomerById(String id);
}
