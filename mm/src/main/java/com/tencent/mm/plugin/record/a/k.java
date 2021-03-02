package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.fr;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class k extends fr implements c {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.plugin.record.a.c
    public final int getKey() {
        return this.field_localId;
    }

    static {
        AppMethodBeat.i(140938);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[10];
        mAutoDBInfo.columns = new String[11];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "INTEGER PRIMARY KEY ");
        sb.append(" localId INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG default '-1' ");
        sb.append(" msgId LONG default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "oriMsgId";
        mAutoDBInfo.colsMap.put("oriMsgId", "LONG default '-1' ");
        sb.append(" oriMsgId LONG default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "toUser";
        mAutoDBInfo.colsMap.put("toUser", "TEXT default '' ");
        sb.append(" toUser TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "desc";
        mAutoDBInfo.colsMap.put("desc", "TEXT");
        sb.append(" desc TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "dataProto";
        mAutoDBInfo.colsMap.put("dataProto", "BLOB");
        sb.append(" dataProto BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
        sb.append(" type INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
        sb.append(" status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "favFrom";
        mAutoDBInfo.colsMap.put("favFrom", "TEXT");
        sb.append(" favFrom TEXT");
        mAutoDBInfo.columns[10] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(140938);
    }
}
