package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;

public final class aa {
    public boolean gKa;
    public int gKb;
    public int gKc;
    public int gKd;
    public int gKe;
    public int gKf;
    public int gKg;
    public int gKh;
    public int gKi;
    public int mVideoHeight;
    public int mVideoWidth;

    public aa() {
        AppMethodBeat.i(155820);
        reset();
        AppMethodBeat.o(155820);
    }

    public final void reset() {
        this.gKa = false;
        this.mVideoHeight = TbsListener.ErrorCode.EXCEED_INCR_UPDATE;
        this.mVideoWidth = 288;
        this.gKb = 10;
        this.gKc = 3000000;
        this.gKd = 1;
        this.gKe = 1;
        this.gKf = 1;
        this.gKg = 0;
        this.gKh = 1;
        this.gKi = 0;
    }
}
