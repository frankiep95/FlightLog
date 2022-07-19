package com.flightLog.models;

public class TrapStats {

    public String name;
    public int traps;
    public Double trapAVG;
    public Double boardingAVG;
    public Double WireAVG;
    public Double GrooveAVG;

    public TrapStats(String name, int traps, Double trapAVG, Double boardingAVG, Double wireAVG, Double grooveAVG) {
        this.name = name;
        this.traps = traps;
        this.trapAVG = trapAVG;
        this.boardingAVG = boardingAVG;
        WireAVG = wireAVG;
        GrooveAVG = grooveAVG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTraps() {
        return traps;
    }

    public void setTraps(int traps) {
        this.traps = traps;
    }

    public Double getTrapAVG() {
        return trapAVG;
    }

    public void setTrapAVG(Double trapAVG) {
        this.trapAVG = trapAVG;
    }

    public Double getBoardingAVG() {
        return boardingAVG;
    }

    public void setBoardingAVG(Double boardingAVG) {
        this.boardingAVG = boardingAVG;
    }

    public Double getWireAVG() {
        return WireAVG;
    }

    public void setWireAVG(Double wireAVG) {
        WireAVG = wireAVG;
    }

    public Double getGrooveAVG() {
        return GrooveAVG;
    }

    public void setGrooveAVG(Double grooveAVG) {
        GrooveAVG = grooveAVG;
    }

    @Override
    public String toString() {
        return "TrapStats{" +
                "name='" + name + '\'' +
                ", traps=" + traps +
                ", trapAVG=" + trapAVG +
                ", boardingAVG=" + boardingAVG +
                ", WireAVG=" + WireAVG +
                ", GrooveAVG=" + GrooveAVG +
                '}';
    }
}
