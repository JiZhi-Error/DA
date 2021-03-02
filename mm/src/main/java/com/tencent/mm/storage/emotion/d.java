package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bk;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class d extends bk {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    public final String getMd5() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    static {
        AppMethodBeat.i(105049);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "md5_lang";
        mAutoDBInfo.colsMap.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        sb.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "md5_lang";
        mAutoDBInfo.columns[1] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT COLLATE NOCASE ");
        sb.append(" md5 TEXT COLLATE NOCASE ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "lang";
        mAutoDBInfo.colsMap.put("lang", "TEXT COLLATE NOCASE ");
        sb.append(" lang TEXT COLLATE NOCASE ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "desc";
        mAutoDBInfo.colsMap.put("desc", "TEXT");
        sb.append(" desc TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "groupId";
        mAutoDBInfo.colsMap.put("groupId", "TEXT default '' ");
        sb.append(" groupId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "click_flag";
        mAutoDBInfo.colsMap.put("click_flag", "INTEGER");
        sb.append(" click_flag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "download_flag";
        mAutoDBInfo.colsMap.put("download_flag", "INTEGER");
        sb.append(" download_flag INTEGER");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(105049);
    }
}
