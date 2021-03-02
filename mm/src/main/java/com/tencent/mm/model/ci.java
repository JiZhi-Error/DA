package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class ci {
    private a iFQ = null;
    private long iFR = 0;
    private long iFS = 0;
    private String iFT = "";
    private int iFU = 1;

    public interface a {
        boolean aWx();
    }

    public ci(a aVar) {
        AppMethodBeat.i(132274);
        Assert.assertTrue(true);
        this.iFQ = aVar;
        aWq();
        AppMethodBeat.o(132274);
    }

    private void aWq() {
        this.iFU = 1;
        this.iFR = 0;
        this.iFS = 0;
        this.iFT = "";
    }

    public final synchronized boolean aWr() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(132275);
            long nowMilliSecond = Util.nowMilliSecond();
            this.iFT = Util.getStack().toString();
            if (this.iFU == 1) {
                this.iFS = nowMilliSecond;
                this.iFR = 1800000;
                Log.i("MicroMsg.SyncPauser", "requestToPause currState:STATE_RUNNING timeout:%d %s", 1800000L, this.iFT);
                this.iFU = 2;
                if (this.iFQ.aWx()) {
                    aWt();
                }
                AppMethodBeat.o(132275);
            } else {
                long j2 = this.iFS + this.iFR;
                long j3 = nowMilliSecond + 1800000;
                if (j3 > j2) {
                    this.iFR += j3 - j2;
                }
                Log.i("MicroMsg.SyncPauser", "requestToPause currState:%s ParamTimeout:%d diff:%s newTimeout:%s %s", Integer.valueOf(this.iFU), 1800000L, Long.valueOf(j3 - j2), Long.valueOf(this.iFR), this.iFT);
                AppMethodBeat.o(132275);
                z = false;
            }
        }
        return z;
    }

    public final synchronized void aWs() {
        AppMethodBeat.i(132276);
        Log.d("MicroMsg.SyncPauser", "restartSync currState:%d %s", Integer.valueOf(this.iFU), Util.getStack());
        if (this.iFU == 1) {
            Log.d("MicroMsg.SyncPauser", "warning: restartSync but currState has been STATE_RUNNING %s", Util.getStack());
            AppMethodBeat.o(132276);
        } else {
            aWq();
            xl xlVar = new xl();
            xlVar.edI.status = 1;
            EventCenter.instance.publish(xlVar);
            AppMethodBeat.o(132276);
        }
    }

    public final synchronized void aWt() {
        AppMethodBeat.i(132277);
        if (this.iFU != 2) {
            Log.e("MicroMsg.SyncPauser", "ERR: setFullPause but currState is %d  %s", Integer.valueOf(this.iFU), Util.getStack());
            AppMethodBeat.o(132277);
        } else {
            Log.d("MicroMsg.SyncPauser", "setFullPause waitTime:%d %s", Long.valueOf(Util.milliSecondsToNow(this.iFS)), Util.getStack());
            this.iFU = 3;
            xl xlVar = new xl();
            xlVar.edI.status = 3;
            EventCenter.instance.publish(xlVar);
            AppMethodBeat.o(132277);
        }
    }

    private synchronized void aWu() {
        AppMethodBeat.i(132278);
        if (this.iFU != 1 && this.iFR + this.iFS < Util.nowMilliSecond()) {
            aWs();
        }
        AppMethodBeat.o(132278);
    }

    public final synchronized boolean aWv() {
        boolean z;
        AppMethodBeat.i(132279);
        aWu();
        if (this.iFU == 2) {
            z = true;
            AppMethodBeat.o(132279);
        } else {
            z = false;
            AppMethodBeat.o(132279);
        }
        return z;
    }

    public final synchronized boolean aWw() {
        boolean z;
        AppMethodBeat.i(132280);
        aWu();
        if (this.iFU == 3) {
            z = true;
            AppMethodBeat.o(132280);
        } else {
            z = false;
            AppMethodBeat.o(132280);
        }
        return z;
    }
}
