package com.flightLog.utilities;

import com.flightLog.models.flightLog;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFlightLogCSV {
    public static ArrayList<flightLog> readFlightLogCSV(String file) throws Exception {
        String callSign = "";
        String flightTime = "";
        String aircraftType = "";
        String takeoffs = "";
        String landings = "";
        String departureField = "";
        String arrivalFiled1 = "";
        String arrivalField2 = "";
        String coalition = "";
        String missionType = "";
        String serverName = "";
        String serverDate = "";
        String serverTime = "";
        String theater = "";
        String dead = "";
        String crashed = "";
        String ejected = "";
        String refueled = "";
        String failure = "";
        String airStart = "";
        String missionEnd = "";
        String deptTime = "";
        String arrivalTime = "";
        ArrayList<flightLog> log = new ArrayList<flightLog>();



        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter("\\{\"Callsign\":");
        while (sc.hasNext()) {
            sc.useDelimiter(",");
            callSign = sc.next();
            flightTime = sc.next();
            aircraftType = sc.next();
            takeoffs = sc.next();
            landings = sc.next();
            departureField = sc.next();
            arrivalFiled1 = sc.next();
            arrivalField2 = sc.next();
            coalition = sc.next();
            missionType = sc.next();
            serverName = sc.next();
            serverDate = sc.next();
            serverTime = sc.next();
            theater = sc.next();
            dead = sc.next();
            crashed = sc.next();
            ejected = sc.next();
            refueled = sc.next();
            failure = sc.next();
            airStart = sc.next();
            missionEnd = sc.next();
            deptTime = sc.next();
            arrivalTime = sc.next();

            log.add(new flightLog(callSign, flightTime, aircraftType, takeoffs, landings, departureField,
                    arrivalFiled1, arrivalField2, coalition, missionType, serverName, serverDate, serverTime,
                    theater, dead, crashed, ejected, refueled, failure, airStart, missionEnd, deptTime, arrivalTime));

        }
        sc.close();
        return log;
    }
}