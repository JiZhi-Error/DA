package com.tencent.mm.plugin.lite.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import java.util.ArrayList;
import java.util.List;

public final class f extends MAutoStorage<e> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "LiteAppInfo")};
    ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(e eVar) {
        AppMethodBeat.i(198903);
        boolean a2 = a(eVar);
        AppMethodBeat.o(198903);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(e eVar) {
        AppMethodBeat.i(198902);
        this.db.replace("LiteAppInfo", "appId", eVar.convertTo());
        AppMethodBeat.o(198902);
        return true;
    }

    static {
        AppMethodBeat.i(198904);
        AppMethodBeat.o(198904);
    }

    public f(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, e.info, "LiteAppInfo");
    }

    private f(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final boolean a(e eVar) {
        AppMethodBeat.i(198899);
        this.db.insert("LiteAppInfo", "appId", eVar.convertTo());
        AppMethodBeat.o(198899);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.lite.storage.e aCV(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.lite.storage.f.aCV(java.lang.String):com.tencent.mm.plugin.lite.storage.e");
    }

    public final List<e> ecD() {
        AppMethodBeat.i(198901);
        String format = String.format("select * from %s ", "LiteAppInfo");
        String[] strArr = new String[0];
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery(format, strArr, 2);
            if (rawQuery.moveToFirst()) {
                do {
                    e eVar = new e();
                    eVar.convertFrom(rawQuery);
                    arrayList.add(eVar);
                } while (rawQuery.moveToNext());
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.LiteAppInfoStorage", "getLiteAppList failed. :%s", Util.stackTraceToString(e2));
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(198901);
            throw th;
        }
        AppMethodBeat.o(198901);
        return arrayList;
    }
}
