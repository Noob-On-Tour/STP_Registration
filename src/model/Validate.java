package model;


import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

/*
 * Created by Ahmed on 13-Aug-16.
 */
public class Validate {

    public boolean Name(String s) {
        if (s.length() < 2) return false;
        else
            for (char i : s.toCharArray()) {
                if (!isAlphabetic(i) && i != ' ') {
                    return false;
                }
            }
        return true;
    }

    public boolean Email(String Email) {
        return Email.length() >= 5;
    }

    public boolean Phone(String phone) {
        if (phone.length() != 10) return false;
        for (char i : phone.toCharArray()) {
            if (!isDigit(i)) return false;
        }
        return true;
    }

    public boolean ID(String id) {
        if (id.length() == 0) return false;
        for (char i : id.toCharArray()) if (!isDigit(i)) return false;
        return true;
    }
}
