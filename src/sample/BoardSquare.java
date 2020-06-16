package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BoardSquare extends StackPane {
    private Color color;
    private Region field;
    public BoardSquare(Color defaultColor) {
        color = defaultColor;
        createField(color);
        getChildren().add(field);
        setPrefSize(200,200);
    }
    public void highlight(){
        setColor(Color.YELLOW);
    }
    public void blacken(){
        setColor(color);
    }
    public void setColor(Color color){
        BackgroundFill bgFill=new BackgroundFill(color, CornerRadii.EMPTY,new Insets(2));
        Background bg =new Background(bgFill);
        field.setBackground(bg);
    }
    private void createField(Color color){
        field=new Region();
        setColor(color);
    };

}
