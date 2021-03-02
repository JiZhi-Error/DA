package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public final class ar extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )"};
    public final h iFy;

    public ar(h hVar) {
        this.iFy = hVar;
    }

    public final aq vi(int i2) {
        aq aqVar = null;
        AppMethodBeat.i(131157);
        Cursor rawQuery = this.iFy.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = ".concat(String.valueOf(i2)), null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(131157);
        } else {
            if (rawQuery.moveToFirst()) {
                aqVar = new aq();
                aqVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(131157);
        }
        return aqVar;
    }

    public final boolean a(aq aqVar) {
        AppMethodBeat.i(131158);
        Assert.assertTrue(aqVar != null);
        ContentValues bos = aqVar.bos();
        if (bos.size() <= 0) {
            Log.e("MicroMsg.QQGroupStorage", "update failed, no values set");
            AppMethodBeat.o(131158);
            return false;
        }
        if (this.iFy.update("qqgroup", bos, "grouopid= ?", new String[]{new StringBuilder().append(aqVar.kfF).toString()}) <= 0) {
            AppMethodBeat.o(131158);
            return false;
        }
        doNotify();
        AppMethodBeat.o(131158);
        return true;
    }
}
