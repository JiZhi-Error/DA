package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class d implements a {
    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final int getKey() {
        return 13182;
    }

    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final void v(Object... objArr) {
        AppMethodBeat.i(94970);
        a(0, objArr);
        AppMethodBeat.o(94970);
    }

    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(94971);
        switch (i2) {
            case 2:
                AppMethodBeat.o(94971);
                return;
            default:
                h.INSTANCE.a(13182, objArr);
                AppMethodBeat.o(94971);
                return;
        }
    }
}
