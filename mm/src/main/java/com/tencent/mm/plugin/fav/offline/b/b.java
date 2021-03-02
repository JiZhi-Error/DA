package com.tencent.mm.plugin.fav.offline.b;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class b extends MAutoStorage<a> {
    public static final String[] INDEX_CREATE = new String[0];
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "FavOffline")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(a aVar) {
        AppMethodBeat.i(73572);
        boolean b2 = b(aVar);
        AppMethodBeat.o(73572);
        return b2;
    }

    static {
        AppMethodBeat.i(73573);
        AppMethodBeat.o(73573);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "FavOffline", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(73566);
        if (aVar == null) {
            AppMethodBeat.o(73566);
            return false;
        }
        boolean insert = super.insert(aVar);
        AppMethodBeat.o(73566);
        return insert;
    }

    public final List<a> cVx() {
        AppMethodBeat.i(73567);
        ArrayList arrayList = new ArrayList();
        Cursor query = this.db.query("FavOffline", a.info.columns, "status!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, "updateTime asc");
        while (query.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(query);
            arrayList.add(aVar);
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(73567);
            return arrayList;
        }
        AppMethodBeat.o(73567);
        return arrayList;
    }

    public final boolean c(a aVar) {
        AppMethodBeat.i(73568);
        if (aVar == null) {
            Log.e("MicroMsg.offline.FavOfflineStorage", "update() item is null");
            AppMethodBeat.o(73568);
            return false;
        }
        boolean update = update(aVar.systemRowid, aVar);
        AppMethodBeat.o(73568);
        return update;
    }

    public final boolean asj(String str) {
        int i2;
        AppMethodBeat.i(73569);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.offline.FavOfflineStorage", "url is null!");
            AppMethodBeat.o(73569);
            return true;
        }
        try {
            i2 = this.db.delete("FavOffline", "url=?", new String[]{str});
        } catch (Exception e2) {
            Log.e("MicroMsg.offline.FavOfflineStorage", "deleteByUrl url:%s Exception:%s %s", str, e2.getClass().getSimpleName(), e2.getMessage());
            i2 = 0;
        }
        if (i2 > 0) {
            AppMethodBeat.o(73569);
            return true;
        }
        AppMethodBeat.o(73569);
        return false;
    }

    public final a ask(String str) {
        AppMethodBeat.i(73570);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73570);
            return null;
        }
        Cursor query = this.db.query("FavOffline", a.info.columns, "url=?", new String[]{str}, null, null, "rowid");
        if (query.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(query);
            AppMethodBeat.o(73570);
            return aVar;
        }
        AppMethodBeat.o(73570);
        return null;
    }

    public final List<a> cVy() {
        AppMethodBeat.i(73571);
        Cursor query = this.db.query("FavOffline", a.info.columns, "status!=? and failNum<?", new String[]{"2", "5"}, null, null, "rowid");
        if (query == null) {
            AppMethodBeat.o(73571);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(query);
            arrayList.add(aVar);
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(73571);
            return null;
        }
        AppMethodBeat.o(73571);
        return arrayList;
    }
}
