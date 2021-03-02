package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ei extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPZ = "logo_md5".hashCode();
    private static final int fQa = "corp_name".hashCode();
    private static final int fQb = ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE.hashCode();
    private static final int fQc = "action_url".hashCode();
    private static final int fQd = "action_app_username".hashCode();
    private static final int fQe = "action_app_nickname".hashCode();
    private static final int fQf = "packet_id".hashCode();
    private static final int fQg = "update_time".hashCode();
    private static final int fne = "title".hashCode();
    private static final int fnf = "description".hashCode();
    private static final int frB = "logo_url".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int uxS = "subtype_id".hashCode();
    private boolean fPR = true;
    private boolean fPS = true;
    private boolean fPT = true;
    private boolean fPU = true;
    private boolean fPV = true;
    private boolean fPW = true;
    private boolean fPX = true;
    private boolean fPY = true;
    public String field_action_app_nickname;
    public String field_action_app_username;
    public int field_action_type;
    public String field_action_url;
    public String field_corp_name;
    public String field_description;
    public String field_logo_md5;
    public String field_logo_url;
    public String field_packet_id;
    public int field_subtype_id;
    public String field_title;
    public long field_update_time;
    private boolean fnb = true;
    private boolean fnc = true;
    private boolean fri = true;
    private boolean uxO = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (frB == hashCode) {
                    this.field_logo_url = cursor.getString(i2);
                } else if (fPZ == hashCode) {
                    this.field_logo_md5 = cursor.getString(i2);
                } else if (fnf == hashCode) {
                    this.field_description = cursor.getString(i2);
                } else if (fQa == hashCode) {
                    this.field_corp_name = cursor.getString(i2);
                } else if (fQb == hashCode) {
                    this.field_action_type = cursor.getInt(i2);
                } else if (fQc == hashCode) {
                    this.field_action_url = cursor.getString(i2);
                } else if (fQd == hashCode) {
                    this.field_action_app_username = cursor.getString(i2);
                } else if (fQe == hashCode) {
                    this.field_action_app_nickname = cursor.getString(i2);
                } else if (fQf == hashCode) {
                    this.field_packet_id = cursor.getString(i2);
                    this.fPX = true;
                } else if (fQg == hashCode) {
                    this.field_update_time = cursor.getLong(i2);
                } else if (uxS == hashCode) {
                    this.field_subtype_id = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fri) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.fPR) {
            contentValues.put("logo_md5", this.field_logo_md5);
        }
        if (this.fnc) {
            contentValues.put("description", this.field_description);
        }
        if (this.fPS) {
            contentValues.put("corp_name", this.field_corp_name);
        }
        if (this.fPT) {
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, Integer.valueOf(this.field_action_type));
        }
        if (this.fPU) {
            contentValues.put("action_url", this.field_action_url);
        }
        if (this.fPV) {
            contentValues.put("action_app_username", this.field_action_app_username);
        }
        if (this.fPW) {
            contentValues.put("action_app_nickname", this.field_action_app_nickname);
        }
        if (this.fPX) {
            contentValues.put("packet_id", this.field_packet_id);
        }
        if (this.fPY) {
            contentValues.put("update_time", Long.valueOf(this.field_update_time));
        }
        if (this.uxO) {
            contentValues.put("subtype_id", Integer.valueOf(this.field_subtype_id));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
