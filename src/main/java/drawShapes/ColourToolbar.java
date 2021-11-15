package drawShapes;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class ColourToolbar extends VBox  {
    Button aqua;
    Button violet;
    Button green;
    Button gold;
    Button orange;
    Button coral;
    Button fuchsia ;
    Button peru;
    InteractionModel iModel;

    public ColourToolbar() {
        this.aqua = new Button("Aqua");
        this.violet = new Button("Violet");
        this.green = new Button("Green");
        this.gold = new Button("Gold");
        this.orange = new Button("Orange");
        this.coral = new Button("Coral");
        this.fuchsia  = new Button("Fuchsia");
        this.peru = new Button("Peru");

        aqua.setMaxWidth(Double.MAX_VALUE);
        aqua.setStyle("-fx-background-color: aqua; ");
        aqua.prefHeightProperty().bind(this.heightProperty());
        aqua.setOnAction(e -> this.iModel.selectedColor(Colour.AQUA));

        violet.setMaxWidth(Double.MAX_VALUE);
        violet.prefHeightProperty().bind(this.heightProperty());
        violet.setStyle("-fx-background-color: violet; ");
        violet.setOnAction(e -> this.iModel.selectedColor(Colour.VIOLET));

        green.setMaxWidth(Double.MAX_VALUE);
        green.prefHeightProperty().bind(this.heightProperty());
        green.setStyle("-fx-background-color: green; ");
        green.setOnAction(e -> this.iModel.selectedColor(Colour.GREEN));

        gold.setMaxWidth(Double.MAX_VALUE);
        gold.prefHeightProperty().bind(this.heightProperty());
        gold.setStyle("-fx-background-color: gold; ");
        gold.setOnAction(e -> this.iModel.selectedColor(Colour.GOLD));

        orange.setMaxWidth(Double.MAX_VALUE);
        orange.prefHeightProperty().bind(this.heightProperty());
        orange.setStyle("-fx-background-color: orange; ");
        orange.setOnAction(e -> this.iModel.selectedColor(Colour.ORANGE));

        coral.setMaxWidth(Double.MAX_VALUE);
        coral.prefHeightProperty().bind(this.heightProperty());
        coral.setStyle("-fx-background-color: coral; ");
        coral.setOnAction(e -> this.iModel.selectedColor(Colour.CORAL));


        fuchsia .setMaxWidth(Double.MAX_VALUE);
        fuchsia .prefHeightProperty().bind(this.heightProperty());
        fuchsia .setStyle("-fx-background-color: fuchsia ; ");
        fuchsia.setOnAction(e -> this.iModel.selectedColor(Colour.FUCHSIA));


        peru.setMaxWidth(Double.MAX_VALUE);
        peru.prefHeightProperty().bind(this.heightProperty());
        peru.setStyle("-fx-background-color: peru ; ");
        peru.setOnAction(e -> this.iModel.selectedColor(Colour.PERU));


        this.getChildren().addAll(aqua,violet,green,gold,orange,coral,fuchsia ,peru);
    }

    public void setiModel(InteractionModel iModel) {
        this.iModel = iModel;
    }

    public VBox getColors() {
        return this;
    }
}
