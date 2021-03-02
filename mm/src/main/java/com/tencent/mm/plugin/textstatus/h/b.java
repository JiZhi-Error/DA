package com.tencent.mm.plugin.textstatus.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class b extends IAutoDBItem {
    private static final int Gcf = "TextStatusId".hashCode();
    private static final int Gcg = "HashUserName".hashCode();
    private static final int Gch = "DisplayName".hashCode();
    private static final int Gci = "HeadImgUrl".hashCode();
    private static final int Gcj = "Notify".hashCode();
    private static final int Gck = "Read".hashCode();
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS TextStatusLike_TextStatusId_index ON TextStatusLike(TextStatusId)"};
    private static final int fGA = "CreateTime".hashCode();
    private static final int fGC = "Description".hashCode();
    private static final int fOg = "Type".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean GbZ = true;
    private boolean Gca = true;
    private boolean Gcb = true;
    private boolean Gcc = true;
    private boolean Gcd = true;
    private boolean Gce = true;
    private boolean fGs = true;
    private boolean fGu = true;
    private boolean fNq = true;
    public int field_CreateTime;
    public String field_Description;
    public String field_DisplayName;
    public String field_HashUserName;
    public String field_HeadImgUrl;
    public int field_Notify;
    public int field_Read;
    public String field_TextStatusId;
    public int field_Type;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[9];
        mAutoDBInfo.columns = new String[10];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "TextStatusId";
        mAutoDBInfo.colsMap.put("TextStatusId", "TEXT");
        sb.append(" TextStatusId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "HashUserName";
        mAutoDBInfo.colsMap.put("HashUserName", "TEXT");
        sb.append(" HashUserName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "DisplayName";
        mAutoDBInfo.colsMap.put("DisplayName", "TEXT");
        sb.append(" DisplayName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "HeadImgUrl";
        mAutoDBInfo.colsMap.put("HeadImgUrl", "TEXT");
        sb.append(" HeadImgUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "Description";
        mAutoDBInfo.colsMap.put("Description", "TEXT");
        sb.append(" Description TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "Type";
        mAutoDBInfo.colsMap.put("Type", "INTEGER");
        sb.append(" Type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "CreateTime";
        mAutoDBInfo.colsMap.put("CreateTime", "INTEGER");
        sb.append(" CreateTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "Notify";
        mAutoDBInfo.colsMap.put("Notify", "INTEGER");
        sb.append(" Notify INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "Read";
        mAutoDBInfo.colsMap.put("Read", "INTEGER");
        sb.append(" Read INTEGER");
        mAutoDBInfo.columns[9] = "rowid";
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
                if (Gcf == hashCode) {
                    this.field_TextStatusId = cursor.getString(i2);
                } else if (Gcg == hashCode) {
                    this.field_HashUserName = cursor.getString(i2);
                } else if (Gch == hashCode) {
                    this.field_DisplayName = cursor.getString(i2);
                } else if (Gci == hashCode) {
                    this.field_HeadImgUrl = cursor.getString(i2);
                } else if (fGC == hashCode) {
                    this.field_Description = cursor.getString(i2);
                } else if (fOg == hashCode) {
                    this.field_Type = cursor.getInt(i2);
                } else if (fGA == hashCode) {
                    this.field_CreateTime = cursor.getInt(i2);
                } else if (Gcj == hashCode) {
                    this.field_Notify = cursor.getInt(i2);
                } else if (Gck == hashCode) {
                    this.field_Read = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.GbZ) {
            contentValues.put("TextStatusId", this.field_TextStatusId);
        }
        if (this.Gca) {
            contentValues.put("HashUserName", this.field_HashUserName);
        }
        if (this.Gcb) {
            contentValues.put("DisplayName", this.field_DisplayName);
        }
        if (this.Gcc) {
            contentValues.put("HeadImgUrl", this.field_HeadImgUrl);
        }
        if (this.fGu) {
            contentValues.put("Description", this.field_Description);
        }
        if (this.fNq) {
            contentValues.put("Type", Integer.valueOf(this.field_Type));
        }
        if (this.fGs) {
            contentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
        }
        if (this.Gcd) {
            contentValues.put("Notify", Integer.valueOf(this.field_Notify));
        }
        if (this.Gce) {
            contentValues.put("Read", Integer.valueOf(this.field_Read));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
