package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d extends MAutoStorage<c> {
    public static final String[] INDEX_CREATE = {"DROP INDEX IF EXISTS statusIndex", "CREATE INDEX IF NOT EXISTS msgInfoIdIndex ON appattach ( msgInfoId )", "CREATE INDEX IF NOT EXISTS appattach_statusIndex ON appattach ( status )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "appattach")};
    ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(c cVar, String[] strArr) {
        AppMethodBeat.i(151656);
        boolean a2 = a(cVar, strArr);
        AppMethodBeat.o(151656);
        return a2;
    }

    static {
        AppMethodBeat.i(151657);
        AppMethodBeat.o(151657);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "appattach", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final void Mo(long j2) {
        AppMethodBeat.i(151652);
        this.db.execSQL("appattach", " update appattach set status = 198 , lastModifyTime = " + Util.nowSecond() + " where rowid = " + j2);
        doNotify();
        AppMethodBeat.o(151652);
    }

    public final c bdx(String str) {
        AppMethodBeat.i(151653);
        c cVar = new c();
        cVar.field_mediaSvrId = str;
        if (get(cVar, "mediaSvrId")) {
            AppMethodBeat.o(151653);
            return cVar;
        }
        if (get(cVar, "mediaId")) {
            AppMethodBeat.o(151653);
            return cVar;
        }
        AppMethodBeat.o(151653);
        return null;
    }

    public final boolean a(c cVar, String... strArr) {
        AppMethodBeat.i(151654);
        boolean update = super.update(cVar, strArr);
        Log.d("MicroMsg.AppAttachInfoStorage", "update AppAttachInfo field_mediaId %s field_mediaSvrId %s ret %s %s", cVar.field_mediaId, cVar.field_mediaSvrId, Boolean.valueOf(update), "");
        AppMethodBeat.o(151654);
        return update;
    }

    public final c Mp(long j2) {
        AppMethodBeat.i(151655);
        c cVar = new c();
        cVar.field_msgInfoId = j2;
        if (get(cVar, "msgInfoId")) {
            AppMethodBeat.o(151655);
            return cVar;
        }
        AppMethodBeat.o(151655);
        return null;
    }
}
