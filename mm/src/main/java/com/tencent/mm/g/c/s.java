package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class s extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fkj = "appId".hashCode();
    private static final int flj = "recommendCard".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_appId;
    public dko field_recommendCard;
    private boolean fjS = true;
    private boolean fli = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                    this.fjS = true;
                } else if (flj == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_recommendCard = (dko) new dko().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseAppBrandRecommendCard", e2.getMessage());
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
        if (this.fli && this.field_recommendCard != null) {
            try {
                contentValues.put("recommendCard", this.field_recommendCard.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseAppBrandRecommendCard", e2.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
