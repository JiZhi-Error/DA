package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fn;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class f extends fn implements b {
    static final IAutoDBItem.MAutoDBInfo iBg;
    static final String[] kJX = {"appId", "scene"};

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(44443);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "launchProtoBlob";
        mAutoDBInfo.colsMap.put("launchProtoBlob", "BLOB");
        sb.append(" launchProtoBlob BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "startTime";
        mAutoDBInfo.colsMap.put("startTime", "LONG");
        sb.append(" startTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "endTime";
        mAutoDBInfo.colsMap.put("endTime", "LONG");
        sb.append(" endTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "reportId";
        mAutoDBInfo.colsMap.put("reportId", "LONG");
        sb.append(" reportId LONG");
        mAutoDBInfo.columns[6] = "rowid";
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
        AppMethodBeat.o(44443);
    }

    @Override // com.tencent.mm.plugin.appbrand.ab.b
    public final String[] getKeys() {
        return kJX;
    }
}
