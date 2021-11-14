package drawShapes;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.application.Application;

public class DrawApp extends Application {
    @Override
    public void start(Stage stage) {
        HBox mainUI = new HBox();
        StackPane root = new StackPane();

        DrawingView main = new DrawingView();
        ShapeToolbar shapeTB = new ShapeToolbar();
        ColourToolbar colorTB = new ColourToolbar();
        DrawingModel model = new DrawingModel();
        InteractionModel iModel = new InteractionModel();
        DrawingController controller = new DrawingController();

        shapeTB.setiModel(iModel);
        colorTB.setiModel(iModel);

        model.addSubscriber(main);
        model.addSubscriber(shapeTB);
        iModel.addSubscriber(shapeTB);

        main.setModel(model);
        controller.setModel(model);
        controller.setiModel(iModel);


        main.setOnMousePressed(controller::handleMousePressed);
        main.setOnMouseDragged(controller::handleMouseDragged);

        mainUI.getChildren().addAll(shapeTB.getShapes(), main,colorTB.getColors());
        root.getChildren().add(mainUI);

        Scene scene = new Scene(root);
        stage.setTitle("Assignment 3");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}