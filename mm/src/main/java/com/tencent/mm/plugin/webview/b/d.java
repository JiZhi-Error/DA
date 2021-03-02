package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ho;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class d extends ho {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(77856);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "recordId";
        mAutoDBInfo.colsMap.put("recordId", "TEXT PRIMARY KEY ");
        sb.append(" recordId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "recordId";
        mAutoDBInfo.columns[1] = "link";
        mAutoDBInfo.colsMap.put("link", "TEXT");
        sb.append(" link TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "source";
        mAutoDBInfo.colsMap.put("source", "TEXT");
        sb.append(" source TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "imgUrl";
        mAutoDBInfo.colsMap.put("imgUrl", "TEXT");
        sb.append(" imgUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "timeStamp";
        mAutoDBInfo.colsMap.put("timeStamp", "LONG");
        sb.append(" timeStamp LONG");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(77856);
    }
}
