package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class c extends MAutoStorage<f> implements t {
    private ISQLiteDatabase db;

    @Override // com.tencent.mm.plugin.fav.a.t
    public final /* synthetic */ boolean a(f fVar) {
        AppMethodBeat.i(101690);
        boolean insert = super.insert(fVar);
        AppMethodBeat.o(101690);
        return insert;
    }

    @Override // com.tencent.mm.plugin.fav.a.t
    public final /* synthetic */ boolean a(f fVar, String[] strArr) {
        AppMethodBeat.i(101689);
        boolean update = super.update(fVar, strArr);
        AppMethodBeat.o(101689);
        return update;
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, f.info, "FavEditInfo", null);
        AppMethodBeat.i(101685);
        this.db = iSQLiteDatabase;
        this.db.execSQL("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
        AppMethodBeat.o(101685);
    }

    @Override // com.tencent.mm.plugin.fav.a.t
    public final f DX(long j2) {
        f fVar = null;
        AppMethodBeat.i(101686);
        Cursor rawQuery = this.db.rawQuery("select * from FavEditInfo where localId =  ? and type =  ?", new String[]{String.valueOf(j2), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101686);
        } else {
            if (rawQuery.moveToFirst()) {
                fVar = new f();
                fVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(101686);
        }
        return fVar;
    }

    @Override // com.tencent.mm.plugin.fav.a.t
    public final void y(long j2, int i2) {
        AppMethodBeat.i(101687);
        this.db.delete("FavEditInfo", "localId=? and type=?", new String[]{String.valueOf(j2), String.valueOf(i2)});
        AppMethodBeat.o(101687);
    }

    @Override // com.tencent.mm.plugin.fav.a.t
    public final List<f> cUO() {
        AppMethodBeat.i(101688);
        Cursor rawQuery = this.db.rawQuery("select count(*) from FavEditInfo", null, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.Fav.FavEditInfoStorage", "count all edit info, cursor is null");
            AppMethodBeat.o(101688);
            return null;
        }
        try {
            if (rawQuery.moveToFirst()) {
                Log.i("MicroMsg.Fav.FavEditInfoStorage", "get all edit infos, count %d", Integer.valueOf(rawQuery.getInt(0)));
            }
            rawQuery.close();
            Cursor rawQuery2 = this.db.rawQuery("select * from FavEditInfo", null, 2);
            if (rawQuery2 == null) {
                AppMethodBeat.o(101688);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                if (rawQuery2.moveToFirst()) {
                    do {
                        f fVar = new f();
                        fVar.convertFrom(rawQuery2);
                        arrayList.add(fVar);
                    } while (rawQuery2.moveToNext());
                }
                rawQuery2.close();
                AppMethodBeat.o(101688);
                return arrayList;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e2, "", new Object[0]);
                rawQuery2.close();
                AppMethodBeat.o(101688);
                return null;
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e3, "", new Object[0]);
            rawQuery.close();
            AppMethodBeat.o(101688);
            return null;
        }
    }
}
