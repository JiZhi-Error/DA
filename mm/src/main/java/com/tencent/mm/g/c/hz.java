package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hz extends IAutoDBItem {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)"};
    private static final int fPr = "versionInfo".hashCode();
    private static final int fkB = "usernameHash".hashCode();
    private static final int fkj = "appId".hashCode();
    private static final int fkx = "signature".hashCode();
    private static final int fpR = "brandIconURL".hashCode();
    private static final int fqW = "reserved".hashCode();
    private static final int fqf = "nickname".hashCode();
    private static final int gjh = "shortNickname".hashCode();
    private static final int gji = "roundedSquareIconURL".hashCode();
    private static final int gjj = "bigHeadURL".hashCode();
    private static final int gjk = "smallHeadURL".hashCode();
    private static final int gjl = "appOpt".hashCode();
    private static final int gjm = "registerSource".hashCode();
    private static final int gjn = "appInfo".hashCode();
    private static final int gjo = "passThroughInfo".hashCode();
    private static final int gjp = "bindWxaInfo".hashCode();
    private static final int gjq = "dynamicInfo".hashCode();
    private static final int gjr = "syncTimeSecond".hashCode();
    private static final int gjs = "syncVersion".hashCode();
    private static final int gjt = "bizMenu".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fPm = true;
    public String field_appId;
    public String field_appInfo;
    public int field_appOpt;
    public String field_bigHeadURL;
    public String field_bindWxaInfo;
    public String field_bizMenu;
    public String field_brandIconURL;
    public String field_dynamicInfo;
    public String field_nickname;
    public String field_passThroughInfo;
    public String field_registerSource;
    public String field_reserved;
    public String field_roundedSquareIconURL;
    public String field_shortNickname;
    public String field_signature;
    public String field_smallHeadURL;
    public long field_syncTimeSecond;
    public String field_syncVersion;
    public String field_username;
    public int field_usernameHash;
    public String field_versionInfo;
    private boolean fjS = true;
    private boolean fkA = true;
    private boolean fkg = true;
    private boolean fpD = true;
    private boolean fqO = true;
    private boolean fqb = true;
    private boolean giU = true;
    private boolean giV = true;
    private boolean giW = true;
    private boolean giX = true;
    private boolean giY = true;
    private boolean giZ = true;
    private boolean gja = true;
    private boolean gjb = true;
    private boolean gjc = true;
    private boolean gjd = true;
    private boolean gje = true;
    private boolean gjf = true;
    private boolean gjg = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (fkB == hashCode) {
                    this.field_usernameHash = cursor.getInt(i2);
                    this.fkA = true;
                } else if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                } else if (fkj == hashCode) {
                    this.field_appId = cursor.getString(i2);
                } else if (fqf == hashCode) {
                    this.field_nickname = cursor.getString(i2);
                } else if (gjh == hashCode) {
                    this.field_shortNickname = cursor.getString(i2);
                } else if (fpR == hashCode) {
                    this.field_brandIconURL = cursor.getString(i2);
                } else if (gji == hashCode) {
                    this.field_roundedSquareIconURL = cursor.getString(i2);
                } else if (gjj == hashCode) {
                    this.field_bigHeadURL = cursor.getString(i2);
                } else if (gjk == hashCode) {
                    this.field_smallHeadURL = cursor.getString(i2);
                } else if (fkx == hashCode) {
                    this.field_signature = cursor.getString(i2);
                } else if (gjl == hashCode) {
                    this.field_appOpt = cursor.getInt(i2);
                } else if (gjm == hashCode) {
                    this.field_registerSource = cursor.getString(i2);
                } else if (gjn == hashCode) {
                    this.field_appInfo = cursor.getString(i2);
                } else if (fPr == hashCode) {
                    this.field_versionInfo = cursor.getString(i2);
                } else if (gjo == hashCode) {
                    this.field_passThroughInfo = cursor.getString(i2);
                } else if (gjp == hashCode) {
                    this.field_bindWxaInfo = cursor.getString(i2);
                } else if (gjq == hashCode) {
                    this.field_dynamicInfo = cursor.getString(i2);
                } else if (fqW == hashCode) {
                    this.field_reserved = cursor.getString(i2);
                } else if (gjr == hashCode) {
                    this.field_syncTimeSecond = cursor.getLong(i2);
                } else if (gjs == hashCode) {
                    this.field_syncVersion = cursor.getString(i2);
                } else if (gjt == hashCode) {
                    this.field_bizMenu = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.fkA) {
            contentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
        }
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fjS) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fqb) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.giU) {
            contentValues.put("shortNickname", this.field_shortNickname);
        }
        if (this.fpD) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.giV) {
            contentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
        }
        if (this.giW) {
            contentValues.put("bigHeadURL", this.field_bigHeadURL);
        }
        if (this.giX) {
            contentValues.put("smallHeadURL", this.field_smallHeadURL);
        }
        if (this.fkg) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.giY) {
            contentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
        }
        if (this.giZ) {
            contentValues.put("registerSource", this.field_registerSource);
        }
        if (this.gja) {
            contentValues.put("appInfo", this.field_appInfo);
        }
        if (this.fPm) {
            contentValues.put("versionInfo", this.field_versionInfo);
        }
        if (this.gjb) {
            contentValues.put("passThroughInfo", this.field_passThroughInfo);
        }
        if (this.gjc) {
            contentValues.put("bindWxaInfo", this.field_bindWxaInfo);
        }
        if (this.gjd) {
            contentValues.put("dynamicInfo", this.field_dynamicInfo);
        }
        if (this.fqO) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.gje) {
            contentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
        }
        if (this.gjf) {
            contentValues.put("syncVersion", this.field_syncVersion);
        }
        if (this.gjg) {
            contentValues.put("bizMenu", this.field_bizMenu);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
