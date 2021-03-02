package com.tencent.mm.plugin.lite.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends a {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    static {
        AppMethodBeat.i(198889);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "host";
        mAutoDBInfo.colsMap.put("host", "TEXT PRIMARY KEY ");
        sb.append(" host TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "host";
        mAutoDBInfo.columns[1] = "param";
        mAutoDBInfo.colsMap.put("param", "TEXT");
        sb.append(" param TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "headerMap";
        mAutoDBInfo.colsMap.put("headerMap", "TEXT");
        sb.append(" headerMap TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "paramMap";
        mAutoDBInfo.colsMap.put("paramMap", "TEXT");
        sb.append(" paramMap TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(198889);
    }
}
