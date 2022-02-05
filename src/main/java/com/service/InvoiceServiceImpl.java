package com.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.InvoiceDAO;
import com.model.Invoice;

@Service("invoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
    private InvoiceDAO dao;
	
	@Override
	public Invoice findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveInvoice(Invoice invoice) {
		dao.saveInvoice(invoice);
	}

	@Override
	public void deleteInvoiceByDate(LocalDate date) {
		dao.deleteInvoiceByDate(date);
	}

	@Override
	public List<Invoice> findAllInvoices() {
		return dao.findAllInvoices();
	}

	@Override
	public Invoice findInvoiceByDate(LocalDate date) {
		return dao.findInvoiceByDate(date);
	}

}
