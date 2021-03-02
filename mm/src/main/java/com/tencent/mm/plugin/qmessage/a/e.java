package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public final class e extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) "};
    private h iFy;

    public e(h hVar) {
        this.iFy = hVar;
    }

    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(27723);
        Assert.assertTrue(str != null && str.length() > 0);
        if (dVar == null) {
            AppMethodBeat.o(27723);
            return false;
        }
        if (this.iFy.update("qcontact", dVar.convertTo(), "username=?", new String[]{str}) > 0) {
            AppMethodBeat.o(27723);
            return true;
        }
        AppMethodBeat.o(27723);
        return false;
    }

    public final d aKB(String str) {
        d dVar = null;
        AppMethodBeat.i(27724);
        Cursor rawQuery = this.iFy.rawQuery("select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(27724);
        } else {
            if (rawQuery.moveToFirst()) {
                dVar = new d();
                dVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(27724);
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        AppMethodBeat.i(27722);
        dVar.cSx = -1;
        if (((int) this.iFy.insert("qcontact", ch.COL_USERNAME, dVar.convertTo())) != -1) {
            AppMethodBeat.o(27722);
            return true;
        }
        AppMethodBeat.o(27722);
        return false;
    }
}
