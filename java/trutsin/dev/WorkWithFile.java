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

                ArrayList<Double> arrayList = new ArrayList<>();
                parameter = parameter.replace("array1[", "");
                parameter = parameter.replace("]", "");
                String[] arrayOfParameters = parameter.split(",");
                for (int i = 0; i < arrayOfParameters.length; i++) {
                    arrayList.add(Double.parseDouble(arrayOfParameters[i]));
                }
                element.setCoefficientFirst(arrayList);
            } else if (parameter.contains("array2")){
                ArrayList<Double> arrayList = new ArrayList<>();
                parameter = parameter.replace("array2[", "");
                parameter = parameter.replace("]", "");
                String[] arrayOfParameters = parameter.split(",");
                for (int i = 0; i < arrayOfParameters.length; i++) {
                    arrayList.add(Double.parseDouble(arrayOfParameters[i]));
                }
                element.setCoefficientSecond(arrayList);
            } else if (parameter.contains("array3")){
                ArrayList<Double> arrayList = new ArrayList<>();
                parameter = parameter.replace("array3[", "");
                parameter = parameter.replace("]", "");
                String[] arrayOfParameters = parameter.split(",");
                for (int i = 0; i < arrayOfParameters.length; i++) {
                    arrayList.add(Double.parseDouble(arrayOfParameters[i]));
                }
                element.setCoefficientThird(arrayList);
            } else if (parameter.contains("array4")){
                ArrayList<Double> arrayList = new ArrayList<>();
                parameter = parameter.replace("array4[", "");
                parameter = parameter.replace("]", "");
                String[] arrayOfParameters = parameter.split(",");
                for (int i = 0; i < arrayOfParameters.length; i++) {
                    arrayList.add(Double.parseDouble(arrayOfParameters[i]));
                }
                element.setCoefficientFourth(arrayList);
            } else if (parameter.contains("largeMultiplier")){
                parameter = parameter.replace("largeMultiplier[", "");
                parameter = parameter.replace("]", "");
                element.setLargeMultiplier(Double.parseDouble(parameter));
            }
        }
        return element;
    }

//    public void ras() {
//        Element element = new Element();
//        String[] parameters = readParameters().split("\r\n");
//        for (String parameter : parameters) {
//            if (parameter.contains("array1")){
//
//                parameter = parameter.replace("array1[[", "");
//                parameter = parameter.replace("][", "!");
//                parameter = parameter.replace("]]", "");
//
//                String[] bigArrayOfParameters = parameter.split("!");
//                double[][] arrayWithParameters;
//
//                for (int i = 0; i < bigArrayOfParameters.length; i++) {
//                    String[] onlyParameters = bigArrayOfParameters[i].split(",");
//
//                    for (int j = 0; j < onlyParameters.length; j++) {
//
//                    }
//                }
//
//                for (int i = 0; i < bigArrayOfParameters.length; i++) {
//                    String[] onlyParameters = bigArrayOfParameters[i].split(",");
//
//
//                    arrayWithParameters = new double[bigArrayOfParameters.length][onlyParameters.length];
//                    for (int j = 0; j < onlyParameters.length; j++) {
//
//                        arrayWithParameters[i][j] = Double.parseDouble(onlyParameters[j]);
//                    }
//                    element.setCoefficientFirsts(arrayWithParameters);
//                    System.out.println(element);
////                    System.out.println(smallArrayOfParameters);
//                }
//
////                for (int i = 0; i < bigArrayOfParameters.length; i++) {
////                    arrayList.add(Double.parseDouble(bigArrayOfParameters[i]));
////                }
////                element.setCoefficientFirst(arrayList);
//            }
//        }
//    }
}
