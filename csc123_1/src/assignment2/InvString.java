package assignment2;
//Camila Ramirez Mendoza cramirezmendoza1@toromail.csudh.edu
public class InvString {
    private String testString; // store string

    public InvString(String NewString) // constructor
    {
        testString = NewString;
    }

    public String toString() {
        char[] charArray = testString.toCharArray();
        StringBuilder reversedString = new StringBuilder();

        for (int i = charArray.length - 1; i >= 0; i--) {
            reversedString.append(charArray[i]);
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InvString s = new InvString("This is a test");
        System.out.println(s);
    }
}
