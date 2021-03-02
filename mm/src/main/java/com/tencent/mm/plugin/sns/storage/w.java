package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gn;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class w extends gn {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(203222);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "top";
        mAutoDBInfo.colsMap.put("top", "LONG");
        sb.append(" top LONG");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "bottom";
        mAutoDBInfo.colsMap.put("bottom", "LONG PRIMARY KEY ");
        sb.append(" bottom LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "bottom";
        mAutoDBInfo.columns[2] = "size";
        mAutoDBInfo.colsMap.put("size", "INTEGER");
        sb.append(" size INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER");
        sb.append(" state INTEGER");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(203222);
    }
}
