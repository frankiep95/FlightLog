package com.flightLog.models;

public class lsoGrades {
    public String callSign;
    public String grade;
    public String points;
    public String finalScore;
    public String details;
    public String wire;
    public String grooveTime;
    public String recoveryCase;
    public String wind;
    public String modex;
    public String airFrame;
    public String carrierType;
    public String carrierName;
    public String theater;
    public String miTime;
    public String miDate;
    public String serverName;
    public String serverDate;
    public String serverTime;
    public String flightTime;

    public lsoGrades(String callSign, String grade, String points, String finalScore, String details, String wire, String grooveTime, String recoveryCase, String wind, String modex, String airFrame, String carrierType, String carrierName, String theater, String miTime, String miDate, String serverName, String serverDate, String serverTime, String flightTime) {
        this.callSign = callSign.substring(12,callSign.length()-1);
        this.grade = grade.substring(9);
        this.points = points.substring(10);
        this.finalScore = finalScore;
        this.details = details;
        this.wire = wire.substring(8);
        this.grooveTime = grooveTime.substring(10);
        this.recoveryCase = recoveryCase;
        this.wind = wind;
        this.modex = modex;
        this.airFrame = airFrame.substring(13);
        this.carrierType = carrierType;
        this.carrierName = carrierName;
        this.theater = theater;
        this.miTime = miTime;
        this.miDate = miDate;
        this.serverName = serverName;
        this.serverDate = serverDate.substring(16,26);
        this.serverTime = serverTime.substring(16,24);
        this.flightTime = flightTime.substring(16,flightTime.length() -1);
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getWire() {
        return wire;
    }

    public void setWire(String wire) {
        this.wire = wire;
    }

    public String getGrooveTime() {
        return grooveTime;
    }

    public void setGrooveTime(String grooveTime) {
        this.grooveTime = grooveTime;
    }

    public String getRecoveryCase() {
        return recoveryCase;
    }

    public void setRecoveryCase(String recoveryCase) {
        this.recoveryCase = recoveryCase;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getModex() {
        return modex;
    }

    public void setModex(String modex) {
        this.modex = modex;
    }

    public String getAirFrame() {
        return airFrame;
    }

    public void setAirFrame(String airFrame) {
        this.airFrame = airFrame;
    }

    public String getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(String carrierType) {
        this.carrierType = carrierType;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getMiTime() {
        return miTime;
    }

    public void setMiTime(String miTime) {
        this.miTime = miTime;
    }

    public String getMiDate() {
        return miDate;
    }

    public void setMiDate(String miDate) {
        this.miDate = miDate;
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

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public String toString() {
        return "lsoGrades{" +
                "callSign='" + callSign + '\'' +
                ", grade='" + grade + '\'' +
                ", points='" + points + '\'' +
                ", finalScore='" + finalScore + '\'' +
                ", details='" + details + '\'' +
                ", wire='" + wire + '\'' +
                ", grooveTime='" + grooveTime + '\'' +
                ", recoveryCase='" + recoveryCase + '\'' +
                ", wind='" + wind + '\'' +
                ", modex='" + modex + '\'' +
                ", airFrame='" + airFrame + '\'' +
                ", carrierType='" + carrierType + '\'' +
                ", carrierName='" + carrierName + '\'' +
                ", theater='" + theater + '\'' +
                ", miTime='" + miTime + '\'' +
                ", miDate='" + miDate + '\'' +
                ", serverName='" + serverName + '\'' +
                ", serverDate='" + serverDate + '\'' +
                ", serverTime='" + serverTime + '\'' +
                ", flightTime='" + flightTime + '\'' +
                '}';
    }
}
