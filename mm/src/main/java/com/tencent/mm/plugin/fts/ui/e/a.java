package com.tencent.mm.plugin.fts.ui.e;

import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.webview.h;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.fas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/fts/ui/webview/PardusJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "Lcom/tencent/mm/protocal/protobuf/WebSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;", "(Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;)V", "TAG", "", "getPardusUIComponent", "getReportType", "", "pardusAction", "", NativeProtocol.WEB_DIALOG_PARAMS, "pardusReport", "renderFinish", "reportKV", "showFTSSearchBar", "webViewReady", "ui-fts_release"})
public final class a extends h<fas> {
    private final String TAG = "MicroMsg.FTS.PardusJSApi";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(d dVar) {
        super(dVar);
        p.h(dVar, "uiComponent");
        AppMethodBeat.i(235453);
        AppMethodBeat.o(235453);
    }

    @Override // com.tencent.mm.plugin.websearch.webview.b
    public final int ddN() {
        return 1;
    }

    @JavascriptInterface
    public final void webViewReady(String str) {
        AppMethodBeat.i(235448);
        p.h(str, NativeProtocol.WEB_DIALOG_PARAMS);
        Log.i(this.TAG, "webViewReady ".concat(String.valueOf(str)));
        AppMethodBeat.o(235448);
    }

    @JavascriptInterface
    public final void pardusReport(String str) {
        AppMethodBeat.i(235449);
        Log.i(this.TAG, "pardusReport %s", str);
        try {
            String optString = new JSONObject(str).optString("logStr", "");
            if (!Util.isNullOrNil(optString)) {
                doc doc = new doc();
                doc.MRe = optString;
                g.azz().b(new ad(doc));
                AppMethodBeat.o(235449);
                return;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(235449);
    }

    @JavascriptInterface
    public final void reportKV(String str) {
        AppMethodBeat.i(235450);
        Log.i(this.TAG, "pardusReport %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            e.INSTANCE.kvStat(jSONObject.optInt("logid"), jSONObject.optString("msg", ""));
            AppMethodBeat.o(235450);
        } catch (Exception e2) {
            AppMethodBeat.o(235450);
        }
    }

    @JavascriptInterface
    public final void pardusAction(String str) {
        AppMethodBeat.i(235451);
        try {
            JSONObject jSONObject = new JSONObject(str);
            dPJ().a(jSONObject.optInt("area", 0), jSONObject);
            AppMethodBeat.o(235451);
        } catch (Exception e2) {
            AppMethodBeat.o(235451);
        }
    }

    @JavascriptInterface
    public final void renderFinish(String str) {
        AppMethodBeat.i(235452);
        Log.i(this.TAG, "renderFinish %s", str);
        try {
            dPJ().aQ(new JSONObject(str));
            AppMethodBeat.o(235452);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "pardusAction", new Object[0]);
            AppMethodBeat.o(235452);
        }
    }

    @JavascriptInterface
    public final void showFTSSearchBar(String str) {
        AppMethodBeat.i(258243);
        Log.i(this.TAG, "showFTSSearchBar %s", str);
        try {
            dPJ().hVN();
            AppMethodBeat.o(258243);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "pardusAction", new Object[0]);
            AppMethodBeat.o(258243);
        }
    }

    private final d dPJ() {
        AppMethodBeat.i(235447);
        com.tencent.mm.plugin.websearch.webview.d<T> dVar = this.IHe;
        if (dVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.widget.IPardusUIComponent");
            AppMethodBeat.o(235447);
            throw tVar;
        }
        d dVar2 = (d) dVar;
        AppMethodBeat.o(235447);
        return dVar2;
    }
}
