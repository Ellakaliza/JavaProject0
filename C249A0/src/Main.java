//--------------------------------------------------------
// Assignment 0
// Question: -
// Written by: Ange Marie Ella Akaliza 40270048
//-------------------------------------------------------- 
import java.util.Scanner;

public class Main {
	public static int maxBooks;
	public static Book[] inventory;

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Welcome!");
		System.out.println("How many books are you going to have in your inventory?");
		maxBooks=scan.nextInt();
		inventory=new Book[maxBooks];
		int choice, a1=1;
		do {
			Main.Choice();
			choice=scan.nextInt();
			//as long as the user doesn't choose an available option, the program keeps asking the user to chose again
			while(choice!=1&&choice!=2&&choice!=3&&choice!=4&&choice!=5) {
				Main.Choice();
				choice=scan.nextInt();
			}
			if(choice==1) {
				System.out.print("Please enter your password");
				String password=scan.next();
				int a=1;
				while(!(password.equals("PssWrd249"))) {
					/*if the user enters the wrong password three times,the program goes back to the main menu
					 * and if the user chooses the wrong password 12 times, the program shuts down.
					 */
					if(a%3==0&&a1!=12)
						break;
					else if(a1==12)
						System.exit(1);
					a++;
					a1++;
					System.out.print("Incorrect. Please enter valid password");
					password=scan.next();
				}
				if(!(password.equals("PssWrd249")))
					continue;
				else
				Main.AddBook();
			}
			if(choice==2) {
				System.out.print("Please enter your password");
				String password=scan.next();
				int b=1;
				// with the break and continue, if the user chooses the wrong password 3 times, the main menu comes back.
				while(!(password.equals("PssWrd249"))) {
					if(b%3==0)
						break;
					b++;
					System.out.print("Incorrect. Please enter valid password");
					password=scan.next();
				}
				if(!(password.equals("PssWrd249")))
					continue;
				else {
					System.out.print("Enter the number of the book you would like to change");
					int bookIndex=scan.nextInt();
					// while the user's choice is invalid, the program keeps prompting the user for a valid choice 
					while(inventory[bookIndex]==null) {
						System.out.print("There are no books at this address, choose 1 to enter another choice of book or any other number to go back to the main menu");
						int choice1=scan.nextInt();
						if(choice1==1)
							bookIndex=scan.nextInt();
						else
							break;
					}
					if(inventory[bookIndex]==null)
						continue;
					System.out.println("Book #"+bookIndex);
					System.out.println(inventory[bookIndex]);
					int choice2;
					do{
						Main.BookChange();
						choice2=scan.nextInt();
						while(choice2!=1&&choice2!=2&&choice2!=3&&choice2!=4&&choice2!=5) {
						Main.BookChange();
						choice2=scan.nextInt();
						}
						if(choice2==5)
							break;
						switch(choice2) {
						case 1: System.out.print("What is the new name of the book's author? ");
						String author=scan.next();
						inventory[bookIndex].setauthor(author);
						break;
						case 2:System.out.print("What is the new title for the book? ");
						String title=scan.next();
						inventory[bookIndex].settitle(title);
						break;
						case 3:System.out.print("What is the new ISBN? ");
						long isbn=scan.nextLong();
						inventory[bookIndex].setisbn(isbn);
						break;
						case 4:System.out.print("What is the new price? ");
						double price=scan.nextDouble();
						inventory[bookIndex].setprice(price);
						break;
						}
						System.out.println("Book #"+bookIndex);
						System.out.println(inventory[bookIndex]);
					}
					while(choice2!=5);
				}
				
			}
			if(choice==3) {
				System.out.println("Enter the author's name");
				String author=scan.next();
				for(int j=0; j<maxBooks;j++) {
					if(inventory[j].getauthor().equals(author))
					System.out.print(inventory[j]+" ");
				}
			}
			if(choice==4) {
				System.out.println("Enter the price");
				double price=scan.nextDouble();
				for(int i=0; i<maxBooks;i++) {
					if(inventory[i].getprice()<price)
						System.out.print(inventory[i]+" ");
				}
			}
			if(choice==5) {
				System.out.print("Thank you for using the program!");
				System.exit(0);
			}
		}
		while(choice>-1);
		scan.close();
	}
	public static void Choice() {
		System.out.print("What do you want to do?\r\n"
					+ "1. Enter new books (password required)\r\n"
					+ "2. Change information of a book (password required)\r\n"
					+ "3. Display all books by a specific author\r\n"
					+ "4. Display all books under a certain a price.\r\n"
					+ "5. Quit\r\n"
					+ "Please enter your choice >");
	}
	public static void AddBook() {
		Scanner scan= new Scanner(System.in);
		System.out.print("How many books do you want to enter? ");
		int books=scan.nextInt();
		while((books+Book.findNumberOfCreatedBooks())>maxBooks) {
			System.out.println("That's too many books, you can only add "+(maxBooks-Book.findNumberOfCreatedBooks())+" books.\n"
					+"Choose another number of books to add.");
			books=scan.nextInt();
		}
		for(int i=0;i<=books;i++) {
			System.out.println("Please enter the title of the book,the author, the ISBN and the price, in that order.");
			String title=scan.next();
			String author=scan.next();
			long isbn=scan.nextLong();
			double price=scan.nextDouble();
			inventory[i]=new Book(title, author, isbn,price);
		}
		scan.close();
	}
	public static void BookChange() {
		System.out.print("What information would you like to\r\n"
				+ "change?\r\n"
				+ "1. author\r\n"
				+ "2. title\r\n"
				+ "3. ISBN\r\n"
				+ "4. price\r\n"
				+ "5. Quit\r\n"
				+ "Enter your choice > ");
	}

}
