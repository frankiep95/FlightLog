package com.flightLog.models;

public class pilotsLog {
    public String pilotName;
    public String airFrame;
    public String hours;
    public int traps;
    public int missionTraps;
    public int landings;
    public int deaths;
    public int crashes;
    public int ejections;

    public pilotsLog(String pilotName) {
        this.pilotName = pilotName;
    }

    public pilotsLog(String pilotName, String airFrame, String hours, int traps, int missionTraps, int landings, int deaths, int crashes, int ejections) {
        this.pilotName = pilotName;
        this.airFrame = airFrame;
        this.hours = hours;
        this.traps = traps;
        this.missionTraps = missionTraps;
        this.landings = landings;
        this.deaths = deaths;
        this.crashes = crashes;
        this.ejections = ejections;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getAirFrame() {
        return airFrame;
    }

    public void setAirFrame(String airFrame) {
        this.airFrame = airFrame;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getTraps() {
        return traps;
    }

    public void setTraps(int traps) {
        this.traps = traps;
    }

    public int getMissionTraps() {
        return missionTraps;
    }

    public void setMissionTraps(int missionTraps) {
        this.missionTraps = missionTraps;
    }

    public int getLandings() {
        return landings;
    }

    public void setLandings(int landings) {
        this.landings = landings;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getCrashes() {
        return crashes;
    }

    public void setCrashes(int crashes) {
        this.crashes = crashes;
    }

    public int getEjections() {
        return ejections;
    }

    public void setEjections(int ejections) {
        this.ejections = ejections;
    }
}
