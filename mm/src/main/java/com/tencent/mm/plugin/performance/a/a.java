package com.tencent.mm.plugin.performance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public enum a {
    INSTANCE;
    
    private final List<c> ASc = new CopyOnWriteArrayList();
    private final Map<Class<? extends c>, c> ASd = new ConcurrentHashMap();

    public static a valueOf(String str) {
        AppMethodBeat.i(145993);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(145993);
        return aVar;
    }

    static {
        AppMethodBeat.i(145998);
        AppMethodBeat.o(145998);
    }

    private a(String str) {
        AppMethodBeat.i(145994);
        AppMethodBeat.o(145994);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.Map<java.lang.Class<? extends com.tencent.mm.plugin.performance.a.c>, com.tencent.mm.plugin.performance.a.c> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(c cVar) {
        AppMethodBeat.i(145995);
        if (this.ASd.containsKey(cVar.getClass())) {
            AppMethodBeat.o(145995);
            return;
        }
        this.ASc.add(cVar);
        this.ASd.put(cVar.getClass(), cVar);
        cVar.eBD();
        AppMethodBeat.o(145995);
    }

    public final <T extends c> T aT(Class<T> cls) {
        AppMethodBeat.i(145996);
        T t = (T) this.ASd.get(cls);
        AppMethodBeat.o(145996);
        return t;
    }

    public final void aA(Map<String, String> map) {
        AppMethodBeat.i(194242);
        if (map == null || !map.containsKey(".cmd.diagnostic")) {
            Log.d("MicroMsg.DiagnosticManager", "just ignore other ipxx cmd");
            AppMethodBeat.o(194242);
            return;
        }
        for (c cVar : this.ASc) {
            if (map.containsKey(cVar.eBC())) {
                cVar.aA(map);
            }
        }
        AppMethodBeat.o(194242);
    }

    public final void aJQ(String str) {
        AppMethodBeat.i(194243);
        Log.i("MicroMsg.DiagnosticManager", "received cmd: %s", str);
        aA(XmlParser.parseXml(str, "cmd", null));
        AppMethodBeat.o(194243);
    }

    public static String eBC() {
        return ".cmd.diagnostic";
    }
}
