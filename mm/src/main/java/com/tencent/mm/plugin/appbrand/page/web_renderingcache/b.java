package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.hx;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.lang.reflect.Field;

public final class b extends hx implements com.tencent.mm.plugin.appbrand.ab.b {
    static final IAutoDBItem.MAutoDBInfo iBg;
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(iBg, "WxaAppWebRenderingCacheAccessStatsTable")};
    static final String[] kJX = {"appId", "commLibVersionId", "appVersionId", "pageURL"};

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    @Override // com.tencent.mm.plugin.appbrand.ab.b
    public final String[] getKeys() {
        return kJX;
    }

    static {
        AppMethodBeat.i(47973);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "commLibVersionId";
        mAutoDBInfo.colsMap.put("commLibVersionId", "TEXT");
        sb.append(" commLibVersionId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "appVersionId";
        mAutoDBInfo.colsMap.put("appVersionId", "TEXT");
        sb.append(" appVersionId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "pageURL";
        mAutoDBInfo.colsMap.put("pageURL", "TEXT");
        sb.append(" pageURL TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "accessTime";
        mAutoDBInfo.colsMap.put("accessTime", "LONG");
        sb.append(" accessTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "cacheFilePath";
        mAutoDBInfo.colsMap.put("cacheFilePath", "TEXT");
        sb.append(" cacheFilePath TEXT");
        mAutoDBInfo.columns[7] = "rowid";
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
        AppMethodBeat.o(47973);
    }
}
