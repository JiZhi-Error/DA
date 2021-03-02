package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static volatile b nQP;
    private static Map<Integer, LinkedList<Map<Integer, Map<Integer, Float>>>> nQQ = new HashMap();

    static {
        AppMethodBeat.i(48502);
        bWF();
        AppMethodBeat.o(48502);
    }

    private b() {
    }

    public static b bWE() {
        AppMethodBeat.i(48499);
        if (nQP == null) {
            synchronized (b.class) {
                try {
                    if (nQP == null) {
                        nQP = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(48499);
                    throw th;
                }
            }
        }
        b bVar = nQP;
        AppMethodBeat.o(48499);
        return bVar;
    }

    private static void bWF() {
        AppMethodBeat.i(48500);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_preload_miniprogram, "");
        if (Util.isNullOrNil(a2)) {
            Log.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "clicfg_preload_miniprogram jsonStr error!");
            AppMethodBeat.o(48500);
            return;
        }
        Log.d("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "generateScenePredictMap jsonStr:%s", a2);
        try {
            JSONArray jSONArray = new JSONArray(a2);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = new JSONObject(jSONArray.optString(i2));
                int optInt = jSONObject.optInt("id");
                LinkedList<Map<Integer, Map<Integer, Float>>> linkedList = new LinkedList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadRate");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = new JSONObject(optJSONArray.optString(i3));
                    int optInt2 = jSONObject2.optInt("innerScene");
                    float optDouble = (float) jSONObject2.optDouble("low");
                    float optDouble2 = (float) jSONObject2.optDouble("high");
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(Integer.valueOf(c.LOW_LEVEL.ordinal()), Float.valueOf(optDouble));
                    hashMap2.put(Integer.valueOf(c.MIDDLE_LEVEL.ordinal()), Float.valueOf((float) jSONObject2.optDouble("middle")));
                    hashMap2.put(Integer.valueOf(c.HIGH_LEVEL.ordinal()), Float.valueOf(optDouble2));
                    hashMap.put(Integer.valueOf(optInt2), hashMap2);
                    linkedList.add(hashMap);
                }
                nQQ.put(Integer.valueOf(optInt), linkedList);
            }
            Log.d("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "scenePredictMap :%s", nQQ.toString());
            AppMethodBeat.o(48500);
        } catch (JSONException e2) {
            Log.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "generateScenePredictMap json exception:%s", e2);
            nQQ.clear();
            nQQ = null;
            AppMethodBeat.o(48500);
        }
    }

    public static Map<Integer, Float> ew(int i2, int i3) {
        AppMethodBeat.i(48501);
        if (nQQ == null || nQQ.size() <= 0) {
            Log.e("MicroMsg.Predownload.AppBrandPreloadPredictLevel", "getScenePredictRate map null!");
            AppMethodBeat.o(48501);
            return null;
        }
        LinkedList<Map<Integer, Map<Integer, Float>>> linkedList = nQQ.get(Integer.valueOf(i2));
        if (linkedList.size() > 0) {
            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                Map<Integer, Map<Integer, Float>> map = linkedList.get(i4);
                if (map.containsKey(Integer.valueOf(i3))) {
                    Map<Integer, Float> map2 = map.get(Integer.valueOf(i3));
                    AppMethodBeat.o(48501);
                    return map2;
                }
            }
        }
        AppMethodBeat.o(48501);
        return null;
    }
}
