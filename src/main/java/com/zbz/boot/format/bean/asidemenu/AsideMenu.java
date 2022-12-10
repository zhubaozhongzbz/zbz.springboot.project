package com.zbz.boot.format.bean.asidemenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsideMenu
{
    private Integer id;
    private String  icon;
    private  String path;
    private  Integer  fid;
    private  String  name;
    private List<AsideMenu> childen;
}
