package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.ItemDAO;
import com.model.Item;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@Autowired
    private ItemDAO dao;
	
	@Override
	public Item findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveItem(Item item) {
		dao.saveItem(item);
	}

	@Override
	public void updateItem(Item item) {
		Item entity = dao.findById(item.getId());
		if(entity!=null){
        	entity.setIname(item.getIname());
        	entity.setPrice(item.getPrice());
        	entity.setUnit(item.getUnit());
        	entity.setShopno(item.getShopno());
//        	entity.setInvtrans(item.getInvtrans());
        }
	}

	@Override
	public void deleteItemByIname(String iname) {
		dao.deleteItemByIname(iname);
	}

	@Override
	public List<Item> findAllItems() {
		return dao.findAllItems();
	}

	@Override
	public Item findItemByIname(String iname) {
		return dao.findItemByIname(iname);
	}

	@Override
	public boolean isItemInameUnique(Integer id, String iname) {
		Item item = findItemByIname(iname);
		return ( item == null || ((id != null) && (item.getId() == id))); 
	}
	
	@Override
	public List<Item> findItemsByShopno(String shopno) {
		return dao.findItemsByShopno(shopno);
	}
}
