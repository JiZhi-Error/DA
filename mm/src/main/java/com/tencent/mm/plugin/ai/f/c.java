package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cn;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public final class c extends cn {
    public static IAutoDBItem.MAutoDBInfo info;
    public SimpleDateFormat kxO = null;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String toString() {
        AppMethodBeat.i(238939);
        String str = "FinderRedDotHistory{field_ds=" + this.field_ds + ", field_hour=" + this.field_hour + ", field_actionMs=" + this.field_actionMs + ", field_isGoToFinderUI=" + this.field_isGoToFinderUI + ", systemRowid=" + this.systemRowid + '}';
        AppMethodBeat.o(238939);
        return str;
    }

    static {
        AppMethodBeat.i(238940);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "ds";
        mAutoDBInfo.colsMap.put("ds", "INTEGER");
        sb.append(" ds INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "hour";
        mAutoDBInfo.colsMap.put("hour", "INTEGER");
        sb.append(" hour INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "actionMs";
        mAutoDBInfo.colsMap.put("actionMs", "LONG");
        sb.append(" actionMs LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "isGoToFinderUI";
        mAutoDBInfo.colsMap.put("isGoToFinderUI", "INTEGER");
        sb.append(" isGoToFinderUI INTEGER");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(238940);
    }
}
