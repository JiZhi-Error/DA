package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class co extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS Finder_RedDot_tips_id ON FinderRedDotInfo(tipsId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_revoke_id ON FinderRedDotInfo(revokeId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_ctrType ON FinderRedDotInfo(ctrType)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_expiredTime ON FinderRedDotInfo(expiredTime)"};
    private static final int fGf = "tipsId".hashCode();
    private static final int fGg = "ctrInfo".hashCode();
    private static final int fGh = "revokeId".hashCode();
    private static final int fGi = "tipsShowEntranceExtInfo".hashCode();
    private static final int fGj = "ctrType".hashCode();
    private static final int fGk = "expiredTime".hashCode();
    private static final int frC = "time".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fFZ = true;
    private boolean fGa = true;
    private boolean fGb = true;
    private boolean fGc = true;
    private boolean fGd = true;
    private boolean fGe = true;
    public bbi field_ctrInfo;
    public int field_ctrType;
    public long field_expiredTime;
    public String field_revokeId;
    public long field_time;
    public String field_tipsId;
    public FinderTipsShowEntranceExtInfo field_tipsShowEntranceExtInfo;
    private boolean frj = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "tipsId";
        mAutoDBInfo.colsMap.put("tipsId", "TEXT PRIMARY KEY ");
        sb.append(" tipsId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "tipsId";
        mAutoDBInfo.columns[1] = "ctrInfo";
        mAutoDBInfo.colsMap.put("ctrInfo", "BLOB");
        sb.append(" ctrInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "time";
        mAutoDBInfo.colsMap.put("time", "LONG");
        sb.append(" time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "revokeId";
        mAutoDBInfo.colsMap.put("revokeId", "TEXT");
        sb.append(" revokeId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "tipsShowEntranceExtInfo";
        mAutoDBInfo.colsMap.put("tipsShowEntranceExtInfo", "BLOB");
        sb.append(" tipsShowEntranceExtInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "ctrType";
        mAutoDBInfo.colsMap.put("ctrType", "INTEGER");
        sb.append(" ctrType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "expiredTime";
        mAutoDBInfo.colsMap.put("expiredTime", "LONG");
        sb.append(" expiredTime LONG");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        return mAutoDBInfo;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fGf == hashCode) {
                    this.field_tipsId = cursor.getString(i2);
                    this.fFZ = true;
                } else if (fGg == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_ctrInfo = (bbi) new bbi().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", e2.getMessage());
                    }
                } else if (frC == hashCode) {
                    this.field_time = cursor.getLong(i2);
                } else if (fGh == hashCode) {
                    this.field_revokeId = cursor.getString(i2);
                } else if (fGi == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_tipsShowEntranceExtInfo = (FinderTipsShowEntranceExtInfo) new FinderTipsShowEntranceExtInfo().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", e3.getMessage());
                    }
                } else if (fGj == hashCode) {
                    this.field_ctrType = cursor.getInt(i2);
                } else if (fGk == hashCode) {
                    this.field_expiredTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fFZ) {
            contentValues.put("tipsId", this.field_tipsId);
        }
        if (this.fGa && this.field_ctrInfo != null) {
            try {
                contentValues.put("ctrInfo", this.field_ctrInfo.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", e2.getMessage());
            }
        }
        if (this.frj) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.fGb) {
            contentValues.put("revokeId", this.field_revokeId);
        }
        if (this.fGc && this.field_tipsShowEntranceExtInfo != null) {
            try {
                contentValues.put("tipsShowEntranceExtInfo", this.field_tipsShowEntranceExtInfo.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", e3.getMessage());
            }
        }
        if (this.fGd) {
            contentValues.put("ctrType", Integer.valueOf(this.field_ctrType));
        }
        if (this.fGe) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
