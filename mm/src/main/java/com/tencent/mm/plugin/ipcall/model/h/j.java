package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.g;

public final class j extends MAutoStorage<i> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(i.info, "IPCallPopularCountry")};
    private ISQLiteDatabase db;
    public MStorageEx keO = new MStorageEx() {
        /* class com.tencent.mm.plugin.ipcall.model.h.j.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx
        public final boolean shouldProcessEvent() {
            AppMethodBeat.i(25552);
            if (j.this.db == null || j.this.db.isClose()) {
                Object[] objArr = new Object[1];
                objArr[0] = j.this.db == null ? BuildConfig.COMMAND : Boolean.valueOf(j.this.db.isClose());
                Log.w("MicroMsg.IPCallPopularCountryStorage", "shouldProcessEvent db is close :%s", objArr);
                AppMethodBeat.o(25552);
                return false;
            }
            AppMethodBeat.o(25552);
            return true;
        }
    };

    static {
        AppMethodBeat.i(25556);
        AppMethodBeat.o(25556);
    }

    public j(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, i.info, "IPCallPopularCountry", null);
        AppMethodBeat.i(25553);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(25553);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.storagebase.g.a
    public final String getTableName() {
        return "IPCallPopularCountry";
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final void ar(int i2, long j2) {
        boolean replace;
        AppMethodBeat.i(25554);
        i iVar = new i();
        Cursor query = this.db.query("IPCallPopularCountry", null, "countryCode=?", new String[]{Integer.toString(i2)}, null, null, null, 2);
        if (!query.moveToFirst()) {
            Log.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:".concat(String.valueOf(i2)));
            query.close();
            iVar.field_countryCode = i2;
            iVar.field_lastCallTime = j2;
            iVar.field_callTimeCount = 1;
            replace = insert(iVar);
        } else {
            iVar.convertFrom(query);
            iVar.field_callTimeCount++;
            iVar.field_lastCallTime = j2;
            replace = super.replace(iVar);
            query.close();
        }
        Log.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:".concat(String.valueOf(replace)));
        AppMethodBeat.o(25554);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.Integer> eba() {
        /*
            r6 = this;
            r5 = 25555(0x63d3, float:3.581E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " ORDER BY IPCallPopularCountry.callTimeCount DESC,IPCallPopularCountry.lastCallTime DESC"
            r1.append(r2)
            com.tencent.mm.sdk.storage.ISQLiteDatabase r2 = r6.db
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "SELECT IPCallPopularCountry.countryCode,IPCallPopularCountry.callTimeCount,IPCallPopularCountry.lastCallTime FROM IPCallPopularCountry  "
            r3.<init>(r4)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r3 = 0
            r4 = 2
            android.database.Cursor r1 = r2.rawQuery(r1, r3, r4)
            if (r1 == 0) goto L_0x0055
            boolean r2 = r1.moveToFirst()
            if (r2 == 0) goto L_0x0055
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x003e:
            com.tencent.mm.plugin.ipcall.model.h.i r2 = new com.tencent.mm.plugin.ipcall.model.h.i
            r2.<init>()
            r2.convertFrom(r1)
            int r2 = r2.field_countryCode
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.add(r2)
            boolean r2 = r1.moveToNext()
            if (r2 != 0) goto L_0x003e
        L_0x0055:
            if (r1 == 0) goto L_0x005a
            r1.close()
        L_0x005a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.model.h.j.eba():java.util.ArrayList");
    }
}
