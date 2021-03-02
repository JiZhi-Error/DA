package com.tencent.mm.ab;

import com.eclipsesource.a.b;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;

public final class j {
    public static e w(Map map) {
        AppMethodBeat.i(158629);
        e eVar = new e();
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(158629);
            return eVar;
        }
        for (Object obj : map.keySet()) {
            a(eVar, (String) obj, map.get(obj));
        }
        AppMethodBeat.o(158629);
        return eVar;
    }

    public static e a(c cVar) {
        AppMethodBeat.i(158630);
        e eVar = new e();
        if (cVar == null) {
            AppMethodBeat.o(158630);
            return eVar;
        }
        try {
            Iterator<String> keys = cVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a(eVar, next, cVar.get(next));
            }
        } catch (g e2) {
        }
        AppMethodBeat.o(158630);
        return eVar;
    }

    public static b a(a aVar) {
        AppMethodBeat.i(158631);
        b bVar = new b();
        if (aVar == null) {
            AppMethodBeat.o(158631);
        } else {
            for (int i2 = 0; i2 < aVar.length(); i2++) {
                try {
                    a(bVar, aVar.get(i2));
                } catch (g e2) {
                }
            }
            AppMethodBeat.o(158631);
        }
        return bVar;
    }

    protected static void a(b bVar, Object obj) {
        AppMethodBeat.i(158632);
        if (obj instanceof c) {
            bVar.a(a((c) obj));
            AppMethodBeat.o(158632);
        } else if (obj instanceof a) {
            bVar.a(a((a) obj));
            AppMethodBeat.o(158632);
        } else if (obj instanceof Integer) {
            bVar.dB(((Integer) obj).intValue());
            AppMethodBeat.o(158632);
        } else if (obj instanceof String) {
            bVar.aT((String) obj);
            AppMethodBeat.o(158632);
        } else if (obj instanceof Boolean) {
            bVar.aM(((Boolean) obj).booleanValue());
            AppMethodBeat.o(158632);
        } else if (obj instanceof Long) {
            bVar.t(((Long) obj).longValue());
            AppMethodBeat.o(158632);
        } else if (obj instanceof Float) {
            bVar.ac(((Float) obj).floatValue());
            AppMethodBeat.o(158632);
        } else if (obj instanceof Integer) {
            bVar.dB(((Integer) obj).intValue());
            AppMethodBeat.o(158632);
        } else if (obj instanceof Double) {
            bVar.e(((Double) obj).doubleValue());
            AppMethodBeat.o(158632);
        } else {
            if (obj instanceof h) {
                bVar.a((h) obj);
            }
            AppMethodBeat.o(158632);
        }
    }

    protected static void a(e eVar, String str, Object obj) {
        AppMethodBeat.i(158633);
        if (obj instanceof c) {
            eVar.b(str, a((c) obj));
            AppMethodBeat.o(158633);
        } else if (obj instanceof a) {
            eVar.b(str, a((a) obj));
            AppMethodBeat.o(158633);
        } else if (obj instanceof Integer) {
            eVar.h(str, ((Integer) obj).intValue());
            AppMethodBeat.o(158633);
        } else if (obj instanceof String) {
            eVar.h(str, (String) obj);
            AppMethodBeat.o(158633);
        } else if (obj instanceof Boolean) {
            eVar.c(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.o(158633);
        } else if (obj instanceof Long) {
            eVar.c(str, ((Long) obj).longValue());
            AppMethodBeat.o(158633);
        } else if (obj instanceof Float) {
            eVar.a(str, ((Float) obj).floatValue());
            AppMethodBeat.o(158633);
        } else if (obj instanceof Double) {
            eVar.a(str, ((Double) obj).doubleValue());
            AppMethodBeat.o(158633);
        } else {
            if (obj instanceof h) {
                eVar.b(str, (h) obj);
            }
            AppMethodBeat.o(158633);
        }
    }
}
