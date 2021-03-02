package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.drq;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b implements i {
    private static String IDj = "websearch_";
    private static String IDk;
    private static String IDl;
    private Runnable IDh;
    private Runnable IDi;

    private static SharedPreferences fXs() {
        AppMethodBeat.i(116539);
        init();
        Log.i("WebSearchPrivacyMgr", " sp name %s ", IDj);
        SharedPreferences sharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), IDj, 0, false);
        AppMethodBeat.o(116539);
        return sharedPreferences;
    }

    public static void init() {
        AppMethodBeat.i(116540);
        if (IDk == null) {
            fXt();
        }
        AppMethodBeat.o(116540);
    }

    public static void fXt() {
        AppMethodBeat.i(116541);
        Log.i("WebSearchPrivacyMgr", "reInit");
        StringBuilder sb = new StringBuilder("websearch_");
        g.aAf();
        IDj = sb.append(a.ayV()).toString();
        Object obj = g.aAh().azQ().get(274436, "");
        String str = LocaleUtil.ENGLISH;
        if (obj != null) {
            str = obj.toString();
        }
        IDk = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/newreadtemplate?t=gdpr/confirm&business=search&lang=%s&cc=%s&autoCloseWindow=1", LocaleUtil.getApplicationLanguage(), str);
        IDl = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/newreadtemplate?t=gdpr/close&business=search&lang=%s&cc=%s&autoCloseWindow=1", LocaleUtil.getApplicationLanguage(), str);
        AppMethodBeat.o(116541);
    }

    @Override // com.tencent.mm.plugin.websearch.api.i
    public final void fXu() {
        AppMethodBeat.i(116542);
        Log.i("WebSearchPrivacyMgr", "openSearch ");
        init();
        if (this.IDh != null) {
            this.IDh.run();
            if (this.IDh == this.IDh) {
                this.IDh = null;
            }
        }
        fXs().edit().putBoolean("websearch_confirmed", true).commit();
        drp drp = new drp();
        drp.MUj = 1;
        drp.Timestamp = (int) (System.currentTimeMillis() / 1000);
        drp.him = 1;
        d.a aVar = new d.a();
        aVar.iLN = drp;
        aVar.iLO = new drq();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
        aVar.funcId = 2957;
        aa.a(aVar.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.websearch.b.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                return 0;
            }
        });
        AppMethodBeat.o(116542);
    }

    @Override // com.tencent.mm.plugin.websearch.api.i
    public final void fXv() {
        AppMethodBeat.i(116543);
        Log.i("WebSearchPrivacyMgr", "closeSearch ");
        init();
        if (this.IDi != null) {
            this.IDi.run();
            if (this.IDi == this.IDi) {
                this.IDi = null;
            }
        }
        fXs().edit().putBoolean("websearch_confirmed", false).commit();
        drp drp = new drp();
        drp.MUj = 1;
        drp.Timestamp = (int) (System.currentTimeMillis() / 1000);
        drp.him = 2;
        d.a aVar = new d.a();
        aVar.iLN = drp;
        aVar.iLO = new drq();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
        aVar.funcId = 2957;
        aa.a(aVar.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.websearch.b.AnonymousClass2 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                return 0;
            }
        });
        ((n) g.ah(n.class)).deleteSOSHistory();
        if (am.IEW != null) {
            am.IEW = null;
        }
        MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove(am.bKh()).commit();
        AppMethodBeat.o(116543);
    }

    @Override // com.tencent.mm.plugin.websearch.api.i
    public final boolean fXw() {
        AppMethodBeat.i(116544);
        boolean z = fXs().getBoolean("websearch_confirmed", false);
        AppMethodBeat.o(116544);
        return z;
    }

    @Override // com.tencent.mm.plugin.websearch.api.i
    public final void a(Context context, Runnable runnable) {
        AppMethodBeat.i(116545);
        init();
        if (fXw() || !com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            runnable.run();
            AppMethodBeat.o(116545);
            return;
        }
        this.IDh = runnable;
        bS(context, IDk);
        AppMethodBeat.o(116545);
    }

    @Override // com.tencent.mm.plugin.websearch.api.i
    public final boolean b(Context context, Runnable runnable) {
        AppMethodBeat.i(116546);
        init();
        if (com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            this.IDi = runnable;
            bS(context, IDl);
            AppMethodBeat.o(116546);
            return true;
        }
        runnable.run();
        AppMethodBeat.o(116546);
        return false;
    }

    private static void bS(Context context, String str) {
        AppMethodBeat.i(116547);
        Intent intent = new Intent();
        intent.putExtra("showShare", true);
        intent.putExtra("rawUrl", str);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(116547);
    }
}
