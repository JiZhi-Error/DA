package com.tencent.midas.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;

public class APPluginProxyBroadcastReceiver extends BroadcastReceiver {
    public static void sendBroadcastReceiver(Context context, String str, String str2, Intent intent) {
        AppMethodBeat.i(193163);
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_NAME, str);
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_RECEIVER_CLASS_NAME, str2);
        try {
            context.sendBroadcast(intent);
            AppMethodBeat.o(193163);
        } catch (Throwable th) {
            AppMethodBeat.o(193163);
        }
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(193164);
        IAPPluginBroadcastReceiver startPluginIfNeccessary = startPluginIfNeccessary(context, intent);
        APLog.i("APPLuginProxyBroadcastReciver", "onReceive startPluginIfNeccessary: ".concat(String.valueOf(startPluginIfNeccessary)));
        if (startPluginIfNeccessary != null) {
            startPluginIfNeccessary.IOnReceive(context, intent);
        }
        AppMethodBeat.o(193164);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.midas.plugin.IAPPluginBroadcastReceiver startPluginIfNeccessary(android.content.Context r9, android.content.Intent r10) {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginProxyBroadcastReceiver.startPluginIfNeccessary(android.content.Context, android.content.Intent):com.tencent.midas.plugin.IAPPluginBroadcastReceiver");
    }
}
