package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class bo extends MAutoStorage<bn> implements e {
    private static final String[] NRG = {"CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(bn.info, "fmessage_msginfo")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(bn bnVar) {
        AppMethodBeat.i(117169);
        boolean b2 = b(bnVar);
        AppMethodBeat.o(117169);
        return b2;
    }

    static {
        AppMethodBeat.i(117170);
        AppMethodBeat.o(117170);
    }

    public bo(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, bn.info, "fmessage_msginfo", NRG);
        this.db = iSQLiteDatabase;
    }

    public final bn[] bku(String str) {
        AppMethodBeat.i(117162);
        Log.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
        Cursor rawQuery = this.db.rawQuery("select *, rowid from fmessage_msginfo  where talker = '" + Util.escapeSqlValue(str) + "' order by createTime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            bn bnVar = new bn();
            bnVar.convertFrom(rawQuery);
            arrayList.add(bnVar);
        }
        rawQuery.close();
        bn[] bnVarArr = (bn[]) arrayList.toArray(new bn[arrayList.size()]);
        AppMethodBeat.o(117162);
        return bnVarArr;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.e
    public final bn aEm(String str) {
        bn bnVar = null;
        AppMethodBeat.i(117163);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
            AppMethodBeat.o(117163);
        } else {
            Cursor rawQuery = this.db.rawQuery("select * from fmessage_msginfo where talker = '" + Util.escapeSqlValue(str) + "' order by createTime DESC limit 1", null, 2);
            bnVar = new bn();
            if (rawQuery.moveToFirst()) {
                bnVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(117163);
        }
        return bnVar;
    }

    public final bn bkv(String str) {
        AppMethodBeat.i(117164);
        bn[] gQ = gQ(str, 1);
        if (gQ == null || gQ.length <= 0) {
            AppMethodBeat.o(117164);
            return null;
        }
        bn bnVar = gQ[0];
        AppMethodBeat.o(117164);
        return bnVar;
    }

    public final bn[] gQ(String str, int i2) {
        AppMethodBeat.i(117165);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
            AppMethodBeat.o(117165);
            return null;
        }
        Cursor rawQuery = this.db.rawQuery("select * from fmessage_msginfo where isSend != 1 and talker = '" + Util.escapeSqlValue(str) + "' order by createTime DESC limit " + i2, null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            bn bnVar = new bn();
            bnVar.convertFrom(rawQuery);
            arrayList.add(bnVar);
        }
        rawQuery.close();
        bn[] bnVarArr = (bn[]) arrayList.toArray(new bn[arrayList.size()]);
        AppMethodBeat.o(117165);
        return bnVarArr;
    }

    public final boolean b(bn bnVar) {
        AppMethodBeat.i(117166);
        if (bnVar == null) {
            Log.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
            AppMethodBeat.o(117166);
            return false;
        } else if (super.insert(bnVar)) {
            doNotify(new StringBuilder().append(bnVar.systemRowid).toString());
            AppMethodBeat.o(117166);
            return true;
        } else {
            AppMethodBeat.o(117166);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.e
    public final List<bn> eiD() {
        AppMethodBeat.i(117167);
        Log.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("select *, rowid from fmessage_msginfo where type = 0", null, 2);
        while (rawQuery.moveToNext()) {
            bn bnVar = new bn();
            bnVar.convertFrom(rawQuery);
            arrayList.add(bnVar);
        }
        rawQuery.close();
        Log.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + arrayList.size());
        AppMethodBeat.o(117167);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.e
    public final boolean aEn(String str) {
        AppMethodBeat.i(117168);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
            AppMethodBeat.o(117168);
            return false;
        }
        boolean execSQL = this.db.execSQL("fmessage_msginfo", "delete from fmessage_msginfo where talker = '" + Util.escapeSqlValue(str) + "'");
        AppMethodBeat.o(117168);
        return execSQL;
    }
}
