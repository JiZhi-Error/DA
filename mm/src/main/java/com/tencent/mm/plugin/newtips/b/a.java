package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eu;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.reflect.Field;

public final class a extends eu {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(127262);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "tipId";
        mAutoDBInfo.colsMap.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
        sb.append(" tipId INTEGER default '0'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "tipId";
        mAutoDBInfo.columns[1] = "tipVersion";
        mAutoDBInfo.colsMap.put("tipVersion", "INTEGER");
        sb.append(" tipVersion INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "tipkey";
        mAutoDBInfo.colsMap.put("tipkey", "TEXT");
        sb.append(" tipkey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "tipType";
        mAutoDBInfo.colsMap.put("tipType", "INTEGER");
        sb.append(" tipType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "isExit";
        mAutoDBInfo.colsMap.put("isExit", "INTEGER");
        sb.append(" isExit INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "hadRead";
        mAutoDBInfo.colsMap.put("hadRead", "INTEGER");
        sb.append(" hadRead INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "isReject";
        mAutoDBInfo.colsMap.put("isReject", "INTEGER");
        sb.append(" isReject INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "beginShowTime";
        mAutoDBInfo.colsMap.put("beginShowTime", "LONG");
        sb.append(" beginShowTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "disappearTime";
        mAutoDBInfo.colsMap.put("disappearTime", "LONG");
        sb.append(" disappearTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "overdueTime";
        mAutoDBInfo.colsMap.put("overdueTime", "LONG");
        sb.append(" overdueTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "tipsShowInfo";
        mAutoDBInfo.colsMap.put("tipsShowInfo", "BLOB");
        sb.append(" tipsShowInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[11] = IssueStorage.COLUMN_EXT_INFO;
        mAutoDBInfo.colsMap.put(IssueStorage.COLUMN_EXT_INFO, "TEXT");
        sb.append(" extInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "pagestaytime";
        mAutoDBInfo.colsMap.put("pagestaytime", "LONG");
        sb.append(" pagestaytime LONG");
        mAutoDBInfo.columns[13] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(127262);
    }
}
