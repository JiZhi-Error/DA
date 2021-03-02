package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import junit.framework.Assert;

public final class d extends MAutoStorage<com.tencent.mm.plugin.exdevice.g.b.a.d> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.exdevice.g.b.a.d.info, "HardDeviceRankInfo")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(23582);
        AppMethodBeat.o(23582);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, com.tencent.mm.plugin.exdevice.g.b.a.d.info, "HardDeviceRankInfo", null);
        AppMethodBeat.i(23576);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
        AppMethodBeat.o(23576);
    }

    public final com.tencent.mm.plugin.exdevice.g.b.a.d a(com.tencent.mm.plugin.exdevice.g.b.d dVar) {
        com.tencent.mm.plugin.exdevice.g.b.a.d dVar2 = null;
        AppMethodBeat.i(23577);
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? limit 1", "HardDeviceRankInfo", "rankID", ch.COL_USERNAME);
        Cursor rawQuery = this.db.rawQuery(format, new String[]{Util.nullAs(dVar.rCB, ""), Util.nullAs(dVar.username, "")}, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
            AppMethodBeat.o(23577);
        } else {
            if (rawQuery.moveToFirst()) {
                dVar2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
                dVar2.convertFrom(rawQuery);
            } else {
                Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            }
            rawQuery.close();
            AppMethodBeat.o(23577);
        }
        return dVar2;
    }

    public final void g(String str, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> arrayList) {
        AppMethodBeat.i(23578);
        if (Util.isNullOrNil(str) || arrayList == null) {
            Log.w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
            AppMethodBeat.o(23578);
            return;
        }
        Log.i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", str, Integer.valueOf(arrayList.size()));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a(arrayList.get(i2), false);
        }
        ad.cKU().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(str, null, null));
        AppMethodBeat.o(23578);
    }

    public final boolean a(com.tencent.mm.plugin.exdevice.g.b.a.d dVar, boolean z) {
        AppMethodBeat.i(23579);
        if (b(dVar, z)) {
            AppMethodBeat.o(23579);
        } else {
            c(dVar, z);
            AppMethodBeat.o(23579);
        }
        return true;
    }

    public final boolean b(com.tencent.mm.plugin.exdevice.g.b.a.d dVar, boolean z) {
        AppMethodBeat.i(23580);
        Assert.assertTrue(dVar != null);
        com.tencent.mm.plugin.exdevice.g.b.a.d a2 = a(new com.tencent.mm.plugin.exdevice.g.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
        if (a2 != null) {
            a2.field_likecount = dVar.field_likecount;
            a2.field_selfLikeState = dVar.field_selfLikeState;
            update(a2, "rankID", ch.COL_USERNAME);
            Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
            if (z) {
                ad.cKU().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
            }
            AppMethodBeat.o(23580);
            return true;
        }
        AppMethodBeat.o(23580);
        return false;
    }

    private boolean c(com.tencent.mm.plugin.exdevice.g.b.a.d dVar, boolean z) {
        AppMethodBeat.i(23581);
        Assert.assertTrue(dVar != null);
        insert(dVar);
        Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
        if (z) {
            ad.cKU().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
        }
        AppMethodBeat.o(23581);
        return true;
    }
}
