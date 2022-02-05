package com.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.model.Item;
@Repository("itemDAO")
public class ItemDAOImpl extends AbstractDAO<Integer, Item> implements ItemDAO{

	@Override
	public Item findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveItem(Item item) {
		persist(item);
	}

	@Override
	public void deleteItemByIname(String iname) {
		Criteria criteria =  createEntityCriteria();
        Item item=(Item)criteria.add(Restrictions.eq("iname", iname)).uniqueResult();
        delete(item);
	}

	@Override
	public List<Item> findAllItems() {
		Criteria criteria = createEntityCriteria();
        return (List<Item>) criteria.list();
	}

	@Override
	public Item findItemByIname(String iname) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("iname", iname));
        return (Item) criteria.uniqueResult();
	}
	
	@Override
	public List<Item> findItemsByShopno(String shopno) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("shopno", shopno));
        return (List<Item>) criteria.list();
	}
}
