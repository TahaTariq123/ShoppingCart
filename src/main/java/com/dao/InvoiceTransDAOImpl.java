package com.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.model.InvoiceTrans;
@Repository("invoiceTransDAO")
public class InvoiceTransDAOImpl extends AbstractDAO<Integer, InvoiceTrans> implements InvoiceTransDAO{

	@Override
	public InvoiceTrans findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveInvoiceTrans(InvoiceTrans invtrans) {
		persist(invtrans);
	}

	@Override
	public void deleteInvoiceTransById(int invtransno) {
		Criteria criteria =  createEntityCriteria();
        InvoiceTrans invtrans=(InvoiceTrans)criteria.add(Restrictions.eq("invtransno", invtransno)).uniqueResult();
        delete(invtrans);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvoiceTrans> findAllInvoiceTrans() {
		Criteria criteria = createEntityCriteria();
        return (List<InvoiceTrans>) criteria.list();
	}
}
