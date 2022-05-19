package com.spring.springcourselearningpetclinic.controllers;

import com.spring.springcourselearningpetclinic.model.Owner;
import com.spring.springcourselearningpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping({"/find"})
    public String findOwnersForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping("")
    public String findOwners(Owner owner, Model model, BindingResult bindingResult) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }
        List<Owner> ownersFound = ownerService.findAllByLastNameLike(owner.getLastName());
        if (ownersFound.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return "/owners/findOwners";
        } else if (ownersFound.size() == 1) {
            owner = ownersFound.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", ownersFound);
            return "/owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(this.ownerService.findById(ownerId));
        return modelAndView;
    }
}
