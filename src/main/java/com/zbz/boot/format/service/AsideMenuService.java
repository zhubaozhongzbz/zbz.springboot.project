package com.zbz.boot.format.service;

import com.zbz.boot.format.bean.asidemenu.AsideMenu;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AsideMenuService {

    List<AsideMenu> getAll();
}
