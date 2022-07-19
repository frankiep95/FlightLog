package com.flightLog.controllers;



import com.flightLog.models.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static com.flightLog.controllers.FlightLogController.*;
import static com.flightLog.controllers.TrapStatsController.*;
import static com.flightLog.controllers.fileController.loadFlightLogFiles;
import static com.flightLog.controllers.fileController.saveLogFiles;
import static com.flightLog.controllers.lsoLogController.*;
import static com.flightLog.controllers.rangeLogController.*;


public class stageController{
    static ObservableList<pilotsLog> pilotsLogs = FXCollections.observableArrayList();
    static ArrayList<lsoGrades> lsoLogs= new ArrayList<>();
    static List<String> lsoLogFiles = new ArrayList<>();
    static List<lsoGrades> squadronLsoLog = new ArrayList<>();
    static List<lsoGrades> pilotLsoLog = new ArrayList<>();
    static List<rangeGrades> pilotRangeLog = new ArrayList<>();
    static List<String> rangeLogFiles = new ArrayList<>();
    static ArrayList<rangeGrades> rangeLogs = new ArrayList<>();
    static List<flightLog> pilotFlightLog = new ArrayList<>();
    static List<flightLog> pilotFlightLogYear = new ArrayList<>();
    static List<flightLog> pilotFlightLogMonth = new ArrayList<>();
    static List<flightLog> squadronFlightLog = new ArrayList<>();

    static List<flightLog> pilotFlightLogBoat = new ArrayList<>();
    static ArrayList<flightLog> flightLogs = new ArrayList<>();
    static List<flightLog> callSigns = new ArrayList<>();
    static List<lsoGrades> lsoCallSigns = new ArrayList<>();

    static List<String> flightLogFiles = new ArrayList<>();
    static List<lsoGrades> pilotTrapMonth = new ArrayList<>();
    static List<lsoGrades> pilotTrapYear = new ArrayList<>();
    static List<lsoGrades> pilotTrapMission = new ArrayList<>();
    static ObservableList<TrapStats> trapsStats = FXCollections.observableArrayList();
    static String username = System.getProperty("user.name");
    static String part1 = "C:\\Users\\";
    static String part2 = "\\AppData\\Local\\";
    static File filePath = new File(part1 + username + part2 +"./logFiles");
    static double trapAVG = 0.0;
    double boardingAVG = 0.0;
    double wireAVG = 0.0;
    double grooveAVG = 0.0;
    int logCounter  = 0;
    List<String> logFileNames;
    List<String> year = List.of(new String[]{"2022"});
    List<String> month = List.of(new String[]{"04","05","06"});

    @FXML
    private TextField pilotName;
    @FXML
    private RadioButton airStartCheck;

    @FXML
    private TableView<TrapStats> trapLogsTable;
    @FXML
    private TableColumn<TrapStats,String> trapAVGPilotName;
    @FXML
    private TableColumn<TrapStats, Integer> trapAVGTraps;
    @FXML
    private TableColumn<TrapStats,Double>  trapAVGT;
    @FXML
    private TableColumn<TrapStats,Double>  trapAVGBoarding;
    @FXML
    private TableColumn<TrapStats,Double>   trapAVGWire;
    @FXML
    private TableColumn<TrapStats,Double>  trapAVGGroove;


    @FXML
    private TableView<pilotsLog> tableLogs;
    @FXML
    private TableColumn<pilotsLog,String> pilotNameTable;
    @FXML
    private TableColumn<pilotsLog,String> airFrameTable;
    @FXML
    private TableColumn<pilotsLog,String> flightHoursTable;
    @FXML
    private TableColumn<pilotsLog,Integer> trapsTable;
    @FXML
    private TableColumn<pilotsLog,Integer> missionTrapsTable;
    @FXML
    private TableColumn<pilotsLog,Integer> landingsTable;
    @FXML
    private TableColumn<pilotsLog,Integer> deathsTable;
    @FXML
    private TableColumn<pilotsLog,Integer> crashesTable;
    @FXML
    private TableColumn<pilotsLog,Integer> ejectionsTable;
    @FXML
    private Text logCount;
    @FXML
    private Rectangle dropBox;
    @FXML
    private ChoiceBox<String> logFiles;
    @FXML
    private Button removeLogButton;
    @FXML
    private Button excludeLogButton;

    @FXML
    protected void searchAll() {
        pilotFlightLog.clear();
        callSigns.clear();
        pilotsLogs.clear();
        callSigns.addAll(getCallSigns(flightLogs));

        for (int b = 0; b < callSigns.size(); b++) {
            pilotFlightLog.clear();
            pilotFlightLog.addAll(sortPilotFlightLog(flightLogs,callSigns.get(b).getCallSign()));
            airframes.clear();
            pilotsLogs.addAll(getPilotLogByAirframe(callSigns.get(b).getCallSign(), airStartCheck.isSelected()));
        }
        displayTable(pilotsLogs);
        for(int a =0; a < callSigns.size(); a++) {
            runTrapStats(callSigns.get(a).callSign, year, month,pilotTrapMonth);
        }
        displayTrapStats(trapsStats);
        int logSize = flightLogs.size();
        logCount.setText("Showing " + logSize + " Logs");
    }
    @FXML
    protected void onSearchPilot() {
        pilotLsoLog.clear();
        pilotFlightLog.clear();
        pilotRangeLog.getClass();
        airframes.clear();
        String name = pilotName.getText();
        pilotFlightLog.addAll(sortPilotFlightLog(flightLogs,name));
        pilotLsoLog.addAll(sortPilotLsoLog(lsoLogs,name));
        pilotRangeLog.addAll(sortPilotRangeLog(rangeLogs,name));
        displayTable(getPilotLogByAirframe( name,airStartCheck.isSelected()));
        trapsStats.clear();
        runTrapStats(name,year,month,pilotTrapMonth);
        displayTrapStats(trapsStats);
    }

    @FXML
        public void initialize(){
        clearFlightLogs();
        clearRangeLogs();
        clearLSOLogs();
        logFileNames = (loadFlightLogFiles(filePath,flightLogFiles,lsoLogFiles,rangeLogFiles,flightLogs,lsoLogs,rangeLogs));
        searchAll();
        for(int a =0; a < callSigns.size(); a++) {
            clearTrapStats();
            runTrapStats(callSigns.get(a).callSign, year, month,pilotTrapMonth);
            trapOutput(callSigns.get(a).callSign,logCounter,trapAVG,boardingAVG,wireAVG,grooveAVG,trapsStats);
        }
        displayTrapStats(trapsStats);
        logFiles.getItems().addAll(logFileNames);
        System.out.println("Initialized!");
    }
    public void displayTable(ObservableList<pilotsLog> tableData){
        pilotNameTable.setCellValueFactory(new PropertyValueFactory<>("pilotName"));
        airFrameTable.setCellValueFactory(new PropertyValueFactory<>("airFrame"));
        flightHoursTable.setCellValueFactory(new PropertyValueFactory<>("hours"));
        trapsTable.setCellValueFactory(new PropertyValueFactory<>("traps"));
        missionTrapsTable.setCellValueFactory(new PropertyValueFactory<>("missionTraps"));
        landingsTable.setCellValueFactory(new PropertyValueFactory<>("landings"));
        deathsTable.setCellValueFactory(new PropertyValueFactory<>("deaths"));
        crashesTable.setCellValueFactory(new PropertyValueFactory<>("crashes"));
        ejectionsTable.setCellValueFactory(new PropertyValueFactory<>("ejections"));
        tableLogs.setItems(tableData);
    }
    static List<flightLog> airframes = new ArrayList<>();
    public static ObservableList<pilotsLog> getPilotLogByAirframe( String pilot, boolean airStart) {
        List<flightLog> log = pilotFlightLog;

        airframes = getAirframes(log);
        ObservableList<pilotsLog> list = FXCollections.observableArrayList();
        for (com.flightLog.models.flightLog flightLog : airframes) {
            String airframe = flightLog.aircraftType;
            list.add(new pilotsLog(pilot, airframe, calculateFlightHours(log, airframe),
                    calculateCarrierTraps(log, airframe), calculateMissionCarrierTraps(log, airframe),
                    calculateLandings(log, airframe), calculateDeaths(log, airframe, airStart),
                    calculateCrashes(log, airframe, airStart), calculateEjected(log, airframe, airStart)));
        }
        return list;
    }

    public void displayTrapStats(ObservableList<TrapStats> statsLog){
        trapAVGPilotName.setCellValueFactory(new PropertyValueFactory<>("name"));
        trapAVGTraps.setCellValueFactory(new PropertyValueFactory<>("traps"));
        trapAVGT.setCellValueFactory(new  PropertyValueFactory<>("trapAVG"));
        trapAVGBoarding.setCellValueFactory(new PropertyValueFactory<>("boardingAVG"));
        trapAVGWire.setCellValueFactory(new PropertyValueFactory<>("WireAVG"));
        trapAVGGroove.setCellValueFactory(new PropertyValueFactory<>("GrooveAVG"));
        trapLogsTable.setItems(statsLog);
    }




    public void mouseDragOver(DragEvent e){
        Dragboard db = e.getDragboard();
        boolean isAccepted = db.getFiles().get(0).getName().toLowerCase().endsWith(".txt");
        if(db.hasFiles()){
            if(isAccepted){
                dropBox.setStyle("-fx-border-width: 5;" +
                        "-fx-border-color: #ff0000;");
                e.acceptTransferModes(TransferMode.LINK);
            }
        }else {
            e.consume();
        }
    }
    public  void handleDragDropped(DragEvent event){
        System.out.println("drag dropped");
        Dragboard db = event.getDragboard();
        File file = db.getFiles().get(0);
        boolean duplicate = false;
        if(file.getAbsolutePath().contains("flight")){
            System.out.println("Flight Log");
            for (String flightLogFile : flightLogFiles) {
                if (file.getAbsolutePath().contentEquals(flightLogFile)) {
                    duplicate = true;
                }
            }
            if(!duplicate) {
                flightLogFiles.add(file.getAbsolutePath());
            }else System.out.println("Duplicate Flight Log!");
        }
        if(file.getAbsolutePath().contains("lso")){
            System.out.println("LSO log");
            for (String lsoLogFile : lsoLogFiles) {
                if (file.getAbsolutePath().contentEquals(lsoLogFile)) {
                    duplicate = true;
                }
            }
            if (!duplicate) {
                lsoLogFiles.add(file.getAbsolutePath());
            }else System.out.println("Duplicate LSO Log!");
        }
        if(file.getAbsolutePath().contains("range")){
            System.out.println("Range Log");
            for (String rangeLogFile : rangeLogFiles) {
                if (file.getAbsolutePath().contentEquals(rangeLogFile)) {
                    duplicate = true;
                }
            }
            if(!duplicate) {
                rangeLogFiles.add(file.getAbsolutePath());
            }else System.out.println("Duplicate Range Log!");
        }
        if(!duplicate) {
            saveLogFiles(filePath,flightLogFiles,lsoLogFiles,rangeLogFiles);
            displayLogFiles(loadFlightLogFiles(filePath,flightLogFiles,lsoLogFiles,rangeLogFiles,flightLogs,lsoLogs,rangeLogs));
            searchAll();
        }
    }
    public void displayLogFiles(List<String> logNames){
        logFiles.getSelectionModel().clearSelection();
        logFiles.getItems().clear();
        logFiles.getItems().addAll(logNames);

    }

    public void onExcludeButtonPressed(){
        String selected = logFiles.getSelectionModel().getSelectedItem();

    }

    public void onRemoveButtonPressed(){
        String selected = logFiles.getSelectionModel().getSelectedItem();
        flightLogFiles.remove(selected);
        saveLogFiles(filePath,flightLogFiles,lsoLogFiles,rangeLogFiles);
        displayLogFiles(loadFlightLogFiles(filePath,flightLogFiles,lsoLogFiles,rangeLogFiles,flightLogs,lsoLogs,rangeLogs));
        searchAll();
    }

    public void exitClicked(){
        Platform.exit();
    }
    public void restoreClicked(){
        Stage s = (Stage) mainPage.getScene().getWindow();
        s.setFullScreen(false);
    }
    @FXML
    private AnchorPane mainPage;
    public void  minimizeClicked(){
        ((Stage) mainPage.getScene().getWindow()).setIconified(true);
    }
}
