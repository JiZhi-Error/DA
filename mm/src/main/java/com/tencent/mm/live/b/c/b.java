package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class b extends eg {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(224101);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "liveId";
        mAutoDBInfo.colsMap.put("liveId", "LONG default '0'  PRIMARY KEY ");
        sb.append(" liveId LONG default '0'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "liveId";
        mAutoDBInfo.columns[1] = "hostRoomId";
        mAutoDBInfo.colsMap.put("hostRoomId", "TEXT default '' ");
        sb.append(" hostRoomId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "liveName";
        mAutoDBInfo.colsMap.put("liveName", "TEXT default '' ");
        sb.append(" liveName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "thumbUrl";
        mAutoDBInfo.colsMap.put("thumbUrl", "TEXT default '' ");
        sb.append(" thumbUrl TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "anchorUsername";
        mAutoDBInfo.colsMap.put("anchorUsername", "TEXT default '' ");
        sb.append(" anchorUsername TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "isSender";
        mAutoDBInfo.colsMap.put("isSender", "INTEGER default 'false' ");
        sb.append(" isSender INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "timeStamp";
        mAutoDBInfo.colsMap.put("timeStamp", "LONG default '0' ");
        sb.append(" timeStamp LONG default '0' ");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(224101);
    }
}
