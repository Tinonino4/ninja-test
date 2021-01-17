package io.swagger.repository;

import io.swagger.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface IAddressRepository extends CrudRepository<Address, Integer> {
}
