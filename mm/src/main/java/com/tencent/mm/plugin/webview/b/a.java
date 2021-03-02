package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hn;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends hn {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(77827);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "appIdKey";
        mAutoDBInfo.colsMap.put("appIdKey", "TEXT PRIMARY KEY ");
        sb.append(" appIdKey TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appIdKey";
        mAutoDBInfo.columns[2] = "value";
        mAutoDBInfo.colsMap.put("value", "TEXT");
        sb.append(" value TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "weight";
        mAutoDBInfo.colsMap.put("weight", "TEXT");
        sb.append(" weight TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "expireTime";
        mAutoDBInfo.colsMap.put("expireTime", "LONG");
        sb.append(" expireTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "timeStamp";
        mAutoDBInfo.colsMap.put("timeStamp", "LONG");
        sb.append(" timeStamp LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "size";
        mAutoDBInfo.colsMap.put("size", "LONG");
        sb.append(" size LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "localFile";
        mAutoDBInfo.colsMap.put("localFile", "TEXT");
        sb.append(" localFile TEXT");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(77827);
    }
}
