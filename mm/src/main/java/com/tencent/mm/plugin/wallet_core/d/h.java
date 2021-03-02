package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.Map;

public final class h extends MAutoStorage<ae> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ae.info, "WalletLuckyMoney")};
    public static Map<String, ae> jTI = new HashMap();
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(ae aeVar) {
        AppMethodBeat.i(70619);
        boolean a2 = a(aeVar);
        AppMethodBeat.o(70619);
        return a2;
    }

    static {
        AppMethodBeat.i(70620);
        AppMethodBeat.o(70620);
    }

    public h(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ae.info, "WalletLuckyMoney", null);
        this.db = iSQLiteDatabase;
    }

    public final ae aVA(String str) {
        AppMethodBeat.i(70617);
        Cursor rawQuery = this.db.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[]{str});
        if (rawQuery == null) {
            AppMethodBeat.o(70617);
            return null;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(70617);
            return null;
        } else {
            rawQuery.moveToFirst();
            ae aeVar = new ae();
            aeVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(70617);
            return aeVar;
        }
    }

    public final boolean a(ae aeVar) {
        AppMethodBeat.i(70618);
        if (aeVar != null && jTI.containsKey(aeVar.field_mNativeUrl)) {
            jTI.put(aeVar.field_mNativeUrl, aeVar);
        }
        boolean replace = super.replace(aeVar);
        AppMethodBeat.o(70618);
        return replace;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.wallet_core.model.ae> aVB(final java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.d.h.aVB(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.wallet_core.model.ae aVC(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.d.h.aVC(java.lang.String):com.tencent.mm.plugin.wallet_core.model.ae");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.wallet_core.model.ae> fSt() {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.d.h.fSt():java.util.List");
    }
}
