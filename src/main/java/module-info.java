module a3.drawshapes {
    requires javafx.controls;
    requires javafx.fxml;


    opens drawShapes to javafx.fxml;
    exports drawShapes;
}