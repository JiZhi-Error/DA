package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public float deo = -1.0f;
    public float dep = -1.0f;
    public float qSd = -1.0f;
    public float qSe = -1.0f;
    public int qSf = -1;
    public float qSg = -1.0f;
    public float qSh = -1.0f;
    public float qSi = -1.0f;
    public float qSj = -1.0f;
    public int qSk = -1;
    public int qcr = 0;

    public final void a(int i2, float f2, float f3, float f4, float f5, int i3) {
        this.qcr = i2;
        this.qSd = f2;
        this.qSe = f3;
        this.deo = f4;
        this.dep = f5;
        if (this.qcr == 1) {
            this.qSf = i3;
        } else {
            this.qSf = 0;
        }
    }

    public final void reset() {
        this.qcr = 0;
        this.qSd = -1.0f;
        this.qSe = -1.0f;
        this.deo = -1.0f;
        this.dep = -1.0f;
        this.qSf = -1;
        this.qSg = -1.0f;
        this.qSh = -1.0f;
        this.qSi = -1.0f;
        this.qSj = -1.0f;
        this.qSk = -1;
    }

    private boolean cDR() {
        return this.qSd >= 0.0f && this.qSe >= 0.0f && this.deo >= 0.0f && this.dep >= 0.0f && this.qSf >= 0;
    }

    private boolean cDS() {
        return this.qSg >= 0.0f && this.qSh >= 0.0f && this.qSi >= 0.0f && this.qSj >= 0.0f && this.qSk >= 0;
    }

    public final int getType() {
        AppMethodBeat.i(30548);
        if (!cDR()) {
            AppMethodBeat.o(30548);
            return 0;
        } else if (!cDS()) {
            AppMethodBeat.o(30548);
            return 1;
        } else {
            int abs = Math.abs((int) (this.deo - this.qSi));
            int abs2 = Math.abs((int) (this.dep - this.qSj));
            if (abs > 30 || abs2 > 30 || this.qSf != this.qSk) {
                AppMethodBeat.o(30548);
                return 3;
            }
            AppMethodBeat.o(30548);
            return 2;
        }
    }
}
