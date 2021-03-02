package com.tencent.mm.danmaku.f;

import android.app.Application;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.c;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    private static final AtomicInteger QH = new AtomicInteger(1);
    private static volatile Application gQX;
    private static volatile boolean gQY;

    public static boolean atn() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean ato() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean atp() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean atq() {
        return Build.VERSION.SDK_INT >= 26;
    }

    static {
        AppMethodBeat.i(241779);
        AppMethodBeat.o(241779);
    }

    public static Application atr() {
        AppMethodBeat.i(241778);
        Application arU = c.arU();
        if (arU != null) {
            AppMethodBeat.o(241778);
            return arU;
        }
        if (!gQY) {
            synchronized (a.class) {
                try {
                    if (!gQY) {
                        try {
                            Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                            gQX = application;
                            if (application != null) {
                                gQY = true;
                            }
                        } catch (Throwable th) {
                            gQY = true;
                        }
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(241778);
                    throw th2;
                }
            }
        }
        Application application2 = gQX;
        AppMethodBeat.o(241778);
        return application2;
    }
}
