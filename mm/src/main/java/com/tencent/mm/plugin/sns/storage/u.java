package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.go;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class u extends go {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(203216);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "groupId";
        mAutoDBInfo.colsMap.put("groupId", "LONG PRIMARY KEY ");
        sb.append(" groupId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "groupId";
        mAutoDBInfo.columns[1] = "groupTime";
        mAutoDBInfo.colsMap.put("groupTime", "INTEGER");
        sb.append(" groupTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "groupStrcut";
        mAutoDBInfo.colsMap.put("groupStrcut", "BLOB");
        sb.append(" groupStrcut BLOB");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(203216);
    }
}
