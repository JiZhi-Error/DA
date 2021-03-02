package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.epn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

public class ar extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "preVerifyJSAPI";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78596);
        Log.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
        com.tencent.mm.plugin.webview.ui.tools.game.g.bI(aVar.cta.coX(), System.currentTimeMillis());
        JSONObject jSONObject = aVar.ctb.csi;
        String optString = jSONObject.optString("verifyAppId");
        String optString2 = jSONObject.optString("verifySignature");
        String optString3 = jSONObject.optString("verifyNonceStr");
        String optString4 = jSONObject.optString("verifyTimestamp");
        String optString5 = jSONObject.optString("verifySignType");
        JSONArray optJSONArray = jSONObject.optJSONArray("verifyJsApiList");
        Log.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", optString, optString2, optString3, optString4, optString5);
        String url = aVar.cta.getUrl();
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            Log.i("MicroMsg.JsApiPreVerify", "jsItem length %s", Integer.valueOf(optJSONArray.length()));
            if (optJSONArray.length() == 0) {
                aVar.c("checkJsApi:param is empty", null);
                AppMethodBeat.o(78596);
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String string = optJSONArray.getString(i2);
                if (!Util.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            }
            if (Util.isNullOrNil(optString) || linkedList.size() <= 0 || Util.isNullOrNil(url)) {
                Log.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", optString);
                aVar.c("pre_verify_jsapi:fail_invalid_args", null);
                AppMethodBeat.o(78596);
                return;
            }
            d.a aVar2 = new d.a();
            aVar2.iLN = new cef();
            aVar2.iLO = new ceg();
            aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
            aVar2.funcId = 1093;
            aVar2.iLP = 0;
            aVar2.respCmdId = 0;
            d aXF = aVar2.aXF();
            cef cef = (cef) aXF.iLK.iLR;
            cef.url = url;
            cef.dNI = optString;
            cef.MjM = linkedList;
            cef.dmc = optString4;
            cef.Mju = optString3;
            cef.signature = optString2;
            cef.Mjv = optString5;
            IPCRunCgi.a(aXF, new a(aVar, optString));
            AppMethodBeat.o(78596);
        } catch (Exception e2) {
            Log.w("MicroMsg.JsApiPreVerify", "exception occur " + e2.getMessage());
            aVar.c("", null);
            AppMethodBeat.o(78596);
        }
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    static class a implements IPCRunCgi.a {
        private b<g>.a IVL;
        private String appId;

        a(b<g>.a aVar, String str) {
            this.IVL = aVar;
            this.appId = str;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, d dVar) {
            AppMethodBeat.i(78594);
            if (this.IVL == null) {
                AppMethodBeat.o(78594);
            } else if (i2 == 0 && i3 == 0) {
                ceg ceg = (ceg) dVar.iLL.iLR;
                if (ceg == null || ceg.Mjz == null || ceg.Mjz.dIZ != 0) {
                    ZA(str);
                    AppMethodBeat.o(78594);
                    return;
                }
                w wVar = this.IVL.cta.ITw;
                String str2 = this.appId;
                if (!Util.isNullOrNil(str2) && !Util.isNullOrNil(wVar.ISU.getUrl())) {
                    wVar.IVj.put(w.aYy(wVar.ISU.getUrl()), str2);
                }
                w wVar2 = this.IVL.cta.ITw;
                String str3 = this.appId;
                String str4 = ceg.MjR;
                if (!Util.isNullOrNil(str3) && !Util.isNullOrNil(str4)) {
                    wVar2.IVl.put(str3, str4);
                }
                a.d dVar2 = new a.d(this.appId, ceg);
                w wVar3 = this.IVL.cta.ITw;
                if (!Util.isNullOrNil(wVar3.ISU.getUrl())) {
                    wVar3.IVk.put(w.aYy(wVar3.ISU.getUrl()), dVar2);
                }
                LinkedList<epn> linkedList = ceg.MjP;
                JsapiPermissionWrapper aZE = this.IVL.cta.gbF().aZE(this.IVL.cta.getUrl());
                if (aZE == null) {
                    ZA("");
                    AppMethodBeat.o(78594);
                    return;
                }
                if (!Util.isNullOrNil(linkedList)) {
                    Iterator<epn> it = linkedList.iterator();
                    while (it.hasNext()) {
                        epn next = it.next();
                        c.g bgb = c.bgb(next.Mjs);
                        if (!(bgb == null || aZE.aiW(bgb.gtt()) == next.state)) {
                            aZE.a(bgb.gtt(), (byte) next.state);
                        }
                    }
                }
                if (this.IVL.cta.gbI() != null) {
                    Log.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", ceg.MjR);
                    this.IVL.cta.gbI().agS(ceg.MjR);
                }
                if (this.IVL.cta.gbJ() != null) {
                    Log.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", ceg.MjR);
                    t gbJ = this.IVL.cta.gbJ();
                    String str5 = ceg.MjR;
                    p.h(str5, "icon");
                    if (gbJ.IVc == null) {
                        gbJ.agS(str5);
                    }
                }
                if (this.IVL.cta.gbK() != null) {
                    this.IVL.cta.gbK().setIcon(Util.nullAsNil(ceg.MjR));
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.IVL.cta.gbK());
                }
                ZA("");
                AppMethodBeat.o(78594);
            } else {
                Log.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                ZA(str);
                AppMethodBeat.o(78594);
            }
        }

        private void ZA(String str) {
            AppMethodBeat.i(78595);
            if (Util.isNullOrNil(str)) {
                this.IVL.c("", null);
            } else {
                this.IVL.c(str, null);
            }
            com.tencent.mm.plugin.webview.ui.tools.game.g.bJ(this.IVL.cta.coX(), System.currentTimeMillis());
            release();
            AppMethodBeat.o(78595);
        }

        private void release() {
            this.IVL = null;
            this.appId = null;
        }
    }
}
