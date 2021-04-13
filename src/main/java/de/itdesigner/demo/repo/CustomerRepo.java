package de.itdesigner.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.itdesigner.demo.domain.Customer;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer, Integer>{
    
    List<Customer> findAllCustomerByVornameContaining(String voraname);

}
