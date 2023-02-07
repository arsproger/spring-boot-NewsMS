package com.arsen.controller;

import com.arsen.entity.NewsMS;
import com.arsen.services.NewsMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NewsMSController {
    private final NewsMSService newMSService;

    @Autowired
    public NewsMSController(NewsMSService newMSService) {
        this.newMSService = newMSService;
    }

    @PostMapping("/")
    public String saveEmployee(@ModelAttribute("news") NewsMS news){
        newMSService.save(news);
        return "redirect:/";
    }

    @GetMapping(value = "/")
    public String getTemplate(Model model) {
        List<NewsMS> newsList = newMSService.getAll();
        model.addAttribute("newsList", newsList);
        return "thymeleafTemplate";
    }

    @GetMapping("/showNewsForm")
    public String showNewEmployeeForm(Model model) {
        NewsMS news = new NewsMS();
        model.addAttribute("news", news);
        return "new_employee";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable long id, Model model) {
        NewsMS news = newMSService.getById(id);
        model.addAttribute("news", news);
        return "update_employee";
    }

    @PostMapping("/saveUpdatedNews/{id}")
    public String saveUpdatedEmployee(@ModelAttribute("employee") NewsMS news, @PathVariable long id) {
        newMSService.update(id, news);
        return "redirect:/";
    }

    @GetMapping("/deleteNews/{id}")
    public String deleteEmployee(@PathVariable long id) {
        newMSService.delete(id);
        return "redirect:/";
    }

















//    @GetMapping("/get/all")
//    public List<NewsMS> getAll() {
//        return newMSService.getAll();
//    }
//
//    @GetMapping("/get/{id}")
//    public NewsMS getById(@PathVariable long id) {
//        return newMSService.getById(id);
//    }
//
//    @PostMapping("/save")
//    public void save(@RequestBody NewsMS newsMS) {
//        newMSService.save(newsMS);
//    }
//
//    @PutMapping("/update")
//    public void update(@RequestBody NewsMS newsMS) {
//        newMSService.update(newsMS);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable long id) {
//        newMSService.delete(id);
//    }


}
