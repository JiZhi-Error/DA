package com.tencent.mm.plugin.expt.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bs;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends bs {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(122445);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "exptKey";
        mAutoDBInfo.colsMap.put("exptKey", "TEXT PRIMARY KEY ");
        sb.append(" exptKey TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "exptKey";
        mAutoDBInfo.columns[1] = "exptId";
        mAutoDBInfo.colsMap.put("exptId", "INTEGER");
        sb.append(" exptId INTEGER");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(122445);
    }
}
