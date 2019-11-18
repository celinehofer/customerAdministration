package controllers;

import entities.Communication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CommunicationService;
import java.util.List;

@Controller
public class CommunicationController {

    @Autowired
    CommunicationService service;

    @RequestMapping("/showCreate")
    public String showCreate() { return "createCommunication";
    }

    @RequestMapping("/saveLoc")
    public String saveCommunication(@ModelAttribute("communication") Communication communication, ModelMap modelMap) {
        Communication communicationSaved = service.saveCommunication(communication);
        String msg = "Communication saved with id: " + communicationSaved.getIdCommunication();
        modelMap.addAttribute("msg", msg);
        return "createCommunication";
    }

    @RequestMapping("/deleteCommunication")
    public String deleteCommunication(@RequestParam("id") int id, ModelMap modelMap) {
        Communication communication = new Communication();
        communication.setIdCommunication(id);
        service.deleteCommunication(communication);
        List<Communication> communications = service.getAllCommunications();
        modelMap.addAttribute("communications", communications);
        return "displayCommunications";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Communication communication = service.getCommunicationById(id);
        modelMap.addAttribute("communication", communication);
        return "updateCommunication";
    }

    @RequestMapping("/updateCommunication")
    public String updateCommunication(@ModelAttribute("communication") Communication communication, ModelMap modelMap) {
        service.updateCommunication(communication);
        List<Communication> communications = service.getAllCommunications();
        modelMap.addAttribute("communications", communications);
        return "displayCommunications";
    }

    @RequestMapping("/displayCommunications")
    public String displayCommunications(ModelMap modelMap) {
        List<Communication> communications = service.getAllCommunications();
        modelMap.addAttribute("communications", communications);
        return "displayCommunications";
    }
}
