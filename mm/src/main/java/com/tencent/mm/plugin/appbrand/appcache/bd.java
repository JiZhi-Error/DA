package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.w;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class bd extends w {
    static final IAutoDBItem.MAutoDBInfo iBg;
    public static final String[] kNu = {"appId", "version", "debugType"};

    static {
        AppMethodBeat.i(146004);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[10];
        mAutoDBInfo.columns = new String[11];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "version";
        mAutoDBInfo.colsMap.put("version", "INTEGER");
        sb.append(" version INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "versionMd5";
        mAutoDBInfo.colsMap.put("versionMd5", "TEXT");
        sb.append(" versionMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "NewMd5";
        mAutoDBInfo.colsMap.put("NewMd5", "TEXT");
        sb.append(" NewMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "pkgPath";
        mAutoDBInfo.colsMap.put("pkgPath", "TEXT");
        sb.append(" pkgPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "debugType";
        mAutoDBInfo.colsMap.put("debugType", "INTEGER default '0' ");
        sb.append(" debugType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "downloadURL";
        mAutoDBInfo.colsMap.put("downloadURL", "TEXT");
        sb.append(" downloadURL TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "startTime";
        mAutoDBInfo.colsMap.put("startTime", "LONG");
        sb.append(" startTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "endTime";
        mAutoDBInfo.colsMap.put("endTime", "LONG");
        sb.append(" endTime LONG");
        mAutoDBInfo.columns[10] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        String str = " PRIMARY KEY (";
        String[] strArr = kNu;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = str + ", " + strArr[i2];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb2 = new StringBuilder();
        IAutoDBItem.MAutoDBInfo mAutoDBInfo2 = iBg;
        mAutoDBInfo2.sql = sb2.append(mAutoDBInfo2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(146004);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }
}
