package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g implements h {
    private int bjK;
    private final List<v.a> bqI;
    private final m[] bqJ;
    private boolean bqK;
    private int bqL;
    private long bqM;

    public g(List<v.a> list) {
        AppMethodBeat.i(92228);
        this.bqI = list;
        this.bqJ = new m[list.size()];
        AppMethodBeat.o(92228);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        this.bqK = false;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(com.google.android.exoplayer2.c.g gVar, v.d dVar) {
        AppMethodBeat.i(92229);
        for (int i2 = 0; i2 < this.bqJ.length; i2++) {
            v.a aVar = this.bqI.get(i2);
            dVar.uW();
            m dV = gVar.dV(dVar.getTrackId());
            dV.f(Format.a(dVar.uX(), "application/dvbsubs", Collections.singletonList(aVar.bsJ), aVar.language, (DrmInitData) null));
            this.bqJ[i2] = dV;
        }
        AppMethodBeat.o(92229);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        if (z) {
            this.bqK = true;
            this.bqM = j2;
            this.bjK = 0;
            this.bqL = 2;
        }
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
        AppMethodBeat.i(92230);
        if (this.bqK) {
            for (m mVar : this.bqJ) {
                mVar.a(this.bqM, 1, this.bjK, 0, null);
            }
            this.bqK = false;
        }
        AppMethodBeat.o(92230);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void t(com.google.android.exoplayer2.i.m mVar) {
        AppMethodBeat.i(92231);
        if (this.bqK) {
            if (this.bqL == 2 && !e(mVar, 32)) {
                AppMethodBeat.o(92231);
                return;
            } else if (this.bqL != 1 || e(mVar, 0)) {
                int i2 = mVar.position;
                int xd = mVar.xd();
                m[] mVarArr = this.bqJ;
                for (m mVar2 : mVarArr) {
                    mVar.setPosition(i2);
                    mVar2.a(mVar, xd);
                }
                this.bjK += xd;
            } else {
                AppMethodBeat.o(92231);
                return;
            }
        }
        AppMethodBeat.o(92231);
    }

    private boolean e(com.google.android.exoplayer2.i.m mVar, int i2) {
        AppMethodBeat.i(92232);
        if (mVar.xd() == 0) {
            AppMethodBeat.o(92232);
            return false;
        }
        if (mVar.readUnsignedByte() != i2) {
            this.bqK = false;
        }
        this.bqL--;
        boolean z = this.bqK;
        AppMethodBeat.o(92232);
        return z;
    }
}
