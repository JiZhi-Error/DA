package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fj;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class al extends fj {
    static final String[] kJX = {"appId", "version"};
    static final IAutoDBItem.MAutoDBInfo kLR;

    static {
        AppMethodBeat.i(44328);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "version";
        mAutoDBInfo.colsMap.put("version", "INTEGER");
        sb.append(" version INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "hit";
        mAutoDBInfo.colsMap.put("hit", "INTEGER");
        sb.append(" hit INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "hitTimeMS";
        mAutoDBInfo.colsMap.put("hitTimeMS", "LONG");
        sb.append(" hitTimeMS LONG");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        kLR = mAutoDBInfo;
        String str = " PRIMARY KEY (";
        String[] strArr = kJX;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = str + ", " + strArr[i2];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb2 = new StringBuilder();
        IAutoDBItem.MAutoDBInfo mAutoDBInfo2 = kLR;
        mAutoDBInfo2.sql = sb2.append(mAutoDBInfo2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(44328);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return kLR;
    }
}
