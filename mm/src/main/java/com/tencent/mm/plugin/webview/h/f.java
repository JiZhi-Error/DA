package com.tencent.mm.plugin.webview.h;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    private static List<String> JcK;
    private static List<String> JcL = new ArrayList();

    public interface a {
        void a(n nVar, String str, Map<String, Object> map);
    }

    static /* synthetic */ void bO(Map map) {
        AppMethodBeat.i(79244);
        m(map);
        AppMethodBeat.o(79244);
    }

    static {
        AppMethodBeat.i(79245);
        ArrayList arrayList = new ArrayList();
        JcK = arrayList;
        arrayList.add("updatePageAuth");
        AppMethodBeat.o(79245);
    }

    public static boolean a(final n nVar, final a aVar) {
        AppMethodBeat.i(211034);
        a.pl(70);
        String nullAs = Util.nullAs((String) nVar.params.get("key_request_full_url_query"), "");
        if (!Util.isNullOrNil(nullAs)) {
            nullAs = String.format("&wx_header=1&pass_ticket=%s", nullAs);
        }
        final String str = nVar.params.get("url") + nullAs;
        final String nullAs2 = Util.nullAs((String) nVar.params.get(FirebaseAnalytics.b.METHOD), "GET");
        String nullAs3 = Util.nullAs((String) nVar.params.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER), "");
        final String str2 = (String) nVar.params.get("data");
        Log.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]url:%s", str);
        String nullAs4 = Util.nullAs((String) nVar.params.get("key_request_header"), "");
        final HashMap hashMap = new HashMap();
        try {
            if (!Util.isNullOrNil(nullAs4)) {
                JSONObject jSONObject = new JSONObject(nullAs4);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            }
            if (!Util.isNullOrNil(nullAs3)) {
                JSONObject jSONObject2 = new JSONObject(nullAs3);
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    hashMap.put(next2, jSONObject2.optString(next2));
                }
            }
        } catch (JSONException e2) {
            Log.printInfoStack("MicroMsg.TmplWebViewJsAPi", "", e2);
        }
        Log.d("MicroMsg.TmplWebViewJsAPi", "[doRequest]url:%s, method:%s, header:%s, data:%s", str, nullAs2, nullAs3, str2);
        com.tencent.mm.plugin.webview.a.a.aj(new Runnable() {
            /* class com.tencent.mm.plugin.webview.h.f.AnonymousClass1 */

            public final void run() {
                e.a Q;
                int i2;
                AppMethodBeat.i(79237);
                if (nullAs2.toUpperCase().equals("POST")) {
                    Q = e.a(str, hashMap, str2);
                } else {
                    Q = e.Q(str, hashMap);
                }
                if (Q != null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(Q.statusCode);
                    if (Q.njn != null) {
                        i2 = Q.njn.size();
                    } else {
                        i2 = 0;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    Log.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse stats:%d, header.size:%d", objArr);
                    Log.v("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse header:%s data:%s", Q.njn, Q.data);
                    a.pl(71);
                    HashMap hashMap = new HashMap();
                    hashMap.put("statusCode", Integer.valueOf(Q.statusCode));
                    hashMap.put("data", Q.data);
                    if (Q.njn != null && Q.njn.size() > 0) {
                        f.bO(Q.njn);
                        hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, new JSONObject(Q.njn).toString());
                    }
                    Log.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]values success");
                    Log.d("MicroMsg.TmplWebViewJsAPi", "[doRequest]values:%s", hashMap);
                    aVar.a(nVar, nVar.mhO + ":ok", hashMap);
                    AppMethodBeat.o(79237);
                    return;
                }
                a.pl(72);
                Log.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse is null, return");
                aVar.a(nVar, nVar.mhO + ":fail", null);
                AppMethodBeat.o(79237);
            }
        });
        AppMethodBeat.o(211034);
        return true;
    }

    private static void m(Map map) {
        AppMethodBeat.i(79242);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                m((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.o(79242);
    }
}
