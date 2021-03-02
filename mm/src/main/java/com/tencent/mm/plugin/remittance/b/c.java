package com.tencent.mm.plugin.remittance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fs;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends fs {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(67619);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "transferId";
        mAutoDBInfo.colsMap.put("transferId", "TEXT PRIMARY KEY ");
        sb.append(" transferId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "transferId";
        mAutoDBInfo.columns[1] = "locaMsgId";
        mAutoDBInfo.colsMap.put("locaMsgId", "LONG");
        sb.append(" locaMsgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "receiveStatus";
        mAutoDBInfo.colsMap.put("receiveStatus", "INTEGER default '-1' ");
        sb.append(" receiveStatus INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "isSend";
        mAutoDBInfo.colsMap.put("isSend", "INTEGER");
        sb.append(" isSend INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "talker";
        mAutoDBInfo.colsMap.put("talker", "TEXT");
        sb.append(" talker TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "invalidtime";
        mAutoDBInfo.colsMap.put("invalidtime", "LONG");
        sb.append(" invalidtime LONG");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(67619);
    }
}
