package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.model.Item;
import com.model.User;
import com.service.FillStock;
import com.service.ItemService;
import com.service.UserService;

@Controller
@RequestMapping("/")
@ComponentScan("com") 
public class AppController {
	private String username;
	private String shop;
	private List<Item> shop1;
	private List<Item> shop2;
	private List<Item> shop3;
	
    @Autowired
    UserService service;
    @Autowired
    ItemService itemService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    FillStock stockService;
    
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homepage() {
    	System.out.println("...................homepage(GET) called................");
        return "homepage";
    }
    @RequestMapping(value = { "/log" }, method = RequestMethod.GET)
    public String login(ModelMap model) {
    	System.out.println("...................login(GET) called................");
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    @RequestMapping(value = { "/log" }, method = RequestMethod.POST)
    public String validateUser(@Valid User user, BindingResult result, ModelMap model) throws Exception{
    	System.out.println("...................validateUser(POST) called................");
    	if (result.hasErrors()) {
            return "login";
        }
        User userDB = service.findUserByUname(user.getUname());
        if(userDB.equals(null)) {
        	return "registration";
        }
        if(!(userDB.getUpass().equals(user.getUpass()))) {
        	return "login";
        }
        username = user.getUname();
        model.addAttribute("success", "User " + username + " logged in successfully");
        initializeShop();
        return "success";
    }
    private void initializeShop() {
    	System.out.println("...................initializeShop() called................");
    	shop1 = itemService.findItemsByShopno("1");
    	shop2 = itemService.findItemsByShopno("2");
    	shop3 = itemService.findItemsByShopno("3");
	}
	@RequestMapping(value = { "/reg" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
		System.out.println("...................newUser(GET) called................");
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }
    @RequestMapping(value = { "/reg" }, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
    	System.out.println("...................saveUser(POST) called................");
    	if (result.hasErrors()) {
            return "registration";
        }
    
        if(!service.isUserUnameUnique(user.getId(), user.getUname())){
            FieldError unameError =new FieldError("user","uname",messageSource.getMessage("non.unique.uname", new String[]{user.getUname()}, Locale.getDefault()));
            result.addError(unameError);
            return "registration";
        }
        
        service.saveUser(user);
        model.addAttribute("success", "User " + user.getUname() + " registered successfully");
        return "regsuccess";
    }
    @RequestMapping(value = { "/shop1" }, method = RequestMethod.GET)
    public String shop1(ModelMap model) {
    	System.out.println("...................shop1(GET) called................");
    	model.addAttribute("items", shop1);
    	shop = "Fruit Shop";
    	model.addAttribute("shopname",shop);
    	model.addAttribute("nextshop", "shop2");
    	return "itemlist";
    }
    @RequestMapping(value = { "/shop2" }, method = RequestMethod.GET)
    public String shop2(ModelMap model) {
    	System.out.println("...................shop2(GET) called................");
    	removeAttributes(model);
    	model.addAttribute("items", shop2);
    	shop = "Vegetable Shop";
    	model.addAttribute("shopname",shop);
    	model.addAttribute("nextshop","shop3");
    	return "itemlist";
    }
    @RequestMapping(value = { "/shop3" }, method = RequestMethod.GET)
    public String shop3(ModelMap model) {
    	System.out.println("...................shop3(GET) called................");
    	removeAttributes(model);
    	model.addAttribute("items",shop3);
    	shop = "Grocery Shop";
    	model.addAttribute("shopname",shop);
    	model.addAttribute("nextshop","invoice");
    	return "itemlist";
    }
    private void removeAttributes(ModelMap model) {
    	System.out.println("...................removeAttributes() called................");
    	model.remove("items");
    	model.remove("shopname");
    	model.remove("nextshop");
    }
    @RequestMapping(value = {"/next-{nextshop}-shop"}, method = RequestMethod.GET)
    public String nextShop(@PathVariable String nextshop) {
    	System.out.println("...................nextShop(GET) called................");
    	if(nextshop.equals("invoice")) {
    		return nextshop;
    	}
    	else {
    		String link = "redirect:/".concat(nextshop);
        	return link;
    	}
    }
    @RequestMapping(value = { "/add-{iname}-item" }, method = RequestMethod.GET)
    public String addItemToShop(@PathVariable String iname) {
    	System.out.println("...................addItemToShop(GET) called................");
    	if(shop.equals("Fruit Shop")) {
    		shop1=increaseQuantity(iname, shop1);
        	return "redirect:/shop1";
    	}
    	else if(shop.equals("Vegetable Shop")) {
    		shop2=increaseQuantity(iname, shop2);
        	return "redirect:/shop2";
    	}
    	else {
    		shop3=increaseQuantity(iname, shop3);
        	return "redirect:/shop3";
    	}
    }
    @RequestMapping(value = { "/invoice" }, method = RequestMethod.GET)
    public String generateInvoice(ModelMap model) {
    	System.out.println("...................generateInvoice(GET) called................");
    	List<Item> items = addItemsToCart();
    	model.remove("items");
    	model.addAttribute("items", items);
    	model.addAttribute("username", username);
    	String totalAmount = calculateTotalAmount(items);
    	model.addAttribute("total", totalAmount);
    	return "displayinvoice";
    }
    private String calculateTotalAmount(List<Item> cart) {
    	System.out.println("...................calculateTotalAmount() called................");
    	double total = 0.0;
    	for(Item item:cart) {
    		double price = item.getPrice();
    		String qty = item.getQty();
    		double multiplier = Double.parseDouble(qty);
    		double amount = price*multiplier;
    		total = total+amount;
    	}
    	return Double.toString(total);
    }
    private List<Item> addItemsToCart() {
    	System.out.println("...................addItemsToCart() called................");
    	List<Item> cart=new ArrayList<Item>();
    	for(Item item:shop1) {
    		try {
    			if(!item.getQty().equals(null)) {cart.add(item);}
    		}catch(Exception e) {}
    	}
    	for(Item item:shop2) {
    		try {
    			if(!item.getQty().equals(null)) {cart.add(item);}
    		}catch(Exception ee) {}
    	}
    	for(Item item:shop3) {
    		try {
    			if(!item.getQty().equals(null)) {cart.add(item);}
    		}catch(Exception eee) {}
    	}
    	return cart;
    }
    private List<Item> increaseQuantity(String iname, List<Item> shop) {
    	System.out.println("...................increaseQuantity() called................");
    	for(Item item: shop) {
    		if(item.getIname().equals(iname)) {
    			int qty;
    			try {
    				qty = Integer.parseInt(item.getQty());
    			}catch(Exception e) {
    				qty=0;
    			}
    			qty = qty+1;
    			String temp = Integer.toString(qty);
    			item.setQty(temp);
    		}
    	}
    	return shop;
    }
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String adminList(ModelMap model) {
    	System.out.println("...................adminList(GET) called................");
    	List<Item> items = itemService.findAllItems();
    	model.addAttribute("items", items);
    	return "allitems";
    }
    @RequestMapping(value = {"/fill"}, method = RequestMethod.GET)
    public String fill() {
    	System.out.println("...................fill(GET) called................");
    	stockService.fillStock();
    	return "redirect:/admin";
    }
    @RequestMapping(value = { "/newitem" }, method = RequestMethod.GET)
    public String addItem(ModelMap model) {
    	System.out.println("...................addItem(GET) called................");
    	Item item = new Item();
        model.addAttribute("item", item);
        model.addAttribute("edit", false);
    	return "additem";
    }
    @RequestMapping(value = { "/newitem" }, method = RequestMethod.POST)
    public String saveItem(@Valid Item item, BindingResult result, ModelMap model) {
    	System.out.println("...................saveItem(POST) called................");
    	if (result.hasErrors()) {
            return "additem";
        }
        
        if(!itemService.isItemInameUnique(item.getId(), item.getIname())){
            FieldError itemnameError =new FieldError("item","iname",messageSource.getMessage("non.unique.itemname", new String[]{item.getIname()}, Locale.getDefault()));
            result.addError(itemnameError);
            return "additem";
        }
        
        itemService.saveItem(item);
        model.addAttribute("success", "Item " + item.getIname() + " added successfully");
        return "itemadded";
    }
    @RequestMapping(value = {"/edit-{iname}-item"}, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String iname, ModelMap model) {
    	System.out.println("...................editEmployee(GET) called................");
    	Item item = itemService.findItemByIname(iname);
    	model.addAttribute("item", item);
    	model.addAttribute("edit", true);
    	return "additem";
    }
    @RequestMapping(value = { "/edit-{iname}-item" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Item item, BindingResult result,
        ModelMap model, @PathVariable String iname) {
    	System.out.println("...................updateEmployee(POST) called................");
    	if (result.hasErrors()) {
    		return "additem";
    	}

    	if(!itemService.isItemInameUnique(item.getId(), item.getIname())){
    		FieldError inameError = new FieldError("item","iname",messageSource.
        		getMessage("non.unique.itemname", new String[]{item.getIname()}, Locale.getDefault()));
    		result.addError(inameError);
    		return "additem";
    	}

    	itemService.updateItem(item);

    	model.addAttribute("success", "Item " + item.getIname()  + " updated successfully");
    	return "itemadded";
    }
    @RequestMapping(value = { "/delete-{iname}-item" }, method = RequestMethod.GET)
    public String deleteItem(@PathVariable String iname) {
    	System.out.println("...................deleteItem(GET) called................");
    	itemService.deleteItemByIname(iname);
    	return "redirect:/admin";
    }
}
