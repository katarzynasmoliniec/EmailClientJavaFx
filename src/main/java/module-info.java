module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.mail;

    opens com.test to javafx.fxml;
    exports com.test;
    exports com.test.controller;
    opens com.test.controller to javafx.fxml;
    exports com.test.view;
}