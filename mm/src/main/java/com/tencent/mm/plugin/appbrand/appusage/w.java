package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public enum w {
    ;

    public static w valueOf(String str) {
        AppMethodBeat.i(44598);
        w wVar = (w) Enum.valueOf(w.class, str);
        AppMethodBeat.o(44598);
        return wVar;
    }

    static void a(int i2, LinkedList<fcn> linkedList) {
        AppMethodBeat.i(44599);
        a(i2, linkedList, null);
        AppMethodBeat.o(44599);
    }

    static void a(int i2, LinkedList<fcn> linkedList, aa.d dVar) {
        o.a aVar;
        AppMethodBeat.i(226393);
        HashSet hashSet = new HashSet();
        Iterator<fcn> it = linkedList.iterator();
        while (it.hasNext()) {
            fcn next = it.next();
            if (!Util.isNullOrNil(next.username)) {
                hashSet.add(next.username);
            }
        }
        ArrayList arrayList = new ArrayList(hashSet.size());
        arrayList.addAll(hashSet);
        if (i2 == 3) {
            aVar = o.a.RECENTS_LIST;
        } else {
            aVar = o.a.DEFAULT;
        }
        aa.a(arrayList, aVar, dVar);
        AppMethodBeat.o(226393);
    }
}
