package com.tencent.mm.plugin.exdevice.g.b.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.dp;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class e extends dp {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(23557);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "rankID";
        mAutoDBInfo.colsMap.put("rankID", "TEXT");
        sb.append(" rankID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "appusername";
        mAutoDBInfo.colsMap.put("appusername", "TEXT");
        sb.append(" appusername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = AppMeasurement.Param.TIMESTAMP;
        mAutoDBInfo.colsMap.put(AppMeasurement.Param.TIMESTAMP, "INTEGER default '0' ");
        sb.append(" timestamp INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "liketips";
        mAutoDBInfo.colsMap.put("liketips", "TEXT default '' ");
        sb.append(" liketips TEXT default '' ");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(23557);
    }
}
