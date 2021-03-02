package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class ck extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fEG = "likeAction".hashCode();
    private static final int fEH = "contextObj".hashCode();
    private static final int fEI = "isPrivate".hashCode();
    private static final int fjQ = "scene".hashCode();
    private static final int fvO = "showTips".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetlocalId = true;
    private boolean fED = true;
    private boolean fEE = true;
    private boolean fEF = true;
    public bbn field_contextObj;
    public boolean field_isPrivate;
    public int field_likeAction;
    public long field_localId;
    public int field_scene;
    public boolean field_showTips;
    private boolean fjO = true;
    private boolean fvy = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "LONG PRIMARY KEY ");
        sb.append(" localId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = "likeAction";
        mAutoDBInfo.colsMap.put("likeAction", "INTEGER");
        sb.append(" likeAction INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER");
        sb.append(" scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "showTips";
        mAutoDBInfo.colsMap.put("showTips", "INTEGER");
        sb.append(" showTips INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "contextObj";
        mAutoDBInfo.colsMap.put("contextObj", "BLOB");
        sb.append(" contextObj BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "isPrivate";
        mAutoDBInfo.colsMap.put("isPrivate", "INTEGER");
        sb.append(" isPrivate INTEGER");
        mAutoDBInfo.columns[6] = "rowid";
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
                if (localId_HASHCODE == hashCode) {
                    this.field_localId = cursor.getLong(i2);
                    this.__hadSetlocalId = true;
                } else if (fEG == hashCode) {
                    this.field_likeAction = cursor.getInt(i2);
                } else if (fjQ == hashCode) {
                    this.field_scene = cursor.getInt(i2);
                } else if (fvO == hashCode) {
                    this.field_showTips = cursor.getInt(i2) != 0;
                } else if (fEH == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_contextObj = (bbn) new bbn().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFinderLocalOperation", e2.getMessage());
                    }
                } else if (fEI == hashCode) {
                    this.field_isPrivate = cursor.getInt(i2) != 0;
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetlocalId) {
            contentValues.put(ch.COL_LOCALID, Long.valueOf(this.field_localId));
        }
        if (this.fED) {
            contentValues.put("likeAction", Integer.valueOf(this.field_likeAction));
        }
        if (this.fjO) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fvy) {
            contentValues.put("showTips", Boolean.valueOf(this.field_showTips));
        }
        if (this.fEE && this.field_contextObj != null) {
            try {
                contentValues.put("contextObj", this.field_contextObj.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFinderLocalOperation", e2.getMessage());
            }
        }
        if (this.fEF) {
            contentValues.put("isPrivate", Boolean.valueOf(this.field_isPrivate));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
