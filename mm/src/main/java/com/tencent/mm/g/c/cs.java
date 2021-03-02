package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.NativeProtocol;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;

public abstract class cs extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fCJ = TPDownloadProxyEnum.USER_SSID.hashCode();
    private static final int fGS = "ssidmd5".hashCode();
    private static final int fGT = "mid".hashCode();
    private static final int fGU = "connectState".hashCode();
    private static final int fGV = "wifiType".hashCode();
    private static final int fGW = NativeProtocol.WEB_DIALOG_ACTION.hashCode();
    private static final int fGX = "showUrl".hashCode();
    private static final int fGY = "showWordEn".hashCode();
    private static final int fGZ = "showWordCn".hashCode();
    private static final int fGk = "expiredTime".hashCode();
    private static final int fHa = "showWordTw".hashCode();
    private static final int fHb = TPDownloadProxyEnum.USER_MAC.hashCode();
    private static final int fHc = "verifyResult".hashCode();
    private static final int fnB = "url".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fCf = true;
    private boolean fGH = true;
    private boolean fGI = true;
    private boolean fGJ = true;
    private boolean fGK = true;
    private boolean fGL = true;
    private boolean fGM = true;
    private boolean fGN = true;
    private boolean fGO = true;
    private boolean fGP = true;
    private boolean fGQ = true;
    private boolean fGR = true;
    private boolean fGe = true;
    public int field_action;
    public int field_connectState;
    public long field_expiredTime;
    public String field_mac;
    public String field_mid;
    public String field_showUrl;
    public String field_showWordCn;
    public String field_showWordEn;
    public String field_showWordTw;
    public String field_ssid;
    public String field_ssidmd5;
    public String field_url;
    public int field_verifyResult;
    public int field_wifiType;
    private boolean fnx = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fGS == hashCode) {
                    this.field_ssidmd5 = cursor.getString(i2);
                    this.fGH = true;
                } else if (fCJ == hashCode) {
                    this.field_ssid = cursor.getString(i2);
                } else if (fGT == hashCode) {
                    this.field_mid = cursor.getString(i2);
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (fGU == hashCode) {
                    this.field_connectState = cursor.getInt(i2);
                } else if (fGk == hashCode) {
                    this.field_expiredTime = cursor.getLong(i2);
                } else if (fGV == hashCode) {
                    this.field_wifiType = cursor.getInt(i2);
                } else if (fGW == hashCode) {
                    this.field_action = cursor.getInt(i2);
                } else if (fGX == hashCode) {
                    this.field_showUrl = cursor.getString(i2);
                } else if (fGY == hashCode) {
                    this.field_showWordEn = cursor.getString(i2);
                } else if (fGZ == hashCode) {
                    this.field_showWordCn = cursor.getString(i2);
                } else if (fHa == hashCode) {
                    this.field_showWordTw = cursor.getString(i2);
                } else if (fHb == hashCode) {
                    this.field_mac = cursor.getString(i2);
                } else if (fHc == hashCode) {
                    this.field_verifyResult = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fGH) {
            contentValues.put("ssidmd5", this.field_ssidmd5);
        }
        if (this.fCf) {
            contentValues.put(TPDownloadProxyEnum.USER_SSID, this.field_ssid);
        }
        if (this.fGI) {
            contentValues.put("mid", this.field_mid);
        }
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.fGJ) {
            contentValues.put("connectState", Integer.valueOf(this.field_connectState));
        }
        if (this.fGe) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.fGK) {
            contentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
        }
        if (this.fGL) {
            contentValues.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(this.field_action));
        }
        if (this.fGM) {
            contentValues.put("showUrl", this.field_showUrl);
        }
        if (this.fGN) {
            contentValues.put("showWordEn", this.field_showWordEn);
        }
        if (this.fGO) {
            contentValues.put("showWordCn", this.field_showWordCn);
        }
        if (this.fGP) {
            contentValues.put("showWordTw", this.field_showWordTw);
        }
        if (this.fGQ) {
            contentValues.put(TPDownloadProxyEnum.USER_MAC, this.field_mac);
        }
        if (this.fGR) {
            contentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
