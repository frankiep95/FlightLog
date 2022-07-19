package com.flightLog.controllers;

import com.flightLog.models.flightLog;
import com.flightLog.models.lsoGrades;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.flightLog.utilities.Service.distinctByKey;
import static com.flightLog.utilities.readLsoGradesCSV.readLsoGradesCSV;

public class lsoLogController extends stageController{


    public static void clearLSOLogs(){
        lsoLogs.clear();
        lsoLogFiles.clear();
    }
    public static List<lsoGrades> loadLsoLog(List<lsoGrades> log, String path){
        try{
            log.addAll(readLsoGradesCSV(path));
        } catch(Exception e){
            e.printStackTrace();
        }
        return log;
    }
    public static List<lsoGrades> sortPilotLsoLog(List<lsoGrades> log, String pilot){
        return log.stream().filter(p -> p.callSign.contains(pilot))
                .collect(Collectors.toList());
    }
    public static List<lsoGrades> sortPilotTrapsYear(List<lsoGrades> log, String year){
        return log.stream().filter(p ->p.getServerDate().substring(6).contains(year))
                .collect(Collectors.toList());
    }
    public static List<lsoGrades> sortPilotTrapsMonth(List<lsoGrades> log, String month){
        return log.stream().filter(p -> p.getServerDate().substring(2,5).contains(month))
                .collect(Collectors.toList());
    }

    public static List<lsoGrades> sortPilotByAircraft(List<lsoGrades> log, String aircraft){
        return log.stream().filter(p -> p.getServerDate().substring(2,5).contains(aircraft))
                .collect(Collectors.toList());
    }

    public static List<lsoGrades> getLsoCallSigns(List<lsoGrades> log) {
        List<lsoGrades> temp = new ArrayList<>(log);
        log.clear();
        log.addAll(temp);
        return log.stream()
                .filter(distinctByKey(lsoGrades::getCallSign))
                .collect(Collectors.toList());
    }

    public static int calculateLsoGrades(List<lsoGrades> list, String airframe){
        int grades =1;
        for (com.flightLog.models.lsoGrades lsoGrades : list) {
            if (lsoGrades.airFrame.contains(airframe)) {
                grades = grades + 1;
            }
        }
        return grades;
    }


}
