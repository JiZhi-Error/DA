package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ae;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class p extends ae {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(212322);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "aId";
        mAutoDBInfo.colsMap.put("aId", "TEXT PRIMARY KEY ");
        sb.append(" aId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "aId";
        mAutoDBInfo.columns[1] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG");
        sb.append(" msgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "exposeTime";
        mAutoDBInfo.colsMap.put("exposeTime", "LONG");
        sb.append(" exposeTime LONG");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(212322);
    }
}
