package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class k {
    public static final byte[] bGT = {0, 0, 0, 1};
    public static final float[] bHg = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object bHh = new Object();
    private static int[] bHi = new int[10];

    public static final class b {
        public final int bHj;
        public final float bHl;
        public final boolean bHm;
        public final boolean bHn;
        public final int bHo;
        public final int bHp;
        public final int bHq;
        public final boolean bHr;
        public final int height;
        public final int width;

        public b(int i2, int i3, int i4, float f2, boolean z, boolean z2, int i5, int i6, int i7, boolean z3) {
            this.bHj = i2;
            this.width = i3;
            this.height = i4;
            this.bHl = f2;
            this.bHm = z;
            this.bHn = z2;
            this.bHo = i5;
            this.bHp = i6;
            this.bHq = i7;
            this.bHr = z3;
        }
    }

    public static final class a {
        public final int bHj;
        public final boolean bHk;
        public final int brw;

        public a(int i2, int i3, boolean z) {
            this.brw = i2;
            this.bHj = i3;
            this.bHk = z;
        }
    }

    static {
        AppMethodBeat.i(93154);
        AppMethodBeat.o(93154);
    }

    public static int j(byte[] bArr, int i2) {
        int i3;
        AppMethodBeat.i(93148);
        synchronized (bHh) {
            int i4 = 0;
            int i5 = 0;
            while (i5 < i2) {
                while (true) {
                    if (i5 >= i2 - 2) {
                        i5 = i2;
                        break;
                    }
                    try {
                        if (bArr[i5] == 0 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == 3) {
                            break;
                        }
                        i5++;
                    } catch (Throwable th) {
                        AppMethodBeat.o(93148);
                        throw th;
                    }
                }
                if (i5 < i2) {
                    if (bHi.length <= i4) {
                        int[] iArr = bHi;
                        bHi = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    bHi[i4] = i5;
                    i5 += 3;
                    i4++;
                }
            }
            i3 = i2 - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = bHi[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i11 + 1;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        AppMethodBeat.o(93148);
        return i3;
    }

    public static void h(ByteBuffer byteBuffer) {
        AppMethodBeat.i(93149);
        int position = byteBuffer.position();
        int i2 = 0;
        for (int i3 = 0; i3 + 1 < position; i3++) {
            int i4 = byteBuffer.get(i3) & 255;
            if (i2 == 3) {
                if (i4 == 1 && (byteBuffer.get(i3 + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i3 - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    AppMethodBeat.o(93149);
                    return;
                }
            } else if (i4 == 0) {
                i2++;
            }
            if (i4 != 0) {
                i2 = 0;
            }
        }
        byteBuffer.clear();
        AppMethodBeat.o(93149);
    }

    public static boolean b(String str, byte b2) {
        AppMethodBeat.i(93150);
        if ((!"video/avc".equals(str) || (b2 & 31) != 6) && (!TPDecoderType.TP_CODEC_MIMETYPE_HEVC.equals(str) || ((b2 & 126) >> 1) != 39)) {
            AppMethodBeat.o(93150);
            return false;
        }
        AppMethodBeat.o(93150);
        return true;
    }

    public static int k(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    public static int l(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    public static b k(byte[] bArr, int i2, int i3) {
        boolean z;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        AppMethodBeat.i(93151);
        n nVar = new n(bArr, i2, i3);
        nVar.en(8);
        int em = nVar.em(8);
        nVar.en(16);
        int xq = nVar.xq();
        int i8 = 1;
        boolean z2 = false;
        if (em == 100 || em == 110 || em == 122 || em == 244 || em == 44 || em == 83 || em == 86 || em == 118 || em == 128 || em == 138) {
            int xq2 = nVar.xq();
            if (xq2 == 3) {
                z2 = nVar.uI();
            }
            nVar.xq();
            nVar.xq();
            nVar.xb();
            if (nVar.uI()) {
                int i9 = xq2 != 3 ? 8 : 12;
                for (int i10 = 0; i10 < i9; i10++) {
                    if (nVar.uI()) {
                        int i11 = i10 < 6 ? 16 : 64;
                        int i12 = 8;
                        int i13 = 8;
                        for (int i14 = 0; i14 < i11; i14++) {
                            if (i13 != 0) {
                                i13 = ((nVar.xp() + i12) + 256) % 256;
                            }
                            if (i13 != 0) {
                                i12 = i13;
                            }
                        }
                    }
                }
            }
            z = z2;
            i8 = xq2;
        } else {
            z = false;
        }
        int xq3 = nVar.xq() + 4;
        int xq4 = nVar.xq();
        int i15 = 0;
        boolean z3 = false;
        if (xq4 == 0) {
            i15 = nVar.xq() + 4;
        } else if (xq4 == 1) {
            z3 = nVar.uI();
            nVar.xp();
            nVar.xp();
            long xq5 = (long) nVar.xq();
            for (int i16 = 0; ((long) i16) < xq5; i16++) {
                nVar.xq();
            }
        }
        nVar.xq();
        nVar.xb();
        int xq6 = nVar.xq() + 1;
        int xq7 = nVar.xq() + 1;
        boolean uI = nVar.uI();
        int i17 = (2 - (uI ? 1 : 0)) * xq7;
        if (!uI) {
            nVar.xb();
        }
        nVar.xb();
        int i18 = xq6 * 16;
        int i19 = i17 * 16;
        if (nVar.uI()) {
            int xq8 = nVar.xq();
            int xq9 = nVar.xq();
            int xq10 = nVar.xq();
            int xq11 = nVar.xq();
            if (i8 == 0) {
                i7 = 1;
                i6 = 2 - (uI ? 1 : 0);
            } else {
                int i20 = i8 == 3 ? 1 : 2;
                i6 = (2 - (uI ? 1 : 0)) * (i8 == 1 ? 2 : 1);
                i7 = i20;
            }
            i4 = i18 - (i7 * (xq8 + xq9));
            i5 = i19 - (i6 * (xq10 + xq11));
        } else {
            i4 = i18;
            i5 = i19;
        }
        float f3 = 1.0f;
        if (nVar.uI() && nVar.uI()) {
            int em2 = nVar.em(8);
            if (em2 == 255) {
                int em3 = nVar.em(16);
                int em4 = nVar.em(16);
                if (!(em3 == 0 || em4 == 0)) {
                    f3 = ((float) em3) / ((float) em4);
                }
                f2 = f3;
            } else if (em2 < bHg.length) {
                f2 = bHg[em2];
            }
            b bVar = new b(xq, i4, i5, f2, z, uI, xq3, xq4, i15, z3);
            AppMethodBeat.o(93151);
            return bVar;
        }
        f2 = 1.0f;
        b bVar2 = new b(xq, i4, i5, f2, z, uI, xq3, xq4, i15, z3);
        AppMethodBeat.o(93151);
        return bVar2;
    }

    public static a m(byte[] bArr, int i2) {
        AppMethodBeat.i(93152);
        n nVar = new n(bArr, 3, i2);
        nVar.en(8);
        int xq = nVar.xq();
        int xq2 = nVar.xq();
        nVar.xb();
        a aVar = new a(xq, xq2, nVar.uI());
        AppMethodBeat.o(93152);
        return aVar;
    }

    public static int a(byte[] bArr, int i2, int i3, boolean[] zArr) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(93153);
        int i4 = i3 - i2;
        a.checkState(i4 >= 0);
        if (i4 == 0) {
            AppMethodBeat.o(93153);
            return i3;
        }
        if (zArr != null) {
            if (zArr[0]) {
                a(zArr);
                int i5 = i2 - 3;
                AppMethodBeat.o(93153);
                return i5;
            } else if (i4 > 1 && zArr[1] && bArr[i2] == 1) {
                a(zArr);
                int i6 = i2 - 2;
                AppMethodBeat.o(93153);
                return i6;
            } else if (i4 > 2 && zArr[2] && bArr[i2] == 0 && bArr[i2 + 1] == 1) {
                a(zArr);
                int i7 = i2 - 1;
                AppMethodBeat.o(93153);
                return i7;
            }
        }
        int i8 = i3 - 1;
        int i9 = i2 + 2;
        while (i9 < i8) {
            if ((bArr[i9] & 254) == 0) {
                if (bArr[i9 - 2] == 0 && bArr[i9 - 1] == 0 && bArr[i9] == 1) {
                    if (zArr != null) {
                        a(zArr);
                    }
                    int i10 = i9 - 2;
                    AppMethodBeat.o(93153);
                    return i10;
                }
                i9 -= 2;
            }
            i9 += 3;
        }
        if (zArr != null) {
            zArr[0] = i4 > 2 ? bArr[i3 + -3] == 0 && bArr[i3 + -2] == 0 && bArr[i3 + -1] == 1 : i4 == 2 ? zArr[2] && bArr[i3 + -2] == 0 && bArr[i3 + -1] == 1 : zArr[1] && bArr[i3 + -1] == 1;
            if (i4 > 1) {
                z = bArr[i3 + -2] == 0 && bArr[i3 + -1] == 0;
            } else {
                z = zArr[2] && bArr[i3 + -1] == 0;
            }
            zArr[1] = z;
            if (bArr[i3 - 1] != 0) {
                z2 = false;
            }
            zArr[2] = z2;
        }
        AppMethodBeat.o(93153);
        return i3;
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
