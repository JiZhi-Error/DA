package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class g extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fjQ = "scene".hashCode();
    private static final int fjR = "ticket".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int userName_HASHCODE = "userName".hashCode();
    private boolean __hadSetuserName = true;
    public int field_scene;
    public String field_ticket;
    public String field_userName;
    private boolean fjO = true;
    private boolean fjP = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[3];
        mAutoDBInfo.columns = new String[4];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "userName";
        mAutoDBInfo.colsMap.put("userName", "TEXT");
        sb.append(" userName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "ticket";
        mAutoDBInfo.colsMap.put("ticket", "TEXT");
        sb.append(" ticket TEXT");
        mAutoDBInfo.columns[3] = "rowid";
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
                if (userName_HASHCODE == hashCode) {
                    this.field_userName = cursor.getString(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fjR == hashCode) {
                    this.field_ticket = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetuserName) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fjP) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
