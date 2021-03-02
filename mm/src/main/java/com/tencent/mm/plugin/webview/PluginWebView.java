package com.tencent.mm.plugin.webview;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.plugin.webview.d.a;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;

public class PluginWebView extends f {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-webview";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(77811);
        if (gVar.aBb()) {
            abi64WebViewCompat(gVar);
            m mVar = m.IAG;
            m.fWN();
            m mVar2 = m.IAG;
            m.yK(false);
            d dVar = d.JmQ;
            d.gcb();
        }
        if (gVar.aBb() || gVar.FY(":tools") || gVar.FY(":toolsmp")) {
            com.tencent.mm.plugin.webview.l.g.LW();
            com.tencent.mm.plugin.webview.core.g.LW();
            a aVar = a.IQX;
            a.gaR();
            Log.i("MicroMsg.PluginWebView", "init DefaultJsApiPool");
            com.tencent.mm.kernel.g.b(aa.class, new b());
        }
        if (gVar.FY(":tools")) {
            WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cyj());
            preInitWebViewSafeDuringMMKernelStage(null);
        } else if (gVar.FY(":toolsmp")) {
            WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cyj());
            preInitWebViewSafeDuringMMKernelStage(new WebView.PreInitCallback() {
                /* class com.tencent.mm.plugin.webview.PluginWebView.AnonymousClass2 */

                @Override // com.tencent.xweb.WebView.PreInitCallback
                public final void onCoreInitFinished() {
                    AppMethodBeat.i(210806);
                    Log.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
                    if (((b) com.tencent.mm.kernel.g.af(b.class)).CR(20)) {
                        ((b) com.tencent.mm.kernel.g.af(b.class)).clg();
                    }
                    AppMethodBeat.o(210806);
                }

                @Override // com.tencent.xweb.WebView.PreInitCallback
                public final void btl() {
                    AppMethodBeat.i(210807);
                    Log.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
                    AppMethodBeat.o(210807);
                }
            });
        }
        if (gVar.FY(":tools") || gVar.FY(":toolsmp")) {
            com.tencent.mm.plugin.s.a.m(gVar.ca);
        }
        AppMethodBeat.o(77811);
    }

    private static void preInitWebViewSafeDuringMMKernelStage(final WebView.PreInitCallback preInitCallback) {
        AppMethodBeat.i(77812);
        AnonymousClass3 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.webview.PluginWebView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(210808);
                com.tencent.mm.cr.d.a(preInitCallback);
                AppMethodBeat.o(210808);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(77812);
            return;
        }
        new Handler(Looper.getMainLooper()).post(r0);
        AppMethodBeat.o(77812);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(77813);
        if (gVar.aBb() || gVar.FY(":tools") || gVar.FY(":toolsmp")) {
            pin(new y(com.tencent.mm.plugin.webview.modeltools.g.class));
        }
        if (gVar.aBb()) {
            com.tencent.mm.vfs.y.b("CDNTemp", "CDNTemp", 259200000, 71);
            com.tencent.mm.vfs.y.b("vproxy", "vproxy", 604800000, 71);
        }
        AppMethodBeat.o(77813);
    }

    private void abi64WebViewCompat(g gVar) {
        boolean z;
        AppMethodBeat.i(77810);
        SharedPreferences sharedPreferences = gVar.ca.getSharedPreferences("abi64_webview_compat_sp", 0);
        int i2 = sharedPreferences.getInt("last_is_32bit_wechat", 0);
        int i3 = BuildInfo.IS_ARM64 ? 2 : 1;
        if (!BuildInfo.IS_ARM64) {
            if (i2 != 2) {
                Log.i("MicroMsg.PluginWebView", "Still 32Bit");
                AppMethodBeat.o(77810);
                return;
            }
            z = false;
        } else if (i2 == 2) {
            Log.i("MicroMsg.PluginWebView", "Still 64Bit");
            AppMethodBeat.o(77810);
            return;
        } else {
            z = true;
        }
        boolean ic = com.tencent.mm.plugin.webview.k.a.ic(gVar.ca);
        Log.i("MicroMsg.PluginWebView", "result %s", Boolean.valueOf(ic));
        if (ic) {
            sharedPreferences.edit().putInt("last_is_32bit_wechat", i3).commit();
        }
        final int i4 = z ? 8 : 9;
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.plugin.webview.PluginWebView.AnonymousClass1 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(210805);
                    com.tencent.mm.kernel.g.aAi().b(this);
                    e.INSTANCE.idkeyStat(661, (long) i4, 1, false);
                    AppMethodBeat.o(210805);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                }
            });
        }
        AppMethodBeat.o(77810);
    }
}
