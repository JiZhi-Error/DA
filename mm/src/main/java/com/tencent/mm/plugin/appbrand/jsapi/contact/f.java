package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends d {
    public static final int CTRL_INDEX = 550;
    public static final String NAME = "privateEnterContact";
    private String lRW;
    final int lSl = com.tencent.luggage.sdk.g.a.aK(this);
    String lSu;
    String lSv;
    String lSw;
    String lSx;
    String lSy;

    /* access modifiers changed from: package-private */
    public interface a {
        void a(boolean z, String str, Intent intent);
    }

    public f() {
        AppMethodBeat.i(174785);
        AppMethodBeat.o(174785);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46278);
        if (fVar instanceof s) {
            s sVar = (s) fVar;
            ac currentPageView = sVar.getCurrentPageView();
            if (currentPageView == null) {
                Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
                sVar.i(i2, h("fail:current page do not exist", null));
                AppMethodBeat.o(46278);
                return;
            }
            a(currentPageView, sVar, jSONObject, i2);
            AppMethodBeat.o(46278);
        } else if (fVar instanceof ac) {
            a((ac) fVar, fVar, jSONObject, i2);
            AppMethodBeat.o(46278);
        } else {
            Log.w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
            AppMethodBeat.o(46278);
        }
    }

    private void a(ac acVar, final com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46279);
        a(acVar, jSONObject, new a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.contact.f.a
            public final void a(boolean z, String str, Intent intent) {
                AppMethodBeat.i(46275);
                Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", Boolean.valueOf(z));
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
                    Log.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", str2, hashMap2.toString());
                    fVar.i(i2, f.this.n("ok", hashMap));
                    AppMethodBeat.o(46275);
                    return;
                }
                fVar.i(i2, f.this.h(str, null));
                AppMethodBeat.o(46275);
            }
        });
        AppMethodBeat.o(46279);
    }

    private void a(ac acVar, JSONObject jSONObject, a aVar) {
        AppMethodBeat.i(46280);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
            aVar.a(false, "fail:invalid data", null);
            AppMethodBeat.o(46280);
        } else if (((AppBrandSysConfigWC) acVar.getRuntime().OT()) == null) {
            Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
            aVar.a(false, "fail:config is null", null);
            AppMethodBeat.o(46280);
        } else {
            this.lRW = jSONObject.optString("sessionFrom");
            if (this.lRW.length() > 1024) {
                this.lRW = this.lRW.substring(0, 1024);
                Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
            }
            this.lSu = jSONObject.optString("appId");
            if (!Util.isNullOrNil(this.lSu)) {
                this.lSv = jSONObject.optString("userName");
                this.lSw = jSONObject.optString("title");
                this.lSx = jSONObject.optString("subTitle");
                this.lSy = jSONObject.optString("headimgUrl");
                a(acVar, aVar);
            }
            AppMethodBeat.o(46280);
        }
    }

    private void a(final ac acVar, final a aVar) {
        AppMethodBeat.i(46281);
        final JsApiChattingTask jsApiChattingTask = new JsApiChattingTask();
        jsApiChattingTask.username = this.lSv;
        jsApiChattingTask.lRW = this.lRW;
        jsApiChattingTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(46277);
                Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("key_temp_session_from", jsApiChattingTask.lRW);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                WxaExposedParams.a aVar = new WxaExposedParams.a();
                aVar.appId = f.this.lSu;
                aVar.username = f.this.lSv;
                aVar.from = 5;
                intent.putExtra("app_brand_chatting_expose_params", aVar.bAv());
                intent.putExtra("keyPrivateAppId", f.this.lSu);
                intent.putExtra("keyPrivateUserName", f.this.lSv);
                intent.putExtra("keyPrivateTitle", f.this.lSw);
                intent.putExtra("keyPrivateSubTitle", f.this.lSx);
                intent.putExtra("keyPrivateHeadImage", f.this.lSy);
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(acVar.getRuntime().mContext);
                if (castActivityOrNull == null) {
                    if (aVar != null) {
                        aVar.a(false, "fail:internal error invalid android context", null);
                    }
                    Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
                    AppMethodBeat.o(46277);
                    return;
                }
                com.tencent.luggage.h.f.aK(castActivityOrNull).b(new f.c() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.contact.f.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.luggage.h.f.c
                    public final boolean c(int i2, int i3, Intent intent) {
                        AppMethodBeat.i(174784);
                        if (i2 == f.this.lSl) {
                            if (aVar != null) {
                                aVar.a(true, "ok", intent);
                            }
                            jsApiChattingTask.bDK();
                            AppMethodBeat.o(174784);
                            return true;
                        }
                        AppMethodBeat.o(174784);
                        return false;
                    }
                });
                c.c(castActivityOrNull, ".ui.chatting.AppBrandServiceChattingUI", intent, f.this.lSl);
                AppMethodBeat.o(46277);
            }
        };
        jsApiChattingTask.bDJ();
        AppBrandMainProcessService.a(jsApiChattingTask);
        AppMethodBeat.o(46281);
    }
}
