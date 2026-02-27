package net.jguzmandev.repository;

import net.jguzmandev.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String firstName);

    List<Customer> findByShippingAddressCity(String city);
    List<Customer> findByBillingAddressCountry(String country);

    @Query("SELECT c FROM Customer c WHERE c.billingAddress.city = :city")
    List<Customer> findByBillingAddressCity(String city);

}
