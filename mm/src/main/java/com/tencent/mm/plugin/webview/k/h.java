package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/webview/util/WebViewKernelUtil;", "", "()V", "CHROME_KERNEL_NO_COMMIT_VERSION", "", "CHROME_PACKAGE_NAME", "", "SPLITER", "TAG", "systemKernelVersion", "currentKernelSupportPageCommitVisible", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "systemWebViewKernelVersion", "webview-sdk_release"})
public final class h {
    private static int JBA;
    public static final h JBB = new h();

    static {
        AppMethodBeat.i(225174);
        AppMethodBeat.o(225174);
    }

    private h() {
    }

    public static int g(MMWebView mMWebView) {
        int i2;
        String userAgentString;
        List b2;
        String str;
        List b3;
        String str2;
        List b4;
        String str3;
        Integer buA;
        int i3;
        List<String> a2;
        String str4;
        Integer buA2;
        int i4 = 0;
        AppMethodBeat.i(225173);
        if (JBA > 0) {
            int i5 = JBA;
            AppMethodBeat.o(225173);
            return i5;
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.webview", 0);
        if (packageInfo != null) {
            try {
                String str5 = packageInfo.versionName;
                if (str5 != null) {
                    if (str5 == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(225173);
                        throw tVar;
                    }
                    String lowerCase = str5.toLowerCase();
                    p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (!(lowerCase == null || (a2 = n.a(lowerCase, new String[]{"."})) == null || (str4 = a2.get(0)) == null || (buA2 = n.buA(str4)) == null)) {
                        i3 = buA2.intValue();
                        i2 = i3;
                    }
                }
                i3 = 0;
                i2 = i3;
            } catch (Throwable th) {
                Log.i("MicroMsg.WebViewKernelUtil", "Get KernelVersion From PKG Error:" + th.getMessage());
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            JBA = i2;
            AppMethodBeat.o(225173);
            return i2;
        }
        if (mMWebView != null) {
            try {
                z settings = mMWebView.getSettings();
                if (!(settings == null || (userAgentString = settings.getUserAgentString()) == null)) {
                    if (userAgentString == null) {
                        t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(225173);
                        throw tVar2;
                    }
                    String lowerCase2 = userAgentString.toLowerCase();
                    p.g(lowerCase2, "(this as java.lang.String).toLowerCase()");
                    if (!(lowerCase2 == null || (b2 = n.b(lowerCase2, new String[]{"chrome/"})) == null || (str = (String) b2.get(1)) == null || (b3 = n.b(str, new String[]{" "})) == null || (str2 = (String) b3.get(0)) == null || (b4 = n.b(str2, new String[]{"."})) == null || (str3 = (String) b4.get(0)) == null || (buA = n.buA(str3)) == null)) {
                        i4 = buA.intValue();
                    }
                }
            } catch (Throwable th2) {
                Log.i("MicroMsg.WebViewKernelUtil", "Get KernelVersion From UA Error:" + th2.getMessage());
                i4 = i2;
            }
        }
        JBA = i4;
        AppMethodBeat.o(225173);
        return i4;
    }
}
