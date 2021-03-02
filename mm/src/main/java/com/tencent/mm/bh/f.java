package com.tencent.mm.bh;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eq;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class f extends eq {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(151162);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[10];
        mAutoDBInfo.columns = new String[11];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "wxGroupId";
        mAutoDBInfo.colsMap.put("wxGroupId", "TEXT PRIMARY KEY ");
        sb.append(" wxGroupId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "wxGroupId";
        mAutoDBInfo.columns[1] = "groupId";
        mAutoDBInfo.colsMap.put("groupId", "TEXT");
        sb.append(" groupId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "roomId";
        mAutoDBInfo.colsMap.put("roomId", "INTEGER");
        sb.append(" roomId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "roomKey";
        mAutoDBInfo.colsMap.put("roomKey", "LONG");
        sb.append(" roomKey LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "routeId";
        mAutoDBInfo.colsMap.put("routeId", "INTEGER");
        sb.append(" routeId INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "inviteUserName";
        mAutoDBInfo.colsMap.put("inviteUserName", "TEXT");
        sb.append(" inviteUserName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "memberCount";
        mAutoDBInfo.colsMap.put("memberCount", "INTEGER");
        sb.append(" memberCount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER default '0' ");
        sb.append(" state INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "ilinkRoomId";
        mAutoDBInfo.colsMap.put("ilinkRoomId", "LONG");
        sb.append(" ilinkRoomId LONG");
        mAutoDBInfo.columns[10] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(151162);
    }
}
