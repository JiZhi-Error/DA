package com.tencent.mm.plugin.ipcall.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.widget.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\"\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/ipcall/model/IPCallForegroundService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "setNotificationBind", "Companion", "app_release"})
public final class IPCallForegroundService extends Service {
    private static final String TAG = TAG;
    public static final a yoG = new a((byte) 0);

    public final int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(39603);
        if (!g.aAf().azp()) {
            Log.e(TAG, "error called ipcall foreground service in onStartCommand process");
            stopSelf();
            AppMethodBeat.o(39603);
            return 2;
        }
        if (d.oD(26) && intent != null) {
            Log.i(TAG, "foreground service is on bind ");
            p.h(intent, "intent");
            Log.i(TAG, "setNotificationBind");
            intent.setClass(MMApplicationContext.getContext(), IPCallTalkUI.class);
            intent.setFlags(268435456);
            intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
            String string = MMApplicationContext.getContext().getString(R.string.e6s);
            p.g(string, "MMApplicationContext.get…ip_call_minimize_wording)");
            Log.i(TAG, "IPCallForegroundService notification type is 42");
            if (!g.aAf().azp()) {
                Log.e(TAG, "error called ipcall foreground service in setNotification process");
                stopSelf();
            } else {
                Notification e2 = m.e(com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(string).i(System.currentTimeMillis()).f(MMApplicationContext.getContext().getString(R.string.e6i)).g(string).as(b.ezb()).a(PendingIntent.getActivity(MMApplicationContext.getContext(), 42, intent, 134217728)).et());
                e2.flags |= 32;
                com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.notification.b.a.class);
                p.g(ah, "MMKernel.plugin(IPluginNotification::class.java)");
                ((com.tencent.mm.plugin.notification.b.a) ah).getNotification().a(42, e2, false);
            }
        }
        AppMethodBeat.o(39603);
        return 3;
    }

    public final void onCreate() {
        AppMethodBeat.i(39604);
        Log.i(TAG, "IPCallForegroundService onCreate");
        super.onCreate();
        if (!g.aAf().azp()) {
            stopSelf();
            AppMethodBeat.o(39604);
            return;
        }
        if (d.oD(26)) {
            Notification e2 = m.e(com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(System.currentTimeMillis()).as(b.ezb()).et());
            try {
                if (MMApplicationContext.isMMProcessExist()) {
                    Log.i(TAG, "current mmprocess is exits");
                }
                startForeground(42, e2);
                AppMethodBeat.o(39604);
                return;
            } catch (Exception e3) {
                Log.i(TAG, "start foreground service happened error %s", e3.getMessage());
            }
        }
        AppMethodBeat.o(39604);
    }

    public final void onDestroy() {
        AppMethodBeat.i(39605);
        Log.i(TAG, "IPCallForegroundService onDestroy");
        try {
            stopForeground(true);
        } catch (Exception e2) {
            Log.e(TAG, "onDestroy happened error %s", e2);
        }
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.notification.b.a.class);
        p.g(ah, "MMKernel.plugin(IPluginNotification::class.java)");
        ((com.tencent.mm.plugin.notification.b.a) ah).getNotification().cancel(42);
        super.onDestroy();
        AppMethodBeat.o(39605);
    }

    public final IBinder onBind(Intent intent) {
        AppMethodBeat.i(39606);
        p.h(intent, "intent");
        Log.i(TAG, "onBind");
        AppMethodBeat.o(39606);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/ipcall/model/IPCallForegroundService$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(39607);
        AppMethodBeat.o(39607);
    }
}
