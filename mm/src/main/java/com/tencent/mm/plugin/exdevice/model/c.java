package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c implements d {
    private static c rxS;
    private byte[] glH = new byte[0];
    private final Map<Integer, Set<d>> iMA = new HashMap();
    private MMHandler mHandler = new MMHandler("ExdeviceHandlerThread");
    public m rxT;
    a rxU;
    Vector<ae> rxV = new Vector<>();

    public interface a {
        void cKs();
    }

    public c() {
        AppMethodBeat.i(23200);
        AppMethodBeat.o(23200);
    }

    public final boolean a(final ae aeVar) {
        AppMethodBeat.i(23201);
        this.mHandler.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.model.c.AnonymousClass2 */

            public final void run() {
                boolean z = true;
                AppMethodBeat.i(23199);
                c cVar = c.this;
                ae aeVar = aeVar;
                if (cVar.rxT == null) {
                    Log.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
                    if (cVar.rxU != null) {
                        Log.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
                        cVar.rxU.cKs();
                        new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                            /* class com.tencent.mm.plugin.exdevice.model.c.AnonymousClass1 */
                            private long timeout = 10;

                            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                            public final boolean onTimerExpired() {
                                AppMethodBeat.i(23198);
                                if (c.this.rxT == null) {
                                    long j2 = this.timeout;
                                    this.timeout = j2 - 1;
                                    if (j2 > 0) {
                                        AppMethodBeat.o(23198);
                                        return true;
                                    }
                                }
                                Log.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", Long.valueOf(this.timeout));
                                if (this.timeout > 0) {
                                    c.this.cKr();
                                }
                                AppMethodBeat.o(23198);
                                return false;
                            }
                        }, true).startTimer(100);
                    } else {
                        Log.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
                    }
                    z = false;
                }
                if (z) {
                    aeVar.a(cVar.rxT, cVar);
                    AppMethodBeat.o(23199);
                    return;
                }
                cVar.rxV.add(aeVar);
                AppMethodBeat.o(23199);
            }
        });
        AppMethodBeat.o(23201);
        return true;
    }

    public static c cKq() {
        AppMethodBeat.i(23202);
        if (rxS == null) {
            rxS = new c();
        }
        c cVar = rxS;
        AppMethodBeat.o(23202);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public final void cKr() {
        AppMethodBeat.i(23203);
        Log.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", Integer.valueOf(this.rxV.size()));
        if (!this.rxV.isEmpty()) {
            a(this.rxV.remove(0));
        }
        AppMethodBeat.o(23203);
    }

    @Override // com.tencent.mm.plugin.exdevice.j.d
    public final void a(long j2, int i2, int i3, String str) {
        AppMethodBeat.i(23204);
        Log.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.rxV.size()));
        synchronized (this.glH) {
            try {
                cKr();
            } finally {
                AppMethodBeat.o(23204);
            }
        }
    }
}
