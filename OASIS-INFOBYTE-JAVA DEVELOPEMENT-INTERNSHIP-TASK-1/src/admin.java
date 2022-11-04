import java.io.*;
import java.util.Scanner;

public class admin extends lib {
    static Scanner scan = new Scanner(System.in);
    private static int admin_ID;
    private static String passcode;
    static String filename="src/lib.csv";

    public static void add_books(int book_id,int quantity){
        Scanner x;
        try{
            x=new Scanner(new File("src/lib.csv"));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                if(Integer.parseInt(x.next())==book_id){
                    System.out.println("in if blck");
                    String b_name=x.next();
                    String Authorname=x.next();
                    String Category=x.next();
                    String price=x.next();
                    int a=Integer.parseInt(x.next())+quantity;
                    try{
                        FileWriter fw=new FileWriter(filename);
                        BufferedWriter bw=new BufferedWriter(fw);
                        PrintWriter pw=new PrintWriter(bw);
                        pw.println(book_id+","+b_name+","+Authorname+","+Category+","+price+","+a);
                        System.out.println("File saved");
                        pw.flush();
                        pw.close();
                    }
                    catch (Exception e){
                        System.out.println("File not saved");
                    }
                }
                x.nextLine();
            }
        }
        catch(Exception ignored){}
    }
    public static int getAdmin_ID() {
        return admin_ID;
    }

    public static void setAdmin_ID(int admin_ID) {
        admin.admin_ID = admin_ID;
    }

    public static String getPasscode() {
        return passcode;
    }

    public static void setPasscode(String passcode) {
        admin.passcode = passcode;
    }

    public static void register_admin(){
        System.out.println("Enter the admin_ID");
        admin_ID= scan.nextInt();
        System.out.println("Set your passcode");
        scan.nextLine();
        passcode=scan.nextLine();
        try{
            FileWriter fr=new FileWriter("E:\\vit\\internship\\Dig_lib_man_\\src\\admin.csv");
            BufferedWriter bw=new BufferedWriter(fr);
            PrintWriter pw=new PrintWriter(bw);
            pw.print(admin_ID+","+passcode);
            pw.flush();
            pw.close();
        }
        catch(Exception e){
            System.out.println("registering not done!");
        }
    }
    public static boolean check_cred(int admin_ID,String passcode){
        Scanner scan;
        try{
            scan=new Scanner(new File("E:\\vit\\internship\\Dig_lib_man_\\src\\admin.csv"));
            scan.useDelimiter("[,\n]");
            while(scan.hasNext()){
                admin.admin_ID=scan.nextInt();
                admin.passcode= scan.next();
                int a_idi=admin.admin_ID;
                String a_pass=admin.passcode;
                if(a_idi==admin_ID && a_pass.equals(passcode)){
                    return true;
                }
            }
        }
        catch(Exception ignored){

        }
        return false;
    }
    public static void add_books() {
        System.out.println("Enter the number of books you want to add: ");
        int number_of_books = scan.nextInt();
        int book_id;
        String b_name;
        String Authorname;
        String Category;
        int quantity;
        int price;
        for (int i = 0; i < number_of_books; i++) {
            System.out.println("Enter the " + (i + 1) + "th book details");
            System.out.println("Book id: ");
            book_id=scan.nextInt();
            System.out.println("Book name:  ");
            scan.nextLine();
            b_name = scan.nextLine();
            System.out.println("Author name:  ");
            Authorname = scan.nextLine();
            System.out.println("Category:  ");
            Category = scan.nextLine();
            System.out.println("Price:  ");
            price = scan.nextInt();
            System.out.println("Quantity: ");
            quantity=scan.nextInt();
            try{
                FileWriter fw=new FileWriter(filename,true);
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw=new PrintWriter(bw);
                pw.println(book_id+","+b_name+","+Authorname+","+Category+","+price+","+quantity);
                System.out.println("File saved");
                pw.flush();
                pw.close();
            }
            catch (Exception e){
                System.out.println("File not saved");
            }
        }
    }
}
