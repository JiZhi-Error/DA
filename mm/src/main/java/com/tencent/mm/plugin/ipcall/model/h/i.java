package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dw;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class i extends dw {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(25551);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "countryCode";
        mAutoDBInfo.colsMap.put("countryCode", "INTEGER PRIMARY KEY ");
        sb.append(" countryCode INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "countryCode";
        mAutoDBInfo.columns[1] = "callTimeCount";
        mAutoDBInfo.colsMap.put("callTimeCount", "LONG");
        sb.append(" callTimeCount LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "lastCallTime";
        mAutoDBInfo.colsMap.put("lastCallTime", "LONG");
        sb.append(" lastCallTime LONG");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(25551);
    }
}
