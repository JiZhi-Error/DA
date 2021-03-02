package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ac extends MAutoStorage<ab> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ab.info, "UxCanvasInfo")};

    static {
        AppMethodBeat.i(97653);
        AppMethodBeat.o(97653);
    }

    public ac(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, ab.info, "UxCanvasInfo");
    }

    private ac(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
    }

    public final void a(ab abVar) {
        AppMethodBeat.i(97652);
        if (abVar == null || Util.isNullOrNil(abVar.field_canvasXml)) {
            AppMethodBeat.o(97652);
            return;
        }
        abVar.field_createTime = System.currentTimeMillis();
        if (!insert(abVar)) {
            update(abVar, new String[0]);
        }
        AppMethodBeat.o(97652);
    }
}
