package com.uniPay.backend.service;

import com.uniPay.backend.model.MenuItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MenuItemService {

    private final List<MenuItem> dummyMenuItems =new ArrayList<>(Arrays.asList(
            new MenuItem("12", "Pesto Pasta",
                    "Fresh pesto sauce with finely diced cherry tomatoes with mushrooms, baby carrots & rare beef pasta.",
                    "https://littlenonni.com/wp-content/uploads/2024/08/ricotta-pesto-pasta-12-12-1-2.jpg",12.99),
            new MenuItem("123", "Chicken Risotto",
                    "Creamy risotto rice slowly simmered with season of vegetables. Served with glazed chicken and fresh vegetables.",
                    "https://www.eatingonadime.com/wp-content/uploads/2019/12/200KB-Easy-Chicken-Risotto-2-1.jpg",14.99)
    )

    );

    public List<MenuItem> getMenuItems() {
        return dummyMenuItems;
    }

    public MenuItem addMenuItem(MenuItem menuItem) {
        for (MenuItem dummyMenuItem : dummyMenuItems) {
            if (dummyMenuItem.getId().equals(menuItem.getId())) {
                return null;
            }
        }

        this.dummyMenuItems.add(menuItem);
        return menuItem;
    }

    public MenuItem updateMenuItem(MenuItem menuItem,String id) {
        for (MenuItem dummyMenuItem : dummyMenuItems) {
            if (dummyMenuItem.getId().equals(id)) {
                if(menuItem.getName()!=null){
                    dummyMenuItem.setName(menuItem.getName());

                }
                if(menuItem.getDescription()!=null){
                    dummyMenuItem.setDescription(menuItem.getDescription());
                }
                if(menuItem.getPrice()>0){
                    dummyMenuItem.setPrice(menuItem.getPrice());}
                if(menuItem.getImage()!=null){
                    dummyMenuItem.setImage(menuItem.getImage());}
                return dummyMenuItem;
            }
        }
        return null;
    }
}
