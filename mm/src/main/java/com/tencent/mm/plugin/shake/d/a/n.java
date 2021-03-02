package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.shake.a.a.c;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class n extends c {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(28347);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT default ''  PRIMARY KEY ");
        sb.append(" username TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[1] = "deeplink";
        mAutoDBInfo.colsMap.put("deeplink", "TEXT default '' ");
        sb.append(" deeplink TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT default '' ");
        sb.append(" title TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "iconurl";
        mAutoDBInfo.colsMap.put("iconurl", "TEXT default '' ");
        sb.append(" iconurl TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "createtime";
        mAutoDBInfo.colsMap.put("createtime", "LONG default '' ");
        sb.append(" createtime LONG default '' ");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(28347);
    }
}
