package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.c;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;

public final class g extends MAutoStorage<c> {
    private static final String[] Fwb = {MAutoStorage.getCreateSQLs(c.info, OsG)};
    public static final String OsG = OsG;
    public static final a OsH = new a((byte) 0);
    private static final String TAG = TAG;
    public final ISQLiteDatabase db;
    public final com.tencent.mm.memory.a.c<String, c> jNx = new com.tencent.mm.memory.a.c<>(100);

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.b<dkt, String> {
        public static final b OsI = new b();

        static {
            AppMethodBeat.i(200095);
            AppMethodBeat.o(200095);
        }

        b() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(dkt dkt) {
            AppMethodBeat.i(200094);
            dkt dkt2 = dkt;
            String str = dkt2.MOJ.Md5 + '-' + dkt2.MOM;
            AppMethodBeat.o(200094);
            return str;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, OsG, null);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        c.a aVar = c.gZz;
        AppMethodBeat.i(200100);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(200100);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(200101);
        c.a aVar = c.gZz;
        AppMethodBeat.o(200101);
    }

    public final c blp(String str) {
        AppMethodBeat.i(200096);
        p.h(str, "desc");
        c cVar = this.jNx.get(str);
        if (cVar != null) {
            AppMethodBeat.o(200096);
        } else {
            cVar = blq(str);
            if (cVar != null) {
                this.jNx.put(cVar.field_desc, cVar);
            }
            AppMethodBeat.o(200096);
        }
        return cVar;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(200097);
        p.h(cVar, "info");
        this.jNx.put(cVar.field_desc, cVar);
        super.replace(cVar);
        AppMethodBeat.o(200097);
    }

    private c blq(String str) {
        AppMethodBeat.i(200098);
        p.h(str, "desc");
        c cVar = new c();
        cVar.field_desc = str;
        super.get(cVar, getPrimaryKey());
        if (cVar.isValid()) {
            AppMethodBeat.o(200098);
            return cVar;
        }
        AppMethodBeat.o(200098);
        return null;
    }

    public final void dump() {
        int i2;
        AppMethodBeat.i(200099);
        Cursor rawQuery = this.db.rawQuery("select * from " + OsG, null, 2);
        if (rawQuery != null) {
            i2 = 0;
            while (rawQuery.moveToNext()) {
                c cVar = new c();
                cVar.convertFrom(rawQuery);
                dld dld = new dld();
                try {
                    dld.parseFrom(cVar.field_content);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                }
                String str = TAG;
                StringBuilder append = new StringBuilder("dump: ").append(i2).append(": ").append(cVar.field_desc).append(", ").append(cVar.field_updateTime).append("; ");
                LinkedList<dkt> linkedList = dld.LVc;
                p.g(linkedList, "rsp.Emoji");
                Log.i(str, append.append(j.a(linkedList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, b.OsI, 31)).toString());
                i2++;
            }
            rawQuery.close();
        } else {
            i2 = 0;
        }
        Log.i(TAG, "dump done: count ".concat(String.valueOf(i2)));
        AppMethodBeat.o(200099);
    }
}
