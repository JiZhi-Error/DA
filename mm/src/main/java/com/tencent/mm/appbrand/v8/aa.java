package com.tencent.mm.appbrand.v8;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class aa {
    private static final String TAG = ("MicroMsg.V8MemoryPressureMonitor" + MMApplicationContext.getProcessName().replace(MMApplicationContext.getApplicationId(), ""));
    private final MultiContextV8 doQ;
    private final int drC = 1000;
    private Integer drD = null;
    private boolean drE;
    private int drF = 0;
    private final Runnable drG = new Runnable() {
        /* class com.tencent.mm.appbrand.v8.aa.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(144144);
            aa.a(aa.this);
            AppMethodBeat.o(144144);
        }
    };
    private final ComponentCallbacks2 drH;

    static {
        AppMethodBeat.i(144153);
        AppMethodBeat.o(144153);
    }

    public aa(MultiContextV8 multiContextV8) {
        AppMethodBeat.i(144147);
        this.doQ = multiContextV8;
        this.drH = new ComponentCallbacks2() {
            /* class com.tencent.mm.appbrand.v8.aa.AnonymousClass2 */

            public final void onTrimMemory(int i2) {
                AppMethodBeat.i(144145);
                Log.i(aa.TAG, "onTrimMemory level = [%d]", Integer.valueOf(i2));
                Integer iX = aa.iX(i2);
                if (iX != null) {
                    aa.this.iV(iX.intValue());
                }
                AppMethodBeat.o(144145);
            }

            public final void onConfigurationChanged(Configuration configuration) {
            }

            public final void onLowMemory() {
                AppMethodBeat.i(144146);
                Log.i(aa.TAG, "onLowMemory");
                aa.this.iV(2);
                Log.i(aa.TAG, "onLowMemory notification with CRITICAL end");
                AppMethodBeat.o(144146);
            }
        };
        AppMethodBeat.o(144147);
    }

    public final void iV(int i2) {
        AppMethodBeat.i(144148);
        if (this.drE) {
            Log.i(TAG, "notifyPressure but throttle");
            this.drD = Integer.valueOf(i2);
            AppMethodBeat.o(144148);
            return;
        }
        iW(i2);
        AppMethodBeat.o(144148);
    }

    private void iW(int i2) {
        String str;
        AppMethodBeat.i(144149);
        XR();
        this.drF = i2;
        if (i2 == 2) {
            str = "CRITICAL";
        } else if (i2 == 1) {
            str = "MODERATE";
        } else {
            str = "NONE";
        }
        Log.i(TAG, "reportPressure [%s]", str);
        this.doQ.memoryPressureNotification(i2);
        AppMethodBeat.o(144149);
    }

    private static void XR() {
        AppMethodBeat.i(144150);
        Log.i(TAG, "startThrottlingInterval");
        AppMethodBeat.o(144150);
    }

    static /* synthetic */ void a(aa aaVar) {
        AppMethodBeat.i(144151);
        Log.i(TAG, "onThrottlingIntervalFinished");
        aaVar.drE = false;
        if (!(aaVar.drD == null || aaVar.drF == aaVar.drD.intValue())) {
            int intValue = aaVar.drD.intValue();
            aaVar.drD = null;
            aaVar.iW(intValue);
        }
        AppMethodBeat.o(144151);
    }

    static /* synthetic */ Integer iX(int i2) {
        AppMethodBeat.i(144152);
        if (i2 >= 80 || i2 == 15) {
            AppMethodBeat.o(144152);
            return 2;
        } else if (i2 >= 40) {
            AppMethodBeat.o(144152);
            return 1;
        } else {
            AppMethodBeat.o(144152);
            return null;
        }
    }
}
