package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cq extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fGA = "CreateTime".hashCode();
    private static final int fGB = "ExpiredTime".hashCode();
    private static final int fGC = "Description".hashCode();
    private static final int fGD = "UserIcon".hashCode();
    private static final int fGE = "UserName".hashCode();
    private static final int fGF = "ExtInfo".hashCode();
    private static final int fGG = "Status".hashCode();
    private static final int fGz = "ForcePushId".hashCode();
    private static final int fOg = "Type".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fGr = true;
    private boolean fGs = true;
    private boolean fGt = true;
    private boolean fGu = true;
    private boolean fGv = true;
    private boolean fGw = true;
    private boolean fGx = true;
    private boolean fGy = true;
    private boolean fNq = true;
    public long field_CreateTime;
    public String field_Description;
    public long field_ExpiredTime;
    public String field_ExtInfo;
    public String field_ForcePushId;
    public int field_Status;
    public int field_Type;
    public String field_UserIcon;
    public String field_UserName;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fGz == hashCode) {
                    this.field_ForcePushId = cursor.getString(i2);
                    this.fGr = true;
                } else if (fGA == hashCode) {
                    this.field_CreateTime = cursor.getLong(i2);
                } else if (fGB == hashCode) {
                    this.field_ExpiredTime = cursor.getLong(i2);
                } else if (fGC == hashCode) {
                    this.field_Description = cursor.getString(i2);
                } else if (fGD == hashCode) {
                    this.field_UserIcon = cursor.getString(i2);
                } else if (fGE == hashCode) {
                    this.field_UserName = cursor.getString(i2);
                } else if (fGF == hashCode) {
                    this.field_ExtInfo = cursor.getString(i2);
                } else if (fGG == hashCode) {
                    this.field_Status = cursor.getInt(i2);
                } else if (fOg == hashCode) {
                    this.field_Type = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fGr) {
            contentValues.put("ForcePushId", this.field_ForcePushId);
        }
        if (this.fGs) {
            contentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
        }
        if (this.fGt) {
            contentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
        }
        if (this.fGu) {
            contentValues.put("Description", this.field_Description);
        }
        if (this.fGv) {
            contentValues.put("UserIcon", this.field_UserIcon);
        }
        if (this.fGw) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.fGx) {
            contentValues.put("ExtInfo", this.field_ExtInfo);
        }
        if (this.fGy) {
            contentValues.put("Status", Integer.valueOf(this.field_Status));
        }
        if (this.fNq) {
            contentValues.put("Type", Integer.valueOf(this.field_Type));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
