package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dh;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class bt extends dh {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(43199);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "originSvrId";
        mAutoDBInfo.colsMap.put("originSvrId", "LONG PRIMARY KEY ");
        sb.append(" originSvrId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "originSvrId";
        mAutoDBInfo.columns[1] = "newMsgId";
        mAutoDBInfo.colsMap.put("newMsgId", "LONG");
        sb.append(" newMsgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "fromUserName";
        mAutoDBInfo.colsMap.put("fromUserName", "TEXT default '' ");
        sb.append(" fromUserName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "toUserName";
        mAutoDBInfo.colsMap.put("toUserName", "TEXT default '' ");
        sb.append(" toUserName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
        sb.append(" createTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT default '' ");
        sb.append(" content TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "msgSource";
        mAutoDBInfo.colsMap.put("msgSource", "TEXT default '' ");
        sb.append(" msgSource TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "msgSeq";
        mAutoDBInfo.colsMap.put("msgSeq", "INTEGER");
        sb.append(" msgSeq INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "flag";
        mAutoDBInfo.colsMap.put("flag", "INTEGER");
        sb.append(" flag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "reserved1";
        mAutoDBInfo.colsMap.put("reserved1", "INTEGER");
        sb.append(" reserved1 INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "reserved2";
        mAutoDBInfo.colsMap.put("reserved2", "LONG");
        sb.append(" reserved2 LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "reserved3";
        mAutoDBInfo.colsMap.put("reserved3", "TEXT default '' ");
        sb.append(" reserved3 TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "reserved4";
        mAutoDBInfo.colsMap.put("reserved4", "TEXT default '' ");
        sb.append(" reserved4 TEXT default '' ");
        mAutoDBInfo.columns[13] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(43199);
    }
}
