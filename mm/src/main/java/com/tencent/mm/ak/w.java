package com.tencent.mm.ak;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.n;
import com.tencent.mm.network.s;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class w extends n.a {
    private final q dGJ;
    private final g dispatcher;
    final MMHandler handler;
    private final long iMN = 330000;
    private s iMO;
    private m iMP;
    private boolean iMQ = false;
    Runnable iMR = new Runnable() {
        /* class com.tencent.mm.ak.w.AnonymousClass1 */

        public final void run() {
            int i2 = 0;
            AppMethodBeat.i(132419);
            if (w.this.ifz || w.this.iMQ) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(w.this.dGJ == null ? 0 : w.this.dGJ.hashCode());
                if (w.this.dGJ != null) {
                    i2 = w.this.dGJ.getType();
                }
                objArr[1] = Integer.valueOf(i2);
                Log.e("MicroMsg.RemoteOnGYNetEnd", "time exceed But removeCallbacks failed hash:%d type:%d", objArr);
                AppMethodBeat.o(132419);
                return;
            }
            final boolean z = w.this.ifz;
            final boolean z2 = w.this.iMQ;
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(w.this.dGJ == null ? 0 : w.this.dGJ.hashCode());
            if (w.this.dGJ != null) {
                i2 = w.this.dGJ.getType();
            }
            objArr2[1] = Integer.valueOf(i2);
            Log.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback hash:%d type:%d", objArr2);
            w.this.ifz = true;
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.ak.w.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    int i2 = 0;
                    AppMethodBeat.i(132418);
                    w.this.dispatcher.MI("push process's network haven't callback in 5.5min!!!! cancelStatus:" + z + " hasCallbackStatus:" + z2);
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(w.this.dGJ == null ? 0 : w.this.dGJ.hashCode());
                    if (w.this.dGJ != null) {
                        i2 = w.this.dGJ.getType();
                    }
                    objArr[1] = Integer.valueOf(i2);
                    Log.w("MicroMsg.RemoteOnGYNetEnd", "time exceed, force to callback . kill push fin. hash:%d type:%d", objArr);
                    AppMethodBeat.o(132418);
                }
            }, "RemoteOnGYNetEnd_killPush");
            w.this.iMP.onGYNetEnd(-1, 3, -1, "time exceed, force to callback", w.this.iMO, null);
            AppMethodBeat.o(132419);
        }
    };
    private boolean ifz = false;
    private final i queueCallback;

    public w(s sVar, m mVar, q qVar, i iVar, g gVar) {
        AppMethodBeat.i(132421);
        this.iMO = sVar;
        this.iMP = mVar;
        this.dGJ = qVar;
        this.queueCallback = iVar;
        this.handler = Looper.myLooper() == null ? new MMHandler(Looper.getMainLooper()) : new MMHandler();
        this.dispatcher = gVar;
        AppMethodBeat.o(132421);
    }

    public final void cancel() {
        AppMethodBeat.i(132422);
        this.ifz = true;
        this.handler.removeCallbacks(this.iMR);
        AppMethodBeat.o(132422);
    }

    @Override // com.tencent.mm.network.n
    public final void a(final int i2, final int i3, final int i4, final String str, t tVar, final byte[] bArr) {
        AppMethodBeat.i(132423);
        Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.ifz), Integer.valueOf(this.dGJ.hashCode()), Integer.valueOf(this.iMO.hashCode()));
        this.dGJ.updateDispatchIdNew(-1);
        if (this.ifz) {
            AppMethodBeat.o(132423);
        } else if (!this.iMQ) {
            this.iMQ = true;
            this.handler.removeCallbacks(this.iMR);
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.ak.w.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(132420);
                    if (w.this.ifz) {
                        Log.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", Integer.valueOf(i2));
                        AppMethodBeat.o(132420);
                        return;
                    }
                    int i2 = i3;
                    int i3 = i4;
                    if (10016 == ac.jOC && !Util.isNullOrNil(ac.jOE)) {
                        Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", ac.jOE);
                        String[] split = ac.jOE.split(",");
                        if (split != null && split.length == 3 && Util.getInt(split[0], -1) == w.this.dGJ.getType()) {
                            i2 = Util.getInt(split[1], 0);
                            i3 = Util.getInt(split[2], 0);
                            if (i2 == 999) {
                                Log.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", ac.jOE);
                                AppMethodBeat.o(132420);
                                return;
                            }
                        }
                    }
                    Log.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", Integer.valueOf(i2), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(w.this.ifz), Integer.valueOf(w.this.dGJ.hashCode()));
                    w.this.iMP.onGYNetEnd(i2, i2, i3, str, w.this.iMO, bArr);
                    if (w.this.dGJ.needCheckCallback() && !w.this.dGJ.hasCallBackToQueue()) {
                        Log.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", Integer.valueOf(w.this.dGJ.getType()));
                        Log.appenderFlush();
                        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                            h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.ak.w.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(197066);
                                    Toast.makeText(MMApplicationContext.getContext(), "the netscene hasn't call callback to onSceneEnd, type:" + w.this.dGJ.getType(), 1).show();
                                    AppMethodBeat.o(197066);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(132420);
                }
            });
            AppMethodBeat.o(132423);
        } else {
            AppMethodBeat.o(132423);
        }
    }
}
