package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.f;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class g {
    static void a(cbo cbo, cbl cbl, bfy bfy, cyl cyl) {
        AppMethodBeat.i(177399);
        if (!a.cNo() || b.getUin() == 0) {
            Log.e("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, report: fetchHellhoundConfig FALSE !!");
            AppMethodBeat.o(177399);
            return;
        }
        List<c<String, String>> a2 = a(cbo, cbl, cyl);
        if (a2 == null) {
            Log.e("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, _reportSessionPage: logIdJsonList == null !!");
        } else {
            ds(a2);
        }
        ds(b.a(cbo, bfy));
        AppMethodBeat.o(177399);
    }

    private static List<c<String, String>> a(cbo cbo, cbl cbl, cyl cyl) {
        JSONObject j2;
        AppMethodBeat.i(177400);
        Map<String, List<cbm>> d2 = j.d(cbl);
        Map<Long, List<dvi>> a2 = i.a(d2, cyl);
        i.ag(a2);
        if (d2.isEmpty() || a2.isEmpty()) {
            Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, toJson, PageFlowMap Empty: %d", Integer.valueOf(a2.size()));
            AppMethodBeat.o(177400);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, List<dvi>> entry : a2.entrySet()) {
            List<dvi> value = entry.getValue();
            if (!value.isEmpty()) {
                dvi dvi = value.get(0);
                if (dvi.vtY && (j2 = i.j(cbo)) != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (dvi dvi2 : value) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pagePathId", dvi2.LPN);
                            jSONObject.put("sessionId", dvi2.dRM);
                            String a3 = a(cbo, dvi2.dRM);
                            if (a3 == null) {
                                a3 = "";
                            }
                            jSONObject.put("lastSessionId", a3);
                            jSONObject.put("pagePath", a(dvi2.MWp, jSONObject, dvi2.LPN));
                            jSONArray.put(jSONObject);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", e2, "toJson, crash-1: %s", e2.getMessage());
                        }
                    }
                    if (jSONArray.length() > 0) {
                        try {
                            j2.put("content", jSONArray);
                            if (!TextUtils.isEmpty(dvi.LPM)) {
                                Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, sidJSONObject: %s", j2.toString());
                                arrayList.add(com.tencent.mm.vending.j.a.Q(dvi.LPM, j2.toString()));
                            }
                        } catch (Exception e3) {
                            Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", e3, "createJSONObjectHead, crash-2: %s", e3.getMessage());
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(177400);
        return arrayList;
    }

    static String a(cbo cbo, String str) {
        AppMethodBeat.i(220582);
        Iterator<cyl> it = cbo.Mhr.iterator();
        while (it.hasNext()) {
            cyl next = it.next();
            if (next != null && next.sessionId.equals(str)) {
                String aqz = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqz(next.kvy);
                AppMethodBeat.o(220582);
                return aqz;
            }
        }
        Iterator<cyh> it2 = cbo.Mht.iterator();
        while (it2.hasNext()) {
            cyh next2 = it2.next();
            if (next2 != null && (next2.dRM.equals(str) || (next2.dMl + "_" + next2.startTime).equals(str))) {
                String aqz2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqz(next2.kvy);
                AppMethodBeat.o(220582);
                return aqz2;
            }
        }
        AppMethodBeat.o(220582);
        return null;
    }

    private static JSONArray a(List<cbm> list, JSONObject jSONObject, long j2) {
        AppMethodBeat.i(220583);
        JSONArray jSONArray = new JSONArray();
        long j3 = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                cbm cbm = list.get(i2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pageName", cbm.dMl);
                jSONObject2.put("tbe", cbm.startTime);
                long max = Math.max(cbm.duration, 0L);
                jSONObject2.put(LocaleUtil.INDONESIAN_NEWNAME, max);
                j3 += max;
                if (i2 == 0) {
                    jSONObject.put("tbe", cbm.startTime);
                }
                j.a(jSONObject2, cbm, false, j2);
                j.a(jSONObject2, cbm, j2);
                jSONArray.put(jSONObject2);
            } catch (JSONException e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", e2, "createPagePathJsonArray json crash", new Object[0]);
            }
        }
        jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, Math.max(j3, 0L));
        AppMethodBeat.o(220583);
        return jSONArray;
    }

    private static void ds(List<c<String, String>> list) {
        AppMethodBeat.i(122238);
        if (dt(h(list, f.cQu()))) {
            f.Dv(System.currentTimeMillis());
        }
        AppMethodBeat.o(122238);
    }

    private static List<c<String, String>> h(List<c<String, String>> list, String str) {
        Exception e2;
        AppMethodBeat.i(184380);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(184380);
            return list;
        }
        try {
            String[] split = str.split("\\|");
            if (split.length <= 0) {
                AppMethodBeat.o(184380);
                return list;
            } else if (split.length == 1) {
                String[] split2 = split[0].split("-");
                if (split2.length == 2) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(com.tencent.mm.vending.j.a.Q(split2[0], split2[1]));
                }
                AppMethodBeat.o(184380);
                return list;
            } else {
                ArrayList arrayList = list;
                for (String str2 : split) {
                    try {
                        if (str2 != null) {
                            String[] split3 = str2.split("-");
                            if (split3.length == 2) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(com.tencent.mm.vending.j.a.Q(split3[0], split3[1]));
                            }
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        list = arrayList;
                        Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", e2, "restoreSessionMap crash: %s", e2.getMessage());
                        AppMethodBeat.o(184380);
                        return list;
                    }
                }
                AppMethodBeat.o(184380);
                return arrayList;
            }
        } catch (Exception e4) {
            e2 = e4;
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", e2, "restoreSessionMap crash: %s", e2.getMessage());
            AppMethodBeat.o(184380);
            return list;
        }
    }

    private static boolean dt(List<c<String, String>> list) {
        AppMethodBeat.i(169361);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(169361);
            return false;
        }
        boolean z = false;
        for (c<String, String> cVar : list) {
            String str = (String) cVar.get(1);
            if (str != null) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("content");
                    if (optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null && optJSONObject.optLong("pagePathId", 0) == 1179880) {
                                e.INSTANCE.a(19354, 9);
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", e2, "realReportFlow, crash: %s", e2.getMessage());
                }
            }
            gy(str, (String) cVar.get(0));
            d.aV(Util.getInt((String) cVar.get(0), -1), str);
            for (c<String, String> cVar2 : list) {
                com.tencent.mm.plugin.expt.d.d.a aVar = com.tencent.mm.plugin.expt.d.a.cMI().sxs;
                String str2 = (String) cVar2.get(1);
                int parseInt = Integer.parseInt((String) cVar2.get(0));
                if (com.tencent.mm.plugin.expt.d.b.cML()) {
                    if (parseInt <= 0 || org.apache.commons.b.g.eP(str2)) {
                        Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
                    } else {
                        aVar.sxy.execute(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e5: INVOKE  
                              (wrap: java.util.concurrent.ThreadPoolExecutor : 0x00de: IGET  (r0v18 java.util.concurrent.ThreadPoolExecutor) = (r2v3 'aVar' com.tencent.mm.plugin.expt.d.d.a) com.tencent.mm.plugin.expt.d.d.a.sxy java.util.concurrent.ThreadPoolExecutor)
                              (wrap: com.tencent.mm.plugin.expt.d.d.a$5 : 0x00e2: CONSTRUCTOR  (r1v5 com.tencent.mm.plugin.expt.d.d.a$5) = 
                              (r2v3 'aVar' com.tencent.mm.plugin.expt.d.d.a)
                              (r3v0 'parseInt' int)
                              (wrap: long : 0x00da: INVOKE  (r4v0 long) =  type: STATIC call: java.lang.System.currentTimeMillis():long)
                              (r6v1 'str2' java.lang.String)
                             call: com.tencent.mm.plugin.expt.d.d.a.5.<init>(com.tencent.mm.plugin.expt.d.d.a, int, long, java.lang.String):void type: CONSTRUCTOR)
                             type: VIRTUAL call: java.util.concurrent.ThreadPoolExecutor.execute(java.lang.Runnable):void in method: com.tencent.mm.plugin.expt.hellhound.a.f.f.g.dt(java.util.List<com.tencent.mm.vending.j.c<java.lang.String, java.lang.String>>):boolean, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e2: CONSTRUCTOR  (r1v5 com.tencent.mm.plugin.expt.d.d.a$5) = 
                              (r2v3 'aVar' com.tencent.mm.plugin.expt.d.d.a)
                              (r3v0 'parseInt' int)
                              (wrap: long : 0x00da: INVOKE  (r4v0 long) =  type: STATIC call: java.lang.System.currentTimeMillis():long)
                              (r6v1 'str2' java.lang.String)
                             call: com.tencent.mm.plugin.expt.d.d.a.5.<init>(com.tencent.mm.plugin.expt.d.d.a, int, long, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.expt.hellhound.a.f.f.g.dt(java.util.List<com.tencent.mm.vending.j.c<java.lang.String, java.lang.String>>):boolean, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 38 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.expt.d.d.a, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 44 more
                            */
                        /*
                        // Method dump skipped, instructions count: 241
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.f.f.g.dt(java.util.List):boolean");
                    }

                    private static void gy(String str, String str2) {
                        AppMethodBeat.i(220584);
                        if (str == null) {
                            AppMethodBeat.o(220584);
                            return;
                        }
                        int length = str.length();
                        if (length >= 1900) {
                            int i2 = length / 1900;
                            int i3 = length % 1900;
                            for (int i4 = 0; i4 < i2; i4++) {
                                Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item-%d: %s, %s", Integer.valueOf(i4), str2, str.substring(i4 * 1900, (i4 * 1900) + 1900));
                            }
                            if (i3 > 0) {
                                Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item-left: %s, %s", str2, str.substring(i2 * 1900));
                            }
                            AppMethodBeat.o(220584);
                            return;
                        }
                        Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item: %s, %s", str2, str);
                        AppMethodBeat.o(220584);
                    }
                }
