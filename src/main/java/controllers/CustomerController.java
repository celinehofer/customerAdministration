package controllers;

import entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    AddressService service; /*Der Controller verwendet den Service*/

    @RequestMapping("/showCreate") /*somit weiss er was machen, wenn diese URL kommt. Unter applicationproperties sind der prefix udn suffix drin, so weiss er was er hinten dran fügen muss.*/
    public String showCreate() { return "createAddress";
    }

    @RequestMapping("/saveLoc") /*steht in der action im form, wann diese Funktion aufgerufen werden soll*/
    public String saveAddress(@ModelAttribute("address") Address address, ModelMap modelMap) { /*Mapping zwischen Objekt und Daten -> @ModelAttribut("Location"), objekt wird in location reingespeichert. Mit ModelMap sagt man spring, dass er was/Antwort zurückgeben soll*/
        Address addressSaved = service.saveAddress(address);
        String msg = "Location saved with id: " + addressSaved.getId();
        modelMap.addAttribute("msg", msg);
        return "createAddress";
    }

    @RequestMapping("/deleteAddress")
    public String deleteAddress(@RequestParam("id") int id, ModelMap modelMap) {
        Address address = new Address();
        address.setId(id);
        service.deleteAddress(address);
        List<Address> address = service.getAllAddresses();
        modelMap.addAttribute("address", address);
        return "displayAddress";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Address address = service.getAddressById(id);
        modelMap.addAttribute("address", address);
        return "updateAddress";
    }

    @RequestMapping("/updateAddress")
    public String updateAddress(@ModelAttribute("address") Address address, ModelMap modelMap) {
        service.updateAddress(address);
        List<Address> address = service.getAllAddresses();
        modelMap.addAttribute("address", address);
        return "displayAddress";
    }

    @RequestMapping("/displayAddress")
    public String displaoyAddress(ModelMap modelMap) {
        List<Address> address = service.getAllAddresses();
        modelMap.addAttribute("address", address);
        return "displayAddress";
    }
}
