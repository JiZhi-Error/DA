package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class n {
    final w.b bch = new w.b();
    final w.a bci = new w.a();
    w bco;
    int repeatMode;

    public static final class a {
        public final k.b bdH;
        public final long bdI;
        public final long bdJ;
        public final boolean bdK;
        public final boolean bdL;
        public final long bde;
        public final long bdf;

        /* synthetic */ a(k.b bVar, long j2, long j3, long j4, long j5, boolean z, boolean z2, byte b2) {
            this(bVar, j2, j3, j4, j5, z, z2);
        }

        a(k.b bVar, long j2, long j3, long j4, long j5, boolean z, boolean z2) {
            this.bdH = bVar;
            this.bde = j2;
            this.bdI = j3;
            this.bdf = j4;
            this.bdJ = j5;
            this.bdK = z;
            this.bdL = z2;
        }

        public final a tx() {
            AppMethodBeat.i(92379);
            a aVar = new a(this.bdH.eA(-1), this.bde, this.bdI, this.bdf, this.bdJ, this.bdK, this.bdL);
            AppMethodBeat.o(92379);
            return aVar;
        }
    }

    public n() {
        AppMethodBeat.i(92380);
        AppMethodBeat.o(92380);
    }

    public final k.b g(int i2, long j2) {
        AppMethodBeat.i(92381);
        this.bco.a(i2, this.bci, false);
        int E = this.bci.E(j2);
        if (E == -1) {
            k.b bVar = new k.b(i2);
            AppMethodBeat.o(92381);
            return bVar;
        }
        k.b bVar2 = new k.b(i2, E, this.bci.ber[E]);
        AppMethodBeat.o(92381);
        return bVar2;
    }

    public final a a(a aVar, int i2) {
        AppMethodBeat.i(92382);
        a a2 = a(aVar, aVar.bdH.eA(i2));
        AppMethodBeat.o(92382);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final a a(a aVar, k.b bVar) {
        long j2;
        AppMethodBeat.i(92383);
        long j3 = aVar.bde;
        long j4 = aVar.bdI;
        boolean b2 = b(bVar, j4);
        boolean a2 = a(bVar, b2);
        this.bco.a(bVar.bwx, this.bci, false);
        if (bVar.isAd()) {
            j2 = this.bci.bb(bVar.bwy, bVar.bwz);
        } else if (j4 == Long.MIN_VALUE) {
            j2 = this.bci.bdJ;
        } else {
            j2 = j4;
        }
        a aVar2 = new a(bVar, j3, j4, aVar.bdf, j2, b2, a2, (byte) 0);
        AppMethodBeat.o(92383);
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public final a a(k.b bVar, long j2, long j3) {
        long j4;
        AppMethodBeat.i(92384);
        this.bco.a(bVar.bwx, this.bci, false);
        if (!bVar.isAd()) {
            int F = this.bci.F(j3);
            if (F == -1) {
                j4 = Long.MIN_VALUE;
            } else {
                j4 = this.bci.beo[F];
            }
            a c2 = c(bVar.bwx, j3, j4);
            AppMethodBeat.o(92384);
            return c2;
        } else if (!this.bci.ba(bVar.bwy, bVar.bwz)) {
            AppMethodBeat.o(92384);
            return null;
        } else {
            a b2 = b(bVar.bwx, bVar.bwy, bVar.bwz, j2);
            AppMethodBeat.o(92384);
            return b2;
        }
    }

    /* access modifiers changed from: package-private */
    public final a b(int i2, int i3, int i4, long j2) {
        long j3;
        AppMethodBeat.i(92385);
        k.b bVar = new k.b(i2, i3, i4);
        boolean b2 = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b2);
        long bb = this.bco.a(bVar.bwx, this.bci, false).bb(bVar.bwy, bVar.bwz);
        if (i4 == this.bci.ber[i3]) {
            j3 = this.bci.bet;
        } else {
            j3 = 0;
        }
        a aVar = new a(bVar, j3, Long.MIN_VALUE, j2, bb, b2, a2, (byte) 0);
        AppMethodBeat.o(92385);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final a c(int i2, long j2, long j3) {
        long j4;
        AppMethodBeat.i(92386);
        k.b bVar = new k.b(i2);
        boolean b2 = b(bVar, j3);
        boolean a2 = a(bVar, b2);
        this.bco.a(bVar.bwx, this.bci, false);
        if (j3 == Long.MIN_VALUE) {
            j4 = this.bci.bdJ;
        } else {
            j4 = j3;
        }
        a aVar = new a(bVar, j2, j3, -9223372036854775807L, j4, b2, a2, (byte) 0);
        AppMethodBeat.o(92386);
        return aVar;
    }

    private boolean b(k.b bVar, long j2) {
        boolean z;
        AppMethodBeat.i(92387);
        int tF = this.bco.a(bVar.bwx, this.bci, false).tF();
        if (tF == 0) {
            AppMethodBeat.o(92387);
            return true;
        }
        int i2 = tF - 1;
        boolean isAd = bVar.isAd();
        if (this.bci.beo[i2] == Long.MIN_VALUE) {
            int i3 = this.bci.bep[i2];
            if (i3 == -1) {
                AppMethodBeat.o(92387);
                return false;
            }
            if (isAd && bVar.bwy == i2 && bVar.bwz == i3 - 1) {
                z = true;
            } else {
                z = false;
            }
            if (z || (!isAd && this.bci.ber[i2] == i3)) {
                AppMethodBeat.o(92387);
                return true;
            }
            AppMethodBeat.o(92387);
            return false;
        } else if (isAd || j2 != Long.MIN_VALUE) {
            AppMethodBeat.o(92387);
            return false;
        } else {
            AppMethodBeat.o(92387);
            return true;
        }
    }

    private boolean a(k.b bVar, boolean z) {
        AppMethodBeat.i(92388);
        if (this.bco.a(this.bco.a(bVar.bwx, this.bci, false).bdi, this.bch).bex || !this.bco.b(bVar.bwx, this.bci, this.bch, this.repeatMode) || !z) {
            AppMethodBeat.o(92388);
            return false;
        }
        AppMethodBeat.o(92388);
        return true;
    }
}
