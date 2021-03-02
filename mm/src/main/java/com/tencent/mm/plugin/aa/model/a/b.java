package com.tencent.mm.plugin.aa.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "AAPayRecord")};
    private static final String[] jTH = {"*", "rowid"};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(63422);
        AppMethodBeat.o(63422);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "AAPayRecord", null);
        this.db = iSQLiteDatabase;
    }

    public final a SC(String str) {
        AppMethodBeat.i(63421);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(63421);
            return null;
        }
        Cursor query = this.db.query("AAPayRecord", jTH, "payMsgId=?", new String[]{str}, null, null, null, 2);
        try {
            if (query.moveToFirst()) {
                a aVar = new a();
                aVar.convertFrom(query);
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(63421);
                return aVar;
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(63421);
            return null;
        } catch (Exception e2) {
            Log.e("MicroMsg.AAPayRecordStorage", "getByPayMsgId error: %s", e2.getMessage());
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(63421);
            throw th;
        }
    }
}
