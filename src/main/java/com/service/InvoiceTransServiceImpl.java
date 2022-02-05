package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.InvoiceTransDAO;
import com.model.InvoiceTrans;

@Service("invoiceTransService")
@Transactional
public class InvoiceTransServiceImpl implements InvoiceTransService{
	
	@Autowired
    private InvoiceTransDAO dao;
	
	@Override
	public InvoiceTrans findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveInvoiceTrans(InvoiceTrans invtrans) {
		dao.saveInvoiceTrans(invtrans);
	}

	@Override
	public void deleteInvoiceTransById(int invtransno) {
		dao.deleteInvoiceTransById(invtransno);
	}

	@Override
	public List<InvoiceTrans> findAllInvoiceTrans() {
		return dao.findAllInvoiceTrans();
	}

}
