package com.tencent.mm.plugin.exdevice.g.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a.b;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c extends MAutoStorage<b> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(b.info, "HardDeviceProfileRankDetail")};

    static {
        AppMethodBeat.i(23575);
        AppMethodBeat.o(23575);
    }
}
