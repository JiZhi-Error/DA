package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.a;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class f extends a {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(28128);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "svrid";
        mAutoDBInfo.colsMap.put("svrid", "LONG default '0'  PRIMARY KEY ");
        sb.append(" svrid LONG default '0'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "svrid";
        mAutoDBInfo.columns[1] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "subtype";
        mAutoDBInfo.colsMap.put("subtype", "INTEGER default '0' ");
        sb.append(" subtype INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "createtime";
        mAutoDBInfo.colsMap.put("createtime", "LONG");
        sb.append(" createtime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "tag";
        mAutoDBInfo.colsMap.put("tag", "TEXT");
        sb.append(" tag TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "desc";
        mAutoDBInfo.colsMap.put("desc", "TEXT");
        sb.append(" desc TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "thumburl";
        mAutoDBInfo.colsMap.put("thumburl", "TEXT");
        sb.append(" thumburl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "reserved1";
        mAutoDBInfo.colsMap.put("reserved1", "TEXT");
        sb.append(" reserved1 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "reserved2";
        mAutoDBInfo.colsMap.put("reserved2", "TEXT");
        sb.append(" reserved2 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "reserved3";
        mAutoDBInfo.colsMap.put("reserved3", "INTEGER");
        sb.append(" reserved3 INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "reservedBuf";
        mAutoDBInfo.colsMap.put("reservedBuf", "BLOB");
        sb.append(" reservedBuf BLOB");
        mAutoDBInfo.columns[13] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(28128);
    }
}
