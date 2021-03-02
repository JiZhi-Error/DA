package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.na;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 592;
    public static final String NAME = "openBusinessView";
    q gut;
    boolean lUi = false;
    private IListener<na> lUj;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46293);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        String optString = jSONObject.optString("businessType");
        if (Util.isNullOrNil(optString)) {
            a(dVar2, i2, f.INVALID_BUSINESS_TYPE.errCode, f.INVALID_BUSINESS_TYPE.errMsg);
            AppMethodBeat.o(46293);
            return;
        }
        if (jSONObject.optJSONObject("extraData") == null) {
            new JSONObject();
        }
        if (jSONObject.optJSONObject("privateExtraData") == null) {
            new JSONObject();
        }
        String optString2 = jSONObject.optString("queryString");
        int i3 = dVar2.getRuntime().OT().leE.kNW;
        final int i4 = b.a(jSONObject.optString("envVersion"), b.RELEASE).iOo;
        if (!(i3 == 1 || i3 == 2)) {
            i4 = 0;
        }
        int optInt = jSONObject.optInt("sourcetype", 5);
        String optString3 = jSONObject.optString("agentId");
        final c.a aVar = new c.a();
        aVar.scene = jSONObject.optInt("scene", 0);
        aVar.dCw = jSONObject.optString("sceneNote");
        aVar.ecU = jSONObject.optInt("preScene", 0);
        aVar.ecV = jSONObject.optString("preSceneNote");
        aVar.sourceType = optInt;
        aVar.leq = optString3;
        aVar.businessType = optString;
        String appId = dVar2.getAppId();
        this.lUi = false;
        final Context context = dVar2.getContext();
        final AnonymousClass1 r1 = new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(46285);
                Log.w("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram, user canceled");
                d.this.lUi = true;
                d.a(d.this, dVar2, i2, f.CANCEL.errCode, f.CANCEL.errMsg);
                AppMethodBeat.o(46285);
            }
        };
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(180214);
                d.a(d.this);
                if (context != null) {
                    d dVar = d.this;
                    Context context = context;
                    context.getString(R.string.zb);
                    dVar.gut = h.a(context, context.getString(R.string.a06), true, r1);
                }
                AppMethodBeat.o(180214);
            }
        });
        this.lUj = new IListener<na>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.AnonymousClass3 */

            {
                AppMethodBeat.i(160598);
                this.__eventId = na.class.getName().hashCode();
                AppMethodBeat.o(160598);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(na naVar) {
                AppMethodBeat.i(46290);
                boolean a2 = a(naVar);
                AppMethodBeat.o(46290);
                return a2;
            }

            private boolean a(na naVar) {
                JSONObject jSONObject;
                String str;
                AppMethodBeat.i(46289);
                int i2 = naVar.dSK.errCode;
                if (i2 < 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(i2));
                    if (i2 == f.CGI_ERROR.errCode) {
                        str = f.CGI_ERROR.errMsg;
                    } else if (i2 == f.CANCEL.errCode) {
                        str = f.CANCEL.errMsg;
                    } else if (i2 == f.INVALID_BUSINESS_TYPE.errCode) {
                        str = f.INVALID_BUSINESS_TYPE.errMsg;
                    } else {
                        str = f.SYSTEM_ERROR.errMsg;
                    }
                    Log.i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram fail, errCode:%s, errMsg:%s", Integer.valueOf(i2), str);
                    dVar2.i(i2, d.this.n(str, hashMap));
                } else {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("errCode", Integer.valueOf(i2));
                    try {
                        jSONObject = new JSONObject(Util.nullAs(naVar.dSK.dSJ, "{}"));
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram, parse extraData fail", e2);
                        jSONObject = new JSONObject();
                    }
                    hashMap2.put("extraData", jSONObject);
                    Log.i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram success");
                    dVar2.i(i2, d.this.n(f.OK.errMsg, hashMap2));
                }
                dead();
                AppMethodBeat.o(46289);
                return false;
            }
        };
        this.lUj.alive();
        OpenBusinessViewUtil.a(3, optString, optString2, appId, null, new OpenBusinessViewUtil.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a
            public final void ds(String str, String str2) {
                AppMethodBeat.i(46287);
                d.a(d.this);
                if (d.this.lUi) {
                    AppMethodBeat.o(46287);
                } else if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram, invalid businessType");
                    d.a(d.this, dVar2, i2, f.INVALID_BUSINESS_TYPE.errCode, f.INVALID_BUSINESS_TYPE.errMsg);
                    AppMethodBeat.o(46287);
                } else {
                    g.lUC.a(dVar2, str, i4, str2, aVar, jSONObject, new c.AbstractC0681c() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.AbstractC0681c
                        public final void o(boolean z, String str) {
                            AppMethodBeat.i(46286);
                            if (z) {
                                Log.i("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram success");
                                AppMethodBeat.o(46286);
                                return;
                            }
                            Log.e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram fail, reason=%s", str);
                            d.a(d.this, dVar2, i2, f.SYSTEM_ERROR.errCode, f.SYSTEM_ERROR.errMsg);
                            AppMethodBeat.o(46286);
                        }
                    });
                    AppMethodBeat.o(46287);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a
            public final void ak(int i2, String str) {
                AppMethodBeat.i(46288);
                d.a(d.this);
                Log.e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
                d.a(d.this, dVar2, i2, f.CGI_ERROR.errCode, f.CGI_ERROR.errMsg);
                AppMethodBeat.o(46288);
            }
        });
        AppMethodBeat.o(46293);
    }

    static /* synthetic */ void a(d dVar, com.tencent.mm.plugin.appbrand.d dVar2, int i2, int i3, String str) {
        AppMethodBeat.i(46294);
        dVar.a(dVar2, i2, i3, str);
        AppMethodBeat.o(46294);
    }

    private void a(com.tencent.mm.plugin.appbrand.d dVar, int i2, int i3, String str) {
        AppMethodBeat.i(46291);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i3));
        dVar.i(i2, n(str, hashMap));
        AppMethodBeat.o(46291);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a
    public final c bGm() {
        return g.lUC;
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(180216);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(180215);
                if (d.this.gut != null) {
                    d.this.gut.dismiss();
                    d.this.gut = null;
                }
                AppMethodBeat.o(180215);
            }
        });
        AppMethodBeat.o(180216);
    }
}
