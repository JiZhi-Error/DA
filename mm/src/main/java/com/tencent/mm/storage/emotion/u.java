package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class u extends MAutoStorage<SmileyPanelConfigInfo> implements g.a {
    private static final String[] OsP = {"position", "key"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(SmileyPanelConfigInfo.info, "SmileyPanelConfigInfo")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(105152);
        AppMethodBeat.o(105152);
    }

    public u(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, SmileyPanelConfigInfo.info, "SmileyPanelConfigInfo");
    }

    private u(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.storage.emotion.SmileyPanelConfigInfo> cFK() {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.u.cFK():java.util.ArrayList");
    }
}
