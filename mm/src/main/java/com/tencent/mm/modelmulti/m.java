package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m {
    Boolean jdz = null;

    public interface a {
        void fH(boolean z);
    }

    public m(Context context, final a aVar) {
        AppMethodBeat.i(150782);
        this.jdz = dc(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(new BroadcastReceiver() {
            /* class com.tencent.mm.modelmulti.m.AnonymousClass1 */
            final /* synthetic */ boolean jdB = false;

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(150781);
                String action = intent == null ? "" : intent.getAction();
                Log.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", action);
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    m.this.jdz = Boolean.FALSE;
                } else {
                    m.this.jdz = Boolean.TRUE;
                }
                if (aVar != null) {
                    aVar.fH(m.this.jdz.booleanValue());
                }
                if (this.jdB) {
                    context.unregisterReceiver(this);
                }
                AppMethodBeat.o(150781);
            }
        }, intentFilter);
        AppMethodBeat.o(150782);
    }

    private Boolean dc(Context context) {
        AppMethodBeat.i(150783);
        try {
            Boolean bool = (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
            Log.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", bool, this.jdz);
            AppMethodBeat.o(150783);
            return bool;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(99, 154, 1, false);
            Log.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", this.jdz, Util.stackTraceToString(e2));
            AppMethodBeat.o(150783);
            return null;
        }
    }
}
