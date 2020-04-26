package com.company;
public class Password {
    private String passwords;


    public Password(String passwords) {
        setPasswords(passwords);
    }


    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        if (check(passwords)) {
            this.passwords = passwords;
        } else System.out.println("Incorrect form password");

    }

    private static boolean check(String passwords) {
        int a = passwords.length();
        String str2 = passwords.toLowerCase();
        for (int i = 0; i < passwords.length(); i++) {
            if (str2.charAt(i) == passwords.charAt(i) && a < 9)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return passwords;
    }
}