package com.tencent.mm.msgsubscription.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.b.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/msgsubscription/api/SubscribeMsgServiceFactory;", "", "()V", "NAME_BIZ", "", "NAME_WXA", "imps", "", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "getInstance", "name", "register", "", "implement", "unregister", "plugin-comm_release"})
public final class b {
    private static final Map<String, a> jyZ = new LinkedHashMap();
    public static final b jza = new b();

    static {
        AppMethodBeat.i(223231);
        AppMethodBeat.o(223231);
    }

    private b() {
    }

    public static a Ru(String str) {
        AppMethodBeat.i(223229);
        p.h(str, "name");
        a aVar = jyZ.get(str);
        AppMethodBeat.o(223229);
        return aVar;
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(223230);
        p.h(str, "name");
        p.h(aVar, "implement");
        jyZ.put(str, aVar);
        AppMethodBeat.o(223230);
    }
}
