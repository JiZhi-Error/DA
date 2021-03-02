package com.tencent.mm.plugin.expt.roomexpt;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<e> {
    public static final String[] INDEX_CREATE = new String[0];
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "RoomMuteExpt"), "CREATE UNIQUE INDEX IF NOT EXISTS namedayIndex ON RoomMuteExpt( chatroom,daySec )"};
    ISQLiteDatabase db;

    static {
        AppMethodBeat.i(122425);
        AppMethodBeat.o(122425);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, e.info, "RoomMuteExpt", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.expt.roomexpt.e gz(java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.roomexpt.b.gz(java.lang.String, java.lang.String):com.tencent.mm.plugin.expt.roomexpt.e");
    }

    public final boolean b(e eVar) {
        AppMethodBeat.i(122421);
        boolean insertNotify = super.insertNotify(eVar, false);
        AppMethodBeat.o(122421);
        return insertNotify;
    }

    public final boolean c(e eVar) {
        AppMethodBeat.i(122422);
        if (eVar == null) {
            AppMethodBeat.o(122422);
            return false;
        }
        boolean updateNotify = super.updateNotify(eVar, false, "chatroom", "daySec");
        AppMethodBeat.o(122422);
        return updateNotify;
    }

    public final Cursor cRF() {
        Cursor cursor = null;
        AppMethodBeat.i(122423);
        try {
            cursor = this.db.rawQuery("SELECT chatroom, nickname, isMute, count(daySec), sum(score) FROM RoomMuteExpt group by chatroom", null);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e2, "get calc cursor", new Object[0]);
        }
        AppMethodBeat.o(122423);
        return cursor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.expt.roomexpt.e> cRG() {
        /*
            r11 = this;
            r10 = 122424(0x1de38, float:1.71553E-40)
            r8 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r10)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            com.tencent.mm.sdk.storage.ISQLiteDatabase r0 = r11.db     // Catch:{ Exception -> 0x005a, all -> 0x004d }
            java.lang.String r1 = "RoomMuteExpt"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "chatroom,daySec ASC"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x005a, all -> 0x004d }
            if (r1 == 0) goto L_0x0047
        L_0x001f:
            boolean r0 = r1.moveToNext()     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0047
            com.tencent.mm.plugin.expt.roomexpt.e r0 = new com.tencent.mm.plugin.expt.roomexpt.e     // Catch:{ Exception -> 0x0031 }
            r0.<init>()     // Catch:{ Exception -> 0x0031 }
            r0.convertFrom(r1)     // Catch:{ Exception -> 0x0031 }
            r9.add(r0)     // Catch:{ Exception -> 0x0031 }
            goto L_0x001f
        L_0x0031:
            r0 = move-exception
        L_0x0032:
            java.lang.String r2 = "MicroMsg.ChatRoomExptStorage"
            java.lang.String r3 = "getAllExpt"
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0058 }
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r2, r0, r3, r4)     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0043
            r1.close()
        L_0x0043:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            return r9
        L_0x0047:
            if (r1 == 0) goto L_0x0043
            r1.close()
            goto L_0x0043
        L_0x004d:
            r0 = move-exception
            r1 = r8
        L_0x004f:
            if (r1 == 0) goto L_0x0054
            r1.close()
        L_0x0054:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            throw r0
        L_0x0058:
            r0 = move-exception
            goto L_0x004f
        L_0x005a:
            r0 = move-exception
            r1 = r8
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.roomexpt.b.cRG():java.util.List");
    }
}
