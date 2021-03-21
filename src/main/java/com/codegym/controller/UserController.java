package com.codegym.controller;

import com.codegym.model.AppUser;
import com.codegym.model.Product;
import com.codegym.repository.AppRoleRepository;
import com.codegym.repository.AppUserRepository;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/signup")
public class UserController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository  appRoleRepository;
    @GetMapping("")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("account/signup");
        modelAndView.addObject("appUser", new AppUser());
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView create(@ModelAttribute AppUser appUser) {
        ModelAndView modelAndView = new ModelAndView("account/signup");
        Optional<com.codegym.demospringboot.model.AppRole> role = appRoleRepository.findById(2l);
        role.ifPresent(appUser::setRole);

        appUserRepository.save(appUser);
        modelAndView.addObject("appUser",appUser);
        modelAndView.addObject("mess", "Đăng kí thành công :" + appUser.getName());
        return modelAndView;
    }

}
