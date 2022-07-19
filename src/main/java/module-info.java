module com.example.flightlog {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.flightLog to javafx.fxml;
    exports com.flightLog;
    exports com.flightLog.controllers;
    exports com.flightLog.models;
    opens com.flightLog.controllers to javafx.fxml;

}