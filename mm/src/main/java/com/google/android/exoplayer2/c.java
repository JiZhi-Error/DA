package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.i.p;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;

public final class c implements m {
    private final k bbN;
    private final long bbO;
    private final long bbP;
    private final long bbQ;
    private final long bbR;
    private final p bbS;
    private int bbT;
    private boolean bbU;

    public c() {
        this(new k());
        AppMethodBeat.i(91857);
        AppMethodBeat.o(91857);
    }

    public c(k kVar) {
        this(kVar, 15000, CommonUtils.MAX_TIMEOUT_MS, 2500, 5000);
    }

    public c(k kVar, int i2, int i3, long j2, long j3) {
        this(kVar, i2, i3, j2, j3, (byte) 0);
    }

    private c(k kVar, int i2, int i3, long j2, long j3, byte b2) {
        AppMethodBeat.i(91858);
        this.bbN = kVar;
        this.bbO = ((long) i2) * 1000;
        this.bbP = ((long) i3) * 1000;
        this.bbQ = j2 * 1000;
        this.bbR = j3 * 1000;
        this.bbS = null;
        AppMethodBeat.o(91858);
    }

    @Override // com.google.android.exoplayer2.m
    public final void tf() {
        AppMethodBeat.i(91859);
        reset(false);
        AppMethodBeat.o(91859);
    }

    @Override // com.google.android.exoplayer2.m
    public final void a(r[] rVarArr, g gVar) {
        AppMethodBeat.i(91860);
        this.bbT = 0;
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            if (gVar.bED[i2] != null) {
                this.bbT += x.fi(rVarArr[i2].getTrackType());
            }
        }
        this.bbN.eX(this.bbT);
        AppMethodBeat.o(91860);
    }

    @Override // com.google.android.exoplayer2.m
    public final void onStopped() {
        AppMethodBeat.i(91861);
        reset(true);
        AppMethodBeat.o(91861);
    }

    @Override // com.google.android.exoplayer2.m
    public final void tg() {
        AppMethodBeat.i(91862);
        reset(true);
        AppMethodBeat.o(91862);
    }

    @Override // com.google.android.exoplayer2.m
    public final b th() {
        return this.bbN;
    }

    @Override // com.google.android.exoplayer2.m
    public final boolean b(long j2, boolean z) {
        long j3 = z ? this.bbR : this.bbQ;
        return j3 <= 0 || j2 >= j3;
    }

    private void reset(boolean z) {
        AppMethodBeat.i(91864);
        this.bbT = 0;
        if (this.bbS != null && this.bbU) {
            this.bbS.xr();
        }
        this.bbU = false;
        if (z) {
            this.bbN.reset();
        }
        AppMethodBeat.o(91864);
    }

    @Override // com.google.android.exoplayer2.m
    public final boolean x(long j2) {
        boolean z = false;
        AppMethodBeat.i(91863);
        boolean z2 = j2 > this.bbP ? false : j2 < this.bbO ? true : true;
        boolean z3 = this.bbN.wI() >= this.bbT;
        boolean z4 = this.bbU;
        if (z2 || (z2 && this.bbU && !z3)) {
            z = true;
        }
        this.bbU = z;
        if (!(this.bbS == null || this.bbU == z4)) {
            if (this.bbU) {
                p pVar = this.bbS;
                synchronized (pVar.lock) {
                    try {
                        pVar.bHs.add(0);
                        pVar.bHt = Math.max(pVar.bHt, 0);
                    } catch (Throwable th) {
                        AppMethodBeat.o(91863);
                        throw th;
                    }
                }
            } else {
                this.bbS.xr();
            }
        }
        boolean z5 = this.bbU;
        AppMethodBeat.o(91863);
        return z5;
    }
}
