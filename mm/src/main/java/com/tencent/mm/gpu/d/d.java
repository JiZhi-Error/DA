package com.tencent.mm.gpu.d;

public final class d {
    long hjn;
    int id = 0;
    int type = 0;

    public d(int i2, int i3, long j2) {
        this.type = i2;
        this.id = i3;
        this.hjn = j2;
    }

    public final boolean equals(Object obj) {
        d dVar = (d) obj;
        if (dVar.type == this.type && dVar.hjn == this.hjn && dVar.id == this.id) {
            return true;
        }
        return false;
    }
}
