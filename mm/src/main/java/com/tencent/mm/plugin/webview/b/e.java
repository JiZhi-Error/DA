package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e extends MAutoStorage<d> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(d.info, "WebViewHistory")};

    static {
        AppMethodBeat.i(77859);
        AppMethodBeat.o(77859);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, d.info, "WebViewHistory", null);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(77858);
        int count = eVar.getCount() - 500;
        if (count > 0) {
            Log.i("MicroMsg.WebViewHistoryStorage", "deleteItem: ".concat(String.valueOf(eVar.execSQL("WebViewHistory", "delete from WebViewHistory order by timeStamp limit ".concat(String.valueOf(count))))));
        }
        AppMethodBeat.o(77858);
    }
}
