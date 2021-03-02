package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class br extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjx = "startTime".hashCode();
    private static final int fjy = "endTime".hashCode();
    private static final int fyq = "groupId".hashCode();
    private static final int fzu = "exptId".hashCode();
    private static final int fzv = "exptSeq".hashCode();
    private static final int fzw = "exptContent".hashCode();
    private static final int fzx = "exptType".hashCode();
    private static final int fzy = "exptCheckSum".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int subType_HASHCODE = "subType".hashCode();
    private boolean __hadSetsubType = true;
    public long field_endTime;
    public String field_exptCheckSum;
    public String field_exptContent;
    public int field_exptId;
    public int field_exptSeq;
    public int field_exptType;
    public int field_groupId;
    public long field_startTime;
    public int field_subType;
    private boolean fjq = true;
    private boolean fjr = true;
    private boolean fxE = true;
    private boolean fzp = true;
    private boolean fzq = true;
    private boolean fzr = true;
    private boolean fzs = true;
    private boolean fzt = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fzu == hashCode) {
                    this.field_exptId = cursor.getInt(i2);
                    this.fzp = true;
                } else if (fyq == hashCode) {
                    this.field_groupId = cursor.getInt(i2);
                } else if (fzv == hashCode) {
                    this.field_exptSeq = cursor.getInt(i2);
                } else if (fzw == hashCode) {
                    this.field_exptContent = cursor.getString(i2);
                } else if (fjx == hashCode) {
                    this.field_startTime = cursor.getLong(i2);
                } else if (fjy == hashCode) {
                    this.field_endTime = cursor.getLong(i2);
                } else if (fzx == hashCode) {
                    this.field_exptType = cursor.getInt(i2);
                } else if (subType_HASHCODE == hashCode) {
                    this.field_subType = cursor.getInt(i2);
                } else if (fzy == hashCode) {
                    this.field_exptCheckSum = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fzp) {
            contentValues.put("exptId", Integer.valueOf(this.field_exptId));
        }
        if (this.fxE) {
            contentValues.put("groupId", Integer.valueOf(this.field_groupId));
        }
        if (this.fzq) {
            contentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
        }
        if (this.fzr) {
            contentValues.put("exptContent", this.field_exptContent);
        }
        if (this.fjq) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fjr) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.fzs) {
            contentValues.put("exptType", Integer.valueOf(this.field_exptType));
        }
        if (this.__hadSetsubType) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.fzt) {
            contentValues.put("exptCheckSum", this.field_exptCheckSum);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
