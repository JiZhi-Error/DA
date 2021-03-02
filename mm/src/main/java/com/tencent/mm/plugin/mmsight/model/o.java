package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

/* access modifiers changed from: package-private */
public final class o {
    boolean imC = false;
    d.a.C0301a imD;
    final Object lock = new byte[0];

    o() {
        AppMethodBeat.i(89445);
        AppMethodBeat.o(89445);
    }

    public final d.a.C0301a B(final Context context, final int i2) {
        AppMethodBeat.i(89446);
        if (context == null) {
            AppMethodBeat.o(89446);
            return null;
        }
        final long nowMilliSecond = Util.nowMilliSecond();
        final long id = Thread.currentThread().getId();
        synchronized (this.lock) {
            try {
                this.imC = false;
                this.imD = null;
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.model.o.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(89444);
                        Log.i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", Long.valueOf(id), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
                        synchronized (o.this.lock) {
                            try {
                                o.this.imD = d.a(context, i2, Looper.getMainLooper());
                            } catch (Exception e2) {
                                Log.e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", e2.getMessage());
                                o.this.imD = null;
                            }
                            try {
                                if (o.this.imC && o.this.imD != null) {
                                    Log.e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
                                    try {
                                        v vVar = o.this.imD.gGr;
                                        vVar.setPreviewCallback(null);
                                        vVar.stopPreview();
                                        vVar.release();
                                        o.this.imD = null;
                                    } catch (Exception e3) {
                                        Log.e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", e3.getMessage());
                                    }
                                }
                                o.this.lock.notify();
                            } finally {
                                AppMethodBeat.o(89444);
                            }
                        }
                    }
                }, "SightCamera_openCamera");
                try {
                    this.lock.wait(30000);
                } catch (InterruptedException e2) {
                    Log.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", e2.getMessage());
                }
                if (this.imD == null || this.imD.gGr == null) {
                    this.imC = true;
                    Log.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
                    AppMethodBeat.o(89446);
                    return null;
                }
                Log.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", Long.valueOf(id), Long.valueOf(Util.nowMilliSecond() - nowMilliSecond), this.imD.gGr);
                return this.imD;
            } finally {
                AppMethodBeat.o(89446);
            }
        }
    }
}
