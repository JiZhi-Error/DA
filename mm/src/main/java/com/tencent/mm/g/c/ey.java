package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ey extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fTV = "oldUsername".hashCode();
    private static final int fTW = "addState".hashCode();
    private static final int fTX = "pinyinName".hashCode();
    private static final int fTY = "seq".hashCode();
    private static final int fjR = "ticket".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int fum = "showHead".hashCode();
    private static final int fus = "encryptUsername".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fTR = true;
    private boolean fTS = true;
    private boolean fTT = true;
    private boolean fTU = true;
    public int field_addState;
    public String field_encryptUsername;
    public String field_nickname;
    public String field_oldUsername;
    public String field_pinyinName;
    public int field_seq;
    public int field_showHead;
    public String field_ticket;
    public String field_username;
    private boolean fjP = true;
    private boolean fqb = true;
    private boolean ftU = true;
    private boolean fua = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fus == hashCode) {
                    this.field_encryptUsername = cursor.getString(i2);
                } else if (fTV == hashCode) {
                    this.field_oldUsername = cursor.getString(i2);
                } else if (fjR == hashCode) {
                    this.field_ticket = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fTW == hashCode) {
                    this.field_addState = cursor.getInt(i2);
                } else if (fum == hashCode) {
                    this.field_showHead = cursor.getInt(i2);
                } else if (fTX == hashCode) {
                    this.field_pinyinName = cursor.getString(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fTY == hashCode) {
                    this.field_seq = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fua) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.fTR) {
            contentValues.put("oldUsername", this.field_oldUsername);
        }
        if (this.fjP) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fTS) {
            contentValues.put("addState", Integer.valueOf(this.field_addState));
        }
        if (this.ftU) {
            contentValues.put("showHead", Integer.valueOf(this.field_showHead));
        }
        if (this.fTT) {
            contentValues.put("pinyinName", this.field_pinyinName);
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fTU) {
            contentValues.put("seq", Integer.valueOf(this.field_seq));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
