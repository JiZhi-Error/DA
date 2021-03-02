package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ch extends MAutoStorage<cg> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(cg.info, "OpenMsgListener")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(cg cgVar) {
        AppMethodBeat.i(32884);
        cg cgVar2 = cgVar;
        if (cgVar2 == null || Util.isNullOrNil(cgVar2.field_appId)) {
            Log.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
            AppMethodBeat.o(32884);
            return false;
        }
        boolean z = this.db.replace("OpenMsgListener", cg.info.primaryKey, cgVar2.convertTo()) > 0;
        Log.d("MicroMsg.OpenMsgListenerStorage", "replace: id=%s, ret=%s ", cgVar2.field_appId, Boolean.valueOf(z));
        AppMethodBeat.o(32884);
        return z;
    }

    static {
        AppMethodBeat.i(32885);
        AppMethodBeat.o(32885);
    }

    public ch(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, cg.info, "OpenMsgListener", null);
        AppMethodBeat.i(32881);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
        iSQLiteDatabase.execSQL("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
        AppMethodBeat.o(32881);
    }

    public final cg bkL(String str) {
        AppMethodBeat.i(32882);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(32882);
            return null;
        }
        Cursor query = this.db.query("OpenMsgListener", null, "appId=?", new String[]{Util.escapeSqlValue(str)}, null, null, null, 2);
        if (!query.moveToFirst()) {
            Log.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:".concat(String.valueOf(str)));
            query.close();
            AppMethodBeat.o(32882);
            return null;
        }
        cg cgVar = new cg();
        cgVar.convertFrom(query);
        query.close();
        AppMethodBeat.o(32882);
        return cgVar;
    }

    public final Cursor gEl() {
        AppMethodBeat.i(32883);
        Cursor rawQuery = rawQuery("select * from OpenMsgListener where (status = ?) ", "1");
        AppMethodBeat.o(32883);
        return rawQuery;
    }
}
