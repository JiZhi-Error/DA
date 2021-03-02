package com.tencent.mm.plugin.expt.d.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.h.a.b;
import com.tencent.mm.plugin.expt.d.h.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.g;

public final class a {
    private b syw = new com.tencent.mm.plugin.expt.d.h.a.a();

    public a() {
        AppMethodBeat.i(220354);
        cNa();
        AppMethodBeat.o(220354);
    }

    private void cNa() {
        AppMethodBeat.i(220355);
        ArrayList<com.tencent.mm.plugin.expt.d.h.b.a> arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.plugin.expt.d.h.b.a.a());
        arrayList.add(new c());
        arrayList.add(new com.tencent.mm.plugin.expt.d.h.b.a.b());
        for (com.tencent.mm.plugin.expt.d.h.b.a aVar : arrayList) {
            if (!this.syw.a(aVar)) {
                Log.e("EdgeComputingScriptService", "[EdgeComputingScriptService] registerJsApi fail, jsApi : " + aVar.cNb());
            }
        }
        AppMethodBeat.o(220355);
    }

    public final Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> a(com.tencent.mm.plugin.expt.d.e.a.b bVar, Map<Long, List<String>> map, long j2, long j3) {
        String[] split;
        boolean z;
        AppMethodBeat.i(220356);
        if (bVar == null || map == null || map.size() <= 0) {
            AppMethodBeat.o(220356);
            return null;
        } else if (g.eP(bVar.script) || g.eP(bVar.sys)) {
            AppMethodBeat.o(220356);
            return null;
        } else if (!g.equals(MD5Util.getMD5String(bVar.script), bVar.sys)) {
            AppMethodBeat.o(220356);
            return null;
        } else {
            Log.d("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript configID : " + bVar.syg);
            if (!this.syw.aor(bVar.script)) {
                Log.e("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript loadScript fail!");
                AppMethodBeat.o(220356);
                return null;
            }
            HashMap hashMap = new HashMap();
            for (Long l : map.keySet()) {
                long longValue = l.longValue();
                List<String> list = map.get(Long.valueOf(longValue));
                if (list != null && list.size() > 0) {
                    for (String str : list) {
                        if (!g.eP(str)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("2,");
                            sb.append(new SimpleDateFormat("yyyyMMdd").format(new Date(j2))).append(",");
                            sb.append(j2).append(",");
                            sb.append(j3).append(",");
                            List<String> ab = this.syw.ab("__main__", str, sb.toString());
                            if (ab != null && ab.size() > 0) {
                                for (String str2 : ab) {
                                    if (!g.eP(str2) && (split = str2.split(",")) != null && split.length > 0 && bVar.sym != null && bVar.sym.size() > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        com.tencent.mm.plugin.expt.d.e.b bVar2 = new com.tencent.mm.plugin.expt.d.e.b();
                                        bVar2.index = 0;
                                        bVar2.type = 2;
                                        bVar2.name = "report_time_ec";
                                        bVar2.syi = longValue;
                                        arrayList.add(bVar2);
                                        Iterator<com.tencent.mm.plugin.expt.d.e.a.a> it = bVar.sym.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                z = false;
                                                break;
                                            }
                                            com.tencent.mm.plugin.expt.d.e.a.a next = it.next();
                                            if (next.index > 0 && split.length > next.index - 1) {
                                                com.tencent.mm.plugin.expt.d.e.b bVar3 = new com.tencent.mm.plugin.expt.d.e.b();
                                                bVar3.index = next.index;
                                                bVar3.type = next.type;
                                                bVar3.name = next.name;
                                                try {
                                                    if (next.type != 1) {
                                                        if (next.type != 2) {
                                                            if (next.type != 0) {
                                                                z = true;
                                                                break;
                                                            } else if (g.eP(split[next.index - 1])) {
                                                                bVar3.stringValue = "";
                                                            } else {
                                                                bVar3.stringValue = split[next.index - 1];
                                                            }
                                                        } else if (g.eP(split[next.index - 1])) {
                                                            bVar3.syi = 0;
                                                        } else {
                                                            bVar3.syi = Long.parseLong(split[next.index - 1]);
                                                        }
                                                    } else if (g.eP(split[next.index - 1])) {
                                                        bVar3.intValue = 0;
                                                    } else {
                                                        bVar3.intValue = Integer.parseInt(split[next.index - 1]);
                                                    }
                                                    arrayList.add(bVar3);
                                                } catch (Exception e2) {
                                                    z = true;
                                                }
                                            }
                                        }
                                        Collections.sort(arrayList, new Comparator<com.tencent.mm.plugin.expt.d.e.b>() {
                                            /* class com.tencent.mm.plugin.expt.d.h.a.AnonymousClass1 */

                                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                                            @Override // java.util.Comparator
                                            public final /* bridge */ /* synthetic */ int compare(com.tencent.mm.plugin.expt.d.e.b bVar, com.tencent.mm.plugin.expt.d.e.b bVar2) {
                                                com.tencent.mm.plugin.expt.d.e.b bVar3 = bVar;
                                                com.tencent.mm.plugin.expt.d.e.b bVar4 = bVar2;
                                                if (bVar3.index > bVar4.index) {
                                                    return 1;
                                                }
                                                if (bVar3.index < bVar4.index) {
                                                    return -1;
                                                }
                                                return 0;
                                            }
                                        });
                                        if (!z) {
                                            List list2 = (List) hashMap.get(Long.valueOf(longValue));
                                            if (list2 == null) {
                                                list2 = new ArrayList();
                                                hashMap.put(Long.valueOf(longValue), list2);
                                            }
                                            list2.add(arrayList);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(220356);
            return hashMap;
        }
    }

    public final void release() {
        AppMethodBeat.i(220357);
        if (this.syw == null) {
            AppMethodBeat.o(220357);
            return;
        }
        this.syw.release();
        AppMethodBeat.o(220357);
    }
}
