import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        List<Person> people=new ArrayList<Person>();
        do{
            String id=SafeInput.getNonZeroLenString(s,"ID");
            String fn=SafeInput.getNonZeroLenString(s,"First Name");
            String ln=SafeInput.getNonZeroLenString(s,"Last Name");
            String rank=SafeInput.getNonZeroLenString(s,"Title");
            int num=SafeInput.getInt(s,"Year Of Birth");
            people.add(new Person(id,fn,ln,rank,num));

        }while(SafeInput.getYNConfirm(s,"Add More?"));


        File workingDirectory = new File(System.getProperty("user.dir"));
        try {
            FileWriter fw = new FileWriter(workingDirectory.getPath() + "\\src", "PersonGeneratorOutput.csv");
            for (Person p : people) {
                fw.WriteLine(p.toString());
            }
            fw.Close();

        }catch (Exception e){
            System.err.println("An error occured while writing the file");
        }

    }
}
