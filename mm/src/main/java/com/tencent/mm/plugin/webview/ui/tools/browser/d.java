package com.tencent.mm.plugin.webview.ui.tools.browser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashSet;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0007J\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserConfigManager;", "", "()V", "TAG", "", "allowBrowserList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "blockBrowserList", "enableBlockBrowser", "", "addAllowBrowserList", "", "configString", "addBlockBrowserList", "enableFilterBlockBrowser", "getAllowBrowserList", "", "getBlockBrowserList", "isAllowBrowser", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "isBlockBrowser", "plugin-webview_release"})
public final class d {
    private static final HashSet<String> JlH = ak.ae(TbsConfig.APP_QB, "com.tencent.mtt.x86", "com.tencent.mtt.qbx", "com.tencent.qbx5", "com.ucmobile", "com.ucmobile.lite", "com.android.chrome", "com.baidu.browser.apps", "com.baidu.searchbox", "com.baidu.searchbox.lite", "com.ijinshan.browser_fast", "com.qihoo.browser", "com.qihoo.contents", "org.mozilla.firefox", "sogou.mobile.explorer");
    private static boolean JlI = (((b) g.af(b.class)).a(b.a.clicfg_webview_browser_enable_block, 0) == 1);
    private static final HashSet<String> JlJ = new HashSet<>();
    public static final d JlK = new d();

    static {
        AppMethodBeat.i(210434);
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_webview_browser_allow_list_1, "");
        p.g(a2, "allowConfig1");
        bay(a2);
        String a3 = ((b) g.af(b.class)).a(b.a.clicfg_webview_browser_allow_list_2, "");
        p.g(a3, "allowConfig2");
        bay(a3);
        String a4 = ((b) g.af(b.class)).a(b.a.clicfg_webview_browser_block_list_1, "");
        p.g(a4, "blockConfig1");
        baz(a4);
        String a5 = ((b) g.af(b.class)).a(b.a.clicfg_webview_browser_block_list_2, "");
        p.g(a5, "blockConfig2");
        baz(a5);
        Log.i("MicroMsg.BrowserConfigManager", "alvinluo initBrowserConfig allowBrowserList size: " + JlH.size() + ", " + JlH + ", enableBlockBrowser: " + JlI + ", blockBrowserList size: " + JlJ.size() + ", " + JlJ);
        AppMethodBeat.o(210434);
    }

    private d() {
    }

    private static void bay(String str) {
        AppMethodBeat.i(210430);
        for (T t : n.a(str, new String[]{";"})) {
            if (t == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(210430);
                throw tVar;
            }
            String lowerCase = t.toLowerCase();
            p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if ((lowerCase.length() > 0) && !JlH.contains(lowerCase)) {
                JlH.add(lowerCase);
            }
        }
        AppMethodBeat.o(210430);
    }

    private static void baz(String str) {
        AppMethodBeat.i(210431);
        for (T t : n.a(str, new String[]{";"})) {
            if (t == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(210431);
                throw tVar;
            }
            String lowerCase = t.toLowerCase();
            p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if ((lowerCase.length() > 0) && !JlJ.contains(lowerCase)) {
                JlJ.add(lowerCase);
            }
        }
        AppMethodBeat.o(210431);
    }

    public static boolean baA(String str) {
        String str2;
        AppMethodBeat.i(210432);
        HashSet<String> hashSet = JlH;
        if (str == null) {
            str2 = null;
        } else if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(210432);
            throw tVar;
        } else {
            str2 = str.toLowerCase();
            p.g(str2, "(this as java.lang.String).toLowerCase()");
        }
        boolean a2 = j.a(hashSet, str2);
        AppMethodBeat.o(210432);
        return a2;
    }

    public static boolean baB(String str) {
        String str2;
        AppMethodBeat.i(210433);
        HashSet<String> hashSet = JlJ;
        if (str == null) {
            str2 = null;
        } else if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(210433);
            throw tVar;
        } else {
            str2 = str.toLowerCase();
            p.g(str2, "(this as java.lang.String).toLowerCase()");
        }
        boolean a2 = j.a(hashSet, str2);
        AppMethodBeat.o(210433);
        return a2;
    }

    public static boolean ggu() {
        return JlI;
    }
}
