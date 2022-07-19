package com.flightLog.controllers;

import com.flightLog.models.rangeGrades;


import java.util.List;
import java.util.stream.Collectors;
import static com.flightLog.utilities.readRangeGradesCSV.readRangeGradesCSV;

public class rangeLogController extends stageController{



    public static void clearRangeLogs(){
        rangeLogs.clear();
        rangeLogFiles.clear();
    }
    public static List<rangeGrades> sortPilotRangeLog(List<rangeGrades> log,String pilot){
       //log.clear();
        return log.stream().filter(p -> p.callSign.contains(pilot))
                .collect(Collectors.toList());
    }
    public static List<rangeGrades> loadRangeLog(List<rangeGrades> log, String path){
        try{
            log.addAll(readRangeGradesCSV(path));
        }catch (Exception e){
            e.printStackTrace();
        }
        return log;
    }


}
