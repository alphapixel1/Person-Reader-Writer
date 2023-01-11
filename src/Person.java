import java.util.Arrays;
import java.util.List;

public class Person{
    int yearOfBirth;
    String title,fName,lName,id;
    public Person(String id,String fName, String lName, String title, int number) {
        this.id=id;
        this.fName = fName;
        this.lName = lName;
        this.title  = title;
        this.yearOfBirth = number;
    }
    public Person(String line){
        String[] s=line.split(",");
        id=s[0];
        fName=s[1];
        lName=s[2];
        title=s[3];
        yearOfBirth=Integer.parseInt(s[4].replace(" ",""));
    }
    public static boolean isPerson(String line){
        String[] s=line.split(",");
        if(s.length==5){
            try{
                Integer.parseInt(s[4].replace(" ",""));
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }
    public List<String> toList(){
        return Arrays.asList(id,fName,lName,title,yearOfBirth+"");
    }
    @Override
    public String toString() {
        return String.join(",",id,fName,lName,title,yearOfBirth+"");
    }
}