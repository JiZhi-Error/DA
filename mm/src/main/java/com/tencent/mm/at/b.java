package com.tencent.mm.at;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public final class b extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    h iFy;

    public b(h hVar) {
        this.iFy = hVar;
    }

    public final boolean On(String str) {
        AppMethodBeat.i(20515);
        if (this.iFy.delete("getcontactinfov2", "username= ?", new String[]{String.valueOf(str)}) > 0) {
            doNotify(str);
            AppMethodBeat.o(20515);
            return true;
        }
        AppMethodBeat.o(20515);
        return false;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(20514);
        aVar.cSx = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.cSx & 1) != 0) {
            contentValues.put(ch.COL_USERNAME, aVar.getUsername());
        }
        if ((aVar.cSx & 2) != 0) {
            contentValues.put("inserttime", Long.valueOf(aVar.iWh));
        }
        if ((aVar.cSx & 4) != 0) {
            contentValues.put("type", Integer.valueOf(aVar.type));
        }
        if ((aVar.cSx & 8) != 0) {
            contentValues.put("lastgettime", Integer.valueOf(aVar.iWi));
        }
        if ((aVar.cSx & 16) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.iFr));
        }
        if ((aVar.cSx & 32) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.iWj));
        }
        if ((aVar.cSx & 64) != 0) {
            contentValues.put("reserved3", aVar.bci());
        }
        if ((aVar.cSx & 128) != 0) {
            contentValues.put("reserved4", aVar.aWe());
        }
        if (((int) this.iFy.replace("getcontactinfov2", ch.COL_USERNAME, contentValues)) != -1) {
            doNotify(aVar.getUsername());
            AppMethodBeat.o(20514);
            return true;
        }
        AppMethodBeat.o(20514);
        return false;
    }
}
