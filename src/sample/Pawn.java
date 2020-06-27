package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pawn extends Circle {
    private int x;
    private int y;
    private int nextX;
    private int nextY;
    private Color color;


    public int getNextY() {

        return nextY;
    }

    public void setNextY(int nextY) {

        this.nextY = nextY;
    }




    public Pawn( int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        setFill(color);
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pawn other = (Pawn) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (((Pawn) obj).getX() !=other.getX() && ((Pawn) obj).getY() !=other.getY() )
            return false;
        return true;

    }
}
