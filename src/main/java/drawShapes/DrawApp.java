// Shaheq Shakeel 11196448
package drawShapes;
import javafx.scene.Scene;
import javafx.stage.Stage;
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


        model.addSubscriber(mainUI.canvas);
        model.addSubscriber(mainUI.shapes);
        iModel.addSubscriber(mainUI.shapes);

        mainUI.canvas.setOnMousePressed(controller::handleMousePressed);
        mainUI.canvas.setOnMouseDragged(controller::handleMouseDragged);

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