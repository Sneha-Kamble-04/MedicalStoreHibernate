package Model;
import Utility.HibernateUtility;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sid",length = 20)
	private int supplierId;
	
	@Column(name = "sname",length = 30)
	private String supplierName;
	
	@Column(name = "smail",length = 30)
	private String supplieremail;
	
	
	@Column(name = "smobile",length = 30)
	private int suppliermobile;


	public Supplier() 
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public Supplier(int supplierId, String supplierName, String supplieremail, int suppliermobile) 
	{
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplieremail = supplieremail;
		this.suppliermobile = suppliermobile;
	}


	public int getSupplierId()
	{
		return supplierId;
	}


	public void setSupplierId(int supplierId) 
	{
		this.supplierId = supplierId;
	}


	public String getSupplierName() 
	{
		return supplierName;
	}


	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}


	public String getSupplieremail() 
	{
		return supplieremail;
	}


	public void setSupplieremail(String supplieremail)
	{
		this.supplieremail = supplieremail;
	}


	public int getSuppliermobile()
	{
		return suppliermobile;
	}


	public void setSuppliermobile(int suppliermobile) 
	{
		this.suppliermobile = suppliermobile;
	}


	@Override
	public String toString()
	{
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplieremail="
				+ supplieremail + ", suppliermobile=" + suppliermobile + "]";
	}	

}
