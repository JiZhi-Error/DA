package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class eq extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fRr = "wxGroupId".hashCode();
    private static final int fRs = "roomId".hashCode();
    private static final int fRt = "roomKey".hashCode();
    private static final int fRu = "routeId".hashCode();
    private static final int fRv = "inviteUserName".hashCode();
    private static final int fRw = "ilinkRoomId".hashCode();
    private static final int ftr = "memberCount".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int fyq = "groupId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean fRl = true;
    private boolean fRm = true;
    private boolean fRn = true;
    private boolean fRo = true;
    private boolean fRp = true;
    private boolean fRq = true;
    public long field_createTime;
    public String field_groupId;
    public long field_ilinkRoomId;
    public String field_inviteUserName;
    public int field_memberCount;
    public int field_roomId;
    public long field_roomKey;
    public int field_routeId;
    public int field_state;
    public String field_wxGroupId;
    private boolean fsR = true;
    private boolean fxE = true;
    private boolean fxx = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fRr == hashCode) {
                    this.field_wxGroupId = cursor.getString(i2);
                    this.fRl = true;
                } else if (fyq == hashCode) {
                    this.field_groupId = cursor.getString(i2);
                } else if (fRs == hashCode) {
                    this.field_roomId = cursor.getInt(i2);
                } else if (fRt == hashCode) {
                    this.field_roomKey = cursor.getLong(i2);
                } else if (fRu == hashCode) {
                    this.field_routeId = cursor.getInt(i2);
                } else if (fRv == hashCode) {
                    this.field_inviteUserName = cursor.getString(i2);
                } else if (ftr == hashCode) {
                    this.field_memberCount = cursor.getInt(i2);
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getLong(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (fRw == hashCode) {
                    this.field_ilinkRoomId = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fRl) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.fxE) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.fRm) {
            contentValues.put("roomId", Integer.valueOf(this.field_roomId));
        }
        if (this.fRn) {
            contentValues.put("roomKey", Long.valueOf(this.field_roomKey));
        }
        if (this.fRo) {
            contentValues.put("routeId", Integer.valueOf(this.field_routeId));
        }
        if (this.fRp) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.fsR) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fRq) {
            contentValues.put("ilinkRoomId", Long.valueOf(this.field_ilinkRoomId));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
