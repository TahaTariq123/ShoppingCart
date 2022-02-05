package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoicetrans_dto")
public class InvoiceTrans{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invtransno;
	private int qty;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "item_no")
//	private Item item;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inv_no")
	private Invoice inv;
	
	public int getInvno() {
		return invtransno;
	}
	public void setInvno(int invtransno) {
		this.invtransno = invtransno;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
//	public Item getItem() {
//		return item;
//	}
//	public void setItem(Item item) {
//		this.item = item;
//	}
	public Invoice getInv() {
		return inv;
	}
	public void setInv(Invoice inv) {
		this.inv = inv;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + invtransno;
        result = prime * result + ((inv == null) ? 0 : inv.hashCode());
        return result;
    }
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Item))
            return false;
        InvoiceTrans other = (InvoiceTrans) obj;
        if (invtransno != other.invtransno)
            return false;
        if (inv == null) {
            if (other.inv != null)
                return false;
        } else if (!inv.equals(other.inv))
            return false;
        return true;
    }
//	@Override
//	public String toString() {
//		return "InvoiceTrans [invtransno=" + invtransno + ", qty=" + qty + ", item=" + item + ", inv=" + inv + "]";
//	}
	@Override
	public String toString() {
		return "InvoiceTrans [invtransno=" + invtransno + ", qty=" + qty + ", inv=" + inv + "]";
	}
	
	
}

