package com.staff.details.controller;

import com.staff.details.model.StaffsDetails;
import com.staff.details.repo.StaffRepo;
import com.staff.details.staffservice.staffphase.Staffservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class StaffController {

    @Autowired
    StaffRepo staffRepo;

    @Autowired
    Staffservice staffservice;

//    @GetMapping("/")
//    public  String showPage(Model model, @RequestParam(defaultValue = "0") int page){
//        model.addAttribute("data",staffRepo.findAll(new PageRequest(page,4)));
//        return "index";
//    }



    @RequestMapping(value = "/staff",method = RequestMethod.GET)
    public  String showForm(Model model, StaffsDetails staffs){
        model.addAttribute("staffs",staffs);
        return "staffsForm";
    }



    @RequestMapping(value="/successfulForm/{staffId}")
    public ModelAndView showSuccessfulForm(@PathVariable Long staffId){
        StaffsDetails staff=  staffservice.getStaffById(staffId);
        return new ModelAndView("successfulForm","staff",staff);
    }




    @RequestMapping(value = "/staff" ,method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView saveStaffs(@Valid StaffsDetails staffs, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("has error");
            return new ModelAndView( "staffsForm");
        }

        StaffsDetails staff = staffservice.addAStaff(staffs);



        return new ModelAndView("redirect:/successfulForm/"+staff.getId(),"staff",staff);

    }



    @RequestMapping(value = "/updatestaff",method = RequestMethod.POST)
    public ModelAndView updateStaff(@ModelAttribute("staffs") StaffsDetails staffs){
        staffservice.staffUpdate(staffs);
        return new ModelAndView("redirect:/viewstaffsForm");
    }

    @RequestMapping(value = "viewstaffsForm")
    public ModelAndView getAllStaffs(){
        List<StaffsDetails> staffs=staffservice.getAllStaffs();
        return new ModelAndView("viewstaffsForm","staffs",staffs);
    }



    @RequestMapping(value = "/deletestaff/{id}",method = RequestMethod.GET)
    public ModelAndView deleteStaff(@PathVariable Long id){
        StaffsDetails staffs = staffservice.getStaffById(id);
        staffservice.deleteStaff(id);
        return new ModelAndView("redirect:/viewstaffsForm");
    }


    @RequestMapping(value="/staffdetails/{staffId}")
    public ModelAndView showStaffDetails(@PathVariable Long staffId){
        StaffsDetails details=  staffservice.getStaffById(staffId);
        return new ModelAndView("staffdetails","details",details);
    }


    @RequestMapping(value = "/editStaff/{id}")
    public String editStaff(@PathVariable Long id, StaffsDetails staffs, Model model){
        staffs=staffservice.getStaffById(id);
        model.addAttribute("staffs",staffs);
        return "editStaff";
    }


}
