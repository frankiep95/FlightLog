package com.flightLog.models;

public  class flightLog{
    public String callSign;
    public String flightTime;
    public String aircraftType;
    public String takeoffs;
    public String landings;
    public String departureField;
    public String arrivalField1;
    public String arrivalField2;
    public String coalition;
    public String missionType;
    public String serverName;
    public String serverDate;
    public String serverTime;
    public String theater;
    public String dead;
    public String crashed;
    public String ejected;
    public String refueled;
    public String failure;
    public String airStart;
    public String missionEnd;
    public String deptTime;
    public String arrivalTime;

    public flightLog(String callSign, String flightTime, String aircraftType, String takeoffs,
                     String landings, String departureField, String arrivalField1, String arrivalField2,
                     String coalition, String missionType, String serverName, String serverDate, String serverTime,
                     String theater, String dead, String crashed, String ejected, String refueled,
                     String failure, String airStart, String missionEnd, String deptTime, String arrivalTime) {
        this.callSign = callSign.substring(14);
        this.flightTime = flightTime.substring(15);
        this.aircraftType = aircraftType.substring(17);
        this.takeoffs = takeoffs;
        this.landings = landings.substring(13);
        this.departureField = departureField;
        this.arrivalField1 = arrivalField1.substring(18);
        this.arrivalField2 = arrivalField2;
        this.coalition = coalition;
        this.missionType = missionType;
        this.serverName = serverName;
        this.serverDate = serverDate.substring(16,26);
        this.serverTime = serverTime.substring(16,24);
        this.theater = theater;
        this.dead = dead.substring(9);
        this.crashed = crashed.substring(12);
        this.ejected = ejected.substring(12);
        this.refueled = refueled;
        this.failure = failure;
        this.airStart = airStart.substring(11);
        this.missionEnd = missionEnd;
        this.deptTime = deptTime;
        this.arrivalTime = arrivalTime;

    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getTakeoffs() {
        return takeoffs;
    }

    public void setTakeoffs(String takeoffs) {
        this.takeoffs = takeoffs;
    }

    public String getLandings() {
        return landings;
    }

    public void setLandings(String landings) {
        this.landings = landings;
    }

    public String getDepartureField() {
        return departureField;
    }

    public void setDepartureField(String departureField) {
        this.departureField = departureField;
    }

    public String getArrivalField1() {
        return arrivalField1;
    }

    public void setArrivalField1(String arrivalFiled1) {
        this.arrivalField1 = arrivalFiled1;
    }

    public String getArrivalField2() {
        return arrivalField2;
    }

    public void setArrivalField2(String arrivalField2) {
        this.arrivalField2 = arrivalField2;
    }

    public String getCoalition() {
        return coalition;
    }

    public void setCoalition(String coalition) {
        this.coalition = coalition;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerDate() {
        return serverDate;
    }

    public void setServerDate(String serverDate) {
        this.serverDate = serverDate;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getCrashed() {
        return crashed;
    }

    public void setCrashed(String crashed) {
        this.crashed = crashed;
    }

    public String getEjected() {
        return ejected;
    }

    public void setEjected(String ejected) {
        this.ejected = ejected;
    }

    public String getRefueled() {
        return refueled;
    }

    public void setRefueled(String refueled) {
        this.refueled = refueled;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public String getAirStart() {
        return airStart;
    }

    public void setAirStart(String airStart) {
        this.airStart = airStart;
    }

    public String getMissionEnd() {
        return missionEnd;
    }

    public void setMissionEnd(String missionEnd) {
        this.missionEnd = missionEnd;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void display(){
        System.out.println(callSign);
    }

    @Override
    public String toString() {
        return "flightLog{" +
                "callSign='" + callSign + '\'' +
                ", flightTime='" + flightTime + '\'' +
                ", aircraftType='" + aircraftType + '\'' +
                ", takeoffs='" + takeoffs + '\'' +
                ", landings='" + landings + '\'' +
                ", departureField='" + departureField + '\'' +
                ", arrivalField1='" + arrivalField1 + '\'' +
                ", arrivalField2='" + arrivalField2 + '\'' +
                ", coalition='" + coalition + '\'' +
                ", missionType='" + missionType + '\'' +
                ", serverName='" + serverName + '\'' +
                ", serverDate='" + serverDate + '\'' +
                ", serverTime='" + serverTime + '\'' +
                ", theater='" + theater + '\'' +
                ", dead='" + dead + '\'' +
                ", crashed='" + crashed + '\'' +
                ", ejected='" + ejected + '\'' +
                ", refueled='" + refueled + '\'' +
                ", failure='" + failure + '\'' +
                ", airStart='" + airStart + '\'' +
                ", missionEnd='" + missionEnd + '\'' +
                ", deptTime='" + deptTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}

