package com.google.a;

import com.google.a.ci;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class i extends f {
    static final boolean bNy = ch.HS();
    private static final Logger logger = Logger.getLogger(i.class.getName());

    public abstract void a(int i2, aw awVar);

    public abstract void a(int i2, g gVar);

    public abstract void a(g gVar);

    public abstract void av(long j2);

    public abstract void ax(long j2);

    public abstract void b(int i2, aw awVar);

    public abstract void b(int i2, g gVar);

    public abstract void br(int i2, int i3);

    public abstract void bs(int i2, int i3);

    public abstract void bt(int i2, int i3);

    public abstract void c(aw awVar);

    public abstract void ca(String str);

    public abstract void d(byte b2);

    public abstract void e(int i2, String str);

    public abstract void fK(int i2);

    public abstract void fL(int i2);

    public abstract void fN(int i2);

    public abstract void n(int i2, long j2);

    public abstract void o(int i2, long j2);

    @Override // com.google.a.f
    public abstract void o(byte[] bArr, int i2, int i3);

    public abstract void r(int i2, boolean z);

    /* access modifiers changed from: package-private */
    public abstract void r(byte[] bArr, int i2);

    public abstract int zz();

    /* synthetic */ i(byte b2) {
        this();
    }

    public static i C(byte[] bArr) {
        return new a(bArr, bArr.length);
    }

    private i() {
    }

    public final void fM(int i2) {
        fL(fX(i2));
    }

    public final void aw(long j2) {
        av(aC(j2));
    }

    public final void ad(float f2) {
        fN(Float.floatToRawIntBits(f2));
    }

    public final void f(double d2) {
        ax(Double.doubleToRawLongBits(d2));
    }

    public final void be(boolean z) {
        d((byte) (z ? 1 : 0));
    }

    public static int bu(int i2, int i3) {
        return fS(i2) + fT(i3);
    }

    private static int fO(int i2) {
        return fS(2) + fU(i2);
    }

    public static int fP(int i2) {
        return fS(i2) + 4;
    }

    public static int ay(long j2) {
        return fS(5) + aA(j2);
    }

    public static int p(int i2, long j2) {
        return fS(i2) + aA(j2);
    }

    public static int fQ(int i2) {
        return fS(i2) + 8;
    }

    public static int zr() {
        return fS(6) + 8;
    }

    public static int fR(int i2) {
        return fS(i2) + 1;
    }

    public static int bv(int i2, int i3) {
        return fS(i2) + fT(i3);
    }

    public static int f(int i2, String str) {
        return fS(i2) + cb(str);
    }

    public static int c(int i2, g gVar) {
        int fS = fS(i2);
        int size = gVar.size();
        return fS + size + fU(size);
    }

    public static int c(int i2, aw awVar) {
        return fS(i2) + d(awVar);
    }

    public static int d(int i2, aw awVar) {
        return (fS(1) * 2) + fO(i2) + c(3, awVar);
    }

    public static int d(int i2, g gVar) {
        return (fS(1) * 2) + fO(i2) + c(3, gVar);
    }

    public static int a(int i2, ai aiVar) {
        int fS = (fS(1) * 2) + fO(i2);
        int fS2 = fS(3);
        int yC = aiVar.yC();
        return fS + fS2 + yC + fU(yC);
    }

    public static int fS(int i2) {
        return fU(cj.bA(i2, 0));
    }

    public static int fT(int i2) {
        if (i2 >= 0) {
            return fU(i2);
        }
        return 10;
    }

    public static int fU(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        if ((-268435456 & i2) == 0) {
            return 4;
        }
        return 5;
    }

    public static int fV(int i2) {
        return fU(fX(i2));
    }

    public static int zs() {
        return 4;
    }

    public static int zt() {
        return 4;
    }

    public static int az(long j2) {
        return aA(j2);
    }

    public static int aA(long j2) {
        long j3;
        if ((-128 & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        int i2 = 2;
        if ((-34359738368L & j2) != 0) {
            i2 = 6;
            j3 = j2 >>> 28;
        } else {
            j3 = j2;
        }
        if ((-2097152 & j3) != 0) {
            i2 += 2;
            j3 >>>= 14;
        }
        if ((j3 & -16384) != 0) {
            return i2 + 1;
        }
        return i2;
    }

    public static int aB(long j2) {
        return aA(aC(j2));
    }

    public static int zu() {
        return 8;
    }

    public static int zv() {
        return 8;
    }

    public static int zw() {
        return 4;
    }

    public static int zx() {
        return 8;
    }

    public static int zy() {
        return 1;
    }

    public static int fW(int i2) {
        return fT(i2);
    }

    public static int cb(String str) {
        int length;
        try {
            length = ci.v(str);
        } catch (ci.d e2) {
            length = str.getBytes(ae.UTF_8).length;
        }
        return length + fU(length);
    }

    public static int a(ai aiVar) {
        int yC = aiVar.yC();
        return yC + fU(yC);
    }

    public static int b(g gVar) {
        int size = gVar.size();
        return size + fU(size);
    }

    public static int D(byte[] bArr) {
        int length = bArr.length;
        return length + fU(length);
    }

    public static int d(aw awVar) {
        int yC = awVar.yC();
        return yC + fU(yC);
    }

    private static int fX(int i2) {
        return (i2 << 1) ^ (i2 >> 31);
    }

    private static long aC(long j2) {
        return (j2 << 1) ^ (j2 >> 63);
    }

    public final void zA() {
        if (zz() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static class b extends IOException {
        b() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        b(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        b(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, ci.d dVar) {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(ae.UTF_8);
        try {
            fL(bytes.length);
            o(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new b(e2);
        } catch (b e3) {
            throw e3;
        }
    }

    @Deprecated
    public final void e(int i2, aw awVar) {
        br(i2, 3);
        awVar.a(this);
        br(i2, 4);
    }

    @Deprecated
    public static int f(int i2, aw awVar) {
        return (fS(i2) * 2) + awVar.yC();
    }

    @Deprecated
    public static int e(aw awVar) {
        return awVar.yC();
    }

    @Deprecated
    public static int fY(int i2) {
        return fU(i2);
    }

    /* access modifiers changed from: package-private */
    public static class a extends i {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        a(byte[] bArr, int i2) {
            super((byte) 0);
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i2 | 0 | (bArr.length - (i2 + 0))) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            } else {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i2 + 0;
            }
        }

        @Override // com.google.a.i
        public final void br(int i2, int i3) {
            fL(cj.bA(i2, i3));
        }

        @Override // com.google.a.i
        public final void bs(int i2, int i3) {
            br(i2, 0);
            fK(i3);
        }

        private void fZ(int i2) {
            br(2, 0);
            fL(i2);
        }

        @Override // com.google.a.i
        public final void bt(int i2, int i3) {
            br(i2, 5);
            fN(i3);
        }

        @Override // com.google.a.i
        public final void n(int i2, long j2) {
            br(i2, 0);
            av(j2);
        }

        @Override // com.google.a.i
        public final void o(int i2, long j2) {
            br(i2, 1);
            ax(j2);
        }

        @Override // com.google.a.i
        public final void r(int i2, boolean z) {
            int i3 = 0;
            br(i2, 0);
            if (z) {
                i3 = 1;
            }
            d((byte) i3);
        }

        @Override // com.google.a.i
        public final void e(int i2, String str) {
            br(i2, 2);
            ca(str);
        }

        @Override // com.google.a.i
        public final void a(int i2, g gVar) {
            br(i2, 2);
            a(gVar);
        }

        @Override // com.google.a.i
        public final void a(g gVar) {
            fL(gVar.size());
            gVar.a(this);
        }

        @Override // com.google.a.i
        public final void r(byte[] bArr, int i2) {
            fL(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.a.i
        public final void a(int i2, aw awVar) {
            br(i2, 2);
            c(awVar);
        }

        @Override // com.google.a.i
        public final void b(int i2, aw awVar) {
            br(1, 3);
            fZ(i2);
            a(3, awVar);
            br(1, 4);
        }

        @Override // com.google.a.i
        public final void b(int i2, g gVar) {
            br(1, 3);
            fZ(i2);
            a(3, gVar);
            br(1, 4);
        }

        @Override // com.google.a.i
        public final void c(aw awVar) {
            fL(awVar.yC());
            awVar.a(this);
        }

        @Override // com.google.a.i
        public final void d(byte b2) {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.a.i
        public final void fK(int i2) {
            if (i2 >= 0) {
                fL(i2);
            } else {
                av((long) i2);
            }
        }

        @Override // com.google.a.i
        public final void fN(int i2) {
            try {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr[i3] = (byte) (i2 & 255);
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr2[i4] = (byte) ((i2 >> 8) & 255);
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr3[i5] = (byte) ((i2 >> 16) & 255);
                byte[] bArr4 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr4[i6] = (byte) ((i2 >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.a.i
        public final void ax(long j2) {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (((int) j2) & 255);
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (((int) (j2 >> 8)) & 255);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (((int) (j2 >> 16)) & 255);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (((int) (j2 >> 24)) & 255);
                byte[] bArr5 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr5[i6] = (byte) (((int) (j2 >> 32)) & 255);
                byte[] bArr6 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr6[i7] = (byte) (((int) (j2 >> 40)) & 255);
                byte[] bArr7 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr7[i8] = (byte) (((int) (j2 >> 48)) & 255);
                byte[] bArr8 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                bArr8[i9] = (byte) (((int) (j2 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        private void write(byte[] bArr, int i2, int i3) {
            try {
                System.arraycopy(bArr, i2, this.buffer, this.position, i3);
                this.position += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i3)), e2);
            }
        }

        @Override // com.google.a.i, com.google.a.f
        public final void o(byte[] bArr, int i2, int i3) {
            write(bArr, i2, i3);
        }

        @Override // com.google.a.i
        public final void ca(String str) {
            int i2 = this.position;
            try {
                int fU = fU(str.length() * 3);
                int fU2 = fU(str.length());
                if (fU2 == fU) {
                    this.position = i2 + fU2;
                    int a2 = ci.a(str, this.buffer, this.position, zz());
                    this.position = i2;
                    fL((a2 - i2) - fU2);
                    this.position = a2;
                    return;
                }
                fL(ci.v(str));
                this.position = ci.a(str, this.buffer, this.position, zz());
            } catch (ci.d e2) {
                this.position = i2;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new b(e3);
            }
        }

        @Override // com.google.a.i
        public final int zz() {
            return this.limit - this.position;
        }

        @Override // com.google.a.i
        public final void fL(int i2) {
            if (!i.bNy || e.yM() || zz() < 5) {
                while ((i2 & -128) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i3 = this.position;
                        this.position = i3 + 1;
                        bArr[i3] = (byte) ((i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr2[i4] = (byte) i2;
            } else if ((i2 & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                ch.a(bArr3, (long) i5, (byte) i2);
            } else {
                byte[] bArr4 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                ch.a(bArr4, (long) i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    ch.a(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                ch.a(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    ch.a(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i12 = this.position;
                this.position = i12 + 1;
                ch.a(bArr8, (long) i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i14 = this.position;
                    this.position = i14 + 1;
                    ch.a(bArr9, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                ch.a(bArr10, (long) i15, (byte) (i13 | 128));
                byte[] bArr11 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                ch.a(bArr11, (long) i16, (byte) (i13 >>> 7));
            }
        }

        @Override // com.google.a.i
        public final void av(long j2) {
            if (!i.bNy || zz() < 10) {
                while ((j2 & -128) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((((int) j2) & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128);
                        j2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) ((int) j2);
                return;
            }
            while ((j2 & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                ch.a(bArr3, (long) i4, (byte) ((((int) j2) & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128));
                j2 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            ch.a(bArr4, (long) i5, (byte) ((int) j2));
        }
    }
}
