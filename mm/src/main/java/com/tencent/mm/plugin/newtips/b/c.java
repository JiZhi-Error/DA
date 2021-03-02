package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ev;
import com.tencent.mm.g.c.f;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;
import java.util.Iterator;

public final class c extends ev {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public c() {
    }

    public c(String str, int i2, int i3, int i4, long j2, long j3, long j4, int i5, int i6, String str2) {
        this.field_uniqueId = str;
        this.field_tipId = i2;
        this.field_priority = i3;
        this.field_tipType = i4;
        this.field_beginShowTime = j2;
        this.field_overdueTime = j3;
        this.field_disappearTime = j4;
        this.field_minClientVersion = i5;
        this.field_maxClientVersion = i6;
        this.field_extInfo = str2;
    }

    public final String toString() {
        AppMethodBeat.i(127269);
        String str = "";
        if (!(this.field_parents == null || this.field_parents.gCs == null || this.field_parents.gCs.size() <= 0)) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.field_parents.gCs.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(",");
            }
            str = sb.toString();
        }
        String str2 = "NewTipsInfo{field_uniqueId='" + this.field_uniqueId + '\'' + ", field_path='" + this.field_path + '\'' + ", field_showType=" + this.field_showType + ", field_title='" + this.field_title + '\'' + ", field_icon_url='" + this.field_icon_url + '\'' + ", field_parents=" + str + ", field_tipId=" + this.field_tipId + ", field_priority=" + this.field_priority + ", field_tipType=" + this.field_tipType + ", field_beginShowTime=" + this.field_beginShowTime + ", field_overdueTime=" + this.field_overdueTime + ", field_disappearTime=" + this.field_disappearTime + ", field_minClientVersion=" + this.field_minClientVersion + ", field_maxClientVersion=" + this.field_maxClientVersion + ", field_state=" + this.field_state + ", field_dynamicPath='" + this.field_dynamicPath + '\'' + '}';
        AppMethodBeat.o(127269);
        return str2;
    }

    static {
        AppMethodBeat.i(127270);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[19];
        mAutoDBInfo.columns = new String[20];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "uniqueId";
        mAutoDBInfo.colsMap.put("uniqueId", "TEXT");
        sb.append(" uniqueId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "path";
        mAutoDBInfo.colsMap.put("path", "INTEGER");
        sb.append(" path INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "showType";
        mAutoDBInfo.colsMap.put("showType", "INTEGER");
        sb.append(" showType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "icon_url";
        mAutoDBInfo.colsMap.put("icon_url", "TEXT");
        sb.append(" icon_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "parents";
        mAutoDBInfo.colsMap.put("parents", "BLOB");
        sb.append(" parents BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "tipId";
        mAutoDBInfo.colsMap.put("tipId", "INTEGER");
        sb.append(" tipId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = DownloadInfo.PRIORITY;
        mAutoDBInfo.colsMap.put(DownloadInfo.PRIORITY, "INTEGER");
        sb.append(" priority INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "tipType";
        mAutoDBInfo.colsMap.put("tipType", "INTEGER");
        sb.append(" tipType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "beginShowTime";
        mAutoDBInfo.colsMap.put("beginShowTime", "LONG");
        sb.append(" beginShowTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = f.COL_EXPOSURETIME;
        mAutoDBInfo.colsMap.put(f.COL_EXPOSURETIME, "LONG");
        sb.append(" exposureTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "overdueTime";
        mAutoDBInfo.colsMap.put("overdueTime", "LONG");
        sb.append(" overdueTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "disappearTime";
        mAutoDBInfo.colsMap.put("disappearTime", "LONG");
        sb.append(" disappearTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "exposureDisappearTime";
        mAutoDBInfo.colsMap.put("exposureDisappearTime", "LONG");
        sb.append(" exposureDisappearTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "minClientVersion";
        mAutoDBInfo.colsMap.put("minClientVersion", "INTEGER");
        sb.append(" minClientVersion INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "maxClientVersion";
        mAutoDBInfo.colsMap.put("maxClientVersion", "INTEGER");
        sb.append(" maxClientVersion INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[16] = IssueStorage.COLUMN_EXT_INFO;
        mAutoDBInfo.colsMap.put(IssueStorage.COLUMN_EXT_INFO, "TEXT");
        sb.append(" extInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER default '0' ");
        sb.append(" state INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "dynamicPath";
        mAutoDBInfo.colsMap.put("dynamicPath", "TEXT");
        sb.append(" dynamicPath TEXT");
        mAutoDBInfo.columns[19] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(127270);
    }
}
