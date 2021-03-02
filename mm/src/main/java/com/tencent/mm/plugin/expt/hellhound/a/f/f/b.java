package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.pd;
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
public final class b {
    static List<c<String, String>> a(cbo cbo, bfy bfy) {
        JSONObject j2;
        List arrayList;
        AppMethodBeat.i(122218);
        if (bfy == null || bfy.LPC.isEmpty()) {
            Log.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: cache == null");
            AppMethodBeat.o(122218);
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<bgb> it = bfy.LPC.iterator();
        while (it.hasNext()) {
            bgb next = it.next();
            if (hashMap.containsKey(Long.valueOf(next.LPN))) {
                arrayList = (List) hashMap.get(Long.valueOf(next.LPN));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
            } else {
                arrayList = new ArrayList();
            }
            arrayList.add(next);
            hashMap.put(Long.valueOf(next.LPN), arrayList);
        }
        if (hashMap.isEmpty()) {
            Log.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: ppidPathsMap == null");
            AppMethodBeat.o(122218);
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            List list = (List) entry.getValue();
            if (list != null && !list.isEmpty()) {
                bgb bgb = (bgb) list.get(0);
                if (bgb.vtY && (j2 = i.j(cbo)) != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        bgb bgb2 = (bgb) list.get(i2);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pagePathId", bgb2.LPN);
                            jSONObject.put("sessionId", bgb2.dRM);
                            String a2 = g.a(cbo, bgb2.dRM);
                            if (a2 == null) {
                                a2 = "";
                            }
                            jSONObject.put("lastSessionId", a2);
                            jSONObject.put("pagePath", a(bgb2, jSONObject));
                            jSONArray.put(jSONObject);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", e2, "toJson, crash-FuzzyPath-1: %s", e2.getMessage());
                        }
                    }
                    if (jSONArray.length() <= 0) {
                        Log.e("HABBYGE-MALI.FuzzyDetailReport", "content is NULL !!");
                    } else {
                        try {
                            j2.put("content", jSONArray);
                            arrayList2.add(a.Q(bgb.LPM, j2.toString()));
                        } catch (JSONException e3) {
                            Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", e3, "toJson, crash-FuzzyPath-2: %s", e3.getMessage());
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(122218);
        return arrayList2;
    }

    private static JSONArray a(bgb bgb, JSONObject jSONObject) {
        String str;
        AppMethodBeat.i(169359);
        JSONArray jSONArray = new JSONArray();
        if (bgb == null || bgb.LPK.isEmpty()) {
            AppMethodBeat.o(169359);
            return jSONArray;
        }
        int size = bgb.LPK.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            try {
                bga bga = bgb.LPK.get(i2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pageName", bga.name);
                jSONObject2.put("tbe", bga.startTime);
                jSONObject2.put(LocaleUtil.INDONESIAN_NEWNAME, bga.LPF);
                j2 += bga.LPF;
                if (i2 == 0) {
                    try {
                        jSONObject.put("tbe", bga.startTime);
                    } catch (Exception e2) {
                        Log.printInfoStack("HABBYGE-MALI.FuzzyDetailReport", "createFuzzyPathJsonArray, exception: %s", e2.getMessage());
                    }
                }
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    if (bga == null) {
                        jSONObject2.put("businessParam", jSONArray2);
                    } else {
                        dvg dvg = bgb.LPJ;
                        if (bgb.LPI.isEmpty() || bgb.LPI.size() != 1) {
                            str = null;
                        } else {
                            str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bgb.LPI.get(0).dMl);
                        }
                        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(dvg.dMl);
                        String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bga.name);
                        if (str != null && str.equals(aoE2)) {
                            Log.i("HABBYGE-MALI.FuzzyDetailReport", "sPrePageName: %s, %s", str, aoE2);
                            a(bga, jSONArray2, bgb.LPN);
                        } else if (aoE == null || !aoE.equals(aoE2)) {
                            Log.e("HABBYGE-MALI.FuzzyDetailReport", "Neither prePage nor curPage !!");
                            jSONObject2.put("businessParam", jSONArray2);
                        } else {
                            Log.i("HABBYGE-MALI.FuzzyDetailReport", "sCurPageName: %s, %s", aoE, aoE2);
                            a(bga, jSONArray2, bgb.LPN);
                        }
                        jSONObject2.put("businessParam", jSONArray2);
                    }
                } catch (JSONException e3) {
                    Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", e3, "_getBizParams crash: %s", e3.getMessage());
                }
                a(jSONObject2, bgb, bga);
                jSONArray.put(jSONObject2);
            } catch (JSONException e4) {
                Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", e4, "createFuzzyPathJsonArray crash: %s", e4.getMessage());
            }
        }
        jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j2 > 0 ? j2 : 0);
        AppMethodBeat.o(169359);
        return jSONArray;
    }

    private static void a(JSONObject jSONObject, bgb bgb, bga bga) {
        AppMethodBeat.i(220579);
        JSONArray jSONArray = new JSONArray();
        Iterator<erd> it = bga.LPH.iterator();
        boolean z = false;
        while (it.hasNext()) {
            erd next = it.next();
            if (next != null && a(next, bga, bgb)) {
                z = true;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("viewId", next.NoL);
                jSONObject2.put("type", next.type);
                jSONObject2.put(NativeProtocol.WEB_DIALOG_ACTION, next.eventId);
                jSONObject2.put(AppMeasurement.Param.TIMESTAMP, next.timestamp);
                if (!next.KVY.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<pd> it2 = next.KVY.iterator();
                    while (it2.hasNext()) {
                        pd next2 = it2.next();
                        if (next2 != null && next2.KVX == bgb.LPN) {
                            Iterator<cbn> it3 = next2.KVY.iterator();
                            while (it3.hasNext()) {
                                cbn next3 = it3.next();
                                if (!(next3 == null || next3.dataPath == null)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("dataPath", next3.dataPath);
                                    jSONObject3.put("value", next3.value);
                                    jSONArray2.put(jSONObject3);
                                }
                            }
                        }
                    }
                    if (jSONArray2.length() > 0) {
                        jSONObject2.put("businessParam", jSONArray2);
                        l.t(bgb.LPN, 4);
                    } else {
                        l.t(bgb.LPN, 5);
                    }
                } else {
                    String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bga.name);
                    if (aoE != null) {
                        j.i(next.NoL, aoE, bgb.LPN);
                    }
                }
                jSONArray.put(jSONObject2);
            }
        }
        jSONObject.put("viewOp", jSONArray);
        if (!z) {
            AppMethodBeat.o(220579);
        } else if (bga.LPH.isEmpty()) {
            String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bga.name);
            if (aoE2 != null) {
                j.ar(aoE2, bgb.LPN);
            }
            AppMethodBeat.o(220579);
        } else {
            l.t(bgb.LPN, jSONArray.length() > 0 ? 2 : 3);
            AppMethodBeat.o(220579);
        }
    }

    private static boolean a(erd erd, bga bga, bgb bgb) {
        AppMethodBeat.i(220580);
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bga.name);
        String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bgb.LPJ.dMl);
        if (aoE2 != null && aoE2.equals(aoE)) {
            Iterator<ere> it = bgb.LPJ.MWm.iterator();
            while (it.hasNext()) {
                ere next = it.next();
                if (g.a(erd, next)) {
                    Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: entry: viewNode=%s, %s", next.viewId, next.NoL);
                    AppMethodBeat.o(220580);
                    return true;
                }
            }
        }
        Iterator<dvg> it2 = bgb.LPI.iterator();
        while (it2.hasNext()) {
            dvg next2 = it2.next();
            String aoE3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(next2.dMl);
            if (aoE3 != null && aoE3.equals(aoE)) {
                Iterator<ere> it3 = next2.MWm.iterator();
                while (it3.hasNext()) {
                    ere next3 = it3.next();
                    if (g.a(erd, next3)) {
                        Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: prePage=%s, %s", next3.viewId, next3.NoL);
                        AppMethodBeat.o(220580);
                        return true;
                    }
                }
                continue;
            }
        }
        Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: false: %s, %s", erd.id, erd.NoL);
        AppMethodBeat.o(220580);
        return false;
    }

    private static void a(bga bga, JSONArray jSONArray, long j2) {
        AppMethodBeat.i(220581);
        if (!bga.LPG.isEmpty()) {
            j.a(jSONArray, bga, j2);
            AppMethodBeat.o(220581);
            return;
        }
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bga.name);
        if (aoE != null) {
            j.d(aoE, false, j2);
        }
        AppMethodBeat.o(220581);
    }
}
