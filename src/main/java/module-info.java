module a3.drawshapes {
    requires javafx.controls;
    requires javafx.fxml;


    opens a3.drawshapes to javafx.fxml;
    exports a3.drawshapes;
}