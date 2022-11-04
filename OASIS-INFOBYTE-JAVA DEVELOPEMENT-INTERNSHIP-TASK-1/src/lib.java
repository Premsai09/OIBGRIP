import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class lib {
    static Scanner scan=new Scanner(System.in);
    public static boolean check_book_availability(int book_id){
        Scanner x;
        try{
            x=new Scanner(new File("E:\\vit\\internship\\Dig_lib_man_\\src\\lib.csv"));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                if(Integer.parseInt(x.next())==book_id){
                    return true;
                }
                x.nextLine();
            }
        }
        catch(Exception ignored){}
        return false;
    }
    public static void get_all_books_available(){
        System.out.println("BookId              Name                AuthorName          Category            Price               Quantity            ");
        String temp="";
        Scanner x;
        int count=0;
        int spaces;
        try{
            x=new Scanner(new File("src/lib.csv"));
            x.useDelimiter("[,\n]");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            while(x.hasNext()){
                temp=x.next();
                System.out.print(temp.trim());
                spaces=20-temp.length();
                for(int i=0;i<spaces;i++){
                    System.out.print(" ");
                }
                if(count!=5){
                    count++;
                }
                else{
                    System.out.println();
                    count=0;
                }
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

        }
        catch (Exception ignored){}
    }
    public static void run_admin(boolean logged){
        boolean loggedIn=logged;
        Scanner scam=new Scanner(System.in);
        if(!loggedIn){
            System.out.println("Enter the ADMIN CREDENTIALS TO LOGIN!");
            int a_id;
            String pc;
            System.out.println("ADMIN_ID:");
            a_id= scan.nextInt();
            System.out.println("PASSCODE:");
            scan.nextLine();
            pc= scan.nextLine();
            if(admin.check_cred(a_id,pc)){
                loggedIn=true;
            }
        }
        if(loggedIn){
            System.out.flush();
            int a;
            System.out.println("1.Change username and passcode\n2.Add new books\n3.Increase quantity of the book\n4.Log out and Go Back\n5.check_book_availability\n6.get_all_books_available\n7.Exit");
            a=scam.nextInt();
            switch(a){
                case 1:
                    admin.register_admin();
                    System.out.println("What next!!!\n\n");
                    run_admin(loggedIn);
                    break;
                case 2:
                    admin.add_books();
                    System.out.println("Book(/s) added sucessfully!!");
                    System.out.println("What next!!!\n");
                    run_admin(loggedIn);
                    break;
                case 3:
                    System.out.println("Enter book ID: ");
                    int b_id=scan.nextInt();
                    System.out.println("Enter quantity: ");
                    int qua= scam.nextInt();
                    admin.add_books(b_id,qua);
                    run_admin(loggedIn);
                    break;
                case 4:
                    loggedIn=false;
                    run();
                    break;
                case 5:
                    System.out.println("Enter the book_id: ");
                    int temp=scan.nextInt();
                    if(admin.check_book_availability(temp)){
                        System.out.println("Book available!!");
                    }
                    else{
                        System.out.println("Book unavailable!!");
                    }
                    System.out.println("What next!!!\n");
                    run_admin(loggedIn);
                    break;
                case 6:
                    get_all_books_available();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid input!!");
                    break;
            }
        }
        else {
            System.out.println("Go away you scammer!!");
            run();
        }
    }
    public static void run_student(boolean logged){
        Scanner scan=new Scanner(System.in);

        boolean loggedIn=logged;
        if(loggedIn){
            int s_id;String password;
            int s;
            System.out.println("1.To get a book\n2.To return a book\n3.To buy a book\n4.Go back\n5.Exit");
            s=scan.nextInt();
            switch (s){
                case 1:

            }
        }
    }
    public static void run(){
        boolean flag=true;
        Scanner scam = new Scanner(System.in);
        while(true)
        {
            System.out.println("1.ADMIN\n2.STUDENT\n3.EXIT");
            int n=scam.nextInt();
            switch(n)
            {
                case 1:
                    run_admin(false);
                    break;
                case 2:
                    run_student(false);
                    break;
                case 3:
                    System.out.println("Exiting!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid input!!");
            }
        }
    }
    public static void main(String[]args) {
        run();
//        admin.register_admin();
    }
}
