package com.logos.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Person person=new Person();
        inputPersonInformation(person,br);


    }
    public static void inputPersonInformation(Person person,BufferedReader br){
        person.inputInformation(br);
        System.out.println(person);
        askForAnotherInput(person, br);
    }

    public static void askForAnotherInput(Person person,BufferedReader br){
        System.out.println("Input another information?(yes/no): ");
        String line =null;
        try {
            System.out.print("> ");
            line=br.readLine();
        } catch (IOException e) {
            System.err.println("Error, please try again");
            askForAnotherInput(person,br);
        }
        if(line.equalsIgnoreCase("yes")){
            inputPersonInformation(person,br);
        } else if(line.equalsIgnoreCase("no")){
            System.out.println("Exiting...");
            System.exit(0);
        } else {
            System.err.println("Invalid command, please try again");
            askForAnotherInput(person, br);
        }
    }
}
