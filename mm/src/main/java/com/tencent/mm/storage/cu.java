package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class cu extends hc {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    public final void bkY(String str) {
        AppMethodBeat.i(148672);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(148672);
            return;
        }
        this.field_cmsgId = str;
        AppMethodBeat.o(148672);
    }

    static {
        AppMethodBeat.i(148673);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
        sb.append(" msgId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "msgId";
        mAutoDBInfo.columns[1] = "cmsgId";
        mAutoDBInfo.colsMap.put("cmsgId", "TEXT");
        sb.append(" cmsgId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT default '' ");
        sb.append(" content TEXT default '' ");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(148673);
    }
}
