package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eh;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class n extends eh {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(70302);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT PRIMARY KEY ");
        sb.append(" title TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "title";
        mAutoDBInfo.columns[1] = "loan_jump_url";
        mAutoDBInfo.colsMap.put("loan_jump_url", "TEXT");
        sb.append(" loan_jump_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "red_dot_index";
        mAutoDBInfo.colsMap.put("red_dot_index", "INTEGER");
        sb.append(" red_dot_index INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "is_show_entry";
        mAutoDBInfo.colsMap.put("is_show_entry", "INTEGER");
        sb.append(" is_show_entry INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "tips";
        mAutoDBInfo.colsMap.put("tips", "TEXT");
        sb.append(" tips TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "is_overdue";
        mAutoDBInfo.colsMap.put("is_overdue", "INTEGER");
        sb.append(" is_overdue INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "available_otb";
        mAutoDBInfo.colsMap.put("available_otb", "TEXT");
        sb.append(" available_otb TEXT");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70302);
    }
}
