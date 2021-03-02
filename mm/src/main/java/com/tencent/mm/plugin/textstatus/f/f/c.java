package com.tencent.mm.plugin.textstatus.f.f;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.f.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.n.n;

public final class c extends MAutoStorage<b> {
    private static final String[] FZH = {MAutoStorage.getCreateSQLs(b.FZC, TABLE)};
    public static final a FZI = new a((byte) 0);
    public static final String TABLE = TABLE;
    public final ISQLiteDatabase db;

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(b bVar, String[] strArr) {
        AppMethodBeat.i(216260);
        boolean b2 = b(bVar, strArr);
        AppMethodBeat.o(216260);
        return b2;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(b bVar) {
        AppMethodBeat.i(216254);
        boolean a2 = a(bVar);
        AppMethodBeat.o(216254);
        return a2;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(b bVar) {
        AppMethodBeat.i(216255);
        b bVar2 = bVar;
        p.h(bVar2, "item");
        boolean replace = super.replace(bVar2, false);
        doNotify(bVar2.field_HashUserName);
        AppMethodBeat.o(216255);
        return replace;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(long j2, b bVar) {
        AppMethodBeat.i(216258);
        b bVar2 = bVar;
        p.h(bVar2, "item");
        boolean update = super.update(j2, bVar2);
        doNotify(bVar2.field_HashUserName);
        AppMethodBeat.o(216258);
        return update;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(b bVar, String[] strArr) {
        AppMethodBeat.i(216257);
        boolean a2 = a(bVar, strArr);
        AppMethodBeat.o(216257);
        return a2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, b.FZC, TABLE, null);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        b.a aVar = b.FZG;
        AppMethodBeat.i(216266);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(216266);
    }

    static {
        AppMethodBeat.i(216267);
        b.a aVar = b.FZG;
        AppMethodBeat.o(216267);
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(216253);
        p.h(bVar, "item");
        boolean insertNotify = super.insertNotify(bVar, false);
        doNotify(bVar.field_HashUserName);
        AppMethodBeat.o(216253);
        return insertNotify;
    }

    public final boolean a(b bVar, String... strArr) {
        AppMethodBeat.i(216256);
        p.h(bVar, "item");
        p.h(strArr, "keys");
        boolean updateNotify = super.updateNotify(bVar, false, (String[]) Arrays.copyOf(strArr, strArr.length));
        doNotify(bVar.field_HashUserName);
        AppMethodBeat.o(216256);
        return updateNotify;
    }

    public final boolean b(b bVar, String... strArr) {
        AppMethodBeat.i(216259);
        p.h(bVar, "item");
        p.h(strArr, "keys");
        boolean delete = super.delete(bVar, (String[]) Arrays.copyOf(strArr, strArr.length));
        doNotify(bVar.field_HashUserName);
        AppMethodBeat.o(216259);
        return delete;
    }

    public final b lc(String str, String str2) {
        AppMethodBeat.i(216261);
        p.h(str, "textStatusId");
        p.h(str2, "userName");
        Cursor rawQuery = this.db.rawQuery("select rowid, * from " + TABLE + " where TextStatusId = ? and HashUserName = ? ", new String[]{Util.escapeSqlValue(str), Util.escapeSqlValue(str2)});
        p.g(rawQuery, "db.rawQuery(sql, arrayOf…scapeSqlValue(userName)))");
        b bVar = null;
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                bVar = new b();
                bVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(216261);
        return bVar;
    }

    public final int ctM() {
        int i2 = 0;
        AppMethodBeat.i(216262);
        Cursor rawQuery = this.db.rawQuery("select count(rowid) from " + TABLE + " where Read != 1 ", null);
        p.g(rawQuery, "db.rawQuery(sql, null)");
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(216262);
        return i2;
    }

    public final boolean aTi(String str) {
        int i2;
        AppMethodBeat.i(216263);
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            AppMethodBeat.o(216263);
            return false;
        }
        Cursor rawQuery = this.db.rawQuery("select count(rowid) from " + TABLE + " where TextStatusId = ? and HashUserName = ?", new String[]{str, com.tencent.mm.plugin.auth.a.a.ceA()});
        p.g(rawQuery, "db.rawQuery(sql, arrayOf…sId, Account.username()))");
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            } else {
                i2 = 0;
            }
            rawQuery.close();
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.TxtStatus.TextStatusLikeStorage", "[getIsLikeOther]statusId:%s result:%s", str, Integer.valueOf(i2));
        if (i2 > 0) {
            AppMethodBeat.o(216263);
            return true;
        }
        AppMethodBeat.o(216263);
        return false;
    }

    public final int aTj(String str) {
        int i2;
        AppMethodBeat.i(216264);
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            AppMethodBeat.o(216264);
            return 0;
        }
        Cursor rawQuery = this.db.rawQuery("select count(rowid) from " + TABLE + " where TextStatusId = ?", new String[]{str});
        p.g(rawQuery, "db.rawQuery(sql, arrayOf(statusId))");
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            } else {
                i2 = 0;
            }
            rawQuery.close();
        } else {
            i2 = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        Log.i("MicroMsg.TxtStatus.TextStatusLikeStorage", "[getSelfLikeCnt]statusId:%s result:%s", str, Integer.valueOf(i2));
        AppMethodBeat.o(216264);
        return i2;
    }
}
