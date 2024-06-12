package Model;
import Utility.HibernateUtility;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class OnlineProduct 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pid",length = 20)
	private int productId;
	
	@Column(name = "pname",length = 30)
	private String productName;
	
	@Column(name = "pbrand",length = 30)
	private String productBrand;
	
	@Column(name = "pcatagory",length = 30)
	private String productCatagory;
	
	@Column(name = "pprice",length = 30)
	private int productPrice;
	
	@Column(name = "pquantity",length = 30)
	private int productQuantity;
	
	
	
	public OnlineProduct() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public OnlineProduct(String productName, String productBrand, String productCatagory, int productPrice,
			int productQuantity)
	{
		super();
		this.productName = productName;
		this.productBrand = productBrand;
		this.productCatagory = productCatagory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		
	}

	public int getProductId() 
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getProductName() 
	{
		return productName;
	}

	public void setProductName(String productName) 
	{
		this.productName = productName;
	}

	public String getProductBrand() 
	{
		return productBrand;
	}

	public void setProductBrand(String productBrand) 
	{
		this.productBrand = productBrand;
	}

	public String getProductCatagory() 
	{
		return productCatagory;
	}

	public void setProductCatagory(String productCatagory) 
	{
		this.productCatagory = productCatagory;
	}

	public int getProductPrice() 
	{
		return productPrice;
	}

	public void setProductPrice(int productPrice) 
	{
		this.productPrice = productPrice;
	}

	public int getProductQuantity() 
	{
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) 
	{
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() 
	{
		return "OnlineProduct [productId=" + productId + ", productName=" + productName + ", productBrand="
				+ productBrand + ", productCatagory=" + productCatagory + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + "]";
	}	
	
}
