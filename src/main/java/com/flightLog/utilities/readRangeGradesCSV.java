package com.flightLog.utilities;


import com.flightLog.models.rangeGrades;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class readRangeGradesCSV {
    public static ArrayList<rangeGrades> readRangeGradesCSV(String file) throws Exception {
        String callSign = "";
        String aircraftType = "";
        String weaponType = "";
        String impactDistance = "";
        String impactRadial = "";
        String impactQuality = "";
        String bombScore = "";
        String altitude = "";
        String pitch = "";
        String strafeAccuracy = "";
        String strafeQuality = "";
        String strafeScore = "";
        String roundsFired = "";
        String roundsHit = "";
        String theater = "";
        String rangeName = "";
        String missionType = "";
        String mizTime = "";
        String mizDate = "";
        String osDate = "";
        String osTIme = "";
        String servername = "";
        ArrayList<rangeGrades> log = new ArrayList<>();



        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter("\\{\"pilot\":");
        while (sc.hasNext()) {
            sc.useDelimiter(",");
            callSign = sc.next();
            aircraftType = sc.next();
           weaponType = sc.next();
            impactDistance = sc.next();
          impactRadial = sc.next();
            impactQuality = sc.next();
            bombScore = sc.next();
            altitude = sc.next();
            pitch = sc.next();
            strafeAccuracy= sc.next();
            strafeQuality= sc.next();
           strafeScore = sc.next();
            roundsFired = sc.next();
            roundsHit = sc.next();
            theater = sc.next();
            rangeName = sc.next();
            missionType = sc.next();
            mizTime = sc.next();
            mizDate = sc.next();
            osDate = sc.next();
            osTIme = sc.next();
            servername = sc.next();

            log.add(new rangeGrades(callSign, aircraftType, weaponType, impactDistance, impactRadial, impactQuality,
                    bombScore,altitude, pitch, strafeAccuracy, strafeQuality,strafeScore, roundsFired,roundsHit,
                    theater, rangeName, missionType, mizTime, mizDate, osDate,osTIme,servername));

        }
        sc.close();
        return log;
    }
}
