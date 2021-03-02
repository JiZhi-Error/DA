package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class cv extends MAutoStorage<cu> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(cu.info, "VoiceTransText")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(cu cuVar) {
        AppMethodBeat.i(148676);
        boolean a2 = a(cuVar);
        AppMethodBeat.o(148676);
        return a2;
    }

    static {
        AppMethodBeat.i(148677);
        AppMethodBeat.o(148677);
    }

    public cv(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, cu.info, "VoiceTransText");
    }

    private cv(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final boolean a(cu cuVar) {
        AppMethodBeat.i(148674);
        if (cuVar == null) {
            AppMethodBeat.o(148674);
            return false;
        }
        if (this.db.replace("VoiceTransText", "msgId", cuVar.convertTo()) >= 0) {
            AppMethodBeat.o(148674);
            return true;
        }
        AppMethodBeat.o(148674);
        return false;
    }

    public final cu bkZ(String str) {
        AppMethodBeat.i(148675);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(148675);
            return null;
        }
        cu cuVar = new cu();
        Cursor query = this.db.query("VoiceTransText", null, "cmsgId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (query.moveToFirst()) {
            cuVar.convertFrom(query);
        }
        query.close();
        AppMethodBeat.o(148675);
        return cuVar;
    }
}
