package net.jguzmandev.repository;

import net.jguzmandev.model.Address;
import net.jguzmandev.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomer(){

        Address _billingAddress = Address.builder()
                .street("Calle primera")
                .city("Santiago")
                .country("Dominicana")
                .build();

        Address _shippingAddress = Address.builder()
                .street("Calle la envia")
                .city("Azua")
                .country("Dominicana Sur")
                .build();

        Customer customer = Customer.builder()
                .firstName("Jorge")
                .lastName("Guzman")
                .email("jguzman@gmail.com")
                .phone("34534534")
                .shippingAddress(_shippingAddress)
                .billingAddress(_billingAddress)
                .build();

        customerRepository.save(customer);
    }

    @Test
    public void findByFirstName(){
        Customer customer = customerRepository.findByFirstName("Jorge").get();

        System.out.println(customer);;
    }

    @Test
    public void findByShippingAddressCity(){
        customerRepository.findByShippingAddressCity("Distrito nacional").stream()
                .forEach(System.out::println);
    }

    @Test
    public void findByBillingAddressCountry(){
        customerRepository.findByBillingAddressCountry("RD").stream()
                .forEach(System.out::println);
    }

    @Test
    public void findByBillingAddressCity(){
        customerRepository.findByBillingAddressCity("Santo Domingo Oeste").stream()
                .forEach(System.out::println);
    }

}