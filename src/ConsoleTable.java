import java.util.Arrays;
import java.util.List;

public class ConsoleTable {
    public static void PrintTable(String Title, List<String> columns,List<List<String>> data){
        int[] colMax=new int[columns.size()];
        for (List<String> row:data){
            for (int i = 0; i < row.size(); i++) {
                String col = row.get(i);
                colMax[i]=Math.max(colMax[i],col.length());
            }
        }
        for (int i=0;i<columns.size();i++){
            colMax[i]=Math.max(colMax[i],columns.get(i).length());
        }

        String max = "-";
        for (int l:colMax) {
            char[] charArray = new char[l];
            Arrays.fill(charArray, '-');
            max+=new String(charArray)+"---";
        }

        System.out.println(max);
        //Title
        int titleL=max.length()-Title.length();
        char[] charArray = new char[(int)Math.floor(titleL/2)];
        Arrays.fill(charArray, ' ');
        String space=new String(charArray);
        System.out.println(space+Title+space);

        System.out.println(max);

        //columns
        String fncString="|";
        for (int m: colMax) {
            fncString+=" %-"+m+"s |";
        }

        System.out.printf(fncString+"%n",columns.toArray());
        System.out.println(max);
        for (List<String> row: data) {
            System.out.printf(fncString+"%n",row.toArray());
        }
        System.out.println(max);
    }
}
