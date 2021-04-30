import java.util.List;
import java.util.Scanner;

public class Controller {

    void printAllPersons(List<Person> persons) {
        int count = 0;
        System.out.println("All Persons: ______");
        for (Object elementPersons : persons) {
            count++;
            System.out.println("#" + count + ") " + elementPersons);
        }
    }

    public List addPerson(Scanner console, List<Person> persons) {
        System.out.println("Add person: _______");
        System.out.println("Input Name: ");
        String firstName = console.next();
        System.out.println("Input Last Name: ");
        String lastName = console.next();
        System.out.println("Input Telephone: ");
        String tel = console.next();
        System.out.println("Input Lucky number: ");
        int number = console.nextInt();
        Person person = new Person(firstName, lastName, tel, number);
        persons.add(person);
        return persons;
    }

    public void winner(List<Person> persons) {
        int sizeLoteery = persons.size();
        int indexWin = rand(sizeLoteery);
        Person winner = persons.get(indexWin);
        System.out.println("                  " +
                "        _____!!! WINNER !!!___!!! WINNER !!!___!!! WINNER !!!_____\n");
        System.out.println("                           "+winner);
        System.out.println("                  " +
                "        _____!!! WINNER !!!___!!! WINNER !!!___!!! WINNER !!!_____\n");

    }

    private static int rand(int size) {
        return (int) (Math.random() * size);
    }
}
