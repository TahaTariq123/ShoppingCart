package com.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "invoice_dto")
public class Invoice{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inv_no;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate inv_date;
	@OneToMany(mappedBy = "inv", fetch = FetchType.LAZY)
	private Set<InvoiceTrans> invtranss;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_no")
	private Customer cust;

	public int getInvno() {
		return inv_no;
	}

	public void setInvno(int inv_no) {
		this.inv_no = inv_no;
	}

	public LocalDate getInv_date() {
		return inv_date;
	}

	public void setInv_date(LocalDate inv_date) {
		this.inv_date = inv_date;
	}

	public Set<InvoiceTrans> getInvtranss() {
		return invtranss;
	}

	public void setInvtranss(Set<InvoiceTrans> invtranss) {
		this.invtranss = invtranss;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + inv_no;
        result = prime * result + ((inv_date == null) ? 0 : inv_date.hashCode());
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
        Invoice other = (Invoice) obj;
        if (inv_no != other.inv_no)
            return false;
        if (inv_date == null) {
            if (other.inv_date != null)
                return false;
        } else if (!inv_date.equals(other.inv_date))
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "Invoice [inv_no=" + inv_no + ", inv_date=" + inv_date + ", invtranss=" + invtranss + ", cust=" + cust
				+ "]";
	}
	
}
