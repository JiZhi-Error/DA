package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static List<a> hnv = new LinkedList();
    private static Map<String, a> hnw = new HashMap();

    static {
        AppMethodBeat.i(158796);
        AppMethodBeat.o(158796);
    }

    public static a bq(Object obj) {
        AppMethodBeat.i(158792);
        for (a aVar : hnv) {
            if (aVar.bp(obj)) {
                AppMethodBeat.o(158792);
                return aVar;
            }
        }
        AppMethodBeat.o(158792);
        return null;
    }

    public static void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(158793);
        a bq = bq(obj);
        if (bq != null) {
            bq.a(obj, parcel);
        }
        AppMethodBeat.o(158793);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(158795);
        if (aVar == null || hnv.contains(aVar)) {
            AppMethodBeat.o(158795);
            return;
        }
        hnw.put(aVar.getClass().getName(), aVar);
        hnv.add(aVar);
        AppMethodBeat.o(158795);
    }

    public static Object a(String str, Parcel parcel) {
        AppMethodBeat.i(158794);
        a aVar = hnw.get(str);
        if (aVar != null) {
            Object d2 = aVar.d(parcel);
            AppMethodBeat.o(158794);
            return d2;
        }
        AppMethodBeat.o(158794);
        return null;
    }
}
