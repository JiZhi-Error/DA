package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class au extends az {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(32839);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "labelID";
        mAutoDBInfo.colsMap.put("labelID", "INTEGER PRIMARY KEY ");
        sb.append(" labelID INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "labelID";
        mAutoDBInfo.columns[1] = "labelName";
        mAutoDBInfo.colsMap.put("labelName", "TEXT");
        sb.append(" labelName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "labelPYFull";
        mAutoDBInfo.colsMap.put("labelPYFull", "TEXT");
        sb.append(" labelPYFull TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "labelPYShort";
        mAutoDBInfo.colsMap.put("labelPYShort", "TEXT");
        sb.append(" labelPYShort TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "isTemporary";
        mAutoDBInfo.colsMap.put("isTemporary", "INTEGER");
        sb.append(" isTemporary INTEGER");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(32839);
    }
}
