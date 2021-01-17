package io.swagger.service;

import io.swagger.model.Address;

public interface IAddressService {
  public Address getAddressById(Integer id);
  public Address saveAddress(Address address);
}
