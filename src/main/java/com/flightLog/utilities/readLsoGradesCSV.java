package com.flightLog.utilities;

import com.flightLog.models.lsoGrades;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class readLsoGradesCSV {

        public static ArrayList<lsoGrades> readLsoGradesCSV(String file) throws Exception {
            String callSign = "";
            String grade = "";
            String points = "";
            String finalScore = "";
            String details = "";
            String wire = "";
            String grooveTime = "";
            String recoveryCase = "";
            String wind = "";
            String modex = "";
            String airFrame = "";
            String carrierType = "";
            String carrierName = "";
            String theater = "";
            String miTime = "";
            String miDate= "";
            String serverName = "";
            String serverDate = "";
            String serverTime = "";
            String flightTime = "";
            ArrayList<lsoGrades> log = new ArrayList<>();



            Scanner sc = new Scanner(new File(file));
            sc.useDelimiter("\\{\"pilot\":");
            while (sc.hasNext()) {
                sc.useDelimiter(",");
                callSign = sc.next();
                grade = sc.next();
                points = sc.next();
                finalScore = sc.next();
                details = sc.next();
                wire = sc.next();
                grooveTime = sc.next();
                recoveryCase = sc.next();
                wind = sc.next();
                modex = sc.next();
                airFrame = sc.next();
                carrierType = sc.next();
                carrierName = sc.next();
                theater = sc.next();
                miTime = sc.next();
                miDate = sc.next();
                serverName = sc.next();
                serverDate = sc.next();
                serverTime = sc.next();
                flightTime = sc.next();


                log.add(new lsoGrades(callSign, grade, points, finalScore, details, wire,
                        grooveTime, recoveryCase, wind, modex,airFrame, carrierType,carrierName,
                        theater, miTime, miDate, serverName, serverDate, serverTime,flightTime));

            }
            sc.close();
            return log;
        }
    }

