package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public abstract class m extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS AppBrandFakeNativeSplashScreenshotAPPIDINDEX ON AppBrandFakeNativeSplashScreenshot(appId)"};
    private static final int fkQ = "versionType".hashCode();
    private static final int fkR = "appVersion".hashCode();
    private static final int fkS = "isDarkMode".hashCode();
    private static final int fkT = "screenshotFilePath".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appId;
    public int field_appVersion;
    public boolean field_isDarkMode;
    public String field_screenshotFilePath;
    public int field_versionType;
    private boolean fjS = true;
    private boolean fkM = true;
    private boolean fkN = true;
    private boolean fkO = true;
    private boolean fkP = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "versionType";
        mAutoDBInfo.colsMap.put("versionType", "INTEGER default '0' ");
        sb.append(" versionType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "appVersion";
        mAutoDBInfo.colsMap.put("appVersion", "INTEGER default '0' ");
        sb.append(" appVersion INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "isDarkMode";
        mAutoDBInfo.colsMap.put("isDarkMode", "INTEGER default 'false' ");
        sb.append(" isDarkMode INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "screenshotFilePath";
        mAutoDBInfo.colsMap.put("screenshotFilePath", "TEXT");
        sb.append(" screenshotFilePath TEXT");
        mAutoDBInfo.columns[5] = "rowid";
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
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fkQ == hashCode) {
                    this.field_versionType = cursor.getInt(i2);
                } else if (fkR == hashCode) {
                    this.field_appVersion = cursor.getInt(i2);
                } else if (fkS == hashCode) {
                    this.field_isDarkMode = cursor.getInt(i2) != 0;
                } else if (fkT == hashCode) {
                    this.field_screenshotFilePath = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fkM) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.fkN) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.fkO) {
            contentValues.put("isDarkMode", Boolean.valueOf(this.field_isDarkMode));
        }
        if (this.fkP) {
            contentValues.put("screenshotFilePath", this.field_screenshotFilePath);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
