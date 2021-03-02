package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class aw extends MAutoStorage<av> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(av.info, "ContactLabelCache")};

    static {
        AppMethodBeat.i(32841);
        AppMethodBeat.o(32841);
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        return 0;
    }
}
