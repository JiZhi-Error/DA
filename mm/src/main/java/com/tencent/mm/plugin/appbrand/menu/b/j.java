package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class j implements b<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(47698);
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) agVar.av(AppBrandSysConfigWC.class);
        if (appBrandSysConfigWC.leE.kNW == 1 || appBrandSysConfigWC.leE.kNW == 2 || WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv() || BuildInfo.IS_FLAVOR_RED || p.Un(str).kDe) {
            AppMethodBeat.o(47698);
            return true;
        } else if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(47698);
            return true;
        } else {
            AppMethodBeat.o(47698);
            return false;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(final Context context, ag agVar, String str) {
        String format;
        AppMethodBeat.i(47697);
        ag agVar2 = agVar;
        if (Util.isNullOrNil(m.bAc())) {
            m.Xe("--prof_cpp");
            AppBrandProcessSuicideLogic.a((AppBrandUI) context, context.getString(R.string.jy));
            AppMethodBeat.o(47697);
            return;
        }
        if (agVar2.getRuntime() instanceof q) {
            q runtime = agVar2.getRuntime();
            String str2 = com.tencent.mm.loader.j.b.aKJ() + "appbrand/trace/";
            o oVar = new o(str2);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            final String str3 = str2 + String.format("HEAP_%s_%d.heapsnapshot", str, Long.valueOf(System.currentTimeMillis()));
            if (runtime.NA()) {
                format = "(function() {var profiler = new NativeGlobal.HeapProfiler();var snapshot = profiler.takeSnapshot();return snapshot.serialize('" + str3 + "');})()";
            } else {
                format = String.format("console.log('dumpHeapSnapshot:' + typeof dumpHeapSnapshot);dumpHeapSnapshot('%s');", str3);
            }
            runtime.bsE().getJsRuntime().evaluateJavascript(format, new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.appbrand.menu.b.j.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(47696);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.menu.b.j.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(47695);
                            Toast.makeText(context, str3 + " exported.", 1).show();
                            Log.i("MiroMsg.GameHeapProfile", "v8DumpSnapshot to :%s", str3);
                            AppMethodBeat.o(47695);
                        }
                    });
                    AppMethodBeat.o(47696);
                }
            });
            if (!runtime.NA() && (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED)) {
                String str4 = str2 + String.format("WebView_HEAP_%s_%d.heapsnapshot", str, Long.valueOf(System.currentTimeMillis()));
                Log.i("MiroMsg.GameHeapProfile", "WebViewDumpSnapshot to :%s suc:%b", str4, Boolean.valueOf(agVar2.bRI().savePage(aa.z(new o(str4).her()), null, 100000)));
            }
        }
        AppMethodBeat.o(47697);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* bridge */ /* synthetic */ String b(Context context, ag agVar, String str) {
        return "Take Heap Snapshot";
    }
}
