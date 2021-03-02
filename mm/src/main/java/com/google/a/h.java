package com.google.a;

import com.google.a.aw;
import java.util.Arrays;

public abstract class h {
    int bNo;
    int bNp;
    int bNq;
    boolean bNr;

    public abstract <T extends aw> T a(bj<T> bjVar, r rVar);

    public abstract void a(int i2, aw.a aVar, r rVar);

    public abstract void a(aw.a aVar, r rVar);

    public abstract void fF(int i2);

    public abstract boolean fG(int i2);

    public abstract int fH(int i2);

    public abstract void fI(int i2);

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract int yT();

    public abstract long yU();

    public abstract long yV();

    public abstract int yW();

    public abstract long yX();

    public abstract int yY();

    public abstract boolean yZ();

    public abstract String za();

    public abstract g zb();

    public abstract int zc();

    public abstract int zd();

    public abstract int ze();

    public abstract long zf();

    public abstract int zg();

    public abstract long zh();

    public abstract int zi();

    /* access modifiers changed from: package-private */
    public abstract long zj();

    public abstract int zk();

    /* synthetic */ h(byte b2) {
        this();
    }

    public static h B(byte[] bArr) {
        return c(bArr, 0, bArr.length, false);
    }

    static h c(byte[] bArr, int i2, int i3, boolean z) {
        a aVar = new a(bArr, i2, i3, z, (byte) 0);
        try {
            aVar.fH(i3);
            return aVar;
        } catch (af e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private h() {
        this.bNp = 100;
        this.bNq = Integer.MAX_VALUE;
        this.bNr = false;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends h {
        private final boolean bNs;
        private int bNt;
        private int bNu;
        private int bNv;
        private boolean bNw;
        private int bNx;
        private final byte[] buffer;
        private int limit;
        private int pos;

        /* synthetic */ a(byte[] bArr, int i2, int i3, boolean z, byte b2) {
            this(bArr, i2, i3, z);
        }

        private a(byte[] bArr, int i2, int i3, boolean z) {
            super((byte) 0);
            this.bNx = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i2 + i3;
            this.pos = i2;
            this.bNu = this.pos;
            this.bNs = z;
        }

        @Override // com.google.a.h
        public final int yT() {
            boolean z;
            if (this.pos == this.limit) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.bNv = 0;
                return 0;
            }
            this.bNv = zi();
            if (cj.gY(this.bNv) != 0) {
                return this.bNv;
            }
            throw af.GJ();
        }

        @Override // com.google.a.h
        public final void fF(int i2) {
            if (this.bNv != i2) {
                throw af.GK();
            }
        }

        @Override // com.google.a.h
        public final boolean fG(int i2) {
            int yT;
            int i3 = 0;
            switch (cj.gX(i2)) {
                case 0:
                    if (this.limit - this.pos >= 10) {
                        while (i3 < 10) {
                            byte[] bArr = this.buffer;
                            int i4 = this.pos;
                            this.pos = i4 + 1;
                            if (bArr[i4] >= 0) {
                                return true;
                            }
                            i3++;
                        }
                        throw af.GI();
                    }
                    while (i3 < 10) {
                        if (zq() >= 0) {
                            return true;
                        }
                        i3++;
                    }
                    throw af.GI();
                case 1:
                    fJ(8);
                    return true;
                case 2:
                    fJ(zi());
                    return true;
                case 3:
                    break;
                case 4:
                    return false;
                case 5:
                    fJ(4);
                    return true;
                default:
                    throw af.GL();
            }
            do {
                yT = yT();
                if (yT != 0) {
                }
                fF(cj.bA(cj.gY(i2), 4));
                return true;
            } while (fG(yT));
            fF(cj.bA(cj.gY(i2), 4));
            return true;
        }

        @Override // com.google.a.h
        public final double readDouble() {
            return Double.longBitsToDouble(zn());
        }

        @Override // com.google.a.h
        public final float readFloat() {
            return Float.intBitsToFloat(zm());
        }

        @Override // com.google.a.h
        public final long yU() {
            return zl();
        }

        @Override // com.google.a.h
        public final long yV() {
            return zl();
        }

        @Override // com.google.a.h
        public final int yW() {
            return zi();
        }

        @Override // com.google.a.h
        public final long yX() {
            return zn();
        }

        @Override // com.google.a.h
        public final int yY() {
            return zm();
        }

        @Override // com.google.a.h
        public final boolean yZ() {
            return zl() != 0;
        }

        @Override // com.google.a.h
        public final String readString() {
            int zi = zi();
            if (zi > 0 && zi <= this.limit - this.pos) {
                String str = new String(this.buffer, this.pos, zi, ae.UTF_8);
                this.pos = zi + this.pos;
                return str;
            } else if (zi == 0) {
                return "";
            } else {
                if (zi < 0) {
                    throw af.GH();
                }
                throw af.GG();
            }
        }

        @Override // com.google.a.h
        public final String za() {
            int zi = zi();
            if (zi > 0 && zi <= this.limit - this.pos) {
                String t = ci.t(this.buffer, this.pos, zi);
                this.pos = zi + this.pos;
                return t;
            } else if (zi == 0) {
                return "";
            } else {
                if (zi <= 0) {
                    throw af.GH();
                }
                throw af.GG();
            }
        }

        @Override // com.google.a.h
        public final void a(int i2, aw.a aVar, r rVar) {
            if (this.bNo >= this.bNp) {
                throw af.GM();
            }
            this.bNo++;
            aVar.c(this, rVar);
            fF(cj.bA(i2, 4));
            this.bNo--;
        }

        @Override // com.google.a.h
        public final void a(aw.a aVar, r rVar) {
            int zi = zi();
            if (this.bNo >= this.bNp) {
                throw af.GM();
            }
            int fH = fH(zi);
            this.bNo++;
            aVar.c(this, rVar);
            fF(0);
            this.bNo--;
            fI(fH);
        }

        @Override // com.google.a.h
        public final <T extends aw> T a(bj<T> bjVar, r rVar) {
            int zi = zi();
            if (this.bNo >= this.bNp) {
                throw af.GM();
            }
            int fH = fH(zi);
            this.bNo++;
            T d2 = bjVar.d(this, rVar);
            fF(0);
            this.bNo--;
            fI(fH);
            return d2;
        }

        @Override // com.google.a.h
        public final g zb() {
            byte[] bArr;
            g p;
            int zi = zi();
            if (zi > 0 && zi <= this.limit - this.pos) {
                if (!this.bNs || !this.bNw) {
                    p = g.p(this.buffer, this.pos, zi);
                } else {
                    p = g.q(this.buffer, this.pos, zi);
                }
                this.pos = zi + this.pos;
                return p;
            } else if (zi == 0) {
                return g.bNg;
            } else {
                if (zi > 0 && zi <= this.limit - this.pos) {
                    int i2 = this.pos;
                    this.pos = zi + this.pos;
                    bArr = Arrays.copyOfRange(this.buffer, i2, this.pos);
                } else if (zi > 0) {
                    throw af.GG();
                } else if (zi == 0) {
                    bArr = ae.EMPTY_BYTE_ARRAY;
                } else {
                    throw af.GH();
                }
                return g.A(bArr);
            }
        }

        @Override // com.google.a.h
        public final int zc() {
            return zi();
        }

        @Override // com.google.a.h
        public final int zd() {
            return zi();
        }

        @Override // com.google.a.h
        public final int ze() {
            return zm();
        }

        @Override // com.google.a.h
        public final long zf() {
            return zn();
        }

        @Override // com.google.a.h
        public final int zg() {
            int zi = zi();
            return (-(zi & 1)) ^ (zi >>> 1);
        }

        @Override // com.google.a.h
        public final long zh() {
            long zl = zl();
            return (-(zl & 1)) ^ (zl >>> 1);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
            if (r3[r2] < 0) goto L_0x006c;
         */
        @Override // com.google.a.h
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int zi() {
            /*
            // Method dump skipped, instructions count: 116
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.zi():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
            if (((long) r4[r3]) < 0) goto L_0x00b4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long zl() {
            /*
            // Method dump skipped, instructions count: 189
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.zl():long");
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.h
        public final long zj() {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte zq = zq();
                j2 |= ((long) (zq & Byte.MAX_VALUE)) << i2;
                if ((zq & 128) == 0) {
                    return j2;
                }
            }
            throw af.GI();
        }

        private int zm() {
            int i2 = this.pos;
            if (this.limit - i2 < 4) {
                throw af.GG();
            }
            byte[] bArr = this.buffer;
            this.pos = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        private long zn() {
            int i2 = this.pos;
            if (this.limit - i2 < 8) {
                throw af.GG();
            }
            byte[] bArr = this.buffer;
            this.pos = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        @Override // com.google.a.h
        public final int fH(int i2) {
            if (i2 < 0) {
                throw af.GH();
            }
            int zp = zp() + i2;
            int i3 = this.bNx;
            if (zp > i3) {
                throw af.GG();
            }
            this.bNx = zp;
            zo();
            return i3;
        }

        private void zo() {
            this.limit += this.bNt;
            int i2 = this.limit - this.bNu;
            if (i2 > this.bNx) {
                this.bNt = i2 - this.bNx;
                this.limit -= this.bNt;
                return;
            }
            this.bNt = 0;
        }

        @Override // com.google.a.h
        public final void fI(int i2) {
            this.bNx = i2;
            zo();
        }

        @Override // com.google.a.h
        public final int zk() {
            if (this.bNx == Integer.MAX_VALUE) {
                return -1;
            }
            return this.bNx - zp();
        }

        private int zp() {
            return this.pos - this.bNu;
        }

        private byte zq() {
            if (this.pos == this.limit) {
                throw af.GG();
            }
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 + 1;
            return bArr[i2];
        }

        private void fJ(int i2) {
            if (i2 >= 0 && i2 <= this.limit - this.pos) {
                this.pos += i2;
            } else if (i2 < 0) {
                throw af.GH();
            } else {
                throw af.GG();
            }
        }
    }
}
