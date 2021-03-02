package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ad;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class n extends ad {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(32833);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "sessionName";
        mAutoDBInfo.colsMap.put("sessionName", "TEXT default '' ");
        sb.append(" sessionName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "startTime";
        mAutoDBInfo.colsMap.put("startTime", "LONG default '0' ");
        sb.append(" startTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "endTime";
        mAutoDBInfo.colsMap.put("endTime", "LONG default '0' ");
        sb.append(" endTime LONG default '0' ");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(32833);
    }
}
