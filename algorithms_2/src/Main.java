import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int noOfProcesses;
    static int noOfMachines;
    static List<int[]> process = new ArrayList<>();
    static List<int[]>costOfMove = new ArrayList<>();
    static ArrayList<List<Integer>> cost = new ArrayList<>();

    public static void main(String[] args) {
        // a flag that shows if the parser has met an empty line or not
        boolean flag = false;
        try {
            BufferedReader file= new BufferedReader(new FileReader ("input.txt"));
            //read the first line. It indicates the number of noOfProcesses
            String line =file.readLine();
            noOfProcesses = Integer.parseInt(line);
            //read the second line. It indicates the number of the different types of machines
            line = file.readLine();
            noOfMachines = Integer.parseInt(line);
            //read the third line which is blank line
            line = file.readLine();
            //create a array list of arrays type int


            //scan the rest of the file until the end
            line = file.readLine();
            while (line!=null) {
                if (line.trim().isEmpty()) {
                    flag = true;
                }
                if (flag == false) {
                    String[] n = line.split("\\s+");
                    try {
                        int[] temp = new int[n.length];
                        for (int i = 0; i < n.length; i++) {
                            temp[i] = Integer.parseInt(n[i]);
                        }
                        process.add(temp);
                    } catch (Exception e) {
                    }
                }
                if (flag) {
                    String[] n = line.split("\\s+");
                    try {
                        int[] temp = new int[n.length];
                        for (int i = 0; i < n.length; i++) {
                            temp[i] = Integer.parseInt(n[i]);
                        }
                        costOfMove.add(temp);
                    } catch (Exception e) {
                    }
                }
                line = file.readLine();
            }
        }catch (Exception e){}


        ArrayList<Integer>temp = new ArrayList<>();
        for (int i=0; i< process.get(0).length; i++){
            temp.add(process.get(0)[i]);
        }
        cost.add(temp);


//        System.out.println(process.get(1)[0] + cost.get(0).get(0) + costOfMove.get(0)[0]);
        for (int i = 1; i< noOfProcesses; i++){
            int min = -1;
            for (int j=0; j< noOfMachines; j++){
                temp.clear();
                for (int k = 0; k < noOfMachines; k++) {
                    int number = process.get(i)[j] + cost.get(i-1).get(k) + costOfMove.get(j)[k];
                    if (min < number){
                        number = process.get(i)[j] + cost.get(i-1).get(k) + costOfMove.get(j)[k];
                    }
                }
                temp.add(min);
            }
            cost.add(temp);
        }


        for (int i=0; i<cost.size(); i++){
            for (int j=0; j<cost.get(i).size(); j++){
                System.out.print(cost.get(i).get(j));
            }
        }
    }
}
