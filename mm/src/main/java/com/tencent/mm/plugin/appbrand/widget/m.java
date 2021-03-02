package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.Cif;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class m extends Cif {
    public static IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    static {
        AppMethodBeat.i(76411);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appIdHash";
        mAutoDBInfo.colsMap.put("appIdHash", "INTEGER PRIMARY KEY ");
        sb.append(" appIdHash INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "appIdHash";
        mAutoDBInfo.columns[1] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "openDebug";
        mAutoDBInfo.colsMap.put("openDebug", "INTEGER");
        sb.append(" openDebug INTEGER");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(76411);
    }
}
