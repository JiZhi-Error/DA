package com.tencent.mm.plugin.story.i;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gt;
import com.tencent.mm.plugin.story.i.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.g.b.p;

public final class m extends MAutoStorage<l> implements MStorage.IOnStorageChange {
    public static final a FwF = new a((byte) 0);
    private static final String Fwl = ("select * from " + TABLE);
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(l.info, TABLE)};
    private static final String TABLE = TABLE;
    private static final String TAG = TAG;
    private final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, l.info, TABLE, gt.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        l.a aVar = l.FwD;
        AppMethodBeat.i(119598);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(119598);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119599);
        l.a aVar = l.FwD;
        AppMethodBeat.o(119599);
    }

    public final l aSB(String str) {
        AppMethodBeat.i(119596);
        p.h(str, "roomName");
        l lVar = new l();
        lVar.field_roomname = str;
        super.get(lVar, new String[0]);
        AppMethodBeat.o(119596);
        return lVar;
    }

    public final void eIQ() {
        AppMethodBeat.i(119597);
        Log.i(TAG, "dropTable ".concat(String.valueOf(this.db.delete(TABLE, null, null))));
        AppMethodBeat.o(119597);
    }
}
