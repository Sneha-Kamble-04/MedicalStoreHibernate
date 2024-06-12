package Model;
import Utility.HibernateUtility;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cid",length = 20)
	private int customerId;
	
	@Column(name = "cname",length = 30)
	private String customerName;
	
	@Column(name = "cmail",length = 30)
	private String custmeremail;
	
	
	@Column(name = "cmobile",length = 30)
	private int customermobile;


	public Customer() 
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int customerId, String customerName, String custmeremail, int customermobile)
	{
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.custmeremail = custmeremail;
		this.customermobile = customermobile;
	}


	public int getCustomerId() 
	{
		return customerId;
	}


	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}


	public String getCustomerName() 
	{
		return customerName;
	}


	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}


	public String getCustmeremail() 
	{
		return custmeremail;
	}


	public void setCustmeremail(String custmeremail)
	{
		this.custmeremail = custmeremail;
	}


	public int getCustomermobile() 
	{
		return customermobile;
	}


	public void setCustomermobile(int customermobile) 
	{
		this.customermobile = customermobile;
	}


	@Override
	public String toString() 
	{
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", custmeremail="
				+ custmeremail + ", customermobile=" + customermobile + "]";
	}
	
	
	
	
	
	

}
