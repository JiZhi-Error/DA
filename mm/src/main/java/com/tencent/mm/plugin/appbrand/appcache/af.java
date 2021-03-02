package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.fh;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class af extends fh {
    static final String[] kJX = {"key", "version"};
    static final IAutoDBItem.MAutoDBInfo kLR;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return kLR;
    }

    static {
        AppMethodBeat.i(44312);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "key";
        mAutoDBInfo.colsMap.put("key", "TEXT");
        sb.append(" key TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "version";
        mAutoDBInfo.colsMap.put("version", "INTEGER");
        sb.append(" version INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
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
        AppMethodBeat.o(44312);
    }
}
