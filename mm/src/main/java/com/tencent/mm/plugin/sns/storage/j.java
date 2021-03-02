package com.tencent.mm.plugin.sns.storage;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gi;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class j extends gi {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(176284);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "key";
        mAutoDBInfo.colsMap.put("key", "TEXT default ''  PRIMARY KEY ");
        sb.append(" key TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "key";
        mAutoDBInfo.columns[1] = AppMeasurement.Param.TIMESTAMP;
        mAutoDBInfo.colsMap.put(AppMeasurement.Param.TIMESTAMP, "LONG default '0' ");
        sb.append(" timestamp LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "extFlag";
        mAutoDBInfo.colsMap.put("extFlag", "INTEGER default '0' ");
        sb.append(" extFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "draft";
        mAutoDBInfo.colsMap.put("draft", "BLOB");
        sb.append(" draft BLOB");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(176284);
    }
}
