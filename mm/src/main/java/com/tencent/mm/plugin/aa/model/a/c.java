package com.tencent.mm.plugin.aa.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends b {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(63423);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "billNo";
        mAutoDBInfo.colsMap.put("billNo", "TEXT PRIMARY KEY ");
        sb.append(" billNo TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "billNo";
        mAutoDBInfo.columns[1] = "insertmsg";
        mAutoDBInfo.colsMap.put("insertmsg", "INTEGER");
        sb.append(" insertmsg INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "localMsgId";
        mAutoDBInfo.colsMap.put("localMsgId", "LONG");
        sb.append(" localMsgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '-1' ");
        sb.append(" status INTEGER default '-1' ");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(63423);
    }
}
