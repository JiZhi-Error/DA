package com.tencent.mm.network;

import android.os.Build;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class ah extends k.a {
    private MTimerHandler iKj = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.network.ah.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(132933);
            int beginBroadcast = ah.this.jFW.beginBroadcast();
            Log.i("MicroMsg.NetworkEvent", "listeners ct : %d", Integer.valueOf(beginBroadcast));
            for (int i2 = beginBroadcast - 1; i2 >= 0; i2--) {
                try {
                    ((p) ah.this.jFW.getBroadcastItem(i2)).onNetworkChange(ah.this.jFT);
                } catch (RemoteException e2) {
                    Log.e("MicroMsg.NetworkEvent", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            ah.this.jFW.finishBroadcast();
            AppMethodBeat.o(132933);
            return false;
        }
    }, false);
    private int jFT = 4;
    private long jFU;
    private int jFV = 0;
    private final RemoteCallbackList<p> jFW = new RemoteCallbackList<>();

    public ah() {
        AppMethodBeat.i(132934);
        AppMethodBeat.o(132934);
    }

    @Override // com.tencent.mm.network.k
    public final int bjC() {
        AppMethodBeat.i(132935);
        int i2 = 0 > Util.secondsToNow(this.jFU) ? 5 : this.jFT;
        Log.i("MicroMsg.NetworkEvent", "getNowStatus = %d", Integer.valueOf(i2));
        AppMethodBeat.o(132935);
        return i2;
    }

    private boolean uB(int i2) {
        if (i2 == this.jFT) {
            return false;
        }
        if (3 != i2) {
            if (2 == i2) {
                if (this.jFT == 0 || this.jFT == 1) {
                    return false;
                }
                this.jFV++;
                if (this.jFV > 0) {
                    this.jFT = 2;
                    return true;
                }
            } else if (4 == i2) {
                this.jFV = 0;
                this.jFT = 4;
                return true;
            } else if (Build.VERSION.SDK_INT >= 26 && i2 == -1) {
                this.jFT = 0;
                return true;
            }
            this.jFT = i2;
            return true;
        } else if (this.jFT != 2) {
            return false;
        } else {
            this.jFT = i2;
            return true;
        }
    }

    @Override // com.tencent.mm.network.k
    public final boolean c(p pVar) {
        AppMethodBeat.i(132936);
        try {
            this.jFW.register(pVar);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetworkEvent", "addListener %s", e2);
            Log.e("MicroMsg.NetworkEvent", "exception:%s", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(132936);
        return true;
    }

    @Override // com.tencent.mm.network.k
    public final boolean d(p pVar) {
        boolean z = false;
        AppMethodBeat.i(132937);
        try {
            z = this.jFW.unregister(pVar);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetworkEvent", "removeListener %s", e2);
            Log.e("MicroMsg.NetworkEvent", "exception:%s", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(132937);
        return z;
    }

    @Override // com.tencent.mm.network.k
    public final void bjD() {
        AppMethodBeat.i(132938);
        this.jFW.kill();
        AppMethodBeat.o(132938);
    }

    public final void uC(int i2) {
        AppMethodBeat.i(132939);
        Log.i("MicroMsg.NetworkEvent", "networkChange : %d", Integer.valueOf(i2));
        if (!uB(i2)) {
            AppMethodBeat.o(132939);
        } else if (this.jFT == 0 || this.jFT == 4 || this.jFT == 6) {
            this.iKj.startTimer(1000);
            AppMethodBeat.o(132939);
        } else {
            AppMethodBeat.o(132939);
        }
    }

    @Override // com.tencent.mm.network.k
    public final long bjE() {
        return this.jFU;
    }
}
