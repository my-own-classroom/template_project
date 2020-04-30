package mainpackage;

import java.util.Arrays;

/**
 * some javadoc.
 *
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Expected 3 arguments: <string> <int> <int>");
            System.out.println("but got: " + Arrays.toString(args));
        }

        OtherClass otherClass = new OtherClass();
        String result = otherClass.substring(args[0], Integer.parseInt(args[1]),
                Integer.parseInt(args[2]));
        System.out.println(result);
    }

    private Main() {}
}

