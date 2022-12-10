package com.zbz.boot.service.serviceImp;

import com.zbz.boot.bean.asidemenu.AsideMenu;
import com.zbz.boot.mapper.AsideMenuMapper;
import com.zbz.boot.service.AsideMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AsideMenuServiceImp implements AsideMenuService {
    @Autowired
    AsideMenuMapper asideMenuMapper;

    @Override
    public List<AsideMenu> getAll() {
        List<AsideMenu>  asidList=new ArrayList<>();
        List<AsideMenu> list= asideMenuMapper.getAll();
        Map<Integer, List<AsideMenu>> regionMap = list.stream().
                collect(Collectors.groupingBy(s->s.getFid(), Collectors.toList()));

        regionMap.forEach((a,b)->{
            if(a==0)
                asidList.addAll(b);
            b.forEach(as->{as.setChilden(regionMap.get(as.getId())) ;
            });

        });


        return asidList;
    }
}
