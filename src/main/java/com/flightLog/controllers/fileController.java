package com.flightLog.controllers;

import com.flightLog.models.flightLog;
import com.flightLog.models.lsoGrades;
import com.flightLog.models.rangeGrades;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static com.flightLog.controllers.FlightLogController.*;
import static com.flightLog.controllers.lsoLogController.*;
import static com.flightLog.controllers.rangeLogController.*;
import static com.flightLog.utilities.Service.getListWithoutDuplicates;

public class fileController extends stageController{


    public static List<String> loadFlightLogFiles(File path,
                                                  List<String> flightLogFiles,
                                                  List<String> lsoLogFiles,
                                                  List<String> rangeLogFiles,
                                                  List<flightLog> flightLogs,
                                                  List<lsoGrades> lsoGradeLogs,
                                                  List<rangeGrades>rangeGradeLogs){
        int flightLogLength;
        int lsoLogLength;
        int rangeLogLength;
        clearFlightLogs();
        clearLSOLogs();
        clearRangeLogs();
        List<String> logNames = new ArrayList<>();
        try {
            FileInputStream fs = new FileInputStream(path);
            ObjectInputStream os = new ObjectInputStream(fs);
            flightLogLength = os.read();
            for(int a = 0; a < flightLogLength; a++) {
                flightLogFiles.add(os.readObject().toString());
            }
            lsoLogLength = os.read();
            for(int b = 0; b < lsoLogLength; b++){
               lsoLogFiles.add(os.readObject().toString());
            }
            rangeLogLength = os.read();
            for(int c = 0; c < rangeLogLength; c++){
                rangeLogFiles.add(os.readObject().toString());
            }

            os.close();
            fs.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int a = 1; a < flightLogFiles.size();a++){
            flightLogs.addAll(loadFlightLog(flightLogFiles.get(a)));
            logNames.add(flightLogFiles.get(a));
            System.out.println("Loading Flight Log File: " + flightLogFiles.get(a));
        }
        for(int b = 1; b < lsoLogFiles.size();b++){
            loadLsoLog(lsoGradeLogs,lsoLogFiles.get(b));
            logNames.add(lsoLogFiles.get(b));
            System.out.println("Loading LSO Log File: " + lsoLogFiles.get(b));
        }
        for(int c = 1; c < rangeLogFiles.size();c++){
            loadRangeLog(rangeGradeLogs,rangeLogFiles.get(c));
            logNames.add(rangeLogFiles.get(c));
            System.out.println("Loading Range Log File: " + rangeLogFiles.get(c));
        }

        System.out.println("Deleting duplicate log entries....");


        System.out.println("Flightlog size before: " + flightLogs.size());
        List<flightLog> cleanFlightLog = getListWithoutDuplicates(flightLogs,
                flightLog::getCallSign,flightLog::getServerDate,flightLog::getServerTime,
                 flightLog::getFlightTime, flightLog::getAircraftType,flightLog::getArrivalField1,
                flightLog::getArrivalField2,flightLog::getAirStart);
        flightLogs.clear();
        flightLogs.addAll(cleanFlightLog);
        System.out.println("Flight log size after: " + flightLogs.size());


        System.out.println("LSO log size before: " + lsoGradeLogs.size());
        List<lsoGrades> cleanLsoLog = getListWithoutDuplicates(lsoGradeLogs,
                lsoGrades::getCallSign,lsoGrades::getServerDate,
                lsoGrades::getServerName, lsoGrades::getServerTime);
        lsoGradeLogs.clear();
        lsoGradeLogs.addAll(cleanLsoLog);
        System.out.println("LSO log size after: " + lsoGradeLogs.size());


        System.out.println("Range log size before: " + rangeGradeLogs.size());
        List<rangeGrades> cleanRangeLog = getListWithoutDuplicates(rangeGradeLogs,
                rangeGrades::getCallSign, rangeGrades::getServerName,rangeGrades::getOsTime,
                rangeGrades::getOsDate);
        rangeGradeLogs.clear();
       rangeGradeLogs.addAll(cleanRangeLog);
        System.out.println("Range log size after: " + rangeGradeLogs.size());

       return logNames;

    }
    public static void saveLogFiles(File path,
                                    List<String> flightLogFiles,
                                    List<String> lsoLogFiles,
                                    List<String> rangeLogFiles){

        try{
            FileOutputStream fs = new FileOutputStream(path);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.write(flightLogFiles.size());
            for (String flightLogFile : flightLogFiles) {
                os.writeObject(flightLogFile);
            }
            os.write(lsoLogFiles.size());
            for (String lsoLogFile : lsoLogFiles) {
                os.writeObject(lsoLogFile);
            }
            os.write(rangeLogFiles.size());
            for (String rangeLogFile : rangeLogFiles) {
                os.writeObject(rangeLogFile);
            }
            os.close();
            fs.close();
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
