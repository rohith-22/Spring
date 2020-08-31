package com.crudapp.controllers;

import com.crudapp.domain.Car;
import com.crudapp.services.ICarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping("/car")
@Controller
public class CarsController {

    private ICarsService ICarsService;

    @Autowired
    public void setCarsService(ICarsService ICarsService) {
        this.ICarsService = ICarsService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String listCars(Model model){
        model.addAttribute("cars", ICarsService.listAllCars());
        return "cars";

    }
    @RequestMapping("/{id}")
    public String  getCar(@PathVariable Integer id, Model model){
        model.addAttribute("car", ICarsService.getCarById(id));
        return "car";
    }
    @RequestMapping("/new")
    public String newCar(Model model){
        model.addAttribute("car",new Car());
        return "newcarform";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String UpdateCarsList(Car newCar){
        Car savedCar = ICarsService.updateCarsList(newCar);
        return "redirect:/car/" + savedCar.getId();
    }
    @RequestMapping("/edit/{id}")
    public String editCarList(@PathVariable Integer id,Model model){
        model.addAttribute("car", ICarsService.getCarById(id));
        return "newcarform";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        ICarsService.deleteCar(id);
        return "redirect:/car";
    }
}
