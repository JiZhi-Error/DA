package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "FreeWifiConfig"), "CREATE INDEX IF NOT EXISTS idx_freewificonfig_key  on FreeWifiConfig  (  key )"};
    public static Map<String, String> wQD = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(24948);
        AppMethodBeat.o(24948);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "FreeWifiConfig", null);
    }

    public final String dNM() {
        AppMethodBeat.i(24944);
        StringBuilder sb = new StringBuilder();
        sb.append("key\tvalue\tmodifyTime\r\n");
        Cursor rawQuery = rawQuery("select key, value, modifyTime from FreeWifiConfig", new String[0]);
        while (rawQuery.moveToNext()) {
            try {
                sb.append(rawQuery.getString(0)).append("\t").append(rawQuery.getString(1)).append("\t").append(rawQuery.getLong(2)).append(APLogFileUtil.SEPARATOR_LINE);
            } catch (Exception e2) {
                Log.i("MicroMsg.FreeWifi.FreeWifiConfigStorage", "FreeWifiConfig Table :\r\n" + e2.getMessage());
                return e2.getMessage();
            } finally {
                rawQuery.close();
                AppMethodBeat.o(24944);
            }
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiConfigStorage", "FreeWifiConfig Table :\r\n" + sb.toString());
        return sb.toString();
    }

    public final String axY(String str) {
        String str2;
        AppMethodBeat.i(24945);
        if (m.eP(str)) {
            AppMethodBeat.o(24945);
            return "";
        }
        try {
            if (!(wQD == null || (str2 = wQD.get(str)) == null)) {
                AppMethodBeat.o(24945);
                return str2;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map get error!");
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiConfig where key = '" + str + "'", new String[0]);
        if (rawQuery == null) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(24945);
            return "";
        }
        try {
            if (rawQuery.moveToFirst()) {
                a aVar = new a();
                aVar.convertFrom(rawQuery);
                return aVar.field_value;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(24945);
            return "";
        } finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(24945);
        }
    }

    public final void hv(String str, String str2) {
        AppMethodBeat.i(24946);
        if (m.eP(str) || m.eP(str2)) {
            AppMethodBeat.o(24946);
            return;
        }
        try {
            if (wQD != null) {
                if (wQD.size() < 1000) {
                    wQD.put(str, str2);
                } else {
                    wQD.clear();
                    wQD.put(str, str2);
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map put error!");
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiConfig where key = '" + str + "'", new String[0]);
        try {
            a aVar = new a();
            aVar.field_key = str;
            aVar.field_value = str2;
            aVar.field_modifyTime = System.currentTimeMillis();
            if (rawQuery.getCount() == 0) {
                insert(aVar);
            } else {
                update(aVar, new String[0]);
            }
        } finally {
            rawQuery.close();
            AppMethodBeat.o(24946);
        }
    }

    public final void byC() {
        AppMethodBeat.i(24947);
        if (wQD != null) {
            wQD.clear();
        }
        super.execSQL("FreeWifiConfig", "delete from FreeWifiConfig");
        AppMethodBeat.o(24947);
    }
}
