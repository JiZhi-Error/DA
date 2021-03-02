package com.tencent.b.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r {
    private static r dgd = null;
    private Map<Integer, q> dgb;
    private int dgc;

    private r(Context context) {
        AppMethodBeat.i(87606);
        this.dgb = null;
        this.dgc = 0;
        this.dgb = new HashMap(3);
        this.dgb.put(1, new o(context));
        this.dgb.put(2, new d(context));
        this.dgb.put(4, new k(context));
        AppMethodBeat.o(87606);
    }

    static synchronized r bs(Context context) {
        r rVar;
        synchronized (r.class) {
            AppMethodBeat.i(87607);
            if (dgd == null) {
                dgd = new r(context);
            }
            rVar = dgd;
            AppMethodBeat.o(87607);
        }
        return rVar;
    }

    /* access modifiers changed from: package-private */
    public final g Ud() {
        AppMethodBeat.i(87608);
        g M = M(new ArrayList(Arrays.asList(1, 2, 4)));
        AppMethodBeat.o(87608);
        return M;
    }

    /* access modifiers changed from: package-private */
    public final g M(List<Integer> list) {
        g Ud;
        AppMethodBeat.i(87609);
        if (list.size() >= 0) {
            for (Integer num : list) {
                q qVar = this.dgb.get(num);
                if (!(qVar == null || (Ud = qVar.Ud()) == null || !s.eZ(Ud.dfK))) {
                    AppMethodBeat.o(87609);
                    return Ud;
                }
            }
        }
        g gVar = new g();
        AppMethodBeat.o(87609);
        return gVar;
    }

    /* access modifiers changed from: package-private */
    public final a Ue() {
        AppMethodBeat.i(87610);
        a N = N(new ArrayList(Arrays.asList(1, 4)));
        AppMethodBeat.o(87610);
        return N;
    }

    private a N(List<Integer> list) {
        a Ue;
        AppMethodBeat.i(87611);
        if (list.size() > 0) {
            for (Integer num : list) {
                q qVar = this.dgb.get(num);
                if (!(qVar == null || (Ue = qVar.Ue()) == null)) {
                    AppMethodBeat.o(87611);
                    return Ue;
                }
            }
        }
        a aVar = new a();
        AppMethodBeat.o(87611);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        AppMethodBeat.i(87612);
        for (Map.Entry<Integer, q> entry : this.dgb.entrySet()) {
            entry.getValue().b(aVar);
        }
        AppMethodBeat.o(87612);
    }

    /* access modifiers changed from: package-private */
    public final void b(g gVar) {
        AppMethodBeat.i(87613);
        for (Map.Entry<Integer, q> entry : this.dgb.entrySet()) {
            entry.getValue().b(gVar);
        }
        AppMethodBeat.o(87613);
    }
}
