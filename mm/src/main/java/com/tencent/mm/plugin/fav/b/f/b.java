package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.e;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<e> implements s {
    private ISQLiteDatabase db;

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, e.info, "FavConfigInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.plugin.fav.a.s
    public final void bE(byte[] bArr) {
        AppMethodBeat.i(101682);
        e cVr = cVr();
        if (8216 == cVr.field_configId) {
            cVr.field_value = Util.encodeHexString(bArr);
            Log.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", cVr.field_value, Boolean.valueOf(update(cVr, new String[0])));
            AppMethodBeat.o(101682);
            return;
        }
        cVr.field_configId = 8216;
        cVr.field_value = Util.encodeHexString(bArr);
        Log.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", cVr.field_value, Boolean.valueOf(insert(cVr)));
        AppMethodBeat.o(101682);
    }

    private e cVr() {
        AppMethodBeat.i(101683);
        e eVar = new e();
        Log.d("MicroMsg.FavConfigStorage", "get fav config sql %s", "select * from FavConfigInfo where configId = 8216");
        Cursor rawQuery = this.db.rawQuery("select * from FavConfigInfo where configId = 8216", null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                eVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(101683);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.fav.a.s
    public final byte[] cUN() {
        AppMethodBeat.i(101684);
        e cVr = cVr();
        if (8216 != cVr.field_configId) {
            Log.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
            g.aAi();
            if (((Boolean) g.aAh().azQ().get(8224, Boolean.FALSE)).booleanValue()) {
                Log.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
            } else {
                g.aAi();
                String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(8216, ""));
                Log.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", nullAsNil);
                byte[] decodeHexString = Util.decodeHexString(nullAsNil);
                bE(decodeHexString);
                Log.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
                g.aAi();
                g.aAh().azQ().set(8224, Boolean.TRUE);
                AppMethodBeat.o(101684);
                return decodeHexString;
            }
        }
        Log.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", Integer.valueOf(cVr.field_configId), cVr.field_value);
        byte[] decodeHexString2 = Util.decodeHexString(cVr.field_value);
        AppMethodBeat.o(101684);
        return decodeHexString2;
    }
}
