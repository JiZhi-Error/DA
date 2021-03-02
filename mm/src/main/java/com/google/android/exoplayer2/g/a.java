package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends b {
    private final d bDT;
    private final int bDU;
    private final long bDV;
    private final long bDW;
    private final long bDX;
    private final float bDY;
    private int bDZ = 1;
    private int bxP = ak(Long.MIN_VALUE);

    /* renamed from: com.google.android.exoplayer2.g.a$a  reason: collision with other inner class name */
    public static final class C0111a implements f.a {
        private final d bDT;
        private final int bDU;
        private final float bDY;
        private final int bEa;
        private final int bEb;
        private final int bEc;

        public C0111a(d dVar) {
            this(dVar, (byte) 0);
        }

        private C0111a(d dVar, byte b2) {
            this.bDT = dVar;
            this.bDU = 800000;
            this.bEa = 10000;
            this.bEb = 25000;
            this.bEc = 25000;
            this.bDY = 0.75f;
        }

        @Override // com.google.android.exoplayer2.g.f.a
        public final /* synthetic */ f a(q qVar, int[] iArr) {
            AppMethodBeat.i(92925);
            a aVar = new a(qVar, iArr, this.bDT, this.bDU, (long) this.bEa, (long) this.bEb, (long) this.bEc, this.bDY);
            AppMethodBeat.o(92925);
            return aVar;
        }
    }

    public a(q qVar, int[] iArr, d dVar, int i2, long j2, long j3, long j4, float f2) {
        super(qVar, iArr);
        AppMethodBeat.i(92926);
        this.bDT = dVar;
        this.bDU = i2;
        this.bDV = 1000 * j2;
        this.bDW = 1000 * j3;
        this.bDX = 1000 * j4;
        this.bDY = f2;
        AppMethodBeat.o(92926);
    }

    @Override // com.google.android.exoplayer2.g.f
    public final void af(long j2) {
        AppMethodBeat.i(92927);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.bxP;
        this.bxP = ak(elapsedRealtime);
        if (this.bxP == i2) {
            AppMethodBeat.o(92927);
            return;
        }
        if (!l(i2, elapsedRealtime)) {
            Format format = this.bwD[i2];
            Format format2 = this.bwD[this.bxP];
            if (format2.bitrate > format.bitrate && j2 < this.bDV) {
                this.bxP = i2;
            } else if (format2.bitrate < format.bitrate && j2 >= this.bDW) {
                this.bxP = i2;
            }
        }
        if (this.bxP != i2) {
            this.bDZ = 3;
        }
        AppMethodBeat.o(92927);
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int getSelectedIndex() {
        return this.bxP;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int vP() {
        return this.bDZ;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final Object vQ() {
        return null;
    }

    private int ak(long j2) {
        int i2 = 0;
        AppMethodBeat.i(92928);
        long wE = this.bDT.wE();
        long j3 = wE == -1 ? (long) this.bDU : (long) (((float) wE) * this.bDY);
        for (int i3 = 0; i3 < this.length; i3++) {
            if (j2 != Long.MIN_VALUE && l(i3, j2)) {
                i2 = i2;
            } else if (((long) this.bwD[i3].bitrate) <= j3) {
                AppMethodBeat.o(92928);
                return i3;
            } else {
                i2 = i3;
            }
        }
        AppMethodBeat.o(92928);
        return i2;
    }
}
