package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;

public final class aa {
    public boolean EmY = false;

    public static boolean a(h hVar, h hVar2) {
        AppMethodBeat.i(97648);
        try {
            if (Util.isNullOrNil(hVar.getKey())) {
                hVar2.execSQL("", "ATTACH DATABASE '" + hVar.getPath() + "' AS old ");
            } else {
                hVar2.execSQL("", "ATTACH DATABASE '" + hVar.getPath() + "' AS old KEY '" + hVar.getKey() + "'");
            }
            Log.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + hVar.getKey());
            AppMethodBeat.o(97648);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.TrimSnsDb", e2, "", new Object[0]);
            AppMethodBeat.o(97648);
            return false;
        }
    }

    public static int a(h hVar, h hVar2, String str) {
        String str2 = null;
        AppMethodBeat.i(97649);
        Cursor rawQuery = hVar.rawQuery(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null);
        if (rawQuery != null) {
            if (rawQuery.getCount() == 1) {
                rawQuery.moveToFirst();
                str2 = rawQuery.getString(0);
            }
            rawQuery.close();
        }
        if (str2 == null) {
            Log.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
            AppMethodBeat.o(97649);
            return -1;
        }
        Log.i("MicroMsg.TrimSnsDb", "create sql %s", str2);
        Log.i("MicroMsg.TrimSnsDb", "create result ".concat(String.valueOf(hVar2.execSQL("", str2))));
        AppMethodBeat.o(97649);
        return 1;
    }

    public static void aQM(String str) {
        AppMethodBeat.i(97650);
        Iterable<e> dC = s.dC(str, false);
        if (dC == null) {
            AppMethodBeat.o(97650);
            return;
        }
        for (e eVar : dC) {
            if (!eVar.RbJ && eVar.name.startsWith("SnsMicroMsg.dberr")) {
                Log.i("MicroMsg.TrimSnsDb", "find error %s", str + eVar.name);
                eVar.hdW();
            }
        }
        AppMethodBeat.o(97650);
    }
}
