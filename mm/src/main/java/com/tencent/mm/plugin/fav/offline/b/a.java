package com.tencent.mm.plugin.fav.offline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bz;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends bz {
    protected static IAutoDBItem.MAutoDBInfo info;
    public boolean tcL = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String toString() {
        AppMethodBeat.i(73564);
        String str = "FavOffline{isMustWifi=" + this.tcL + ", field_url='" + this.field_url + '\'' + ", field_size=" + this.field_size + ", field_path='" + this.field_path + '\'' + ", field_imgDirPath='" + this.field_imgDirPath + '\'' + ", field_imgPaths='" + this.field_imgPaths + '\'' + ", field_favTime=" + this.field_favTime + ", field_updateTime=" + this.field_updateTime + ", field_status=" + this.field_status + ", field_failNum=" + this.field_failNum + ", field_isReport=" + this.field_isReport + ", systemRowid=" + this.systemRowid + '}';
        AppMethodBeat.o(73564);
        return str;
    }

    static {
        AppMethodBeat.i(73565);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[10];
        mAutoDBInfo.columns = new String[11];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "size";
        mAutoDBInfo.colsMap.put("size", "LONG");
        sb.append(" size LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "path";
        mAutoDBInfo.colsMap.put("path", "TEXT");
        sb.append(" path TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "imgDirPath";
        mAutoDBInfo.colsMap.put("imgDirPath", "TEXT");
        sb.append(" imgDirPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "imgPaths";
        mAutoDBInfo.colsMap.put("imgPaths", "TEXT");
        sb.append(" imgPaths TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "favTime";
        mAutoDBInfo.colsMap.put("favTime", "LONG");
        sb.append(" favTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "failNum";
        mAutoDBInfo.colsMap.put("failNum", "INTEGER");
        sb.append(" failNum INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "isReport";
        mAutoDBInfo.colsMap.put("isReport", "INTEGER");
        sb.append(" isReport INTEGER");
        mAutoDBInfo.columns[10] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(73565);
    }
}
