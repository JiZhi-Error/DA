package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends MAutoStorage<e> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "GameHaowanPublishEdition")};

    static {
        AppMethodBeat.i(40975);
        AppMethodBeat.o(40975);
    }

    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, e.info, "GameHaowanPublishEdition", null);
    }

    public final e azX(String str) {
        e eVar = null;
        AppMethodBeat.i(40968);
        String format = String.format("select * from %s where %s=\"%s\"", "GameHaowanPublishEdition", "taskId", str);
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "query, sql : %s", format);
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(40968);
        } else {
            if (rawQuery.moveToNext()) {
                eVar = new e();
                eVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(40968);
        }
        return eVar;
    }

    public final boolean ef(String str, int i2) {
        AppMethodBeat.i(40969);
        String format = String.format("update %s set %s=%d where %s=\"%s\"", "GameHaowanPublishEdition", "mixState", Integer.valueOf(i2), "taskId", str);
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateMixState, sql : %s", format);
        boolean execSQL = execSQL("GameHaowanPublishEdition", format);
        AppMethodBeat.o(40969);
        return execSQL;
    }

    public final boolean eg(String str, int i2) {
        AppMethodBeat.i(40970);
        String format = String.format("update %s set %s=%d where %s=\"%s\"", "GameHaowanPublishEdition", "uploadState", Integer.valueOf(i2), "taskId", str);
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateMediaUploadState, sql : %s", format);
        boolean execSQL = execSQL("GameHaowanPublishEdition", format);
        AppMethodBeat.o(40970);
        return execSQL;
    }

    public final boolean azY(String str) {
        AppMethodBeat.i(40971);
        String format = String.format("update %s set %s=%d where %s=\"%s\"", "GameHaowanPublishEdition", "publishState", 1, "taskId", str);
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updatePublishState, sql : %s", format);
        boolean execSQL = execSQL("GameHaowanPublishEdition", format);
        AppMethodBeat.o(40971);
        return execSQL;
    }

    public final LinkedList<e> dUk() {
        AppMethodBeat.i(40972);
        String format = String.format("select * from %s where %s<>%d", "GameHaowanPublishEdition", "publishState", 2);
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAllNotFinished, sql : %s", format);
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(40972);
            return null;
        }
        LinkedList<e> linkedList = new LinkedList<>();
        while (rawQuery.moveToNext()) {
            e eVar = new e();
            eVar.convertFrom(rawQuery);
            linkedList.add(eVar);
        }
        rawQuery.close();
        AppMethodBeat.o(40972);
        return linkedList;
    }

    public final LinkedList<e> aS(LinkedList<String> linkedList) {
        AppMethodBeat.i(40973);
        String format = String.format("select * from %s where %s in %s", "GameHaowanPublishEdition", "taskId", c.aY(linkedList));
        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchQuery, sql : %s", format);
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(40973);
            return null;
        }
        LinkedList<e> linkedList2 = new LinkedList<>();
        while (rawQuery.moveToNext()) {
            e eVar = new e();
            eVar.convertFrom(rawQuery);
            linkedList2.add(eVar);
        }
        rawQuery.close();
        AppMethodBeat.o(40973);
        return linkedList2;
    }

    public final void aR(LinkedList<String> linkedList) {
        AppMethodBeat.i(40974);
        LinkedList<e> aS = aS(linkedList);
        if (aS != null) {
            Iterator<e> it = aS.iterator();
            while (it.hasNext()) {
                ((f) com.tencent.mm.kernel.g.af(f.class)).dSO().aR(c.aAL(it.next().field_localIdList));
            }
            String format = String.format("delete from %s where %s in %s", "GameHaowanPublishEdition", "taskId", c.aY(linkedList));
            Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "batchDelete, sql : %s", format);
            execSQL("GameHaowanPublishEdition", format);
        }
        AppMethodBeat.o(40974);
    }
}
