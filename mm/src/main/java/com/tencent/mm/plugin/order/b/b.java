package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "OrderCommonMsgXml")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* bridge */ /* synthetic */ boolean insert(a aVar) {
        AppMethodBeat.i(66704);
        boolean insert = super.insert(aVar);
        AppMethodBeat.o(66704);
        return insert;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* bridge */ /* synthetic */ boolean update(a aVar, String[] strArr) {
        AppMethodBeat.i(66703);
        boolean update = super.update(aVar, strArr);
        AppMethodBeat.o(66703);
        return update;
    }

    static {
        AppMethodBeat.i(66705);
        AppMethodBeat.o(66705);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "OrderCommonMsgXml", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final Cursor getAll() {
        AppMethodBeat.i(66701);
        Cursor rawQuery = this.db.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
        AppMethodBeat.o(66701);
        return rawQuery;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(66702);
        boolean insert = super.insert(aVar);
        AppMethodBeat.o(66702);
        return insert;
    }
}
