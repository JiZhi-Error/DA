package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ab extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fnn = "deviceId".hashCode();
    private static final int fno = "sessionName".hashCode();
    private static final int fnp = "moveTime".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_deviceId;
    public in field_moveTime;
    public String field_sessionName;
    private boolean fnk = true;
    private boolean fnl = true;
    private boolean fnm = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fnn == hashCode) {
                    this.field_deviceId = cursor.getString(i2);
                } else if (fno == hashCode) {
                    this.field_sessionName = cursor.getString(i2);
                } else if (fnp == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_moveTime = (in) new in().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseBackupMoveTime", e2.getMessage());
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
        if (this.field_deviceId == null) {
            this.field_deviceId = "";
        }
        if (this.fnk) {
            contentValues.put("deviceId", this.field_deviceId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.fnl) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.fnm && this.field_moveTime != null) {
            try {
                contentValues.put("moveTime", this.field_moveTime.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseBackupMoveTime", e2.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
