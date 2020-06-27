package sample;

import javafx.css.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PawnPos {
    List<Pawn> pawnPosList = new ArrayList<>();
    List<Pawn> nextAvailableMove=new ArrayList<>();

    public List<Pawn> getPawnPosList() {
        return pawnPosList;
    }

    public List<Pawn> getNextAvailableMove() {
        return nextAvailableMove;
    }

    public void addPawn(Pawn pawn) {
        pawnPosList.add(pawn);
    }
    public void removePawn(Pawn pawn){
        pawnPosList.remove(pawn);
    }
    public void clearNextAvailableMove(){
        nextAvailableMove.clear();
    }
    public void nextPos(Pawn pawn){

        for (Pawn pawn1:pawnPosList) {
            if (pawn1.equals(pawn)){
                clearNextAvailableMove();
                nextAvailableMove.add(new Pawn(Math.abs(pawn.getX()-1),Math.abs(pawn.getY()-1),pawn.getColor()));
                nextAvailableMove.add(new Pawn(Math.abs(pawn.getX()-1),pawn.getY()+1,pawn.getColor()));
                nextAvailableMove.add(new Pawn(pawn.getX()+1,Math.abs(pawn.getY()-1),pawn.getColor()));
                nextAvailableMove.add(new Pawn(pawn.getX()+1,pawn.getY()+1,pawn.getColor()));
            }
        }
    }

    public void showList() {
        for (Pawn pawn : nextAvailableMove) {
            System.out.println(pawn);
        }
    }


}
