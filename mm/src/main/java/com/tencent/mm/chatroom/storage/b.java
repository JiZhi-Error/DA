package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS GroupBindAppUserNameIndex ON GroupBindApp ( chatRoomName )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "GroupBindApp")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(194053);
        AppMethodBeat.o(194053);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "GroupBindApp", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final dps DA(String str) {
        AppMethodBeat.i(194052);
        Cursor query = this.db.query("GroupBindApp", null, "chatRoomName =?", new String[]{str}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(194052);
            return null;
        }
        try {
            if (query.moveToNext()) {
                a aVar = new a();
                aVar.convertFrom(query);
                if (aVar.field_BindAppData == null || aVar.field_BindAppData.length > 0) {
                    dps dps = new dps();
                    dps.parseFrom(aVar.field_BindAppData);
                    query.close();
                    AppMethodBeat.o(194052);
                    return dps;
                }
                Log.i("MicroMsg.GroupBindAppStorage", "BindAppData is null");
                query.close();
                AppMethodBeat.o(194052);
                return null;
            }
            query.close();
            AppMethodBeat.o(194052);
            return null;
        } catch (Exception e2) {
            Log.i("MicroMsg.GroupBindAppStorage", e2.getMessage());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.o(194052);
            throw th;
        }
    }
}
