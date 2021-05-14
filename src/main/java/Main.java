import sandbox.PersonInform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        System.out.println("->->->->->->->->->->-> WELCOME <-<-<-<-<-<-<-<-<-<-<-<-<");

        Person a = new Person("Lina", "Zh", "+7999", 4);
        Person b = new Person("L", "Z", "+7999", 1);
        Person c = new Person("Lina", "Zh", "+7999", 5);
        Person d = new Person("Lina", "Zh", "+7999", 6);

        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(a);
        persons.add(b);
        persons.add(c);
        persons.add(d);

        ArrayList<PersonInform> personInforms = new ArrayList<PersonInform>();

        menu.welcomeMenu();
        menu.menu(personInforms);


    }
}
