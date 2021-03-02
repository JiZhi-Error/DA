package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.Map;

public final class d extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "RemittanceRecord")};
    private static final String[] jTH = {"*", "rowid"};
    private static Map<String, c> jTI = new HashMap();
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(c cVar, String[] strArr) {
        AppMethodBeat.i(67623);
        c cVar2 = cVar;
        if (cVar2 != null && jTI.containsKey(cVar2.field_transferId)) {
            jTI.remove(cVar2.field_transferId);
        }
        boolean delete = super.delete(cVar2, strArr);
        AppMethodBeat.o(67623);
        return delete;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(c cVar) {
        AppMethodBeat.i(67624);
        c cVar2 = cVar;
        if (cVar2 != null && jTI.containsKey(cVar2.field_transferId)) {
            jTI.put(cVar2.field_transferId, cVar2);
        }
        boolean insert = super.insert(cVar2);
        AppMethodBeat.o(67624);
        return insert;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(c cVar) {
        AppMethodBeat.i(67622);
        boolean a2 = a(cVar);
        AppMethodBeat.o(67622);
        return a2;
    }

    static {
        AppMethodBeat.i(67625);
        AppMethodBeat.o(67625);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "RemittanceRecord", null);
        this.db = iSQLiteDatabase;
    }

    public final c aLW(String str) {
        AppMethodBeat.i(67620);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(67620);
            return null;
        }
        Cursor query = this.db.query("RemittanceRecord", jTH, "transferId=?", new String[]{str}, null, null, null, 2);
        try {
            if (query.moveToFirst()) {
                c cVar = new c();
                cVar.convertFrom(query);
                query.close();
                AppMethodBeat.o(67620);
                return cVar;
            }
            query.close();
            AppMethodBeat.o(67620);
            return null;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", e2, "getRecordByTransferId error: %s", e2.getMessage());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.o(67620);
            throw th;
        }
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(67621);
        if (cVar != null && jTI.containsKey(cVar.field_transferId)) {
            jTI.put(cVar.field_transferId, cVar);
        }
        boolean replace = super.replace(cVar);
        AppMethodBeat.o(67621);
        return replace;
    }

    public final c aLX(String str) {
        AppMethodBeat.i(213703);
        if (Util.isNullOrNil(str) || !jTI.containsKey(str)) {
            c aLW = aLW(str);
            if (aLW != null) {
                jTI.put(str, aLW);
                AppMethodBeat.o(213703);
                return aLW;
            }
            AppMethodBeat.o(213703);
            return null;
        }
        c cVar = jTI.get(str);
        AppMethodBeat.o(213703);
        return cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.remittance.b.c> aLY(java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.b.d.aLY(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.remittance.b.c> eNl() {
        /*
        // Method dump skipped, instructions count: 188
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.b.d.eNl():java.util.List");
    }
}
