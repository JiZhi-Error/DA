package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.b.a.a;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

final class c {
    private byte[] bih;
    final q bxA;
    private final List<Format> bxB;
    boolean bxC;
    byte[] bxD;
    IOException bxE;
    private a.C0114a bxF;
    private boolean bxG;
    private Uri bxH;
    private String bxI;
    f bxJ;
    private byte[] bxt;
    private final g bxv;
    private final g bxw;
    private final k bxx;
    private final a.C0114a[] bxy;
    private final e bxz;

    public static final class b {
        public com.google.android.exoplayer2.source.a.a bxM;
        public boolean bxN;
        public a.C0114a bxO;

        public b() {
            AppMethodBeat.i(62824);
            clear();
            AppMethodBeat.o(62824);
        }

        public final void clear() {
            this.bxM = null;
            this.bxN = false;
            this.bxO = null;
        }
    }

    public c(e eVar, a.C0114a[] aVarArr, d dVar, k kVar, List<Format> list) {
        AppMethodBeat.i(62827);
        this.bxz = eVar;
        this.bxy = aVarArr;
        this.bxx = kVar;
        this.bxB = list;
        Format[] formatArr = new Format[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            formatArr[i2] = aVarArr[i2].bdF;
            iArr[i2] = i2;
        }
        this.bxv = dVar.vO();
        this.bxw = dVar.vO();
        this.bxA = new q(formatArr);
        this.bxJ = new C0116c(this.bxA, iArr);
        AppMethodBeat.o(62827);
    }

    public final void vs() {
        AppMethodBeat.i(62828);
        if (this.bxE != null) {
            IOException iOException = this.bxE;
            AppMethodBeat.o(62828);
            throw iOException;
        }
        if (this.bxF != null) {
            this.bxz.d(this.bxF);
        }
        AppMethodBeat.o(62828);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.exoplayer2.source.b.f r25, long r26, com.google.android.exoplayer2.source.b.c.b r28) {
        /*
        // Method dump skipped, instructions count: 695
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.c.a(com.google.android.exoplayer2.source.b.f, long, com.google.android.exoplayer2.source.b.c$b):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(Uri uri, String str, byte[] bArr) {
        String str2;
        AppMethodBeat.i(62830);
        if (x.bH(str).startsWith("0x")) {
            str2 = str.substring(2);
        } else {
            str2 = str;
        }
        byte[] byteArray = new BigInteger(str2, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
        this.bxH = uri;
        this.bih = bArr;
        this.bxI = str;
        this.bxt = bArr2;
        AppMethodBeat.o(62830);
    }

    /* renamed from: com.google.android.exoplayer2.source.b.c$c  reason: collision with other inner class name */
    static final class C0116c extends com.google.android.exoplayer2.g.b {
        private int bxP;

        public C0116c(q qVar, int[] iArr) {
            super(qVar, iArr);
            AppMethodBeat.i(62825);
            this.bxP = j(qVar.bwD[0]);
            AppMethodBeat.o(62825);
        }

        @Override // com.google.android.exoplayer2.g.f
        public final void af(long j2) {
            AppMethodBeat.i(62826);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!l(this.bxP, elapsedRealtime)) {
                AppMethodBeat.o(62826);
                return;
            }
            for (int i2 = this.length - 1; i2 >= 0; i2--) {
                if (!l(i2, elapsedRealtime)) {
                    this.bxP = i2;
                    AppMethodBeat.o(62826);
                    return;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(62826);
            throw illegalStateException;
        }

        @Override // com.google.android.exoplayer2.g.f
        public final int getSelectedIndex() {
            return this.bxP;
        }

        @Override // com.google.android.exoplayer2.g.f
        public final int vP() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.g.f
        public final Object vQ() {
            return null;
        }
    }

    static final class a extends com.google.android.exoplayer2.source.a.c {
        public final String bxK;
        byte[] bxL;

        public a(g gVar, j jVar, Format format, int i2, Object obj, byte[] bArr, String str) {
            super(gVar, jVar, format, i2, obj, bArr);
            this.bxK = str;
        }

        @Override // com.google.android.exoplayer2.source.a.c
        public final void f(byte[] bArr, int i2) {
            AppMethodBeat.i(62823);
            this.bxL = Arrays.copyOf(bArr, i2);
            AppMethodBeat.o(62823);
        }
    }
}
