package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.j;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends j {
    public static IAutoDBItem.MAutoDBInfo kXQ;
    static final String[] kXR = {ch.COL_USERNAME, "fetchType"};

    static {
        AppMethodBeat.i(44704);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "fetchType";
        mAutoDBInfo.colsMap.put("fetchType", "INTEGER");
        sb.append(" fetchType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "path";
        mAutoDBInfo.colsMap.put("path", "TEXT");
        sb.append(" path TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = SearchIntents.EXTRA_QUERY;
        mAutoDBInfo.colsMap.put(SearchIntents.EXTRA_QUERY, "TEXT");
        sb.append(" query TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "data";
        mAutoDBInfo.colsMap.put("data", "TEXT");
        sb.append(" data TEXT");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        kXQ = mAutoDBInfo;
        String str = " PRIMARY KEY ( ";
        String[] strArr = kXR;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = str + ", " + strArr[i2];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb2 = new StringBuilder();
        IAutoDBItem.MAutoDBInfo mAutoDBInfo2 = kXQ;
        mAutoDBInfo2.sql = sb2.append(mAutoDBInfo2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(44704);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return kXQ;
    }
}
