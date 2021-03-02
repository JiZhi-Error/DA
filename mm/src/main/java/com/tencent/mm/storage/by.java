package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;

public final class by extends MAutoStorage<bx> implements g {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(bx.info, "LBSVerifyMessage")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(bx bxVar) {
        AppMethodBeat.i(117185);
        boolean a2 = a(bxVar);
        AppMethodBeat.o(117185);
        return a2;
    }

    static {
        AppMethodBeat.i(117186);
        AppMethodBeat.o(117186);
    }

    public by(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, bx.info, "LBSVerifyMessage", eb.INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.g
    public final int ctM() {
        AppMethodBeat.i(117172);
        Cursor rawQuery = this.db.rawQuery("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(117172);
            return 0;
        }
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        AppMethodBeat.o(117172);
        return i2;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final int getCount() {
        int i2 = 0;
        AppMethodBeat.i(117173);
        Cursor rawQuery = this.db.rawQuery("select count(*) from " + getTableName(), null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(117173);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.g
    public final bx eiG() {
        AppMethodBeat.i(117174);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(117174);
            return null;
        } else if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(117174);
            return null;
        } else {
            bx bxVar = new bx();
            bxVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(117174);
            return bxVar;
        }
    }

    public final Cursor Pf(int i2) {
        AppMethodBeat.i(117175);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + i2, null);
        AppMethodBeat.o(117175);
        return rawQuery;
    }

    public final Cursor akl(int i2) {
        AppMethodBeat.i(117176);
        Cursor rawQuery = this.db.rawQuery("SELECT a.* FROM (" + ("SELECT sayhiencryptuser,max(createtime) createtime FROM " + getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i2) + ") b left join " + getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i2, null);
        AppMethodBeat.o(117176);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.g
    public final void aEp(String str) {
        AppMethodBeat.i(117177);
        int delete = this.db.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        Log.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(delete)));
        AppMethodBeat.o(117177);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.g
    public final void aEq(String str) {
        AppMethodBeat.i(117178);
        int delete = this.db.delete(getTableName(), "sayhiuser = '" + str + "' or sayhiencryptuser='" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        Log.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = ".concat(String.valueOf(delete)));
        AppMethodBeat.o(117178);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.g
    public final void byC() {
        AppMethodBeat.i(117179);
        this.db.delete(getTableName(), null, null);
        AppMethodBeat.o(117179);
    }

    public final boolean a(bx bxVar) {
        AppMethodBeat.i(117180);
        if (bxVar == null) {
            Log.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
            AppMethodBeat.o(117180);
            return false;
        } else if (super.insert(bxVar)) {
            doNotify(new StringBuilder().append(bxVar.systemRowid).toString());
            AppMethodBeat.o(117180);
            return true;
        } else {
            AppMethodBeat.o(117180);
            return false;
        }
    }

    public final bx[] bkx(String str) {
        AppMethodBeat.i(117181);
        Log.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
        Cursor rawQuery = this.db.rawQuery("select *, rowid from LBSVerifyMessage  where sayhiuser = '" + Util.escapeSqlValue(str) + "' or sayhiencryptuser = '" + Util.escapeSqlValue(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            bx bxVar = new bx();
            bxVar.convertFrom(rawQuery);
            arrayList.add(bxVar);
        }
        rawQuery.close();
        bx[] bxVarArr = (bx[]) arrayList.toArray(new bx[arrayList.size()]);
        AppMethodBeat.o(117181);
        return bxVarArr;
    }

    public final bx bky(String str) {
        bx bxVar = null;
        AppMethodBeat.i(117182);
        Log.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
        Cursor rawQuery = this.db.rawQuery("select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + Util.escapeSqlValue(str) + "' or sayhiencryptuser = '" + Util.escapeSqlValue(str) + "') and flag=1 order by createtime DESC limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            bxVar = new bx();
            bxVar.convertFrom(rawQuery);
        } else {
            Log.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
        }
        rawQuery.close();
        AppMethodBeat.o(117182);
        return bxVar;
    }

    public final bx[] gR(String str, int i2) {
        AppMethodBeat.i(117183);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
            AppMethodBeat.o(117183);
            return null;
        }
        Cursor rawQuery = this.db.rawQuery("select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + Util.escapeSqlValue(str) + "' or sayhiencryptuser = '" + Util.escapeSqlValue(str) + "') order by createTime DESC limit " + i2, null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            bx bxVar = new bx();
            bxVar.convertFrom(rawQuery);
            arrayList.add(bxVar);
        }
        rawQuery.close();
        bx[] bxVarArr = (bx[]) arrayList.toArray(new bx[arrayList.size()]);
        AppMethodBeat.o(117183);
        return bxVarArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x004d  */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.g
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long aEr(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.by.aEr(java.lang.String):long");
    }
}
