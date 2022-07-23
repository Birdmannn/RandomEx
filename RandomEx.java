import textio.TextIO;
public class RandomEx {

    public static void main(String[] args) {
        boolean tryAgain;
        double A, B, C;
        String message;

        do {
            try {
                System.out.println("Enter the values for A, B and C.");
                System.out.print("A = ");
                A = TextIO.getlnDouble();
                System.out.print("B = ");
                B = TextIO.getlnDouble();
                System.out.print("C = ");
                C = TextIO.getlnDouble();

                System.out.println();
                message = "The root of the equation is " + root(A, B, C);
            }
            catch(IllegalArgumentException e) {
                message = e.getMessage();
            }
            System.out.println(message);
            System.out.print("\n\nDo you wish to try again? ");
            tryAgain = TextIO.getlnBoolean();
        } while(tryAgain);

        System.out.print("\n\nGoodbye!");

    }

    /*
    Returns the larger of the two roots of the quadratic equation
    A*x*x + B*x + C = 0, provided it has any roots. If A == 0 or
    if the discriminant, B*B - 4*A*C, is negative, then an exception
    of type IllegalArgumentException is thrown.
     */
    static double root(double A, double B, double C) throws IllegalArgumentException {
       if(A == 0) {
           throw new IllegalArgumentException("A can't be zero.");
       }
       else {
           double disc = B*B - 4*A*C;
           if(disc < 0)
               throw new IllegalArgumentException("Discriminant < zero.");
           return (-B + Math.sqrt(disc)) / (2*A);
       }
    }
}
