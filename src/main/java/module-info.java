module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.test to javafx.fxml;
    exports com.test;
    opens com.test.view to javafx.fxml;
    exports com.test.controller;
    opens com.test.controller to javafx.fxml;
}