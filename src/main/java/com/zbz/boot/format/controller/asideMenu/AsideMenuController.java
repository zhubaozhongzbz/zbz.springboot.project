package com.zbz.boot.format.controller.asideMenu;
import com.zbz.boot.format.bean.asidemenu.AsideMenu;
import com.zbz.boot.format.service.AsideMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AsideMenuController {
    @Autowired
    AsideMenuService asideMenuService;
    @GetMapping("getAllMenu")
    public List<AsideMenu> getAll(){
        return asideMenuService.getAll();

    }
}
