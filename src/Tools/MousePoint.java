package Tools;
public class MousePoint {
    private int x;
    private int y;
    public MousePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public MousePoint clickedPoint() {
        return this;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
