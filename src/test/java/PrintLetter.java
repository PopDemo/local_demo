public class PrintLetter {

    public static void main(String args []) {
        PrintLetter pl = new PrintLetter ();
        pl.printLowerCase ();
        pl.printUpperCase ();
    }

    void printLowerCase () {
        char c = 'a';
        for (int i=0;i<26;i++) {
            System.out.print((char)(c+i)+" ");
        }
    }

    void printUpperCase () {
        char c = 'A';
        for (int i=0;i<26;i++) {
            System.out.print((char)(c+i)+" ");
        }
    }

}