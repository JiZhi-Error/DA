package com.tencent.mm.plugin.freewifi.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.plugin.freewifi.b.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b {
    /* synthetic */ b(byte b2) {
        this();
    }

    public static class a {
        private static b wOf = new b((byte) 0);

        static {
            AppMethodBeat.i(24747);
            AppMethodBeat.o(24747);
        }
    }

    private b() {
    }

    public final synchronized void a(ft ftVar) {
        AppMethodBeat.i(24748);
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        final String removeSsidQuote = m.removeSsidQuote(ftVar.dIV.ssid);
        final String str = ftVar.dIV.bssid;
        if (m.eP(removeSsidQuote)) {
            a(ftVar, 1141, "Ssid is empty.");
            AppMethodBeat.o(24748);
        } else if (m.eP(str)) {
            a(ftVar, 1142, "Bssid is empty.");
            AppMethodBeat.o(24748);
        } else {
            Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + ftVar.dIV.ssid + "; bssid=" + ftVar.dIV.bssid + "; version=" + ftVar.dIV.version);
            Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
            a.b hs = a.C1370a.wOb.hs(removeSsidQuote, str);
            Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
            if (hs != null) {
                final String str2 = hs.dFd;
                int i2 = hs.wNc;
                if (i2 == 4) {
                    Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.freewifi.b.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(24745);
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", str2);
                            intent.putExtra("free_wifi_sessionkey", m.dMJ());
                            intent.putExtra("free_wifi_source", 6);
                            intent.addFlags(67108864);
                            c.b(MMApplicationContext.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                            AppMethodBeat.o(24745);
                        }
                    });
                    a(ftVar, 1, null);
                    AppMethodBeat.o(24748);
                } else if (i2 == 31) {
                    Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.freewifi.b.b.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(24746);
                            Intent intent = new Intent();
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", removeSsidQuote);
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", str);
                            intent.setClass(MMApplicationContext.getContext(), FreeWifiManufacturerLoadingUI.class);
                            intent.addFlags(268435456);
                            Context context = MMApplicationContext.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/freewifi/manufacturer/FreeWifiManufacturerConnectWifiHelper$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/freewifi/manufacturer/FreeWifiManufacturerConnectWifiHelper$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(24746);
                        }
                    });
                    a(ftVar, 1, null);
                    AppMethodBeat.o(24748);
                } else {
                    a(ftVar, 1143, "Wechant installed Currently doesn't support connect protocol ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(24748);
                }
            } else if (a.C1370a.wOb.size() == 0) {
                a(ftVar, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
                AppMethodBeat.o(24748);
            } else {
                a(ftVar, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
                AppMethodBeat.o(24748);
            }
        }
    }

    private static void a(ft ftVar, int i2, String str) {
        AppMethodBeat.i(24749);
        ftVar.dIW.dIZ = i2;
        ftVar.dIW.dJa = str;
        ftVar.dIW.dIY = 1;
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", Integer.valueOf(i2), str);
        if (ftVar.callback != null) {
            ftVar.callback.run();
        }
        AppMethodBeat.o(24749);
    }
}
