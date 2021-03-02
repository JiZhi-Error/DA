package com.tencent.tav.decoder;

public class Rectangle {
    public float height;
    public float width;
    public float x;
    public float y;

    public Rectangle() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Rectangle(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }
}
