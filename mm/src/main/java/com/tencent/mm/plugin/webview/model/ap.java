package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hq;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class ap extends hq {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(79029);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "recordId";
        mAutoDBInfo.colsMap.put("recordId", "INTEGER PRIMARY KEY ");
        sb.append(" recordId INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "recordId";
        mAutoDBInfo.columns[1] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "domin";
        mAutoDBInfo.colsMap.put("domin", "TEXT");
        sb.append(" domin TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "key";
        mAutoDBInfo.colsMap.put("key", "TEXT");
        sb.append(" key TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "value";
        mAutoDBInfo.colsMap.put("value", "TEXT");
        sb.append(" value TEXT");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(79029);
    }
}
