package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;

public final class r extends MAutoStorage<q> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(q.info, TABLE_NAME)};
    private static final String TABLE_NAME = TABLE_NAME;
    private static final String TAG = TAG;
    public static final a vEh = new a((byte) 0);
    private final ISQLiteDatabase db;
    private final String vEg = ("select * from " + TABLE_NAME + ' ');

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, q.info, TABLE_NAME, ci.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        q.a aVar = q.vEf;
        AppMethodBeat.i(251794);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(251794);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(q qVar) {
        AppMethodBeat.i(251791);
        boolean a2 = a(qVar);
        AppMethodBeat.o(251791);
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
        AppMethodBeat.i(251795);
        q.a aVar = q.vEf;
        AppMethodBeat.o(251795);
    }

    public final boolean a(q qVar) {
        AppMethodBeat.i(251790);
        p.h(qVar, "item");
        boolean replace = super.replace(qVar);
        Log.i(TAG, "insert " + qVar.field_key + ", ret:" + replace);
        AppMethodBeat.o(251790);
        return replace;
    }

    public final cir dxK() {
        AppMethodBeat.i(251792);
        q qVar = new q();
        cir cir = new cir();
        Cursor rawQuery = this.db.rawQuery(this.vEg + " where " + TABLE_NAME + ".key=\"KEY_BEAUTY_CONFIG\"", null, 2);
        if (rawQuery.moveToFirst()) {
            qVar.convertFrom(rawQuery);
            try {
                cir.parseFrom(qVar.field_value);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
            }
            rawQuery.close();
            AppMethodBeat.o(251792);
            return cir;
        }
        rawQuery.close();
        AppMethodBeat.o(251792);
        return null;
    }

    public final ciu dxL() {
        AppMethodBeat.i(251793);
        q qVar = new q();
        ciu ciu = new ciu();
        Cursor rawQuery = this.db.rawQuery(this.vEg + " where " + TABLE_NAME + ".key=\"KEY_FILTER_CONFIG\"", null, 2);
        if (rawQuery.moveToFirst()) {
            qVar.convertFrom(rawQuery);
            try {
                ciu.parseFrom(qVar.field_value);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
            }
            rawQuery.close();
            AppMethodBeat.o(251793);
            return ciu;
        }
        rawQuery.close();
        AppMethodBeat.o(251793);
        return null;
    }
}
