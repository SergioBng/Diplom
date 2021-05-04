package trutsin.dev;

import java.io.*;
import java.io.IOException;

public class WorkWithFile {

    public WorkWithFile() {
    }

    public void readParameters() {
        String textFromFile = "";
        try (FileReader reader = new FileReader("java/trutsin/dev/parameters.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                textFromFile += (char) c;
            }
            System.out.println(textFromFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void writeSomething(String text) {
        try (FileWriter writer = new FileWriter("java/trutsin/dev/output.txt", false)) {
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
