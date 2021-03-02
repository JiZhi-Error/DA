package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class c implements a {
    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final int getKey() {
        return 12990;
    }

    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final void v(Object... objArr) {
        AppMethodBeat.i(94968);
        a(0, objArr);
        AppMethodBeat.o(94968);
    }

    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(94969);
        switch (i2) {
            case 2:
                AppMethodBeat.o(94969);
                return;
            default:
                h.INSTANCE.a(12990, objArr);
                AppMethodBeat.o(94969);
                return;
        }
    }
}
