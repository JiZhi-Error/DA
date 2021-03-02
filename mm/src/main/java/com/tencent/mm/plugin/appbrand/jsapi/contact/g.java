package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.a;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends d {
    public static final int CTRL_INDEX = 414;
    public static final String NAME = "searchContacts";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        boolean z;
        String replaceAll;
        AppMethodBeat.i(137501);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiSearchContacts", "data is null, err");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(137501);
            return;
        }
        Log.i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
        Log.d("MicroMsg.JsApiSearchContacts", "data:%s", jSONObject);
        Context context = fVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            Log.e("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", fVar.getAppId());
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(137501);
            return;
        }
        r.b(fVar.getAppId(), new a.AbstractC0015a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.g.AnonymousClass1 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(137500);
                if (i2 != 48) {
                    AppMethodBeat.o(137500);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    fVar.i(i2, g.this.h("fail:system permission denied", null));
                    AppMethodBeat.o(137500);
                } else {
                    g.this.a(fVar, jSONObject, i2);
                    AppMethodBeat.o(137500);
                }
            }
        });
        Context context2 = fVar.getContext();
        if (context2 == null || !(context2 instanceof Activity)) {
            fVar.i(i2, h("fail", null));
            z = false;
        } else {
            z = i.a((Activity) context2, "android.permission.READ_CONTACTS", 48, "", "");
            if (z) {
                r.aeq(fVar.getAppId());
            }
        }
        if (!z) {
            Log.i("MicroMsg.JsApiSearchContacts", "check permission");
            AppMethodBeat.o(137501);
            return;
        }
        String optString = jSONObject.optString("phoneNumber");
        if (optString.length() < 8) {
            Log.e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
            HashMap hashMap = new HashMap();
            hashMap.put("result", "");
            fVar.i(i2, n("ok", hashMap));
            AppMethodBeat.o(137501);
            return;
        }
        List<String[]> dO = dO(context);
        JSONArray jSONArray = new JSONArray();
        if (!dO.isEmpty()) {
            for (String[] strArr : dO) {
                String str = strArr[2];
                if (str == null) {
                    replaceAll = null;
                } else {
                    replaceAll = str.replaceAll("\\D", "");
                    if (replaceAll.startsWith("86")) {
                        replaceAll = replaceAll.substring(2);
                    }
                }
                String nullAs = Util.nullAs(strArr[1], "");
                if (!Util.isNullOrNil(replaceAll) && dq(optString, replaceAll)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("phoneNumber", replaceAll);
                        jSONObject2.put("name", nullAs);
                        jSONArray.put(jSONObject2);
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.JsApiSearchContacts", e2, "", new Object[0]);
                    }
                }
            }
        }
        Log.d("MicroMsg.JsApiSearchContacts", "resultArray:%s", jSONArray.toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", jSONArray);
        fVar.i(i2, n("ok", hashMap2));
        AppMethodBeat.o(137501);
    }

    private static boolean dq(String str, String str2) {
        AppMethodBeat.i(137502);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
            AppMethodBeat.o(137502);
            return false;
        }
        int length = str.length();
        int length2 = str2.length();
        if (length < 8) {
            Log.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", Integer.valueOf(str.length()));
            AppMethodBeat.o(137502);
            return false;
        } else if (length > length2) {
            Log.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", Integer.valueOf(length), Integer.valueOf(length2));
            AppMethodBeat.o(137502);
            return false;
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i2 < length && (str.charAt(i2) == str2.charAt(i2) || (i3 = i3 + 1) <= 3)) {
                i2++;
            }
            if (i3 <= 3) {
                AppMethodBeat.o(137502);
                return true;
            }
            AppMethodBeat.o(137502);
            return false;
        }
    }

    private static List<String[]> dO(Context context) {
        Cursor query;
        AppMethodBeat.i(137503);
        LinkedList linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        try {
            query = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.JsApiSearchContacts", e2, "", new Object[0]);
            Log.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo(), [%s]", e2.getMessage());
            query = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        }
        if (query == null) {
            Log.e("MicroMsg.JsApiSearchContacts", "getMobileInfo: mobile is null");
            AppMethodBeat.o(137503);
            return linkedList;
        }
        try {
            if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                AppMethodBeat.o(137503);
                return linkedList;
            }
            do {
                String string = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                linkedList.add(new String[]{query.getString(query.getColumnIndex("contact_id")), string, query.getString(query.getColumnIndex("data1")), query.getString(query.getColumnIndex("raw_contact_id"))});
            } while (query.moveToNext());
            query.close();
            AppMethodBeat.o(137503);
            return linkedList;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.JsApiSearchContacts", e3, "", new Object[0]);
            Log.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo()2, [%s]", e3.getMessage());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.o(137503);
            throw th;
        }
    }
}
