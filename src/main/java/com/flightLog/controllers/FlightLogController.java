package com.flightLog.controllers;

import com.flightLog.models.flightLog;
import com.flightLog.models.pilotsLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;
import java.util.stream.Collectors;
import static com.flightLog.utilities.ReadFlightLogCSV.readFlightLogCSV;
import static com.flightLog.utilities.Service.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class FlightLogController extends stageController {





    public static void clearFlightLogs() {
        flightLogs.clear();
        callSigns.clear();
        pilotsLogs.clear();
        flightLogFiles.clear();
    }

    public static List<flightLog> loadFlightLog(String path) {
        try {
            return readFlightLogCSV(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static List<flightLog> sortPilotFlightLog(List<flightLog> list, String pilot) {
        return list.stream().filter(p -> p.callSign.contains(pilot))
                .collect(Collectors.toList());
    }

    public static String calculateFlightHours(List<flightLog> log, String aircraft) {
        double totalFlightTime = 0;
        for (com.flightLog.models.flightLog flightLog : log) {
            if (flightLog.aircraftType.contains(aircraft)) {
                totalFlightTime = totalFlightTime + parseDouble(flightLog.flightTime);
            }
        }
        int sec = (int) totalFlightTime % 60;
        int min = (int) (totalFlightTime / 60) % 60;
        int hours = (int) (totalFlightTime / 60) / 60;
        String strSec = (sec < 10) ? "0" + sec : Integer.toString(sec);
        String strMin = (min < 10) ? "0" + min : Integer.toString(min);
        String strHours = (hours < 10) ? "0" + hours : Integer.toString(hours);

        return (strHours + ":" + strMin + ":" + strSec);
    }

    public static int calculateCarrierTraps(List<flightLog> log, String airframe) {
        int traps = 0;
        for (com.flightLog.models.flightLog flightLog : log) {
            if (flightLog.arrivalField1.contains("CVN") && flightLog.aircraftType.contains(airframe)) {
                traps = traps + parseInt(flightLog.landings);
            }
        }
        return traps;
    }

    public static List<flightLog> sortPilotFlightLogYear(List<flightLog> list, String year) {
        return list.stream().filter(p -> p.getServerDate().substring(0,3).contentEquals(year))
                .collect(Collectors.toList());
    }
    public static List<flightLog> sortPilotFlightLogMonth(List<flightLog> list, String month) {
        return list.stream().filter(p -> p.getServerDate().substring(5,7).contentEquals(month))
                .collect(Collectors.toList());

    }
    public static List<flightLog> sortPilotByDate(List<flightLog> list, String date){
        return list.stream().filter(p -> p.getServerDate().contains(date))
                .collect(Collectors.toList());
    }
    public static List<flightLog> sortPilotFlightLogBoat(List<flightLog> list, String boat) {
        return list.stream().filter(p -> p.getArrivalField1().contains(boat))
                .collect(Collectors.toList());
    }
    public static int calculateMissionCarrierTraps(List<flightLog> log, String airframe) {
        int missionTraps = 0;
        for (com.flightLog.models.flightLog flightLog : log) {
            if (flightLog.arrivalField1.contains("CVN") && flightLog.aircraftType.contains(airframe) && parseDouble(flightLog.getFlightTime()) > 1200.0) {
                missionTraps = missionTraps + parseInt(flightLog.landings);
            }
        }
        return missionTraps;
    }

    public static int calculateLandings(List<flightLog> log, String airframe) {
        int landings = 0;
        for (com.flightLog.models.flightLog flightLog : log) {
            if (!flightLog.arrivalField1.contains("CVN") && flightLog.aircraftType.contains(airframe)) {
                landings = landings + parseInt(flightLog.landings);
            }
        }
        return landings;
    }

    public static int calculateDeaths(List<flightLog> log, String airframe, boolean airStart) {
        int deaths = 0;
        for (com.flightLog.models.flightLog flightLog : log) {
            if (!airStart) {
                if (flightLog.aircraftType.contains(airframe)) {
                    deaths = deaths + parseInt(flightLog.dead);
                }
            } else {
                if (flightLog.aircraftType.contains(airframe) && flightLog.getAirStart().contains("0")) {
                    deaths = deaths + parseInt(flightLog.dead);

                }
            }

        }
        return deaths;
    }

    public static int calculateCrashes(List<flightLog> log, String airframe, boolean airStart) {
        int crashes = 0;
        for (com.flightLog.models.flightLog flightLog : log) {
            if (!airStart) {
                if (flightLog.aircraftType.contains(airframe)) {
                    crashes = crashes + parseInt(flightLog.crashed);
                }
            } else {
                if (flightLog.aircraftType.contains(airframe) && flightLog.getAirStart().contains("0")) {
                    crashes = crashes + parseInt(flightLog.crashed);
                }
            }
        }
        return crashes;
    }

    public static int calculateEjected(List<flightLog> log, String airframe, boolean airStart) {
        int ejections = 0;
        for (com.flightLog.models.flightLog flightLog : log) {
            if (!airStart) {
                if (flightLog.aircraftType.contains(airframe)) {
                    ejections = ejections + parseInt(flightLog.ejected);
                }
            } else {
                if (flightLog.aircraftType.contains(airframe) && flightLog.getAirStart().contains("1")) {
                    ejections = ejections + parseInt(flightLog.ejected);
                }
            }
        }
        return ejections;
    }

    public static List<flightLog> getAirframes(List<flightLog> log) {
        List<flightLog> temp = new ArrayList<>(log);
        log.clear();
        log.addAll(temp);
        return log.stream()
                .filter(distinctByKey(flightLog::getAircraftType))
                .collect(Collectors.toList());
    }



    public static List<flightLog> getCallSigns(List<flightLog> log) {
        List<flightLog> temp = new ArrayList<>(log);
        log.clear();
        log.addAll(temp);
        return log.stream()
                .filter(distinctByKey(flightLog::getCallSign))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        String path = "C:\\Users\\fpere\\OneDrive\\Documents\\logs\\data_flight_logs(1).txt";
        List<flightLog> newLog = new ArrayList<>(loadFlightLog(path));
        List<flightLog> call = new ArrayList<>(getCallSigns(newLog));
        for (com.flightLog.models.flightLog flightLog : call) {
            System.out.println(flightLog.callSign);
            System.out.println("end");
        }
    }
}