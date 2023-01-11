import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonReader {
    public static void main(String[] args) {
        OpenFileDialog();
    }
    public static void OpenFileDialog(){
        FileOpener.ShowFileDialog(f -> {
            if(f==null)
                OpenFileDialog();
            else {
                try {
                    printData(f);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || ( f.getName().endsWith(".csv") || f.getName().endsWith(".txt"));
            }

            @Override
            public String getDescription() {
                return null;
            }
        });
    }
    private static void printData(File f) throws IOException {
        InputStream in = new BufferedInputStream(Files.newInputStream(f.toPath()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));


        String l=reader.readLine();
        List<Person> people= new ArrayList<>();
        while(l!=null) {
            if(Person.isPerson(l))
                people.add(new Person(l));
            else
                System.err.println("Line is not a person: \t"+l);
            l = reader.readLine();
        }
        ConsoleTable.PrintTable("PEOPLE",
                Arrays.asList("ID","FIRST NAME","LAST NAME","TITLE","YEAR OF BIRTH"),
                people.stream().map(Person::toList).collect(Collectors.toList())
        );
    }
}
