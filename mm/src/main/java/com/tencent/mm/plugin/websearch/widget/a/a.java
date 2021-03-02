package com.tencent.mm.plugin.websearch.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hv;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends hv {
    public static IAutoDBItem.MAutoDBInfo info;

    static {
        AppMethodBeat.i(116652);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appid";
        mAutoDBInfo.colsMap.put("appid", "TEXT PRIMARY KEY ");
        sb.append(" appid TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appid";
        mAutoDBInfo.columns[1] = "jsExceptionCount";
        mAutoDBInfo.colsMap.put("jsExceptionCount", "INTEGER");
        sb.append(" jsExceptionCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "crashCount";
        mAutoDBInfo.colsMap.put("crashCount", "INTEGER");
        sb.append(" crashCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "beginTimestamp";
        mAutoDBInfo.colsMap.put("beginTimestamp", "LONG");
        sb.append(" beginTimestamp LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "pkgVersion";
        mAutoDBInfo.colsMap.put("pkgVersion", "INTEGER");
        sb.append(" pkgVersion INTEGER");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(116652);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }
}
