package com.tencent.mm.plugin.welab.b;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b implements a {
    @Override // com.tencent.mm.plugin.welab.b.a
    public final void g(final List<c> list, final List<d> list2, final List<Integer> list3) {
        AppMethodBeat.i(146248);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.welab.b.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(146247);
                b.h(list, list2, list3);
                AppMethodBeat.o(146247);
            }
        }, "cross_welab");
        AppMethodBeat.o(146248);
    }

    static /* synthetic */ void h(List list, List list2, List list3) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(146249);
        long currentTicks = Util.currentTicks();
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        if (list2 != null && !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.status == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    hashSet.add(dVar.appId);
                } else {
                    if (dVar.status == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        hashSet2.add(dVar.appId);
                    }
                }
            }
        }
        if (list3 != null && !list3.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                a aVar = new a();
                aVar.field_expId = ((Integer) it2.next()).toString();
                com.tencent.mm.plugin.welab.a.gjg().JFR.get(aVar, "expId");
                if (!TextUtils.isEmpty(aVar.field_LabsAppId)) {
                    aVar.field_Switch = 3;
                    aVar.field_endtime = Util.nowSecond() - 1;
                    arrayList.add(aVar);
                    Log.i("MicroMsg.XExptForWelabBridge", "welab app[%s] stop now", aVar);
                    d.f(aVar.field_LabsAppId, aVar.field_expId, 9, false);
                }
            }
            if (!arrayList.isEmpty()) {
                com.tencent.mm.plugin.welab.a.gjg().JFR.ip(arrayList);
            }
        }
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                a a2 = e.a((c) it3.next());
                if (a2.isValid()) {
                    if (!hashMap.containsKey(a2.field_LabsAppId)) {
                        hashMap.put(a2.field_LabsAppId, a2);
                    } else if (Util.getInt(((a) hashMap.get(a2.field_LabsAppId)).field_expId, 0) < Util.getInt(a2.field_expId, 0)) {
                        hashMap.put(a2.field_LabsAppId, a2);
                    }
                    a2.reportIdkey();
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (a aVar2 : hashMap.values()) {
                a bbz = com.tencent.mm.plugin.welab.a.gjg().bbz(aVar2.field_LabsAppId);
                if (bbz.gjp() && Util.getInt(bbz.field_expId, 0) > Util.getInt(aVar2.field_expId, 0)) {
                    Log.w("MicroMsg.XExptForWelabBridge", "it had local welab item, don't update.local[%s] new[%s]", bbz, aVar2);
                } else if (aVar2.gjq()) {
                    com.tencent.mm.plugin.welab.a.gjg().JFR.delete(aVar2, "expId");
                } else {
                    arrayList2.add(aVar2);
                    linkedList.add(aVar2);
                    com.tencent.mm.plugin.welab.e.b.gju().f(aVar2);
                    d.f(aVar2.field_LabsAppId, aVar2.field_expId, 8, com.tencent.mm.plugin.welab.e.b.gju().e(aVar2));
                }
            }
            if (!arrayList2.isEmpty()) {
                com.tencent.mm.plugin.welab.a.gjg().JFR.ip(arrayList2);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.e.d.CTRL_INDEX, 20);
        }
        if (!hashSet.isEmpty() || !hashSet2.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            for (a aVar3 : com.tencent.mm.plugin.welab.a.gjg().JFR.gjn()) {
                if (aVar3 != null && aVar3.isValid() && aVar3.gjp()) {
                    if (hashSet.contains(aVar3.field_LabsAppId) && aVar3.field_Switch == 1) {
                        aVar3.field_Switch = 2;
                        arrayList3.add(aVar3);
                    }
                    if (hashSet2.contains(aVar3.field_LabsAppId) && aVar3.field_Switch == 2) {
                        aVar3.field_Switch = 1;
                        arrayList3.add(aVar3);
                    }
                }
            }
            if (!arrayList3.isEmpty()) {
                com.tencent.mm.plugin.welab.a.gjg().JFR.ip(arrayList3);
            }
        }
        com.tencent.mm.plugin.welab.a.gjg();
        com.tencent.mm.plugin.welab.a.io(linkedList);
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(list != null ? list.size() : 0);
        objArr[1] = Integer.valueOf(list3 != null ? list3.size() : 0);
        objArr[2] = Long.valueOf(Util.ticksToNow(currentTicks));
        objArr[3] = hashSet;
        objArr[4] = hashSet2;
        Log.i("MicroMsg.XExptForWelabBridge", "itemList [%d] delList[%d] cost[%d] openAppId[%s] closeAppId[%s]", objArr);
        AppMethodBeat.o(146249);
    }
}
