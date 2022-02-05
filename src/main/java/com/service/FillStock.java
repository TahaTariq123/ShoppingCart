package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Item;
@Service("fillStockService")
@Transactional
public class FillStock {
	@Autowired
	ItemService service;
	
	public void fillStock() {
		System.out.println("...............fillStock() called..........");
		List<Item> items = itemList();
		for(Item item:items) {
			service.saveItem(item);
		}
	}
	
	private List<Item> itemList() {
		List<Item> items = new ArrayList<Item>();
		Item item1 = new Item();
		item1.setIname("Apple");
		item1.setPrice(250.0);
		item1.setUnit("kg");
		item1.setShopno("1");
		Item item2 = new Item();
		item2.setIname("Banana");
		item2.setPrice(60.0);
		item2.setUnit("dozen");
		item2.setShopno("1");
		Item item3 = new Item();
		item3.setIname("Orange");
		item3.setPrice(100.0);
		item3.setUnit("kg");
		item3.setShopno("1");
		Item item4 = new Item();
		item4.setIname("Potato");
		item4.setPrice(40.0);
		item4.setUnit("kg");
		item4.setShopno("2");
		Item item5 = new Item();
		item5.setIname("Tomato");
		item5.setPrice(50.0);
		item5.setUnit("kg");
		item5.setShopno("2");
		Item item6 = new Item();
		item6.setIname("Onion");
		item6.setPrice(30.0);
		item6.setUnit("kg");
		item6.setShopno("2");
		Item item7 = new Item();
		item7.setIname("Oil");
		item7.setPrice(700.0);
		item7.setUnit("l");
		item7.setShopno("3");
		Item item8 = new Item();
		item8.setIname("Rice");
		item8.setPrice(70.0);
		item8.setUnit("kg");
		item8.setShopno("3");
		Item item9 = new Item();
		item9.setIname("Daal");
		item9.setPrice(50.0);
		item9.setUnit("kg");
		item9.setShopno("3");
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		items.add(item9);
		return items;
	}
}
