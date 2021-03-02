package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.t;

public abstract class a implements t.c {
    protected final g bhK;
    public final j bxj;
    public final Format bxk;
    public final int bxl;
    public final Object bxm;
    public final long bxn;
    public final long bxo;
    public final int type;

    public abstract long vN();

    public a(g gVar, j jVar, int i2, Format format, int i3, Object obj, long j2, long j3) {
        this.bhK = (g) com.google.android.exoplayer2.i.a.checkNotNull(gVar);
        this.bxj = (j) com.google.android.exoplayer2.i.a.checkNotNull(jVar);
        this.type = i2;
        this.bxk = format;
        this.bxl = i3;
        this.bxm = obj;
        this.bxn = j2;
        this.bxo = j3;
    }
}
