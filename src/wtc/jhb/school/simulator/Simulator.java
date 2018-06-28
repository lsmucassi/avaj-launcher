package wtc.jhb.school.simulator;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

import java.io.*;

import wtc.jhb.school.weather.WeatherProvider;
import wtc.jhb.school.weather.WeatherTower;
import wtc.jhb.school.simulator.Aircraft.AircraftFactory;

public class Simulator {

    public static PrintWriter printer ;
    public static int iter;

    public static void main(String[] args) {
        System.out.println("welcome to the flight terminal\nInit communication sequence");

        //handle no file input_
        if (args.length != 1) {
            System.out.println("Usage: must specify a scenario file");
            System.out.println("E.g  : $java wtc.jhb.school.simulator.aircraft.Simulator scenario.txt");
            return;
        }

        AircraftFactory aircraftFactory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower();
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        //read file_ {
        String scenarioFile = args[0];
        //File to create_
        File simulationFile = new File("simulation.txt");

        try {
            //scenarioFile = new Scanner(new File(scenarioFile.toString()));
            printer = new PrintWriter(simulationFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: couldn't read from specified file");
            System.out.println("Error: file might not be configured correctly");
            System.out.println("Error: " + e.getMessage());
            return ;
        }
        // }

        //verify simulation file before writing it_
        if (simulationFile.exists() && !simulationFile.isDirectory())
            printer.println("");

        //verify scenario file_
        try {
            FileInputStream fstream = new FileInputStream(scenarioFile);
            BufferedReader breader = new BufferedReader(new InputStreamReader(fstream));
            String fLine;
            int line = 1;
            String[] splits;
            while ((fLine = breader.readLine()) != null) {
                if (line == 1)
                    try {
                        iter = Integer.parseInt(fLine);
                        if (iter < 0) {
                            System.out.println("Error: line must be an integer & must be positive");
                            return ;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: expected a positive integer");
                        return;
                    }
                else {
                    splits = fLine.split(" ");
                    //ignore empty line_
                    if (splits.length == 1 && splits[0].isEmpty())
                        continue; //skip
                    if (splits.length != 5)
                        throw new Exception("Error: [" + line + "] - must have 5 parameters");

                    try {
                        aircraftFactory.newAircraft(splits[0], splits[1], Integer.parseInt(splits[2]),
                                Integer.parseInt(splits[3]),
                                Integer.parseInt(splits[4])).registerTower(weatherTower);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: [" + line + "] - parameter 3 to 5 must be an integer");
                        return ;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        return ;
                    }
                }
                line++;
            }
            breader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return ;
        }

        while (iter > 0) {
            weatherTower.changeWeather();
            iter--;
        }

        printer.close();
        //validate file {
        // }//extract from file {
        // }//process air crafts {
        // }//print statements {
        // }//output {
    }
}
