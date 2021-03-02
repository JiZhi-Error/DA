package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.lang.reflect.Field;

public final class a extends t implements b {
    static final IAutoDBItem.MAutoDBInfo iBg;
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(iBg, "AppBrandSeparatedPluginsCompatMarkTable")};
    public static final String[] kJX = {"appId", "appVersion"};

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(180190);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "appVersion";
        mAutoDBInfo.colsMap.put("appVersion", "INTEGER");
        sb.append(" appVersion INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "isSeparatedPluginsUsed";
        mAutoDBInfo.colsMap.put("isSeparatedPluginsUsed", "INTEGER");
        sb.append(" isSeparatedPluginsUsed INTEGER");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        String str = " PRIMARY KEY ( ";
        String[] strArr = kJX;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = str + ", " + strArr[i2];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb2 = new StringBuilder();
        IAutoDBItem.MAutoDBInfo mAutoDBInfo2 = iBg;
        mAutoDBInfo2.sql = sb2.append(mAutoDBInfo2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(180190);
    }

    @Override // com.tencent.mm.plugin.appbrand.ab.b
    public final String[] getKeys() {
        return kJX;
    }
}
