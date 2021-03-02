package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.a.j;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class w {
    static b SzM;
    static a SzN;

    public interface a extends b {
        void a(String str, j jVar);

        void hsE();
    }

    public interface b {
        void b(Context context, HashMap<String, String> hashMap);

        boolean isBusy();
    }

    static {
        AppMethodBeat.i(156773);
        l.a g2 = l.g(WebView.c.WV_KIND_CW);
        SzM = (b) g2.excute("STR_CMD_GET_UPDATER", null);
        SzN = (a) g2.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
        AppMethodBeat.o(156773);
    }

    public static void hsB() {
        AppMethodBeat.i(156770);
        if (SzM != null) {
            Log.i("WCWebUpdater", "start check runtime update");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("UpdaterCheckType", "2");
            SzM.b(XWalkEnvironment.getApplicationContext(), hashMap);
            AppMethodBeat.o(156770);
            return;
        }
        Log.e("WCWebUpdater", "no sWebviewUpdater");
        AppMethodBeat.o(156770);
    }

    public static void hsC() {
        AppMethodBeat.i(156771);
        if (SzM != null) {
            Log.i("WCWebUpdater", "start check runtime update");
            new HashMap().put("UpdaterCheckType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            SzM.b(XWalkEnvironment.getApplicationContext(), null);
            AppMethodBeat.o(156771);
            return;
        }
        Log.e("WCWebUpdater", "no sWebviewUpdater");
        AppMethodBeat.o(156771);
    }

    public static void hsD() {
        AppMethodBeat.i(219045);
        if (SzM != null) {
            Log.i("WCWebUpdater", "tryEmbedInstall");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("UpdaterCheckType", "4");
            SzM.b(XWalkEnvironment.getApplicationContext(), hashMap);
            AppMethodBeat.o(219045);
            return;
        }
        Log.e("WCWebUpdater", "no sWebviewUpdater");
        AppMethodBeat.o(219045);
    }

    public static boolean isBusy() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(156772);
        if (SzM != null) {
            z = SzM.isBusy();
        } else {
            Log.e("WCWebUpdater", "check is busy : no sWebviewUpdater");
            z = false;
        }
        if (SzN != null) {
            z2 = SzN.isBusy();
        } else {
            Log.e("WCWebUpdater", "check is busy : no sPluginUpdater");
            z2 = false;
        }
        if (z || z2) {
            AppMethodBeat.o(156772);
            return true;
        }
        AppMethodBeat.o(156772);
        return false;
    }

    public static void b(Context context, HashMap<String, String> hashMap) {
        AppMethodBeat.i(156769);
        synchronized (w.class) {
            try {
                h.huE();
                if (SzM != null) {
                    Log.i("WCWebUpdater", "start check runtime update");
                    SzM.b(context, hashMap);
                } else {
                    Log.e("WCWebUpdater", "no sWebviewUpdater");
                }
                if (SzN != null) {
                    h.hux();
                    SzN.b(context, hashMap);
                } else {
                    Log.e("WCWebUpdater", "no sPluginUpdater");
                }
            } finally {
                AppMethodBeat.o(156769);
            }
        }
    }
}
