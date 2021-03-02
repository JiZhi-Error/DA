package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.dynamicbackground.a.c;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBackgroundConfig;", "", "()V", "BAN_FPS", "", "CURRENT_DRAW_FPS", "", "DEFAULT_DRAW_FPS", "FRAME_PER_SECOND", "HIGH_FPS", "LAST_APP_FPS", "LOWEST_DRAW_FPS", "LOW_FPS", "MIDDLE_FPS", "MONITOR_CHECK_FPS_DURATION", "", "MONITOR_LAST_CHECK_FPS_TIME", "SLEEP_TIME_IN_MS_PER_FRAME", "", "getSLEEP_TIME_IN_MS_PER_FRAME", "()F", "setSLEEP_TIME_IN_MS_PER_FRAME", "(F)V", "TAG", "lastAppFps", "lastCheckTime", "adjustDynamicBackgroundDrawFps", "", "appFps", "", "computeSleepTimePerFrame", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "needMonitorFps", "", "plugin-taskbar_release"})
public final class a {
    public static int FUW = 20;
    private static float FUX = 16.0f;
    public static int FUY;
    public static final a FUZ = new a();
    private static long lastCheckTime = -1;

    static {
        AppMethodBeat.i(238469);
        AppMethodBeat.o(238469);
    }

    private a() {
    }

    public static float fuY() {
        return FUX;
    }

    public static boolean fuZ() {
        boolean z;
        AppMethodBeat.i(238467);
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (defaultPreference != null) {
            long j2 = defaultPreference.getLong("monitory_last_check_time", -1);
            if (FUY == 0) {
                FUY = defaultPreference.getInt("current_app_fps", 0);
            }
            Log.d("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps lastAppFps: %d, lastCheckTime: %d", Integer.valueOf(FUY), Long.valueOf(j2));
            if (j2 == -1 || FUY <= 45 || System.currentTimeMillis() - j2 > Util.MILLSECONDS_OF_HOUR) {
                defaultPreference.edit().putLong("monitory_last_check_time", System.currentTimeMillis()).apply();
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps needCheck: %b", Boolean.valueOf(z));
        } else {
            z = false;
        }
        AppMethodBeat.o(238467);
        return z;
    }

    public static void fva() {
        AppMethodBeat.i(238468);
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        FUW = defaultPreference != null ? defaultPreference.getInt("current_draw_fps", 20) : 20;
        FUX = (1000.0f / ((float) FUW)) - 20.0f;
        if (FUW == 2) {
            DynamicBackgroundGLSurfaceView.b.C0315b bVar = DynamicBackgroundGLSurfaceView.b.gRP;
            c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo updateAlphaAnimation %d", 1500L);
            DynamicBackgroundGLSurfaceView.b.gRO = 1500;
        }
        Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo computeSleepTimePerFrame: %f, fps: %d, DEFAULT_DRAW_FPS: %d", Float.valueOf(FUX), Integer.valueOf(FUW), 20);
        AppMethodBeat.o(238468);
    }
}
