package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.exdevice.g.b.a.a;
import com.tencent.mm.plugin.exdevice.g.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import junit.framework.Assert;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "HardDeviceChampionInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(23574);
        AppMethodBeat.o(23574);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "HardDeviceChampionInfo", null);
        AppMethodBeat.i(23571);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
        AppMethodBeat.o(23571);
    }

    public final a anF(String str) {
        a aVar = null;
        AppMethodBeat.i(23572);
        String format = String.format("select *, rowid from %s where %s = ? limit 1", "HardDeviceChampionInfo", ch.COL_USERNAME);
        Cursor rawQuery = this.db.rawQuery(format, new String[]{Util.nullAs(str, "")}, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
            AppMethodBeat.o(23572);
        } else {
            if (rawQuery.moveToFirst()) {
                aVar = new a();
                aVar.convertFrom(rawQuery);
            } else {
                Log.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
            }
            rawQuery.close();
            AppMethodBeat.o(23572);
        }
        return aVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(23573);
        Assert.assertTrue(aVar != null);
        if (update(aVar, ch.COL_USERNAME)) {
            Log.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
            ad.cKU().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            AppMethodBeat.o(23573);
            return true;
        } else if (insert(aVar)) {
            Log.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
            ad.cKU().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            AppMethodBeat.o(23573);
            return true;
        } else {
            Log.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
            AppMethodBeat.o(23573);
            return false;
        }
    }
}
