package com.tencent.mm.plugin.aa.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends com.tencent.mm.g.c.a {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(63420);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "payMsgId";
        mAutoDBInfo.colsMap.put("payMsgId", "TEXT PRIMARY KEY ");
        sb.append(" payMsgId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "payMsgId";
        mAutoDBInfo.columns[1] = "insertmsg";
        mAutoDBInfo.colsMap.put("insertmsg", "INTEGER");
        sb.append(" insertmsg INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "chatroom";
        mAutoDBInfo.colsMap.put("chatroom", "TEXT");
        sb.append(" chatroom TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG");
        sb.append(" msgId LONG");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(63420);
    }
}
