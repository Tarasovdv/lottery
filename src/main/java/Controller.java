import sandbox.Number;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    void printAllPersons(ArrayList<Person> people) {
        for (Person el : people) {
            System.out.println(el.getInform());
        }
    }


//        int count = 0;
//        System.out.println("All Persons: ______");
//        for (Object elementPersons : persons) {
//            count++;
//            System.out.println("#" + count + ") " + elementPersons);
//        }


//    private void readFileCreateList(String path, ArrayList arrayList ) throws IOException {
//        BufferedReader br = null;
//        br = new BufferedReader(new FileReader(path)); //"newFile.txt"
//        String line;
//        while ((line = br.readLine()) != null) {
//            ArrayList arrayList = new ArrayList();
////            Person persons = new Person(line);
////            persons.add(persons);
//        }
//
//    }

//    public List addPerson(Scanner console, List<Person> persons) {
//        System.out.println("Add person: _______");
//        System.out.println("Input Name: ");
//        String firstName = console.next();
//        System.out.println("Input Last Name: ");
//        String lastName = console.next();
//        System.out.println("Input Telephone: ");
//        String tel = console.next();
//        System.out.println("Input Lucky number: ");
//        int number = console.nextInt();
//        Person person = new Person(firstName, lastName, tel, number);
//        persons.add(person);
//        return persons;
//    }

    public void winner(ArrayList<BoxLottery> slots) {
        int sizeLottery = slots.size();
        int indexWin = rand(sizeLottery);
        BoxLottery winner = slots.get(indexWin);
        System.out.println("                  " +
                "        _____!!! WINNER !!!___!!! WINNER !!!___!!! WINNER !!!_____\n");
        System.out.println("                           " + winner);
        System.out.println("                  " +
                "        _____!!! WINNER !!!___!!! WINNER !!!___!!! WINNER !!!_____\n");

    }

    private static int rand(int size) {
        return (int) (Math.random() * size);
    }

    public ArrayList<Person> readFilePerson(String pathNameFile) {
        ArrayList<Person> persons = new ArrayList<>();
        try {
            File file = new File(pathNameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            persons = createListPerson(pathNameFile, persons);

        } catch (
                IOException ex) {
            System.out.println("Error: " + ex);
        }
        return persons;
    }

    public ArrayList<Person> createListPerson(String pathNameFile, ArrayList<Person> persons) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathNameFile));
        String line;
        while ((line = br.readLine()) != null) {
            Person person = new Person(line);
            persons.add(person);
        }
        br.close();
        return persons;
    }


    public ArrayList<Number> readFileNumber(String pathNameFile) {
        ArrayList<Number> numbers = new ArrayList<>();
        try {
            File file = new File(pathNameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            numbers = createListNumber(pathNameFile, numbers);

        } catch (
                IOException ex) {
            System.out.println("Error: " + ex);
        }
        return numbers;
    }

    public ArrayList<Number> createListNumber(String pathNameFile, ArrayList<Number> numbers) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathNameFile));
        String line;
        while ((line = br.readLine()) != null) {
            Number number = new Number(Integer.parseInt(line));
            numbers.add(number);
        }
        br.close();
        return numbers;
    }

    public String chooseNumber(ArrayList<Number> numbers) throws IOException {
        int sizeNumbers = numbers.size();

        System.out.println("Количество номерков: " + sizeNumbers);
        System.out.println("Выберите номерок: " + numbers);
        Scanner console = new Scanner(System.in);
        String luckyNumb = console.nextLine();
        String informNum = null;

        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if ((numbers.get(i).getNumber() == (Integer.parseInt(luckyNumb)))) {

                informNum = String.valueOf(numbers.get(i).getNumber());
                System.out.println("Выбранный номерок: " + informNum);
                numbers.remove(numbers.get(i));


            } else {
                count++;
            }
        }

        File file = new File("FreeNumbers.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter pw = new PrintWriter(file);
        for (int i = 0; i < numbers.size(); i++) {
            pw.println(numbers.get(i).getNumber());
        }
        pw.close();

        return informNum;
    }


    public String choosePerson(ArrayList<Person> persons) {
        int sizePersons = persons.size();
        System.out.println("Количество участников лоттереи: " + sizePersons);
        System.out.println("Выберите участника (номер или Имя) для присваивания номерка: ");
        printAllPersons(persons);
        Scanner console = new Scanner(System.in);
        String candidate = console.nextLine();
        String informPerson = null;

        int count = 0;
        for (int i = 0; i < persons.size(); i++) {
            if ((persons.get(i).getInform().equals(candidate)) || String.valueOf(i + 1).equals(candidate)) {

                informPerson = persons.get(i).getInform();
                System.out.println("Участник лоттереи: \n" + informPerson);

            } else {
                count++;
            }
        }
        return informPerson;
    }


    public void addSlotInBox(String numb, String person, ArrayList<BoxLottery> slots) throws IOException {
//        ArrayList<BoxLottery> slots = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("Номерок: ").append(numb).append(", Участник: ").append(person);
        String slotLine = sb.toString();
        System.out.println(slotLine);
        BoxLottery slot = new BoxLottery(sb.toString());
        slots.add(slot);
        File file = new File("BoxLottery.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter pw = new PrintWriter(file);
        for (int i = 0; i < slots.size(); i++) {
            pw.println(slots.get(i).getLotterySlot());
        }
        pw.close();
    }

    public ArrayList<BoxLottery> readFileBoxLottery(String pathNameFile) {
        ArrayList<BoxLottery> slots = new ArrayList<>();
        try {
            File file = new File(pathNameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            slots = createListSlot(pathNameFile, slots);

        } catch (
                IOException ex) {
            System.out.println("Error: " + ex);
        }
        return slots;
    }


    public ArrayList<BoxLottery> createListSlot(String pathNameFile, ArrayList<BoxLottery> slots) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathNameFile));
        String line;
        while ((line = br.readLine()) != null) {
            BoxLottery slot = new BoxLottery((line));
            slots.add(slot);
        }
        br.close();
        return slots;
    }


    public void createNumbersFile(int sizePersons) throws IOException {
        int allNumLottery = ((sizePersons * 3) / 2 + 1);
        ArrayList<Number> freeNumbers = new ArrayList();
        int count = 1;
        for (int i = 0; i < allNumLottery; i++) {
            Number number = new Number((count));
            freeNumbers.add(number);
            count++;
        }
        System.out.println("Номерки для лоттереи: " + freeNumbers);
        File file2 = new File("FreeNumbers.txt");
        if (!file2.exists()) {
            file2.createNewFile();
        }
        PrintWriter pw = new PrintWriter(file2);
        for (int i = 0; i < allNumLottery; i++) {
            pw.println(freeNumbers.get(i).getNumber());
        }
        pw.close();
    }

//    public ArrayList<Number> removeNumber(ArrayList<Number> numbers, int chooseNumb) {
//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i).getNumber() == chooseNumb) {
//                numbers.remove(i);
//            }
//        }
//        return numbers;
//    }


}
