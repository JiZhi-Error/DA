package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;

public final class h extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    com.tencent.mm.storagebase.h iFy;

    public h(com.tencent.mm.storagebase.h hVar) {
        this.iFy = hVar;
    }

    public final int a(String str, g gVar) {
        AppMethodBeat.i(150281);
        ContentValues convertTo = gVar.convertTo();
        int update = this.iFy.update("hdheadimginfo", convertTo, "username=?", new String[]{str});
        AppMethodBeat.o(150281);
        return update;
    }

    public final g Mu(String str) {
        g gVar = null;
        AppMethodBeat.i(150282);
        Cursor rawQuery = this.iFy.rawQuery("select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(150282);
        } else {
            if (rawQuery.moveToFirst()) {
                gVar = new g();
                gVar.username = rawQuery.getString(0);
                gVar.iKM = rawQuery.getInt(1);
                gVar.iKN = rawQuery.getInt(2);
                gVar.iKO = rawQuery.getString(3);
                gVar.iKP = rawQuery.getInt(4);
                gVar.bNu = rawQuery.getInt(5);
                gVar.iKQ = rawQuery.getInt(6);
                gVar.iKR = rawQuery.getString(7);
                gVar.iKS = rawQuery.getString(8);
                gVar.iKT = rawQuery.getInt(9);
                gVar.iKU = rawQuery.getInt(10);
            }
            rawQuery.close();
            AppMethodBeat.o(150282);
        }
        return gVar;
    }
}
