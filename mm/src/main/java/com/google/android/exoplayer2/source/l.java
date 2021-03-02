package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l {
    private int[] bhG = new int[this.bwA];
    private long[] bhI = new long[this.bwA];
    private int[] bmY = new int[this.bwA];
    private int bwA = 1000;
    public int[] bwB = new int[this.bwA];
    private m.a[] bwC = new m.a[this.bwA];
    private Format[] bwD = new Format[this.bwA];
    private int bwE;
    private int bwF;
    public int bwG;
    private long bwH = Long.MIN_VALUE;
    private long bwI = Long.MIN_VALUE;
    private boolean bwJ = true;
    private boolean bwK = true;
    private Format bwL;
    public int bwM;
    private int length;
    private long[] offsets = new long[this.bwA];

    public static final class a {
        public m.a bjS;
        public long offset;
        public int size;
    }

    public l() {
        AppMethodBeat.i(92681);
        AppMethodBeat.o(92681);
    }

    public final void reset(boolean z) {
        this.length = 0;
        this.bwE = 0;
        this.bwF = 0;
        this.bwG = 0;
        this.bwJ = true;
        this.bwH = Long.MIN_VALUE;
        this.bwI = Long.MIN_VALUE;
        if (z) {
            this.bwL = null;
            this.bwK = true;
        }
    }

    public final int vD() {
        return this.bwE + this.length;
    }

    public final int vE() {
        return this.bwE + this.bwG;
    }

    public final synchronized boolean vF() {
        return this.bwG != this.length;
    }

    public final synchronized Format vG() {
        return this.bwK ? null : this.bwL;
    }

    public final synchronized long vy() {
        return this.bwI;
    }

    public final synchronized void rewind() {
        this.bwG = 0;
    }

    public final synchronized int a(k kVar, e eVar, boolean z, boolean z2, Format format, a aVar) {
        boolean z3;
        int i2 = -4;
        synchronized (this) {
            AppMethodBeat.i(92683);
            if (vF()) {
                int eD = eD(this.bwG);
                if (z || this.bwD[eD] != format) {
                    kVar.bdF = this.bwD[eD];
                    AppMethodBeat.o(92683);
                    i2 = -5;
                } else {
                    if (eVar.aKP == null && eVar.bhq == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        AppMethodBeat.o(92683);
                        i2 = -3;
                    } else {
                        eVar.timeUs = this.bhI[eD];
                        eVar.flags = this.bmY[eD];
                        aVar.size = this.bhG[eD];
                        aVar.offset = this.offsets[eD];
                        aVar.bjS = this.bwC[eD];
                        this.bwG++;
                        AppMethodBeat.o(92683);
                    }
                }
            } else if (z2) {
                eVar.flags = 4;
                AppMethodBeat.o(92683);
            } else if (this.bwL == null || (!z && this.bwL == format)) {
                AppMethodBeat.o(92683);
                i2 = -3;
            } else {
                kVar.bdF = this.bwL;
                AppMethodBeat.o(92683);
                i2 = -5;
            }
        }
        return i2;
    }

    public final synchronized boolean f(long j2, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(92684);
            int eD = eD(this.bwG);
            if (!vF() || j2 < this.bhI[eD] || (j2 > this.bwI && !z)) {
                AppMethodBeat.o(92684);
            } else {
                int a2 = a(eD, this.length - this.bwG, j2, true);
                if (a2 == -1) {
                    AppMethodBeat.o(92684);
                } else {
                    this.bwG += a2;
                    AppMethodBeat.o(92684);
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public final synchronized void vH() {
        AppMethodBeat.i(92685);
        if (!vF()) {
            AppMethodBeat.o(92685);
        } else {
            this.bwG = this.length;
            AppMethodBeat.o(92685);
        }
    }

    public final synchronized long g(long j2, boolean z) {
        long j3;
        AppMethodBeat.i(196060);
        if (this.length == 0 || j2 < this.bhI[this.bwF]) {
            AppMethodBeat.o(196060);
            j3 = -1;
        } else {
            int a2 = a(this.bwF, (!z || this.bwG == this.length) ? this.length : this.bwG + 1, j2, false);
            if (a2 == -1) {
                AppMethodBeat.o(196060);
                j3 = -1;
            } else {
                j3 = eB(a2);
                AppMethodBeat.o(196060);
            }
        }
        return j3;
    }

    public final synchronized long vI() {
        long eB;
        AppMethodBeat.i(92687);
        if (this.bwG == 0) {
            eB = -1;
            AppMethodBeat.o(92687);
        } else {
            eB = eB(this.bwG);
            AppMethodBeat.o(92687);
        }
        return eB;
    }

    public final synchronized long vJ() {
        long eB;
        AppMethodBeat.i(92688);
        if (this.length == 0) {
            eB = -1;
            AppMethodBeat.o(92688);
        } else {
            eB = eB(this.length);
            AppMethodBeat.o(92688);
        }
        return eB;
    }

    public final synchronized boolean i(Format format) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(92689);
            if (format == null) {
                this.bwK = true;
                AppMethodBeat.o(92689);
            } else {
                this.bwK = false;
                if (x.j(format, this.bwL)) {
                    AppMethodBeat.o(92689);
                } else {
                    this.bwL = format;
                    AppMethodBeat.o(92689);
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void a(long j2, int i2, long j3, int i3, m.a aVar) {
        AppMethodBeat.i(92690);
        if (this.bwJ) {
            if ((i2 & 1) == 0) {
                AppMethodBeat.o(92690);
            } else {
                this.bwJ = false;
            }
        }
        com.google.android.exoplayer2.i.a.checkState(!this.bwK);
        aa(j2);
        int eD = eD(this.length);
        this.bhI[eD] = j2;
        this.offsets[eD] = j3;
        this.bhG[eD] = i3;
        this.bmY[eD] = i2;
        this.bwC[eD] = aVar;
        this.bwD[eD] = this.bwL;
        this.bwB[eD] = this.bwM;
        this.length++;
        if (this.length == this.bwA) {
            int i4 = this.bwA + 1000;
            int[] iArr = new int[i4];
            long[] jArr = new long[i4];
            long[] jArr2 = new long[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            m.a[] aVarArr = new m.a[i4];
            Format[] formatArr = new Format[i4];
            int i5 = this.bwA - this.bwF;
            System.arraycopy(this.offsets, this.bwF, jArr, 0, i5);
            System.arraycopy(this.bhI, this.bwF, jArr2, 0, i5);
            System.arraycopy(this.bmY, this.bwF, iArr2, 0, i5);
            System.arraycopy(this.bhG, this.bwF, iArr3, 0, i5);
            System.arraycopy(this.bwC, this.bwF, aVarArr, 0, i5);
            System.arraycopy(this.bwD, this.bwF, formatArr, 0, i5);
            System.arraycopy(this.bwB, this.bwF, iArr, 0, i5);
            int i6 = this.bwF;
            System.arraycopy(this.offsets, 0, jArr, i5, i6);
            System.arraycopy(this.bhI, 0, jArr2, i5, i6);
            System.arraycopy(this.bmY, 0, iArr2, i5, i6);
            System.arraycopy(this.bhG, 0, iArr3, i5, i6);
            System.arraycopy(this.bwC, 0, aVarArr, i5, i6);
            System.arraycopy(this.bwD, 0, formatArr, i5, i6);
            System.arraycopy(this.bwB, 0, iArr, i5, i6);
            this.offsets = jArr;
            this.bhI = jArr2;
            this.bmY = iArr2;
            this.bhG = iArr3;
            this.bwC = aVarArr;
            this.bwD = formatArr;
            this.bwB = iArr;
            this.bwF = 0;
            this.length = this.bwA;
            this.bwA = i4;
        }
        AppMethodBeat.o(92690);
    }

    private synchronized void aa(long j2) {
        AppMethodBeat.i(92691);
        this.bwI = Math.max(this.bwI, j2);
        AppMethodBeat.o(92691);
    }

    public final synchronized boolean ab(long j2) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(92692);
            if (this.length == 0) {
                if (j2 > this.bwH) {
                    AppMethodBeat.o(92692);
                } else {
                    AppMethodBeat.o(92692);
                    z = false;
                }
            } else if (Math.max(this.bwH, eC(this.bwG)) >= j2) {
                AppMethodBeat.o(92692);
                z = false;
            } else {
                int i2 = this.length;
                int eD = eD(this.length - 1);
                while (i2 > this.bwG && this.bhI[eD] >= j2) {
                    i2--;
                    eD--;
                    if (eD == -1) {
                        eD = this.bwA - 1;
                    }
                }
                int vD = vD() - (this.bwE + i2);
                if (vD >= 0 && vD <= this.length - this.bwG) {
                    z2 = true;
                }
                com.google.android.exoplayer2.i.a.checkArgument(z2);
                this.length -= vD;
                this.bwI = Math.max(this.bwH, eC(this.length));
                AppMethodBeat.o(92692);
            }
        }
        return z;
    }

    private int a(int i2, int i3, long j2, boolean z) {
        int i4 = -1;
        int i5 = 0;
        while (i5 < i3 && this.bhI[i2] <= j2) {
            if (!z || (this.bmY[i2] & 1) != 0) {
                i4 = i5;
            }
            int i6 = i2 + 1;
            if (i6 == this.bwA) {
                i6 = 0;
            }
            i5++;
            i2 = i6;
        }
        return i4;
    }

    private long eB(int i2) {
        AppMethodBeat.i(92693);
        this.bwH = Math.max(this.bwH, eC(i2));
        this.length -= i2;
        this.bwE += i2;
        this.bwF += i2;
        if (this.bwF >= this.bwA) {
            this.bwF -= this.bwA;
        }
        this.bwG -= i2;
        if (this.bwG < 0) {
            this.bwG = 0;
        }
        if (this.length == 0) {
            int i3 = (this.bwF == 0 ? this.bwA : this.bwF) - 1;
            long j2 = ((long) this.bhG[i3]) + this.offsets[i3];
            AppMethodBeat.o(92693);
            return j2;
        }
        long j3 = this.offsets[this.bwF];
        AppMethodBeat.o(92693);
        return j3;
    }

    private long eC(int i2) {
        AppMethodBeat.i(92694);
        if (i2 == 0) {
            AppMethodBeat.o(92694);
            return Long.MIN_VALUE;
        }
        int eD = eD(i2 - 1);
        int i3 = 0;
        long j2 = Long.MIN_VALUE;
        while (i3 < i2) {
            j2 = Math.max(j2, this.bhI[eD]);
            if ((this.bmY[eD] & 1) != 0) {
                break;
            }
            int i4 = eD - 1;
            if (i4 == -1) {
                i4 = this.bwA - 1;
            }
            i3++;
            eD = i4;
        }
        AppMethodBeat.o(92694);
        return j2;
    }

    public final int eD(int i2) {
        int i3 = this.bwF + i2;
        return i3 < this.bwA ? i3 : i3 - this.bwA;
    }
}
