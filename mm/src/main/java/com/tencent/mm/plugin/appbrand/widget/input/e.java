package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import java.util.Set;

public final class e {
    private static final h<ac, aa> orU = new h<>();

    public interface a {
        boolean a(aa aaVar);
    }

    static {
        AppMethodBeat.i(136329);
        AppMethodBeat.o(136329);
    }

    public static void a(ac acVar, aa aaVar) {
        AppMethodBeat.i(136326);
        orU.r(acVar, aaVar);
        AppMethodBeat.o(136326);
    }

    public static void B(ac acVar) {
        AppMethodBeat.i(136327);
        orU.cN(acVar);
        AppMethodBeat.o(136327);
    }

    public static aa a(ac acVar, a aVar) {
        AppMethodBeat.i(136328);
        if (acVar == null) {
            AppMethodBeat.o(136328);
            return null;
        }
        Set<aa> cM = orU.cM(acVar);
        if (cM != null) {
            for (aa aaVar : cM) {
                if (aaVar != null && aVar.a(aaVar)) {
                    AppMethodBeat.o(136328);
                    return aaVar;
                }
            }
        }
        AppMethodBeat.o(136328);
        return null;
    }
}
