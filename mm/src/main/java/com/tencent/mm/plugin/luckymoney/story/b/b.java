package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "LocalRedPacketStoryInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(163693);
        AppMethodBeat.o(163693);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "LocalRedPacketStoryInfo", null);
        this.db = iSQLiteDatabase;
    }
}
