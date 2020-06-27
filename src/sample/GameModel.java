package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ListIterator;

public class GameModel {
    GameView gameView;
    PawnPos pos;
    BoardSquare [][] fields;
    Color colorPawn;
    BoardSquare tmp;
    public GameModel(GameView gameView,BoardSquare [][] fields) {
        this.gameView = gameView;
        this.fields=fields;
        this.pos=new PawnPos();
    }
    public void initGamePawnPosition(BoardSquare [][] fields){
        for (int i = 0 ; i < fields[0].length ; i++) {
            if (fields[0][i].getColor()== Color.GREEN){
                pos.addPawn(fields[0][i].createPawn(0,i,Color.AZURE));
            }
        }
        pos.addPawn(fields[fields.length-1][0].createPawn(fields.length-1,0,Color.RED));
    }
    public Color getColorPawn(){

        return colorPawn;
    }

    public void setTmp(BoardSquare tmp) {

        this.tmp = tmp;
    }

    public BoardSquare getTmp() {

        return tmp;
    }

    public void availableNextMove(Pawn pawn){
                    pos.nextPos(pawn);
                    pos.showList();
     };
    public void addListener(){
        for (int i = 0; i <fields.length ; i++) {
            for (int j = 0; j <fields.length ; j++) {
                if(fields[i][j].getColor()==Color.GREEN) {
                    int finalI = i;
                    int finalJ = j;
                    fields[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                                if (fields[finalI][finalJ].getFocusColor()==Color.YELLOW&&fields[finalI][finalJ].getPawn()==null){
                                    move(fields[finalI][finalJ],finalI,finalJ);

                                }
                                if(fields[finalI][finalJ].getPawn()!=null) {
                                    setTmp(fields[finalI][finalJ]);
                                    colorPawn=fields[finalI][finalJ].getPawn().getColor();
                                    availableNextMove(fields[finalI][finalJ].getPawn());
                                    showAvailableMove();

                                }

                                if(mouseEvent.getClickCount() == 2){
                                    fields[finalI][finalJ].blacken();
                                    hideAvailableMove();
                                    pos.clearNextAvailableMove();
                                }
                            }
                        }
                    });
                }
            }

        }
    }
    private void showAvailableMove(){
        for (Pawn pawn:pos.getNextAvailableMove()
             ) {
            if (pawn.getX()<8&&pawn.getY()<8){
                        fields[pawn.getX()][pawn.getY()].highlight();
            }
        }
    }
    private void hideAvailableMove(){
        for (Pawn pawn:pos.getNextAvailableMove()
        ) {
            if (pawn.getX()<8&&pawn.getY()<8){
                fields[pawn.getX()][pawn.getY()].blacken();
            }
        }
    }
    private void deleteOldPawn(){
        ListIterator iterator = pos.getPawnPosList().listIterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(getTmp().getPawn())) {
                pos.removePawn(getTmp().getPawn());
                getTmp().hidePawn();
                getTmp().deletePawn();
            }

        }
    }
    private void move(BoardSquare boardSquare,int row,int col){
            pos.addPawn(boardSquare.createPawn(row, col, getColorPawn()));
            deleteOldPawn();
    }


}











