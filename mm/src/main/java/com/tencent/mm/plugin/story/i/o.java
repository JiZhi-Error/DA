package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gu;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;

public final class o extends MAutoStorage<n> {
    public static final a FwH = new a((byte) 0);
    private static final String[] Fwb = {MAutoStorage.getCreateSQLs(n.info, "StoryVideoCacheInfo")};
    private static final String TAG = TAG;
    public final ISQLiteDatabase db;

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(n nVar) {
        AppMethodBeat.i(119605);
        boolean a2 = a(nVar);
        AppMethodBeat.o(119605);
        return a2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, n.info, "StoryVideoCacheInfo", gu.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        n.a aVar = n.FwG;
        AppMethodBeat.i(119609);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(119609);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119610);
        n.a aVar = n.FwG;
        AppMethodBeat.o(119610);
    }

    public final boolean a(n nVar) {
        AppMethodBeat.i(119604);
        p.h(nVar, "item");
        boolean insert = super.insert(nVar);
        AppMethodBeat.o(119604);
        return insert;
    }

    public final boolean b(n nVar) {
        AppMethodBeat.i(119606);
        p.h(nVar, "item");
        boolean update = super.update(nVar, new String[0]);
        AppMethodBeat.o(119606);
        return update;
    }

    public final n KC(long j2) {
        n nVar = null;
        AppMethodBeat.i(119607);
        if (j2 == 0) {
            Log.i(TAG, "Test get mediaId error " + j2 + ' ' + Util.getStack());
            AppMethodBeat.o(119607);
        } else {
            Cursor rawQuery = this.db.rawQuery("select * from StoryVideoCacheInfo  where storyId = '" + j2 + "' ", null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    nVar = new n();
                    nVar.convertFrom(rawQuery);
                }
                rawQuery.close();
            }
            AppMethodBeat.o(119607);
        }
        return nVar;
    }

    public final void eIQ() {
        AppMethodBeat.i(119608);
        Log.i(TAG, "dropTable ".concat(String.valueOf(this.db.delete("StoryVideoCacheInfo", null, null))));
        AppMethodBeat.o(119608);
    }
}
