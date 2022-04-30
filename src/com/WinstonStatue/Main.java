package com.WinstonStatue;


import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static void ReaderExample() throws IOException {
        //creates it
        BufferedReader br = new BufferedReader(new FileReader("filename.in"));
        // reads it
        String stuffRead = br.readLine();
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
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
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

}
