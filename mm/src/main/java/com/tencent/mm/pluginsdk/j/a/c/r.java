package com.tencent.mm.pluginsdk.j.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.a.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class r {
    private static final HashMap<Integer, g> Kao;
    private static volatile List<g> Kap = null;

    static {
        AppMethodBeat.i(152069);
        HashMap<Integer, g> hashMap = new HashMap<>(1);
        Kao = hashMap;
        hashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new b.a());
        AppMethodBeat.o(152069);
    }

    public static void init() {
    }

    public static Collection<g> gob() {
        AppMethodBeat.i(152068);
        if (Kap != null) {
            List<g> list = Kap;
            AppMethodBeat.o(152068);
            return list;
        }
        LinkedList linkedList = new LinkedList();
        for (Integer num : Kao.keySet()) {
            g gVar = Kao.get(Integer.valueOf(num.intValue()));
            if (gVar != null) {
                linkedList.add(gVar);
            }
        }
        Kap = linkedList;
        AppMethodBeat.o(152068);
        return linkedList;
    }
}
