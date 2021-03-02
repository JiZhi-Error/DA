package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gb extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int content_HASHCODE = "content".hashCode();
    private static final int fLi = "createtime".hashCode();
    private static final int fNl = "sayhiuser".hashCode();
    private static final int fNm = "sayhicontent".hashCode();
    private static final int fNn = "imgpath".hashCode();
    private static final int fjQ = "scene".hashCode();
    private static final int fjl = "status".hashCode();
    private static final int foe = "isSend".hashCode();
    private static final int fqw = "talker".hashCode();
    private static final int fyg = "svrid".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetcontent = true;
    private boolean __hadSettype = true;
    private boolean fKX = true;
    private boolean fNh = true;
    private boolean fNi = true;
    private boolean fNj = true;
    public String field_content;
    public long field_createtime;
    public String field_imgpath;
    public int field_isSend;
    public String field_sayhicontent;
    public String field_sayhiuser;
    public int field_scene;
    public int field_status;
    public long field_svrid;
    public String field_talker;
    public int field_type;
    private boolean fjO = true;
    private boolean fji = true;
    private boolean fnP = true;
    private boolean fqi = true;
    private boolean fxu = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fyg == hashCode) {
                    this.field_svrid = cursor.getLong(i2);
                    this.fxu = true;
                } else if (fjl == hashCode) {
                    this.field_status = cursor.getInt(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fLi == hashCode) {
                    this.field_createtime = cursor.getLong(i2);
                } else if (fqw == hashCode) {
                    this.field_talker = cursor.getString(i2);
                } else if (content_HASHCODE == hashCode) {
                    this.field_content = cursor.getString(i2);
                } else if (fNl == hashCode) {
                    this.field_sayhiuser = cursor.getString(i2);
                } else if (fNm == hashCode) {
                    this.field_sayhicontent = cursor.getString(i2);
                } else if (fNn == hashCode) {
                    this.field_imgpath = cursor.getString(i2);
                } else if (foe == hashCode) {
                    this.field_isSend = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fxu) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.fji) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fKX) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.fqi) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.__hadSetcontent) {
            contentValues.put("content", this.field_content);
        }
        if (this.fNh) {
            contentValues.put("sayhiuser", this.field_sayhiuser);
        }
        if (this.fNi) {
            contentValues.put("sayhicontent", this.field_sayhicontent);
        }
        if (this.fNj) {
            contentValues.put("imgpath", this.field_imgpath);
        }
        if (this.fnP) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
