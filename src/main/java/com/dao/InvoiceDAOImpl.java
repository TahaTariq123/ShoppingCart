package com.dao;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.model.Invoice;
@Repository("invoiceDAO")
public class InvoiceDAOImpl extends AbstractDAO<Integer, Invoice> implements InvoiceDAO{

	@Override
	public Invoice findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveInvoice(Invoice item) {
		persist(item);
	}

	@Override
	public void deleteInvoiceByDate(LocalDate date) {
		Criteria criteria =  createEntityCriteria();
        Invoice item=(Invoice)criteria.add(Restrictions.eq("date", date)).uniqueResult();
        delete(item);
	}

	@Override
	public List<Invoice> findAllInvoices() {
		Criteria criteria = createEntityCriteria();
        return (List<Invoice>) criteria.list();
	}

	@Override
	public Invoice findInvoiceByDate(LocalDate date) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("date", date));
        return (Invoice) criteria.uniqueResult();
	}
	
}
