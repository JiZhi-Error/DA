package com.tencent.mm.plugin.f.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.hw;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class a extends hw {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.hw, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(22736);
        super.convertFrom(cursor);
        AppMethodBeat.o(22736);
    }

    public final String toString() {
        AppMethodBeat.i(22737);
        String str = "{  sys row id: " + this.systemRowid + " msg id : " + this.field_msgId + " msg talker: " + this.field_username + " msg type : " + this.field_msgType + " msg sub type : " + this.field_msgSubType + " path : " + this.field_path + " size : " + this.field_size + " msgtime : " + this.field_msgtime + " } ";
        AppMethodBeat.o(22737);
        return str;
    }

    static {
        AppMethodBeat.i(22738);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG");
        sb.append(" msgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[1] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "msgType";
        mAutoDBInfo.colsMap.put("msgType", "INTEGER");
        sb.append(" msgType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "msgSubType";
        mAutoDBInfo.colsMap.put("msgSubType", "INTEGER");
        sb.append(" msgSubType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "path";
        mAutoDBInfo.colsMap.put("path", "TEXT");
        sb.append(" path TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "size";
        mAutoDBInfo.colsMap.put("size", "LONG");
        sb.append(" size LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "msgtime";
        mAutoDBInfo.colsMap.put("msgtime", "LONG");
        sb.append(" msgtime LONG");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(22738);
    }
}
