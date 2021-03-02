package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ic;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.lang.reflect.Field;

public final class bk extends ic implements b {
    static final IAutoDBItem.MAutoDBInfo iBg;
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(iBg, "WxaPluginCodeVersionInfo")};
    static final String[] kOf = {"pluginAppID", "pluginAppVersion"};

    static {
        AppMethodBeat.i(182787);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "pluginAppID";
        mAutoDBInfo.colsMap.put("pluginAppID", "TEXT");
        sb.append(" pluginAppID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "pluginAppVersion";
        mAutoDBInfo.colsMap.put("pluginAppVersion", "INTEGER");
        sb.append(" pluginAppVersion INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "pluginStringVersion";
        mAutoDBInfo.colsMap.put("pluginStringVersion", "TEXT");
        sb.append(" pluginStringVersion TEXT");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        String str = " PRIMARY KEY (";
        String[] strArr = kOf;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = str + ", " + strArr[i2];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb2 = new StringBuilder();
        IAutoDBItem.MAutoDBInfo mAutoDBInfo2 = iBg;
        mAutoDBInfo2.sql = sb2.append(mAutoDBInfo2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(182787);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    @Override // com.tencent.mm.plugin.appbrand.ab.b
    public final String[] getKeys() {
        return kOf;
    }
}
