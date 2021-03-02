package com.tencent.mm.av.a.d;

import android.graphics.Bitmap;

public final class b {
    public Bitmap bitmap;
    public String contentType;
    public byte[] data;
    public int from;
    public int jbH;
    public boolean jbI;
    public boolean jbJ;
    public int status;

    public b() {
        this.jbH = 0;
        this.jbI = false;
        this.jbJ = false;
        this.status = -1;
    }

    public b(Bitmap bitmap2) {
        this.jbH = 0;
        this.jbI = false;
        this.jbJ = false;
        this.status = 0;
        this.from = 0;
        this.bitmap = bitmap2;
    }

    public b(byte[] bArr, String str) {
        this.jbH = 0;
        this.jbI = false;
        this.jbJ = false;
        this.data = bArr;
        this.contentType = str;
    }

    public b(byte[] bArr, String str, byte b2) {
        this.jbH = 0;
        this.jbI = false;
        this.jbJ = false;
        this.data = bArr;
        this.from = 2;
        this.contentType = str;
    }

    public final void tA(int i2) {
        this.jbH = i2;
    }
}
