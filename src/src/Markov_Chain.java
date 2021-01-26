import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Markov_Chain {
    private String filename;
    private Scanner s;
    private Dictionary d;
    private File f;
    private String allWords;
public Markov_Chain(){
    s = new Scanner(System.in);
    System.out.println("enter file name:");
    d = new Hashtable();
    filename = s.nextLine();
    f = new File(filename);
    allWords ="";
}
public boolean fileRead(){
    boolean sucess;
    try {
        Scanner reader = new Scanner(f);
        while (reader.hasNextLine()){
            allWords+= reader.nextLine();
        }
        sucess = true;
    }catch (FileNotFoundException e){
        System.out.println("a fille error occured");
        e.printStackTrace();
        sucess = false;
    }
    return sucess;
}

}
