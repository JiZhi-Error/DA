package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final Map<String, List<n.a>> hno = new ConcurrentHashMap();
    private static final Map<String, DebuggerInfo> lnf = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(121294);
        AppMethodBeat.o(121294);
    }

    public static DebuggerInfo Yv(String str) {
        AppMethodBeat.i(121289);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(121289);
            return null;
        }
        DebuggerInfo debuggerInfo = lnf.get(str);
        AppMethodBeat.o(121289);
        return debuggerInfo;
    }

    public static void a(String str, DebuggerInfo debuggerInfo) {
        AppMethodBeat.i(121290);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(121290);
            return;
        }
        lnf.put(str, debuggerInfo);
        AppMethodBeat.o(121290);
    }

    public static boolean c(String str, n.a aVar) {
        AppMethodBeat.i(121291);
        if (Util.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(121291);
            return false;
        }
        List<n.a> list = hno.get(str);
        if (list == null) {
            list = new LinkedList<>();
            hno.put(str, list);
        } else if (list.contains(aVar)) {
            AppMethodBeat.o(121291);
            return true;
        }
        boolean add = list.add(aVar);
        AppMethodBeat.o(121291);
        return add;
    }

    public static boolean d(String str, n.a aVar) {
        AppMethodBeat.i(121292);
        if (Util.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(121292);
            return false;
        }
        List<n.a> list = hno.get(str);
        if (list == null) {
            AppMethodBeat.o(121292);
            return false;
        }
        boolean remove = list.remove(aVar);
        if (list.isEmpty()) {
            hno.remove(str);
        }
        AppMethodBeat.o(121292);
        return remove;
    }

    public static void S(String str, int i2) {
        AppMethodBeat.i(121293);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(121293);
            return;
        }
        List<n.a> list = hno.get(str);
        if (list == null) {
            AppMethodBeat.o(121293);
            return;
        }
        for (n.a aVar : new LinkedList(list)) {
            aVar.sF(i2);
        }
        AppMethodBeat.o(121293);
    }
}
