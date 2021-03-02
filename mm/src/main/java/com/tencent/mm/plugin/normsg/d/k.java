package com.tencent.mm.plugin.normsg.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class k {
    private static a AGu;
    private static boolean hBs = false;

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(149109);
            if (intent == null) {
                AppMethodBeat.o(149109);
                return;
            }
            boolean unused = k.hBs = intent.getExtras().getBoolean(d.INSTANCE.aIJ("3<<;14\"<<"));
            AppMethodBeat.o(149109);
        }
    }

    public static void start() {
        AppMethodBeat.i(149110);
        if (AGu == null) {
            AGu = new a((byte) 0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(d.INSTANCE.aIJ("\u001d\u0011\u001a\u000b\u0017\u0012\u001e[\u001c\u0016\u0004\u0015\u0007\u0012\u0000\bB\u001a\u001d\u000bF\n\t\u0011\r\b\bO50 \u0002\u000f\u000b\u001f\r\u001d"));
        MMApplicationContext.getContext().registerReceiver(AGu, intentFilter);
        AppMethodBeat.o(149110);
    }

    public static void stop() {
        AppMethodBeat.i(149111);
        if (AGu != null) {
            MMApplicationContext.getContext().unregisterReceiver(AGu);
        }
        AGu = null;
        AppMethodBeat.o(149111);
    }

    public static boolean isConnected() {
        return hBs;
    }
}
