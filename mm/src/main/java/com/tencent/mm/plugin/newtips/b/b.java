package com.tencent.mm.plugin.newtips.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "NewTipsInfo")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(a aVar) {
        AppMethodBeat.i(127267);
        boolean f2 = f(aVar);
        AppMethodBeat.o(127267);
        return f2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(a aVar, String[] strArr) {
        AppMethodBeat.i(127266);
        boolean a2 = a(aVar, strArr);
        AppMethodBeat.o(127266);
        return a2;
    }

    static {
        AppMethodBeat.i(127268);
        AppMethodBeat.o(127268);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "NewTipsInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final boolean f(a aVar) {
        boolean z = false;
        AppMethodBeat.i(127263);
        if (aVar == null) {
            Log.e("MicroMsg.NewTipsCompatInfoStorage", "NewTipsCompatInfo is null!");
            AppMethodBeat.o(127263);
        } else if (aVar.field_tipId <= 0) {
            Log.e("MicroMsg.NewTipsCompatInfoStorage", "newTipsId is error, tipsId = %s", Integer.valueOf(aVar.field_tipId));
            AppMethodBeat.o(127263);
        } else {
            z = insertNotify(aVar, false);
            if (z) {
                doNotify(new StringBuilder().append(aVar.field_tipId).toString(), 2, Integer.valueOf(aVar.field_tipId));
            }
            AppMethodBeat.o(127263);
        }
        return z;
    }

    public final boolean a(a aVar, String... strArr) {
        AppMethodBeat.i(127264);
        if (aVar == null) {
            Log.e("MicroMsg.NewTipsCompatInfoStorage", "NewTipsCompatInfo is null!");
            AppMethodBeat.o(127264);
            return false;
        }
        boolean updateNotify = super.updateNotify(aVar, false, strArr);
        if (updateNotify) {
            doNotify(new StringBuilder().append(aVar.field_tipId).toString(), 3, Integer.valueOf(aVar.field_tipId));
        }
        Log.d("MicroMsg.NewTipsCompatInfoStorage", "update result[%B]", Boolean.valueOf(updateNotify));
        AppMethodBeat.o(127264);
        return updateNotify;
    }

    public final a TF(int i2) {
        AppMethodBeat.i(127265);
        if (this.db == null) {
            Log.e("MicroMsg.NewTipsCompatInfoStorage", "getByTipsId, but db is null, return");
            AppMethodBeat.o(127265);
            return null;
        }
        Cursor query = this.db.query("NewTipsInfo", null, "tipId=?", new String[]{String.valueOf(i2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            a aVar = new a();
            try {
                aVar.convertFrom(query);
                query.close();
                AppMethodBeat.o(127265);
                return aVar;
            } catch (Exception e2) {
                Log.e("MicroMsg.NewTipsCompatInfoStorage", "getByTipsId convertFrom(cu) cause IlleagalStateException, return null");
                query.close();
                AppMethodBeat.o(127265);
                return null;
            }
        } else {
            Log.w("MicroMsg.NewTipsCompatInfoStorage", "getByTipsId:%d, no data", Integer.valueOf(i2));
            query.close();
            AppMethodBeat.o(127265);
            return null;
        }
    }
}
