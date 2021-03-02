package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c extends MAutoStorage<AdSnsInfo> {
    private static final String Emf = String.format("select  %s %s,rowid from AdSnsInfo ", "snsId", "createTime");
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(AdSnsInfo.info, "adsnsinfo")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(long j2, AdSnsInfo adSnsInfo) {
        AppMethodBeat.i(97442);
        boolean b2 = b(j2, adSnsInfo);
        AppMethodBeat.o(97442);
        return b2;
    }

    static {
        AppMethodBeat.i(97443);
        AppMethodBeat.o(97443);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, AdSnsInfo.info, "adsnsinfo", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final AdSnsInfo JE(long j2) {
        AppMethodBeat.i(97434);
        AdSnsInfo adSnsInfo = new AdSnsInfo();
        Cursor rawQuery = this.db.rawQuery("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(j2)), null, 2);
        if (rawQuery.moveToFirst()) {
            adSnsInfo.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(97434);
            return adSnsInfo;
        }
        rawQuery.close();
        AppMethodBeat.o(97434);
        return null;
    }

    public final AdSnsInfo Zp(int i2) {
        AppMethodBeat.i(97435);
        AdSnsInfo adSnsInfo = new AdSnsInfo();
        Cursor rawQuery = this.db.rawQuery("select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=".concat(String.valueOf(i2)), null, 2);
        if (rawQuery.moveToFirst()) {
            adSnsInfo.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(97435);
            return adSnsInfo;
        }
        rawQuery.close();
        AppMethodBeat.o(97435);
        return null;
    }

    public final boolean a(long j2, AdSnsInfo adSnsInfo) {
        AppMethodBeat.i(97436);
        if (JF(j2)) {
            boolean b2 = b(j2, adSnsInfo);
            AppMethodBeat.o(97436);
            return b2;
        }
        Log.d("MicroMsg.AdSnsInfoStorage", "added PcId ".concat(String.valueOf(j2)));
        if (a(adSnsInfo) != -1) {
            AppMethodBeat.o(97436);
            return true;
        }
        AppMethodBeat.o(97436);
        return false;
    }

    public final boolean b(long j2, AdSnsInfo adSnsInfo) {
        AppMethodBeat.i(97437);
        ContentValues convertTo = adSnsInfo.convertTo();
        convertTo.remove("rowid");
        if (this.db.update(f.TABLE_NAME, convertTo, "snsId=?", new String[]{String.valueOf(j2)}) > 0) {
            AppMethodBeat.o(97437);
            return true;
        }
        AppMethodBeat.o(97437);
        return false;
    }

    public final boolean JF(long j2) {
        AppMethodBeat.i(97438);
        Cursor rawQuery = this.db.rawQuery("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(j2)), null, 2);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        AppMethodBeat.o(97438);
        return moveToFirst;
    }

    private int a(AdSnsInfo adSnsInfo) {
        AppMethodBeat.i(97439);
        Log.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
        if (adSnsInfo == null) {
            AppMethodBeat.o(97439);
            return -1;
        }
        int insert = (int) this.db.insert(f.TABLE_NAME, "", adSnsInfo.convertTo());
        Log.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result".concat(String.valueOf(insert)));
        AppMethodBeat.o(97439);
        return insert;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final boolean delete(long j2) {
        AppMethodBeat.i(97440);
        int delete = this.db.delete(f.TABLE_NAME, "snsId=?", new String[]{String.valueOf(j2)});
        Log.i("MicroMsg.AdSnsInfoStorage", "del msg " + j2 + " res " + delete);
        if (delete > 0) {
            AppMethodBeat.o(97440);
            return true;
        }
        AppMethodBeat.o(97440);
        return false;
    }

    public final Cursor iG(int i2, int i3) {
        AppMethodBeat.i(97441);
        String str = ("select *,rowid from AdSnsInfo  where createTime > " + i3 + " and createTime <= " + i2 + " and " + n.EmI) + " order by  createTime desc";
        Log.d("MicroMsg.AdSnsInfoStorage", "getAdInTime ".concat(String.valueOf(str)));
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        AppMethodBeat.o(97441);
        return rawQuery;
    }
}
