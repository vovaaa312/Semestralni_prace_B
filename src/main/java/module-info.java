module com.example.semestralni_prace_b {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.GUI to javafx.fxml;
    exports com.example.GUI;
}