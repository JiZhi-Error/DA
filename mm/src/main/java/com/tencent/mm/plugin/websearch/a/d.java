package com.tencent.mm.plugin.websearch.a;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.a.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J,\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;)V", "TAG", "", "netSceneGetSearchShare", "Lcom/tencent/mm/plugin/websearch/api/NetSceneGetSearchShare;", "cancelSearchShare", "", "destroy", "getRequestModel", "Lcom/tencent/mm/plugin/websearch/api/NetSceneRequestModel;", NativeProtocol.WEB_DIALOG_PARAMS, "", "", "getSearchData", "paramsStr", "getSearchShare", "getSuggestData", "getTagSearchUIComponent", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ui-websearch_release"})
public final class d extends g<egj> {
    q IGc;
    private final String TAG = "MicroMsg.WebSearch.TagSearchWebData";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(b bVar) {
        super(bVar);
        p.h(bVar, "uiComponent");
        AppMethodBeat.i(197955);
        com.tencent.mm.kernel.g.azz().a(719, this);
        com.tencent.mm.kernel.g.azz().a(1161, this);
        com.tencent.mm.kernel.g.azz().a(4614, this);
        com.tencent.mm.kernel.g.azz().a(4858, this);
        AppMethodBeat.o(197955);
    }

    public final void fYF() {
        AppMethodBeat.i(197951);
        q qVar = this.IGc;
        if (qVar != null) {
            com.tencent.mm.kernel.g.azz().a(qVar);
            this.IGc = null;
            AppMethodBeat.o(197951);
            return;
        }
        AppMethodBeat.o(197951);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
        if (r1 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011d, code lost:
        if (r0 == null) goto L_0x011f;
     */
    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.websearch.webview.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
        /*
        // Method dump skipped, instructions count: 413
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.a.d.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @Override // com.tencent.mm.plugin.websearch.webview.g, com.tencent.mm.plugin.websearch.webview.a
    public final void destroy() {
        AppMethodBeat.i(197953);
        super.destroy();
        com.tencent.mm.kernel.g.azz().b(719, this);
        com.tencent.mm.kernel.g.azz().b(1161, this);
        com.tencent.mm.kernel.g.azz().b(4614, this);
        com.tencent.mm.kernel.g.azz().b(4858, this);
        AppMethodBeat.o(197953);
    }

    /* access modifiers changed from: package-private */
    public final v bh(Map<String, ? extends Object> map) {
        AppMethodBeat.i(197954);
        int b2 = ai.b(map, "scene", 0);
        v vVar = new v();
        vVar.dDv = ai.N(map, SearchIntents.EXTRA_QUERY);
        vVar.offset = ai.b(map, "offset", 0);
        vVar.businessType = ai.b(map, "type", 0);
        vVar.scene = b2;
        vVar.IDG = ai.N(map, "sugId");
        vVar.IDI = ai.b(map, "sugType", 0);
        vVar.IDH = ai.N(map, "prefixSug");
        vVar.IDT = ai.N(map, "poiInfo");
        vVar.IDE = ai.O(map, "isHomePage") ? 1 : 0;
        vVar.rjq = ai.N(map, "searchId");
        if (map.containsKey("sessionId")) {
            vVar.sessionId = ai.N(map, "sessionId");
        }
        vVar.dVS = ai.b(map, "sceneActionType", 1);
        vVar.IDK = ai.b(map, "displayPattern", 2);
        vVar.IDL = ai.b(map, "sugPosition", 0);
        vVar.IDM = ai.N(map, "sugBuffer");
        vVar.dPI = ai.N(map, "requestId");
        vVar.sessionId = ai.N(map, "sessionId");
        vVar.dVO = ai.N(map, "subSessionId");
        vVar.IDU = ai.N(map, "tagId");
        vVar.dVL = fXz();
        String N = ai.N(map, "extReqParams");
        if (!Util.isNullOrNil(N)) {
            try {
                JSONArray jSONArray = new JSONArray(N);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    aca aca = new aca();
                    aca.key = jSONObject.optString("key", "");
                    aca.LmC = (long) jSONObject.optInt("uintValue", 0);
                    aca.LmD = jSONObject.optString("textValue", "");
                    vVar.IDO.add(aca);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "commKvJSONArray", new Object[0]);
            }
        }
        String N2 = ai.N(map, "matchUser");
        if (!Util.isNullOrNil(N2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(N2);
                eou eou = new eou();
                eou.UserName = jSONObject2.optString("userName");
                eou.NmU = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(eou.UserName)) {
                    vVar.IDF.add(eou);
                }
            } catch (Exception e3) {
                Log.printErrStackTrace(this.TAG, e3, "matchUserJSONArray", new Object[0]);
            }
        }
        String N3 = ai.N(map, "prefixQuery");
        if (!Util.isNullOrNil(N3)) {
            try {
                JSONArray jSONArray2 = new JSONArray(N3);
                int length2 = jSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    vVar.IDJ.add(jSONArray2.getString(i3));
                }
            } catch (Exception e4) {
                Log.printErrStackTrace(this.TAG, e4, "prefixQueryJSONArray", new Object[0]);
            }
        }
        String N4 = ai.N(map, "tagInfo");
        if (!Util.isNullOrNil(N4)) {
            try {
                JSONObject jSONObject3 = new JSONObject(N4);
                vVar.IDN = new egk();
                vVar.IDN.Ngs = jSONObject3.optString("tagText");
                vVar.IDN.Ngr = jSONObject3.optInt("tagType");
                vVar.IDN.Ngt = jSONObject3.optString("tagExtValue");
            } catch (Exception e5) {
                Log.printErrStackTrace(this.TAG, e5, "tagInfoObj", new Object[0]);
            }
        }
        String N5 = ai.N(map, "numConditions");
        if (!Util.isNullOrNil(N5)) {
            try {
                JSONArray jSONArray3 = new JSONArray(N5);
                int length3 = jSONArray3.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    JSONObject optJSONObject = jSONArray3.optJSONObject(i4);
                    ctz ctz = new ctz();
                    ctz.Mzn = optJSONObject.optLong("from");
                    ctz.Mzo = optJSONObject.optLong("to");
                    ctz.Mzm = optJSONObject.optInt("field");
                    vVar.IDP.add(ctz);
                }
            } catch (Exception e6) {
                Log.printErrStackTrace(this.TAG, e6, "numConditionsArray", new Object[0]);
            }
        }
        vVar.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        vVar.wVW = ai.b(map, "subType", 0);
        String N6 = ai.N(map, "specialSearch");
        if (!Util.isNullOrNil(N6)) {
            try {
                JSONObject jSONObject4 = new JSONObject(N6);
                vVar.IDX = jSONObject4.optInt("type", 0);
                vVar.dDL = jSONObject4.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS).optString("reqKey");
            } catch (Exception e7) {
            }
        }
        AppMethodBeat.o(197954);
        return vVar;
    }

    public final b fYE() {
        com.tencent.mm.plugin.websearch.webview.d<T> dVar = this.IHe;
        if (!(dVar instanceof b)) {
            dVar = null;
        }
        return (b) dVar;
    }
}
