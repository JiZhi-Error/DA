package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
    public static void d(cbo cbo, cbl cbl, cyl cyl) {
        AppMethodBeat.i(177407);
        Log.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, realReport");
        k.a(cbo, cbl);
        k(cbo);
        e(cbo, cbl, cyl);
        a.f(cbo);
        AppMethodBeat.o(177407);
    }

    private static void k(cbo cbo) {
        AppMethodBeat.i(122251);
        c.cQa();
        if (c.cQd()) {
            Log.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, reportSession Detail true");
            e.f(cbo);
        }
        f.f(cbo);
        AppMethodBeat.o(122251);
    }

    private static void e(cbo cbo, cbl cbl, cyl cyl) {
        AppMethodBeat.i(177408);
        a aVar = a.sHW;
        bfy cPB = a.cPB();
        g.a(cbo, cbl, cPB, cyl);
        h.a(cbo, e(cbl), cPB, cyl);
        k.cQC();
        a aVar2 = a.sHW;
        a.cPA();
        AppMethodBeat.o(177408);
    }

    public static void a(cbl cbl, cbo cbo, boolean z) {
        cbm last;
        long j2;
        cbm first;
        int i2 = 0;
        long j3 = 0;
        AppMethodBeat.i(122253);
        Collections.sort(cbl.Mhn, new Comparator<cbm>() {
            /* class com.tencent.mm.plugin.expt.hellhound.a.f.f.j.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(cbm cbm, cbm cbm2) {
                AppMethodBeat.i(122249);
                int compare = Long.compare(cbm.startTime, cbm2.startTime);
                AppMethodBeat.o(122249);
                return compare;
            }
        });
        Map<String, List<cbm>> c2 = c(cbl);
        Iterator<cyl> it = cbo.Mhr.iterator();
        while (it.hasNext()) {
            cyl next = it.next();
            List<cbm> list = c2.get(next.sessionId);
            if (list != null && !list.isEmpty()) {
                list.get(0).startTime = next.startTime;
            }
        }
        Iterator<cyh> it2 = cbo.Mht.iterator();
        while (it2.hasNext()) {
            cyh next2 = it2.next();
            List<cbm> list2 = c2.get(next2.dMl + "_" + next2.startTime);
            if (list2 != null && !list2.isEmpty()) {
                list2.get(0).startTime = next2.startTime;
            }
        }
        int size = cbl.Mhn.size();
        if (size > 0 && (first = cbl.Mhn.getFirst()) != null) {
            first.startTime = cbo.Mhp;
        }
        for (int i3 = 0; i3 < size; i3++) {
            cbm cbm = cbl.Mhn.get(i3);
            if (cbm != null) {
                if (i3 + 1 >= size) {
                    break;
                }
                cbm cbm2 = cbl.Mhn.get(i3 + 1);
                if (cbm2 != null && cbm.duration == 0) {
                    long j4 = cbm2.startTime - cbm.startTime;
                    if (j4 <= 0) {
                        j4 = 0;
                    }
                    cbm.duration = j4;
                }
            }
        }
        if (z) {
            long j5 = 0;
            while (i2 < size) {
                cbm cbm3 = cbl.Mhn.get(i2);
                if (cbm3 == null || cbm3.duration <= 0) {
                    j2 = j5;
                } else {
                    j2 = cbm3.duration + j5;
                }
                i2++;
                j5 = j2;
            }
            cbo.Mhq = cbo.Mhp + j5;
            AppMethodBeat.o(122253);
            return;
        }
        if (size > 0 && (last = cbl.Mhn.getLast()) != null) {
            long j6 = cbo.Mhq - last.startTime;
            if (j6 > 0) {
                j3 = j6;
            }
            last.duration = j3;
        }
        AppMethodBeat.o(122253);
    }

    static Map<String, List<cbm>> c(cbl cbl) {
        List arrayList;
        AppMethodBeat.i(122254);
        HashMap hashMap = new HashMap();
        Iterator<cbm> it = cbl.Mhn.iterator();
        while (it.hasNext()) {
            cbm next = it.next();
            if (next != null) {
                if (next.dRM == null || next.dRM.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(next);
                    hashMap.put(next.dMl + "_" + next.startTime, arrayList2);
                } else {
                    if (hashMap.containsKey(next.dRM)) {
                        arrayList = (List) hashMap.get(next.dRM);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                    } else {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    hashMap.put(next.dRM, arrayList);
                }
            }
        }
        AppMethodBeat.o(122254);
        return hashMap;
    }

    static Map<String, List<cbm>> d(cbl cbl) {
        List arrayList;
        AppMethodBeat.i(122255);
        HashMap hashMap = new HashMap();
        Iterator<cbm> it = cbl.Mhn.iterator();
        while (it.hasNext()) {
            cbm next = it.next();
            if (next != null) {
                if (next.dRM != null && !next.dRM.isEmpty()) {
                    if (hashMap.containsKey(next.dRM)) {
                        arrayList = (List) hashMap.get(next.dRM);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                    } else {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    hashMap.put(next.dRM, arrayList);
                } else if (!hashMap.containsKey(next.dMl)) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(next);
                    hashMap.put(next.dMl, arrayList2);
                }
            }
        }
        AppMethodBeat.o(122255);
        return hashMap;
    }

    public static void a(cbo cbo, cbm cbm) {
        AppMethodBeat.i(122256);
        Log.i("HABBYGE-MALI.HellSessionReportUtil", "adjustSession");
        cyl cyl = null;
        Iterator<cyl> it = cbo.Mhr.iterator();
        cyl cyl2 = null;
        while (it.hasNext()) {
            cyl next = it.next();
            if (next != null) {
                if (cyl == null) {
                    cyl2 = next;
                    cyl = next;
                } else {
                    if (next.startTime < cyl.startTime) {
                        cyl = next;
                    }
                    if (next.endTime <= cyl2.endTime) {
                        next = cyl2;
                    }
                    cyl2 = next;
                }
            }
        }
        cyh cyh = null;
        Iterator<cyh> it2 = cbo.Mht.iterator();
        cyh cyh2 = null;
        while (it2.hasNext()) {
            cyh next2 = it2.next();
            if (next2 != null) {
                if (cyh == null) {
                    cyh2 = next2;
                    cyh = next2;
                } else {
                    if (next2.startTime < cyh.startTime) {
                        cyh = next2;
                    }
                    if (next2.endTime <= cyh2.endTime) {
                        next2 = cyh2;
                    }
                    cyh2 = next2;
                }
            }
        }
        if (cyl == null) {
            if (cyh == null) {
                AppMethodBeat.o(122256);
                return;
            }
            boolean z = false;
            if (cyh.dMl.equals(cbm.dMl) && cyh.startTime == cbm.startTime) {
                z = true;
            }
            cyh.startTime = cbo.Mhp;
            if (z) {
                Log.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
                cbm.startTime = cyh.startTime;
            } else {
                Log.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
            }
        } else if (cyh == null || cyh.startTime >= cyl.startTime) {
            cyl.startTime = cbo.Mhp;
        } else {
            boolean z2 = false;
            if (cyh.dMl.equals(cbm.dMl) && cyh.startTime == cbm.startTime) {
                z2 = true;
            }
            cyh.startTime = cbo.Mhp;
            if (z2) {
                Log.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
                cbm.startTime = cyh.startTime;
            } else {
                Log.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
            }
        }
        if (cyl2 == null) {
            if (cyh2 != null) {
                cyh2.endTime = cbo.Mhq;
                AppMethodBeat.o(122256);
                return;
            }
        } else if (cyh2 == null || cyh2.endTime <= cyl2.endTime) {
            cyl2.endTime = cbo.Mhq;
        } else {
            cyh2.endTime = cbo.Mhq;
            AppMethodBeat.o(122256);
            return;
        }
        AppMethodBeat.o(122256);
    }

    private static cbl e(cbl cbl) {
        AppMethodBeat.i(122257);
        cbl cbl2 = new cbl();
        Iterator<cbm> it = cbl.Mhn.iterator();
        while (it.hasNext()) {
            cbm next = it.next();
            cbm cbm = new cbm();
            cbm.dRM = next.dRM;
            cbm.dMl = next.dMl;
            cbm.aHK = next.aHK;
            cbm.startTime = next.startTime;
            cbm.duration = next.duration;
            cbm.count = next.count;
            cbl2.Mhn.add(cbm);
        }
        AppMethodBeat.o(122257);
        return cbl2;
    }

    static void a(JSONArray jSONArray, bga bga, long j2) {
        String str;
        int i2;
        String s;
        AppMethodBeat.i(220587);
        ArrayList arrayList = new ArrayList();
        Iterator<cbn> it = bga.LPG.iterator();
        while (it.hasNext()) {
            cbn next = it.next();
            if (next != null && !TextUtils.isEmpty(next.businessId)) {
                arrayList.add(next.businessId);
            }
        }
        try {
            Iterator<cbn> it2 = bga.LPG.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                cbn next2 = it2.next();
                if (next2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dataPath", next2.dataPath == null ? "" : next2.dataPath);
                    jSONObject.put("value", next2.value == null ? "" : next2.value);
                    if (TextUtils.isEmpty(next2.businessId)) {
                        while (true) {
                            i2 = i3 + 1;
                            s = b.s(bga.startTime, i2);
                            if (!arrayList.contains(s)) {
                                break;
                            }
                            i3 = i2;
                        }
                        arrayList.add(s);
                        str = s;
                    } else {
                        str = next2.businessId;
                        i2 = i3;
                    }
                    jSONObject.put("businessId", str);
                    Log.i("HABBYGE-MALI.HellSessionReportUtil", "handleSessionPageDetailParams, bizId, %s", str);
                    jSONArray.put(jSONObject);
                    i3 = i2;
                }
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportUtil", e2, "handleFuzzyPathDetailParams: %s", e2.getMessage());
        }
        l.t(j2, jSONArray.length() > 0 ? 0 : 1);
        AppMethodBeat.o(220587);
    }

    static void a(JSONObject jSONObject, cbm cbm, long j2) {
        AppMethodBeat.i(220588);
        if (cbm.LPH.isEmpty()) {
            ar(cbm.dMl, j2);
            AppMethodBeat.o(220588);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<erd> it = cbm.LPH.iterator();
        while (it.hasNext()) {
            erd next = it.next();
            if (next != null && !next.NoQ) {
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
                        if (next2 != null && next2.KVX == j2) {
                            Iterator<cbn> it3 = next2.KVY.iterator();
                            while (it3.hasNext()) {
                                cbn next3 = it3.next();
                                if (!(next3 == null || next3.dataPath == null || !a(j2, next3.dataPath, next))) {
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
                        l.t(j2, 4);
                    } else {
                        l.t(j2, 5);
                    }
                } else {
                    i(next.NoL, cbm.dMl, j2);
                }
                jSONArray.put(jSONObject2);
            }
        }
        l.t(j2, jSONArray.length() > 0 ? 2 : 3);
        jSONObject.put("viewOp", jSONArray);
        AppMethodBeat.o(220588);
    }

    private static boolean a(long j2, String str, erd erd) {
        AppMethodBeat.i(220589);
        Iterator<cgd> it = erd.NoP.iterator();
        boolean z = false;
        while (it.hasNext()) {
            cgd next = it.next();
            if (next != null && next.KVX == j2) {
                Iterator<String> it2 = next.MlP.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String next2 = it2.next();
                    if (!TextUtils.isEmpty(next2) && next2.equals(str)) {
                        z = true;
                        break;
                    }
                }
            }
        }
        AppMethodBeat.o(220589);
        return z;
    }

    static void a(JSONObject jSONObject, cbm cbm, boolean z, long j2) {
        LinkedList<cbn> linkedList;
        String str;
        AppMethodBeat.i(220590);
        if (z) {
            linkedList = cbm.Mho;
        } else {
            linkedList = cbm.LPG;
        }
        JSONArray jSONArray = new JSONArray();
        if (linkedList.isEmpty()) {
            jSONObject.put("businessParam", jSONArray);
            d(cbm.dMl, z, j2);
            AppMethodBeat.o(220590);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (cbn cbn : linkedList) {
            if (cbn != null && !TextUtils.isEmpty(cbn.businessId)) {
                arrayList.add(cbn.businessId);
            }
        }
        int i2 = 0;
        for (cbn cbn2 : linkedList) {
            if (cbn2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dataPath", cbn2.dataPath == null ? "" : cbn2.dataPath);
                jSONObject2.put("value", cbn2.value == null ? "" : cbn2.value);
                if (TextUtils.isEmpty(cbn2.businessId)) {
                    int i3 = i2;
                    do {
                        i3++;
                        str = b.s(cbm.startTime, i3);
                    } while (arrayList.contains(str));
                    arrayList.add(str);
                    i2 = i3;
                } else {
                    str = cbn2.businessId;
                }
                jSONObject2.put("businessId", str);
                Log.i("HABBYGE-MALI.HellSessionReportUtil", "handleSessionPageDetailParams, bizId, %s", str);
                jSONArray.put(jSONObject2);
            }
        }
        if (!z) {
            l.t(j2, jSONArray.length() > 0 ? 0 : 1);
        }
        jSONObject.put("businessParam", jSONArray);
        AppMethodBeat.o(220590);
    }

    static void ar(String str, long j2) {
        boolean z;
        AppMethodBeat.i(220591);
        d.cQe();
        dvk Du = d.Du(j2);
        if (Du != null) {
            Iterator<dvg> it = Du.MWr.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                dvg next = it.next();
                if (next != null) {
                    if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(next.dMl))) {
                        z = !next.MWm.isEmpty();
                        if (!z) {
                            break;
                        }
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
            if (z) {
                l.t(j2, 3);
            }
        }
        AppMethodBeat.o(220591);
    }

    static void i(String str, String str2, long j2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(220592);
        d.cQe();
        dvk Du = d.Du(j2);
        if (Du != null) {
            Iterator<dvg> it = Du.MWr.iterator();
            boolean z3 = false;
            while (true) {
                if (!it.hasNext()) {
                    z = z3;
                    break;
                }
                dvg next = it.next();
                if (next != null) {
                    if (str2.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(next.dMl))) {
                        Iterator<ere> it2 = next.MWm.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = z3;
                                z2 = false;
                                break;
                            }
                            ere next2 = it2.next();
                            if (next2 != null && str.equals(next2.NoL)) {
                                z = !next2.MWl.isEmpty();
                                z2 = true;
                            }
                        }
                        if (z2) {
                            break;
                        }
                    } else {
                        z = z3;
                    }
                    z3 = z;
                }
            }
            if (z) {
                l.t(j2, 5);
            }
        }
        AppMethodBeat.o(220592);
    }

    static void d(String str, boolean z, long j2) {
        boolean z2;
        AppMethodBeat.i(220593);
        if (z) {
            AppMethodBeat.o(220593);
            return;
        }
        d.cQe();
        dvk Du = d.Du(j2);
        if (Du != null) {
            Iterator<dvg> it = Du.MWr.iterator();
            boolean z3 = false;
            while (true) {
                if (!it.hasNext()) {
                    z2 = z3;
                    break;
                }
                dvg next = it.next();
                if (next != null) {
                    if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(next.dMl))) {
                        z2 = !next.MWl.isEmpty();
                        if (!z2) {
                            break;
                        }
                    } else {
                        z2 = z3;
                    }
                    z3 = z2;
                }
            }
            if (z2) {
                l.t(j2, 1);
            }
        }
        AppMethodBeat.o(220593);
    }
}
