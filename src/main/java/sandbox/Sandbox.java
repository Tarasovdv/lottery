package sandbox;

import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Sandbox {
    public static void main(String[] args) {

        ArrayList<PersonInform> personInforms = new ArrayList<>();

        BufferedReader br = null;
        try {
            File file = new File("newFile.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

//            PrintWriter pw = new PrintWriter(file);
//            pw.println("Java");
//            pw.println("Hello!!!");
//            pw.close();

            br = new BufferedReader(new FileReader("newFile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                PersonInform pers = new PersonInform(line);
                personInforms.add(pers);

            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (PersonInform el : personInforms) {
            System.out.println(el.getInform());

        }
        System.out.println("personInforms.size() = " + personInforms.size());


        ArrayList<Number> numbers = new ArrayList();  // создать ПУЛ номерков
        Scanner console = new Scanner(System.in);
        System.out.println("Введите количество участников лотереи: ");
        int num = console.nextInt();
        int count = 1;
        if (num == 1) {
            Number number = new Number((num));
            numbers.add(number);
        } else {
            for (int i = 0; i < num; i++) {
                Number number = new Number((count));
                numbers.add(number);
                count++;
            }
        }

        for (Number el : numbers) {
            System.out.println("номерок №: " + el);
        }

        //выдача номерков
        System.out.println("Выберите номерок: ");
        int changeNum = console.nextInt();
        for (int i = 0; i < numbers.size(); i++) {
            if ((String.valueOf(changeNum)).equals(String.valueOf(numbers.get(i).number))) {
                System.out.println(i);
                break;
            }
        }
//        for (Number el : numbers) {
//            if (String.valueOf(el.getNumber()).equals(String.valueOf(changeNum))){
//                System.out.println("Номерок найден!!!");
//
//            } else {
//                System.out.println("Номерка нет!");
//            }
//        }


    }
}

