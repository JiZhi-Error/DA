package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class e {
    c[] cgD;
    private final f cgE;
    final ArrayList<d> cgS = new ArrayList<>();
    Set<Character> cgT;

    e(f fVar) {
        AppMethodBeat.i(39849);
        this.cgE = fVar;
        AppMethodBeat.o(39849);
    }

    /* access modifiers changed from: package-private */
    public final void b(char[] cArr) {
        AppMethodBeat.i(39850);
        if (this.cgD == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Need to call #setCharacterLists first.");
            AppMethodBeat.o(39850);
            throw illegalStateException;
        }
        int i2 = 0;
        while (i2 < this.cgS.size()) {
            if (this.cgS.get(i2).IM() > 0.0f) {
                i2++;
            } else {
                this.cgS.remove(i2);
            }
        }
        int[] a2 = a.a(IP(), cArr, this.cgT);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < a2.length; i5++) {
            switch (a2[i5]) {
                case 0:
                    break;
                case 1:
                    this.cgS.add(i4, new d(this.cgD, this.cgE));
                    break;
                case 2:
                    this.cgS.get(i4).q(0);
                    i4++;
                    continue;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown action: " + a2[i5]);
                    AppMethodBeat.o(39850);
                    throw illegalArgumentException;
            }
            this.cgS.get(i4).q(cArr[i3]);
            i4++;
            i3++;
        }
        AppMethodBeat.o(39850);
    }

    /* access modifiers changed from: package-private */
    public final void onAnimationEnd() {
        AppMethodBeat.i(39851);
        int size = this.cgS.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = this.cgS.get(i2);
            dVar.IN();
            dVar.cgO = dVar.cgM;
        }
        AppMethodBeat.o(39851);
    }

    /* access modifiers changed from: package-private */
    public final void setAnimationProgress(float f2) {
        AppMethodBeat.i(39852);
        int size = this.cgS.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = this.cgS.get(i2);
            if (f2 == 1.0f) {
                dVar.cgF = dVar.cgG;
                dVar.cgP = 0.0f;
                dVar.cgQ = 0.0f;
            }
            float f3 = dVar.cgE.cgK;
            float abs = ((((float) Math.abs(dVar.endIndex - dVar.startIndex)) * f3) * f2) / f3;
            dVar.cgJ = ((abs - ((float) ((int) abs))) * f3 * ((float) dVar.cgR)) + (dVar.cgQ * (1.0f - f2));
            dVar.cgI = (((int) abs) * dVar.cgR) + dVar.startIndex;
            dVar.cgK = f3;
            dVar.cgM = dVar.cgL + ((dVar.cgN - dVar.cgL) * f2);
        }
        AppMethodBeat.o(39852);
    }

    /* access modifiers changed from: package-private */
    public final float IO() {
        AppMethodBeat.i(39853);
        float f2 = 0.0f;
        int size = this.cgS.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = this.cgS.get(i2);
            dVar.IN();
            f2 += dVar.cgO;
        }
        AppMethodBeat.o(39853);
        return f2;
    }

    /* access modifiers changed from: package-private */
    public final float IM() {
        AppMethodBeat.i(39854);
        float f2 = 0.0f;
        int size = this.cgS.size();
        for (int i2 = 0; i2 < size; i2++) {
            f2 += this.cgS.get(i2).IM();
        }
        AppMethodBeat.o(39854);
        return f2;
    }

    private char[] IP() {
        AppMethodBeat.i(39855);
        int size = this.cgS.size();
        char[] cArr = new char[size];
        for (int i2 = 0; i2 < size; i2++) {
            cArr[i2] = this.cgS.get(i2).cgF;
        }
        AppMethodBeat.o(39855);
        return cArr;
    }
}
