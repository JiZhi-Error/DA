package com.tencent.mm.g.c;

import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class dy extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fNf = "logId".hashCode();
    private static final int fNg = "liftTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fNd = true;
    private boolean fNe = true;
    public long field_liftTime;
    public int field_logId;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "logId";
        mAutoDBInfo.colsMap.put("logId", "INTEGER PRIMARY KEY ");
        sb.append(" logId INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "logId";
        mAutoDBInfo.columns[1] = "liftTime";
        mAutoDBInfo.colsMap.put("liftTime", "LONG");
        sb.append(" liftTime LONG");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        return mAutoDBInfo;
    }
}
