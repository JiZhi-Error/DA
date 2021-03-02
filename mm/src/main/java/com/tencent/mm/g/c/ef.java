package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.protocal.protobuf.ffb;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ef extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPd = "appIdHash".hashCode();
    private static final int fPe = "launchAction".hashCode();
    private static final int fPo = "pkgType".hashCode();
    private static final int fPp = "widgetType".hashCode();
    private static final int fPq = "jsApiInfo".hashCode();
    private static final int fPr = "versionInfo".hashCode();
    private static final int fPs = "widgetSetting".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fOX = true;
    private boolean fOY = true;
    private boolean fPj = true;
    private boolean fPk = true;
    private boolean fPl = true;
    private boolean fPm = true;
    private boolean fPn = true;
    public String field_appId;
    public int field_appIdHash;
    public ys field_jsApiInfo;
    public fbo field_launchAction;
    public int field_pkgType;
    public fbq field_versionInfo;
    public ffb field_widgetSetting;
    public int field_widgetType;
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
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fPo == hashCode) {
                    this.field_pkgType = cursor.getInt(i2);
                } else if (fPp == hashCode) {
                    this.field_widgetType = cursor.getInt(i2);
                } else if (fPe == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i2);
                        if (blob != null && blob.length > 0) {
                            this.field_launchAction = (fbo) new fbo().parseFrom(blob);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
                    }
                } else if (fPq == hashCode) {
                    try {
                        byte[] blob2 = cursor.getBlob(i2);
                        if (blob2 != null && blob2.length > 0) {
                            this.field_jsApiInfo = (ys) new ys().parseFrom(blob2);
                        }
                    } catch (IOException e3) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e3.getMessage());
                    }
                } else if (fPr == hashCode) {
                    try {
                        byte[] blob3 = cursor.getBlob(i2);
                        if (blob3 != null && blob3.length > 0) {
                            this.field_versionInfo = (fbq) new fbq().parseFrom(blob3);
                        }
                    } catch (IOException e4) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e4.getMessage());
                    }
                } else if (fPs == hashCode) {
                    try {
                        byte[] blob4 = cursor.getBlob(i2);
                        if (blob4 != null && blob4.length > 0) {
                            this.field_widgetSetting = (ffb) new ffb().parseFrom(blob4);
                        }
                    } catch (IOException e5) {
                        Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e5.getMessage());
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
        if (this.fPj) {
            contentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
        }
        if (this.fPk) {
            contentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
        }
        if (this.fOY && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
            }
        }
        if (this.fPl && this.field_jsApiInfo != null) {
            try {
                contentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
            } catch (IOException e3) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e3.getMessage());
            }
        }
        if (this.fPm && this.field_versionInfo != null) {
            try {
                contentValues.put("versionInfo", this.field_versionInfo.toByteArray());
            } catch (IOException e4) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e4.getMessage());
            }
        }
        if (this.fPn && this.field_widgetSetting != null) {
            try {
                contentValues.put("widgetSetting", this.field_widgetSetting.toByteArray());
            } catch (IOException e5) {
                Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e5.getMessage());
            }
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
