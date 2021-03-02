package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public final class b extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public h iFy;

    public b(h hVar) {
        this.iFy = hVar;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(150788);
        Assert.assertTrue(aVar != null);
        ContentValues convertTo = aVar.convertTo();
        if (convertTo.size() > 0) {
            if (this.iFy.update("chattingbginfo", convertTo, "username= ?", new String[]{aVar.getUsername()}) > 0) {
                doNotify(aVar.getUsername());
                AppMethodBeat.o(150788);
                return true;
            }
        }
        AppMethodBeat.o(150788);
        return false;
    }

    public final a Pp(String str) {
        a aVar = null;
        AppMethodBeat.i(150789);
        Cursor rawQuery = this.iFy.rawQuery("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(150789);
        } else {
            if (rawQuery.moveToFirst()) {
                aVar = new a();
                aVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(150789);
        }
        return aVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(150787);
        aVar.cSx = -1;
        if (((int) this.iFy.insert("chattingbginfo", ch.COL_USERNAME, aVar.convertTo())) != -1) {
            doNotify(aVar.getUsername());
            AppMethodBeat.o(150787);
            return true;
        }
        AppMethodBeat.o(150787);
        return false;
    }
}
