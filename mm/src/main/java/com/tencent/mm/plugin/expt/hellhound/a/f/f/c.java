package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class c {
    static String b(cbo cbo, bfy bfy) {
        List arrayList;
        AppMethodBeat.i(122221);
        HashMap hashMap = new HashMap();
        Iterator<bgb> it = bfy.LPC.iterator();
        while (it.hasNext()) {
            bgb next = it.next();
            String aqn = b.aqn(next.dRM);
            if (aqn != null) {
                if (hashMap.containsKey(aqn)) {
                    arrayList = (List) hashMap.get(aqn);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                } else {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
                hashMap.put(aqn, arrayList);
            }
        }
        Log.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyPageMerge, sidPathsMap: %d", Integer.valueOf(hashMap.size()));
        if (hashMap.isEmpty()) {
            AppMethodBeat.o(122221);
            return null;
        }
        JSONObject j2 = i.j(cbo);
        if (j2 == null) {
            AppMethodBeat.o(122221);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            HashMap hashMap2 = new HashMap();
            for (bgb bgb : (List) entry.getValue()) {
                if (hashMap2.containsKey(Long.valueOf(bgb.LPN))) {
                    com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) hashMap2.get(Long.valueOf(bgb.LPN));
                    if (cVar != null) {
                        long j3 = 0;
                        Iterator<bga> it2 = bgb.LPK.iterator();
                        while (it2.hasNext()) {
                            j3 += it2.next().LPF;
                        }
                        hashMap2.put(Long.valueOf(bgb.LPN), a.Q(Integer.valueOf(((Integer) cVar.get(0)).intValue() + 1), Long.valueOf(((Long) cVar.get(1)).longValue() + j3)));
                    }
                } else {
                    long j4 = 0;
                    Iterator<bga> it3 = bgb.LPK.iterator();
                    while (it3.hasNext()) {
                        j4 += it3.next().LPF;
                    }
                    hashMap2.put(Long.valueOf(bgb.LPN), a.Q(1, Long.valueOf(j4)));
                }
            }
            Log.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyPageMerge, sid: %s, ppidInfoMap: %d", str, Integer.valueOf(hashMap2.size()));
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sid", str);
                    jSONObject.put("pagePathId", entry2.getKey());
                    jSONObject.put("count", ((com.tencent.mm.vending.j.c) entry2.getValue()).get(0));
                    jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, ((com.tencent.mm.vending.j.c) entry2.getValue()).get(1));
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("HABBYGE-MALI.FuzzyMergeReport", e2, "FuzzyPageMerge, jsonObject: %s", e2.getMessage());
                }
            }
        }
        if (jSONArray.length() <= 0) {
            Log.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyMergeReport, content is NULL !!!");
            AppMethodBeat.o(122221);
            return null;
        }
        try {
            j2.put("content", jSONArray);
            String jSONObject2 = j2.toString();
            AppMethodBeat.o(122221);
            return jSONObject2;
        } catch (JSONException e3) {
            Log.printErrStackTrace("HABBYGE-MALI.FuzzyMergeReport", e3, "SessionPageMerge, content: %s", e3.getMessage());
            AppMethodBeat.o(122221);
            return null;
        }
    }
}
