package com.example.demoSecirity.controller;

import com.example.demoSecirity.dao.SellerRepository;
import com.example.demoSecirity.entity.Seller;
import com.example.demoSecirity.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DemoController {
    private final SellerService sellerService;

    public DemoController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/")
    public String getHome(){
        return "Home";
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Seller> theEmployees = sellerService.findAll();
        // add to the spring model
        theModel.addAttribute("sellers", theEmployees);

        return "listsellers";
    }

    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    @GetMapping("/employee")
    public String showEmployee(){
        return "employee";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
       return "access-denied";
    }

    @GetMapping("/buyer")
    public String showFormUpdate(){
        return "buyer-home";
    }

    @GetMapping("/seller")
    public String showSeller(){
        return "seller-home";
    }
    @GetMapping("/viewDetails3")
    public String viewDetails3(){
        System.out.println("View details3");
        return "viewDetails3";
    }
    @GetMapping("/viewDetails1")
    public String viewDetails1(){
        return "viewDetails1";
    }

    @GetMapping("/viewDetails2")
    public String viewDetails2(){
        return "viewDetails2";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("seller") Seller seller){
        sellerService.save(seller);
        return "redirect:/list";
    }

    @GetMapping("/showFormForSave")
    public String showFormForSave(Model theModel){
        Seller newSeller= new Seller();
        theModel.addAttribute("seller",newSeller);
        return "showFormForSave";
    }

    @GetMapping("/delete")
    public String showFormDelete(@RequestParam("sellerId") int theId){
        sellerService.deleteById(theId);
        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormUpdate(@RequestParam("sellerId") int theId, Model theModel){
        Seller theSeller = sellerService.findById(theId);
        theModel.addAttribute("seller",theSeller);
        return "showFormForSave";
    }

    @GetMapping("/sell")
    public String sell(@RequestParam("sellerId") int theId){
       Seller seller= sellerService.findById(theId);
        seller.setStatus("SOLD");
        sellerService.save(seller);
        return "redirect:/list";
    }

    @GetMapping("/uploadDocuments")
    public String uploadDocuments(){
        return "uploadDocuments";
    }

    @GetMapping("/uploadDocuments2")
    public String uploadDocuments2(){
        return "uploadDocuments2";
    }

    @GetMapping("/aprovemedia")
    public String aprovemedia(@RequestParam("sellerId") int theId){
        Seller seller= sellerService.findById(theId);
        seller.setMediastatus("Approved");
        sellerService.save(seller);
        return "redirect:/list";
    }
}
