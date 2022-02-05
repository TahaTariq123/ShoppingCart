package com.dao;

import java.util.List;
import com.model.InvoiceTrans;

public interface InvoiceTransDAO {
	InvoiceTrans findById(int id);
	 
    void saveInvoiceTrans(InvoiceTrans invtrans);
     
    void deleteInvoiceTransById(int invtransno);
     
    List<InvoiceTrans> findAllInvoiceTrans();
 
}
