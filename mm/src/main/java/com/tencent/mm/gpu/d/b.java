package com.tencent.mm.gpu.d;

public final class b {
    long id;
    int type;

    public b(int i2, long j2) {
        this.type = i2;
        this.id = j2;
    }

    public final boolean equals(Object obj) {
        d dVar = (d) obj;
        if (dVar.type == this.type && ((long) dVar.id) == this.id) {
            return true;
        }
        return false;
    }
}
