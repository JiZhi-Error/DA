package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class d {
    final e boR = new e();
    final m bpj = new m(new byte[65025], 0);
    int bpk = -1;
    private int bpl;
    boolean bpm;

    d() {
        AppMethodBeat.i(92155);
        AppMethodBeat.o(92155);
    }

    public final boolean k(f fVar) {
        int i2;
        boolean z;
        int i3;
        AppMethodBeat.i(92156);
        a.checkState(fVar != null);
        if (this.bpm) {
            this.bpm = false;
            this.bpj.reset();
        }
        while (!this.bpm) {
            if (this.bpk < 0) {
                if (!this.boR.c(fVar, true)) {
                    AppMethodBeat.o(92156);
                    return false;
                }
                int i4 = this.boR.bkI;
                if ((this.boR.type & 1) == 1 && this.bpj.limit == 0) {
                    i4 += el(0);
                    i3 = this.bpl + 0;
                } else {
                    i3 = 0;
                }
                fVar.dP(i4);
                this.bpk = i3;
            }
            int el = el(this.bpk);
            int i5 = this.bpk + this.bpl;
            if (el > 0) {
                if (this.bpj.capacity() < this.bpj.limit + el) {
                    this.bpj.data = Arrays.copyOf(this.bpj.data, this.bpj.limit + el);
                }
                fVar.readFully(this.bpj.data, this.bpj.limit, el);
                this.bpj.eY(el + this.bpj.limit);
                if (this.boR.bpv[i5 - 1] != 255) {
                    z = true;
                } else {
                    z = false;
                }
                this.bpm = z;
            }
            if (i5 == this.boR.bpt) {
                i2 = -1;
            } else {
                i2 = i5;
            }
            this.bpk = i2;
        }
        AppMethodBeat.o(92156);
        return true;
    }

    private int el(int i2) {
        int i3 = 0;
        this.bpl = 0;
        while (this.bpl + i2 < this.boR.bpt) {
            int[] iArr = this.boR.bpv;
            int i4 = this.bpl;
            this.bpl = i4 + 1;
            int i5 = iArr[i4 + i2];
            i3 += i5;
            if (i5 != 255) {
                break;
            }
        }
        return i3;
    }
}
