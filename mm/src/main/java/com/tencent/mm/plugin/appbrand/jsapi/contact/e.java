package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.y;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends d {
    public static final int CTRL_INDEX = 145;
    public static final String NAME = "enterContact";
    private String businessId;
    private String lRW;
    String lSf;
    String lSg;
    String lSh;
    boolean lSi;
    String lSj;
    boolean lSk;
    final int lSl = com.tencent.luggage.sdk.g.a.aK(this);

    /* access modifiers changed from: package-private */
    public interface a {
        void a(boolean z, String str, Intent intent);
    }

    public e() {
        AppMethodBeat.i(174783);
        AppMethodBeat.o(174783);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46260);
        if (fVar instanceof c) {
            c cVar = (c) fVar;
            ag bsz = cVar.bsz();
            if (bsz == null) {
                Log.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
                cVar.i(i2, h("fail:current page do not exist", null));
                AppMethodBeat.o(46260);
                return;
            }
            a(bsz, cVar, jSONObject, i2);
            AppMethodBeat.o(46260);
        } else if (fVar instanceof ac) {
            a((ag) fVar, fVar, jSONObject, i2);
            AppMethodBeat.o(46260);
        } else {
            fVar.i(i2, h("fail:internal error invalid js component", null));
            AppMethodBeat.o(46260);
        }
    }

    private void a(ag agVar, final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46261);
        a(agVar, jSONObject, new a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.contact.e.a
            public final void a(boolean z, String str, Intent intent) {
                AppMethodBeat.i(46255);
                Log.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", Boolean.valueOf(z));
                if (z) {
                    HashMap hashMap = new HashMap();
                    String str2 = "";
                    Object hashMap2 = new HashMap();
                    if (intent != null) {
                        String nullAs = Util.nullAs(intent.getStringExtra("keyOutPagePath"), "");
                        str2 = l.dM(nullAs);
                        hashMap2 = l.dN(nullAs);
                    }
                    hashMap.put("path", str2);
                    hashMap.put(SearchIntents.EXTRA_QUERY, hashMap2);
                    Log.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", str2, hashMap2.toString());
                    fVar.i(i2, e.this.n("ok", hashMap));
                    AppMethodBeat.o(46255);
                    return;
                }
                fVar.i(i2, e.this.h(str, null));
                AppMethodBeat.o(46255);
            }
        });
        AppMethodBeat.o(46261);
    }

    private void a(ag agVar, JSONObject jSONObject, a aVar) {
        AppMethodBeat.i(46262);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
            aVar.a(false, "fail:invalid data", null);
            AppMethodBeat.o(46262);
            return;
        }
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        if (bsB == null) {
            Log.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
            aVar.a(false, "fail:config is null", null);
            AppMethodBeat.o(46262);
            return;
        }
        this.lRW = jSONObject.optString("sessionFrom");
        if (this.lRW.length() > 1024) {
            this.lRW = this.lRW.substring(0, 1024);
            Log.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
        }
        this.businessId = jSONObject.optString("businessId");
        this.lSf = jSONObject.optString("sendMessageTitle");
        this.lSg = jSONObject.optString("sendMessagePath");
        this.lSh = jSONObject.optString("sendMessageImg");
        this.lSi = jSONObject.optBoolean("showMessageCard", false);
        this.lSk = y.aaK(this.lSh);
        this.lSj = y.a((com.tencent.luggage.sdk.b.a.c) agVar, this.lSh, true);
        if (Util.isNullOrNil(this.businessId)) {
            Log.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
            a(agVar, bsB, "", aVar);
            AppMethodBeat.o(46262);
            return;
        }
        Log.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
        a(agVar, bsB, aVar);
        AppMethodBeat.o(46262);
    }

    private void a(final ag agVar, final AppBrandSysConfigWC appBrandSysConfigWC, final a aVar) {
        AppMethodBeat.i(46263);
        String str = agVar.getRuntime().bsC().username;
        if (appBrandSysConfigWC == null || Util.isNullOrNil(str)) {
            Log.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
            if (aVar != null) {
                aVar.a(false, "fail:config is null", null);
            }
            AppMethodBeat.o(46263);
            return;
        }
        d.a aVar2 = new d.a();
        aVar2.iLN = new bvr();
        aVar2.iLO = new bvs();
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
        aVar2.funcId = 1303;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        com.tencent.mm.ak.d aXF = aVar2.aXF();
        bvr bvr = (bvr) aXF.iLK.iLR;
        bvr.username = str;
        bvr.MbE = this.businessId;
        IPCRunCgi.a(aXF, new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.e.AnonymousClass2 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                AppMethodBeat.i(46257);
                if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                    final bvs bvs = (bvs) dVar.iLL.iLR;
                    Log.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", bvs.MbF);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.contact.e.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(46256);
                            e.this.a(agVar, appBrandSysConfigWC, bvs.MbF, aVar);
                            AppMethodBeat.o(46256);
                        }
                    });
                    AppMethodBeat.o(46257);
                    return;
                }
                Log.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, dVar.iLL.iLR);
                if (aVar != null) {
                    aVar.a(false, "fail:cgi fail", null);
                }
                AppMethodBeat.o(46257);
            }
        });
        AppMethodBeat.o(46263);
    }

    /* access modifiers changed from: package-private */
    public final void a(final ag agVar, AppBrandSysConfigWC appBrandSysConfigWC, String str, final a aVar) {
        AppMethodBeat.i(46264);
        final JsApiChattingTask jsApiChattingTask = new JsApiChattingTask();
        String str2 = agVar.getRuntime().bsC().username;
        final WxaExposedParams.a aVar2 = new WxaExposedParams.a();
        aVar2.appId = agVar.getAppId();
        aVar2.username = str2;
        aVar2.nickname = appBrandSysConfigWC.brandName;
        aVar2.iconUrl = appBrandSysConfigWC.jyi;
        aVar2.kNW = appBrandSysConfigWC.leE.kNW;
        aVar2.pkgVersion = appBrandSysConfigWC.leE.pkgVersion;
        aVar2.lhn = appBrandSysConfigWC.leE.md5;
        aVar2.from = 5;
        aVar2.pageId = e(agVar);
        aVar2.lho = w.Ur(agVar.getAppId());
        jsApiChattingTask.username = dp(str2, str);
        jsApiChattingTask.nickname = m13do(appBrandSysConfigWC.brandName, str);
        jsApiChattingTask.lRW = this.lRW;
        jsApiChattingTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.e.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(46259);
                Log.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("app_brand_chatting_expose_params", aVar2.bAv());
                intent.putExtra("key_temp_session_from", jsApiChattingTask.lRW);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                if (e.this.lSi) {
                    intent.putExtra("sendMessageTitle", e.this.lSf);
                    intent.putExtra("sendMessagePath", e.this.lSg);
                    intent.putExtra("sendMessageImg", e.this.lSh);
                    intent.putExtra("sendMessageLocalImg", y.aaL(e.this.lSj));
                    intent.putExtra("needDelThumb", e.this.lSk);
                }
                intent.putExtra("showMessageCard", e.this.lSi);
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(agVar.getRuntime().mContext);
                if (castActivityOrNull == null) {
                    if (aVar != null) {
                        aVar.a(false, "fail:internal error invalid android context", null);
                    }
                    Log.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
                    AppMethodBeat.o(46259);
                    return;
                }
                com.tencent.luggage.h.f.aK(castActivityOrNull).b(new f.c() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.contact.e.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.luggage.h.f.c
                    public final boolean c(int i2, int i3, Intent intent) {
                        AppMethodBeat.i(174782);
                        if (i2 == e.this.lSl) {
                            if (aVar != null) {
                                aVar.a(true, "ok", intent);
                            }
                            jsApiChattingTask.bDK();
                            AppMethodBeat.o(174782);
                            return true;
                        }
                        AppMethodBeat.o(174782);
                        return false;
                    }
                });
                com.tencent.mm.br.c.c(castActivityOrNull, ".ui.chatting.AppBrandServiceChattingUI", intent, e.this.lSl);
                AppMethodBeat.o(46259);
            }
        };
        jsApiChattingTask.bDJ();
        AppBrandMainProcessService.a(jsApiChattingTask);
        AppMethodBeat.o(46264);
    }

    /* renamed from: do  reason: not valid java name */
    private static String m13do(String str, String str2) {
        AppMethodBeat.i(46265);
        if (!Util.isNullOrNil(str2)) {
            AppMethodBeat.o(46265);
            return "";
        } else if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(46265);
            return str;
        } else {
            Log.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
            AppMethodBeat.o(46265);
            return "";
        }
    }

    private static String dp(String str, String str2) {
        AppMethodBeat.i(46266);
        if (!Util.isNullOrNil(str2)) {
            AppMethodBeat.o(46266);
            return str2;
        } else if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(46266);
            return str;
        } else {
            Log.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
            AppMethodBeat.o(46266);
            return "";
        }
    }

    private static String e(ac acVar) {
        AppMethodBeat.i(46267);
        String str = "";
        if (acVar != null) {
            str = acVar.lBI;
        }
        Log.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", str);
        AppMethodBeat.o(46267);
        return str;
    }
}
