package com.handson;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;


import java.util.Scanner;

@SuppressWarnings("unused")
public class BookDemo {

	public static void main(String[] args) {


		Book[] Barray = new Book[25];

		Scanner sc = new Scanner(System.in);
		int position=0;
		String choice = "";
		do
		{
			System.out.println("BOOK DETAILS");
			System.out.println("1.Add Book");
			System.out.println("2.Search Book by title");
			System.out.println("3.list all Books");
			System.out.println("4.List all Books by price");
			System.out.println("5.Exit");

			System.out.println("Enetr your choice");

			choice=sc.nextLine();

			switch(choice)
			{

			case "1":System.out.println("Please enter a book title: ");
			String title = sc.nextLine();


			System.out.print("Enter price: ");

			double price=GetDouble();





			System.out.println("Please enter book id: ");

			int id = GetInt();


			//do {
			//  try {
			//		    id = sc.nextInt();
			//} catch (InputMismatchException e){
			//  System.out.println("ID should be number only");
			//sc.next();
			//}
			//} while (id<1);


			Book b = new Book(title,price,id);
			Barray[position] = b;
			position++;
			System.out.println("Book Deatails added succesfully!!");

			try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Book.ser")))
			{

				for(int i = 0;i<position;i++)
				{
					Book bs = Barray[i];
					os.writeObject(bs);
				}
				//os.writeObject(new endoffile());
				// os.close();



				System.out.println("Object written succesfully");

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}




			break;

			case "2": System.out.println("Enter a Book title to search");
			String searchTitle = sc.nextLine();
			boolean found =false;
			for(Book i:Barray)
			{
				if(i != null && i.getTitle().equals(searchTitle))
				{
					found = true;
					i.BookInfo();
					break;
				}
			}
			if(!found)
			{
				System.out.println("Sorry searched details not found");

			}
			break;


			case "3":
				System.out.println("List of all Books");
			//	DeserializeBook.display();

				//ObjectInputStream is = new ObjectInputStream(new FileInputStream("Book.ser"));
				//Object is1=null;
				//while((is1=is.readObject()) instanceof endoffile==false)
				// {
				// System.out.println(((Book)is1).title+": "+((Book)is1).price+": "+((Book)is1).id);
				// }
				// is.close();


				//for(int i = 0;i<position;i++)

				//{
				//Book d = Barray[i];
				//d.BookInfo();
				//}

				break;

			case "4":System.out.println("please enter price to search Book List!");
			double searchPrice = GetDouble1();
			sc.nextLine();
			for(int i =0;i<position;i++)
			{
				Book c = Barray[i];
				if(c.getPrice()>= searchPrice)
				{
					c.BookInfo();

				}

			}
			break;
			case "5":


				System.out.println("!Bye exiting Application!!");
				break;


			default: System.out.println("Invalid choice!!");
			break;
			}

		}while(!choice.equals("5"));
		try{
			FileInputStream fis = new FileInputStream("Book.ser");
			ObjectInputStream os= new ObjectInputStream(fis);
			Book bs = (Book) os.readObject();
			//os.readObject().toString();
			//Book b2 =(Book)os.readObject().toString();
			/*for(Book bs : b1)
			 * {
			 * }*/
			os.close();
			fis.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
					
					
		}
		for(Book bs : Barray){
			System.out.println(bs);
		}
		sc.close();
	}

	@SuppressWarnings("resource")
	private static double GetDouble1() {
		Scanner sc3 = new Scanner(System.in);
		while(true)
		{
			try
			{
				return sc3.nextDouble();
			}
			catch (InputMismatchException e) {
				sc3.next();
				System.out.println("That's not"+ "an double. Try agian");
			}

		}


	}

	@SuppressWarnings("resource")
	private static int GetInt() {
		Scanner sc2 = new Scanner(System.in);
		while(true)
		{
			try
			{
				return sc2.nextInt();
			}
			catch (InputMismatchException e) {
				sc2.next();
				System.out.println("That's not"+ "an Integer. Try agian");
			}

		}

	}

	@SuppressWarnings("resource")
	private static double GetDouble() {
		Scanner sc1 = new Scanner(System.in);
		while(true)
		{
			try
			{
				return sc1.nextDouble();
			}
			catch (InputMismatchException e) {
				sc1.next();
				System.out.println("That's not"+ "an double. Try agian");
			}

		}

	}
}
