package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class i extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS AppBrandAppLaunchRecordUpdateTimeIndex ON AppBrandAppLaunchUsernameDuplicateRecord2(updateTime)"};
    private static final int fkB = "usernameHash".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean __hadSetusername = true;
    public long field_updateTime;
    public String field_username;
    public int field_usernameHash;
    private boolean fkA = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkB == hashCode) {
                    this.field_usernameHash = cursor.getInt(i2);
                    this.fkA = true;
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fkA) {
            contentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
