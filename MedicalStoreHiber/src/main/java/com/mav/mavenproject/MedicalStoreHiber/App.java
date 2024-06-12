package com.mav.mavenproject.MedicalStoreHiber;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Dao.OnlineProductDAO;
import Dao.CutomerDAO;
import Dao.SupplierDAO;

import Model.OnlineProduct;
import Model.Customer;
import Model.Supplier;

import Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
	Scanner sc=new Scanner(System.in);
	
	OnlineProductDAO Odao = new OnlineProductDAO();
	CutomerDAO Cdao = new CutomerDAO();
	SupplierDAO Sdao = new SupplierDAO();
	
    public static void main( String[] args )
    {
    	
    	System.out.println( "Welcom To Medical Store!" );
    	App obj=new App();
    	obj.my_online_shop();
    }
    public void my_online_shop()
    {
    	int answer;
    	do
    	{
	    	int mainchoice;
	    	System.out.println("Select Your Operation: \n1:Product\n2:Customer\n3:Supplier");
	    	mainchoice=sc.nextInt();
    	
	    	switch(mainchoice)
	    	{
		    	case 1:
		    		Product();
		    		break;
		    	
		    	case 2:
		    		Customer();
		    		break;
		    		
		    	case 3:
		    		Supplier();
		    		break;
		    		
		    	default:
		    		System.out.println("Please Select Valid Operation");
	    	
	    	}
	    	System.out.println("Do you want to Perform More Operation!");
	    	answer=sc.next().charAt(0);
    	}while(answer=='y'||answer=='Y');
    	
    }
    
    public void Product()
    {
    	int answer2;
    	do
    	{
    	
	    	int choice;
	    	System.out.println("Select Your operation:\n1:Add Product\n2:Delete Product\n3:get data by ID\n4:Update Product");
	    	choice=sc.nextInt(); 
	    	switch(choice)
	    	{
	    	case 1:
	    		
	    		System.out.println("Enter the product ID");
		    	int productId=sc.nextInt();
		    	
		    	System.out.println("Enter the product name");
		    	String productName=sc.next();
		    	
		    	
		    	System.out.println("Enter product Catagory");
		    	String productCatagory=sc.next();
		    	
		    	
		    	System.out.println("Enter name of brand");
		    	String productBrand=sc.next();
		    	
		    	
		    	System.out.println("Enter price");
		    	int productPrice=sc.nextInt();
		    	
		    	System.out.println("Enter Quantity");
		    	int productQuantity=sc.nextInt();
		    	
		    	OnlineProduct onlineProduct=new OnlineProduct(productName, productBrand, productCatagory, productPrice, productQuantity);
		    	Odao.addProduct(onlineProduct);
		    	break;
		    	
	    	case 2:
	    		System.out.println("Enter the product ID");
		    	int p_id1=sc.nextInt();
		    	Odao.deleteProduct(p_id1);
		    	break;
	    	case 3:
	    		System.out.println("Enter the product ID");
		    	int p_id2=sc.nextInt();
		    	Odao.getProductById(p_id2);
	    		break;
	    	case 4:
	    		Odao.updateProduct();
	    		break;
	    		default:
	    			System.out.println("Invalid choice");
	    			break;
	    	}
	    	System.out.println("Do you want to Perform More Product Operation!");
	    	answer2=sc.next().charAt(0);
    	}while(answer2=='y'||answer2=='Y');
    }
    
    public void Customer()
    {
    	int answer3;
    	do
    	{
	    	int choice;
	    	System.out.println("Select Your operation:\n1:Add Customer\n2:Delete Customer\n3:get Customer data by ID\n4:Update Customer Data");
	    	choice=sc.nextInt();
    	
	    	switch(choice)
	    	{
	    	case 1:
	    		
	    		System.out.println("Enter the Customer ID");
		    	int customerId=sc.nextInt();
		    	
		    	System.out.println("Enter the Customer name");
		    	String customerName=sc.next();
		    	
		    	
		    	System.out.println("Enter Custmer Email");
		    	String custmeremail=sc.next();
		    	
		    	
		    	System.out.println("Enter Custmer Mobile Number");
		    	int customermobile=sc.nextInt();
		    	
		    	
		    	
		    	Customer customer=new Customer(customerId,customerName, custmeremail, customermobile);
		    	Cdao.AddCustomer(customer);
		    	break;
		    	
	    	case 2:
	    		System.out.println("Enter the Customer ID");
		    	int c_id1=sc.nextInt();
		    	Cdao.deleteCustomer(c_id1);
		    	break;
		    	
	    	case 3:
	    		System.out.println("Enter the Customer ID");
		    	int C_id2=sc.nextInt();
		    	Cdao.getCustomerById(C_id2);
	    		break;
	    		
	    	case 4:
	    		Cdao.updateCustomer();
	    		break;
	    		
	    	default:
	    			System.out.println("Invalid choice");
	    			break;
	    	}
	    	System.out.println("Do you want to Perform More Customer Operation!");
	    	answer3=sc.next().charAt(0);
    	}while(answer3=='y'||answer3=='Y');
	    	
    }
    
    
    public void Supplier()
    {
    	
    	int answer4;
    	do
    	{
	    	int choice;
	    	System.out.println("Select Your operation:\n1:Add Supplier\n2:Delete Supplier\n3:get Supplier data by ID\n4:Update Supplier Data");
	    	choice=sc.nextInt();
    	
	    	switch(choice)
	    	{
	    	case 1:
	    		
	    		System.out.println("Enter the Supplier ID");
		    	int supplierId=sc.nextInt();
		    	
		    	System.out.println("Enter the Supplier name");
		    	String supplierrName=sc.next();
		    	
		    	
		    	System.out.println("Enter Supplier Email");
		    	String supplieremail=sc.next();
		    	
		    	
		    	System.out.println("Enter Supplier Mobile Number");
		    	int suppliermobile=sc.nextInt();
		    	
		    	
		    	
		    	Supplier supplier=new Supplier(supplierId, supplierrName, supplieremail, suppliermobile);
		    	Sdao.AddSupplier(supplier);
		    	break;
		    	
	    	case 2:
	    		System.out.println("Enter the Supplier ID");
		    	int S_id1=sc.nextInt();
		    	Sdao.deleteSupplier(S_id1);
		    	break;
		    	
	    	case 3:
	    		System.out.println("Enter the Supplier ID");
		    	int S_id2=sc.nextInt();
		    	Sdao.getSupplierById(S_id2);
	    		break;
	    		
	    	case 4:
	    		Sdao.updateSupplier();
	    		break;
	    		
	    	default:
	    			System.out.println("Invalid choice");
	    			break;
	    	}
	    	System.out.println("Do you want to Perform More Supplier Operation!");
	    	answer4=sc.next().charAt(0);
    	}while(answer4=='y'||answer4=='Y');
    }
}
