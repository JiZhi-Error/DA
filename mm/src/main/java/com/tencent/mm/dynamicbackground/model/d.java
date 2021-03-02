package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 11}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/dynamicbackground/model/DynamicBgServiceManager;", "", "()V", "TAG", "", "service", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "getDynamicBgService", "setDynamicBgService", "", "dynamicBgService", "dynamicbg_release"})
public final class d {
    private static c gRi = new a();
    public static final d gRj = new d();

    static {
        AppMethodBeat.i(103080);
        AppMethodBeat.o(103080);
    }

    private d() {
    }

    public static void a(c cVar) {
        AppMethodBeat.i(103079);
        p.h(cVar, "dynamicBgService");
        c.i("MicroMsg.DynamicBgServiceManager", "alvinluo setDynamicBgService", new Object[0]);
        gRi = cVar;
        AppMethodBeat.o(103079);
    }

    public static c atN() {
        return gRi;
    }
}
