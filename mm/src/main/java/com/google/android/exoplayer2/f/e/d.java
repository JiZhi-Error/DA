package com.google.android.exoplayer2.f.e;

import android.text.Layout;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class d {
    int bCV;
    boolean bCW;
    boolean bCX;
    int bCY = -1;
    int bCZ = -1;
    int bDa = -1;
    int bDb = -1;
    int bDc = -1;
    d bDd;
    Layout.Alignment bDe;
    int backgroundColor;
    String fontFamily;
    float fontSize;
    String id;

    public final int getStyle() {
        int i2 = 0;
        if (this.bDa == -1 && this.bDb == -1) {
            return -1;
        }
        int i3 = this.bDa == 1 ? 1 : 0;
        if (this.bDb == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public final d aU(boolean z) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.i(92858);
        if (this.bDd == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        a.checkState(z2);
        if (!z) {
            i2 = 0;
        }
        this.bCY = i2;
        AppMethodBeat.o(92858);
        return this;
    }

    public final d aV(boolean z) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.i(92859);
        if (this.bDd == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        a.checkState(z2);
        if (!z) {
            i2 = 0;
        }
        this.bCZ = i2;
        AppMethodBeat.o(92859);
        return this;
    }

    public final d eS(int i2) {
        AppMethodBeat.i(92860);
        a.checkState(this.bDd == null);
        this.bCV = i2;
        this.bCW = true;
        AppMethodBeat.o(92860);
        return this;
    }

    public final d eT(int i2) {
        this.backgroundColor = i2;
        this.bCX = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final d b(d dVar) {
        AppMethodBeat.i(92861);
        if (dVar != null) {
            if (!this.bCW && dVar.bCW) {
                eS(dVar.bCV);
            }
            if (this.bDa == -1) {
                this.bDa = dVar.bDa;
            }
            if (this.bDb == -1) {
                this.bDb = dVar.bDb;
            }
            if (this.fontFamily == null) {
                this.fontFamily = dVar.fontFamily;
            }
            if (this.bCY == -1) {
                this.bCY = dVar.bCY;
            }
            if (this.bCZ == -1) {
                this.bCZ = dVar.bCZ;
            }
            if (this.bDe == null) {
                this.bDe = dVar.bDe;
            }
            if (this.bDc == -1) {
                this.bDc = dVar.bDc;
                this.fontSize = dVar.fontSize;
            }
            if (!this.bCX && dVar.bCX) {
                eT(dVar.backgroundColor);
            }
        }
        AppMethodBeat.o(92861);
        return this;
    }
}
