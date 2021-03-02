package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fw extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fXB = "xmlContent".hashCode();
    private static final int fXC = "ScanTime".hashCode();
    private static final int fXD = "funcType".hashCode();
    private static final int fXE = "qrcodeUrl".hashCode();
    private static final int fjQ = "scene".hashCode();
    private static final int fwr = "productId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fXA = true;
    private boolean fXx = true;
    private boolean fXy = true;
    private boolean fXz = true;
    public long field_ScanTime;
    public int field_funcType;
    public String field_productId;
    public String field_qrcodeUrl;
    public int field_scene;
    public String field_xmlContent;
    private boolean fjO = true;
    private boolean fwo = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fwr == hashCode) {
                    this.field_productId = cursor.getString(i2);
                    this.fwo = true;
                } else if (fXB == hashCode) {
                    this.field_xmlContent = cursor.getString(i2);
                } else if (fXC == hashCode) {
                    this.field_ScanTime = cursor.getLong(i2);
                } else if (fXD == hashCode) {
                    this.field_funcType = cursor.getInt(i2);
                } else if (fXE == hashCode) {
                    this.field_qrcodeUrl = cursor.getString(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fwo) {
            contentValues.put("productId", this.field_productId);
        }
        if (this.fXx) {
            contentValues.put("xmlContent", this.field_xmlContent);
        }
        if (this.fXy) {
            contentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
        }
        if (this.fXz) {
            contentValues.put("funcType", Integer.valueOf(this.field_funcType));
        }
        if (this.fXA) {
            contentValues.put("qrcodeUrl", this.field_qrcodeUrl);
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
