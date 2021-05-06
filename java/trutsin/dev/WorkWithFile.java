package trutsin.dev;

import java.io.*;
import java.util.ArrayList;

public class WorkWithFile {

    public WorkWithFile() {
    }

    public String readParameters() {
        String textFromFile = "";
        try (FileReader reader = new FileReader("java/trutsin/dev/parameters.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                textFromFile += (char) c;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return textFromFile;
    }

    public void writeSomething(String text) {
        try (FileWriter writer = new FileWriter("java/trutsin/dev/output.txt", false)) {
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Element setParametersFromFile() {
        Element element = new Element();
        String[] parameters = readParameters().split("\r\n");
        for (String parameter : parameters) {
            if (parameter.contains("array1")){
                ArrayList<Integer> arrayList = new ArrayList<>();
                parameter = parameter.replace("array1[", "");
                parameter = parameter.replace("]", "");
                String[] arrayOfParameters = parameter.split(",");
                for (int i = 0; i < arrayOfParameters.length; i++) {
                    arrayList.add(Integer.parseInt(arrayOfParameters[i]));
                }
                element.setCoefficientFirst(arrayList);
            } else if (parameter.contains("array2")){
                ArrayList<Integer> arrayList = new ArrayList<>();
                parameter = parameter.replace("array2[", "");
                parameter = parameter.replace("]", "");
                String[] arrayOfParameters = parameter.split(",");
                for (int i = 0; i < arrayOfParameters.length; i++) {
                    arrayList.add(Integer.parseInt(arrayOfParameters[i]));
                }
                element.setCoefficientSecond(arrayList);
            } else if (parameter.contains("array3")){
                ArrayList<Integer> arrayList = new ArrayList<>();
                parameter = parameter.replace("array3[", "");
                parameter = parameter.replace("]", "");
                String[] arrayOfParameters = parameter.split(",");
                for (int i = 0; i < arrayOfParameters.length; i++) {
                    arrayList.add(Integer.parseInt(arrayOfParameters[i]));
                }
                element.setCoefficientThird(arrayList);
            } else if (parameter.contains("array4")){
                ArrayList<Integer> arrayList = new ArrayList<>();
                parameter = parameter.replace("array4[", "");
                parameter = parameter.replace("]", "");
                String[] arrayOfParameters = parameter.split(",");
                for (int i = 0; i < arrayOfParameters.length; i++) {
                    arrayList.add(Integer.parseInt(arrayOfParameters[i]));
                }
                element.setCoefficientFourth(arrayList);
            } else if (parameter.contains("val1")){
                parameter = parameter.replace("val1[", "");
                parameter = parameter.replace("]", "");
                element.setCountOfMultiplier(Integer.parseInt(parameter));
            } else if (parameter.contains("val2")){
                parameter = parameter.replace("val2[", "");
                parameter = parameter.replace("]", "");
                element.setLargeMultiplier(Integer.parseInt(parameter));
            }
        }
        return element;
    }

}
