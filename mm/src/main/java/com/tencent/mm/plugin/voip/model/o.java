package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.e;

public final class o {
    public long GUE = 0;
    public long GUF = 0;
    int GXA;
    int GXB;
    int GXC;
    public long GXD;
    long GXE;
    long GXF;
    long GXG;
    long GXH;
    public long GXI;
    long GXJ;
    long GXK;
    long GXL;
    long GXM;
    public int GXN = 0;
    public int GXc;
    public int GXd;
    public int GXe;
    public int GXf;
    byte GXg;
    byte GXh;
    byte GXi;
    byte GXj;
    byte GXk;
    byte GXl;
    byte GXm;
    int GXn;
    public int GXo;
    public int GXp;
    public int GXq;
    public int GXr;
    public int GXs;
    public int GXt;
    public int GXu;
    int GXv;
    int GXw;
    int GXx;
    int GXy;
    int GXz;
    long beginTime = 0;
    String jHj;

    public o() {
        AppMethodBeat.i(114954);
        fGW();
        AppMethodBeat.o(114954);
    }

    public final void fGR() {
        AppMethodBeat.i(114955);
        if (this.beginTime == 0) {
            this.GXf = 0;
        } else {
            this.GXf = (int) (System.currentTimeMillis() - this.beginTime);
        }
        e.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + this.beginTime + ", CurrentTime: " + System.currentTimeMillis());
        e.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + this.GXf);
        AppMethodBeat.o(114955);
    }

    public final void fGS() {
        AppMethodBeat.i(114956);
        if (0 == this.GXE) {
            this.GXE = System.currentTimeMillis();
            e.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + this.GXE);
        }
        AppMethodBeat.o(114956);
    }

    public final void fGT() {
        AppMethodBeat.i(114957);
        if (0 == this.GXF) {
            this.GXF = System.currentTimeMillis();
            e.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + this.GXF);
        }
        AppMethodBeat.o(114957);
    }

    public final void fGU() {
        AppMethodBeat.i(114958);
        this.GXJ = System.currentTimeMillis();
        e.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + this.GXJ);
        AppMethodBeat.o(114958);
    }

    public final void fGV() {
        AppMethodBeat.i(114959);
        if (this.GXI == 0) {
            this.GXy = 0;
        } else {
            this.GXy = (int) (System.currentTimeMillis() - this.GXI);
        }
        e.Logi("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
        e.Logi("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.GXy);
        AppMethodBeat.o(114959);
    }

    public final void reset() {
        this.beginTime = 0;
        this.GXc = 0;
        this.GXd = 0;
        this.GXe = 0;
        this.GXf = 0;
        this.GXg = 0;
        this.GXh = 0;
        this.GXi = 0;
        this.GXj = 0;
        this.GXk = 0;
        this.GXl = 0;
        this.GXm = 0;
        this.GXn = 0;
    }

    public final void fGW() {
        this.GXD = 0;
        this.GXH = 0;
        this.GXI = 0;
        this.GXJ = 0;
        this.GXK = 0;
        this.GXL = 0;
        this.GXE = 0;
        this.GXF = 0;
        this.GXG = 0;
        this.GXo = 0;
        this.GXp = 0;
        this.GXq = 0;
        this.GXr = 0;
        this.GXs = 0;
        this.GXt = 0;
        this.GXu = 0;
        this.GXv = 0;
        this.GXw = 0;
        this.GXx = 0;
        this.GXy = 0;
        this.GXz = 0;
        this.GXA = 0;
        this.GXB = 0;
        this.GXC = 0;
    }

    public final String fGX() {
        AppMethodBeat.i(114960);
        String str = "," + ((int) this.GXm);
        AppMethodBeat.o(114960);
        return str;
    }
}
