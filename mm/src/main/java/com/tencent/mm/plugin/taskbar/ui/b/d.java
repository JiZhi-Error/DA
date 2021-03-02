package com.tencent.mm.plugin.taskbar.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;

public enum d {
    INSTANCE;
    
    private WeakReference<Context> hkm = null;
    public HashMap<Integer, b> hkn = new HashMap<>();
    public final Object hkp = new Object();
    public boolean isRunning = false;
    public Timer mTimer = null;

    private d(String str) {
        AppMethodBeat.i(238326);
        AppMethodBeat.o(238326);
    }

    public static d valueOf(String str) {
        AppMethodBeat.i(238325);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(238325);
        return dVar;
    }

    static {
        AppMethodBeat.i(238329);
        AppMethodBeat.o(238329);
    }

    public final void axH() {
        AppMethodBeat.i(238327);
        synchronized (this.hkp) {
            try {
                if (this.isRunning) {
                    if (this.mTimer != null) {
                        this.mTimer.cancel();
                    }
                    this.isRunning = false;
                    AppMethodBeat.o(238327);
                }
            } finally {
                AppMethodBeat.o(238327);
            }
        }
    }

    public final void release() {
        AppMethodBeat.i(238328);
        Log.i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
        if (this.hkn != null) {
            this.hkn.clear();
        }
        AppMethodBeat.o(238328);
    }
}
