package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class k extends MAutoStorage<b> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(b.iBg, "AppBrandAppLaunchUsernameDuplicateRecord2")};
    public final ISQLiteDatabase kLX;

    static {
        AppMethodBeat.i(44488);
        AppMethodBeat.o(44488);
    }

    public k(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, b.iBg, "AppBrandAppLaunchUsernameDuplicateRecord2", b.INDEX_CREATE);
        this.kLX = iSQLiteDatabase;
    }

    public final b Ws(String str) {
        AppMethodBeat.i(226387);
        b bVar = new b();
        bVar.field_usernameHash = str.hashCode();
        if (!get(bVar, "usernameHash") || bVar.field_username == null || !bVar.field_username.equals(str)) {
            AppMethodBeat.o(226387);
            return null;
        }
        AppMethodBeat.o(226387);
        return bVar;
    }

    public final List<String> bxT() {
        AppMethodBeat.i(226388);
        Cursor rawQuery = rawQuery(String.format("select attributes.appId from %s as duplicate inner join %s as attributes where duplicate.username = attributes.username", "AppBrandAppLaunchUsernameDuplicateRecord2", "WxaAttributesTable"), new String[0]);
        ArrayList arrayList = new ArrayList();
        if (rawQuery == null || rawQuery.getColumnCount() <= 0) {
            AppMethodBeat.o(226388);
        } else {
            while (rawQuery.moveToNext()) {
                try {
                    String string = rawQuery.getString(0);
                    if (Util.isNullOrNil(string)) {
                        Log.i("MicroMsg.AppBrandLaunchUsernameDuplicateStorage", "appId is null, continue");
                    } else {
                        arrayList.add(string);
                    }
                } finally {
                    rawQuery.close();
                    AppMethodBeat.o(226388);
                }
            }
        }
        return arrayList;
    }

    public final boolean Wt(String str) {
        AppMethodBeat.i(226389);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(226389);
            return false;
        }
        b Ws = Ws(str);
        if (Ws == null || Ws.field_updateTime <= 0) {
            AppMethodBeat.o(226389);
            return false;
        }
        AppMethodBeat.o(226389);
        return true;
    }

    public final boolean P(String str, long j2) {
        AppMethodBeat.i(44487);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44487);
            return false;
        }
        b bVar = new b();
        bVar.field_usernameHash = str.hashCode();
        bVar.field_username = str;
        boolean z = get(bVar, new String[0]);
        bVar.field_updateTime = j2;
        if (z) {
            boolean update = update(bVar, new String[0]);
            AppMethodBeat.o(44487);
            return update;
        }
        boolean insert = insert(bVar);
        AppMethodBeat.o(44487);
        return insert;
    }

    public final boolean Wu(String str) {
        AppMethodBeat.i(226390);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(226390);
            return false;
        }
        b bVar = new b();
        bVar.field_username = str;
        bVar.field_usernameHash = str.hashCode();
        boolean delete = super.delete(bVar, "usernameHash");
        AppMethodBeat.o(226390);
        return delete;
    }
}
