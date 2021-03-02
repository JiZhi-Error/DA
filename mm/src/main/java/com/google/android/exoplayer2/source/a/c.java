package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.x;
import java.util.Arrays;

public abstract class c extends a {
    private volatile boolean bwg;
    public byte[] data;
    private int limit;

    /* access modifiers changed from: protected */
    public abstract void f(byte[] bArr, int i2);

    public c(g gVar, j jVar, Format format, int i2, Object obj, byte[] bArr) {
        super(gVar, jVar, 3, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    @Override // com.google.android.exoplayer2.source.a.a
    public final long vN() {
        return (long) this.limit;
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final void vA() {
        this.bwg = true;
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final boolean vB() {
        return this.bwg;
    }

    @Override // com.google.android.exoplayer2.h.t.c
    public final void vC() {
        int i2 = 0;
        try {
            this.bhK.a(this.bxj);
            this.limit = 0;
            while (i2 != -1 && !this.bwg) {
                if (this.data == null) {
                    this.data = new byte[16384];
                } else if (this.data.length < this.limit + 16384) {
                    this.data = Arrays.copyOf(this.data, this.data.length + 16384);
                }
                i2 = this.bhK.read(this.data, this.limit, 16384);
                if (i2 != -1) {
                    this.limit += i2;
                }
            }
            if (!this.bwg) {
                f(this.data, this.limit);
            }
        } finally {
            x.a(this.bhK);
        }
    }
}
