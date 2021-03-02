package com.tencent.e.d.a;

import com.tencent.e.d.b.e;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class g implements b {
    private final Pattern Pmj = Pattern.compile("^/system/xbin/ku\\.sud$|^daemonsu:|^k_worker/[1-9]\\d*:[1-9]\\d*$|^kr_worker/[1-9]\\d*:[1-9]\\d*$|^km_worker/[1-9]\\d*:[1-9]\\d*$|^tworker/[1-9]\\d*:[1-9]\\d*$|^tu_worker/[1-9]\\d*:[1-9]\\d*$|^tq_worker/[1-9]\\d*:[1-9]\\d*$|^kworker/[1-9]\\d{2}$|^permmgrd$|^360sguard$|^/data/data/[\\w\\-\\.]+/");
    private final List<e.a> RMp = new ArrayList();

    public g() {
        AppMethodBeat.i(138353);
        AppMethodBeat.o(138353);
    }

    @Override // com.tencent.e.d.a.b
    public final void a(e.a aVar) {
        AppMethodBeat.i(138354);
        if (aVar.uid != 0) {
            AppMethodBeat.o(138354);
        } else if (aVar.RMw != 1) {
            AppMethodBeat.o(138354);
        } else {
            this.RMp.add(aVar);
            AppMethodBeat.o(138354);
        }
    }

    @Override // com.tencent.e.d.a.b
    public final boolean hkw() {
        AppMethodBeat.i(138355);
        for (e.a aVar : this.RMp) {
            new StringBuilder("SingleProcessAnalyzer : ").append(aVar.toString());
            h.gGd();
            if (aVar.name != null && this.Pmj.matcher(aVar.name).find()) {
                new StringBuilder("SingleProcessAnalyzer match : ").append(aVar.toString());
                h.hkR();
                AppMethodBeat.o(138355);
                return true;
            }
        }
        AppMethodBeat.o(138355);
        return false;
    }
}
