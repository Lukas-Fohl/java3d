import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.io.File;

public class obj{
    List<plane> planeList = new ArrayList<plane>();
    public void readFromFile(String objPath){
        //open path --> convet to plane by point
        try{
            File f = new File(objPath);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            }
            myReader.close();
        } catch  (FileNotFoundException e){
            e.printStackTrace();
        }
        return;
    }
}