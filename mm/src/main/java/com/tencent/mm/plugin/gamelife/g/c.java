package com.tencent.mm.plugin.gamelife.g;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.plugin.gamelife.g.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;

public final class c extends MAutoStorage<a> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "AppMessage")};
    public static final a ycj = new a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "AppMessage", cy.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        a.C1420a aVar = a.ych;
        AppMethodBeat.i(241398);
        AppMethodBeat.o(241398);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241399);
        a.C1420a aVar = a.ych;
        AppMethodBeat.o(241399);
    }
}
