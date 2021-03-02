package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.fck;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ee extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPd = "appIdHash".hashCode();
    private static final int fPe = "launchAction".hashCode();
    private static final int fPf = "jsapiInfo".hashCode();
    private static final int fPg = "hostInfo".hashCode();
    private static final int fPh = "actionsheetInfo".hashCode();
    private static final int fPi = "operationInfo".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fOX = true;
    private boolean fOY = true;
    private boolean fOZ = true;
    private boolean fPa = true;
    private boolean fPb = true;
    private boolean fPc = true;
    public bh field_actionsheetInfo;
    public String field_appId;
    public int field_appIdHash;
    public fck field_hostInfo;
    public ys field_jsapiInfo;
    public cgz field_launchAction;
    public cxi field_operationInfo;
    private boolean fjS = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fPd == hashCode) {
                    this.field_appIdHash = cursor.getInt(i2);
                    this.fOX = true;
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fPe == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_launchAction = (cgz) new cgz().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
                    }
                } else if (fPf == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_jsapiInfo = (ys) new ys().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e3.getMessage());
                    }
                } else if (fPg == hashCode) {
                    try {
                        byte[] blob3 = cursor.getBlob(i2);
                        if (blob3 != null && blob3.length > 0) {
                            this.field_hostInfo = (fck) new fck().parseFrom(blob3);
                        }
                    } catch (IOException e4) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e4.getMessage());
                    }
                } else if (fPh == hashCode) {
                    try {
                        byte[] blob4 = cursor.getBlob(i2);
                        if (blob4 != null && blob4.length > 0) {
                            this.field_actionsheetInfo = (bh) new bh().parseFrom(blob4);
                        }
                    } catch (IOException e5) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e5.getMessage());
                    }
                } else if (fPi == hashCode) {
                    try {
                        byte[] blob5 = cursor.getBlob(i2);
                        if (blob5 != null && blob5.length > 0) {
                            this.field_operationInfo = (cxi) new cxi().parseFrom(blob5);
                        }
                    } catch (IOException e6) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e6.getMessage());
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
        if (this.fOX) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fOY && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
            }
        }
        if (this.fOZ && this.field_jsapiInfo != null) {
            try {
                contentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e3.getMessage());
            }
        }
        if (this.fPa && this.field_hostInfo != null) {
            try {
                contentValues.put("hostInfo", this.field_hostInfo.toByteArray());
            } catch (IOException e4) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e4.getMessage());
            }
        }
        if (this.fPb && this.field_actionsheetInfo != null) {
            try {
                contentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            } catch (IOException e5) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e5.getMessage());
            }
        }
        if (this.fPc && this.field_operationInfo != null) {
            try {
                contentValues.put("operationInfo", this.field_operationInfo.toByteArray());
            } catch (IOException e6) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e6.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
