package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedHashMap;

public final class f extends MAutoStorage<e> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )"};
    public static LinkedHashMap<String, Class> wQE = new LinkedHashMap<String, Class>() {
        /* class com.tencent.mm.plugin.freewifi.g.f.AnonymousClass1 */

        {
            AppMethodBeat.i(24956);
            put("id", String.class);
            put("protocolNumber", Integer.TYPE);
            put("logContent", String.class);
            put("createTime", Long.TYPE);
            AppMethodBeat.o(24956);
        }
    };

    static {
        AppMethodBeat.i(24958);
        AppMethodBeat.o(24958);
    }

    public f(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, e.info, "FreeWifiLog", null);
    }

    public final boolean b(String str, int i2, String str2, long j2) {
        AppMethodBeat.i(24957);
        Log.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", str, Integer.valueOf(i2), str2, Long.valueOf(j2));
        if (m.eP(str)) {
            AppMethodBeat.o(24957);
            return false;
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiLog where id = '" + str + "'", new String[0]);
        try {
            e eVar = new e();
            eVar.field_id = str;
            eVar.field_protocolNumber = i2;
            eVar.field_logContent = str2;
            eVar.field_createTime = j2;
            if (rawQuery.getCount() == 0) {
                boolean insert = insert(eVar);
                Log.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret".concat(String.valueOf(insert)));
                return insert;
            }
            boolean update = update(eVar, new String[0]);
            Log.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret".concat(String.valueOf(update)));
            rawQuery.close();
            AppMethodBeat.o(24957);
            return update;
        } catch (Exception e2) {
            Log.e("MicroMsg.FreeWifi.FreeWifiLogStorage", m.m(e2));
            return false;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(24957);
        }
    }
}
