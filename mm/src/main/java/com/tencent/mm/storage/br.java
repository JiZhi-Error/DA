package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import junit.framework.Assert;

public final class br extends MAutoStorage<bq> implements f {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(bq.info, "FriendUser")};
    private final MStorageEvent<f.a, bq> NQt = new MStorageEvent<f.a, bq>() {
        /* class com.tencent.mm.storage.br.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(f.a aVar, bq bqVar) {
            AppMethodBeat.i(187506);
            aVar.a(bqVar);
            AppMethodBeat.o(187506);
        }
    };
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(bq bqVar) {
        AppMethodBeat.i(187515);
        bq bqVar2 = bqVar;
        if (bqVar2 != null) {
            boolean insert = super.insert(bqVar2);
            if (insert) {
                b(bqVar2);
            }
            AppMethodBeat.o(187515);
            return insert;
        }
        AppMethodBeat.o(187515);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(bq bqVar) {
        boolean z;
        AppMethodBeat.i(187514);
        bq bqVar2 = bqVar;
        Assert.assertTrue("FriendUser NULL !", bqVar2 != null);
        Log.d("MicroMsg.FriendUserStorage", "replace : encryptUsername=%s, username=%s", bqVar2.field_encryptUsername, bqVar2.field_username);
        if (this.db.replace("FriendUser", "", bqVar2.convertTo()) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(187514);
            return false;
        }
        b(bqVar2);
        AppMethodBeat.o(187514);
        return true;
    }

    static {
        AppMethodBeat.i(187516);
        AppMethodBeat.o(187516);
    }

    private void b(bq bqVar) {
        AppMethodBeat.i(187507);
        if (this.NQt.event(bqVar)) {
            this.NQt.doNotify();
        }
        AppMethodBeat.o(187507);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.f
    public final void a(f.a aVar) {
        AppMethodBeat.i(187508);
        this.NQt.add(aVar, (Looper) null);
        AppMethodBeat.o(187508);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.f
    public final void b(f.a aVar) {
        AppMethodBeat.i(187509);
        this.NQt.remove(aVar);
        AppMethodBeat.o(187509);
    }

    public br(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, bq.info, "FriendUser", null);
        AppMethodBeat.i(187510);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(187510);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.f
    public final bq aEo(String str) {
        AppMethodBeat.i(187511);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(187511);
            return null;
        }
        bq bqVar = new bq();
        Cursor query = this.db.query("FriendUser", null, "encryptUsername = ?", new String[]{str}, null, null, null, 2);
        if (query.moveToFirst()) {
            bqVar.convertFrom(query);
        }
        query.close();
        AppMethodBeat.o(187511);
        return bqVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.f
    public final int eiE() {
        AppMethodBeat.i(187512);
        Cursor rawQuery = this.db.rawQuery(String.format("select count(rowid) from %s", "FriendUser"), null);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            AppMethodBeat.o(187512);
            return 0;
        }
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        Log.i("MicroMsg.FriendUserStorage", "#recordCnts#, count:".concat(String.valueOf(i2)));
        AppMethodBeat.o(187512);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.f
    public final int eiF() {
        AppMethodBeat.i(187513);
        int delete = this.db.delete("FriendUser", "(modifyTime< ?)", new String[]{String.valueOf(System.currentTimeMillis() - 604800000)});
        if (delete > 0) {
            doNotify();
        }
        Log.i("MicroMsg.FriendUserStorage", "#Clear Records#, result:".concat(String.valueOf(delete)));
        AppMethodBeat.o(187513);
        return delete;
    }
}
