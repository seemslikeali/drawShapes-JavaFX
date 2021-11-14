module a3.drawshapes {
    requires javafx.controls;
    requires javafx.fxml;


    opens a3 to javafx.fxml;
    exports a3;
}