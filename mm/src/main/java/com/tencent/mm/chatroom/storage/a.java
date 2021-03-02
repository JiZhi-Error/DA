package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dj;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends dj {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.dj, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(194050);
        super.convertFrom(cursor);
        AppMethodBeat.o(194050);
    }

    static {
        AppMethodBeat.i(194051);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "chatRoomName";
        mAutoDBInfo.colsMap.put("chatRoomName", "TEXT default '群username'  PRIMARY KEY ");
        sb.append(" chatRoomName TEXT default '群username'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "chatRoomName";
        mAutoDBInfo.columns[1] = "BindAppData";
        mAutoDBInfo.colsMap.put("BindAppData", "BLOB");
        sb.append(" BindAppData BLOB");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(194051);
    }
}
