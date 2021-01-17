package io.swagger.service;

import io.swagger.model.Address;
import io.swagger.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {
  @Autowired
  private IAddressRepository addressRepository;

  @Override
  public Address getAddressById(Integer id) {
    return (Address) addressRepository.findOne(id);
  }

  @Override
  public Address saveAddress(Address address) {
    return (Address) addressRepository.save(address);
  }
}
