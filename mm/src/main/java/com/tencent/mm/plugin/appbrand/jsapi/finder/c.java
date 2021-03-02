package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class c extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "fetchFinderProfileFeed";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(163928);
        final s sVar2 = sVar;
        Log.i("MicroMsg.Finder.JsApiFetchFinderProfileFeed", "JsApiFetchFinderProfileFeed");
        if (jSONObject == null) {
            sVar2.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(163928);
            return;
        }
        String optString = jSONObject.optString(ch.COL_USERNAME, "");
        if (Util.isNullOrNil(optString)) {
            sVar2.i(i2, h("fail:username is null or nil", null));
            AppMethodBeat.o(163928);
            return;
        }
        String optString2 = jSONObject.optString("maxId", "");
        if (Util.isNullOrNil(optString2)) {
            sVar2.i(i2, h("fail:maxId is null or nil", null));
            AppMethodBeat.o(163928);
            return;
        }
        beb beb = new beb();
        beb.DIf = Long.valueOf(optString2).longValue();
        beb.username = optString;
        d.a aVar = new d.a();
        aVar.funcId = 3736;
        aVar.uri = "${FinderCgiConstants.CGI_PRE}/finderuserpage";
        aVar.iLN = beb;
        aVar.iLO = new FinderUserPageResponse();
        IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.c.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                AppMethodBeat.i(163927);
                if (i2 == 0 && i3 == 0) {
                    FinderUserPageResponse finderUserPageResponse = (FinderUserPageResponse) dVar.iLL.iLR;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        a.a(finderUserPageResponse, jSONObject);
                        sVar2.i(i2, a.a("", 0, jSONObject));
                        AppMethodBeat.o(163927);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Finder.JsApiFetchFinderProfileFeed", e2, "JsApiFetchFinderProfileFeed", new Object[0]);
                        sVar2.i(i2, a.a(e2.getMessage(), -1, jSONObject));
                        AppMethodBeat.o(163927);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    if (i2 == 4) {
                        sVar2.i(i2, a.a(str, i3, jSONObject2));
                        AppMethodBeat.o(163927);
                        return;
                    }
                    sVar2.i(i2, a.a(str, -1, jSONObject2));
                    AppMethodBeat.o(163927);
                }
            }
        });
        AppMethodBeat.o(163928);
    }
}
