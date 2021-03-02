package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;

public final class cm extends MAutoStorage<cl> implements m {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(cl.info, "shakeverifymessage")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(cl clVar) {
        AppMethodBeat.i(117341);
        boolean a2 = a(clVar);
        AppMethodBeat.o(117341);
        return a2;
    }

    static {
        AppMethodBeat.i(117342);
        AppMethodBeat.o(117342);
    }

    public cm(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, cl.info, "shakeverifymessage", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final int ctM() {
        AppMethodBeat.i(117331);
        Cursor rawQuery = this.db.rawQuery("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(117331);
            return 0;
        }
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        if (i2 > 0) {
            AppMethodBeat.o(117331);
            return i2;
        }
        AppMethodBeat.o(117331);
        return 0;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final int getCount() {
        AppMethodBeat.i(117332);
        Cursor rawQuery = this.db.rawQuery("select count(*) from " + getTableName(), null, 2);
        if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(117332);
            return 0;
        }
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        if (i2 > 0) {
            AppMethodBeat.o(117332);
            return i2;
        }
        AppMethodBeat.o(117332);
        return 0;
    }

    public final cl gEx() {
        AppMethodBeat.i(117333);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(117333);
            return null;
        } else if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(117333);
            return null;
        } else {
            cl clVar = new cl();
            clVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(117333);
            return clVar;
        }
    }

    public final Cursor Pf(int i2) {
        AppMethodBeat.i(117334);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + i2, null);
        AppMethodBeat.o(117334);
        return rawQuery;
    }

    public final void aEp(String str) {
        AppMethodBeat.i(117335);
        int delete = this.db.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        Log.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(delete)));
        AppMethodBeat.o(117335);
    }

    public final void byC() {
        AppMethodBeat.i(117336);
        this.db.delete(getTableName(), null, null);
        AppMethodBeat.o(117336);
    }

    public final boolean a(cl clVar) {
        AppMethodBeat.i(117337);
        if (clVar == null) {
            Log.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
            AppMethodBeat.o(117337);
            return false;
        } else if (super.insert(clVar)) {
            doNotify(new StringBuilder().append(clVar.systemRowid).toString());
            AppMethodBeat.o(117337);
            return true;
        } else {
            AppMethodBeat.o(117337);
            return false;
        }
    }

    public final cl[] gT(String str, int i2) {
        AppMethodBeat.i(117338);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
            AppMethodBeat.o(117338);
            return null;
        }
        Cursor rawQuery = this.db.rawQuery("select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + Util.escapeSqlValue(str) + "' order by createTime DESC limit " + i2, null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            cl clVar = new cl();
            clVar.convertFrom(rawQuery);
            arrayList.add(clVar);
        }
        rawQuery.close();
        if (arrayList.size() == 0) {
            AppMethodBeat.o(117338);
            return null;
        }
        cl[] clVarArr = (cl[]) arrayList.toArray(new cl[arrayList.size()]);
        AppMethodBeat.o(117338);
        return clVarArr;
    }

    public final cl[] bkW(String str) {
        AppMethodBeat.i(117339);
        Log.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
        Cursor rawQuery = this.db.rawQuery("select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + Util.escapeSqlValue(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            cl clVar = new cl();
            clVar.convertFrom(rawQuery);
            arrayList.add(clVar);
        }
        rawQuery.close();
        if (arrayList.size() == 0) {
            AppMethodBeat.o(117339);
            return null;
        }
        cl[] clVarArr = (cl[]) arrayList.toArray(new cl[arrayList.size()]);
        AppMethodBeat.o(117339);
        return clVarArr;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.m
    public final long aEr(String str) {
        long j2;
        cl gEx;
        AppMethodBeat.i(117340);
        if (str == null || (gEx = ((cm) ((l) g.af(l.class)).eiu()).gEx()) == null) {
            j2 = 0;
        } else {
            j2 = gEx.field_createtime + 1;
        }
        long nowSecond = Util.nowSecond();
        if (j2 > nowSecond) {
            AppMethodBeat.o(117340);
            return j2;
        }
        AppMethodBeat.o(117340);
        return nowSecond;
    }
}
