package com.tencent.mm.plugin.expt.d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.a.a;
import com.tencent.mm.plugin.expt.d.e.a.b;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.ail;
import com.tencent.mm.protocal.protobuf.aim;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c {
    public static Map<String, b> a(aik aik) {
        AppMethodBeat.i(220339);
        if (aik.LrR.size() <= 0) {
            AppMethodBeat.o(220339);
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<aij> it = aik.LrR.iterator();
        while (it.hasNext()) {
            aij next = it.next();
            b bVar = new b();
            bVar.syg = next.syg;
            bVar.syj = next.syj;
            bVar.syk = next.syk;
            bVar.syl = next.syl;
            bVar.syn = next.syn;
            bVar.syo = next.syo;
            bVar.syp = next.syp;
            bVar.syq = next.syq;
            bVar.script = next.script;
            bVar.sys = next.sys;
            bVar.sym = new ArrayList();
            Iterator<aii> it2 = next.LrQ.iterator();
            while (it2.hasNext()) {
                aii next2 = it2.next();
                a aVar = new a();
                aVar.index = next2.index;
                aVar.name = next2.name;
                aVar.type = next2.type;
                bVar.sym.add(aVar);
            }
            hashMap.put(bVar.syg, bVar);
        }
        AppMethodBeat.o(220339);
        return hashMap;
    }

    public static aim ae(Map<String, com.tencent.mm.plugin.expt.d.e.a.c> map) {
        AppMethodBeat.i(220340);
        if (map == null || map.size() <= 0) {
            AppMethodBeat.o(220340);
            return null;
        }
        aim aim = new aim();
        for (com.tencent.mm.plugin.expt.d.e.a.c cVar : map.values()) {
            ail ail = new ail();
            ail.syg = cVar.syg;
            ail.syl = cVar.syl;
            ail.sql = cVar.sql;
            ail.syt = cVar.syt;
            ail.dbPath = cVar.dbPath;
            ail.syr = cVar.syr;
            aim.LrS.add(ail);
        }
        AppMethodBeat.o(220340);
        return aim;
    }

    public static Map<String, com.tencent.mm.plugin.expt.d.e.a.c> a(aim aim) {
        AppMethodBeat.i(220341);
        if (aim.LrS.size() <= 0) {
            AppMethodBeat.o(220341);
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ail> it = aim.LrS.iterator();
        while (it.hasNext()) {
            ail next = it.next();
            com.tencent.mm.plugin.expt.d.e.a.c cVar = new com.tencent.mm.plugin.expt.d.e.a.c();
            cVar.syg = next.syg;
            cVar.syl = next.syl;
            cVar.sql = next.sql;
            cVar.syt = next.syt;
            cVar.dbPath = next.dbPath;
            cVar.syr = next.syr;
            hashMap.put(cVar.syg, cVar);
        }
        AppMethodBeat.o(220341);
        return hashMap;
    }

    public static List<a> a(aih aih) {
        AppMethodBeat.i(220342);
        if (aih.LrP.size() <= 0) {
            AppMethodBeat.o(220342);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<aig> it = aih.LrP.iterator();
        while (it.hasNext()) {
            aig next = it.next();
            a aVar = new a();
            aVar.syh = next.syh;
            aVar.data = next.data;
            aVar.syg = next.syg;
            arrayList.add(aVar);
        }
        AppMethodBeat.o(220342);
        return arrayList;
    }

    /* renamed from: do  reason: not valid java name */
    public static aih m17do(List<a> list) {
        AppMethodBeat.i(220343);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(220343);
            return null;
        }
        aih aih = new aih();
        for (a aVar : list) {
            aig aig = new aig();
            aig.syh = aVar.syh;
            aig.data = aVar.data;
            aig.syg = aVar.syg;
            aih.LrP.add(aig);
        }
        AppMethodBeat.o(220343);
        return aih;
    }
}
