package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class b extends MAutoStorage<a> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(a.info, "AppBrandIdentifierInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(44450);
        AppMethodBeat.o(44450);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "AppBrandIdentifierInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final boolean cy(String str, String str2) {
        AppMethodBeat.i(44447);
        Log.i("MicroMsg.AppBrand.AppBrandIdentifierInfoStorage", "addIdentifierInfo: appId = [%s], userName = [%s]", str, str2);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(44447);
            return false;
        }
        a aVar = new a();
        aVar.field_appId = str;
        aVar.field_username = str2;
        boolean insert = insert(aVar);
        AppMethodBeat.o(44447);
        return insert;
    }

    public final String VH(String str) {
        String str2;
        AppMethodBeat.i(44448);
        Cursor query = this.db.query("AppBrandIdentifierInfo", new String[]{"appId"}, "username=?", new String[]{str}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            str2 = "";
        } else {
            str2 = query.getString(0);
        }
        if (query != null) {
            query.close();
        }
        Log.i("MicroMsg.AppBrand.AppBrandIdentifierInfoStorage", "queryAppId: appId = [%s], userName = [%s]", str2, str);
        AppMethodBeat.o(44448);
        return str2;
    }

    public final String VI(String str) {
        String str2;
        AppMethodBeat.i(44449);
        Cursor query = this.db.query("AppBrandIdentifierInfo", new String[]{ch.COL_USERNAME}, "appId=?", new String[]{str}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            str2 = "";
        } else {
            str2 = query.getString(0);
        }
        if (query != null) {
            query.close();
        }
        Log.i("MicroMsg.AppBrand.AppBrandIdentifierInfoStorage", "queryAppId: appId = [%s], userName = [%s]", str, str2);
        AppMethodBeat.o(44449);
        return str2;
    }
}
