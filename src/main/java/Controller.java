import sandbox.PersonInform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    void printAllPersons(ArrayList<PersonInform> personInforms) {
        int count = 0;
        System.out.println("All Persons: ______");
        for (Object elementPersons : personInforms) {
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

    public void winner(ArrayList<PersonInform> personInforms) {
        int sizeLottery = personInforms.size();
        int indexWin = rand(sizeLottery);
        PersonInform winner = personInforms.get(indexWin);
        System.out.println("                  " +
                "        _____!!! WINNER !!!___!!! WINNER !!!___!!! WINNER !!!_____\n");
        System.out.println("                           " + winner);
        System.out.println("                  " +
                "        _____!!! WINNER !!!___!!! WINNER !!!___!!! WINNER !!!_____\n");

    }

    private static int rand(int size) {
        return (int) (Math.random() * size);
    }

    public ArrayList<PersonInform> readFile(String pathnameFile) {
        ArrayList<PersonInform> personInforms = new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(pathnameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(pathnameFile));
            String line;
            while ((line = br.readLine()) != null) {
                PersonInform pers = new PersonInform(line);
                personInforms.add(pers);
            }
        } catch (
                IOException ex) {
            System.out.println("Error: " + ex);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return personInforms;
    }

}
