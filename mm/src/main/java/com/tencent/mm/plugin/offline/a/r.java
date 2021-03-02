package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ex;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class r extends ex {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(66319);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "reqkey";
        mAutoDBInfo.colsMap.put("reqkey", "TEXT PRIMARY KEY ");
        sb.append(" reqkey TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "reqkey";
        mAutoDBInfo.columns[1] = "ack_key";
        mAutoDBInfo.colsMap.put("ack_key", "TEXT");
        sb.append(" ack_key TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "receive_time";
        mAutoDBInfo.colsMap.put("receive_time", "LONG");
        sb.append(" receive_time LONG");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(66319);
    }
}
