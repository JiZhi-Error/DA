package com.tencent.mm.plugin.webview.core;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class g implements com.tencent.mm.pluginsdk.cmd.a {
    public static final a ILB = new a((byte) 0);
    private static final f VgE = kotlin.g.ah(c.VgF);

    private static void fh(String str, String str2) {
        AppMethodBeat.i(225047);
        if (!a.fZP()) {
            AppMethodBeat.o(225047);
            return;
        }
        d.h(new b(str2));
        Log.i(str, str2);
        AppMethodBeat.o(225047);
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        Iterator it;
        String str2 = null;
        AppMethodBeat.i(225048);
        if (!a.fZP()) {
            AppMethodBeat.o(225048);
            return false;
        }
        if (strArr != null) {
            it = kotlin.g.b.b.af(strArr);
        } else {
            it = null;
        }
        if (it != null) {
            str2 = (String) it.next();
        }
        if (!p.j(str2, "//webview")) {
            AppMethodBeat.o(225048);
            return false;
        }
        String str3 = (String) it.next();
        if (str3 == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(225048);
            throw tVar;
        }
        String lowerCase = str3.toLowerCase();
        p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case -1354815177:
                if (lowerCase.equals("commit")) {
                    if (strArr.length <= 2) {
                        AppMethodBeat.o(225048);
                        return false;
                    }
                    String str4 = strArr[2];
                    switch (str4.hashCode()) {
                        case 3556498:
                            if (str4.equals(APMidasPayAPI.ENV_TEST)) {
                                h.cdi().putBoolean("webview_page_commit_mock", true);
                                fh("WebViewCommand", "commit mock enable");
                                AppMethodBeat.o(225048);
                                return true;
                            }
                            AppMethodBeat.o(225048);
                            return false;
                        case 108404047:
                            if (str4.equals("reset")) {
                                h.cdi().putBoolean("webview_page_commit_mock", false);
                                fh("WebViewCommand", "commit mock reset");
                                AppMethodBeat.o(225048);
                                return true;
                            }
                            AppMethodBeat.o(225048);
                            return false;
                        default:
                            AppMethodBeat.o(225048);
                            return false;
                    }
                }
                break;
            case -318798133:
                if (lowerCase.equals("preauth")) {
                    if (strArr.length <= 2) {
                        AppMethodBeat.o(225048);
                        return false;
                    }
                    String str5 = strArr[2];
                    e.a aVar = new e.a();
                    aVar.url = str5;
                    aVar.pmM = TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR;
                    aVar.pmN = 10001;
                    CronetLogic.setUserCertVerify(true);
                    h.cdi().putBoolean("webview_use_a8key_lite_header", true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(aVar);
                    ((e) com.tencent.mm.kernel.g.af(e.class)).cu(arrayList);
                    AppMethodBeat.o(225048);
                    return true;
                }
                break;
            case 2045106293:
                if (lowerCase.equals("prefetchpkg")) {
                    if (strArr.length <= 2) {
                        AppMethodBeat.o(225048);
                        return false;
                    }
                    h.cdi().putInt("prefetchUsePkg", Util.getInt(strArr[2], -1));
                    AppMethodBeat.o(225048);
                    return true;
                }
                break;
        }
        AppMethodBeat.o(225048);
        return false;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean KB() {
            AppMethodBeat.i(225043);
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                AppMethodBeat.o(225043);
                return true;
            }
            AppMethodBeat.o(225043);
            return false;
        }

        public static boolean fZP() {
            AppMethodBeat.i(225044);
            if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || (Log.getLogLevel() == 0 && WeChatEnvironment.hasDebugger())) {
                AppMethodBeat.o(225044);
                return true;
            }
            AppMethodBeat.o(225044);
            return false;
        }

        public static boolean fZQ() {
            AppMethodBeat.i(225045);
            boolean z = h.cdi().getBoolean("webview_page_commit_mock", false);
            AppMethodBeat.o(225045);
            return z;
        }
    }

    static {
        AppMethodBeat.i(225049);
        AppMethodBeat.o(225049);
    }

    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String grJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.grJ = str;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(225046);
            Toast.makeText(MMApplicationContext.getContext(), this.grJ, 0).show();
            x xVar = x.SXb;
            AppMethodBeat.o(225046);
            return xVar;
        }
    }

    static final class c extends q implements kotlin.g.a.a<Boolean> {
        public static final c VgF = new c();

        static {
            AppMethodBeat.i(263540);
            AppMethodBeat.o(263540);
        }

        c() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(263539);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_activity_translucent, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(263539);
            return valueOf;
        }
    }

    public static final void LW() {
        AppMethodBeat.i(225050);
        com.tencent.mm.pluginsdk.cmd.b.a(new g(), "//webview");
        AppMethodBeat.o(225050);
    }
}
