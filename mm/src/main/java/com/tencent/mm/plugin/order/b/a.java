package com.tencent.mm.plugin.order.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fd;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends fd {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(66700);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "TEXT PRIMARY KEY ");
        sb.append(" msgId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "msgId";
        mAutoDBInfo.columns[1] = "msgContentXml";
        mAutoDBInfo.colsMap.put("msgContentXml", "TEXT");
        sb.append(" msgContentXml TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "isRead";
        mAutoDBInfo.colsMap.put("isRead", "TEXT");
        sb.append(" isRead TEXT");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(66700);
    }
}
