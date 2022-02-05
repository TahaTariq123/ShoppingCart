package com.dao;

import java.time.LocalDate;
import java.util.List;

import com.model.Invoice;

public interface InvoiceDAO {
	Invoice findById(int id);
	 
    void saveInvoice(Invoice invoice);
     
    void deleteInvoiceByDate(LocalDate date);
     
    List<Invoice> findAllInvoices();
 
    Invoice findInvoiceByDate(LocalDate date);
    
}
