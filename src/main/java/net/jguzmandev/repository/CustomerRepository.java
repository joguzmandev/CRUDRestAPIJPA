package net.jguzmandev.repository;

import net.jguzmandev.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // ============ QUERY METHOD ============
    Optional<Customer> findByFirstName(String firstName);
    List<Customer> findByShippingAddressCity(String city);
    List<Customer> findByBillingAddressCountry(String country);

    // ============ QUERY JPQL ============
    @Query("SELECT c FROM Customer c WHERE c.billingAddress.city = :city")
    List<Customer> findByBillingAddressCity(String city);

    @Query("SELECT c.firstName FROM Customer c WHERE c.email = ?1")
    String getFirstNameByEmail(String emal);

    // ============ NATIVE QUERY - SQL ============
    @Query(value = "SELECT * FROM tbl_customers WHERE customer_id = :customer_id", nativeQuery = true)
    Customer getCustomerById(@Param("customer_id") Long customer_id);

    /*
    La anotacion Query solo es para consulta tipo select,
    sin embargo cuando realizamos update o delete mediante la anotacion query,
    debemos indicarle a spring que no vamos a obtener un resultado de la consulta
    sino que vamos actualizar o eliminar un registro en la db y esto se lo indicamos con la
    anotacion @Modifying,
    adicional a eso se necesita que haya una transaccion de por medio
    ya que spring para realizar operacion de modificacion (update o delete)
    requiere una transaccion por defecto.
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE tbl_customers SET first_name = :firstName WHERE customer_id = :customerId", nativeQuery = true)
    void updateCustomerFirstNameById(
            @Param("firstName") String firstName,
            @Param("customerId") Long customerId);
}
