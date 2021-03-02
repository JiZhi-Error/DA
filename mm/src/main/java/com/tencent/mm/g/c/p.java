package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class p extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)"};
    private static final int fjQ = "scene".hashCode();
    private static final int fkQ = "versionType".hashCode();
    private static final int flc = "recordId".hashCode();
    private static final int fld = "brandId".hashCode();
    private static final int fle = "usedInThirdPartyAppRecently".hashCode();
    private static final int flf = "thirdPartyAppUsingDesc".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    public String field_brandId;
    public int field_recordId;
    public int field_scene;
    public String field_thirdPartyAppUsingDesc;
    public long field_updateTime;
    public boolean field_usedInThirdPartyAppRecently;
    public int field_versionType;
    private boolean fjO = true;
    private boolean fkM = true;
    private boolean fkY = true;
    private boolean fkZ = true;
    private boolean fla = true;
    private boolean flb = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (flc == hashCode) {
                    this.field_recordId = cursor.getInt(i2);
                    this.fkY = true;
                } else if (fld == hashCode) {
                    this.field_brandId = cursor.getString(i2);
                } else if (fkQ == hashCode) {
                    this.field_versionType = cursor.getInt(i2);
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fle == hashCode) {
                    this.field_usedInThirdPartyAppRecently = cursor.getInt(i2) != 0;
                } else if (flf == hashCode) {
                    this.field_thirdPartyAppUsingDesc = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fkY) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.fkZ) {
            contentValues.put("brandId", this.field_brandId);
        }
        if (this.fkM) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fla) {
            contentValues.put("usedInThirdPartyAppRecently", Boolean.valueOf(this.field_usedInThirdPartyAppRecently));
        }
        if (this.flb) {
            contentValues.put("thirdPartyAppUsingDesc", this.field_thirdPartyAppUsingDesc);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
