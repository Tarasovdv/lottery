import sandbox.Number;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Controller controller = new Controller();

    public void menu() throws IOException {
        Scanner console = new Scanner(System.in);
        int menuNum = console.nextInt();

        ArrayList<Person> people = controller.readFilePerson("Persons.txt"); // чтение из файла и создание списка (участники лоттереи)
        ArrayList<Number> freeNumbers = controller.readFileNumber("FreeNumbers.txt"); // чтение из файла и создание списка (свободные номерки)
        ArrayList<BoxLottery> boxSlots = controller.readFileBoxLottery("BoxLottery.txt"); // чтение из файла и создание списка (разыгрываемые слоты)

        while (true) {
            if (menuNum == 1) { //Участники лоттереи

                controller.printAllPersons(people);
                System.out.println("Количество участников лоттереи: " + (people).size());
                ArrayList<Number> freeNumbers1 = controller.readFileNumber("FreeNumbers.txt"); // чтение из файла и создание списка (свободные номерки)

                if (freeNumbers1.size() == 0) {
                    System.out.println("пустой список - генерация номерков");
                    int sizePersons = people.size();
                    System.out.println("Количество разыгрываемых номерков: " + ((sizePersons * 3) / 2 + 1));
                    controller.createNumbersFile(sizePersons);
                } else {
                    System.out.println("Разыгрываемых номерков: " + (freeNumbers1.size()));
                }

            } else if (menuNum == 2) { //Генерация номерков

//                controller.clearFile("BoxLottery");
//                controller.clearFile("FreeNumbers");
//                int sizePersons = people.size();
//                System.out.println("Количество разыгрываемых номерков: " + ((sizePersons * 3) / 2 + 1));
//                controller.createNumbersFile(sizePersons);

            } else if (menuNum == 3) {

                String person = controller.choosePerson(people);
                String num = controller.chooseNumber(controller.readFileNumber("FreeNumbers.txt"));
                controller.addSlotInBox(num, person, boxSlots);

            } else if (menuNum == 4) {

                controller.printAllSlots(boxSlots);

            } else if (menuNum == 5) {

                controller.winner(boxSlots);

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
                "1-Участники лоттереи |||| 3-Вручение номерка || 4-Разыгрываемые слоты || 5-Победитель || 0-Exit ||");
    }
}
