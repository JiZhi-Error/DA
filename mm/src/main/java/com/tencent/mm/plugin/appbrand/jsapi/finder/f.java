package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class f extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "modifyFinderAccountNickname";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(163959);
        final s sVar2 = sVar;
        Log.i("MicroMsg.Finder.JsApiModifyFinderAccountNickname", "JsApiModifyFinderAccountNickname");
        if (jSONObject == null) {
            sVar2.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(163959);
            return;
        }
        String optString = jSONObject.optString(ch.COL_USERNAME, "");
        if (Util.isNullOrNil(optString)) {
            sVar2.i(i2, h("fail:username is null or nil", null));
            AppMethodBeat.o(163959);
            return;
        }
        String optString2 = jSONObject.optString("nickname", "");
        if (Util.isNullOrNil(optString2)) {
            sVar2.i(i2, h("fail:nickname is null or nil", null));
            AppMethodBeat.o(163959);
            return;
        }
        String optString3 = jSONObject.optString("signature", "");
        if (Util.isNullOrNil(optString3)) {
            sVar2.i(i2, h("fail:signature is null or nil", null));
            AppMethodBeat.o(163959);
            return;
        }
        azg azg = new azg();
        azg.nickname = optString2;
        azg.signature = optString3;
        apf apf = new apf();
        bx.a aVar = bx.tvW;
        apf.cmdId = bx.tvL;
        try {
            apf.LBo = b.cD(azg.toByteArray());
        } catch (Exception e2) {
        }
        baa baa = new baa();
        baa.username = optString;
        baa.sKS.add(apf);
        d.a aVar2 = new d.a();
        aVar2.funcId = 3870;
        aVar2.uri = "${FinderCgiConstants.CGI_PRE}/finderoplog";
        aVar2.iLN = baa;
        aVar2.iLO = new bab();
        IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.f.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                AppMethodBeat.i(163958);
                JSONObject jSONObject = new JSONObject();
                if (i2 == 0 && i3 == 0) {
                    sVar2.i(i2, a.a("", 0, jSONObject));
                    AppMethodBeat.o(163958);
                } else if (i2 == 4) {
                    sVar2.i(i2, a.a(str, i3, jSONObject));
                    AppMethodBeat.o(163958);
                } else {
                    sVar2.i(i2, a.a(str, -1, jSONObject));
                    AppMethodBeat.o(163958);
                }
            }
        });
        AppMethodBeat.o(163959);
    }
}
