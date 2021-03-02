package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class i implements h {
    private static final double[] bqN = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private m biA;
    private boolean bik;
    private String bqA;
    private long bqM;
    private final boolean[] bqO = new boolean[4];
    private final a bqP = new a();
    private long bqQ;
    private boolean bqR;
    private long bqS;
    private long bqT;
    private boolean bqU;
    private boolean bqV;
    private long frameDurationUs;

    public i() {
        AppMethodBeat.i(92235);
        AppMethodBeat.o(92235);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uK() {
        AppMethodBeat.i(92236);
        k.a(this.bqO);
        a aVar = this.bqP;
        aVar.bqX = false;
        aVar.length = 0;
        aVar.bqY = 0;
        this.bqQ = 0;
        this.bqR = false;
        AppMethodBeat.o(92236);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92237);
        dVar.uW();
        this.bqA = dVar.uX();
        this.biA = gVar.dV(dVar.getTrackId());
        AppMethodBeat.o(92237);
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void c(long j2, boolean z) {
        this.bqS = j2;
    }

    @Override // com.google.android.exoplayer2.c.f.h
    public final void uL() {
    }

    static final class a {
        static final byte[] bqW = {0, 0, 1};
        boolean bqX;
        public int bqY;
        public byte[] data = new byte[128];
        public int length;

        public a() {
            AppMethodBeat.i(92233);
            AppMethodBeat.o(92233);
        }

        public final void d(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(92234);
            if (!this.bqX) {
                AppMethodBeat.o(92234);
                return;
            }
            int i4 = i3 - i2;
            if (this.data.length < this.length + i4) {
                this.data = Arrays.copyOf(this.data, (this.length + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.data, this.length, i4);
            this.length = i4 + this.length;
            AppMethodBeat.o(92234);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073  */
    @Override // com.google.android.exoplayer2.c.f.h
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(com.google.android.exoplayer2.i.m r13) {
        /*
        // Method dump skipped, instructions count: 436
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.f.i.t(com.google.android.exoplayer2.i.m):void");
    }
}
