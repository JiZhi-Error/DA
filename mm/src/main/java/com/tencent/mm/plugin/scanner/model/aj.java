package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class aj extends fx {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(120859);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "originMD5";
        mAutoDBInfo.colsMap.put("originMD5", "TEXT PRIMARY KEY ");
        sb.append(" originMD5 TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "originMD5";
        mAutoDBInfo.columns[1] = "resultFile";
        mAutoDBInfo.colsMap.put("resultFile", "TEXT");
        sb.append(" resultFile TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "fromLang";
        mAutoDBInfo.colsMap.put("fromLang", "TEXT");
        sb.append(" fromLang TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "toLang";
        mAutoDBInfo.colsMap.put("toLang", "TEXT");
        sb.append(" toLang TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "brand";
        mAutoDBInfo.colsMap.put("brand", "TEXT");
        sb.append(" brand TEXT");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(120859);
    }
}
