package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.el;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class u extends el {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(65223);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "subtype";
        mAutoDBInfo.colsMap.put("subtype", "INTEGER PRIMARY KEY ");
        sb.append(" subtype INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "subtype";
        mAutoDBInfo.columns[1] = "bubbleMd5";
        mAutoDBInfo.colsMap.put("bubbleMd5", "TEXT");
        sb.append(" bubbleMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "coverMd5";
        mAutoDBInfo.colsMap.put("coverMd5", "TEXT");
        sb.append(" coverMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "minilogoMd5";
        mAutoDBInfo.colsMap.put("minilogoMd5", "TEXT");
        sb.append(" minilogoMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "detailMd5";
        mAutoDBInfo.colsMap.put("detailMd5", "TEXT");
        sb.append(" detailMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "version";
        mAutoDBInfo.colsMap.put("version", "INTEGER");
        sb.append(" version INTEGER");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(65223);
    }
}
