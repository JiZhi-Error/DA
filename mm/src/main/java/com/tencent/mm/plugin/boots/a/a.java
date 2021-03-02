package com.tencent.mm.plugin.boots.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.e;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends e {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(123715);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "key";
        mAutoDBInfo.colsMap.put("key", "INTEGER PRIMARY KEY  COLLATE NOCASE ");
        sb.append(" key INTEGER PRIMARY KEY  COLLATE NOCASE ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "key";
        mAutoDBInfo.columns[1] = "mau";
        mAutoDBInfo.colsMap.put("mau", "INTEGER");
        sb.append(" mau INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "dau";
        mAutoDBInfo.colsMap.put("dau", "INTEGER");
        sb.append(" dau INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "useTime";
        mAutoDBInfo.colsMap.put("useTime", "LONG");
        sb.append(" useTime LONG");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(123715);
    }
}
