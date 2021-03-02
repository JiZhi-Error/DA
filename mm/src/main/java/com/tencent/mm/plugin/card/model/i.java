package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ar;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class i extends ar {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(112781);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "card_id";
        mAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
        sb.append(" card_id TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "card_id";
        mAutoDBInfo.columns[1] = "lower_bound";
        mAutoDBInfo.colsMap.put("lower_bound", "INTEGER");
        sb.append(" lower_bound INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "need_insert_show_timestamp";
        mAutoDBInfo.colsMap.put("need_insert_show_timestamp", "INTEGER default 'false' ");
        sb.append(" need_insert_show_timestamp INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "show_timestamp_encrypt_key";
        mAutoDBInfo.colsMap.put("show_timestamp_encrypt_key", "TEXT");
        sb.append(" show_timestamp_encrypt_key TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "expire_time_interval";
        mAutoDBInfo.colsMap.put("expire_time_interval", "INTEGER");
        sb.append(" expire_time_interval INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "show_expire_interval";
        mAutoDBInfo.colsMap.put("show_expire_interval", "INTEGER");
        sb.append(" show_expire_interval INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "fetch_time";
        mAutoDBInfo.colsMap.put("fetch_time", "LONG");
        sb.append(" fetch_time LONG");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(112781);
    }
}
