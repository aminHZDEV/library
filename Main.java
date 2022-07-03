import db.*;
import java.util.*;
import models.*;


public class Main { 
    public static void main(String args[]) {
      Scanner sc= new Scanner(System.in);  
      ReadSqlFile readSqlFile = new ReadSqlFile();
      Connect.connect(readSqlFile.read());
      while(true){
        System.out.println("\n\nWhat do u want to do ?");
        System.out.println("1- inseart new manager . ");
        System.out.println("2- display all managers . ");
        System.out.println("3- remove a manager . ");
        System.out.println("4- edit fields of a manager . ");  
        int a= sc.nextInt();  
        if (a == 1){
          Manager manager = new Manager();
          sc= new Scanner(System.in);
          System.out.println("inseart manager username : ");
          manager.setUsername(sc.nextLine());
          System.out.println("inseart manager first_name : ");
          manager.setFirstname(sc.nextLine());
          System.out.println("inseart manager last_name : ");
          manager.setLastname(sc.nextLine());
          System.out.println("inseart manager password : ");
          manager.setPassword(sc.nextLine());
          Connect.connect("INSERT INTO managers (firstname,lastname,username,pass) " +"VALUES ('" +manager.getFirstname()+ "','" +manager.getLastname() + "','" + manager.getUsername() + "','"+manager.getPassword()+"');"); 
        }
        else if (a == 2){
          // ResultSet rs = stmt.executeQuery("SELECT * FROM Product;");
          Connect.read("SELECT manager_id, username, firstname, lastname FROM managers;");          
        }
        else if (a == 3){
          sc= new Scanner(System.in);
          System.out.println("Enter Manager id:");
          int id = sc.nextInt();
          Connect.connect("DELETE FROM managers WHERE manager_id=" + id+";");
          System.out.println("Deleted Successfully!!!");
        }
        else if (a == 4){
          sc= new Scanner(System.in);
          Manager manager = new Manager();
          System.out.println("Enter Manager id:");
          int id = sc.nextInt();
          System.out.println("Enter new username:");
          sc= new Scanner(System.in);
          manager.setUsername(sc.nextLine());
          System.out.println("Enter new firstname:");
          manager.setFirstname(sc.nextLine());
          System.out.println("Enter lastname:");
          manager.setLastname(sc.nextLine());
          System.out.println("Enter password:");
          manager.setPassword(sc.nextLine());
          Connect.connect("UPDATE managers SET  username='"+ manager.getUsername() + "',firstname='" + manager.getFirstname() +"', lastname='" + manager.getLastname() +"', pass='"+manager.getPassword()+
          "' WHERE manager_id=" +id );
          System.out.println("Updated Successfully!!!");

        }
        else {
          System.err.println("\n\nwrong number try again !!!\n\n");
        }
      }
      
    }
  }