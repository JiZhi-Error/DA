package com.tencent.mm.plugin.cast.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/cast/service/ScreenCastForegroundService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "Companion", "plugin-cast_release"})
public final class ScreenCastForegroundService extends Service {
    public static final a qmh = new a((byte) 0);

    static {
        AppMethodBeat.i(197255);
        AppMethodBeat.o(197255);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/cast/service/ScreenCastForegroundService$Companion;", "", "()V", "TAG", "", "plugin-cast_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate() {
        AppMethodBeat.i(197252);
        super.onCreate();
        Log.i("MicroMsg.ScreenCastForegroundService", "Service onCreate() is called");
        AppMethodBeat.o(197252);
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(197253);
        p.h(intent, "intent");
        Log.i("MicroMsg.ScreenCastForegroundService", "Service onStartCommand() is called");
        AppMethodBeat.o(197253);
        return 2;
    }

    public final void onDestroy() {
        AppMethodBeat.i(197254);
        super.onDestroy();
        Log.i("MicroMsg.ScreenCastForegroundService", "Service onDestroy");
        AppMethodBeat.o(197254);
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }
}
