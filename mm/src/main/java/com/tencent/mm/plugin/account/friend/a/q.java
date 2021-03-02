package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public final class q extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    private h iFy;

    public q(h hVar) {
        this.iFy = hVar;
    }

    private boolean a(p pVar) {
        AppMethodBeat.i(131063);
        if (pVar == null) {
            AppMethodBeat.o(131063);
            return false;
        }
        pVar.cSx = -1;
        if (((int) this.iFy.insert("invitefriendopen", ch.COL_USERNAME, pVar.convertTo())) != -1) {
            AppMethodBeat.o(131063);
            return true;
        }
        AppMethodBeat.o(131063);
        return false;
    }

    public final boolean b(p pVar) {
        AppMethodBeat.i(131064);
        if (Tf(pVar.getUsername())) {
            boolean c2 = c(pVar);
            AppMethodBeat.o(131064);
            return c2;
        }
        boolean a2 = a(pVar);
        AppMethodBeat.o(131064);
        return a2;
    }

    public final boolean Tf(String str) {
        AppMethodBeat.i(131066);
        Cursor rawQuery = this.iFy.rawQuery("select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        AppMethodBeat.o(131066);
        return moveToFirst;
    }

    private boolean c(p pVar) {
        AppMethodBeat.i(131065);
        pVar.cSx = -1;
        ContentValues convertTo = pVar.convertTo();
        if (this.iFy.update("invitefriendopen", convertTo, "username=?", new String[]{pVar.getUsername()}) > 0) {
            AppMethodBeat.o(131065);
            return true;
        }
        AppMethodBeat.o(131065);
        return false;
    }
}
