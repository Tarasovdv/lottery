import sandbox.Number;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Controller method = new Controller();

    public void menu(ArrayList<Person> persons) throws IOException {
        Scanner console = new Scanner(System.in);
        int menuNum = console.nextInt();
        ArrayList<Person> people = method.readFilePerson("newFile.txt");
        ArrayList<Number> freeNumbers = method.readFileNumber("FreeNumbers.txt");
        ArrayList<BoxLottery> boxSlots = method.readFileBoxLottery("BoxLottery.txt");

        while (true) {
            if (menuNum == 1) { //Участники лоттереи
                method.printAllPersons(people);
                System.out.println("Количество участников лоттереи: " + (people).size());

            } else if (menuNum == 2) { //Генерация номерков
                int sizePersons = people.size();
                System.out.println("Количество разыгрываемых номерков: " + ((sizePersons * 3) / 2 + 1));

                method.createNumbersFile(sizePersons);


            } else if (menuNum == 3) {
                String pers = method.choosePerson(people);
                String num = method.chooseNumber(freeNumbers);

                method.addSlotInBox(num, pers, boxSlots);


            } else if (menuNum == 4) {
                method.winner(boxSlots);

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
                "1-Участники лоттереи || 2-Генерация номерков || 3-Вручение номерка || 4-Победитель || 0-Exit ||");
    }
}
