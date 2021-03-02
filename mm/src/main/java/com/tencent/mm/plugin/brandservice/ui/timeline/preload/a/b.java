package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public final class b extends MAutoStorage<a> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(a.iBg, "BizAppMsgReportContext")};
    public static final String[] iBi = new String[0];
    final ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(a aVar) {
        AppMethodBeat.i(6190);
        boolean a2 = a(aVar);
        AppMethodBeat.o(6190);
        return a2;
    }

    static {
        AppMethodBeat.i(6191);
        AppMethodBeat.o(6191);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.iBg, "BizAppMsgReportContext", iBi);
        this.db = iSQLiteDatabase;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(6188);
        aVar.field_appMsgReportContextId = aVar.field_reportTime;
        boolean insert = super.insert(aVar);
        AppMethodBeat.o(6188);
        return insert;
    }

    public final void cJ(List<a> list) {
        AppMethodBeat.i(6189);
        long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
        for (a aVar : list) {
            if (!delete(aVar, new String[0])) {
                Log.v("MicroMsg.Preload.BizAppMsgReportContextStorage", "[remove] delete fail");
            }
        }
        g.aAh().hqK.endTransaction(beginTransaction);
        AppMethodBeat.o(6189);
    }
}
