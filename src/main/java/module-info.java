module com.elie309.thesnake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.elie309.thesnake to javafx.fxml;
    exports com.elie309.thesnake;
    exports com.elie309.thesnake.GameEntities;
    opens com.elie309.thesnake.GameEntities to javafx.fxml;
    exports com.elie309.thesnake.Utils;
    opens com.elie309.thesnake.Utils to javafx.fxml;
}