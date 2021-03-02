package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class k {
    public static int eo(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    public static boolean a(int i2, m mVar, boolean z) {
        AppMethodBeat.i(92177);
        if (mVar.xd() < 7) {
            if (z) {
                AppMethodBeat.o(92177);
                return false;
            }
            o oVar = new o("too short header: " + mVar.xd());
            AppMethodBeat.o(92177);
            throw oVar;
        } else if (mVar.readUnsignedByte() != i2) {
            if (z) {
                AppMethodBeat.o(92177);
                return false;
            }
            o oVar2 = new o("expected header type " + Integer.toHexString(i2));
            AppMethodBeat.o(92177);
            throw oVar2;
        } else if (mVar.readUnsignedByte() == 118 && mVar.readUnsignedByte() == 111 && mVar.readUnsignedByte() == 114 && mVar.readUnsignedByte() == 98 && mVar.readUnsignedByte() == 105 && mVar.readUnsignedByte() == 115) {
            AppMethodBeat.o(92177);
            return true;
        } else if (z) {
            AppMethodBeat.o(92177);
            return false;
        } else {
            o oVar3 = new o("expected characters 'vorbis'");
            AppMethodBeat.o(92177);
            throw oVar3;
        }
    }

    static c[] a(i iVar) {
        AppMethodBeat.i(92178);
        int em = iVar.em(6) + 1;
        c[] cVarArr = new c[em];
        for (int i2 = 0; i2 < em; i2++) {
            cVarArr[i2] = new c(iVar.uI(), iVar.em(16), iVar.em(16), iVar.em(8));
        }
        AppMethodBeat.o(92178);
        return cVarArr;
    }

    static void a(int i2, i iVar) {
        AppMethodBeat.i(92179);
        int em = iVar.em(6) + 1;
        for (int i3 = 0; i3 < em; i3++) {
            switch (iVar.em(16)) {
                case 0:
                    int em2 = iVar.uI() ? iVar.em(4) + 1 : 1;
                    if (iVar.uI()) {
                        int em3 = iVar.em(8) + 1;
                        for (int i4 = 0; i4 < em3; i4++) {
                            iVar.en(eo(i2 - 1));
                            iVar.en(eo(i2 - 1));
                        }
                    }
                    if (iVar.em(2) == 0) {
                        if (em2 > 1) {
                            for (int i5 = 0; i5 < i2; i5++) {
                                iVar.en(4);
                            }
                        }
                        for (int i6 = 0; i6 < em2; i6++) {
                            iVar.en(8);
                            iVar.en(8);
                            iVar.en(8);
                        }
                        break;
                    } else {
                        o oVar = new o("to reserved bits must be zero after mapping coupling steps");
                        AppMethodBeat.o(92179);
                        throw oVar;
                    }
            }
        }
        AppMethodBeat.o(92179);
    }

    static void b(i iVar) {
        AppMethodBeat.i(92180);
        int em = iVar.em(6) + 1;
        for (int i2 = 0; i2 < em; i2++) {
            if (iVar.em(16) > 2) {
                o oVar = new o("residueType greater than 2 is not decodable");
                AppMethodBeat.o(92180);
                throw oVar;
            }
            iVar.en(24);
            iVar.en(24);
            iVar.en(24);
            int em2 = iVar.em(6) + 1;
            iVar.en(8);
            int[] iArr = new int[em2];
            for (int i3 = 0; i3 < em2; i3++) {
                iArr[i3] = ((iVar.uI() ? iVar.em(5) : 0) * 8) + iVar.em(3);
            }
            for (int i4 = 0; i4 < em2; i4++) {
                for (int i5 = 0; i5 < 8; i5++) {
                    if ((iArr[i4] & (1 << i5)) != 0) {
                        iVar.en(8);
                    }
                }
            }
        }
        AppMethodBeat.o(92180);
    }

    static void c(i iVar) {
        AppMethodBeat.i(92181);
        int em = iVar.em(6) + 1;
        for (int i2 = 0; i2 < em; i2++) {
            int em2 = iVar.em(16);
            switch (em2) {
                case 0:
                    iVar.en(8);
                    iVar.en(16);
                    iVar.en(16);
                    iVar.en(6);
                    iVar.en(8);
                    int em3 = iVar.em(4) + 1;
                    for (int i3 = 0; i3 < em3; i3++) {
                        iVar.en(8);
                    }
                    break;
                case 1:
                    int em4 = iVar.em(5);
                    int i4 = -1;
                    int[] iArr = new int[em4];
                    for (int i5 = 0; i5 < em4; i5++) {
                        iArr[i5] = iVar.em(4);
                        if (iArr[i5] > i4) {
                            i4 = iArr[i5];
                        }
                    }
                    int[] iArr2 = new int[(i4 + 1)];
                    for (int i6 = 0; i6 < iArr2.length; i6++) {
                        iArr2[i6] = iVar.em(3) + 1;
                        int em5 = iVar.em(2);
                        if (em5 > 0) {
                            iVar.en(8);
                        }
                        for (int i7 = 0; i7 < (1 << em5); i7++) {
                            iVar.en(8);
                        }
                    }
                    iVar.en(2);
                    int em6 = iVar.em(4);
                    int i8 = 0;
                    int i9 = 0;
                    for (int i10 = 0; i10 < em4; i10++) {
                        i9 += iArr2[iArr[i10]];
                        while (i8 < i9) {
                            iVar.en(em6);
                            i8++;
                        }
                    }
                    break;
                default:
                    o oVar = new o("floor type greater than 1 not decodable: ".concat(String.valueOf(em2)));
                    AppMethodBeat.o(92181);
                    throw oVar;
            }
        }
        AppMethodBeat.o(92181);
    }

    public static final class a {
        public final int bpT;
        public final long[] bpU;
        public final int bpV;
        public final boolean bpW;
        public final int entries;

        public a(int i2, int i3, long[] jArr, int i4, boolean z) {
            this.bpT = i2;
            this.entries = i3;
            this.bpU = jArr;
            this.bpV = i4;
            this.bpW = z;
        }
    }

    public static final class b {
        public final String[] bpX;
        public final int length;
        public final String vendor;

        public b(String str, String[] strArr, int i2) {
            this.vendor = str;
            this.bpX = strArr;
            this.length = i2;
        }
    }

    public static final class d {
        public final long bqc;
        public final int bqd;
        public final int bqe;
        public final int bqf;
        public final int bqg;
        public final int bqh;
        public final boolean bqi;
        public final int channels;
        public final byte[] data;
        public final long sampleRate;

        public d(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr) {
            this.bqc = j2;
            this.channels = i2;
            this.sampleRate = j3;
            this.bqd = i3;
            this.bqe = i4;
            this.bqf = i5;
            this.bqg = i6;
            this.bqh = i7;
            this.bqi = z;
            this.data = bArr;
        }
    }

    public static final class c {
        public final boolean bpY;
        public final int bpZ;
        public final int bqa;
        public final int bqb;

        public c(boolean z, int i2, int i3, int i4) {
            this.bpY = z;
            this.bpZ = i2;
            this.bqa = i3;
            this.bqb = i4;
        }
    }
}
