import textio.TextIO;
import java.math.BigInteger;
public class ModifiedSequence {
    private static boolean checkE;

    public static void main(String[] args) {


        while(!checkE) {
            try {
                printSequence();
                checkE = true;
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Not an Integer.");
                checkE = false;
            }
        }
        System.out.print("Goodbye.");
    }

    static void printSequence() throws NumberFormatException {
        BigInteger N = new BigInteger("1");
        int count = 1;

        System.out.println("This will output the 3N+1 sequence of the integer you put in.");
        System.out.println("Input your integer and press Enter:");

        BigInteger m;
        do {
            TextIO.skipBlanks();
            String str = TextIO.getln().trim();           //
            if(str.length() == 0)                         //this line?
                return;

            m = new BigInteger(str);
            if(m.signum() <= 0 || m.equals(N))
                System.out.println("Please input a valid integer");

        } while(m.signum() <= 0 || m.equals(N));


        System.out.println("The sequence is as follows: ");
        System.out.print(m);

        while(!m.equals(N)) {
            if(!m.testBit(0))
                m = m.divide(new BigInteger("2"));
            else
                m = m.multiply(new BigInteger("3")).add(N);
            System.out.print(", " + m);
            count++;
        }

        System.out.println();
        System.out.println("The number of terms in the sequence is " + count);

    }
}
