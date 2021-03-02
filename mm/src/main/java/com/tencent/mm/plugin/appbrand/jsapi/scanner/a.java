package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends d<s> {
    public static final int CTRL_INDEX = 434;
    public static final String NAME = "openQRCode";
    private static volatile boolean mpG = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        boolean z;
        AppMethodBeat.i(174871);
        final s sVar2 = sVar;
        if (mpG) {
            sVar2.i(i2, h("cancel", null));
            AppMethodBeat.o(174871);
            return;
        }
        mpG = true;
        Log.i("MicroMsg.JsApiOpenQRCode", "openQRCode data::%s", jSONObject);
        Activity ay = sVar2.ay(Activity.class);
        if (ay == null) {
            mpG = false;
            Log.e("MicroMsg.JsApiOpenQRCode", "pageContext is null, err");
            sVar2.i(i2, h("fail:context is err", null));
            AppMethodBeat.o(174871);
            return;
        }
        jSONObject.optString("desc");
        int i3 = Util.getInt(jSONObject.optString("needResult"), 1);
        String optString = jSONObject.optString("scanType");
        boolean z2 = false;
        boolean z3 = false;
        if (Util.isNullOrNil(optString)) {
            z2 = true;
            z3 = true;
        }
        if (optString != null) {
            try {
                JSONArray jSONArray = new JSONArray(optString);
                int i4 = 0;
                while (i4 < jSONArray.length()) {
                    String str = (String) jSONArray.get(i4);
                    if (str.equalsIgnoreCase("qrCode")) {
                        z2 = true;
                        z = z3;
                    } else if (str.equalsIgnoreCase("barCode")) {
                        z = true;
                    } else {
                        z = z3;
                    }
                    i4++;
                    z3 = z;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiOpenQRCode", "doScanQRCode, ex in scanType");
            }
        }
        int i5 = 1;
        if (z2 && !z3) {
            i5 = 8;
        } else if (!z2 && z3) {
            i5 = 4;
        }
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.scanner.a.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174870);
                boolean unused = a.mpG = false;
                if (i2 != (a.this.hashCode() & 65535)) {
                    AppMethodBeat.o(174870);
                    return false;
                }
                Log.i("MicroMsg.JsApiOpenQRCode", "onActivityResult requestCode:%d  resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                switch (i3) {
                    case -1:
                        if (intent != null) {
                            HashMap hashMap = new HashMap();
                            String stringExtra = intent.getStringExtra("key_scan_result");
                            String stringExtra2 = intent.getStringExtra("key_scan_result_code_name");
                            Log.d("MicroMsg.JsApiOpenQRCode", "result:%s, codeName:%s", stringExtra, stringExtra2);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("scan_type", e.d.bcW(stringExtra2) ? "qrcode" : "barcode");
                                jSONObject.put("scan_result", stringExtra);
                            } catch (JSONException e2) {
                                Log.printErrStackTrace("MicroMsg.JsApiOpenQRCode", e2, "", new Object[0]);
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("scan_code", jSONObject);
                            } catch (JSONException e3) {
                                Log.printErrStackTrace("MicroMsg.JsApiOpenQRCode", e3, "", new Object[0]);
                            }
                            hashMap.put("resultStr", jSONObject2.toString());
                            Log.d("MicroMsg.JsApiOpenQRCode", "ret:%s", hashMap);
                            sVar2.i(i2, a.this.n("ok", hashMap));
                            break;
                        } else {
                            Log.e("MicroMsg.JsApiOpenQRCode", "data is null, err");
                            sVar2.i(i2, a.this.h("fail:unknown err", null));
                            AppMethodBeat.o(174870);
                            return true;
                        }
                    case 0:
                        sVar2.i(i2, a.this.h("cancel", null));
                        break;
                    default:
                        sVar2.i(i2, a.this.h("fail", null));
                        break;
                }
                AppMethodBeat.o(174870);
                return true;
            }
        });
        if (i3 == 0) {
            Log.i("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivity");
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i5);
            intent.putExtra("key_enable_multi_code", false);
            intent.putExtra("key_scan_entry_scene", 4);
            c.c(ay, "scanner", ".ui.BaseScanUI", intent);
            mpG = false;
            sVar2.i(i2, h("ok", null));
            AppMethodBeat.o(174871);
        } else if (i3 == 1) {
            Log.d("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivityForResult requestCode:%d", Integer.valueOf(hashCode()));
            Intent intent2 = new Intent();
            intent2.putExtra("BaseScanUI_select_scan_mode", i5);
            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent2.putExtra("key_set_result_after_scan", true);
            intent2.putExtra("key_enable_multi_code", false);
            intent2.putExtra("key_scan_entry_scene", 4);
            intent2.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            c.a((Context) ay, "scanner", ".ui.BaseScanUI", intent2, hashCode() & 65535, false);
            AppMethodBeat.o(174871);
        } else {
            Log.e("MicroMsg.JsApiOpenQRCode", "needResult is err");
            sVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(174871);
        }
    }
}
