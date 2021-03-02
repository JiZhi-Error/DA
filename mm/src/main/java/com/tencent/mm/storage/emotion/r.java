package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dg;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class r extends dg {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public r(String str, byte[] bArr) {
        this.field_reqType = str;
        this.field_cache = bArr;
    }

    public r(Cursor cursor) {
        AppMethodBeat.i(105126);
        if (cursor == null) {
            AppMethodBeat.o(105126);
            return;
        }
        convertFrom(cursor);
        AppMethodBeat.o(105126);
    }

    static {
        AppMethodBeat.i(105127);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "reqType";
        mAutoDBInfo.colsMap.put("reqType", "TEXT PRIMARY KEY ");
        sb.append(" reqType TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "reqType";
        mAutoDBInfo.columns[1] = "cache";
        mAutoDBInfo.colsMap.put("cache", "BLOB default '' ");
        sb.append(" cache BLOB default '' ");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(105127);
    }
}
