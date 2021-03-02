package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends d<ac> {
    public static final int CTRL_INDEX = 204;
    public static final String NAME = "getUserAutoFillData";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147153);
        final ac acVar2 = acVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData data is invalid");
            acVar2.i(i2, h("fail:data is invalid", null));
            AppMethodBeat.o(147153);
            return;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray(GraphRequest.FIELDS_PARAM);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                linkedList.add(optJSONArray.optString(i3));
            }
        }
        if (linkedList.size() == 0) {
            Log.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData fields is empty");
            acVar2.i(i2, h("fail:fields is empty", null));
            AppMethodBeat.o(147153);
            return;
        }
        String appId = acVar2.getAppId();
        int optInt = jSONObject.optInt("clientVersion", 0);
        Log.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData appId:%s, clientVersion:%s data:%s", appId, Integer.valueOf(optInt), jSONObject.toString());
        bwx bwx = new bwx();
        bwx.McG = linkedList;
        bwx.dNI = appId;
        bwx.McF = jSONObject.optBoolean("getAllInfo", false);
        bwx.source = 1;
        bwx.KFC = optInt;
        ((c) acVar2.M(c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", bwx, bwy.class).c(new a<Object, bwy>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.e.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(bwy bwy) {
                AppMethodBeat.i(147152);
                bwy bwy2 = bwy;
                HashMap hashMap = new HashMap();
                if (bwy2 == null) {
                    Log.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, null response");
                    hashMap.put("ret", -99);
                    acVar2.i(i2, e.this.n("fail: ErrMsg: cgi fail", hashMap));
                    AppMethodBeat.o(147152);
                } else if (bwy2.BaseResponse.Ret != 0) {
                    Log.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(bwy2.BaseResponse.Ret), bwy2.BaseResponse.ErrMsg);
                    hashMap.put("ret", Integer.valueOf(bwy2.BaseResponse.Ret));
                    acVar2.i(i2, e.this.n("fail: ErrMsg:" + bwy2.BaseResponse.ErrMsg, hashMap));
                    AppMethodBeat.o(147152);
                } else {
                    Log.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
                    String str = "";
                    if (!TextUtils.isEmpty(bwy2.McH)) {
                        str = bwy2.McH;
                    }
                    String str2 = "";
                    if (!TextUtils.isEmpty(bwy2.McI)) {
                        str2 = bwy2.McI;
                    }
                    int i2 = bwy2.KLv;
                    LinkedList<String> linkedList = bwy2.McJ;
                    Log.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData auth_info:%s, auth_status:%d", str2, Integer.valueOf(i2));
                    Log.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData user_info_json:%s", str);
                    hashMap.put("userData", str);
                    hashMap.put("authStatus", Integer.valueOf(i2));
                    hashMap.put("authInfo", str2);
                    if (linkedList != null && linkedList.size() > 0) {
                        hashMap.put("authGroupList", new JSONArray((Collection) linkedList));
                        Log.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData authGroupList:%s", new JSONArray((Collection) linkedList).toString());
                    }
                    acVar2.i(i2, e.this.n("ok", hashMap));
                    AppMethodBeat.o(147152);
                }
                return null;
            }
        });
        AppMethodBeat.o(147153);
    }
}
