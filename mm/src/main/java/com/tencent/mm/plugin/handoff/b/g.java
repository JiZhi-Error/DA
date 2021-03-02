package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/handoff/parser/HandOffParserFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "type", "", "api-handoff_release"})
public final class g {
    public static final g yhO = new g();

    static {
        AppMethodBeat.i(238086);
        AppMethodBeat.o(238086);
    }

    private g() {
    }

    public static i OJ(int i2) {
        AppMethodBeat.i(238085);
        switch (i2) {
            case 1:
                b bVar = new b();
                AppMethodBeat.o(238085);
                return bVar;
            case 2:
                h hVar = new h();
                AppMethodBeat.o(238085);
                return hVar;
            case 3:
                e eVar = new e();
                AppMethodBeat.o(238085);
                return eVar;
            case 4:
                d dVar = new d();
                AppMethodBeat.o(238085);
                return dVar;
            default:
                AppMethodBeat.o(238085);
                return null;
        }
    }
}
