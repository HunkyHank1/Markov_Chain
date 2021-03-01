import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MarkovChain {
    private String filename;
    private Scanner s;
    private Dictionary d;
    private File f;
    private String allWords;
    private Random r;
    private String sentenceOut;
    public MarkovChain(){
        s = new Scanner(System.in);
        System.out.println("enter file name:");
        d = new Hashtable();
        filename = s.nextLine();
        f = new File(filename);
        allWords ="";
        r = new Random();
    }
    public boolean fileRead(){
        boolean sucess;
        try {
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()){
                allWords+=" ";
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
    public void makeHashtable(){
        String prefix = "";
        String suffix = "";
        for(int i = 0;i<allWords.length();i++){
            if(allWords.charAt(i)==' '){
                System.out.println("Key: "+prefix);
                System.out.println("Definition: "+suffix);
                this.d.put(prefix, suffix);
                System.out.println("Printing definition of key: "+d.get(prefix));
                prefix=suffix;
            suffix = "";}
            else if(allWords.charAt(i)=='.'||allWords.charAt(i)=='!'||allWords.charAt(i)=='?'){
                //prefix = "";
                //suffix = "";
                System.out.println(i);
            }
            else{
                suffix+= allWords.charAt(i);
                System.out.println(suffix);
            }
        }
    }
    public String getRandomWord(){
        int firstWord = r.nextInt(allWords.length());
        System.out.println("first char "+allWords.charAt(firstWord)+firstWord);
        int i;
        String word = "";
        while (firstWord>allWords.length()/2){
            firstWord = r.nextInt(allWords.length());
        }
        do{
           firstWord++;
        }while(allWords.charAt(firstWord)!=' ');
        System.out.println("found first space");
        do{
            firstWord++;
            word += allWords.charAt(firstWord);
            System.out.println(word);
        }while(allWords.charAt(firstWord)!=' ');
        System.out.println("made first word");
        System.out.println("Our first word is "+word);
        return word;
    }
    public String makeSentence(){
        sentenceOut="";
        String firstword = getRandomWord();
        String nextword = firstword;
        System.out.println(firstword+" nextword: "+nextword);
        //System.out.println(d.get(firstword));
        sentenceOut+=firstword;

        do{
            System.out.println("Adding words");
            System.out.println(d.get("I"));
                sentenceOut += d.get(nextword);
                nextword = (String) d.get(nextword);
                System.out.println(nextword);
        }while(!nextword.contains("."));
        System.out.println("making lines");
        return sentenceOut;
    }
}
