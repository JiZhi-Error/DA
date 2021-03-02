package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bg;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class e extends bg {
    public static IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(76398);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "id";
        mAutoDBInfo.colsMap.put("id", "TEXT");
        sb.append(" id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "cacheKey";
        mAutoDBInfo.colsMap.put("cacheKey", "TEXT");
        sb.append(" cacheKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "data";
        mAutoDBInfo.colsMap.put("data", "TEXT");
        sb.append(" data TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "interval";
        mAutoDBInfo.colsMap.put("interval", "INTEGER");
        sb.append(" interval INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(76398);
    }
}
