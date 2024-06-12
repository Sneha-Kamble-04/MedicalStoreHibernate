package Dao;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Model.Customer;
import Model.OnlineProduct;
import Utility.HibernateUtility;

public class CutomerDAO
{
	public void AddCustomer(Customer customer)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			session.save(customer);
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
	
	public void deleteCustomer(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			Customer customer=session.get(Customer.class, id);
			session.delete(customer);
			System.out.println("Customer Id "+id+" is deleted");
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
	
	public void getCustomerById(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			Customer customer=session.get(Customer.class, id);
			if(customer!=null)
			{
				System.out.println(customer);
				System.out.println("Customer Name:"+customer.getCustomerName());
				System.out.println("Customer Email:"+customer.getCustmeremail());
				System.out.println("Customer Mobile Number:"+customer.getCustomermobile());
				
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
	
	public void updateCustomer()
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			Scanner sc=new Scanner(System.in);
			transaction=session.beginTransaction();
			System.out.println("Enter Customer ID:");
			int c_id=sc.nextInt();
			
			Customer customer=session.get(Customer.class, c_id);
			
			if(customer!=null)
			{
				System.out.println("Enter the column no which you want to update");
				System.out.println("1:Customer Name\n2:Customer Email\n3:Customer Mobile Number");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Enter the Customer New name which you want to change");
					customer.setCustomerName(sc.next());
					break;

				case 2:
					System.out.println("Enter the Customer New Email which you want to change");
					customer.setCustmeremail(sc.next());
					break;

				case 3:
					System.out.println("Enter the Customer New Mobile Number which you want to change");
					customer.setCustomermobile(sc.nextInt());
					break;

					
				}
			}
			session.saveOrUpdate(customer);
			System.out.println(customer);
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
