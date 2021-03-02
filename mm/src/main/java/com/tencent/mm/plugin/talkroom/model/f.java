package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    private int FPN;
    private long FPO;
    int FPP = 0;
    private int FPQ;
    long FPR;
    int FPS;
    int FPT;
    private int FPU;
    private int FPV;
    private int FPW;
    int FPX;
    int FPY;
    public int FPZ = 0;
    private int FQa;
    private int FQb;
    private int FQc;
    private int FQd;
    private int FQe;
    private int FQf;
    private int FQg;
    private int FQh;
    private int FQi;
    String FQj;
    int FQk;
    int FQl;
    long FQm;
    int FQn;
    long FQo;
    long FQp;
    boolean FQq;
    boolean FQr;
    private long hlg;
    int roomId;
    long ypH;

    public final void abp(int i2) {
        AppMethodBeat.i(29477);
        if (this.FQm == 0) {
            AppMethodBeat.o(29477);
            return;
        }
        this.FPN = i2;
        this.FPO = Util.ticksToNow(this.FQm);
        AppMethodBeat.o(29477);
    }

    public final void ftV() {
        AppMethodBeat.i(29478);
        if (this.FQm == 0) {
            AppMethodBeat.o(29478);
            return;
        }
        this.hlg = Util.ticksToNow(this.FQm);
        AppMethodBeat.o(29478);
    }

    public final void exitRoom() {
        AppMethodBeat.i(29479);
        if (this.FQm == 0) {
            AppMethodBeat.o(29479);
            return;
        }
        this.FPQ = (int) (Util.ticksToNow(this.FQm) / 1000);
        AppMethodBeat.o(29479);
    }

    public final void ftW() {
        this.FPW++;
    }

    public final void ftX() {
        AppMethodBeat.i(29480);
        if (this.FQp == 0) {
            AppMethodBeat.o(29480);
            return;
        }
        long ticksToNow = Util.ticksToNow(this.FQp) / 1000;
        if (ticksToNow < 2) {
            this.FQa++;
        } else if (ticksToNow < 6) {
            this.FQb++;
        } else if (ticksToNow < 11) {
            this.FQc++;
        } else if (ticksToNow < 21) {
            this.FQd++;
        } else if (ticksToNow < 31) {
            this.FQe++;
        } else if (ticksToNow < 41) {
            this.FQf++;
        } else if (ticksToNow < 51) {
            this.FQg++;
        } else if (ticksToNow < 61) {
            this.FQh++;
        } else {
            this.FQi++;
        }
        this.FQp = 0;
        AppMethodBeat.o(29480);
    }

    public final String toString() {
        AppMethodBeat.i(29481);
        String str = this.FPN + "," + this.FPO + "," + this.hlg + "," + this.FPP + "," + this.FPQ + "," + this.FPR + "," + this.FPS + "," + this.FPT + "," + this.FPU + "," + this.FPV + "," + this.FPW + "," + this.FPX + "," + this.FPY + "," + this.FPZ + "," + this.FQa + "," + this.FQb + "," + this.FQc + "," + this.FQd + "," + this.FQe + "," + this.FQf + "," + this.FQg + "," + this.FQh + "," + this.FQi + "," + this.FQj + "," + this.roomId + "," + this.ypH + "," + this.FQk + "," + this.FQl;
        AppMethodBeat.o(29481);
        return str;
    }
}
