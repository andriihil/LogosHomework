package com.logos.homework1;

import java.io.BufferedReader;
import java.io.IOException;

public class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private String ipn;

    Person() {
    }

    public Person(String firstName, String lastName, Gender gender, int age, String ipn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.ipn = ipn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIpn() {
        return ipn;
    }

    public void setIpn(String ipn) {
        this.ipn = ipn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("=======Person=======\n");
        sb.append("First name = ").append(firstName).append('\n');
        sb.append("Last name = ").append(lastName).append('\n');
        sb.append("Gender = ").append(gender).append('\n');
        sb.append("Age = ").append(age).append('\n');
        sb.append("IPN = ").append(ipn).append('\n');
        sb.append("====================");

        return sb.toString();
    }

    public void checkFirstName(String line, BufferedReader br) {
        String regex = "[^\\s\\d\\!\\.\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\_\\+\\=\\\\\\|\\/\\,\\<\\>\\?\\`\\'\\;\\:]+";
        if (!line.matches(regex)) {
            System.err.println("First name can only have letters, please try again");
            this.inputFirstName(br);
        } else {
            this.setFirstName(line);
        }
    }


    public void inputFirstName(BufferedReader br) {
        System.out.println("Enter first name: ");
        String line = null;
        try {
            System.out.print("> ");
            line = br.readLine();
//            this.setFirstName(br.readLine());
        } catch (IOException e) {
            System.err.println("Error, please try again");
            this.inputFirstName(br);
        }
        this.checkFirstName(line, br);
    }

    public void checkLastName(String line, BufferedReader br) {
        String regex = "[^\\s\\d\\!\\.\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\_\\+\\=\\\\\\|\\/\\,\\<\\>\\?\\`\\'\\;\\:]+";
        if (!line.matches(regex)) {
            System.err.println("Last name can only have letters, please try again");
            this.inputLastName(br);
        } else {
            this.setLastName(line);
        }
    }

    public void inputLastName(BufferedReader br) {
        System.out.println("Enter last name: ");
        try {
            System.out.print("> ");
            this.setLastName(br.readLine());
        } catch (IOException e) {
            System.err.println("Error, please try again");
            this.inputLastName(br);
        }
    }

    public void checkGender(String line, BufferedReader br) {
        if (line.equalsIgnoreCase(Gender.MALE.toString())) {
            this.setGender(Gender.MALE);
        } else if (line.equalsIgnoreCase(Gender.FEMALE.toString())) {
            this.setGender(Gender.FEMALE);
        } else if (line.equalsIgnoreCase(Gender.ANOTHER.toString())) {
            this.setGender(Gender.ANOTHER);
        } else {
            System.err.println("Gender can be only male, female or another");
            this.inputGender(br);
        }
    }

    public void inputGender(BufferedReader br) {
        System.out.println("Enter gender: ");
        String line = null;
        try {
            System.out.print("> ");
            line = br.readLine();
        } catch (IOException e) {
            System.err.println("Error, please try again");
            this.inputGender(br);
        }
        this.checkGender(line, br);
    }

    public void checkAge(int age, BufferedReader br) {
        if ((age >= 0) && (age <= 130)) {
            this.setAge(age);

        } else {
            System.err.println("Age can be in range of 0-130");
            this.inputAge(br);
        }
    }

    public void inputAge(BufferedReader br) {
        System.out.println("Enter age: ");
        int digit = 0;
        try {
            System.out.print("> ");
            digit = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println("Error, please try again");
            this.inputAge(br);
        }
        this.checkAge(digit, br);
    }

    public void checkIpn(String line, BufferedReader br) {
        String regex = "\\d+";
        int ipnRange = 12;
        if (!line.matches(regex)) {
            System.err.println("IPN must include only digits");
            this.inputIpn(br);
        } else if (line.length() != ipnRange) {
            System.err.println("IPN must inlcude 12 digits");
            this.inputIpn(br);
        } else {
            this.setIpn(line);
        }

    }

    public void inputIpn(BufferedReader br) {
        System.out.println("Enter IPN: ");
        String line = null;
        try {
            System.out.print("> ");
            line = br.readLine();
        } catch (IOException e) {
            System.err.println("Error, please try again");
            this.inputIpn(br);
        }
        this.checkIpn(line, br);
    }

    public void inputInformation(BufferedReader br) {
        this.inputFirstName(br);
        this.inputLastName(br);
        this.inputGender(br);
        this.inputAge(br);
        this.inputIpn(br);
    }

}
