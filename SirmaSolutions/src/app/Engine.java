package app;

import java.io.*;
import java.util.Scanner;

public class Engine implements Runnable {

    private static File FILE;
    private Scanner scanner;
    private BufferedReader bufferedReader;
    private DataParser dataParser;

    public Engine() {
        try {
            this.scanner = new Scanner(System.in);
            this.bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
            this.dataParser = new DataParser();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                dataParser.parse(line);
            }

            System.out.println(dataParser
                    .getMostWorkedEmployee()
                    .getEmployeeId());

//            dataParser.getSecondMostWorkedEmployee();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
