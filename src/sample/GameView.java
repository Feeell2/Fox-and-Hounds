package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameView extends Application {
    private BoardSquare [][] fields;
    PawnPos pos;

    GameModel gameModel;
    public static void main(String[] args) {
        GameView.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
      fields=new BoardSquare[8][8];
      gameModel=new GameModel(this,fields);
      Scene scane= new Scene(createView(),600,600);
        stage.setTitle("Fox and Hounds");
        stage.setScene(scane);
        stage.show();

    }
    public BoardSquare[][] getFields() {
        return fields;
    }
    private VBox createView(){
        VBox mainView=new VBox();
        mainView.setSpacing(10);
        mainView.setPadding(new Insets(10,0,10,0));
        BackgroundFill fill=new BackgroundFill(Color.AZURE,CornerRadii.EMPTY,Insets.EMPTY);
        mainView.setBackground(new Background(fill));
        mainView.getChildren().addAll(createMenu(),createdBoard());
        return mainView;
    }
    private HBox createMenu(){
        HBox menu=new HBox();
        menu.setAlignment(Pos.BOTTOM_CENTER);
        Button button=new Button("New Game");
        menu.getChildren().add(button);
        return menu;
    };
    private GridPane createdBoard(){
        GridPane board=new GridPane();
        board.setAlignment(Pos.CENTER);
        for (int row = 0; row < 8 ; row++) {
            for (int col = 0; col < 8; col++) {
                board.add(createBoardSquare(row,col),col,row);
            }
        }
        for (int row = 0; row < 8; row++) {
            RowConstraints constrains = new RowConstraints();
            constrains.setPercentHeight(100/8);
            board.getRowConstraints().add(constrains);
        }
        for (int col = 0; col < 8; col++) {
            ColumnConstraints constrains = new ColumnConstraints();
            constrains.setPercentWidth(100/8);
            board.getColumnConstraints().add(constrains);
        }
        gameModel.initGamePawnPosition(fields);
        gameModel.addListener();
        return board;
    }
    private StackPane createBoardSquare(int row, int col){
        if (row%2==0){
            if(col%2==0){
                fields[row][col]=new BoardSquare(Color.BLACK,gameModel);
            }else{
                fields[row][col]=new BoardSquare(Color.GREEN,gameModel);
            }

        }else {
            if(col%2!=0){
                fields[row][col]=new BoardSquare(Color.BLACK,gameModel);
            }else{
                fields[row][col]=new BoardSquare(Color.GREEN,gameModel);
            }
        }

        return fields[row][col];
    }


}
