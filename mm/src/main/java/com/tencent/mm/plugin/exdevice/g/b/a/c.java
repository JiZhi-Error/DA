package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.dr;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends dr {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String toString() {
        AppMethodBeat.i(23553);
        String str = ("{" + "username: " + this.field_username + " step: " + this.field_step + " rankId: " + this.field_rankID + " appname: " + this.field_appusername) + "}";
        AppMethodBeat.o(23553);
        return str;
    }

    static {
        AppMethodBeat.i(23554);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appusername";
        mAutoDBInfo.colsMap.put("appusername", "TEXT");
        sb.append(" appusername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "rankID";
        mAutoDBInfo.colsMap.put("rankID", "TEXT");
        sb.append(" rankID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "step";
        mAutoDBInfo.colsMap.put("step", "INTEGER");
        sb.append(" step INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "sort";
        mAutoDBInfo.colsMap.put("sort", "INTEGER default '0' ");
        sb.append(" sort INTEGER default '0' ");
        mAutoDBInfo.columns[5] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(23554);
    }
}
