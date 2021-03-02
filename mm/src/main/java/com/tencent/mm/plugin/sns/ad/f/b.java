package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b implements a {
    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final int getKey() {
        return 11855;
    }

    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final void v(Object... objArr) {
        AppMethodBeat.i(94966);
        a(0, objArr);
        AppMethodBeat.o(94966);
    }

    @Override // com.tencent.mm.plugin.sns.ad.f.a
    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(94967);
        switch (i2) {
            case 0:
            case 1:
                h.INSTANCE.a(11855, objArr);
                AppMethodBeat.o(94967);
                return;
            case 2:
                h.INSTANCE.a(14646, objArr);
                AppMethodBeat.o(94967);
                return;
            default:
                Log.e("Kv_11855", "unknown type %d", Integer.valueOf(i2));
                AppMethodBeat.o(94967);
                return;
        }
    }
}
