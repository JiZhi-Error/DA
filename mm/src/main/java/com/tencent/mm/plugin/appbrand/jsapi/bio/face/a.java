package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.c;
import com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class a extends d<k> {
    /* access modifiers changed from: protected */
    public abstract boolean bFa();

    /* access modifiers changed from: protected */
    public abstract String bFb();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        final boolean z = false;
        final k kVar2 = kVar;
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            Log.e("MicroMsg.JsApiFaceAsyncBase", "JsApiFaceAsyncBase context is null, appId is %s", kVar2.getAppId());
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            return;
        }
        String optString = jSONObject.optString("requestVerifyPreInfo");
        int optInt = jSONObject.optInt("checkAliveType");
        String appId = kVar2.getAppId();
        int i3 = bFa() ? 1001 : 1000;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("scene", 5);
        bundle.putBoolean("needVideo", bFa());
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("appId", appId);
        bundle.putString("request_verify_pre_info", optString);
        bundle.putInt("key_business_type", 4);
        bundle.putString("key_function_name", bFb());
        bundle.putInt("check_alive_type", optInt);
        bundle.putBoolean("key_is_need_confirm_page", bFc());
        Intent intent = new Intent(castActivityOrNull, FaceTransparentStubUI.class);
        intent.putExtra("KEY_EXTRAS", bundle);
        intent.putExtra("KEY_REQUEST_CODE", i3);
        final c cVar = (c) e.M(c.class);
        if (cVar != null) {
            z = cVar.u(kVar2);
        }
        if (z) {
            cVar.bHL();
        }
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bio.face.a.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                int i4;
                Bundle bundle = null;
                AppMethodBeat.i(175253);
                if (z) {
                    cVar.bHK();
                }
                if (intent != null) {
                    i4 = intent.getIntExtra("err_code", 90199);
                } else {
                    i4 = 90199;
                }
                if (i2 == 1000) {
                    Log.i("MicroMsg.JsApiFaceAsyncBase", "alvinluo: requestWxFacePictureVerify errCode: %d", Integer.valueOf(i4));
                    if (i4 == 0) {
                        a aVar = a.this;
                        k kVar = kVar2;
                        int i5 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, kVar, i5, bundle, "ok");
                    } else if (i4 == 90100) {
                        a aVar2 = a.this;
                        k kVar2 = kVar2;
                        int i6 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar2, kVar2, i6, bundle, "cancel");
                    } else {
                        a aVar3 = a.this;
                        k kVar3 = kVar2;
                        int i7 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar3, kVar3, i7, bundle, "fail");
                    }
                    AppMethodBeat.o(175253);
                    return true;
                } else if (i2 == 1001) {
                    Log.i("MicroMsg.JsApiFaceAsyncBase", "hy: REQUEST_FACE_DETECT_WITH_VIDEO errCode: %d", Integer.valueOf(i4));
                    if (i4 == 0) {
                        a aVar4 = a.this;
                        k kVar4 = kVar2;
                        int i8 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar4, kVar4, i8, bundle, "ok");
                    } else if (i4 == 90100) {
                        a aVar5 = a.this;
                        k kVar5 = kVar2;
                        int i9 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar5, kVar5, i9, bundle, "cancel");
                    } else {
                        a aVar6 = a.this;
                        k kVar6 = kVar2;
                        int i10 = i2;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar6, kVar6, i10, bundle, "fail");
                    }
                    AppMethodBeat.o(175253);
                    return true;
                } else {
                    AppMethodBeat.o(175253);
                    return false;
                }
            }
        });
        castActivityOrNull.startActivityForResult(intent, i3);
    }

    /* access modifiers changed from: protected */
    public boolean bFc() {
        return true;
    }

    static /* synthetic */ void a(a aVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, int i2, Bundle bundle, String str) {
        int i3 = -1;
        String str2 = "not returned";
        String str3 = "";
        if (bundle != null) {
            i3 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            str3 = bundle.getString("verify_result");
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("errCode", Integer.valueOf(i3));
        hashMap.put("verifyResult", str3);
        if ("fail".equals(str)) {
            str = str + " " + str2;
        }
        fVar.i(i2, aVar.n(str, hashMap));
    }
}
