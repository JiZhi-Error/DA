package com.tencent.mm.plugin.expansions;

import android.util.Pair;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

final class c {
    static final ArrayList<IDKey> rNE = new ArrayList<>();
    static final List<Pair<String, Object>> rNF = new ArrayList();

    static {
        AppMethodBeat.i(152978);
        AppMethodBeat.o(152978);
    }

    public static void cMv() {
        AppMethodBeat.i(152974);
        g.aAi().a(new com.tencent.mm.kernel.api.g() {
            /* class com.tencent.mm.plugin.expansions.c.AnonymousClass1 */

            @Override // com.tencent.mm.kernel.api.g
            public final void WY() {
                AppMethodBeat.i(152973);
                g.aAi().b(this);
                c.access$000();
                AppMethodBeat.o(152973);
            }

            @Override // com.tencent.mm.kernel.api.g
            public final void cQ(boolean z) {
            }
        });
        AppMethodBeat.o(152974);
    }

    public static void gj(String str, String str2) {
        AppMethodBeat.i(152975);
        rNF.add(new Pair<>(str, str2));
        AppMethodBeat.o(152975);
    }

    public static void cMw() {
        AppMethodBeat.i(152976);
        for (Pair<String, Object> pair : rNF) {
            if (pair.second instanceof String) {
                Log.i((String) pair.first, "pending log: " + pair.second);
            }
            if (pair.second instanceof Throwable) {
                Log.printErrStackTrace((String) pair.first, (Throwable) pair.second, "pending exception", new Object[0]);
            }
        }
        rNF.clear();
        AppMethodBeat.o(152976);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(152977);
        if (rNE.size() > 0) {
            e.INSTANCE.b(rNE, false);
            rNE.clear();
        }
        AppMethodBeat.o(152977);
    }
}
