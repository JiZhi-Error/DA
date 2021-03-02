package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.g;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class h {
    private static String b(cbo cbo, cbl cbl, cyl cyl) {
        String aqn;
        List arrayList;
        AppMethodBeat.i(177402);
        Map<String, List<cbm>> d2 = j.d(cbl);
        Map<Long, List<dvi>> a2 = i.a(d2, cyl);
        i.ag(a2);
        if (d2.isEmpty() || a2.isEmpty()) {
            Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, toJson, PageFlowMap Empty !!");
            AppMethodBeat.o(177402);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<Long, List<dvi>> entry : a2.entrySet()) {
            List<dvi> value = entry.getValue();
            if (!value.isEmpty()) {
                for (dvi dvi : value) {
                    if (!(dvi == null || (aqn = b.aqn(dvi.dRM)) == null)) {
                        if (hashMap.containsKey(aqn)) {
                            arrayList = (List) hashMap.get(aqn);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(dvi);
                        hashMap.put(aqn, arrayList);
                    }
                }
            }
        }
        if (hashMap.isEmpty()) {
            AppMethodBeat.o(177402);
            return null;
        }
        JSONObject j2 = i.j(cbo);
        if (j2 == null) {
            AppMethodBeat.o(177402);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry2 : hashMap.entrySet()) {
            String str = (String) entry2.getKey();
            HashMap hashMap2 = new HashMap();
            for (dvi dvi2 : (List) entry2.getValue()) {
                if (hashMap2.containsKey(Long.valueOf(dvi2.LPN))) {
                    c cVar = (c) hashMap2.get(Long.valueOf(dvi2.LPN));
                    if (cVar != null) {
                        long j3 = 0;
                        Iterator<cbm> it = dvi2.MWp.iterator();
                        while (it.hasNext()) {
                            j3 += it.next().duration;
                        }
                        hashMap2.put(Long.valueOf(dvi2.LPN), a.Q(Integer.valueOf(((Integer) cVar.get(0)).intValue() + 1), Long.valueOf(((Long) cVar.get(1)).longValue() + j3)));
                    }
                } else {
                    long j4 = 0;
                    Iterator<cbm> it2 = dvi2.MWp.iterator();
                    while (it2.hasNext()) {
                        j4 += it2.next().duration;
                    }
                    hashMap2.put(Long.valueOf(dvi2.LPN), a.Q(1, Long.valueOf(j4)));
                }
            }
            Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, sid: %s, ppidInfoMap: %d", str, Integer.valueOf(hashMap2.size()));
            for (Map.Entry entry3 : hashMap2.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sid", str);
                    jSONObject.put("pagePathId", entry3.getKey());
                    jSONObject.put("count", ((c) entry3.getValue()).get(0));
                    jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, ((c) entry3.getValue()).get(1));
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", e2, "SessionPageMerge, jsonObject: %s", e2.getMessage());
                }
            }
        }
        if (jSONArray.length() <= 0) {
            Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "HellSessionPageMergeReport, content is NULL !!!");
            AppMethodBeat.o(177402);
            return null;
        }
        try {
            j2.put("content", jSONArray);
            String jSONObject2 = j2.toString();
            AppMethodBeat.o(177402);
            return jSONObject2;
        } catch (JSONException e3) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", e3, "SessionPageMerge, jsonObject, crash: %s", e3.getMessage());
            AppMethodBeat.o(177402);
            return null;
        }
    }

    private static void aqX(String str) {
        AppMethodBeat.i(122244);
        String cQw = g.cQw();
        if (cQw != null && !cQw.isEmpty()) {
            if (str == null || str.isEmpty()) {
                str = cQw;
            } else {
                str = cQw + "|" + str;
            }
        }
        aqY(str);
        g.Dw(System.currentTimeMillis());
        AppMethodBeat.o(122244);
    }

    @SuppressLint({"NewApi"})
    private static void aqY(String str) {
        AppMethodBeat.i(122245);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(122245);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "FuzzyMergeReport, reportSessionPageMerge: %s", str);
        d.aV(17647, str);
        com.tencent.mm.plugin.expt.d.a.cMI().sxs.aoo(str);
        AppMethodBeat.o(122245);
    }

    static void a(cbo cbo, cbl cbl, bfy bfy, cyl cyl) {
        AppMethodBeat.i(177401);
        aqX(b(cbo, cbl, cyl));
        if (bfy == null || bfy.LPC.isEmpty()) {
            AppMethodBeat.o(177401);
            return;
        }
        aqX(c.b(cbo, bfy));
        AppMethodBeat.o(177401);
    }
}
