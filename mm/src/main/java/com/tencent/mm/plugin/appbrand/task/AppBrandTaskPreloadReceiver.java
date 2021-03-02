package com.tencent.mm.plugin.appbrand.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.Log;

public class AppBrandTaskPreloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(48472);
        c("", intent);
        AppMethodBeat.o(48472);
    }

    public static void c(String str, Intent intent) {
        AppMethodBeat.i(48473);
        if (intent == null) {
            Log.e("MicroMsg.AppBrandTaskPreloadReceiver", "[PreloadProfile][%s] Receiver get NULL intent", str);
            AppMethodBeat.o(48473);
            return;
        }
        intent.setExtrasClassLoader(AppBrandPreloadProfiler.class.getClassLoader());
        int intExtra = intent.getIntExtra("EXTRA_KEY_LEVEL", 2);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long longExtra = intent.getLongExtra("EXTRA_KEY_TRIGGER_TIME", -1);
        e.a(g.L(intent), (AppBrandPreloadProfiler) intent.getParcelableExtra("preloadProfiler"), intent.getBooleanExtra("EXTRA_KEY_AGGRESSIVE", false), intExtra);
        Log.i("MicroMsg.AppBrandTaskPreloadReceiver", "[PreloadProfile][%s] Trigger cost [%d]ms Receiver cost [%d]ms, at [%d], level [%d]", str, Long.valueOf(SystemClock.elapsedRealtime() - longExtra), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Long.valueOf(elapsedRealtime), Integer.valueOf(intExtra));
        AppMethodBeat.o(48473);
    }
}
