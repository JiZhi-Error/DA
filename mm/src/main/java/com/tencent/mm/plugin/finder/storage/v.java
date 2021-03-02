package com.tencent.mm.plugin.finder.storage;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ck;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;

public final class v extends MAutoStorage<u> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(u.info, TABLE_NAME)};
    private static final String TABLE_NAME = TABLE_NAME;
    public static final String TAG = TAG;
    public static final a vEl = new a((byte) 0);
    public final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, u.info, TABLE_NAME, ck.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        u.a aVar = u.vEk;
        AppMethodBeat.i(251807);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(251807);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(u uVar) {
        AppMethodBeat.i(251806);
        boolean a2 = a(uVar);
        AppMethodBeat.o(251806);
        return a2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251808);
        u.a aVar = u.vEk;
        AppMethodBeat.o(251808);
    }

    public final boolean a(u uVar) {
        AppMethodBeat.i(251805);
        p.h(uVar, "item");
        boolean insert = super.insert(uVar);
        Log.i(TAG, "insert " + uVar.field_localId + ", ret:" + insert);
        AppMethodBeat.o(251805);
        return insert;
    }
}
