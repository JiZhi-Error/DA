package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class l {
    public long boA;
    public long boB;
    public int boC;
    public long[] boD;
    public int[] boE;
    public int[] boF;
    public int[] boG;
    public long[] boH;
    public boolean[] boI;
    public boolean boJ;
    public boolean[] boK;
    public k boL;
    public int boM;
    public m boN;
    public boolean boO;
    public long boP;
    public c boy;
    public long boz;
    public int sampleCount;

    l() {
    }

    public final void reset() {
        this.boC = 0;
        this.boP = 0;
        this.boJ = false;
        this.boO = false;
        this.boL = null;
    }

    public final void bd(int i2, int i3) {
        this.boC = i2;
        this.sampleCount = i3;
        if (this.boE == null || this.boE.length < i2) {
            this.boD = new long[i2];
            this.boE = new int[i2];
        }
        if (this.boF == null || this.boF.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.boF = new int[i4];
            this.boG = new int[i4];
            this.boH = new long[i4];
            this.boI = new boolean[i4];
            this.boK = new boolean[i4];
        }
    }

    public final void ej(int i2) {
        AppMethodBeat.i(92130);
        if (this.boN == null || this.boN.limit < i2) {
            this.boN = new m(i2);
        }
        this.boM = i2;
        this.boJ = true;
        this.boO = true;
        AppMethodBeat.o(92130);
    }

    public final void q(m mVar) {
        AppMethodBeat.i(92131);
        mVar.readBytes(this.boN.data, 0, this.boM);
        this.boN.setPosition(0);
        this.boO = false;
        AppMethodBeat.o(92131);
    }

    public final long ek(int i2) {
        return this.boH[i2] + ((long) this.boG[i2]);
    }
}
