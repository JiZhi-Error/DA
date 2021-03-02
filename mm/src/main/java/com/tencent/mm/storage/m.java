package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class m extends MAutoStorage<l> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(l.info, "BackupRecoverMsgListDataId")};
    public h iFy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* bridge */ /* synthetic */ boolean update(long j2, l lVar) {
        AppMethodBeat.i(32831);
        boolean update = super.update(j2, lVar);
        AppMethodBeat.o(32831);
        return update;
    }

    static {
        AppMethodBeat.i(32832);
        AppMethodBeat.o(32832);
    }

    public m(h hVar) {
        super(hVar, l.info, "BackupRecoverMsgListDataId", null);
        this.iFy = hVar;
    }

    public final String biE(String str) {
        AppMethodBeat.i(32826);
        String str2 = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + str + "\" ";
        Log.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        if (rawQuery == null) {
            Log.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", str);
            AppMethodBeat.o(32826);
            return null;
        } else if (rawQuery.moveToFirst()) {
            l lVar = new l();
            lVar.convertFrom(rawQuery);
            rawQuery.close();
            String str3 = lVar.field_sessionName;
            AppMethodBeat.o(32826);
            return str3;
        } else {
            rawQuery.close();
            AppMethodBeat.o(32826);
            return null;
        }
    }

    public final HashMap<String, String> gzC() {
        AppMethodBeat.i(32827);
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor all = getAll();
        if (all == null) {
            Log.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
            AppMethodBeat.o(32827);
        } else {
            while (all.moveToNext()) {
                l lVar = new l();
                lVar.convertFrom(all);
                hashMap.put(lVar.field_msgListDataId, lVar.field_sessionName);
            }
            all.close();
            AppMethodBeat.o(32827);
        }
        return hashMap;
    }

    public final boolean gzD() {
        AppMethodBeat.i(32828);
        Log.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:".concat(String.valueOf("SELECT * FROM BackupRecoverMsgListDataId")));
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BackupRecoverMsgListDataId", null);
        if (rawQuery == null) {
            Log.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
            AppMethodBeat.o(32828);
            return false;
        } else if (rawQuery.getCount() <= 0) {
            Log.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
            rawQuery.close();
            AppMethodBeat.o(32828);
            return false;
        } else {
            rawQuery.close();
            AppMethodBeat.o(32828);
            return true;
        }
    }

    public final int gzE() {
        int i2 = 0;
        AppMethodBeat.i(32829);
        Log.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionCount:".concat(String.valueOf("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ")));
        Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(DISTINCT sessionName) FROM BackupRecoverMsgListDataId ", null);
        if (rawQuery.moveToLast()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(32829);
        return i2;
    }

    public final boolean aHo() {
        AppMethodBeat.i(32830);
        boolean execSQL = this.iFy.execSQL("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
        Log.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", Boolean.valueOf(execSQL));
        AppMethodBeat.o(32830);
        return execSQL;
    }
}
