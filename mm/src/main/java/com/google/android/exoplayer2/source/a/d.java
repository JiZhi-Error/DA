package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.a;

public abstract class d extends a {
    public final int bxp;

    public d(g gVar, j jVar, Format format, int i2, Object obj, long j2, long j3, int i3) {
        super(gVar, jVar, 1, format, i2, obj, j2, j3);
        a.checkNotNull(format);
        this.bxp = i3;
    }
}
