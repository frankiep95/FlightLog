package com.flightLog.controllers;

import com.flightLog.models.TrapStats;
import com.flightLog.models.lsoGrades;

import java.util.List;

import static com.flightLog.controllers.FlightLogController.sortPilotByDate;
import static com.flightLog.controllers.FlightLogController.sortPilotFlightLog;
import static com.flightLog.controllers.lsoLogController.*;


public class TrapStatsController {
    static Integer logCounter = 0;
     static   Double trapAVG;
     static Double boardingAVG;
     static   Double wireAVG;
     static Double grooveAVG;

    public static void clearTrapStats(){
        trapAVG = 0.0;
        boardingAVG = 0.0;
        wireAVG = 0.0;
        grooveAVG = 0.0;
        logCounter = 0;
    }
    public static void runTrapStats(String pilot, List<String> year, List<String> month,List<lsoGrades> trapList){
        for(int a = 0; a < year.size(); a++){
            for(int b = 0; b < month.size(); b++) {
                trapStats(pilot, year.get(a), month.get(b), trapList);
            }
        }
    }
    public static void trapStats(String pilot, String year, String month, List<lsoGrades> trapList){
        populateFlightTime(pilot, year, month);
        logCounter = logCounter + trapList.size();
        for (int a = 0; a < trapList.size(); a++){
            if(!trapList.get(a).getCallSign().contains("VT")
                    && trapList.get(a).getAirFrame().contains("F-14")
                    && Double.parseDouble(trapList.get(a).getFlightTime().replaceAll("\"" ,"0")) >= 1200){
                trapAVG = trapAVG + Double.parseDouble(trapList.get(a).getPoints());
                if (!(trapList.get(a).getWire().contains("\"\""))) {
                    wireAVG = wireAVG + Double.parseDouble(trapList.get(a).getWire());
                }
                if(trapList.get(a).getWire().contains("\"\"")){
                    boardingAVG++;
                }
                if (!(trapList.get(a).getGrooveTime().contains("\"\""))) {
                    grooveAVG = grooveAVG + Double.parseDouble(trapList.get(a).getGrooveTime());
                }
            }else logCounter--;
        }
    }
    private static void populateFlightTime(String pilot, String year, String month) {
        String day;
        pilotLsoLog.clear();
        pilotTrapMonth.clear();
        pilotTrapYear.clear();
        pilotFlightLog.clear();
        pilotTrapMission.clear();
        pilotFlightLogBoat.clear();
        pilotLsoLog.addAll(sortPilotLsoLog(lsoLogs, pilot));
        pilotTrapYear.addAll(sortPilotTrapsYear(pilotLsoLog, year));
        pilotTrapMonth.addAll(sortPilotTrapsMonth(pilotTrapYear, month));
        pilotFlightLog.addAll(sortPilotFlightLog(flightLogs, pilot));
        for(int a = 0; a < pilotTrapMonth.size(); a++) {
            pilotFlightLogBoat.clear();
            int hours = 0;
            int minutes = 0;
            int seconds = 0;
            int totalSeconds1 = 0;
            int totalSeconds2 = 0;
            day = pilotTrapMonth.get(a).getServerDate().substring(0, 2);
            pilotFlightLogBoat.addAll(sortPilotByDate(pilotFlightLog, year + "/" + month + "/" + day));
            for (int b = 0; b < pilotFlightLogBoat.size(); b++) {
                hours = Integer.parseInt(pilotFlightLogBoat.get(b).getServerTime().substring(0, 2));
                minutes = Integer.parseInt(pilotFlightLogBoat.get(b).getServerTime().substring(3, 5));
                seconds = Integer.parseInt(pilotFlightLogBoat.get(b).getServerTime().substring(6));
                totalSeconds1 = (hours * 3600) + (minutes * 60) + seconds;
                hours = Integer.parseInt(pilotTrapMonth.get(a).getServerTime().substring(0, 2));
                minutes = Integer.parseInt(pilotTrapMonth.get(a).getServerTime().substring(3, 5));
                seconds = Integer.parseInt(pilotTrapMonth.get(a).getServerTime().substring(6));
                totalSeconds2 = (hours * 3600) + (minutes * 60) + seconds;
                if ((totalSeconds1 - totalSeconds2) < 35 && (totalSeconds1 - totalSeconds2) > -35 ) {
                    pilotTrapMonth.get(a).setFlightTime(pilotFlightLogBoat.get(b).getFlightTime());
                }
            }
        }
    }

    public static void trapOutput(String pilot, Integer logCounter, Double trapAVG, Double boardingAVG, Double wireAVG, Double grooveAVG, List<TrapStats> list){
        if(trapAVG > 0){trapAVG = trapAVG/logCounter;}
        if(boardingAVG  > 0){boardingAVG=  (boardingAVG/logCounter)* 100;}
        if(wireAVG > 0){ wireAVG = wireAVG/logCounter;}
        if(grooveAVG > 0){ grooveAVG = grooveAVG/logCounter;}
        trapAVG = Math.round(trapAVG * 100.0) / 100.0;
        boardingAVG = Math.round(boardingAVG * 100.0) / 100.0;
        wireAVG = Math.round(wireAVG* 100.0) / 100.0;
        grooveAVG = Math.round(grooveAVG* 100.0) / 100.0;
        list.add(new TrapStats(pilot,logCounter,trapAVG,boardingAVG,wireAVG,grooveAVG));
    }
}
