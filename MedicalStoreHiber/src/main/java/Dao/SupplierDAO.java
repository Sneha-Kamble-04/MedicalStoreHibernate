package Dao;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Model.Supplier;
import Utility.HibernateUtility;
public class SupplierDAO 
{
	public void AddSupplier(Supplier supplier)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			session.save(supplier);
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
	
	public void deleteSupplier(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			Supplier supplier=session.get(Supplier.class, id);
			session.delete(supplier);
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
	
	public void getSupplierById(int id)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			Supplier supplier=session.get(Supplier.class, id);
			if(supplier!=null)
			{
				System.out.println(supplier);
				System.out.println("Supplier Name:"+supplier.getSupplierName());
				System.out.println("Supplier Email:"+supplier.getSupplieremail());
				System.out.println("Supplier Mobile Number:"+supplier.getSuppliermobile());
				
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
	
	public void updateSupplier()
	{
		Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			Scanner sc=new Scanner(System.in);
			transaction=session.beginTransaction();
			System.out.println("Enter Customer ID:");
			int s_id=sc.nextInt();
			
			Supplier supplier=session.get(Supplier.class, s_id);
			
			if(supplier!=null)
			{
				System.out.println("Enter the column no which you want to update");
				System.out.println("1:Supplier Name\n2:Supplier Email\n3:Supplier Mobile Number");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Enter the Supplier New name which you want to change");
					supplier.setSupplierName(sc.next());
					break;

				case 2:
					System.out.println("Enter the Supplier New Email which you want to change");
					supplier.setSupplieremail(sc.next());
					break;

				case 3:
					System.out.println("Enter the Supplier New Mobile Number which you want to change");
					supplier.setSuppliermobile(sc.nextInt());
					break;

					
				}
			}
			session.saveOrUpdate(supplier);
			System.out.println(supplier);
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
