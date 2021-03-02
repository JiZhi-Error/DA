package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.dn;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends dn {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(23551);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "championUrl";
        mAutoDBInfo.colsMap.put("championUrl", "TEXT");
        sb.append(" championUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "championMotto";
        mAutoDBInfo.colsMap.put("championMotto", "TEXT");
        sb.append(" championMotto TEXT");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(23551);
    }
}
