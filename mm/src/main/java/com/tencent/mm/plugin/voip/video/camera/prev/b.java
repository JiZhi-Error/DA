package com.tencent.mm.plugin.voip.video.camera.prev;

import android.graphics.Point;

public final class b {
    private String HjV = null;
    public int HjW = 30;
    public boolean HjX = false;
    public boolean HjY = true;
    public int HjZ = 0;
    public int Hka;
    public Point Hkb;
    public Point Hkc;
    public int gFx = 1;

    public b(String str) {
        this.HjV = str;
        this.HjW = 15;
        this.gFx = 1;
        this.HjX = false;
        this.HjY = true;
        this.HjZ = 0;
        this.Hka = 0;
        this.Hkb = null;
        this.Hkc = null;
    }

    public final Point fLq() {
        return this.Hkb;
    }

    public final Point fLr() {
        return this.Hkc;
    }

    public final int fLs() {
        return this.HjW;
    }

    public final int aRA() {
        return this.gFx;
    }

    public final boolean fLt() {
        return this.HjX;
    }

    public final boolean fLu() {
        return this.HjY;
    }
}
