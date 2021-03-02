package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import junit.framework.Assert;

public final class co extends MAutoStorage<cn> implements n {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(cn.info, "Stranger")};
    private final MStorageEvent<n.a, cn> NQt = new MStorageEvent<n.a, cn>() {
        /* class com.tencent.mm.storage.co.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(n.a aVar, cn cnVar) {
            AppMethodBeat.i(117343);
            aVar.a(cnVar);
            AppMethodBeat.o(117343);
        }
    };
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(cn cnVar) {
        AppMethodBeat.i(117351);
        cn cnVar2 = cnVar;
        if (cnVar2 != null) {
            boolean insert = super.insert(cnVar2);
            if (insert) {
                b(cnVar2);
            }
            AppMethodBeat.o(117351);
            return insert;
        }
        AppMethodBeat.o(117351);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(cn cnVar) {
        boolean z;
        AppMethodBeat.i(117350);
        cn cnVar2 = cnVar;
        Assert.assertTrue("stranger NULL !", cnVar2 != null);
        Log.d("MicroMsg.StrangerStorage", "replace : encryptUsername=%s, conRemark=%s", cnVar2.field_encryptUsername, cnVar2.field_conRemark);
        if (this.db.replace("Stranger", "", cnVar2.convertTo()) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(117350);
            return false;
        }
        b(cnVar2);
        AppMethodBeat.o(117350);
        return true;
    }

    static {
        AppMethodBeat.i(117352);
        AppMethodBeat.o(117352);
    }

    private void b(cn cnVar) {
        AppMethodBeat.i(117344);
        if (this.NQt.event(cnVar)) {
            this.NQt.doNotify();
        }
        AppMethodBeat.o(117344);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.n
    public final void a(n.a aVar) {
        AppMethodBeat.i(117345);
        this.NQt.add(aVar, (Looper) null);
        AppMethodBeat.o(117345);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.n
    public final void b(n.a aVar) {
        AppMethodBeat.i(117346);
        this.NQt.remove(aVar);
        AppMethodBeat.o(117346);
    }

    public co(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, cn.info, "Stranger", null);
        AppMethodBeat.i(117347);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(117347);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.n
    public final cn aEZ(String str) {
        AppMethodBeat.i(117348);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(117348);
            return null;
        }
        cn cnVar = new cn();
        Cursor query = this.db.query("Stranger", null, "encryptUsername = ?", new String[]{str}, null, null, null, 2);
        if (query.moveToFirst()) {
            cnVar.convertFrom(query);
        }
        query.close();
        AppMethodBeat.o(117348);
        return cnVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.n
    public final int aFa(String str) {
        AppMethodBeat.i(117349);
        int delete = this.db.delete("Stranger", "(encryptUsername=?)", new String[]{String.valueOf(str)});
        if (delete > 0) {
            doNotify();
        }
        Log.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + str + " result:" + delete);
        AppMethodBeat.o(117349);
        return delete;
    }
}
