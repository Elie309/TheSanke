module com.elie309.thesnake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.elie309.thesnake to javafx.fxml;
    exports com.elie309.thesnake;
}