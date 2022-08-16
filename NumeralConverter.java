import textio.TextIO;
public class NumeralConverter {

    public static void main(String[] args) {

        Numeral value;


        System.out.println("This program coverts from Arabic numeral to Roman Numeral, and vice versa.");
        System.out.println();
        do {
            System.out.print("input? ");
            try {
                TextIO.skipBlanks();
                if(TextIO.peek() == '\n')
                    break;
                if(Character.isDigit(TextIO.peek())) {
                    int N = TextIO.getlnInt();
                    value = new Numeral(N);
                    System.out.println("Corresponding value: " + value.toString());
                }
                else {
                    String str = TextIO.getln().trim();
                    value = new Numeral(str);
                    System.out.println("Corresponding value: " + value.toInt());
                }

            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " Please input a valid numeral.");
            }
        } while(true);
    }








    static class Numeral {
        private String str;
        private int N;
        private int value;
        Numeral(String str) {
            this.str = str.toUpperCase();
        }
        Numeral(int N) {
            this.N = N;
        }

        public String toString() throws NumberFormatException {
            if(N < 1 || N > 3999)
                throw new NumberFormatException("Illegal input.");
            String roman = "";
            while(N >= 1000) {
                roman += "M";
                N -= 1000;
            }
            while(N >= 900) {
                roman += "CM";
                N -= 900;
            }
            while(N >= 500) {
                roman += "D";
                N -= 500;
            }
            while(N >= 400) {
                roman += "CD";
                N -= 400;
            }
            while(N >= 100) {
                roman += "C";
                N -= 100;
            }
            while(N >= 90) {
                roman += "XC";
                N -= 90;
            }
            while(N >= 50) {
                roman += "L";
                N -= 50;
            }
            while(N >= 40) {
                roman += "XL";
                N -= 40;
            }
            while(N >= 10) {
                roman += "X";
                N -= 10;
            }
            while(N >= 9) {
                roman += "IX";
                N -= 9;
            }
            while(N >= 5) {
                roman += "V";
                N -= 5;
            }
            while(N >= 4) {
                roman += "IV";
                N -= 4;
            }
            while(N >= 1) {
                roman += "I";
                N -= 1;
            }
            return roman;
        }

        public int toInt() throws NumberFormatException {
            if(str.length() == 0)
                throw new NumberFormatException("Illegal Input.");
            int i = 0;
            int value = 0;

            while (i < str.length()) {
                char ch = str.charAt(i);
                int number = letterToNumber(ch);
                i++;

                if(i == str.length()) {
                    value += number;
                }
                else {
                    int nextNumber = letterToNumber(str.charAt(i));
                    if(nextNumber > number) {
                        value += (nextNumber - number);
                        i++;
                    }
                    else {
                        value += number;
                    }
                }
            }
            if(value > 3999)
                throw new NumberFormatException("Illegal string. Value greateer than 3999.");

            return value;

        }
        private int letterToNumber(char letter) {
            switch(letter) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default:  throw new NumberFormatException("Illegal input.");
            }
        }
    }
}
