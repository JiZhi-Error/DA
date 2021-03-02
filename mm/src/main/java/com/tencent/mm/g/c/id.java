package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

public abstract class id extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fUh = "appid".hashCode();
    private static final int fkL = "token".hashCode();
    private static final int ggz = OpenSDKTool4Assistant.EXTRA_UIN.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fUf = true;
    public String field_appid;
    public String field_token;
    public int field_uin;
    public String field_username;
    private boolean fkK = true;
    private boolean gfU = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[4];
        mAutoDBInfo.columns = new String[5];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "token";
        mAutoDBInfo.colsMap.put("token", "TEXT PRIMARY KEY ");
        sb.append(" token TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "token";
        mAutoDBInfo.columns[1] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = OpenSDKTool4Assistant.EXTRA_UIN;
        mAutoDBInfo.colsMap.put(OpenSDKTool4Assistant.EXTRA_UIN, "INTEGER");
        sb.append(" uin INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "appid";
        mAutoDBInfo.colsMap.put("appid", "TEXT");
        sb.append(" appid TEXT");
        mAutoDBInfo.columns[4] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        return mAutoDBInfo;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkL == hashCode) {
                    this.field_token = cursor.getString(i2);
                    this.fkK = true;
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (ggz == hashCode) {
                    this.field_uin = cursor.getInt(i2);
                } else if (fUh == hashCode) {
                    this.field_appid = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fkK) {
            contentValues.put("token", this.field_token);
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.gfU) {
            contentValues.put(OpenSDKTool4Assistant.EXTRA_UIN, Integer.valueOf(this.field_uin));
        }
        if (this.fUf) {
            contentValues.put("appid", this.field_appid);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
