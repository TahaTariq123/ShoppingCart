package com.service;

import java.util.List;

import com.model.InvoiceTrans;

public interface InvoiceTransService {
	InvoiceTrans findById(int id);
    
    void saveInvoiceTrans(InvoiceTrans invtrans);
     
    void deleteInvoiceTransById(int invtransno);
 
    List<InvoiceTrans> findAllInvoiceTrans(); 
   
}
