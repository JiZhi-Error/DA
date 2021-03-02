package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;

public final class at extends MStorageEx {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS qqlist ( qq long  PRIMARY KEY , wexinstatus int  , groupid int  , username text  , nickname text  , pyinitial text  , quanpin text  , qqnickname text  , qqpyinitial text  , qqquanpin text  , qqremark text  , qqremarkpyinitial text  , qqremarkquanpin text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE INDEX IF NOT EXISTS groupid_index ON qqlist ( groupid ) ", "CREATE INDEX IF NOT EXISTS qq_index ON qqlist ( qq ) "};
    public final h iFy;

    public at(h hVar) {
        this.iFy = hVar;
    }

    public final Cursor J(int i2, boolean z) {
        String str;
        String[] strArr;
        AppMethodBeat.i(131164);
        if (z) {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=?  order by reserved3";
            strArr = new String[]{String.valueOf(i2)};
        } else {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=? and (wexinstatus=? or wexinstatus=?) order by reserved3";
            strArr = new String[]{String.valueOf(i2), "1", "2"};
        }
        Cursor rawQuery = this.iFy.rawQuery(str, strArr);
        AppMethodBeat.o(131164);
        return rawQuery;
    }

    public final Cursor b(int i2, String str, boolean z) {
        AppMethodBeat.i(131165);
        Log.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i2 + ", searchby:" + str);
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i2 + "\" and ( ");
        } else {
            sb.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i2 + "\" and (wexinstatus =\"1\" or wexinstatus =\"2" + "\") and ( ");
        }
        sb.append("qqlist.qq like '%" + str + "%' or ");
        sb.append("qqlist.username like '%" + str + "%' or ");
        sb.append("qqlist.nickname like '%" + str + "%' or ");
        sb.append("qqlist.pyinitial like '%" + str + "%' or ");
        sb.append("qqlist.quanpin like '%" + str + "%' or ");
        sb.append("qqlist.qqnickname like '%" + str + "%' or ");
        sb.append("qqlist.qqpyinitial like '%" + str + "%' or ");
        sb.append("qqlist.qqquanpin like '%" + str + "%' or ");
        sb.append("qqlist.qqremark like '%" + str + "%' )");
        sb.append(" order by reserved3");
        Cursor rawQuery = this.iFy.rawQuery(sb.toString(), null);
        AppMethodBeat.o(131165);
        return rawQuery;
    }

    public final as AT(long j2) {
        as asVar = null;
        AppMethodBeat.i(131166);
        Cursor rawQuery = this.iFy.rawQuery("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.qq = \"" + j2 + "\"", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(131166);
        } else {
            if (rawQuery.moveToFirst()) {
                asVar = new as();
                asVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(131166);
        }
        return asVar;
    }

    public final as Tg(String str) {
        as asVar = null;
        AppMethodBeat.i(131167);
        Cursor rawQuery = this.iFy.rawQuery("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.username = \"" + str + "\"", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(131167);
        } else {
            if (rawQuery.moveToFirst()) {
                asVar = new as();
                asVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(131167);
        }
        return asVar;
    }

    public final int a(long j2, as asVar) {
        int i2 = 0;
        AppMethodBeat.i(131168);
        ContentValues bov = asVar.bov();
        if (bov.size() > 0) {
            i2 = this.iFy.update("qqlist", bov, "qq=?", new String[]{String.valueOf(j2)});
        }
        if (i2 > 0) {
            doNotify(3, this, String.valueOf(j2));
        }
        AppMethodBeat.o(131168);
        return i2;
    }

    public final boolean a(as asVar) {
        AppMethodBeat.i(131169);
        if (asVar == null) {
            AppMethodBeat.o(131169);
            return false;
        }
        Log.d("MicroMsg.QQListStorage", "insert: name:" + asVar.bow());
        asVar.cSx = -1;
        if (((int) this.iFy.insert("qqlist", "qq", asVar.bov())) != -1) {
            doNotify(2, this, new StringBuilder().append(asVar.kfN).toString());
            AppMethodBeat.o(131169);
            return true;
        }
        AppMethodBeat.o(131169);
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx
    public final boolean shouldProcessEvent() {
        AppMethodBeat.i(131170);
        if (this.iFy == null || this.iFy.isClose()) {
            Object[] objArr = new Object[1];
            objArr[0] = this.iFy == null ? BuildConfig.COMMAND : Boolean.valueOf(this.iFy.isClose());
            Log.w("MicroMsg.QQListStorage", "shouldProcessEvent db is close :%s", objArr);
            AppMethodBeat.o(131170);
            return false;
        }
        AppMethodBeat.o(131170);
        return true;
    }

    public final boolean vj(int i2) {
        boolean z = false;
        AppMethodBeat.i(131171);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.iFy.rawQuery("select reserved3 from qqlist where groupid=? and reserved3=?  limit 1", new String[]{String.valueOf(i2), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                z = true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.QQListStorage", "[cpan] check qq list show head faild.:%s", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(131171);
            throw th;
        }
        AppMethodBeat.o(131171);
        return z;
    }
}
