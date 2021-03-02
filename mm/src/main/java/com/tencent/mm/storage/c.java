package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.d;
import com.tencent.mm.model.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c extends d implements Serializable {
    protected static IAutoDBItem.MAutoDBInfo info;
    private Map<String, String> NOK = null;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean isValid() {
        AppMethodBeat.i(153158);
        long nowSecond = Util.nowSecond();
        if (nowSecond < this.field_startTime || nowSecond > this.field_endTime) {
            AppMethodBeat.o(153158);
            return false;
        }
        AppMethodBeat.o(153158);
        return true;
    }

    public final Map<String, String> gzz() {
        AppMethodBeat.i(153159);
        if (this.NOK == null) {
            this.NOK = a.Le(this.field_rawXML);
        }
        Map<String, String> map = this.NOK;
        AppMethodBeat.o(153159);
        return map;
    }

    static {
        AppMethodBeat.i(153160);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "layerId";
        mAutoDBInfo.colsMap.put("layerId", "TEXT PRIMARY KEY ");
        sb.append(" layerId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "layerId";
        mAutoDBInfo.columns[1] = "business";
        mAutoDBInfo.colsMap.put("business", "TEXT");
        sb.append(" business TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "expId";
        mAutoDBInfo.colsMap.put("expId", "TEXT");
        sb.append(" expId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "sequence";
        mAutoDBInfo.colsMap.put("sequence", "LONG");
        sb.append(" sequence LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "prioritylevel";
        mAutoDBInfo.colsMap.put("prioritylevel", "INTEGER default '0' ");
        sb.append(" prioritylevel INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "startTime";
        mAutoDBInfo.colsMap.put("startTime", "LONG");
        sb.append(" startTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "endTime";
        mAutoDBInfo.colsMap.put("endTime", "LONG");
        sb.append(" endTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "needReport";
        mAutoDBInfo.colsMap.put("needReport", "INTEGER");
        sb.append(" needReport INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "rawXML";
        mAutoDBInfo.colsMap.put("rawXML", "TEXT default '' ");
        sb.append(" rawXML TEXT default '' ");
        mAutoDBInfo.columns[9] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(153160);
    }
}
