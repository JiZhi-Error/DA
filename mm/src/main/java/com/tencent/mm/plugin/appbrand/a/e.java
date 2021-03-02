package com.tencent.mm.plugin.appbrand.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public abstract class e {
    private final WeakReference<Activity> kRw;
    public final BroadcastReceiver receiver = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.appbrand.a.e.AnonymousClass1 */
        final String kRx = "reason";
        final String kRy = "homekey";
        final String kRz = "recentapps";

        public final void onReceive(Context context, Intent intent) {
            String stringExtra;
            AppMethodBeat.i(139837);
            if (intent == null) {
                AppMethodBeat.o(139837);
                return;
            }
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && (stringExtra = intent.getStringExtra("reason")) != null) {
                Log.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", intent.getAction(), stringExtra);
                if (stringExtra.equals("homekey")) {
                    e.this.bxc();
                    AppMethodBeat.o(139837);
                    return;
                } else if (stringExtra.equals("recentapps")) {
                    e.this.bxd();
                }
            }
            AppMethodBeat.o(139837);
        }
    };

    /* access modifiers changed from: protected */
    public abstract void bxc();

    /* access modifiers changed from: protected */
    public abstract void bxd();

    public e(Activity activity) {
        this.kRw = new WeakReference<>(activity);
    }
}
