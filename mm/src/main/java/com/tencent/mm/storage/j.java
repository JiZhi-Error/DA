package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ab;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class j extends ab {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(32817);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "deviceId";
        mAutoDBInfo.colsMap.put("deviceId", "TEXT default '' ");
        sb.append(" deviceId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "sessionName";
        mAutoDBInfo.colsMap.put("sessionName", "TEXT default '' ");
        sb.append(" sessionName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "moveTime";
        mAutoDBInfo.colsMap.put("moveTime", "BLOB default '' ");
        sb.append(" moveTime BLOB default '' ");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(32817);
    }
}
