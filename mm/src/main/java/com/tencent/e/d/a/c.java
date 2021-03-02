package com.tencent.e.d.a;

import android.text.TextUtils;
import com.tencent.e.d.b.e;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {
    private final List<e.a> RMp = new ArrayList();

    public c() {
        AppMethodBeat.i(138344);
        AppMethodBeat.o(138344);
    }

    @Override // com.tencent.e.d.a.b
    public final void a(e.a aVar) {
        AppMethodBeat.i(138345);
        if (aVar.uid != 0) {
            AppMethodBeat.o(138345);
        } else if (TextUtils.isEmpty(aVar.RMx) || !"u:r:zygote:s0".equals(aVar.RMx)) {
            AppMethodBeat.o(138345);
        } else if (TextUtils.isEmpty(aVar.name) || "zygote".equals(aVar.name) || "zygote64".equals(aVar.name)) {
            AppMethodBeat.o(138345);
        } else {
            new StringBuilder("JavaProcessAnalyzer match : ").append(aVar.toString());
            h.hkR();
            this.RMp.add(aVar);
            AppMethodBeat.o(138345);
        }
    }

    @Override // com.tencent.e.d.a.b
    public final boolean hkw() {
        AppMethodBeat.i(138346);
        if (this.RMp.size() > 0) {
            AppMethodBeat.o(138346);
            return true;
        }
        AppMethodBeat.o(138346);
        return false;
    }
}
