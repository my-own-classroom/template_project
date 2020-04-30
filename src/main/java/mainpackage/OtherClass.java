package mainpackage;

/**
 * Javadoc for Class implementing substring.
 * @author Mark
 */
public class OtherClass {
    public String substring(String str, int from, int to) {
        if (from > to) {
            return str.substring(to, from);
        }
        if (str.length() < to || from < 0 || to < 0) {
            return "";
        } else {
            return str.substring(from, to);
        }
    }
}
