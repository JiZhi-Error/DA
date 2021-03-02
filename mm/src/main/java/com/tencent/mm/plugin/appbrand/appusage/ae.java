package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.storage.ar;

public final class ae extends as {
    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(44648);
        if (rT(i2)) {
            g.aAh().azQ().set(ar.a.APPBRAND_PREDOWNLOAD_DONE_USAGE_USERNAME_DUPLICATE_BEFORE_BOOLEAN_SYNC, Boolean.FALSE);
        }
        AppMethodBeat.o(44648);
    }

    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        boolean z = true;
        boolean z2 = i2 != 0;
        if (i2 >= 637927936) {
            z = false;
        }
        return z & z2;
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
    }
}
