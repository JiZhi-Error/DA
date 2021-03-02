package com.tencent.mm.storage;

public final class bh {
    public String OpA;
    public String OpB;
    public int Opv;
    private boolean Opw;
    public int Opx;
    public int Opy;
    public String Opz;
    public String productId;
    public String rjt;

    public bh() {
        this.Opw = false;
        this.Opv = -1;
    }

    public bh(String str) {
        this.Opw = false;
        this.productId = str;
        this.Opv = -1;
    }

    public final void akj(int i2) {
        if (!(this.Opv == -1 || this.Opv == i2 || i2 != 7)) {
            this.Opw = true;
        }
        this.Opv = i2;
    }
}
