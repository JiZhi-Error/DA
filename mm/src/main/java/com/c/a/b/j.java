package com.c.a.b;

public final class j extends i {
    public k cpi;
    int cpj;
    int mIndex;

    public j(k kVar) {
        this(kVar, 0, 0, null);
    }

    public j(k kVar, long j2) {
        this(kVar, j2, 0, null);
    }

    public j(k kVar, long j2, int i2, n nVar) {
        super(j2, nVar);
        this.cpi = k.UNKNOWN;
        this.cpi = kVar;
        this.cpj = i2;
    }

    public final String toString() {
        return String.format("%s@0x%08x", this.cpi.mName, Long.valueOf(this.MS));
    }

    public final i Km() {
        if (this.cpi == k.SYSTEM_CLASS) {
            return this.cpb.coS.aS(this.MS);
        }
        return this.cpb.coS.aR(this.MS);
    }
}
