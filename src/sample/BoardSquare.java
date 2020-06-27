package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BoardSquare extends StackPane {
    private Color color;
    private Region field;
    private Pawn pawn;
    GameModel gameModel;
    private PawnPos pos;
    private Color focusColor;

    public BoardSquare(Color defaultColor,GameModel model) {
        color = defaultColor;
        gameModel=model;
        createField(color);
        getChildren().addAll(field);
        setPrefSize(200,200);
    }
    public Pawn getPawn() {
        return pawn;
    }
    public Color getColor(){

        return color;
    }
    public Color getFocusColor(){

        return focusColor;
    }
    public void highlight(){
        setColorSquare(Color.YELLOW);
        focusColor=Color.YELLOW;
    }
    public void blacken(){
        setColorSquare(color);
        focusColor=color;
    }
    public void showPawn() {
        pawn.setVisible(true);
    }
    public void hidePawn() {
        pawn.setVisible(false);
    }
    public boolean isPawnVisible() {
        if (pawn!=null)
            return true;
        return false;
    }
    public void setColorSquare(Color color){
        BackgroundFill bgFill=new BackgroundFill(color, CornerRadii.EMPTY,new Insets(2));
        Background bg =new Background(bgFill);
        field.setBackground(bg);
    }
    public void changeColor(Color color){
        pawn.setFill(color);
    }
    public void deletePawn(){
        pawn=null;
    }
    private void createField(Color color){
        field=new Region();

        setColorSquare(color);
    };
    public Pawn createPawn(int x,int y,Color color) {
        NumberBinding radiusProperty = Bindings.when(widthProperty().greaterThan(heightProperty()))
                .then(heightProperty().subtract(12).divide(2))
                .otherwise(widthProperty().subtract(12).divide(2));
        pawn = new Pawn(x,y,color);
        pawn.radiusProperty().bind(radiusProperty);
        pawn.setVisible(true);
        getChildren().add(pawn);
        return pawn;
    }



}


