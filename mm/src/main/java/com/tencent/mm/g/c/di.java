package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class di extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fKA = "small_url".hashCode();
    private static final int fKB = "big_url".hashCode();
    private static final int fKC = "ret".hashCode();
    private static final int fKD = "googleitemid".hashCode();
    private static final int fKE = "googlecgistatus".hashCode();
    private static final int fKF = "contecttype".hashCode();
    private static final int fKG = "googlenamepy".hashCode();
    private static final int fKu = "googleid".hashCode();
    private static final int fKv = "googlename".hashCode();
    private static final int fKw = "googlephotourl".hashCode();
    private static final int fKx = "googlegmail".hashCode();
    private static final int fKy = "nicknameqp".hashCode();
    private static final int fKz = "usernamepy".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fKh = true;
    private boolean fKi = true;
    private boolean fKj = true;
    private boolean fKk = true;
    private boolean fKl = true;
    private boolean fKm = true;
    private boolean fKn = true;
    private boolean fKo = true;
    private boolean fKp = true;
    private boolean fKq = true;
    private boolean fKr = true;
    private boolean fKs = true;
    private boolean fKt = true;
    public String field_big_url;
    public String field_contecttype;
    public int field_googlecgistatus;
    public String field_googlegmail;
    public String field_googleid;
    public String field_googleitemid;
    public String field_googlename;
    public String field_googlenamepy;
    public String field_googlephotourl;
    public String field_nickname;
    public String field_nicknameqp;
    public int field_ret;
    public String field_small_url;
    public int field_status;
    public String field_username;
    public String field_usernamepy;
    private boolean fji = true;
    private boolean fqb = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fKu == hashCode) {
                    this.field_googleid = cursor.getString(i2);
                } else if (fKv == hashCode) {
                    this.field_googlename = cursor.getString(i2);
                } else if (fKw == hashCode) {
                    this.field_googlephotourl = cursor.getString(i2);
                } else if (fKx == hashCode) {
                    this.field_googlegmail = cursor.getString(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (fKy == hashCode) {
                    this.field_nicknameqp = cursor.getString(i2);
                } else if (fKz == hashCode) {
                    this.field_usernamepy = cursor.getString(i2);
                } else if (fKA == hashCode) {
                    this.field_small_url = cursor.getString(i2);
                } else if (fKB == hashCode) {
                    this.field_big_url = cursor.getString(i2);
                } else if (fKC == hashCode) {
                    this.field_ret = cursor.getInt(i2);
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (fKD == hashCode) {
                    this.field_googleitemid = cursor.getString(i2);
                    this.fKq = true;
                } else if (fKE == hashCode) {
                    this.field_googlecgistatus = cursor.getInt(i2);
                } else if (fKF == hashCode) {
                    this.field_contecttype = cursor.getString(i2);
                } else if (fKG == hashCode) {
                    this.field_googlenamepy = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fKh) {
            contentValues.put("googleid", this.field_googleid);
        }
        if (this.fKi) {
            contentValues.put("googlename", this.field_googlename);
        }
        if (this.fKj) {
            contentValues.put("googlephotourl", this.field_googlephotourl);
        }
        if (this.fKk) {
            contentValues.put("googlegmail", this.field_googlegmail);
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fKl) {
            contentValues.put("nicknameqp", this.field_nicknameqp);
        }
        if (this.fKm) {
            contentValues.put("usernamepy", this.field_usernamepy);
        }
        if (this.fKn) {
            contentValues.put("small_url", this.field_small_url);
        }
        if (this.fKo) {
            contentValues.put("big_url", this.field_big_url);
        }
        if (this.fKp) {
            contentValues.put("ret", Integer.valueOf(this.field_ret));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.fKq) {
            contentValues.put("googleitemid", this.field_googleitemid);
        }
        if (this.fKr) {
            contentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
        }
        if (this.fKs) {
            contentValues.put("contecttype", this.field_contecttype);
        }
        if (this.fKt) {
            contentValues.put("googlenamepy", this.field_googlenamepy);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
