package controllers;

import entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CustomerService;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService service;

    @RequestMapping("/showCreate")
    public String showCreate() { return "createCustomer";
    }

    @RequestMapping("/saveLoc")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, ModelMap modelMap) {
        Customer customerSaved = service.saveCustomer(customer);
        String msg = "Customer saved with id: " + customerSaved.getIdCustomer();
        modelMap.addAttribute("msg", msg);
        return "createCustomer";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") int id, ModelMap modelMap) {
        Customer customer = new Customer();
        customer.setIdCustomer(id);
        service.deleteCustomer(customer);
        List<Customer> customers = service.getAllCustomers();
        modelMap.addAttribute("customers", customers);
        return "displayCustomers";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Customer customer = service.getCustomerById(id);
        modelMap.addAttribute("customer", customer);
        return "updateCustomer";
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer, ModelMap modelMap) {
        service.updateCustomer(customer);
        List<Customer> customers = service.getAllCustomers();
        modelMap.addAttribute("customers", customers);
        return "displayCustomers";
    }

    @RequestMapping("/displayCustomers")
    public String displayCustomers(ModelMap modelMap) {
        List<Customer> customers = service.getAllCustomers();
        modelMap.addAttribute("customers", customers);
        return "displayCustomers";
    }

}
