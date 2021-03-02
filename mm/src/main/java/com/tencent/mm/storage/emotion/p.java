package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bq;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class p extends bq {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    static {
        AppMethodBeat.i(105121);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "prodcutID";
        mAutoDBInfo.colsMap.put("prodcutID", "TEXT PRIMARY KEY ");
        sb.append(" prodcutID TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "prodcutID";
        mAutoDBInfo.columns[1] = "totalCount";
        mAutoDBInfo.colsMap.put("totalCount", "INTEGER");
        sb.append(" totalCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "continuCount";
        mAutoDBInfo.colsMap.put("continuCount", "INTEGER");
        sb.append(" continuCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "flag";
        mAutoDBInfo.colsMap.put("flag", "INTEGER");
        sb.append(" flag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "modifyTime";
        mAutoDBInfo.colsMap.put("modifyTime", "LONG");
        sb.append(" modifyTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "showTipsTime";
        mAutoDBInfo.colsMap.put("showTipsTime", "LONG");
        sb.append(" showTipsTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "setFlagTime";
        mAutoDBInfo.colsMap.put("setFlagTime", "LONG");
        sb.append(" setFlagTime LONG");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(105121);
    }
}
