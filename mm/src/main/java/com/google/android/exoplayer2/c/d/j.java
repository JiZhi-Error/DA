package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j {
    public final Format bdF;
    public final long bdJ;
    public final int biD;
    public final long boo;
    public final long bop;
    public final int boq;
    public final long[] bor;
    public final long[] bos;
    private final k[] bot;
    public final int id;
    public final int type;

    public j(int i2, int i3, long j2, long j3, long j4, Format format, int i4, k[] kVarArr, int i5, long[] jArr, long[] jArr2) {
        this.id = i2;
        this.type = i3;
        this.boo = j2;
        this.bop = j3;
        this.bdJ = j4;
        this.bdF = format;
        this.boq = i4;
        this.bot = kVarArr;
        this.biD = i5;
        this.bor = jArr;
        this.bos = jArr2;
    }

    public final k ei(int i2) {
        if (this.bot == null) {
            return null;
        }
        return this.bot[i2];
    }
}
