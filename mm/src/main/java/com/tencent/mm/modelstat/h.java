package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h {
    long beginTime;
    long cCv;
    boolean ehd;
    long endTime;
    long jod;
    long joe;
    int rtType;

    public h() {
    }

    public h(int i2, boolean z, long j2) {
        this.rtType = i2;
        this.ehd = z;
        this.jod = j2;
        this.joe = 0;
    }

    public final void bgi() {
        AppMethodBeat.i(151079);
        if (this.joe == 0) {
            this.beginTime = Util.nowMilliSecond();
            this.cCv = Util.currentTicks();
        }
        this.joe++;
        AppMethodBeat.o(151079);
    }

    public final void AH(long j2) {
        AppMethodBeat.i(151080);
        if (this.jod == 0) {
            this.jod = j2;
        }
        this.cCv = Util.currentTicks() - this.cCv;
        this.endTime = Util.nowMilliSecond();
        Log.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.jod + " Count:" + this.joe + " type:" + this.rtType);
        WatchDogPushReceiver.a(this);
        AppMethodBeat.o(151080);
    }
}
