package com.tencent.mm.plugin.textstatus.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.n;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/logic/StatusLoadLogicFactory;", "", "()V", "get", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "getProfileLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "plugin-textstatus_release"})
public final class e {
    public static final e FYH = new e();

    static {
        AppMethodBeat.i(216156);
        AppMethodBeat.o(216156);
    }

    private e() {
    }

    public static d a(n nVar) {
        AppMethodBeat.i(216154);
        p.h(nVar, "showParam");
        b bVar = new b(nVar);
        AppMethodBeat.o(216154);
        return bVar;
    }

    public static /* synthetic */ c fvR() {
        AppMethodBeat.i(216155);
        n nVar = n.FXs;
        p.g(nVar, "StatusShowParam.sDefaultShowParam");
        c b2 = b(nVar);
        AppMethodBeat.o(216155);
        return b2;
    }

    public static c b(n nVar) {
        AppMethodBeat.i(258390);
        p.h(nVar, "showParam");
        a aVar = new a(nVar);
        AppMethodBeat.o(258390);
        return aVar;
    }
}
