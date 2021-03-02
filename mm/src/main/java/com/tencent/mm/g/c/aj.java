package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class aj extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fnU = "brandUserName".hashCode();
    private static final int foB = "needToUpdate".hashCode();
    private static final int foC = "bitFlag".hashCode();
    private static final int foG = "addMemberUrl".hashCode();
    private static final int foJ = "userId".hashCode();
    private static final int foN = "userNamePY".hashCode();
    private static final int foO = "UserVersion".hashCode();
    private static final int foP = "profileUrl".hashCode();
    private static final int fox = "headImageUrl".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private boolean __hadSetuserName = true;
    public int field_UserVersion;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public String field_brandUserName;
    public String field_headImageUrl;
    public boolean field_needToUpdate;
    public String field_profileUrl;
    public String field_userId;
    public String field_userName;
    public String field_userNamePY;
    private boolean fnF = true;
    private boolean foI = true;
    private boolean foK = true;
    private boolean foL = true;
    private boolean foM = true;
    private boolean fok = true;
    private boolean foo = true;
    private boolean fop = true;
    private boolean fot = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (foJ == hashCode) {
                    this.field_userId = cursor.getString(i2);
                    this.foI = true;
                } else if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                } else if (foN == hashCode) {
                    this.field_userNamePY = cursor.getString(i2);
                } else if (fnU == hashCode) {
                    this.field_brandUserName = cursor.getString(i2);
                } else if (foO == hashCode) {
                    this.field_UserVersion = cursor.getInt(i2);
                } else if (foB == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i2) != 0;
                } else if (fox == hashCode) {
                    this.field_headImageUrl = cursor.getString(i2);
                } else if (foP == hashCode) {
                    this.field_profileUrl = cursor.getString(i2);
                } else if (foC == hashCode) {
                    this.field_bitFlag = cursor.getInt(i2);
                } else if (foG == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.foI) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.__hadSetuserName) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.field_userNamePY == null) {
            this.field_userNamePY = "";
        }
        if (this.foK) {
            contentValues.put("userNamePY", this.field_userNamePY);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.fnF) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.foL) {
            contentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
        }
        if (this.foo) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.fok) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.foM) {
            contentValues.put("profileUrl", this.field_profileUrl);
        }
        if (this.fop) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.fot) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
