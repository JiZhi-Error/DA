package com.tencent.e.d.a;

import com.tencent.e.d.b.e;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements b {
    private final HashSet<Integer> RMq = new HashSet<>();
    private final List<e.a> RMr = new ArrayList();

    public d() {
        AppMethodBeat.i(138347);
        AppMethodBeat.o(138347);
    }

    @Override // com.tencent.e.d.a.b
    public final void a(e.a aVar) {
        AppMethodBeat.i(138348);
        if (aVar.uid != 0) {
            AppMethodBeat.o(138348);
        } else if (aVar.RMw != 1 || "/sbin/adbd".equals(aVar.name)) {
            if (aVar.RMw > 1 && "sh".equals(aVar.name) && "/system/bin/sh".equals(aVar.name)) {
                new StringBuilder("ProcessRelationAnalyzer child : ").append(aVar.toString());
                h.gGd();
                this.RMr.add(aVar);
            }
            AppMethodBeat.o(138348);
        } else {
            new StringBuilder("ProcessRelationAnalyzer parent : ").append(aVar.toString());
            h.gGd();
            this.RMq.add(Integer.valueOf(aVar.pid));
            AppMethodBeat.o(138348);
        }
    }

    @Override // com.tencent.e.d.a.b
    public final boolean hkw() {
        AppMethodBeat.i(138349);
        for (e.a aVar : this.RMr) {
            if (this.RMq.contains(Integer.valueOf(aVar.RMw))) {
                new StringBuilder("ProcessRelationAnalyzer match : ").append(aVar.toString());
                h.hkR();
                AppMethodBeat.o(138349);
                return true;
            }
        }
        AppMethodBeat.o(138349);
        return false;
    }
}
