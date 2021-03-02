package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public abstract class h {
    private g bir;
    private m bky;
    private long boW;
    private f bpA;
    long bpB;
    private long bpC;
    private a bpD;
    private long bpE;
    private boolean bpF;
    private boolean bpG;
    private final d bpz = new d();
    private int sampleRate;
    int state;

    /* access modifiers changed from: protected */
    public abstract boolean a(com.google.android.exoplayer2.i.m mVar, long j2, a aVar);

    /* access modifiers changed from: protected */
    public abstract long s(com.google.android.exoplayer2.i.m mVar);

    /* access modifiers changed from: package-private */
    public static class a {
        Format bdF;
        f bpA;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar, m mVar) {
        this.bir = gVar;
        this.bky = mVar;
        reset(true);
    }

    /* access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.bpD = new a();
            this.bpB = 0;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.boW = -1;
        this.bpC = 0;
    }

    /* access modifiers changed from: package-private */
    public final void f(long j2, long j3) {
        boolean z = false;
        d dVar = this.bpz;
        dVar.boR.reset();
        dVar.bpj.reset();
        dVar.bpk = -1;
        dVar.bpm = false;
        if (j2 == 0) {
            if (!this.bpF) {
                z = true;
            }
            reset(z);
        } else if (this.state != 0) {
            this.boW = this.bpA.R(j3);
            this.state = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int l(f fVar) {
        boolean z = true;
        while (z) {
            if (!this.bpz.k(fVar)) {
                this.state = 3;
                return -1;
            }
            this.bpE = fVar.getPosition() - this.bpB;
            z = a(this.bpz.bpj, this.bpB, this.bpD);
            if (z) {
                this.bpB = fVar.getPosition();
            }
        }
        this.sampleRate = this.bpD.bdF.sampleRate;
        if (!this.bpG) {
            this.bky.f(this.bpD.bdF);
            this.bpG = true;
        }
        if (this.bpD.bpA != null) {
            this.bpA = this.bpD.bpA;
        } else if (fVar.getLength() == -1) {
            this.bpA = new b((byte) 0);
        } else {
            e eVar = this.bpz.boR;
            this.bpA = new a(this.bpB, fVar.getLength(), this, eVar.bkI + eVar.bpu, eVar.bpp);
        }
        this.bpD = null;
        this.state = 2;
        d dVar = this.bpz;
        if (dVar.bpj.data.length == 65025) {
            return 0;
        }
        dVar.bpj.data = Arrays.copyOf(dVar.bpj.data, Math.max(65025, dVar.bpj.limit));
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int b(f fVar, k kVar) {
        long i2 = this.bpA.i(fVar);
        if (i2 >= 0) {
            kVar.position = i2;
            return 1;
        }
        if (i2 < -1) {
            U(-(i2 + 2));
        }
        if (!this.bpF) {
            this.bir.a(this.bpA.uH());
            this.bpF = true;
        }
        if (this.bpE > 0 || this.bpz.k(fVar)) {
            this.bpE = 0;
            com.google.android.exoplayer2.i.m mVar = this.bpz.bpj;
            long s = s(mVar);
            if (s >= 0 && this.bpC + s >= this.boW) {
                long S = S(this.bpC);
                this.bky.a(mVar, mVar.limit);
                this.bky.a(S, 1, mVar.limit, 0, null);
                this.boW = -1;
            }
            this.bpC += s;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public final long S(long j2) {
        return (TimeUtil.SECOND_TO_US * j2) / ((long) this.sampleRate);
    }

    /* access modifiers changed from: protected */
    public final long T(long j2) {
        return (((long) this.sampleRate) * j2) / TimeUtil.SECOND_TO_US;
    }

    /* access modifiers changed from: protected */
    public void U(long j2) {
        this.bpC = j2;
    }

    /* access modifiers changed from: package-private */
    public static final class b implements f {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.c.e.f
        public final long i(f fVar) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.c.e.f
        public final long R(long j2) {
            return 0;
        }

        @Override // com.google.android.exoplayer2.c.e.f
        public final l uH() {
            AppMethodBeat.i(92166);
            l.a aVar = new l.a(-9223372036854775807L);
            AppMethodBeat.o(92166);
            return aVar;
        }
    }
}
