package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ik;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class ah extends ik {
    public static final IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(261961);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "topic";
        mAutoDBInfo.colsMap.put("topic", "TEXT PRIMARY KEY ");
        sb.append(" topic TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "topic";
        mAutoDBInfo.columns[1] = "count";
        mAutoDBInfo.colsMap.put("count", "LONG");
        sb.append(" count LONG");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(261961);
    }
}
