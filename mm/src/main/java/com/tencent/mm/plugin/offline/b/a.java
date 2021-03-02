package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a extends MAutoStorage<r> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(r.info, "OfflineOrderStatus")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(66341);
        AppMethodBeat.o(66341);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, r.info, "OfflineOrderStatus", null);
        this.db = iSQLiteDatabase;
    }

    public final r ezt() {
        boolean z = true;
        r rVar = null;
        AppMethodBeat.i(66334);
        Log.i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", Integer.valueOf(ezv()), ezu());
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(66334);
        } else {
            rawQuery.moveToFirst();
            if (rawQuery.isAfterLast()) {
                z = false;
            }
            if (z) {
                rVar = new r();
                rVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            if (rVar != null) {
                Log.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + rVar.field_status);
            } else {
                Log.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
            }
            AppMethodBeat.o(66334);
        }
        return rVar;
    }

    private boolean b(r rVar) {
        boolean z = true;
        AppMethodBeat.i(66335);
        Cursor rawQuery = this.db.rawQuery("select * from OfflineOrderStatus where reqkey=?", new String[]{rVar.field_reqkey}, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(66335);
            return false;
        }
        rawQuery.moveToFirst();
        if (rawQuery.isAfterLast()) {
            z = false;
        }
        rawQuery.close();
        AppMethodBeat.o(66335);
        return z;
    }

    public final r aJe(String str) {
        r rVar = null;
        AppMethodBeat.i(66336);
        Cursor rawQuery = this.db.rawQuery("select * from OfflineOrderStatus where reqkey=?", new String[]{str}, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(66336);
        } else {
            rawQuery.moveToFirst();
            Log.i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + rawQuery.isAfterLast());
            if (!rawQuery.isAfterLast()) {
                rVar = new r();
                rVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(66336);
        }
        return rVar;
    }

    public final void c(r rVar) {
        AppMethodBeat.i(66337);
        if (rVar.field_reqkey == null) {
            Log.e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
            AppMethodBeat.o(66337);
        } else if (!b(rVar)) {
            Log.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", rVar.field_reqkey, Integer.valueOf(rVar.field_status));
            insert(rVar);
            AppMethodBeat.o(66337);
        } else {
            Log.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", rVar.field_reqkey, Integer.valueOf(rVar.field_status));
            update(rVar, new String[0]);
            AppMethodBeat.o(66337);
        }
    }

    public final void aJf(String str) {
        AppMethodBeat.i(66338);
        r aJe = aJe(str);
        if (aJe != null) {
            aJe.field_status = -1;
        } else {
            aJe = new r();
            aJe.field_reqkey = str;
            aJe.field_status = -1;
        }
        c(aJe);
        AppMethodBeat.o(66338);
    }

    public final String ezu() {
        int i2;
        AppMethodBeat.i(66339);
        Cursor rawQuery = this.db.rawQuery(String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", "OfflineOrderStatus", "rowid", 3), null, 2);
        String str = "";
        if (rawQuery == null) {
            Log.e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
        } else {
            int i3 = 0;
            while (rawQuery.moveToNext() && (i2 = i3 + 1) <= 3) {
                for (int i4 = 0; i4 < rawQuery.getColumnCount(); i4++) {
                    str = str + rawQuery.getColumnName(i4) + ": " + rawQuery.getString(i4) + ", ";
                }
                str = str + ";";
                i3 = i2;
            }
            rawQuery.close();
        }
        AppMethodBeat.o(66339);
        return str;
    }

    public final int ezv() {
        int i2 = 0;
        AppMethodBeat.i(66340);
        Cursor rawQuery = this.db.rawQuery(String.format("SELECT COUNT(*) FROM %s;", "OfflineOrderStatus"), null, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
        } else {
            if (rawQuery.moveToNext() && rawQuery.getColumnCount() > 0) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(66340);
        return i2;
    }
}
