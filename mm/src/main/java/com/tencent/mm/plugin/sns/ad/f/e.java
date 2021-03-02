package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class e implements a {
    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final int getKey() {
        return 13235;
    }

    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final void v(Object... objArr) {
        AppMethodBeat.i(94972);
        a(0, objArr);
        AppMethodBeat.o(94972);
    }

    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(94973);
        switch (i2) {
            case 2:
                AppMethodBeat.o(94973);
                return;
            default:
                h.INSTANCE.a(13235, objArr);
                AppMethodBeat.o(94973);
                return;
        }
    }
}
