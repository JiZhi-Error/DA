package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class f extends ai {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(124242);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "brandUserName";
        mAutoDBInfo.colsMap.put("brandUserName", "TEXT PRIMARY KEY ");
        sb.append(" brandUserName TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "brandUserName";
        mAutoDBInfo.columns[1] = "userId";
        mAutoDBInfo.colsMap.put("userId", "TEXT");
        sb.append(" userId TEXT");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(124242);
    }
}
