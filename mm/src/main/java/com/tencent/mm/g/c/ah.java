package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ah extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fnU = "brandUserName".hashCode();
    private static final int foA = "chatVersion".hashCode();
    private static final int foB = "needToUpdate".hashCode();
    private static final int foC = "bitFlag".hashCode();
    private static final int foD = "maxMemberCnt".hashCode();
    private static final int foE = "ownerUserId".hashCode();
    private static final int foF = "userList".hashCode();
    private static final int foG = "addMemberUrl".hashCode();
    private static final int foH = "roomflag".hashCode();
    private static final int fod = "chatType".hashCode();
    private static final int fov = "bizChatLocalId".hashCode();
    private static final int fow = "bizChatServId".hashCode();
    private static final int fox = "headImageUrl".hashCode();
    private static final int foy = "chatName".hashCode();
    private static final int foz = "chatNamePY".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_addMemberUrl;
    public int field_bitFlag;
    public long field_bizChatLocalId;
    public String field_bizChatServId;
    public String field_brandUserName;
    public String field_chatName;
    public String field_chatNamePY;
    public int field_chatType;
    public int field_chatVersion;
    public String field_headImageUrl;
    public int field_maxMemberCnt;
    public boolean field_needToUpdate;
    public String field_ownerUserId;
    public int field_roomflag;
    public String field_userList;
    private boolean fnF = true;
    private boolean fnO = true;
    private boolean foi = true;
    private boolean foj = true;
    private boolean fok = true;
    private boolean fol = true;
    private boolean fom = true;
    private boolean fon = true;
    private boolean foo = true;
    private boolean fop = true;
    private boolean foq = true;

    /* renamed from: for  reason: not valid java name */
    private boolean f2for = true;
    private boolean fos = true;
    private boolean fot = true;
    private boolean fou = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fov == hashCode) {
                    this.field_bizChatLocalId = cursor.getLong(i2);
                    this.foi = true;
                } else if (fow == hashCode) {
                    this.field_bizChatServId = cursor.getString(i2);
                } else if (fnU == hashCode) {
                    this.field_brandUserName = cursor.getString(i2);
                } else if (fod == hashCode) {
                    this.field_chatType = cursor.getInt(i2);
                } else if (fox == hashCode) {
                    this.field_headImageUrl = cursor.getString(i2);
                } else if (foy == hashCode) {
                    this.field_chatName = cursor.getString(i2);
                } else if (foz == hashCode) {
                    this.field_chatNamePY = cursor.getString(i2);
                } else if (foA == hashCode) {
                    this.field_chatVersion = cursor.getInt(i2);
                } else if (foB == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i2) != 0;
                } else if (foC == hashCode) {
                    this.field_bitFlag = cursor.getInt(i2);
                } else if (foD == hashCode) {
                    this.field_maxMemberCnt = cursor.getInt(i2);
                } else if (foE == hashCode) {
                    this.field_ownerUserId = cursor.getString(i2);
                } else if (foF == hashCode) {
                    this.field_userList = cursor.getString(i2);
                } else if (foG == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i2);
                } else if (foH == hashCode) {
                    this.field_roomflag = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.foi) {
            contentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
        }
        if (this.foj) {
            contentValues.put("bizChatServId", this.field_bizChatServId);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.fnF) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fnO) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.fok) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.field_chatName == null) {
            this.field_chatName = "";
        }
        if (this.fol) {
            contentValues.put("chatName", this.field_chatName);
        }
        if (this.field_chatNamePY == null) {
            this.field_chatNamePY = "";
        }
        if (this.fom) {
            contentValues.put("chatNamePY", this.field_chatNamePY);
        }
        if (this.fon) {
            contentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
        }
        if (this.foo) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.fop) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.foq) {
            contentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
        }
        if (this.f2for) {
            contentValues.put("ownerUserId", this.field_ownerUserId);
        }
        if (this.fos) {
            contentValues.put("userList", this.field_userList);
        }
        if (this.fot) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.fou) {
            contentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
