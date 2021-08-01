package main.java.models;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MailModel {


    public void generateEmail(PersonObjectModel person) {
        try {
            String path = (System.getProperty("user.dir") + "\\src\\main\\java\\data\\" + person.getEmail() + ".txt");
            File file = new File(path);
            file.createNewFile();

            FileWriter fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            if (person.getGender() == 'M') {
                printWriter.print("\nSzanowny Pan " + person.getName() + " " + person.getLastName());
            } else {
                printWriter.print("\nSzanowna Pani " + person.getName() + " " + person.getLastName());
            }
            printWriter.printf("\nemail: " + person.getEmail());
            printWriter.printf("\n\n                          Powiadomienie");
            printWriter.printf("\n\nProsimy o uregulowanie zaległej kwoty w wysokości " + person.getAmount() +
                    " do dnia " + person.getFinalDate());

            printWriter.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
