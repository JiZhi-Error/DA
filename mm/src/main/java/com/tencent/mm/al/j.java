package com.tencent.mm.al;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends MAutoStorage<h> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(h.info, "BizKF")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(h hVar) {
        AppMethodBeat.i(124084);
        boolean b2 = b(hVar);
        AppMethodBeat.o(124084);
        return b2;
    }

    static {
        AppMethodBeat.i(124085);
        AppMethodBeat.o(124085);
    }

    public j(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, h.info, "BizKF", null);
        AppMethodBeat.i(124077);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
        iSQLiteDatabase.execSQL("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
        AppMethodBeat.o(124077);
    }

    public final h Nm(String str) {
        AppMethodBeat.i(124078);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(124078);
            return null;
        }
        Cursor query = this.db.query("BizKF", null, "openId=?", new String[]{str}, null, null, null, 2);
        if (!query.moveToFirst()) {
            Log.w("MicroMsg.BizKFStorage", "get null with openId:".concat(String.valueOf(str)));
            query.close();
            AppMethodBeat.o(124078);
            return null;
        }
        h hVar = new h();
        hVar.convertFrom(query);
        query.close();
        AppMethodBeat.o(124078);
        return hVar;
    }

    public static boolean a(h hVar) {
        AppMethodBeat.i(124079);
        if (hVar == null) {
            AppMethodBeat.o(124079);
            return false;
        } else if (System.currentTimeMillis() - hVar.field_updateTime >= Util.MILLSECONDS_OF_DAY) {
            AppMethodBeat.o(124079);
            return true;
        } else {
            AppMethodBeat.o(124079);
            return false;
        }
    }

    private boolean b(h hVar) {
        boolean z;
        AppMethodBeat.i(124080);
        if (hVar == null || Util.isNullOrNil(hVar.field_openId) || Util.isNullOrNil(hVar.field_brandUsername)) {
            Log.w("MicroMsg.BizKFStorage", "wrong argument");
            AppMethodBeat.o(124080);
            return false;
        }
        if (this.db.replace("BizKF", h.info.primaryKey, hVar.convertTo()) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", hVar.field_openId, hVar.field_brandUsername, Boolean.valueOf(z));
        AppMethodBeat.o(124080);
        return z;
    }

    public final h Nn(String str) {
        AppMethodBeat.i(124081);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(124081);
            return null;
        }
        Cursor query = this.db.query("BizKF", null, "brandUsername = ? order by kfType desc ", new String[]{str}, null, null, null, 2);
        if (!query.moveToFirst()) {
            Log.w("MicroMsg.BizKFStorage", "get null with brandUsername:".concat(String.valueOf(str)));
            query.close();
            AppMethodBeat.o(124081);
            return null;
        }
        h hVar = new h();
        hVar.convertFrom(query);
        query.close();
        AppMethodBeat.o(124081);
        return hVar;
    }

    public final int No(String str) {
        AppMethodBeat.i(124082);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(124082);
            return -1;
        }
        int delete = this.db.delete("BizKF", "brandUsername = ?", new String[]{str});
        Log.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", str, Integer.valueOf(delete));
        AppMethodBeat.o(124082);
        return delete;
    }

    public final int f(LinkedList<h> linkedList) {
        long j2;
        AppMethodBeat.i(124083);
        if (linkedList.size() <= 0) {
            Log.e("MicroMsg.BizKFStorage", "null kfs");
            AppMethodBeat.o(124083);
            return 0;
        }
        if (this.db instanceof h) {
            j2 = ((h) this.db).beginTransaction(Thread.currentThread().getId());
        } else {
            j2 = 0;
        }
        Iterator<h> it = linkedList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && b(next)) {
                i2++;
            }
            i2 = i2;
        }
        if (this.db instanceof h) {
            g.aAh().hqK.endTransaction(j2);
        }
        Log.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", Integer.valueOf(i2));
        AppMethodBeat.o(124083);
        return i2;
    }
}
