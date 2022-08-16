import textio.TextIO;
public class Functions {

    public static void main(String[] args) {

        Expr func;
        String str,str2;
        double x;


        System.out.println("This program lets the user input an expression and substitute a value of 'x' into it.");
        System.out.println();

        while (true) {
            System.out.println("Please input your expression:");
            TextIO.skipBlanks();
            str = TextIO.getln().trim();
            if(str.length() == 0)
                break;
            System.out.println("Input your value for 'x'. Type \"exit\" to exit.\n");

            do {
                System.out.print("x?  ");
                TextIO.skipBlanks();
                str2 = TextIO.getln().trim();
                try {
                    x = Double.parseDouble(str2);
                    func = new Expr(str);
                    double value = func.value(x);
                    if(Double.isNaN(value)) {
                        System.out.println("The expression " + func + " is undefined for the value of " + x);
                        System.out.println("Please input a valid value for 'x'");
                    }
                    else {
                        System.out.println("The solution for the expression for the value of " + x + " is " + value + ".");
                        System.out.println();
                    }
                }
                catch(IllegalArgumentException e) {
                    if(!str2.equalsIgnoreCase("exit"))
                        System.out.println(e.getMessage() + "\n");
                }
            } while(!str2.equalsIgnoreCase("exit"));
        }
    }
}
