package db;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadSqlFile {
     //Creating a reader object
     public ReadSqlFile(){}
     Path currentRelativePath = Paths.get("");
     String s = currentRelativePath.toAbsolutePath().toString();
     public String read(){
        try{
            FileReader fr = new FileReader(s+"/mydb.sql") ;
            BufferedReader br = new BufferedReader(fr) ;
            //Running the script
            String myScript_0 = "";
            String myScript_1 = "";
            while (true) {
                myScript_0 = br.readLine();
                if (myScript_0 == null){
                    break;
                }
                myScript_1 += myScript_0;
            }
            return myScript_1;
        }catch(Exception e){
            System.out.println(e);
        }
        return ""; 
     } 
    
}
