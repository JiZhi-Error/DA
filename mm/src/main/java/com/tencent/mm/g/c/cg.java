package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class cg extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FinderDraftItem_local_index ON FinderDraftItem(localId)", "CREATE INDEX IF NOT EXISTS FinderDraftItem_create_time ON FinderDraftItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderDraftItem__Local_Flag ON FinderDraftItem(localFlag)", "CREATE INDEX IF NOT EXISTS FinderDraftItem__Object_Type ON FinderDraftItem(objectType)"};
    private static final int createTime_HASHCODE = "createTime".hashCode();
    private static final int fEd = "finderItem".hashCode();
    private static final int fEe = "objectType".hashCode();
    private static final int fEf = "postIntent".hashCode();
    private static final int fEg = "originMvInfo".hashCode();
    private static final int localFlag_HASHCODE = "localFlag".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean __hadSetcreateTime = true;
    private boolean __hadSetlocalFlag = true;
    private boolean __hadSetlocalId = true;
    private boolean fDZ = true;
    private boolean fEa = true;
    private boolean fEb = true;
    private boolean fEc = true;
    public int field_createTime;
    public aud field_finderItem;
    public int field_localFlag;
    public long field_localId;
    public int field_objectType;
    public axw field_originMvInfo;
    public String field_postIntent;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "LONG PRIMARY KEY ");
        sb.append(" localId LONG PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "INTEGER");
        sb.append(" createTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "localFlag";
        mAutoDBInfo.colsMap.put("localFlag", "INTEGER");
        sb.append(" localFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "finderItem";
        mAutoDBInfo.colsMap.put("finderItem", "BLOB");
        sb.append(" finderItem BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "objectType";
        mAutoDBInfo.colsMap.put("objectType", "INTEGER");
        sb.append(" objectType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "postIntent";
        mAutoDBInfo.colsMap.put("postIntent", "TEXT");
        sb.append(" postIntent TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "originMvInfo";
        mAutoDBInfo.colsMap.put("originMvInfo", "BLOB");
        sb.append(" originMvInfo BLOB");
        mAutoDBInfo.columns[7] = "rowid";
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
                } else if (createTime_HASHCODE == hashCode) {
                    this.field_createTime = cursor.getInt(i2);
                } else if (localFlag_HASHCODE == hashCode) {
                    this.field_localFlag = cursor.getInt(i2);
                } else if (fEd == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_finderItem = (aud) new aud().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFinderDraftItem", e2.getMessage());
                    }
                } else if (fEe == hashCode) {
                    this.field_objectType = cursor.getInt(i2);
                } else if (fEf == hashCode) {
                    this.field_postIntent = cursor.getString(i2);
                } else if (fEg == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_originMvInfo = (axw) new axw().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e("MicroMsg.SDK.BaseFinderDraftItem", e3.getMessage());
                    }
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
        if (this.__hadSetcreateTime) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.__hadSetlocalFlag) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.fDZ && this.field_finderItem != null) {
            try {
                contentValues.put("finderItem", this.field_finderItem.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFinderDraftItem", e2.getMessage());
            }
        }
        if (this.fEa) {
            contentValues.put("objectType", Integer.valueOf(this.field_objectType));
        }
        if (this.fEb) {
            contentValues.put("postIntent", this.field_postIntent);
        }
        if (this.fEc && this.field_originMvInfo != null) {
            try {
                contentValues.put("originMvInfo", this.field_originMvInfo.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseFinderDraftItem", e3.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
