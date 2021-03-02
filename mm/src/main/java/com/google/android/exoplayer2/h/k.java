package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class k implements b {
    private final boolean bEQ;
    private final int bER;
    private final byte[] bES;
    private final a[] bET;
    private int bEU;
    private int bEV;
    private a[] bEW;
    private int bbT;

    public k() {
        this((byte) 0);
    }

    private k(byte b2) {
        AppMethodBeat.i(93049);
        a.checkArgument(true);
        a.checkArgument(true);
        this.bEQ = true;
        this.bER = 65536;
        this.bEV = 0;
        this.bEW = new a[100];
        this.bES = null;
        this.bET = new a[1];
        AppMethodBeat.o(93049);
    }

    public final synchronized void reset() {
        AppMethodBeat.i(93050);
        if (this.bEQ) {
            eX(0);
        }
        AppMethodBeat.o(93050);
    }

    public final synchronized void eX(int i2) {
        AppMethodBeat.i(93051);
        boolean z = i2 < this.bbT;
        this.bbT = i2;
        if (z) {
            trim();
        }
        AppMethodBeat.o(93051);
    }

    @Override // com.google.android.exoplayer2.h.b
    public final synchronized a wC() {
        a aVar;
        AppMethodBeat.i(93052);
        this.bEU++;
        if (this.bEV > 0) {
            a[] aVarArr = this.bEW;
            int i2 = this.bEV - 1;
            this.bEV = i2;
            aVar = aVarArr[i2];
            this.bEW[this.bEV] = null;
        } else {
            aVar = new a(new byte[this.bER]);
        }
        AppMethodBeat.o(93052);
        return aVar;
    }

    @Override // com.google.android.exoplayer2.h.b
    public final synchronized void a(a aVar) {
        AppMethodBeat.i(93053);
        this.bET[0] = aVar;
        a(this.bET);
        AppMethodBeat.o(93053);
    }

    @Override // com.google.android.exoplayer2.h.b
    public final synchronized void a(a[] aVarArr) {
        AppMethodBeat.i(93054);
        if (this.bEV + aVarArr.length >= this.bEW.length) {
            this.bEW = (a[]) Arrays.copyOf(this.bEW, Math.max(this.bEW.length * 2, this.bEV + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            a.checkArgument(aVar.data == this.bES || aVar.data.length == this.bER);
            a[] aVarArr2 = this.bEW;
            int i2 = this.bEV;
            this.bEV = i2 + 1;
            aVarArr2[i2] = aVar;
        }
        this.bEU -= aVarArr.length;
        notifyAll();
        AppMethodBeat.o(93054);
    }

    @Override // com.google.android.exoplayer2.h.b
    public final synchronized void trim() {
        AppMethodBeat.i(93055);
        int max = Math.max(0, x.bi(this.bbT, this.bER) - this.bEU);
        if (max >= this.bEV) {
            AppMethodBeat.o(93055);
        } else {
            if (this.bES != null) {
                int i2 = this.bEV - 1;
                int i3 = 0;
                while (i3 <= i2) {
                    a aVar = this.bEW[i3];
                    if (aVar.data == this.bES) {
                        i3++;
                    } else {
                        a aVar2 = this.bEW[i2];
                        if (aVar2.data != this.bES) {
                            i2--;
                        } else {
                            this.bEW[i3] = aVar2;
                            this.bEW[i2] = aVar;
                            i2--;
                            i3++;
                        }
                    }
                }
                max = Math.max(max, i3);
                if (max >= this.bEV) {
                    AppMethodBeat.o(93055);
                }
            }
            Arrays.fill(this.bEW, max, this.bEV, (Object) null);
            this.bEV = max;
            AppMethodBeat.o(93055);
        }
    }

    public final synchronized int wI() {
        return this.bEU * this.bER;
    }

    @Override // com.google.android.exoplayer2.h.b
    public final int wD() {
        return this.bER;
    }
}
