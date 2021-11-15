package drawShapes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.application.Application;

public class DrawApp extends Application {
    @Override
    public void start(Stage stage) {
        MiniView miniView = new MiniView();
        MainUI mainUI = new MainUI(miniView);
        DrawingModel model = new DrawingModel();
        InteractionModel iModel = new InteractionModel();
        DrawingController controller = new DrawingController();

        mainUI.shapes.setiModel(iModel);
        mainUI.colors.setiModel(iModel);

        mainUI.canvas.setModel(model);
        controller.setModel(model);
        controller.setiModel(iModel);



//        model.addSubscriber(miniView);
        model.addSubscriber(mainUI.canvas);
        model.addSubscriber(mainUI.shapes);
        iModel.addSubscriber(mainUI.shapes);

        mainUI.canvas.setOnMousePressed(controller::handleMousePressed);
        mainUI.canvas.setOnMouseDragged(controller::handleMouseDragged);

//        mainUI.getChildren().addAll(shapeTB.getShapes(), main,colorTB.getColors());
//        root.getChildren().addAll(shapeTB.getShapes(), main,colorTB.getColors());
//        root.setLeft(shapeTB.getShapes());
//        shapes.prefWidthProperty().bind(myCanvas.widthProperty().multiply(0.20));
//        root.setCenter(main);
//        root.setRight(colorTB.getColors());
//        mainUI.shapes.prefHeightProperty().bind(stage.heightProperty());
//        mainUI.shapes.prefWidthProperty().bind(stage.heightProperty());
//        mainUI.prefHeightProperty().bind(stage.heightProperty());
//        mainUI.prefWidthProperty().bind(stage.widthProperty());
//        stage.widthProperty().addListener((observable, oldVal, newVal) -> {
//            mainUI.canvas.setPrefWidth(newVal.doubleValue());
//            mainUI.canvas.Draw();
//        });
//
//        stage.heightProperty().addListener((observable, oldVal, newVal) -> {
//            mainUI.canvas.setPrefHeight(newVal.doubleValue());
//            mainUI.canvas.Draw();
//        });

        Scene scene = new Scene(mainUI);
        stage.setTitle("Assignment 3");
        stage.setScene(scene);
        stage.show();

        mainUI.prefWidthProperty().bind(stage.widthProperty());
    }

    public static void main(String[] args) {
        launch();
    }
}