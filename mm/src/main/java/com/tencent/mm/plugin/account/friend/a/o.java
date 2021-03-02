package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;

public final class o extends MAutoStorage<n> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(n.info, "GoogleFriend")};
    private ISQLiteDatabase db;
    public MStorageEx keO = new MStorageEx() {
        /* class com.tencent.mm.plugin.account.friend.a.o.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx
        public final boolean shouldProcessEvent() {
            AppMethodBeat.i(131048);
            if (o.this.db == null || o.this.db.isClose()) {
                Object[] objArr = new Object[1];
                objArr[0] = o.this.db == null ? BuildConfig.COMMAND : Boolean.valueOf(o.this.db.isClose());
                Log.w("MicroMsg.GoogleContact.GoogleFriendUI", "shouldProcessEvent db is close :%s", objArr);
                AppMethodBeat.o(131048);
                return false;
            }
            AppMethodBeat.o(131048);
            return true;
        }
    };

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(n nVar) {
        AppMethodBeat.i(131059);
        boolean a2 = a(nVar);
        AppMethodBeat.o(131059);
        return a2;
    }

    static {
        AppMethodBeat.i(131060);
        AppMethodBeat.o(131060);
    }

    public o(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, n.info, "GoogleFriend", null);
        AppMethodBeat.i(131049);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(131049);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.storagebase.g.a
    public final String getTableName() {
        return "GoogleFriend";
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    private boolean a(n nVar) {
        AppMethodBeat.i(131050);
        if (nVar == null) {
            AppMethodBeat.o(131050);
            return false;
        }
        if (((int) this.db.insert("GoogleFriend", "googleitemid", nVar.convertTo())) > 0) {
            AppMethodBeat.o(131050);
            return true;
        }
        AppMethodBeat.o(131050);
        return false;
    }

    public final boolean z(ArrayList<n> arrayList) {
        long j2;
        AppMethodBeat.i(131051);
        if (arrayList.size() <= 0) {
            Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
            AppMethodBeat.o(131051);
            return false;
        }
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", Long.valueOf(j2));
            hVar = hVar2;
        } else {
            j2 = -1;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a(arrayList.get(i2));
        }
        if (hVar != null) {
            hVar.endTransaction(j2);
            Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.keO.doNotify(2, this.keO, "");
        AppMethodBeat.o(131051);
        return true;
    }

    public final Cursor bZ(String str, String str2) {
        AppMethodBeat.i(131052);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(" WHERE ( ");
            sb.append("GoogleFriend.googlegmail!='" + str2 + "' AND ");
            sb.append("GoogleFriend.googlename LIKE '%" + str + "%' OR ");
            sb.append("GoogleFriend.googlenamepy LIKE '%" + str + "%' OR ");
            sb.append("GoogleFriend.googlegmail LIKE '%" + str + "%' OR ");
            sb.append("GoogleFriend.nickname LIKE '%" + str + "%' ) ");
        } else {
            sb.append(" WHERE ( GoogleFriend.googlegmail!='" + str2 + "' )");
        }
        sb.append(" GROUP BY googleid,contecttype");
        sb.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
        Cursor rawQuery = this.db.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + sb.toString(), null);
        AppMethodBeat.o(131052);
        return rawQuery;
    }

    public final Cursor Td(String str) {
        AppMethodBeat.i(131053);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(" WHERE ( ");
            sb.append("GoogleFriend.googleid='" + str + "'");
            sb.append(" ) ");
        }
        Cursor rawQuery = this.db.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  ".concat(String.valueOf(sb)), null);
        AppMethodBeat.o(131053);
        return rawQuery;
    }

    public final boolean b(n nVar) {
        AppMethodBeat.i(131054);
        if (!Te(nVar.field_googleitemid)) {
            boolean a2 = a(nVar);
            AppMethodBeat.o(131054);
            return a2;
        }
        ContentValues convertTo = nVar.convertTo();
        int update = this.db.update("GoogleFriend", convertTo, "googleitemid=?", new String[]{nVar.field_googleitemid});
        if (update > 0) {
            doNotify();
        }
        if (update > 0) {
            AppMethodBeat.o(131054);
            return true;
        }
        AppMethodBeat.o(131054);
        return false;
    }

    public final boolean aF(String str, int i2) {
        AppMethodBeat.i(131055);
        boolean execSQL = this.db.execSQL("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i2 + "' WHERE googleitemid='" + str + "'");
        AppMethodBeat.o(131055);
        return execSQL;
    }

    public final boolean aG(String str, int i2) {
        AppMethodBeat.i(131056);
        if (!TextUtils.isEmpty(str)) {
            boolean execSQL = this.db.execSQL("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i2 + "' , status='0' WHERE username='" + str + "'");
            AppMethodBeat.o(131056);
            return execSQL;
        }
        AppMethodBeat.o(131056);
        return false;
    }

    private boolean Te(String str) {
        AppMethodBeat.i(131057);
        Cursor rawQuery = this.db.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        AppMethodBeat.o(131057);
        return moveToFirst;
    }

    public final void clear() {
        AppMethodBeat.i(131058);
        this.db.execSQL("GoogleFriend", " delete from GoogleFriend");
        this.keO.doNotify(5, this.keO, "");
        AppMethodBeat.o(131058);
    }
}
