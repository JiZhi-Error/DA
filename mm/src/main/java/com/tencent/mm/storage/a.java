package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends c {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean isValid() {
        AppMethodBeat.i(153149);
        long nowSecond = Util.nowSecond();
        if (nowSecond < this.field_startTime || nowSecond >= this.field_endTime) {
            AppMethodBeat.o(153149);
            return false;
        }
        AppMethodBeat.o(153149);
        return true;
    }

    static {
        AppMethodBeat.i(153150);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "abtestkey";
        mAutoDBInfo.colsMap.put("abtestkey", "TEXT PRIMARY KEY ");
        sb.append(" abtestkey TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "abtestkey";
        mAutoDBInfo.columns[1] = "value";
        mAutoDBInfo.colsMap.put("value", "TEXT");
        sb.append(" value TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "expId";
        mAutoDBInfo.colsMap.put("expId", "TEXT");
        sb.append(" expId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "sequence";
        mAutoDBInfo.colsMap.put("sequence", "LONG");
        sb.append(" sequence LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "prioritylevel";
        mAutoDBInfo.colsMap.put("prioritylevel", "INTEGER");
        sb.append(" prioritylevel INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "startTime";
        mAutoDBInfo.colsMap.put("startTime", "LONG");
        sb.append(" startTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "endTime";
        mAutoDBInfo.colsMap.put("endTime", "LONG");
        sb.append(" endTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "noReport";
        mAutoDBInfo.colsMap.put("noReport", "INTEGER");
        sb.append(" noReport INTEGER");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(153150);
    }
}
