package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class er extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fRA = "memberId".hashCode();
    private static final int fRr = "wxGroupId".hashCode();
    private static final int fRv = "inviteUserName".hashCode();
    private static final int fRz = "memberUuid".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetuserName = true;
    private boolean fRl = true;
    private boolean fRp = true;
    private boolean fRx = true;
    private boolean fRy = true;
    public long field_createTime;
    public String field_inviteUserName;
    public long field_memberId;
    public long field_memberUuid;
    public int field_status;
    public String field_userName;
    public String field_wxGroupId;
    private boolean fji = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fRz == hashCode) {
                    this.field_memberUuid = cursor.getLong(i2);
                } else if (fRr == hashCode) {
                    this.field_wxGroupId = cursor.getString(i2);
                } else if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                } else if (fRv == hashCode) {
                    this.field_inviteUserName = cursor.getString(i2);
                } else if (fRA == hashCode) {
                    this.field_memberId = cursor.getLong(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fRx) {
            contentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
        }
        if (this.fRl) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.__hadSetuserName) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fRp) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.fRy) {
            contentValues.put("memberId", Long.valueOf(this.field_memberId));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
