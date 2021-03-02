package android.support.constraint.solver.widgets;

public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public void setBounds(int i2, int i3, int i4, int i5) {
        this.x = i2;
        this.y = i3;
        this.width = i4;
        this.height = i5;
    }

    /* access modifiers changed from: package-private */
    public void grow(int i2, int i3) {
        this.x -= i2;
        this.y -= i3;
        this.width += i2 * 2;
        this.height += i3 * 2;
    }

    /* access modifiers changed from: package-private */
    public boolean intersects(Rectangle rectangle) {
        return this.x >= rectangle.x && this.x < rectangle.x + rectangle.width && this.y >= rectangle.y && this.y < rectangle.y + rectangle.height;
    }

    public boolean contains(int i2, int i3) {
        return i2 >= this.x && i2 < this.x + this.width && i3 >= this.y && i3 < this.y + this.height;
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }
}
