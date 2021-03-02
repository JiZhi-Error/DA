package com.tencent.mm.plugin.aa.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.Map;

public final class d extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "AARecord")};
    private static final String[] jTH = {"*", "rowid"};
    public static Map<String, c> jTI = new HashMap();
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(c cVar, String[] strArr) {
        AppMethodBeat.i(63429);
        boolean a2 = a(cVar, strArr);
        AppMethodBeat.o(63429);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(c cVar) {
        AppMethodBeat.i(63430);
        boolean a2 = a(cVar);
        AppMethodBeat.o(63430);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(c cVar) {
        AppMethodBeat.i(63428);
        boolean b2 = b(cVar);
        AppMethodBeat.o(63428);
        return b2;
    }

    static {
        AppMethodBeat.i(63431);
        AppMethodBeat.o(63431);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "AARecord", null);
        this.db = iSQLiteDatabase;
    }

    public final c SD(String str) {
        AppMethodBeat.i(63424);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(63424);
            return null;
        }
        Cursor query = this.db.query("AARecord", jTH, "billNo=?", new String[]{str}, null, null, null, 2);
        try {
            if (query.moveToFirst()) {
                c cVar = new c();
                cVar.convertFrom(query);
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(63424);
                return cVar;
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(63424);
            return null;
        } catch (Exception e2) {
            Log.e("MicroMsg.AARecordStorage", "getRecordByBillno error: %s", e2.getMessage());
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(63424);
            throw th;
        }
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(63425);
        if (cVar != null && jTI.containsKey(cVar.field_billNo)) {
            jTI.put(cVar.field_billNo, cVar);
        }
        boolean insert = super.insert(cVar);
        AppMethodBeat.o(63425);
        return insert;
    }

    public final boolean a(c cVar, String... strArr) {
        AppMethodBeat.i(63426);
        if (cVar != null && jTI.containsKey(cVar.field_billNo)) {
            jTI.remove(cVar.field_billNo);
        }
        boolean delete = super.delete(cVar, strArr);
        AppMethodBeat.o(63426);
        return delete;
    }

    public final boolean b(c cVar) {
        AppMethodBeat.i(63427);
        if (cVar != null && jTI.containsKey(cVar.field_billNo)) {
            jTI.put(cVar.field_billNo, cVar);
        }
        boolean replace = super.replace(cVar);
        AppMethodBeat.o(63427);
        return replace;
    }
}
