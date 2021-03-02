package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "DelayTransferRecord")};
    private static final String[] jTH = {"*", "rowid"};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(67618);
        AppMethodBeat.o(67618);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "DelayTransferRecord", null);
        this.db = iSQLiteDatabase;
    }

    public final a aLV(String str) {
        AppMethodBeat.i(67617);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AARecordStorage", "empty transferId");
            AppMethodBeat.o(67617);
            return null;
        }
        Cursor query = this.db.query("DelayTransferRecord", jTH, "transferId=?", new String[]{str}, null, null, null, 2);
        try {
            if (query.moveToFirst()) {
                a aVar = new a();
                aVar.convertFrom(query);
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(67617);
                return aVar;
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(67617);
            return null;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AARecordStorage", e2, "", new Object[0]);
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(67617);
            throw th;
        }
    }
}
