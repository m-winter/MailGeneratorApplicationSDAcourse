package main.java.app;

import main.java.models.MailModel;
import main.java.models.PersonObjectModel;

import java.io.*;
import java.util.ArrayList;

public class MailGeneratorApp {
    public static void main(String[] args) {
        String filePath = (System.getProperty("user.dir") + "\\src\\main\\java\\data\\people.txt");

        ArrayList<PersonObjectModel> personObjectModelArrayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) { //check if there is another existing line

                PersonObjectModel personObjectModel = new PersonObjectModel();
                personObjectModelArrayList.add(personObjectModel.generateFromString(currentLine)); //creating object and adding it to List


            }
            System.out.println("Creating ArrayList with objects from file Success");

        } catch (FileNotFoundException e) {
            System.out.println("File not found! Check all path Strings! \n" + e);
        } catch (IOException e) {
            System.out.println("Error \n" + e);
        }

        for (PersonObjectModel person : personObjectModelArrayList) {
            try {
                person.toString();
                MailModel mail = new MailModel(); //create new mail object
                mail.generateEmail(person); // generate file and format email
                System.out.println("Creating mail for object " + person.getName() + " Success");
            } catch (Exception e) {
                System.out.println("Error! Check all path Strings! \n"  + e);
            }
        }


    }
}
