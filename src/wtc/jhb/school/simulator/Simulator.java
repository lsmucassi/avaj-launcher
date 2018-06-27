package wtc.jhb.school.simulator;

import java.io.*;
import java.util.Scanner;

public class Simulator {
    private Scanner fileCont ;

    public static void main(String[] args) {
        System.out.println("welcome to the flight terminal\nInit communication sequence");
        public String scenarioFile = args[0];

        if(args.length < 1) {
            System.out.println("Usage: must specify a scenario file");
            System.out.println("E.g: $java wtc.jhb.school.simulator.aircraft.Simulator scenario.txt");
            return;
        }

        //read file {
        try {
            scenarioFile = new Scanner(new File(scenarioFile.toString()));
        } catch (Exception e) {
            System.out.println("Error: couldn't read from specified file");
            System.out.println("Error: file might not be configured correctly");
            return ;
        }
        // }

        //output {
        File simulationFile = new File("simulation.txt");
        //validate file {

        // }

        //extract from file {

        // }

        //process air crafts {

        // }

        //print statements {

        // }
    }
}
