package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzzg extends zzze {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbrh;
    private int zzbri;
    private int zzbrj;
    private int zzbrk;

    private zzzg(byte[] bArr, int i2, int i3, boolean z) {
        super();
        AppMethodBeat.i(40348);
        this.zzbrk = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i3;
        this.pos = i2;
        this.zzbrj = this.pos;
        this.zzbrh = z;
        AppMethodBeat.o(40348);
    }

    private final void zzta() {
        this.limit += this.zzbri;
        int i2 = this.limit - this.zzbrj;
        if (i2 > this.zzbrk) {
            this.zzbri = i2 - this.zzbrk;
            this.limit -= this.zzbri;
            return;
        }
        this.zzbri = 0;
    }

    public final int zzaf(int i2) {
        AppMethodBeat.i(40349);
        if (i2 < 0) {
            zzzt zztn = zzzt.zztn();
            AppMethodBeat.o(40349);
            throw zztn;
        }
        int zzsz = zzsz() + i2;
        int i3 = this.zzbrk;
        if (zzsz > i3) {
            zzzt zztm = zzzt.zztm();
            AppMethodBeat.o(40349);
            throw zztm;
        }
        this.zzbrk = zzsz;
        zzta();
        AppMethodBeat.o(40349);
        return i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzze
    public final int zzsz() {
        return this.pos - this.zzbrj;
    }
}
