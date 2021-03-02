package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;

public final class c extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "WebViewData")};

    static {
        AppMethodBeat.i(77855);
        AppMethodBeat.o(77855);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "WebViewData", null);
    }

    public static String gao() {
        AppMethodBeat.i(210816);
        String str = b.dTg() + "datastore/";
        AppMethodBeat.o(210816);
        return str;
    }

    public final void a(String str, String str2, String str3, String str4, long j2, String str5) {
        AppMethodBeat.i(77844);
        a aVar = new a();
        aVar.field_appId = str;
        aVar.field_appIdKey = lQ(str, str2);
        aVar.field_value = str3;
        aVar.field_weight = str4;
        aVar.field_expireTime = (System.currentTimeMillis() / 1000) + j2;
        aVar.field_size = (long) (str2.getBytes().length + str3.getBytes().length);
        aVar.field_timeStamp = System.currentTimeMillis() / 1000;
        aVar.field_localFile = str5;
        Log.d("MicroMsg.WebViewDataStorage", "setData: ".concat(String.valueOf(replace(aVar))));
        AppMethodBeat.o(77844);
    }

    public final long lO(String str, String str2) {
        long j2 = 0;
        AppMethodBeat.i(77845);
        Cursor rawQuery = rawQuery(String.format("select %s from %s where %s=\"%s\"", "size", "WebViewData", "appIdKey", lQ(str, str2)), new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(77845);
        } else {
            if (rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
            }
            rawQuery.close();
            AppMethodBeat.o(77845);
        }
        return j2;
    }

    public final a lN(String str, String str2) {
        AppMethodBeat.i(77846);
        Cursor lP = lP(str, str2);
        a aVar = new a();
        if (lP != null) {
            if (lP.moveToFirst()) {
                aVar.convertFrom(lP);
            }
            lP.close();
        }
        AppMethodBeat.o(77846);
        return aVar;
    }

    private Cursor lP(String str, String str2) {
        AppMethodBeat.i(77847);
        String format = String.format("select * from %s where %s=\"%s\"", "WebViewData", "appIdKey", lQ(str, str2));
        Log.d("MicroMsg.WebViewDataStorage", "getData: ".concat(String.valueOf(format)));
        Cursor rawQuery = rawQuery(format, new String[0]);
        AppMethodBeat.o(77847);
        return rawQuery;
    }

    public final void b(String str, JSONArray jSONArray) {
        AppMethodBeat.i(77848);
        if (Util.isNullOrNil(str) || jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(77848);
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(lQ(str, jSONArray.optString(i2)));
        }
        long j2 = 0;
        for (String str2 : arrayList) {
            a aVar = new a();
            aVar.field_appIdKey = str2;
            super.get(aVar, new String[0]);
            if (!Util.isNullOrNil(aVar.field_localFile)) {
                Log.i("MicroMsg.WebViewDataStorage", "clearData(), delete data file:%s, ret:%b", aVar.field_localFile, Boolean.valueOf(new o(gao() + aVar.field_localFile).delete()));
            }
            Log.i("MicroMsg.WebViewDataStorage", "clearData(), delete data appIdKey:%s, ret:%b", aVar.field_appIdKey, Boolean.valueOf(super.delete(aVar, new String[0])));
            j2 = aVar.field_size + j2;
        }
        long aXU = aXU(str) - j2;
        Log.i("MicroMsg.WebViewDataStorage", "clearData(), currSize:%d", Long.valueOf(aXU));
        if (aXU < 0) {
            aXU = 0;
        }
        by(str, aXU);
        AppMethodBeat.o(77848);
    }

    public final void aXT(String str) {
        AppMethodBeat.i(77849);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=\"%s\"", "WebViewData", "appId", str), new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    a aVar = new a();
                    aVar.convertFrom(rawQuery);
                    if (!Util.isNullOrNil(aVar.field_localFile)) {
                        Log.i("MicroMsg.WebViewDataStorage", "clearAllData(), delete data file:%s, ret:%b", aVar.field_localFile, Boolean.valueOf(new o(gao() + aVar.field_localFile).delete()));
                    }
                    Log.i("MicroMsg.WebViewDataStorage", "clearAllData(), delete data appIdKey:%s, ret:%b", aVar.field_appIdKey, Boolean.valueOf(super.delete(aVar, new String[0])));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        AppMethodBeat.o(77849);
    }

    public final void by(String str, long j2) {
        AppMethodBeat.i(77850);
        a aVar = new a();
        aVar.field_appId = str;
        aVar.field_appIdKey = bc(str, "###@@@@TOTAL@@@###SIZE####", "_");
        aVar.field_expireTime = MAlarmHandler.NEXT_FIRE_INTERVAL;
        aVar.field_size = j2;
        Log.d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", Boolean.valueOf(replace(aVar)), Long.valueOf(j2));
        AppMethodBeat.o(77850);
    }

    private static String bc(String str, String str2, String str3) {
        AppMethodBeat.i(77851);
        String str4 = str + str3 + str2;
        AppMethodBeat.o(77851);
        return str4;
    }

    public final long aXU(String str) {
        AppMethodBeat.i(77852);
        String format = String.format("select %s from %s where %s=\"%s\"", "size", "WebViewData", "appIdKey", bc(str, "###@@@@TOTAL@@@###SIZE####", "_"));
        Log.d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(format)));
        long j2 = 0;
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
            }
            rawQuery.close();
        }
        Log.d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(j2)));
        AppMethodBeat.o(77852);
        return j2;
    }

    public final long bz(String str, long j2) {
        long j3;
        AppMethodBeat.i(77853);
        String format = String.format("select * from %s where appId='%s' order by weight,timeStamp", "WebViewData", str);
        Log.d("MicroMsg.WebViewDataStorage", "deleteSize querySql: ".concat(String.valueOf(format)));
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(77853);
            return 0;
        }
        LinkedList<String> linkedList = new LinkedList();
        if (rawQuery.moveToFirst()) {
            long j4 = j2;
            do {
                String string = rawQuery.getString(1);
                long j5 = rawQuery.getLong(6);
                linkedList.add(string);
                j4 -= j5;
                if (!rawQuery.moveToNext()) {
                    break;
                }
            } while (j4 > 0);
            j3 = j4;
        } else {
            j3 = j2;
        }
        rawQuery.close();
        for (String str2 : linkedList) {
            a aVar = new a();
            aVar.field_appIdKey = str2;
            super.get(aVar, new String[0]);
            if (!Util.isNullOrNil(aVar.field_localFile)) {
                Log.i("MicroMsg.WebViewDataStorage", "deleteSize(), delete data file:%s, size:%d, ret:%b", aVar.field_localFile, Long.valueOf(aVar.field_size), Boolean.valueOf(new o(gao() + aVar.field_localFile).delete()));
            }
            Log.i("MicroMsg.WebViewDataStorage", "deleteSize(), delete data appIdKey:%s, size:%d, ret:%b", aVar.field_appIdKey, Long.valueOf(aVar.field_size), Boolean.valueOf(super.delete(aVar, new String[0])));
        }
        long j6 = j2 - j3;
        AppMethodBeat.o(77853);
        return j6;
    }

    private static String lQ(String str, String str2) {
        AppMethodBeat.i(77854);
        String str3 = str + "_" + str2;
        AppMethodBeat.o(77854);
        return str3;
    }
}
