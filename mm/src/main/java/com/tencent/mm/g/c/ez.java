package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ez extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fUc = "acctTypeId".hashCode();
    private static final int fUd = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE.hashCode();
    private static final int fUe = "accTypeRec".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int updateTime_HASHCODE = ch.COL_UPDATETIME.hashCode();
    private boolean __hadSetupdateTime = true;
    private boolean fTZ = true;
    private boolean fUa = true;
    private boolean fUb = true;
    public bb field_accTypeRec;
    public String field_acctTypeId;
    public String field_language;
    public long field_updateTime;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fUc == hashCode) {
                    this.field_acctTypeId = cursor.getString(i2);
                } else if (fUd == hashCode) {
                    this.field_language = cursor.getString(i2);
                } else if (fUe == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_accTypeRec = (bb) new bb().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", e2.getMessage());
                    }
                } else if (updateTime_HASHCODE == hashCode) {
                    this.field_updateTime = cursor.getLong(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fTZ) {
            contentValues.put("acctTypeId", this.field_acctTypeId);
        }
        if (this.fUa) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.field_language);
        }
        if (this.fUb && this.field_accTypeRec != null) {
            try {
                contentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", e2.getMessage());
            }
        }
        if (this.__hadSetupdateTime) {
            contentValues.put(ch.COL_UPDATETIME, Long.valueOf(this.field_updateTime));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
