package com.service;

import java.util.List;

import com.model.Item;

public interface ItemService {
	Item findById(int id);
    
    void saveItem(Item item);
     
    void updateItem(Item item);
     
    void deleteItemByIname(String iname);
 
    List<Item> findAllItems(); 
     
    Item findItemByIname(String iname);
 
    boolean isItemInameUnique(Integer id, String iname);
    
    List<Item> findItemsByShopno(String shopno); 
}
