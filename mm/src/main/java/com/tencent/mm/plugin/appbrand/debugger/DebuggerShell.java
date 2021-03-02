package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.Map;

public final class DebuggerShell extends BroadcastReceiver implements com.tencent.mm.kernel.c.a, b {
    private static boolean lhB = true;
    private static boolean lhC;
    private final Map<String, a> lhA = new HashMap();

    public interface a {
        void A(Intent intent);

        String name();
    }

    public DebuggerShell() {
        AppMethodBeat.i(44937);
        AppMethodBeat.o(44937);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(44938);
        String stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        if (!Util.isNullOrNil(stringExtra) && this.lhA.containsKey(stringExtra)) {
            this.lhA.get(stringExtra).A(intent);
        }
        AppMethodBeat.o(44938);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(44939);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.appbrand.debugger");
        MMApplicationContext.getContext().registerReceiver(this, intentFilter);
        for (a aVar : a.lhz) {
            if (aVar != null && !Util.isNullOrNil(aVar.name())) {
                this.lhA.put(aVar.name(), aVar);
            }
        }
        AppMethodBeat.o(44939);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        AppMethodBeat.i(44940);
        MMApplicationContext.getContext().unregisterReceiver(this);
        this.lhA.clear();
        AppMethodBeat.o(44940);
    }

    public static boolean bAx() {
        return lhC;
    }

    public static boolean bAy() {
        AppMethodBeat.i(44941);
        if (lhC || WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(44941);
            return true;
        }
        AppMethodBeat.o(44941);
        return false;
    }

    public static void gV(boolean z) {
        AppMethodBeat.i(226504);
        lhB = z;
        MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").putBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", z);
        b.bAE();
        AppMethodBeat.o(226504);
    }

    public static boolean bAz() {
        return lhB;
    }

    static {
        AppMethodBeat.i(44944);
        bAA();
        AppMethodBeat.o(44944);
    }

    static void bAA() {
        AppMethodBeat.i(226505);
        lhC = false;
        Log.d("MicroMsg.DebuggerShell", "<clinit> BuildConfig.ENABLE_APPBRAND_MONKEY_TEST=%b", Boolean.valueOf(lhC));
        if (!lhC && (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger())) {
            lhC = MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
            Log.d("MicroMsg.DebuggerShell", "<clinit> ENABLE_MONKEY from mmkv = %b", Boolean.valueOf(lhC));
        }
        if (lhC) {
            lhB = MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").getBoolean("KEY_SKIP_APPBRAND_PROCESS_SUICIDE", true);
        }
        AppMethodBeat.o(226505);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void bAB() {
        AppMethodBeat.i(44942);
        MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).commit();
        lhC = true;
        o.bVl();
        b.bAE();
        AppMethodBeat.o(44942);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void bAC() {
        AppMethodBeat.i(44943);
        MultiProcessMMKV.getMMKV("ENABLE_APPBRAND_DEBUGGER").edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).commit();
        lhC = false;
        AppMethodBeat.o(44943);
    }
}
