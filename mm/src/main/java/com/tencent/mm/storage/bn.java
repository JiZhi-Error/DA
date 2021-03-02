package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bu;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class bn extends bu {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean gCT() {
        return this.field_isSend % 2 == 0;
    }

    static {
        AppMethodBeat.i(43198);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgContent";
        mAutoDBInfo.colsMap.put("msgContent", "TEXT default '' ");
        sb.append(" msgContent TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER default '0' ");
        sb.append(" isSend INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT default '' ");
        sb.append(" talker TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "encryptTalker";
        mAutoDBInfo.colsMap.put("encryptTalker", "TEXT default '' ");
        sb.append(" encryptTalker TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "svrId";
        mAutoDBInfo.colsMap.put("svrId", "LONG default '0' ");
        sb.append(" svrId LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
        sb.append(" type INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
        sb.append(" createTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "chatroomName";
        mAutoDBInfo.colsMap.put("chatroomName", "TEXT default '' ");
        sb.append(" chatroomName TEXT default '' ");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(43198);
    }
}
