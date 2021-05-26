package trutsin.dev;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFile {

    public WorkWithFile() {
    }

    public String readParameters(String path) {
        String textFromFile = "";
        try (FileReader reader = new FileReader(path)) {
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
        String path = "C:/Users/user/Desktop/Mathcad diplom/FNCH.txt";
        Element element = new Element();
        String[] parameters = readParameters(path).split("\r\n");
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

    public ArrayList<Double> getReadyValues(String path) {
        ArrayList<Double> list = new ArrayList<>();
        String[] arrayWithXY = readParameters(path).split("\r\n");
        for (String str : arrayWithXY) {
            String[] xy = str.split(",");
            for (String v: xy) {
                list.add(Double.parseDouble(v));
            }
        }
        System.out.println(list);
        return list;
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
