package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.SchemeResolver;

/* access modifiers changed from: package-private */
public final class m {
    final SchemeResolver Rds;
    SchemeResolver.a Rdt;

    m(SchemeResolver schemeResolver) {
        this.Rds = schemeResolver;
    }

    public final String toString() {
        AppMethodBeat.i(187739);
        if (this.Rds == null) {
            AppMethodBeat.o(187739);
            return "[NULL]";
        }
        String obj = this.Rds.toString();
        AppMethodBeat.o(187739);
        return obj;
    }
}
