package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class g extends dv {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(25548);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "svrId";
        mAutoDBInfo.colsMap.put("svrId", "LONG PRIMARY KEY ");
        sb.append(" svrId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "svrId";
        mAutoDBInfo.columns[1] = "isRead";
        mAutoDBInfo.colsMap.put("isRead", "SHORT default '0' ");
        sb.append(" isRead SHORT default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "pushTime";
        mAutoDBInfo.colsMap.put("pushTime", "LONG");
        sb.append(" pushTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "msgType";
        mAutoDBInfo.colsMap.put("msgType", "INTEGER");
        sb.append(" msgType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "descUrl";
        mAutoDBInfo.colsMap.put("descUrl", "TEXT");
        sb.append(" descUrl TEXT");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(25548);
    }
}
