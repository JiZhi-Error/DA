package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class k extends MAutoStorage<j> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(j.info, "ShakeNewYearFriendInfo")};

    static {
        AppMethodBeat.i(28146);
        AppMethodBeat.o(28146);
    }
}
