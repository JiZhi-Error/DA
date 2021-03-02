package com.tencent.mm.b;

/* access modifiers changed from: package-private */
public final class j {
    public byte[] array;
    public int begin;

    public j() {
        this.begin = 0;
        this.array = new byte[256];
    }

    public j(byte b2) {
        this.begin = 0;
        this.array = new byte[]{b2};
    }

    public j(byte[] bArr) {
        this.begin = 0;
        this.array = bArr;
    }
}
