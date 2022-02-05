package com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "item_dto")
public class Item{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String iname;
	@NotEmpty
	private String unit;
	@NotNull
    @Digits(integer=4, fraction=2)
	private double price;
	@NotEmpty
	private String shopno;
	private String qty;
//	@OneToMany(mappedBy = "item",fetch = FetchType.LAZY)
//	private Set<InvoiceTrans> invtrans;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
//	public Set<InvoiceTrans> getInvtrans() {
//		return invtrans;
//	}
//	public void setInvtrans(Set<InvoiceTrans> invtrans) {
//		this.invtrans = invtrans;
//	}  
	public String getShopno() {
		return shopno;
	}
	public void setShopno(String shopno) {
		this.shopno = shopno;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((iname == null) ? 0 : iname.hashCode());
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
        Item other = (Item) obj;
        if (id != other.id)
            return false;
        if (iname == null) {
            if (other.iname != null)
                return false;
        } else if (!iname.equals(other.iname))
            return false;
        return true;
    }
//	@Override
//	public String toString() {
//		return "Item [id=" + id + ", iname=" + iname + ", unit=" + unit + ", price=" + price + ", shopno=" + shopno
//				+ "]";
//	}
//	@Override
//	public String toString() {
//		return "Item [id=" + id + ", iname=" + iname + ", unit=" + unit + ", price=" + price + ", shopno=" + shopno
//				+ ", qty=" + qty + ", invtrans=" + invtrans + "]";
//	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", iname=" + iname + ", unit=" + unit + ", price=" + price + ", shopno=" + shopno
				+ ", qty=" + qty + "]";
	}
	
	
	
}
