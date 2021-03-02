package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import junit.framework.Assert;

public final class h extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) "};
    public com.tencent.mm.storagebase.h iFy;

    public h(com.tencent.mm.storagebase.h hVar) {
        this.iFy = hVar;
    }

    public final Cursor SY(String str) {
        AppMethodBeat.i(130996);
        StringBuilder sb = new StringBuilder();
        if (str != null && str.length() > 0) {
            sb.append(" where ( ");
            sb.append("facebookfriend.fbname like '%" + str + "%' or ");
            sb.append("facebookfriend.nickname like '%" + str + "%' or ");
            sb.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        Cursor rawQuery = this.iFy.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + sb.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null);
        AppMethodBeat.o(130996);
        return rawQuery;
    }

    public final boolean a(g gVar) {
        boolean z;
        AppMethodBeat.i(130997);
        if (gVar.cSx == -1) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue("Func Set always conv_flag == flag_all", z);
        Cursor rawQuery = this.iFy.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + Util.escapeSqlValue(String.valueOf(gVar.fuC)) + "\"", null, 2);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        if (!moveToFirst) {
            gVar.cSx = -1;
            if (((int) this.iFy.insert("facebookfriend", "fbid", gVar.convertTo())) != -1) {
                AppMethodBeat.o(130997);
                return true;
            }
            AppMethodBeat.o(130997);
            return false;
        }
        int update = this.iFy.update("facebookfriend", gVar.convertTo(), "fbid=?", new String[]{new StringBuilder().append(gVar.fuC).toString()});
        if (update > 0) {
            doNotify();
        }
        if (update > 0) {
            AppMethodBeat.o(130997);
            return true;
        }
        AppMethodBeat.o(130997);
        return false;
    }

    public final boolean bnU() {
        AppMethodBeat.i(130998);
        boolean execSQL = this.iFy.execSQL("facebookfriend", "delete from facebookfriend");
        AppMethodBeat.o(130998);
        return execSQL;
    }
}
