import sandbox.PersonInform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();

        System.out.println("->->->->->->->->->->-> WELCOME <-<-<-<-<-<-<-<-<-<-<-<-<");

        ArrayList<Person> persons = new ArrayList<Person>();

        menu.welcomeMenu();
        menu.menu(persons);


    }
}
