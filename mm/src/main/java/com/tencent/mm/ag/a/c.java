package com.tencent.mm.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ie;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends ie {
    public static IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(2616);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "shareKeyHash";
        mAutoDBInfo.colsMap.put("shareKeyHash", "INTEGER PRIMARY KEY ");
        sb.append(" shareKeyHash INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "shareKeyHash";
        mAutoDBInfo.columns[1] = "btnState";
        mAutoDBInfo.colsMap.put("btnState", "INTEGER");
        sb.append(" btnState INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "msgState";
        mAutoDBInfo.colsMap.put("msgState", "INTEGER");
        sb.append(" msgState INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "contentColor";
        mAutoDBInfo.colsMap.put("contentColor", "TEXT");
        sb.append(" contentColor TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "updatePeroid";
        mAutoDBInfo.colsMap.put("updatePeroid", "INTEGER");
        sb.append(" updatePeroid INTEGER");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(2616);
    }
}
