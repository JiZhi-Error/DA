package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class l extends MAutoStorage<k> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(k.info, "IPCallRecord")};
    static final String[] ysL = {"*", "rowid"};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(25562);
        AppMethodBeat.o(25562);
    }

    public l(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, k.info, "IPCallRecord", null);
        this.db = iSQLiteDatabase;
    }

    public final Cursor aBZ(String str) {
        AppMethodBeat.i(25558);
        Cursor query = this.db.query("IPCallRecord", ysL, "phonenumber=?", new String[]{str}, null, null, "calltime desc limit 4");
        AppMethodBeat.o(25558);
        return query;
    }

    public final Cursor aCa(String str) {
        AppMethodBeat.i(25559);
        Cursor query = this.db.query("IPCallRecord", ysL, "phonenumber=?", new String[]{str}, null, null, "calltime desc");
        AppMethodBeat.o(25559);
        return query;
    }

    public final Cursor GT(long j2) {
        AppMethodBeat.i(25560);
        Cursor query = this.db.query("IPCallRecord", ysL, "addressId=?", new String[]{String.valueOf(j2)}, null, null, "calltime desc");
        AppMethodBeat.o(25560);
        return query;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(25561);
        if (kVar != null) {
            update(kVar.systemRowid, kVar);
        }
        AppMethodBeat.o(25561);
    }
}
