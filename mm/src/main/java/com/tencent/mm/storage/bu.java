package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class bu extends MAutoStorage<bt> implements o {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(bt.info, "GetSysCmdMsgInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(117171);
        AppMethodBeat.o(117171);
    }

    public bu(h hVar) {
        super(hVar, bt.info, "GetSysCmdMsgInfo", null);
        this.db = hVar;
    }
}
