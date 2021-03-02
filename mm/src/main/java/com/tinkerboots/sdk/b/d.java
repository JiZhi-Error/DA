package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.util.HashSet;

public final class d {
    private static String SKM;
    private static HashSet<String> SKN = new HashSet<>();

    public interface a {
        void onScreenOff();
    }

    static {
        AppMethodBeat.i(3466);
        AppMethodBeat.o(3466);
    }

    public static String hwb() {
        if (SKM == null) {
            return "";
        }
        return SKM;
    }

    public static boolean hwc() {
        AppMethodBeat.i(3465);
        if (SKM == null) {
            AppMethodBeat.o(3465);
            return false;
        }
        boolean contains = SKN.contains(SKM);
        AppMethodBeat.o(3465);
        return contains;
    }

    public static class b {
        public b(Context context, final a aVar) {
            AppMethodBeat.i(3464);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver() {
                /* class com.tinkerboots.sdk.b.d.b.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(3463);
                    String action = intent == null ? "" : intent.getAction();
                    ShareTinkerLog.v("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", action);
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        context.unregisterReceiver(this);
                        if (aVar != null) {
                            aVar.onScreenOff();
                        }
                    }
                    AppMethodBeat.o(3463);
                }
            }, intentFilter);
            AppMethodBeat.o(3464);
        }
    }
}
