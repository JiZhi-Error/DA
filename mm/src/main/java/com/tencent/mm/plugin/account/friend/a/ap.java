package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ap extends MAutoStorage<r> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(r.info, "OldAccountFriend")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(184428);
        AppMethodBeat.o(184428);
    }

    public ap(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, r.info, "OldAccountFriend", null);
        this.db = iSQLiteDatabase;
    }
}
