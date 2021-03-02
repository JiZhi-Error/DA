package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.c;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetectaction.ui.FaceTransStubUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<k> {
    public static final int CTRL_INDEX = 495;
    public static final String NAME = "faceVerifyForPay";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        final boolean z;
        AppMethodBeat.i(106568);
        final k kVar2 = kVar;
        this.lxO = false;
        Log.i("MicroMsg.JsApiStartFaceAction", " start JsApiStartFaceAction（） ");
        h.INSTANCE.idkeyStat(917, 35, 1, false);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            Log.e("MicroMsg.JsApiStartFaceAction", "JsApiFaceAsyncBase context is null, appId is %s", kVar2.getAppId());
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(106568);
            return;
        }
        int optInt = jSONObject.optInt("scene");
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("packageSign");
        String optString3 = jSONObject.optString("otherVerifyTitle");
        String optString4 = jSONObject.optString("needFrontPage");
        Log.i("MicroMsg.JsApiStartFaceAction", " packageName ：%s , packageSign:%s , otherVerifyTitle:%s ,needFrontPage:%s", optString, optString2, optString3, optString4);
        Intent intent = new Intent(castActivityOrNull, FaceTransStubUI.class);
        Bundle bundle = new Bundle();
        bundle.putInt("scene", optInt);
        bundle.putString("package", optString);
        bundle.putString("packageSign", optString2);
        bundle.putString("otherVerifyTitle", optString3);
        bundle.putString("needFrontPage", optString4);
        intent.putExtras(bundle);
        final c cVar = (c) e.M(c.class);
        if (cVar != null) {
            z = cVar.u(kVar2);
        } else {
            z = false;
        }
        if (z) {
            cVar.bHL();
        }
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(175254);
                Log.i("MicroMsg.JsApiStartFaceAction", "carson: start mmOnActivityResult（） ");
                if (z) {
                    cVar.bHK();
                }
                if (intent == null) {
                    Log.e("MicroMsg.JsApiStartFaceAction", "mmOnActivityResult NULL data, appId[%s], callbackId[%d]", kVar2.getAppId(), Integer.valueOf(i2));
                    d.a(d.this, kVar2, i2, null, "fail:internal error");
                    AppMethodBeat.o(175254);
                    return true;
                }
                int HL = l.HL(intent.getIntExtra("err_code", 0));
                int intExtra = intent.getIntExtra("scene", 0);
                int intExtra2 = intent.getIntExtra("countFace", 0);
                long longExtra = intent.getLongExtra("totalTime", 0);
                int intExtra3 = intent.getIntExtra("err_type", 6);
                Log.i("MicroMsg.JsApiStartFaceAction", "errCode： ".concat(String.valueOf(HL)));
                Log.i("MicroMsg.JsApiStartFaceAction", "scene： ".concat(String.valueOf(intExtra)));
                Log.i("MicroMsg.JsApiStartFaceAction", "countFace： ".concat(String.valueOf(intExtra2)));
                Log.i("MicroMsg.JsApiStartFaceAction", "totalTime： ".concat(String.valueOf(longExtra)));
                Log.i("MicroMsg.JsApiStartFaceAction", "errorType： ".concat(String.valueOf(intExtra3)));
                if (i2 == 63) {
                    Log.i("MicroMsg.JsApiStartFaceAction", "REQUEST_FACE_VERIFY_FOR_PAY resultCode: %d", Integer.valueOf(i3));
                    if (i3 == -1) {
                        h.INSTANCE.a(15711, Integer.valueOf(intExtra), 0, Integer.valueOf(intExtra2), Long.valueOf(longExtra), 3, 0, Integer.valueOf(HL));
                        d.a(d.this, kVar2, i2, intent != null ? intent.getExtras() : null, "ok");
                    } else if (i3 == 1) {
                        h.INSTANCE.a(15711, Integer.valueOf(intExtra), 3, Integer.valueOf(intExtra2), Long.valueOf(longExtra), 3, Integer.valueOf(intExtra3), Integer.valueOf(HL));
                        d.a(d.this, kVar2, i2, intent != null ? intent.getExtras() : null, "fail");
                    } else if (i3 == 0) {
                        h.INSTANCE.a(15711, Integer.valueOf(intExtra), 2, Integer.valueOf(intExtra2), Long.valueOf(longExtra), 3, 1, Integer.valueOf(HL));
                        d.a(d.this, kVar2, i2, intent != null ? intent.getExtras() : null, "cancel");
                    }
                    AppMethodBeat.o(175254);
                    return true;
                }
                AppMethodBeat.o(175254);
                return false;
            }
        });
        castActivityOrNull.startActivityForResult(intent, 63);
        AppMethodBeat.o(106568);
    }

    static /* synthetic */ void a(d dVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, int i2, Bundle bundle, String str) {
        AppMethodBeat.i(106569);
        Log.i("MicroMsg.JsApiStartFaceAction", "carson: start mmOnActivityResult（） ");
        Log.i("MicroMsg.JsApiStartFaceAction", "carson： generalErrMsg ：".concat(String.valueOf(str)));
        int i3 = -1;
        String str2 = "nothing return";
        String str3 = "";
        String str4 = "";
        Boolean bool = Boolean.FALSE;
        if (bundle != null) {
            Log.i("MicroMsg.JsApiStartFaceAction", "carson: extras ≠ null  ");
            i3 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            str3 = bundle.getString("token");
            str4 = bundle.getString("serial_id");
            Log.i("MicroMsg.JsApiStartFaceAction", "carson：errCode：".concat(String.valueOf(i3)));
            Log.i("MicroMsg.JsApiStartFaceAction", "carson：errMsg ：".concat(String.valueOf(str2)));
            Log.i("MicroMsg.JsApiStartFaceAction", "carson：token：".concat(String.valueOf(str3)));
            if (bundle.getString("click_other_verify_btn") != null && "yes".equals(bundle.getString("click_other_verify_btn"))) {
                bool = Boolean.TRUE;
            }
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("err_code", Integer.valueOf(i3));
        hashMap.put("token", str3);
        hashMap.put("serial_id", str4);
        hashMap.put("click_other_verify_btn", bool);
        Log.i("MicroMsg.JsApiStartFaceAction", "carson: service back data");
        fVar.i(i2, dVar.n(str2, hashMap));
        AppMethodBeat.o(106569);
    }
}
