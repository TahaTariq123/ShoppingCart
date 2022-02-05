package com.dao;

import java.util.List;

import com.model.Item;

public interface ItemDAO {
	Item findById(int id);
	 
    void saveItem(Item item);
     
    void deleteItemByIname(String iname);
     
    List<Item> findAllItems();
 
    Item findItemByIname(String iname);
    
    List<Item> findItemsByShopno(String shopno);
}
