package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ba extends d<c> {
    public static final int CTRL_INDEX = 627;
    public static final String NAME = "chooseShareGroup";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        String[] strArr;
        AppMethodBeat.i(45472);
        final c cVar2 = cVar;
        if (jSONObject == null) {
            cVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(45472);
            return;
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(cVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(45472);
            return;
        }
        try {
            String string = jSONObject.getString("title");
            boolean optBoolean = jSONObject.has("public") ? jSONObject.optBoolean("public") : true;
            boolean optBoolean2 = jSONObject.has("private") ? jSONObject.optBoolean("private") : true;
            boolean optBoolean3 = jSONObject.has("visible") ? jSONObject.optBoolean("visible") : true;
            boolean optBoolean4 = jSONObject.has("invisible") ? jSONObject.optBoolean("invisible") : true;
            JSONArray optJSONArray = jSONObject.optJSONArray("labelList");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    strArr2[i3] = optJSONArray.getString(i3);
                }
                strArr = strArr2;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("userList");
            String[] strArr3 = null;
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                strArr3 = new String[optJSONArray2.length()];
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    strArr3[i4] = optJSONArray2.getString(i4);
                }
            }
            String optString = jSONObject.optString("group");
            Intent intent = new Intent();
            intent.putExtra("k_select_group", optString);
            intent.putExtra("k_title", string);
            intent.putExtra("k_show_public", optBoolean);
            intent.putExtra("k_show_private", optBoolean2);
            intent.putExtra("k_show_include", optBoolean3);
            intent.putExtra("k_show_exclude", optBoolean4);
            if (strArr != null) {
                intent.putExtra("Klabel_name_list", Util.listToString(Arrays.asList(strArr), ","));
            }
            if (strArr3 != null) {
                intent.putExtra("Kother_user_name_list", Util.listToString(Arrays.asList(strArr3), ","));
            }
            intent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.sns.ui.jsapi.JsapiSnsLabelUI");
            try {
                f.aK(castActivityOrNull).a(intent, new f.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.ba.AnonymousClass1 */

                    @Override // com.tencent.luggage.h.f.b
                    public final void a(int i2, Intent intent) {
                        char c2 = 65535;
                        AppMethodBeat.i(45471);
                        if (i2 == -1) {
                            String stringExtra = intent.getStringExtra("k_select_group");
                            HashMap hashMap = new HashMap();
                            if (!TextUtils.isEmpty(stringExtra)) {
                                switch (stringExtra.hashCode()) {
                                    case -1901805651:
                                        if (stringExtra.equals("invisible")) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                    case -977423767:
                                        if (stringExtra.equals("public")) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                    case -314497661:
                                        if (stringExtra.equals("private")) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case 466743410:
                                        if (stringExtra.equals("visible")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                    case 1:
                                        hashMap.put("group", stringExtra);
                                        cVar2.i(i2, ba.this.n("ok", hashMap));
                                        AppMethodBeat.o(45471);
                                        return;
                                    case 2:
                                    case 3:
                                        String stringExtra2 = intent.getStringExtra("Klabel_name_list");
                                        String stringExtra3 = intent.getStringExtra("Kother_user_name_list");
                                        hashMap.put("group", stringExtra);
                                        try {
                                            if (!TextUtils.isEmpty(stringExtra2)) {
                                                hashMap.put("labels", new JSONObject(stringExtra2));
                                            }
                                            if (!TextUtils.isEmpty(stringExtra3)) {
                                                hashMap.put("userList", new JSONArray(stringExtra3));
                                            }
                                            cVar2.i(i2, ba.this.n("ok", hashMap));
                                            AppMethodBeat.o(45471);
                                            return;
                                        } catch (JSONException e2) {
                                            Log.printErrStackTrace("MicroMsg.JsApiChooseShareGroup", e2, "", new Object[0]);
                                            break;
                                        }
                                }
                                cVar2.i(i2, ba.this.h("cancel", null));
                                AppMethodBeat.o(45471);
                                return;
                            }
                            cVar2.i(i2, ba.this.h("cancel", null));
                            AppMethodBeat.o(45471);
                            return;
                        }
                        cVar2.i(i2, ba.this.h("fail", null));
                        AppMethodBeat.o(45471);
                    }
                });
                AppMethodBeat.o(45472);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiChooseShareGroup", e2, "", new Object[0]);
                cVar2.i(i2, h("fail", null));
                AppMethodBeat.o(45472);
            }
        } catch (JSONException e3) {
            Log.e("MicroMsg.JsApiChooseShareGroup", "parse data failed by %s, appId:%s, callbackId:%d", e3, cVar2.getAppId(), Integer.valueOf(i2));
            cVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(45472);
        }
    }
}
