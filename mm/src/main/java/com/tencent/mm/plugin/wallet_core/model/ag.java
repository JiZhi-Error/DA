package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hj;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class ag extends hj {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(70435);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "pref_key";
        mAutoDBInfo.colsMap.put("pref_key", "TEXT PRIMARY KEY ");
        sb.append(" pref_key TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "pref_key";
        mAutoDBInfo.columns[1] = "pref_title";
        mAutoDBInfo.colsMap.put("pref_title", "TEXT");
        sb.append(" pref_title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "pref_url";
        mAutoDBInfo.colsMap.put("pref_url", "TEXT");
        sb.append(" pref_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "is_show";
        mAutoDBInfo.colsMap.put("is_show", "INTEGER default '1' ");
        sb.append(" is_show INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "pref_desc";
        mAutoDBInfo.colsMap.put("pref_desc", "TEXT");
        sb.append(" pref_desc TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "logo_url";
        mAutoDBInfo.colsMap.put("logo_url", "TEXT");
        sb.append(" logo_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "jump_type";
        mAutoDBInfo.colsMap.put("jump_type", "INTEGER");
        sb.append(" jump_type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "tinyapp_username";
        mAutoDBInfo.colsMap.put("tinyapp_username", "TEXT");
        sb.append(" tinyapp_username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "tinyapp_path";
        mAutoDBInfo.colsMap.put("tinyapp_path", "TEXT");
        sb.append(" tinyapp_path TEXT");
        mAutoDBInfo.columns[9] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70435);
    }
}
