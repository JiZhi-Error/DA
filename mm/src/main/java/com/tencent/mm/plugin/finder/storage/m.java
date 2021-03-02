package com.tencent.mm.plugin.finder.storage;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;

public final class m extends MAutoStorage<cm> {
    private static final String[] INDEX_CREATE;
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ao.info, cm.fFh)};
    public static final a vDN = new a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ao.info, cm.fFh, INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        ao.a aVar = ao.vFu;
        AppMethodBeat.i(251731);
        AppMethodBeat.o(251731);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251732);
        StringBuilder sb = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        ao.a aVar = ao.vFu;
        INDEX_CREATE = new String[]{sb.append(ao.TABLEINDEXUSERNAME).append(" ON ").append(cm.fFh).append(" ( id, flag, type, userVersion)").toString(), "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + cm.fFh + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + cm.fFh + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + cm.fFh + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + cm.fFh + "(commentId)"};
        ao.a aVar2 = ao.vFu;
        AppMethodBeat.o(251732);
    }
}