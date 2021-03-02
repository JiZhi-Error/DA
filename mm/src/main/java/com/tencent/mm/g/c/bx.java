package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bx extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)"};
    private static final int fAy = "modItem".hashCode();
    private static final int fjQ = "scene".hashCode();
    private static final int frC = "time".hashCode();
    private static final int localId_HASHCODE = ch.COL_LOCALID.hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int type_HASHCODE = "type".hashCode();
    private boolean __hadSetlocalId = true;
    private boolean __hadSettype = true;
    private boolean fAx = true;
    public long field_localId;
    public amp field_modItem;
    public int field_scene;
    public long field_time;
    public int field_type;
    private boolean fjO = true;
    private boolean frj = true;

    public static IAutoDBItem.MAutoDBInfo ajs() {
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[5];
        mAutoDBInfo.columns = new String[6];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "LONG");
        sb.append(" localId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "modItem";
        mAutoDBInfo.colsMap.put("modItem", "BLOB");
        sb.append(" modItem BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "time";
        mAutoDBInfo.colsMap.put("time", "LONG");
        sb.append(" time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "scene";
        mAutoDBInfo.colsMap.put("scene", "INTEGER default '1' ");
        sb.append(" scene INTEGER default '1' ");
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
                if (localId_HASHCODE == hashCode) {
                    this.field_localId = cursor.getLong(i2);
                } else if (fAy == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_modItem = (amp) new amp().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseFavEditInfo", e2.getMessage());
                    }
                } else if (frC == hashCode) {
                    this.field_time = cursor.getLong(i2);
                } else if (type_HASHCODE == hashCode) {
                    this.field_type = cursor.getInt(i2);
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
        if (this.__hadSetlocalId) {
            contentValues.put(ch.COL_LOCALID, Long.valueOf(this.field_localId));
        }
        if (this.fAx && this.field_modItem != null) {
            try {
                contentValues.put("modItem", this.field_modItem.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseFavEditInfo", e2.getMessage());
            }
        }
        if (this.frj) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.__hadSettype) {
            contentValues.put("type", Integer.valueOf(this.field_type));
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
