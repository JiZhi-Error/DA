package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bn;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class j extends bn {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    static {
        AppMethodBeat.i(105108);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "designerIDAndType";
        mAutoDBInfo.colsMap.put("designerIDAndType", "TEXT PRIMARY KEY ");
        sb.append(" designerIDAndType TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "designerIDAndType";
        mAutoDBInfo.columns[1] = "content";
        mAutoDBInfo.colsMap.put("content", "BLOB default '' ");
        sb.append(" content BLOB default '' ");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(105108);
    }
}
