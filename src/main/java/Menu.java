import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Controller method = new Controller();

    public void menu(List<Person> persons) {
        Scanner console = new Scanner(System.in);
        int menuNum = console.nextInt();

        while (true) {
            if (menuNum == 1) {
                method.printAllPersons(persons);

            } else if (menuNum == 2) {
                method.addPerson(console, persons);

            } else if (menuNum == 3) {
                method.winner(persons);

            } else if (menuNum == 0) {
                System.out.println("Thanks!");
                System.exit(0);
            }
            welcomeMenu();
            menuNum = console.nextInt();
        }
    }

    public void welcomeMenu() {
        System.out.println("Menu: \n" +
                "1-All persons || 2-Add persons || 3-Winner || 0-Exit ||");
    }
}