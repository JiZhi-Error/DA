package com.tencent.mm.plugin.appbrand.appcache.predownload.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.x;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class b extends x implements com.tencent.mm.plugin.appbrand.ab.b {
    static final IAutoDBItem.MAutoDBInfo iBg;
    static final String[] kJX = {"appId", "version", "packageType", "packageKey"};

    static {
        AppMethodBeat.i(44430);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "version";
        mAutoDBInfo.colsMap.put("version", "INTEGER");
        sb.append(" version INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "packageType";
        mAutoDBInfo.colsMap.put("packageType", "INTEGER");
        sb.append(" packageType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "packageKey";
        mAutoDBInfo.colsMap.put("packageKey", "TEXT");
        sb.append(" packageKey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "source";
        mAutoDBInfo.colsMap.put("source", "INTEGER default '0' ");
        sb.append(" source INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "hitCount";
        mAutoDBInfo.colsMap.put("hitCount", "INTEGER default '0' ");
        sb.append(" hitCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "reportId";
        mAutoDBInfo.colsMap.put("reportId", "INTEGER default '0' ");
        sb.append(" reportId INTEGER default '0' ");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        StringBuilder sb2 = new StringBuilder();
        IAutoDBItem.MAutoDBInfo mAutoDBInfo2 = iBg;
        mAutoDBInfo2.sql = sb2.append(mAutoDBInfo2.sql).append(b.a.t(kJX)).toString();
        AppMethodBeat.o(44430);
    }

    @Override // com.tencent.mm.plugin.appbrand.ab.b
    public final String[] getKeys() {
        return kJX;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }
}
