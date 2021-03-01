import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        MarkovChain m = new MarkovChain();
        m.fileRead();
        m.makeHashtable();
        Scanner s = new Scanner(System.in);
        System.out.println("how many sentences would you like to print");
        int numSenctences = s.nextInt();
        for(int i = 0;i<numSenctences;i++) {
            System.out.println("in for loop");
            String sentence = m.makeSentence();
            System.out.println("made sentences");
            System.out.println(sentence);
        }
        System.out.println("not stuck");
    }
}
