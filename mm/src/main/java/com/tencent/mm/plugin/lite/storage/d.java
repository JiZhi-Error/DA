package com.tencent.mm.plugin.lite.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class d extends MAutoStorage<c> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "LiteAppAuthInfo")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(c cVar) {
        AppMethodBeat.i(198893);
        boolean a2 = a(cVar);
        AppMethodBeat.o(198893);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(c cVar) {
        AppMethodBeat.i(198892);
        this.db.replace("LiteAppAuthInfo", "host", cVar.convertTo());
        AppMethodBeat.o(198892);
        return true;
    }

    static {
        AppMethodBeat.i(198894);
        AppMethodBeat.o(198894);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, c.info, "LiteAppAuthInfo");
    }

    private d(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(198890);
        this.db.insert("LiteAppAuthInfo", "host", cVar.convertTo());
        AppMethodBeat.o(198890);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.lite.storage.c aCU(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.lite.storage.d.aCU(java.lang.String):com.tencent.mm.plugin.lite.storage.c");
    }
}
