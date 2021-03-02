package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bo;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class l extends bo {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(105115);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "productID";
        mAutoDBInfo.colsMap.put("productID", "TEXT PRIMARY KEY ");
        sb.append(" productID TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "productID";
        mAutoDBInfo.columns[1] = "content";
        mAutoDBInfo.colsMap.put("content", "BLOB default '' ");
        sb.append(" content BLOB default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "lan";
        mAutoDBInfo.colsMap.put("lan", "TEXT default '' ");
        sb.append(" lan TEXT default '' ");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(105115);
    }
}
