package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class k extends aj {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean iE(int i2) {
        return (this.field_bitFlag & i2) != 0;
    }

    public final boolean bay() {
        AppMethodBeat.i(116442);
        if (this.field_needToUpdate) {
            AppMethodBeat.o(116442);
            return true;
        } else if (Util.isNullOrNil(this.field_profileUrl) && Util.isNullOrNil(this.field_headImageUrl)) {
            AppMethodBeat.o(116442);
            return true;
        } else if (!Util.isNullOrNil(this.field_userNamePY) || Util.isNullOrNil(this.field_userName)) {
            AppMethodBeat.o(116442);
            return false;
        } else {
            AppMethodBeat.o(116442);
            return true;
        }
    }

    static {
        AppMethodBeat.i(116443);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[10];
        mAutoDBInfo.columns = new String[11];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "userId";
        mAutoDBInfo.colsMap.put("userId", "TEXT PRIMARY KEY ");
        sb.append(" userId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "userId";
        mAutoDBInfo.columns[1] = "userName";
        mAutoDBInfo.colsMap.put("userName", "TEXT default '' ");
        sb.append(" userName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "userNamePY";
        mAutoDBInfo.colsMap.put("userNamePY", "TEXT default '' ");
        sb.append(" userNamePY TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "brandUserName";
        mAutoDBInfo.colsMap.put("brandUserName", "TEXT default '' ");
        sb.append(" brandUserName TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "UserVersion";
        mAutoDBInfo.colsMap.put("UserVersion", "INTEGER default '-1' ");
        sb.append(" UserVersion INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "needToUpdate";
        mAutoDBInfo.colsMap.put("needToUpdate", "INTEGER default 'true' ");
        sb.append(" needToUpdate INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "headImageUrl";
        mAutoDBInfo.colsMap.put("headImageUrl", "TEXT");
        sb.append(" headImageUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "profileUrl";
        mAutoDBInfo.colsMap.put("profileUrl", "TEXT");
        sb.append(" profileUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "bitFlag";
        mAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
        sb.append(" bitFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "addMemberUrl";
        mAutoDBInfo.colsMap.put("addMemberUrl", "TEXT");
        sb.append(" addMemberUrl TEXT");
        mAutoDBInfo.columns[10] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(116443);
    }
}
