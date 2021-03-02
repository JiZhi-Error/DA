package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.fk;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends fk {
    static final IAutoDBItem.MAutoDBInfo iBg;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    public final String toString() {
        AppMethodBeat.i(44431);
        String str = "CmdBlockCgiPersistentInfo{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_startTime=" + this.field_startTime + ", field_endTime=" + this.field_endTime + ", field_sceneList='" + this.field_sceneList + '\'' + ", field_cgiList='" + this.field_cgiList + '\'' + ", field_reportId=" + this.field_reportId + '}';
        AppMethodBeat.o(44431);
        return str;
    }

    static {
        AppMethodBeat.i(44432);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT PRIMARY KEY ");
        sb.append(" username TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[1] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "startTime";
        mAutoDBInfo.colsMap.put("startTime", "LONG");
        sb.append(" startTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "endTime";
        mAutoDBInfo.colsMap.put("endTime", "LONG");
        sb.append(" endTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "sceneList";
        mAutoDBInfo.colsMap.put("sceneList", "TEXT");
        sb.append(" sceneList TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "cgiList";
        mAutoDBInfo.colsMap.put("cgiList", "TEXT");
        sb.append(" cgiList TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "reportId";
        mAutoDBInfo.colsMap.put("reportId", "INTEGER");
        sb.append(" reportId INTEGER");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        iBg = mAutoDBInfo;
        AppMethodBeat.o(44432);
    }
}
