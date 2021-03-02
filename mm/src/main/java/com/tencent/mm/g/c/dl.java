package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dl extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fKQ = "creator".hashCode();
    private static final int fLg = "todoid".hashCode();
    private static final int fLh = "roomname".hashCode();
    private static final int fLi = "createtime".hashCode();
    private static final int fLj = "updatetime".hashCode();
    private static final int fLk = "custominfo".hashCode();
    private static final int fLl = "related_msgids".hashCode();
    private static final int fLm = "manager".hashCode();
    private static final int fLn = "nreply".hashCode();
    private static final int fLo = "netSceneState".hashCode();
    private static final int fLp = "shareKey".hashCode();
    private static final int fLq = "shareName".hashCode();
    private static final int fkH = "path".hashCode();
    private static final int fne = "title".hashCode();
    private static final int fyj = "state".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fKL = true;
    private boolean fKV = true;
    private boolean fKW = true;
    private boolean fKX = true;
    private boolean fKY = true;
    private boolean fKZ = true;
    private boolean fLa = true;
    private boolean fLb = true;
    private boolean fLc = true;
    private boolean fLd = true;
    private boolean fLe = true;
    private boolean fLf = true;
    public long field_createtime;
    public String field_creator;
    public String field_custominfo;
    public String field_manager;
    public int field_netSceneState;
    public int field_nreply;
    public String field_path;
    public String field_related_msgids;
    public String field_roomname;
    public String field_shareKey;
    public String field_shareName;
    public int field_state;
    public String field_title;
    public String field_todoid;
    public long field_updatetime;
    public String field_username;
    private boolean fkD = true;
    private boolean fnb = true;
    private boolean fxx = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fLg == hashCode) {
                    this.field_todoid = cursor.getString(i2);
                } else if (fLh == hashCode) {
                    this.field_roomname = cursor.getString(i2);
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fkH == hashCode) {
                    this.field_path = cursor.getString(i2);
                } else if (fLi == hashCode) {
                    this.field_createtime = cursor.getLong(i2);
                } else if (fLj == hashCode) {
                    this.field_updatetime = cursor.getLong(i2);
                } else if (fLk == hashCode) {
                    this.field_custominfo = cursor.getString(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (fKQ == hashCode) {
                    this.field_creator = cursor.getString(i2);
                } else if (fLl == hashCode) {
                    this.field_related_msgids = cursor.getString(i2);
                } else if (fLm == hashCode) {
                    this.field_manager = cursor.getString(i2);
                } else if (fLn == hashCode) {
                    this.field_nreply = cursor.getInt(i2);
                } else if (fyj == hashCode) {
                    this.field_state = cursor.getInt(i2);
                } else if (fLo == hashCode) {
                    this.field_netSceneState = cursor.getInt(i2);
                } else if (fLp == hashCode) {
                    this.field_shareKey = cursor.getString(i2);
                } else if (fLq == hashCode) {
                    this.field_shareName = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fKV) {
            contentValues.put("todoid", this.field_todoid);
        }
        if (this.fKW) {
            contentValues.put("roomname", this.field_roomname);
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fkD) {
            contentValues.put("path", this.field_path);
        }
        if (this.fKX) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.fKY) {
            contentValues.put("updatetime", Long.valueOf(this.field_updatetime));
        }
        if (this.field_custominfo == null) {
            this.field_custominfo = "";
        }
        if (this.fKZ) {
            contentValues.put("custominfo", this.field_custominfo);
        }
        if (this.field_title == null) {
            this.field_title = "";
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fKL) {
            contentValues.put("creator", this.field_creator);
        }
        if (this.fLa) {
            contentValues.put("related_msgids", this.field_related_msgids);
        }
        if (this.fLb) {
            contentValues.put("manager", this.field_manager);
        }
        if (this.fLc) {
            contentValues.put("nreply", Integer.valueOf(this.field_nreply));
        }
        if (this.fxx) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fLd) {
            contentValues.put("netSceneState", Integer.valueOf(this.field_netSceneState));
        }
        if (this.fLe) {
            contentValues.put("shareKey", this.field_shareKey);
        }
        if (this.fLf) {
            contentValues.put("shareName", this.field_shareName);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
