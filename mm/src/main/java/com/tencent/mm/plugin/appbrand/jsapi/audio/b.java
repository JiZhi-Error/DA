package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.HandlerThread;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static volatile HandlerThread lDE;
    private static String lDF = "app_brand_audio_player";
    private static AtomicInteger lDG = new AtomicInteger(0);
    private static Object lockObj = new Object();
    private static MMHandler mHandler;

    static {
        AppMethodBeat.i(145694);
        AppMethodBeat.o(145694);
    }

    public static void onCreate(String str) {
        AppMethodBeat.i(145690);
        Log.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", str);
        if (lDG.incrementAndGet() == 1) {
            synchronized (lockObj) {
                try {
                    bEz();
                } finally {
                    AppMethodBeat.o(145690);
                }
            }
            return;
        }
        AppMethodBeat.o(145690);
    }

    private static void bEz() {
        AppMethodBeat.i(145691);
        if (lDE == null) {
            HandlerThread hB = d.hB(lDF, 5);
            lDE = hB;
            hB.start();
            g.a(lDF, new h(lDE.getLooper(), lDF));
        }
        mHandler = new MMHandler(lDE.getLooper());
        AppMethodBeat.o(145691);
    }

    public static void Zl(String str) {
        AppMethodBeat.i(145692);
        Log.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", str);
        if (lDG.decrementAndGet() == 0) {
            synchronized (lockObj) {
                try {
                    if (!(lDE == null || lDE == null)) {
                        g.boG(lDF);
                        lDE.quit();
                        lDE = null;
                        mHandler = null;
                    }
                } finally {
                    AppMethodBeat.o(145692);
                }
            }
            return;
        }
        AppMethodBeat.o(145692);
    }

    public static void Z(Runnable runnable) {
        AppMethodBeat.i(145693);
        synchronized (lockObj) {
            try {
                if (mHandler != null) {
                    mHandler.post(runnable);
                } else {
                    Log.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
                    bEz();
                    mHandler.post(runnable);
                }
            } finally {
                AppMethodBeat.o(145693);
            }
        }
    }
}
