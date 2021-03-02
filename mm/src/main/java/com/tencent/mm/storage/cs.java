package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class cs extends MAutoStorage<cr> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(cr.info, "UserOpenIdInApp")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(cr crVar) {
        AppMethodBeat.i(32890);
        boolean a2 = a(crVar);
        AppMethodBeat.o(32890);
        return a2;
    }

    static {
        AppMethodBeat.i(32891);
        AppMethodBeat.o(32891);
    }

    public cs(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, cr.info, "UserOpenIdInApp", null);
        AppMethodBeat.i(32887);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
        iSQLiteDatabase.execSQL("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
        AppMethodBeat.o(32887);
    }

    public final cr bkX(String str) {
        AppMethodBeat.i(32888);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(32888);
            return null;
        }
        Cursor query = this.db.query("UserOpenIdInApp", null, "openId=?", new String[]{Util.escapeSqlValue(str)}, null, null, null, 2);
        if (!query.moveToFirst()) {
            Log.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:".concat(String.valueOf(str)));
            query.close();
            AppMethodBeat.o(32888);
            return null;
        }
        cr crVar = new cr();
        crVar.convertFrom(query);
        query.close();
        AppMethodBeat.o(32888);
        return crVar;
    }

    public final boolean a(cr crVar) {
        boolean z;
        AppMethodBeat.i(32889);
        if (crVar == null || Util.isNullOrNil(crVar.field_appId) || Util.isNullOrNil(crVar.field_openId) || Util.isNullOrNil(crVar.field_username)) {
            Log.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
            AppMethodBeat.o(32889);
            return false;
        }
        if (this.db.replace("UserOpenIdInApp", cr.info.primaryKey, crVar.convertTo()) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", crVar.field_appId, crVar.field_username, Boolean.valueOf(z));
        AppMethodBeat.o(32889);
        return z;
    }
}
