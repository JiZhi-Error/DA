package com.tencent.mm.cr;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.abg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ah;
import com.tencent.xweb.ai;
import com.tencent.xweb.y;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class d {
    static a Rzm = null;
    static boolean Rzn = true;
    static boolean Rzo = true;
    static String Rzp = "20201215";
    static String Rzq = null;
    static String Rzr = null;
    static int Rzs = 3600000;
    static long Rzt = Util.MILLSECONDS_OF_HOUR;

    public interface a {
        String cMs();

        boolean isInstalled();
    }

    public static synchronized void a(a aVar) {
        synchronized (d.class) {
            AppMethodBeat.i(223920);
            Rzm = aVar;
            hiz();
            Log.i("XWebUtil", "setExpansionImp stack = ");
            AppMethodBeat.o(223920);
        }
    }

    public static void hiy() {
        AppMethodBeat.i(152944);
        bpH("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        bpI("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
        AppMethodBeat.o(152944);
    }

    public static void bpG(String str) {
        AppMethodBeat.i(152945);
        bpH(str);
        bpI(str);
        AppMethodBeat.o(152945);
    }

    public static void bJ(Intent intent) {
        AppMethodBeat.i(152946);
        intent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        MMApplicationContext.getContext().sendBroadcast(intent);
        if (c.ayt()) {
            AppMethodBeat.o(152946);
            return;
        }
        intent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(152946);
    }

    private static void bpH(String str) {
        AppMethodBeat.i(152947);
        if (!"com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(str) || MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":tools")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", str);
            MMApplicationContext.getContext().sendBroadcast(intent);
            AppMethodBeat.o(152947);
            return;
        }
        AppMethodBeat.o(152947);
    }

    public static void bpI(String str) {
        AppMethodBeat.i(152948);
        if (c.ayt()) {
            AppMethodBeat.o(152948);
        } else if (!"com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(str) || MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":toolsmp")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", str);
            MMApplicationContext.getContext().sendBroadcast(intent);
            AppMethodBeat.o(152948);
        } else {
            AppMethodBeat.o(152948);
        }
    }

    public static boolean kS(Context context) {
        AppMethodBeat.i(152949);
        if (!WebView.isX5() || WebView.getUsingTbsCoreVersion(context) > 36541) {
            AppMethodBeat.o(152949);
            return true;
        }
        Log.i("XWebUtil", "lower version of x5 not support source type ");
        AppMethodBeat.o(152949);
        return false;
    }

    public static void a(WebView.c cVar) {
        AppMethodBeat.i(223921);
        a(cVar, null);
        AppMethodBeat.o(223921);
    }

    public static void a(WebView.PreInitCallback preInitCallback) {
        AppMethodBeat.i(223922);
        a(MMWebView.QDR, preInitCallback);
        AppMethodBeat.o(223922);
    }

    public static void a(WebView.c cVar, WebView.PreInitCallback preInitCallback) {
        AppMethodBeat.i(152950);
        a(MMApplicationContext.getContext(), cVar, preInitCallback);
        AppMethodBeat.o(152950);
    }

    private static void a(Context context, WebView.c cVar, final WebView.PreInitCallback preInitCallback) {
        AppMethodBeat.i(152951);
        AnonymousClass1 r1 = new WebView.PreInitCallback() {
            /* class com.tencent.mm.cr.d.AnonymousClass1 */

            @Override // com.tencent.xweb.WebView.PreInitCallback
            public final void onCoreInitFinished() {
                AppMethodBeat.i(152942);
                Log.i("XWebUtil", "onCoreInitFinished");
                abg abg = new abg();
                abg.eiA.success = true;
                EventCenter.instance.publish(abg);
                if (preInitCallback != null) {
                    preInitCallback.onCoreInitFinished();
                }
                AppMethodBeat.o(152942);
            }

            @Override // com.tencent.xweb.WebView.PreInitCallback
            public final void btl() {
                AppMethodBeat.i(152943);
                Log.i("XWebUtil", "onCoreInitFailed");
                abg abg = new abg();
                abg.eiA.success = false;
                EventCenter.instance.publish(abg);
                if (preInitCallback != null) {
                    preInitCallback.btl();
                }
                AppMethodBeat.o(152943);
            }
        };
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        kT(context);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || Log.getLogLevel() <= 1) {
            try {
                y.hsF().hsI();
            } catch (Exception e2) {
                org.xwalk.core.Log.e("XWebUtil", "turn on xweb debug failed , exp = " + e2.getMessage());
            }
        }
        WebView.initWebviewCore(context, cVar, b.getModuleName(), r1);
        if ("mm".equals(b.getModuleName()) && ao.isDarkMode()) {
            ah.htg();
        }
        if (hiB()) {
            XWalkEnvironment.setUsingCustomContext(true);
        }
        AppMethodBeat.o(152951);
    }

    private static synchronized void hiz() {
        synchronized (d.class) {
            AppMethodBeat.i(223923);
            if (Rzm == null) {
                Log.w("XWebUtil", " initExpansionSetting sExpansionImp == null ");
                ai.Ek(false);
                AppMethodBeat.o(223923);
            } else {
                Log.i("XWebUtil", " initExpansionSetting sExpansionImp setted");
                boolean isInstalled = Rzm.isInstalled();
                ai.Ek(isInstalled);
                if (isInstalled) {
                    ai.bss(Rzm.cMs());
                }
                AppMethodBeat.o(223923);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void kT(android.content.Context r5) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.cr.d.kT(android.content.Context):void");
    }

    private static void hiA() {
        AppMethodBeat.i(152953);
        HashMap hashMap = new HashMap();
        hashMap.put(XWalkEnvironment.XWALK_ENV_MAP_KEY_ISGPVERSION, Boolean.valueOf(ChannelUtil.isGPVersion()));
        hashMap.put(XWalkEnvironment.XWALK_ENV_MAP_KEY_PROCESSNAME, MMApplicationContext.getProcessName());
        hashMap.put("is64bitabi", Boolean.valueOf(q.is64BitRuntime()));
        XWalkEnvironment.setXWebInitArgs(hashMap);
        AppMethodBeat.o(152953);
    }

    public static boolean hiB() {
        AppMethodBeat.i(152954);
        if (WebView.getCurWebType() == WebView.c.WV_KIND_CW) {
            boolean isCurrentVersionSupportCustomContext = XWalkEnvironment.isCurrentVersionSupportCustomContext();
            AppMethodBeat.o(152954);
            return isCurrentVersionSupportCustomContext;
        }
        AppMethodBeat.o(152954);
        return false;
    }
}
