package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fl;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends fl implements b {
    static final IAutoDBItem.MAutoDBInfo iBg;
    static final String[] kJX = {"appId", "type", "version", "packageKey", "packageType"};

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(44437);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[16];
        mAutoDBInfo.columns = new String[17];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "version";
        mAutoDBInfo.colsMap.put("version", "INTEGER");
        sb.append(" version INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "retryTimes";
        mAutoDBInfo.colsMap.put("retryTimes", "INTEGER");
        sb.append(" retryTimes INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "retriedCount";
        mAutoDBInfo.colsMap.put("retriedCount", "INTEGER");
        sb.append(" retriedCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "retryInterval";
        mAutoDBInfo.colsMap.put("retryInterval", "LONG");
        sb.append(" retryInterval LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "networkType";
        mAutoDBInfo.colsMap.put("networkType", "INTEGER");
        sb.append(" networkType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "pkgMd5";
        mAutoDBInfo.colsMap.put("pkgMd5", "TEXT");
        sb.append(" pkgMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "packageKey";
        mAutoDBInfo.colsMap.put("packageKey", "TEXT");
        sb.append(" packageKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "packageType";
        mAutoDBInfo.colsMap.put("packageType", "INTEGER default '0' ");
        sb.append(" packageType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "lastRetryTime";
        mAutoDBInfo.colsMap.put("lastRetryTime", "LONG");
        sb.append(" lastRetryTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "firstTimeTried";
        mAutoDBInfo.colsMap.put("firstTimeTried", "INTEGER");
        sb.append(" firstTimeTried INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "reportId";
        mAutoDBInfo.colsMap.put("reportId", "INTEGER");
        sb.append(" reportId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "splitDownloadURLCgi";
        mAutoDBInfo.colsMap.put("splitDownloadURLCgi", "INTEGER");
        sb.append(" splitDownloadURLCgi INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "cmdSequence";
        mAutoDBInfo.colsMap.put("cmdSequence", "LONG");
        sb.append(" cmdSequence LONG");
        mAutoDBInfo.columns[16] = "rowid";
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
        AppMethodBeat.o(44437);
    }

    @Override // com.tencent.mm.plugin.appbrand.ab.b
    public final String[] getKeys() {
        return kJX;
    }
}
