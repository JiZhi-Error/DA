package com.tencent.mm.plugin.crashfix.d.a;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.crashfix.jni.BinderProxyTransactNativeHook;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a implements com.tencent.mm.plugin.crashfix.d.a {
    @Override // com.tencent.mm.plugin.crashfix.d.a
    public final void start() {
        AppMethodBeat.i(225321);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix");
        singleMMKV.putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
        singleMMKV.putBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", true);
        singleMMKV.commit();
        AppMethodBeat.o(225321);
    }

    @Override // com.tencent.mm.plugin.crashfix.d.a
    public final void cAM() {
        AppMethodBeat.i(225322);
        MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").putBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", true).commit();
        AppMethodBeat.o(225322);
    }

    @Override // com.tencent.mm.plugin.crashfix.d.a
    public final boolean cAN() {
        AppMethodBeat.i(225323);
        boolean z = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_START_BOOLEAN", false);
        boolean z2 = MultiProcessMMKV.getSingleMMKV("bad_binder_monitor_fix").getBoolean("BAD_BINDER_MONITOR_MMKV_END_BOOLEAN", false);
        Log.i("MicroMsg.BadBinderMonitor", "start ".concat(String.valueOf(z)));
        Log.i("MicroMsg.BadBinderMonitor", "end ".concat(String.valueOf(z2)));
        if (z == z2) {
            AppMethodBeat.o(225323);
            return false;
        }
        AppMethodBeat.o(225323);
        return true;
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean Fh(int i2) {
        AppMethodBeat.i(225324);
        Log.i("MicroMsg.BadBinderMonitor", "api level ".concat(String.valueOf(i2)));
        if (i2 > 28) {
            AppMethodBeat.o(225324);
            return false;
        }
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_bad_binder_monitor, 0);
        Log.i("MicroMsg.BadBinderMonitor", "Expt : ".concat(String.valueOf(a2)));
        if (a2 == 1) {
            AppMethodBeat.o(225324);
            return true;
        }
        AppMethodBeat.o(225324);
        return false;
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean cAO() {
        AppMethodBeat.i(225325);
        BinderProxyTransactNativeHook.init();
        BinderProxyTransactNativeHook.calculateOffset();
        Log.i("MicroMsg.BadBinderMonitor", "init finish");
        try {
            BinderProxyTransactNativeHook.hook(Class.forName("android.os.BinderProxy").getMethod("transactNative", Integer.TYPE, Parcel.class, Parcel.class, Integer.TYPE), BinderProxyTransactNativeHook.class.getMethod("calculateOffset", new Class[0]));
            Log.i("MicroMsg.BadBinderMonitor", "test client hook !");
            ((WifiManager) MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            Log.i("MicroMsg.BadBinderMonitor", "test server hook !");
            Intent intent = new Intent();
            intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.gpu.service.GpuHookServiceImpl");
            MMApplicationContext.getContext().bindService(intent, new ServiceConnection() {
                /* class com.tencent.mm.plugin.crashfix.d.a.a.AnonymousClass1 */

                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AppMethodBeat.i(225319);
                    Log.i("MicroMsg.BadBinderMonitor", "onServiceConnected");
                    AppMethodBeat.o(225319);
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    AppMethodBeat.i(225320);
                    Log.i("MicroMsg.BadBinderMonitor", "onServiceDisconnected");
                    AppMethodBeat.o(225320);
                }
            }, 1);
            Log.i("MicroMsg.BadBinderMonitor", "hook succ ?");
            AppMethodBeat.o(225325);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.BadBinderMonitor", "hook error:" + e2.getCause());
            AppMethodBeat.o(225325);
            return false;
        }
    }
}
