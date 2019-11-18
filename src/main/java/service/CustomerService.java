package service;
import entities.Customer;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
}
