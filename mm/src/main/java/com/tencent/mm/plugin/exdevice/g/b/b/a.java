package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.exdevice.g.b.a.c;
import com.tencent.mm.plugin.exdevice.g.b.b;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class a extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "HardDeviceRankFollowInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(23570);
        AppMethodBeat.o(23570);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "HardDeviceRankFollowInfo", null);
        AppMethodBeat.i(23558);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
        AppMethodBeat.o(23558);
    }

    public final c a(b bVar) {
        AppMethodBeat.i(23559);
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", "HardDeviceRankFollowInfo", "rankID", ch.COL_USERNAME, "appusername");
        Cursor rawQuery = this.db.rawQuery(format, new String[]{Util.nullAs(bVar.rCB, ""), Util.nullAs(bVar.username, ""), Util.nullAs(bVar.appName, "")}, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
            AppMethodBeat.o(23559);
            return null;
        }
        c cVar = null;
        if (rawQuery.moveToFirst()) {
            cVar = new c();
            cVar.convertFrom(rawQuery);
        } else {
            Log.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
        }
        rawQuery.close();
        AppMethodBeat.o(23559);
        return cVar;
    }

    public final boolean anD(String str) {
        AppMethodBeat.i(23560);
        boolean Y = Y("hardcode_rank_id", "hardcode_app_name", str);
        AppMethodBeat.o(23560);
        return Y;
    }

    private boolean Y(String str, String str2, String str3) {
        AppMethodBeat.i(23561);
        String format = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", "HardDeviceRankFollowInfo", "rankID", "appusername", ch.COL_USERNAME);
        Cursor rawQuery = this.db.rawQuery(format, new String[]{Util.nullAs(str, ""), Util.nullAs(str2, ""), Util.nullAs(str3, "")}, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
            AppMethodBeat.o(23561);
            return false;
        }
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        Log.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", Boolean.valueOf(moveToFirst));
        AppMethodBeat.o(23561);
        return moveToFirst;
    }

    public final ArrayList<c> cKZ() {
        ArrayList<c> arrayList = null;
        AppMethodBeat.i(23562);
        String format = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", "HardDeviceRankFollowInfo", "rankID", "appusername");
        Cursor rawQuery = this.db.rawQuery(format, new String[]{"hardcode_rank_id", "hardcode_app_name"}, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
            AppMethodBeat.o(23562);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList<>();
                do {
                    c cVar = new c();
                    cVar.convertFrom(rawQuery);
                    Log.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", Integer.valueOf(rawQuery.getColumnIndex("rowid")), cVar.toString());
                    arrayList.add(cVar);
                } while (rawQuery.moveToNext());
                Log.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", Integer.valueOf(arrayList.size()), arrayList.toString());
            } else {
                Log.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            rawQuery.close();
            AppMethodBeat.o(23562);
        }
        return arrayList;
    }

    public final void a(ArrayList<bes> arrayList, String str, String str2) {
        AppMethodBeat.i(23563);
        if (arrayList != null) {
            Iterator<bes> it = arrayList.iterator();
            while (it.hasNext()) {
                bes next = it.next();
                c cVar = new c();
                cVar.field_rankID = str;
                cVar.field_step = next.lCq;
                cVar.field_username = next.username;
                cVar.field_appusername = str2;
                a(cVar);
            }
        }
        AppMethodBeat.o(23563);
    }

    public final void dn(List<c> list) {
        AppMethodBeat.i(23564);
        if (Util.isNullOrNil("hardcode_rank_id") || Util.isNullOrNil("hardcode_app_name")) {
            Log.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
        } else {
            Log.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", "hardcode_rank_id", "hardcode_app_name", Integer.valueOf(this.db.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[]{"hardcode_rank_id", "hardcode_app_name"})));
        }
        if (list != null) {
            for (c cVar : list) {
                cVar.field_rankID = "hardcode_rank_id";
                cVar.field_appusername = "hardcode_app_name";
                a(cVar);
            }
        }
        AppMethodBeat.o(23564);
    }

    private boolean a(c cVar) {
        AppMethodBeat.i(23565);
        if (b(cVar)) {
            AppMethodBeat.o(23565);
        } else {
            c(cVar);
            AppMethodBeat.o(23565);
        }
        return true;
    }

    public final boolean anE(String str) {
        AppMethodBeat.i(23566);
        boolean Z = Z("hardcode_rank_id", "hardcode_app_name", str);
        AppMethodBeat.o(23566);
        return Z;
    }

    private boolean Z(String str, String str2, String str3) {
        AppMethodBeat.i(23567);
        c a2 = a(new b(str, str2, str3));
        if (a2 != null) {
            delete(a2, "rankID", "appusername", ch.COL_USERNAME);
            Log.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            AppMethodBeat.o(23567);
            return true;
        }
        AppMethodBeat.o(23567);
        return false;
    }

    private boolean b(c cVar) {
        AppMethodBeat.i(23568);
        Assert.assertTrue(cVar != null);
        c a2 = a(new b(cVar.field_rankID, cVar.field_appusername, cVar.field_username));
        if (a2 != null) {
            a2.field_step = cVar.field_step;
            update(a2, "rankID", "appusername", ch.COL_USERNAME);
            Log.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            AppMethodBeat.o(23568);
            return true;
        }
        AppMethodBeat.o(23568);
        return false;
    }

    private boolean c(c cVar) {
        AppMethodBeat.i(23569);
        Assert.assertTrue(cVar != null);
        insert(cVar);
        Log.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
        AppMethodBeat.o(23569);
        return true;
    }
}
