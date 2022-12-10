package com.zbz.boot.service;

import com.zbz.boot.bean.asidemenu.AsideMenu;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AsideMenuService {

    List<AsideMenu> getAll();
}
