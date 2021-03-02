package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class al extends aw {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(197169);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
        sb.append(" createTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "modifyTime";
        mAutoDBInfo.colsMap.put("modifyTime", "LONG default '0' ");
        sb.append(" modifyTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "deleteTime";
        mAutoDBInfo.colsMap.put("deleteTime", "LONG default '0' ");
        sb.append(" deleteTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "id";
        mAutoDBInfo.colsMap.put("id", "TEXT default '' ");
        sb.append(" id TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "saveTime";
        mAutoDBInfo.colsMap.put("saveTime", "LONG default '0' ");
        sb.append(" saveTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "size";
        mAutoDBInfo.colsMap.put("size", "LONG default '0' ");
        sb.append(" size LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "flags";
        mAutoDBInfo.colsMap.put("flags", "LONG default '0' ");
        sb.append(" flags LONG default '0' ");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(197169);
    }
}
