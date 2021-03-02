package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public int dvv;
    public String eag;
    public double iJH = 1.0d;
    public String iJP;
    public String iJQ;
    public int jeT;
    public int jeU;
    public String jeV;
    public float jeW;
    public String jeX;
    public String jeY;
    public String jeZ;
    public String jfa;
    public String jfb;
    public String jfc;
    public String jfd;
    public String jfe;
    public String jff;
    public String jfg;
    public String jfh;
    public String jfi;
    public int jfj;
    public int jfk;
    public String jfl;
    public String jfm;
    public String jfn;
    public long jfo;
    public String jfp;
    public boolean jfq;
    public boolean jfr;
    public String jfs;
    public String jft;
    public boolean jfu;
    public String jfv;
    public String jfw;
    public boolean jfx;
    public String playUrl;
    public String protocol;
    public float volume = 1.0f;

    public final boolean f(f fVar) {
        AppMethodBeat.i(137008);
        if (fVar == null) {
            AppMethodBeat.o(137008);
            return false;
        }
        boolean equals = this.jeV.equals(fVar.jeV);
        AppMethodBeat.o(137008);
        return equals;
    }

    public final boolean g(f fVar) {
        AppMethodBeat.i(198133);
        if (fVar == null) {
            AppMethodBeat.o(198133);
            return false;
        } else if (this.jeT != fVar.jeT || !f(fVar)) {
            AppMethodBeat.o(198133);
            return false;
        } else {
            AppMethodBeat.o(198133);
            return true;
        }
    }
}
