package com.tencent.mm.plugin.scanner.model;

import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanPoint;", "", "()V", "id", "", "getId", "()I", "setId", "(I)V", "size", "", "getSize", "()F", "setSize", "(F)V", "x", "getX", "setX", "xFactor", "getXFactor", "setXFactor", "y", "getY", "setY", "yFactor", "getYFactor", "setYFactor", "plugin-scan_release"})
public final class ScanPoint {
    private int id;
    private float size;
    private float x;
    private float xFactor;
    private float y;
    private float yFactor;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final float getSize() {
        return this.size;
    }

    public final void setSize(float f2) {
        this.size = f2;
    }

    public final float getXFactor() {
        return this.xFactor;
    }

    public final void setXFactor(float f2) {
        this.xFactor = f2;
    }

    public final float getYFactor() {
        return this.yFactor;
    }

    public final void setYFactor(float f2) {
        this.yFactor = f2;
    }

    public final float getX() {
        return this.x;
    }

    public final void setX(float f2) {
        this.x = f2;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float f2) {
        this.y = f2;
    }
}
