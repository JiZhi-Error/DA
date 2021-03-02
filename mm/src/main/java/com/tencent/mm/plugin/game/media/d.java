package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "GameHaowanMedia")};

    static {
        AppMethodBeat.i(40950);
        AppMethodBeat.o(40950);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "GameHaowanMedia", null);
    }

    public final c azV(String str) {
        c cVar = null;
        AppMethodBeat.i(40947);
        String format = String.format("select * from %s where %s=\"%s\"", "GameHaowanMedia", ch.COL_LOCALID, str);
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "get, sql: ".concat(String.valueOf(format)));
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(40947);
        } else {
            if (rawQuery.moveToNext()) {
                cVar = new c();
                cVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(40947);
        }
        return cVar;
    }

    public final Map<String, c> aQ(LinkedList<String> linkedList) {
        AppMethodBeat.i(40948);
        String format = String.format("select * from %s where %s in %s", "GameHaowanMedia", ch.COL_LOCALID, c.aY(linkedList));
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchGet, sql: ".concat(String.valueOf(format)));
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(40948);
            return null;
        }
        HashMap hashMap = new HashMap();
        while (rawQuery.moveToNext()) {
            c cVar = new c();
            cVar.convertFrom(rawQuery);
            hashMap.put(cVar.field_localId, cVar);
        }
        rawQuery.close();
        AppMethodBeat.o(40948);
        return hashMap;
    }

    public final void aR(LinkedList<String> linkedList) {
        final LinkedList linkedList2;
        AppMethodBeat.i(40949);
        String format = String.format("select * from %s where %s in %s", "GameHaowanMedia", ch.COL_LOCALID, c.aY(linkedList));
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchGet, sql: ".concat(String.valueOf(format)));
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            linkedList2 = null;
        } else {
            linkedList2 = new LinkedList();
            while (rawQuery.moveToNext()) {
                c cVar = new c();
                cVar.convertFrom(rawQuery);
                linkedList2.add(cVar);
            }
            rawQuery.close();
        }
        if (!Util.isNullOrNil(linkedList2)) {
            a.post(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(40946);
                    for (c cVar : linkedList2) {
                        if (cVar != null) {
                            b.remove(cVar.field_filePath);
                            b.remove(cVar.field_thumbPath);
                            b.remove(cVar.field_compressPath);
                        }
                    }
                    AppMethodBeat.o(40946);
                }
            });
        }
        String format2 = String.format("delete from %s where %s in %s", "GameHaowanMedia", ch.COL_LOCALID, c.aY(linkedList));
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchDelete, sql: ".concat(String.valueOf(format2)));
        execSQL("GameHaowanMedia", format2);
        AppMethodBeat.o(40949);
    }
}
