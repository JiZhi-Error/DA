package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class bq extends cu {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public bq(String str) {
        this();
        AppMethodBeat.i(225988);
        this.field_encryptUsername = str == null ? "" : str;
        this.field_modifyTime = System.currentTimeMillis();
        AppMethodBeat.o(225988);
    }

    public bq() {
        AppMethodBeat.i(225989);
        this.field_encryptUsername = "";
        this.field_username = "";
        AppMethodBeat.o(225989);
    }

    static {
        AppMethodBeat.i(225990);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "encryptUsername";
        mAutoDBInfo.colsMap.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        sb.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "encryptUsername";
        mAutoDBInfo.columns[1] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT default '' ");
        sb.append(" username TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "modifyTime";
        mAutoDBInfo.colsMap.put("modifyTime", "LONG default '0' ");
        sb.append(" modifyTime LONG default '0' ");
        mAutoDBInfo.columns[3] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(225990);
    }
}
