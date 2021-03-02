package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BatteryManager {
    public static BatteryChangedReceiver JpJ;
    public static boolean xvy;

    public static class BatteryChangedReceiver extends BroadcastReceiver {
        private BatteryChangedReceiver() {
        }

        public /* synthetic */ BatteryChangedReceiver(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(80804);
            if (intent == null) {
                AppMethodBeat.o(80804);
            } else if ("android.intent.action.BATTERY_OKAY".equals(intent.getAction())) {
                BatteryManager.xvy = false;
                AppMethodBeat.o(80804);
            } else {
                if ("android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                    BatteryManager.xvy = true;
                }
                AppMethodBeat.o(80804);
            }
        }
    }
}
