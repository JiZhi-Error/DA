package com.tencent.mm.plugin.webview.d;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n {
    public b IBt;
    public JsapiPermissionWrapper IBv;
    public Bundle IRs;
    public String ISe;
    public JSONObject ISf;
    public Map<String, Object> ISg = new HashMap();
    public String mhO;
    public Map<String, Object> params;
    public String type;

    public n() {
        AppMethodBeat.i(224430);
        AppMethodBeat.o(224430);
    }

    public final Map<String, Object> gbq() {
        return this.ISg;
    }

    public static class a {
        public static String a(String str, Map<String, Object> map, boolean z, String str2) {
            AppMethodBeat.i(224420);
            String a2 = a("callback", str, map, null, z, str2);
            AppMethodBeat.o(224420);
            return a2;
        }

        public static String a(String str, JSONObject jSONObject, boolean z, String str2) {
            AppMethodBeat.i(224421);
            String a2 = a("event", str, null, jSONObject, z, str2);
            AppMethodBeat.o(224421);
            return a2;
        }

        public static String b(String str, Map<String, Object> map, boolean z, String str2) {
            AppMethodBeat.i(224422);
            String a2 = a("event", str, map, null, z, str2);
            AppMethodBeat.o(224422);
            return a2;
        }

        private static String a(String str, String str2, Map<String, Object> map, JSONObject jSONObject, boolean z, String str3) {
            AppMethodBeat.i(224423);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__msg_type", str);
                if (str.equals("callback")) {
                    jSONObject2.put("__callback_id", str2);
                } else if (str.equals("event")) {
                    jSONObject2.put("__event_id", str2);
                }
                if (jSONObject == null) {
                    jSONObject2.put("__params", be(map));
                } else {
                    jSONObject2.put("__params", jSONObject);
                }
                if (z) {
                    String o = o(jSONObject2, str3);
                    AppMethodBeat.o(224423);
                    return o;
                }
                String jSONObject3 = jSONObject2.toString();
                AppMethodBeat.o(224423);
                return jSONObject3;
            } catch (Exception e2) {
                Log.e("MicroMsg.MsgWrapper", "build fail, exception = " + e2.getMessage());
                AppMethodBeat.o(224423);
                return null;
            }
        }

        private static String o(JSONObject jSONObject, String str) {
            AppMethodBeat.i(224424);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__json_message", jSONObject);
                String replaceAll = jSONObject.toString().replaceAll("\\\\/", FilePathGenerator.ANDROID_DIR_SEP);
                Log.i("MicroMsg.MsgWrapper", "js digest verification contentStr = %s", replaceAll);
                String fc = com.tencent.mm.b.n.fc(replaceAll + str);
                Log.i("MicroMsg.MsgWrapper", "js digest verification shaStr = %s", fc);
                jSONObject2.put("__sha_key", fc);
                String jSONObject3 = jSONObject2.toString();
                AppMethodBeat.o(224424);
                return jSONObject3;
            } catch (Exception e2) {
                Log.e("MicroMsg.MsgWrapper", "build fail, exception = " + e2.getMessage());
                AppMethodBeat.o(224424);
                return null;
            }
        }

        public static JSONObject be(Map<String, Object> map) {
            AppMethodBeat.i(224425);
            if (map == null || map.size() == 0) {
                JSONObject jSONObject = new JSONObject();
                AppMethodBeat.o(224425);
                return jSONObject;
            }
            try {
                String str = (String) map.get("jsapi_callback_json_special_key");
                JSONObject jSONObject2 = new JSONObject();
                for (String str2 : map.keySet()) {
                    if (str2 != null && !str2.equals("jsapi_callback_json_special_key")) {
                        if (str == null || !str2.equals(str)) {
                            jSONObject2.put(str2, map.get(str2));
                        } else {
                            jSONObject2.put(str, new JSONArray((String) map.get(str)));
                        }
                    }
                }
                AppMethodBeat.o(224425);
                return jSONObject2;
            } catch (Exception e2) {
                Log.e("MicroMsg.MsgWrapper", "convertMapToJSON fail, exception = " + e2.getMessage());
                AppMethodBeat.o(224425);
                return null;
            }
        }

        public static n lY(String str, String str2) {
            AppMethodBeat.i(224426);
            n nVar = new n();
            nVar.type = "call";
            nVar.mhO = str;
            nVar.params = new HashMap();
            nVar.ISe = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            JSONObject jSONObject = new JSONObject(str2);
            if (TextUtils.isEmpty(nVar.mhO) || !org.apache.commons.b.a.contains(c.KyC, nVar.mhO)) {
                nVar.ISf = null;
            } else {
                nVar.ISf = jSONObject;
            }
            a(jSONObject, nVar.params);
            AppMethodBeat.o(224426);
            return nVar;
        }

        private static void a(JSONObject jSONObject, Map<String, Object> map) {
            AppMethodBeat.i(224427);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                if (string == null) {
                    string = "";
                }
                if ("urls".equalsIgnoreCase(next)) {
                    Log.v("MicroMsg.MsgWrapper", "key is JSONArray, %s", next);
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        String[] strArr = new String[jSONArray.length()];
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            strArr[i2] = jSONArray.getString(i2);
                        }
                        map.put(next, strArr);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MsgWrapper", "parse JSONArray fail, ex = %s", e2.getMessage());
                    }
                } else {
                    map.put(next, string);
                }
            }
            AppMethodBeat.o(224427);
        }

        private static n aYn(String str) {
            AppMethodBeat.i(224428);
            if (str == null || str.length() == 0) {
                Log.e("MicroMsg.MsgWrapper", "fromString fail, src is null");
                AppMethodBeat.o(224428);
                return null;
            }
            n nVar = new n();
            try {
                JSONObject jSONObject = new JSONObject(str);
                nVar.type = jSONObject.getString("__msg_type");
                nVar.ISe = jSONObject.optString("__callback_id", "-1");
                nVar.mhO = jSONObject.getString("func");
                nVar.params = new HashMap();
                JSONObject jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                if (TextUtils.isEmpty(nVar.mhO) || !org.apache.commons.b.a.contains(c.KyC, nVar.mhO)) {
                    nVar.ISf = null;
                } else {
                    nVar.ISf = jSONObject2;
                }
                if (jSONObject2 != null) {
                    a(jSONObject2, nVar.params);
                }
                AppMethodBeat.o(224428);
                return nVar;
            } catch (Exception e2) {
                Log.e("MicroMsg.MsgWrapper", "fromString fail, exception = " + e2.getMessage());
                AppMethodBeat.o(224428);
                return null;
            }
        }

        static List<n> k(String str, boolean z, String str2) {
            JSONArray jSONArray;
            AppMethodBeat.i(224429);
            if (str == null || str.length() == 0) {
                Log.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
                AppMethodBeat.o(224429);
                return null;
            }
            if (z) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("__json_message");
                    String string = jSONObject.getString("__sha_key");
                    String fc = com.tencent.mm.b.n.fc(jSONArray2.toString().replaceAll("\\\\/", FilePathGenerator.ANDROID_DIR_SEP) + str2);
                    if (!string.equals(fc)) {
                        Log.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", string, fc, jSONArray2.toString().replaceAll("\\\\/", FilePathGenerator.ANDROID_DIR_SEP));
                        h.INSTANCE.idkeyStat(894, 6, 1, false);
                        AppMethodBeat.o(224429);
                        return null;
                    }
                    jSONArray = jSONArray2;
                } catch (Exception e2) {
                    Log.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + e2.getMessage());
                    AppMethodBeat.o(224429);
                    return null;
                }
            } else {
                jSONArray = new JSONArray(str);
            }
            if (jSONArray.length() == 0) {
                AppMethodBeat.o(224429);
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                linkedList.add(aYn(jSONArray.getString(i2)));
            }
            AppMethodBeat.o(224429);
            return linkedList;
        }
    }

    public static Bundle bL(Map<String, Object> map) {
        AppMethodBeat.i(224431);
        if (map == null || map.size() == 0) {
            AppMethodBeat.o(224431);
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String[]) {
                bundle.putStringArray(str, (String[]) obj);
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else {
                bundle.putString(str, String.valueOf(obj));
            }
        }
        AppMethodBeat.o(224431);
        return bundle;
    }

    public static Map<String, Object> aN(Bundle bundle) {
        AppMethodBeat.i(224432);
        if (bundle == null) {
            AppMethodBeat.o(224432);
            return null;
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            AppMethodBeat.o(224432);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : keySet) {
            hashMap.put(str, bundle.get(str));
        }
        AppMethodBeat.o(224432);
        return hashMap;
    }
}
