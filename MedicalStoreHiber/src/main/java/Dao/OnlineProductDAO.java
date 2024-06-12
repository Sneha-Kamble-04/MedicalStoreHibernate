package Dao;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.OnlineProduct;
import Utility.HibernateUtility;
public class OnlineProductDAO 
{
	public void addProduct(OnlineProduct onlineProduct)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			session.save(onlineProduct);
			transaction.commit();
			session.close();
		} 
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		
	}
	
	public void deleteProduct(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			OnlineProduct onlineProduct=session.get(OnlineProduct.class, id);
			session.delete(onlineProduct);
			System.out.println("Product Id "+id+" is deleted");
			transaction.commit();
			session.close();
		} 
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		
	}
	
	public void getProductById(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			OnlineProduct onlineProduct=session.get(OnlineProduct.class, id);
			if(onlineProduct!=null)
			{
				System.out.println(onlineProduct);
				System.out.println("Product Name:"+onlineProduct.getProductName());
				System.out.println("Product Brand:"+onlineProduct.getProductBrand());
				System.out.println("Product Catagoory:"+onlineProduct.getProductCatagory());
				System.out.println("Product Price:"+onlineProduct.getProductPrice());
				System.out.println("Product Quantity:"+onlineProduct.getProductQuantity());
				
				
			}
			else
			{
				System.out.println("Data not found of ID :"+id);
			}
			transaction.commit();
			session.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Error in fectching the data");
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		
	}
	
	public void updateProduct()
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			Scanner sc=new Scanner(System.in);
			transaction=session.beginTransaction();
			System.out.println("Enter product ID:");
			int p_id=sc.nextInt();
			
			OnlineProduct onlineProduct=session.get(OnlineProduct.class, p_id);
			
			if(onlineProduct!=null)
			{
				System.out.println("Enter the column no which you want to update");
				System.out.println("1:Product Name\n2:Product Brand\n3:Product Catagory");
				System.out.println("4:Product Price\n5:Product Quantity");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Enter the product name which you want to change");
					onlineProduct.setProductName(sc.next());
					break;

				case 2:
					System.out.println("Enter the product brand name which you want to change");
					onlineProduct.setProductBrand(sc.next());
					break;

				case 3:
					System.out.println("Enter the product catagory which you want to change");
					onlineProduct.setProductCatagory(sc.next());
					break;

				case 4:
					System.out.println("Enter the product price which you want to change");
					onlineProduct.setProductPrice(sc.nextInt());
					break;

				case 5:
					System.out.println("Enter the product Quantity which you want to change");
					onlineProduct.setProductQuantity(sc.nextInt());
					break;
					
				}
			}
			session.saveOrUpdate(onlineProduct);
			System.out.println(onlineProduct);
			transaction.commit();
			session.close();
		} 
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
	}
	
	
	
}
