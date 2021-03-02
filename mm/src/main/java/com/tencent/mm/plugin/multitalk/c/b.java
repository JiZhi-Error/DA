package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.er;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class b extends er {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(114644);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "memberUuid";
        mAutoDBInfo.colsMap.put("memberUuid", "LONG");
        sb.append(" memberUuid LONG");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "wxGroupId";
        mAutoDBInfo.colsMap.put("wxGroupId", "TEXT");
        sb.append(" wxGroupId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "userName";
        mAutoDBInfo.colsMap.put("userName", "TEXT");
        sb.append(" userName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "inviteUserName";
        mAutoDBInfo.colsMap.put("inviteUserName", "TEXT");
        sb.append(" inviteUserName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "memberId";
        mAutoDBInfo.colsMap.put("memberId", "LONG");
        sb.append(" memberId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(114644);
    }
}
