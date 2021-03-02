package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class w {
    private static final Object gIM = new Object();

    public static v e(Looper looper) {
        AppMethodBeat.i(155760);
        if (looper == null) {
            v vVar = new v(Camera.open());
            AppMethodBeat.o(155760);
            return vVar;
        }
        v vVar2 = new v(d(-1, looper));
        AppMethodBeat.o(155760);
        return vVar2;
    }

    static {
        AppMethodBeat.i(155764);
        AppMethodBeat.o(155764);
    }

    public static v b(int i2, Looper looper) {
        AppMethodBeat.i(155761);
        if (d.oD(28)) {
            try {
                v vVar = new v(c(i2, looper));
                AppMethodBeat.o(155761);
                return vVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMCamera", e2, "opnImpl error, try camera directly, myLooper: %s", Looper.myLooper());
                if (Looper.myLooper() == null) {
                    v vVar2 = new v(d(i2, looper));
                    AppMethodBeat.o(155761);
                    return vVar2;
                }
                v vVar3 = new v(Camera.open(i2));
                AppMethodBeat.o(155761);
                return vVar3;
            }
        } else {
            v vVar4 = new v(c(i2, looper));
            AppMethodBeat.o(155761);
            return vVar4;
        }
    }

    private static Camera c(int i2, Looper looper) {
        AppMethodBeat.i(155762);
        if (looper == null) {
            Camera open = Camera.open(i2);
            AppMethodBeat.o(155762);
            return open;
        }
        Camera d2 = d(i2, looper);
        AppMethodBeat.o(155762);
        return d2;
    }

    private static Camera d(final int i2, Looper looper) {
        Camera open;
        AppMethodBeat.i(155763);
        if (looper == Looper.getMainLooper() && Looper.getMainLooper() == Looper.myLooper()) {
            if (i2 >= 0) {
                open = Camera.open(i2);
            } else {
                open = Camera.open();
            }
            AppMethodBeat.o(155763);
            return open;
        }
        final Camera[] cameraArr = {null};
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.compatible.deviceinfo.w.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(155759);
                try {
                    if (i2 >= 0) {
                        cameraArr[0] = Camera.open(i2);
                    } else {
                        cameraArr[0] = Camera.open();
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MMCamera", e2, "syncCreateCamera error in new free thread", new Object[0]);
                }
                synchronized (w.gIM) {
                    try {
                        w.gIM.notifyAll();
                        Log.i("MicroMsg.MMCamera", "openCamera notifyAll");
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.MMCamera", e3, "MMCamera_openLooperNull notify error", new Object[0]);
                    }
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(155759);
                        throw th;
                    }
                }
                AppMethodBeat.o(155759);
            }
        });
        synchronized (gIM) {
            try {
                if (cameraArr[0] == null) {
                    gIM.wait();
                }
                Log.i("MicroMsg.MMCamera", "openCamera wait finish");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMCamera", e2, "MMCamera_openLooperNull wait error", new Object[0]);
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(155763);
                throw th;
            }
        }
        Camera camera = cameraArr[0];
        AppMethodBeat.o(155763);
        return camera;
    }
}
