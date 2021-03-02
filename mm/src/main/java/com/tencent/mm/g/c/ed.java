package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ed extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fOW = "launchPB".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fOV = true;
    public String field_appId;
    public che field_launchPB;
    private boolean fjS = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fOW == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_launchPB = (che) new che().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", e2.getMessage());
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
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fOV && this.field_launchPB != null) {
            try {
                contentValues.put("launchPB", this.field_launchPB.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", e2.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
