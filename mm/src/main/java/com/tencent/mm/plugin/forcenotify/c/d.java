package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cq;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import java.lang.reflect.Field;

public final class d extends cq {
    public static IAutoDBItem.MAutoDBInfo info;
    public as contact = null;

    public final boolean dMp() {
        AppMethodBeat.i(149134);
        if (cl.aWy() >= this.field_ExpiredTime) {
            AppMethodBeat.o(149134);
            return true;
        }
        AppMethodBeat.o(149134);
        return false;
    }

    public final boolean isEnable() {
        return this.field_Status == 1;
    }

    public final String toString() {
        AppMethodBeat.i(149135);
        String str = this.field_ForcePushId + " " + this.field_UserName + " " + this.field_CreateTime + " " + this.field_ExpiredTime + " " + this.field_Status;
        AppMethodBeat.o(149135);
        return str;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(149136);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "ForcePushId";
        mAutoDBInfo.colsMap.put("ForcePushId", "TEXT PRIMARY KEY ");
        sb.append(" ForcePushId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "ForcePushId";
        mAutoDBInfo.columns[1] = "CreateTime";
        mAutoDBInfo.colsMap.put("CreateTime", "LONG");
        sb.append(" CreateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "ExpiredTime";
        mAutoDBInfo.colsMap.put("ExpiredTime", "LONG");
        sb.append(" ExpiredTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "Description";
        mAutoDBInfo.colsMap.put("Description", "TEXT");
        sb.append(" Description TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "UserIcon";
        mAutoDBInfo.colsMap.put("UserIcon", "TEXT");
        sb.append(" UserIcon TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "UserName";
        mAutoDBInfo.colsMap.put("UserName", "TEXT");
        sb.append(" UserName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "ExtInfo";
        mAutoDBInfo.colsMap.put("ExtInfo", "TEXT");
        sb.append(" ExtInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "Status";
        mAutoDBInfo.colsMap.put("Status", "INTEGER default '0' ");
        sb.append(" Status INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "Type";
        mAutoDBInfo.colsMap.put("Type", "INTEGER default '0' ");
        sb.append(" Type INTEGER default '0' ");
        mAutoDBInfo.columns[9] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(149136);
    }
}
