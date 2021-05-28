package sandbox;

import java.io.*;
import java.util.ArrayList;

import java.io.IOException;
import java.util.Scanner;

public class Sandbox {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<PersonInform> personInforms = new ArrayList<>();
        BufferedReader br = null;

        try {
            File file = new File("Persons.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader("Persons.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                PersonInform pers = new PersonInform(line);
                personInforms.add(pers);
            }

            printList(personInforms);

            int sizePersons = personInforms.size();
            System.out.println("Количество участников лоттереи: " + sizePersons);
            int allNumLottery = ((sizePersons * 3) / 2 + 1);
            System.out.println("Количество номерков лоттереи: " + allNumLottery);

            createNumbersList(allNumLottery);


            System.out.println("Выберите участника (номер или Имя) для присваивания номерка: ");
            Scanner console = new Scanner(System.in);
            String candidate = console.nextLine();


            for (int i = 0; i < personInforms.size(); i++) {
                if ((personInforms.get(i).getInform().equals(candidate)) || String.valueOf(i + 1).equals(candidate)) {
                    System.out.println(personInforms.get(i).getInform());
                }
            }

//            StringBuilder sb = new StringBuilder(personInforms.get(i).getInform());
//            System.out.println("Присвойте номерок: ");
//            String nomerok = console.nextLine();
//            for (int i = 0; i < personInforms.size(); i++) {
//                if (nomerok.equals(String.valueOf(number.getNumber()))) {
//                    sb.append("; номерок: ").append(nomerok);
//                    personInforms.get(i).setInform(sb.toString());
//                    System.out.println(personInforms.get(i).getInform());
////                            numbers.remove(j);
//                    break;
//                } else {
//                    System.out.println("no numbers");
//                    break;
//                }
//            }
//
//            System.out.println("numbers = " + numbers);
//
//            PrintWriter pw = new PrintWriter(file);
//            for (int i = 0; i < personInforms.size(); i++) {
//                pw.println(personInforms.get(i).getInform());
//            }
//            pw.close();


        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println("personInforms.size() = " + personInforms.size());


//        System.out.println();
//        for (PersonInform el : personInforms) {
//            System.out.println(el.getInform());
//
//        }


//        ArrayList<Number> numbers = new ArrayList();  // создать ПУЛ номерков
//        Scanner console = new Scanner(System.in);
//        System.out.println("Введите количество участников лотереи: ");
//        int num = console.nextInt();
//        int count = 1;
//        if (num == 1) {
//            Number number = new Number((num));
//            numbers.add(number);
//        } else {
//            for (int i = 0; i < num; i++) {
//                Number number = new Number((count));
//                numbers.add(number);
//                count++;
//            }
//        }
//
//        for (Number el : numbers) {
//            System.out.println("номерок №: " + el);
//        }
//
//        //выдача номерков
//        System.out.println("Выберите номерок: ");
//        int changeNum = console.nextInt();
//        for (int i = 0; i < numbers.size(); i++) {
//            if ((String.valueOf(changeNum)).equals(String.valueOf(numbers.get(i).number))) {
//                numbers.remove(i);
////                System.out.println(i);
//                break;
//            }
//        }
//
//        for (Number el : numbers) {
//            System.out.println("номерок №: " + el);
//        }


//        for (Number el : numbers) {
//            if (String.valueOf(el.getNumber()).equals(String.valueOf(changeNum))){
//                System.out.println("Номерок найден!!!");
//
//            } else {
//                System.out.println("Номерка нет!");
//            }
//        }


    }

    private static void createNumbersList(int allNumLottery) {
        ArrayList<Number> numbers = new ArrayList();  // создать ПУЛ номерков
        int count = 1;
        for (int i = 0; i < allNumLottery; i++) {
            Number number = new Number((count));
            numbers.add(number);
            count++;
        }
        System.out.println("Номерки для лоттереи: " + numbers);
    }

    private static void printList(ArrayList<PersonInform> personInforms) {
        for (PersonInform el : personInforms) {
            System.out.println(el.getInform());
        }
    }

    private static File getFile() throws IOException {
        File file = new File("Persons.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }


}

