package com.tencent.mm.plugin.webview.ui.tools.browser.storage;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/storage/BrowserSettingStorageManager;", "", "()V", "TAG", "", "getBrowserConfigId", "", "configId", "getDefaultBrowser", "saveDefaultBrowser", "", "selectedInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "plugin-webview_release"})
public final class a {
    public static final a JlP = new a();

    static {
        AppMethodBeat.i(210445);
        AppMethodBeat.o(210445);
    }

    private a() {
    }

    public static final String ggv() {
        AppMethodBeat.i(210443);
        try {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(274528, "");
            if (obj instanceof String) {
                String str = (String) obj;
                AppMethodBeat.o(210443);
                return str;
            }
            AppMethodBeat.o(210443);
            return "";
        } catch (Exception e2) {
            AppMethodBeat.o(210443);
            return "";
        }
    }

    private static void baC(String str) {
        AppMethodBeat.i(210444);
        try {
            Log.i("MicroMsg.BrowserSettingStorageManager", "alvinluo saveDefaultBrowser packageName: %s", str);
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(274528, str);
            AppMethodBeat.o(210444);
        } catch (Exception e2) {
            AppMethodBeat.o(210444);
        }
    }

    public static final void a(f fVar) {
        String str;
        ActivityInfo activityInfo;
        AppMethodBeat.i(210442);
        p.h(fVar, "selectedInfo");
        if (fVar.dUm == 1) {
            ResolveInfo resolveInfo = fVar.resolveInfo;
            if (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || (str = activityInfo.packageName) == null) {
                str = "";
            }
            baC(str);
            AppMethodBeat.o(210442);
            return;
        }
        if (fVar.dUm == 2) {
            baC("");
        }
        AppMethodBeat.o(210442);
    }
}
