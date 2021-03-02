package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.exdevice.g.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e extends MAutoStorage<com.tencent.mm.plugin.exdevice.g.b.a.e> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.exdevice.g.b.a.e.info, "HardDeviceLikeUser")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(23586);
        AppMethodBeat.o(23586);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, com.tencent.mm.plugin.exdevice.g.b.a.e.info, "HardDeviceLikeUser", null);
        AppMethodBeat.i(23583);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
        AppMethodBeat.o(23583);
    }

    public final ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> anG(String str) {
        ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> arrayList = null;
        AppMethodBeat.i(23584);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
            AppMethodBeat.o(23584);
        } else {
            String format = String.format("select *, rowid from %s where %s = ? order by %s desc", "HardDeviceLikeUser", "rankID", AppMeasurement.Param.TIMESTAMP);
            Cursor rawQuery = this.db.rawQuery(format, new String[]{Util.nullAs(str, "")}, 2);
            if (rawQuery == null) {
                Log.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
                AppMethodBeat.o(23584);
            } else {
                if (rawQuery.moveToFirst()) {
                    arrayList = new ArrayList<>();
                    do {
                        com.tencent.mm.plugin.exdevice.g.b.a.e eVar = new com.tencent.mm.plugin.exdevice.g.b.a.e();
                        eVar.convertFrom(rawQuery);
                        arrayList.add(eVar);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
                AppMethodBeat.o(23584);
            }
        }
        return arrayList;
    }

    public final void b(String str, String str2, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> arrayList) {
        boolean z;
        AppMethodBeat.i(23585);
        Assert.assertTrue(!Util.isNullOrNil(str));
        if (arrayList == null) {
            Log.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
            AppMethodBeat.o(23585);
            return;
        }
        Iterator<com.tencent.mm.plugin.exdevice.g.b.a.e> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.g.b.a.e next = it.next();
            if (next != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (update(next, "rankID", ch.COL_USERNAME)) {
                Log.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
            } else if (insert(next)) {
                Log.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
            } else {
                Log.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
            }
        }
        ad.cKU().a("HardDeviceLikeUser", new d(str, str2, null));
        AppMethodBeat.o(23585);
    }
}
