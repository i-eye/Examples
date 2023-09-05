package com.WinstonStatue;
import java.lang.Integer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

public static void main(String[] args) throws Exception{
    String[] strings = txtReader("txt.txt");
    for (String line: strings) {
        System.out.println(line);
    }
    String[] lines = readFileToLines("txt.txt");
    for (String line: lines) {
        System.out.println(line);
    }
}

public static String[] readFileToLines(String filePath) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    ArrayList<String> lines = new ArrayList<>();
    String line;
    while ((line = reader.readLine()) != null) {
        lines.add(line);
    }
    return lines.toArray(new String[0]);
}

    public static void ReaderExample() throws IOException {
        //creates it
        BufferedReader br = new BufferedReader(new FileReader("filename.in"));
        // reads it
        String stuffRead = br.readLine();

        String line;
        ArrayList<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        //closes it
        br.close();
    }
    public static void WriterExample() throws IOException {
        //makes it
        BufferedWriter bw = new BufferedWriter(new FileWriter("filename.out"));
        //prints it
        bw.write("Stuff to Write");
        //flushes it
        bw.flush();
    }

    private int[][] rotateClockWise(int[][] matrix) {
        int size = matrix.length;
        int[][] ret = new int[size][size];

        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j)
                ret[i][j] = matrix[size - j - 1][i]; //***

        return ret;
    }
    private int[][] rotateCounterClockWise(int[][] matrix) {
        int size = matrix.length;
        int[][] ret = new int[size][size];

        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j)
                ret[i][j] = matrix[j][size - i - 1]; //***

        return ret;
    }
    public static void EnhancedSwitch(){
        int x = 0;
        boolean result = switch(x){
            case 1,2,3,4 -> {
                System.out.println("yeah");
                yield false;
            }
            case 0 -> {
                System.out.println("noo");
                yield true;
            }
            default -> {
                yield false;
            }
        };
    }

    // Console Animation
    private String lastLine = "";
    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            StringBuilder temp = new StringBuilder();
            temp.append(" ".repeat(lastLine.length()));
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }
    private byte anim;
    public void animate(String line) {
        switch (anim) {
            case 1:
                print("[ \\ ] " + line);
                break;
            case 2:
                print("[ | ] " + line);
                break;
            case 3:
                print("[ / ] " + line);
                break;
            default:
                anim = 0;
                print("[ - ] " + line);
        }
        anim++;
    }

    //read csv
    public static String[][] csvReader(String file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> rows = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null){
            rows.add(line);
        }
        String[][] returner = new String[rows.size()][rows.get(0).split(",").length];
        for (int i = 0, rowsSize = rows.size(); i < rowsSize; i++) {
            String row = rows.get(i);
            String[] split = row.split(",");
            for (int j = 0, splitLength = split.length; j < splitLength; j++) {
                String word = split[j];
                returner[i][j] = word;
            }
        }
        return returner;
    }
    public static String[] txtReader(String file) throws Exception{
        BufferedReader reader = new BufferedReader((new FileReader(file)));
        ArrayList<String> rows = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null){
            rows.add(line);
        }
        return rows.toArray(new String[0]);
    }
    public static void readerBeader() throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader elements;
        BufferedReader chemicals;

        elements = new BufferedReader(new FileReader("elements.csv"));
        chemicals = new BufferedReader(new FileReader("chemicals.csv"));
        System.out.println("ENTER CHEMICAL NAME:");
        String name = sc.nextLine();
        ArrayList<String> chemicalArray = new ArrayList<>();
        String line;
        String formula = "";
        while ((line = chemicals.readLine()) != null) {
            chemicalArray.add(line);
        }

        String[] firstChemicals = chemicalArray.get(0).split(",");
        ArrayList<String> firstChemical = new ArrayList<>();
        Collections.addAll(firstChemical, firstChemicals);
        for(String findName: chemicalArray){
            if(name.toLowerCase().trim().equals(findName.split(",")[firstChemical.indexOf("Name")])){
                formula = findName.split(",")[firstChemical.indexOf("ChemicalFormula")];
                break;
            }

        }
        if(formula.equals("")){
            System.out.println("UNKNOWN");
            return;
        }
        System.out.println("Formula: "+ formula);
        char[] formulas = formula.toCharArray();
        ArrayList<String> symbols = new ArrayList<>();
        for(int i = 65; i <= 90; i++){
            for (int e = 0; e < formulas.length; e++) {
                if((int)formulas[e] == i){
                    String atom = String.valueOf(formulas[e]);
                    int add = 0;
                    for(int j = 97; j <= 122; j++) {
                        if ((formulas.length > e + 1) && formulas[e + 1] == j) {
                            atom = atom + String.valueOf(formulas[e + 1]);
                            add = 1;
                            break;
                        }
                    }
                    boolean ok = false;
                    for(int ger = 49; ger <= 57; ger++){
                        if((formulas.length > e+1+add) && (int)formulas[e+1+add] == ger){
                            ok = true;
                            for(int y = 0; y < Integer.parseInt(String.valueOf(formulas[e+1+add])); y++)
                            {
                                symbols.add(atom);
                            }
                        }
                    }
                    if(!ok){
                        symbols.add(atom);
                    }
                }
            }
        }

        ArrayList<String> elementArray = new ArrayList<>();
        while ((line = elements.readLine()) != null) {
            elementArray.add(line);
        }
        String[] firstElements = elementArray.get(0).split(",");
        ArrayList<String> firstElement = new ArrayList<>();
        Collections.addAll(firstElement, firstElements);
        int protons = 0;
        int electrons = 0;
        int weight = 0;
        for(String symbol: symbols){
            for(String findElement: elementArray){
                if(symbol.equals(findElement.split(",")[firstElement.indexOf("Symbol")])){
                    protons += Integer.parseInt(findElement.split(",")[firstElement.indexOf("NumberOfProtons")]);
                    electrons += Integer.parseInt(findElement.split(",")[firstElement.indexOf("NumberOfElectrons")]);
                    weight += Integer.parseInt(findElement.split(",")[firstElement.indexOf("AtomicMass")]);
                    break;
                }

            }

        }
        
    }

}
