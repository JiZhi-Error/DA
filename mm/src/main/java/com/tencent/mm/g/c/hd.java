package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hd extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fPO = "tips".hashCode();
    private static final int fyW = "desc".hashCode();
    private static final int gdV = "bindSerial".hashCode();
    private static final int gdW = "cardType".hashCode();
    private static final int gdX = "bankcardState".hashCode();
    private static final int gdY = "forbidWord".hashCode();
    private static final int gdZ = "bankName".hashCode();
    private static final int geA = "forbid_url".hashCode();
    private static final int geB = "no_micro_word".hashCode();
    private static final int geC = "card_bottom_wording".hashCode();
    private static final int geD = "support_lqt_turn_in".hashCode();
    private static final int geE = "support_lqt_turn_out".hashCode();
    private static final int geF = "is_hightlight_pre_arrive_time_wording".hashCode();
    private static final int geG = "card_state_name".hashCode();
    private static final int geH = "prompt_info_prompt_text".hashCode();
    private static final int geI = "prompt_info_jump_text".hashCode();
    private static final int geJ = "prompt_info_jump_url".hashCode();
    private static final int gea = "bankcardType".hashCode();
    private static final int geb = "bankcardTypeName".hashCode();
    private static final int gec = "bankcardTag".hashCode();
    private static final int ged = "bankcardTail".hashCode();
    private static final int gee = "supportTag".hashCode();
    private static final int gef = "mobile".hashCode();
    private static final int geg = "trueName".hashCode();
    private static final int geh = "bankPhone".hashCode();
    private static final int gei = "bizUsername".hashCode();
    private static final int gej = "onceQuotaKind".hashCode();
    private static final int gek = "onceQuotaVirtual".hashCode();
    private static final int gel = "dayQuotaKind".hashCode();
    private static final int gem = "dayQuotaVirtual".hashCode();
    private static final int gen = "fetchArriveTime".hashCode();
    private static final int geo = "fetchArriveTimeWording".hashCode();
    private static final int gep = "repay_url".hashCode();
    private static final int geq = "wxcreditState".hashCode();
    private static final int ger = "bankcardClientType".hashCode();
    private static final int ges = "ext_msg".hashCode();
    private static final int get = "support_micropay".hashCode();
    private static final int geu = "arrive_type".hashCode();
    private static final int gev = "avail_save_wording".hashCode();
    private static final int gew = "fetch_charge_rate".hashCode();
    private static final int gex = "full_fetch_charge_fee".hashCode();
    private static final int gey = "fetch_charge_info".hashCode();
    private static final int gez = "forbid_title".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private boolean fPI = true;
    public String field_arrive_type;
    public String field_avail_save_wording;
    public String field_bankName;
    public String field_bankPhone;
    public int field_bankcardClientType;
    public int field_bankcardState;
    public int field_bankcardTag;
    public String field_bankcardTail;
    public String field_bankcardType;
    public String field_bankcardTypeName;
    public String field_bindSerial;
    public String field_bizUsername;
    public int field_cardType;
    public String field_card_bottom_wording;
    public String field_card_state_name;
    public double field_dayQuotaKind;
    public double field_dayQuotaVirtual;
    public String field_desc;
    public String field_ext_msg;
    public long field_fetchArriveTime;
    public String field_fetchArriveTimeWording;
    public String field_fetch_charge_info;
    public double field_fetch_charge_rate;
    public String field_forbidWord;
    public String field_forbid_title;
    public String field_forbid_url;
    public double field_full_fetch_charge_fee;
    public int field_is_hightlight_pre_arrive_time_wording;
    public String field_mobile;
    public String field_no_micro_word;
    public double field_onceQuotaKind;
    public double field_onceQuotaVirtual;
    public String field_prompt_info_jump_text;
    public String field_prompt_info_jump_url;
    public String field_prompt_info_prompt_text;
    public String field_repay_url;
    public int field_supportTag;
    public int field_support_lqt_turn_in;
    public int field_support_lqt_turn_out;
    public boolean field_support_micropay;
    public String field_tips;
    public String field_trueName;
    public int field_wxcreditState;
    private boolean fyS = true;
    private boolean gdA = true;
    private boolean gdB = true;
    private boolean gdC = true;
    private boolean gdD = true;
    private boolean gdE = true;
    private boolean gdF = true;
    private boolean gdG = true;
    private boolean gdH = true;
    private boolean gdI = true;
    private boolean gdJ = true;
    private boolean gdK = true;
    private boolean gdL = true;
    private boolean gdM = true;
    private boolean gdN = true;
    private boolean gdO = true;
    private boolean gdP = true;
    private boolean gdQ = true;
    private boolean gdR = true;
    private boolean gdS = true;
    private boolean gdT = true;
    private boolean gdU = true;
    private boolean gdg = true;
    private boolean gdh = true;
    private boolean gdi = true;
    private boolean gdj = true;
    private boolean gdk = true;
    private boolean gdl = true;
    private boolean gdm = true;
    private boolean gdn = true;
    private boolean gdo = true;
    private boolean gdp = true;
    private boolean gdq = true;
    private boolean gdr = true;
    private boolean gds = true;
    private boolean gdt = true;
    private boolean gdu = true;
    private boolean gdv = true;
    private boolean gdw = true;
    private boolean gdx = true;
    private boolean gdy = true;
    private boolean gdz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (gdV == hashCode) {
                    this.field_bindSerial = cursor.getString(i2);
                    this.gdg = true;
                } else if (gdW == hashCode) {
                    this.field_cardType = cursor.getInt(i2);
                } else if (gdX == hashCode) {
                    this.field_bankcardState = cursor.getInt(i2);
                } else if (gdY == hashCode) {
                    this.field_forbidWord = cursor.getString(i2);
                } else if (gdZ == hashCode) {
                    this.field_bankName = cursor.getString(i2);
                } else if (gea == hashCode) {
                    this.field_bankcardType = cursor.getString(i2);
                } else if (geb == hashCode) {
                    this.field_bankcardTypeName = cursor.getString(i2);
                } else if (gec == hashCode) {
                    this.field_bankcardTag = cursor.getInt(i2);
                } else if (ged == hashCode) {
                    this.field_bankcardTail = cursor.getString(i2);
                } else if (gee == hashCode) {
                    this.field_supportTag = cursor.getInt(i2);
                } else if (gef == hashCode) {
                    this.field_mobile = cursor.getString(i2);
                } else if (geg == hashCode) {
                    this.field_trueName = cursor.getString(i2);
                } else if (fyW == hashCode) {
                    this.field_desc = cursor.getString(i2);
                } else if (geh == hashCode) {
                    this.field_bankPhone = cursor.getString(i2);
                } else if (gei == hashCode) {
                    this.field_bizUsername = cursor.getString(i2);
                } else if (gej == hashCode) {
                    this.field_onceQuotaKind = cursor.getDouble(i2);
                } else if (gek == hashCode) {
                    this.field_onceQuotaVirtual = cursor.getDouble(i2);
                } else if (gel == hashCode) {
                    this.field_dayQuotaKind = cursor.getDouble(i2);
                } else if (gem == hashCode) {
                    this.field_dayQuotaVirtual = cursor.getDouble(i2);
                } else if (gen == hashCode) {
                    this.field_fetchArriveTime = cursor.getLong(i2);
                } else if (geo == hashCode) {
                    this.field_fetchArriveTimeWording = cursor.getString(i2);
                } else if (gep == hashCode) {
                    this.field_repay_url = cursor.getString(i2);
                } else if (geq == hashCode) {
                    this.field_wxcreditState = cursor.getInt(i2);
                } else if (ger == hashCode) {
                    this.field_bankcardClientType = cursor.getInt(i2);
                } else if (ges == hashCode) {
                    this.field_ext_msg = cursor.getString(i2);
                } else if (get == hashCode) {
                    this.field_support_micropay = cursor.getInt(i2) != 0;
                } else if (geu == hashCode) {
                    this.field_arrive_type = cursor.getString(i2);
                } else if (gev == hashCode) {
                    this.field_avail_save_wording = cursor.getString(i2);
                } else if (gew == hashCode) {
                    this.field_fetch_charge_rate = cursor.getDouble(i2);
                } else if (gex == hashCode) {
                    this.field_full_fetch_charge_fee = cursor.getDouble(i2);
                } else if (gey == hashCode) {
                    this.field_fetch_charge_info = cursor.getString(i2);
                } else if (fPO == hashCode) {
                    this.field_tips = cursor.getString(i2);
                } else if (gez == hashCode) {
                    this.field_forbid_title = cursor.getString(i2);
                } else if (geA == hashCode) {
                    this.field_forbid_url = cursor.getString(i2);
                } else if (geB == hashCode) {
                    this.field_no_micro_word = cursor.getString(i2);
                } else if (geC == hashCode) {
                    this.field_card_bottom_wording = cursor.getString(i2);
                } else if (geD == hashCode) {
                    this.field_support_lqt_turn_in = cursor.getInt(i2);
                } else if (geE == hashCode) {
                    this.field_support_lqt_turn_out = cursor.getInt(i2);
                } else if (geF == hashCode) {
                    this.field_is_hightlight_pre_arrive_time_wording = cursor.getInt(i2);
                } else if (geG == hashCode) {
                    this.field_card_state_name = cursor.getString(i2);
                } else if (geH == hashCode) {
                    this.field_prompt_info_prompt_text = cursor.getString(i2);
                } else if (geI == hashCode) {
                    this.field_prompt_info_jump_text = cursor.getString(i2);
                } else if (geJ == hashCode) {
                    this.field_prompt_info_jump_url = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gdg) {
            contentValues.put("bindSerial", this.field_bindSerial);
        }
        if (this.gdh) {
            contentValues.put("cardType", Integer.valueOf(this.field_cardType));
        }
        if (this.gdi) {
            contentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
        }
        if (this.gdj) {
            contentValues.put("forbidWord", this.field_forbidWord);
        }
        if (this.gdk) {
            contentValues.put("bankName", this.field_bankName);
        }
        if (this.gdl) {
            contentValues.put("bankcardType", this.field_bankcardType);
        }
        if (this.gdm) {
            contentValues.put("bankcardTypeName", this.field_bankcardTypeName);
        }
        if (this.gdn) {
            contentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
        }
        if (this.gdo) {
            contentValues.put("bankcardTail", this.field_bankcardTail);
        }
        if (this.gdp) {
            contentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
        }
        if (this.gdq) {
            contentValues.put("mobile", this.field_mobile);
        }
        if (this.gdr) {
            contentValues.put("trueName", this.field_trueName);
        }
        if (this.fyS) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.gds) {
            contentValues.put("bankPhone", this.field_bankPhone);
        }
        if (this.gdt) {
            contentValues.put("bizUsername", this.field_bizUsername);
        }
        if (this.gdu) {
            contentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
        }
        if (this.gdv) {
            contentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
        }
        if (this.gdw) {
            contentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
        }
        if (this.gdx) {
            contentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
        }
        if (this.gdy) {
            contentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
        }
        if (this.gdz) {
            contentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
        }
        if (this.gdA) {
            contentValues.put("repay_url", this.field_repay_url);
        }
        if (this.gdB) {
            contentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
        }
        if (this.gdC) {
            contentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
        }
        if (this.gdD) {
            contentValues.put("ext_msg", this.field_ext_msg);
        }
        if (this.gdE) {
            contentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
        }
        if (this.gdF) {
            contentValues.put("arrive_type", this.field_arrive_type);
        }
        if (this.gdG) {
            contentValues.put("avail_save_wording", this.field_avail_save_wording);
        }
        if (this.gdH) {
            contentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
        }
        if (this.gdI) {
            contentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
        }
        if (this.gdJ) {
            contentValues.put("fetch_charge_info", this.field_fetch_charge_info);
        }
        if (this.fPI) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.gdK) {
            contentValues.put("forbid_title", this.field_forbid_title);
        }
        if (this.gdL) {
            contentValues.put("forbid_url", this.field_forbid_url);
        }
        if (this.gdM) {
            contentValues.put("no_micro_word", this.field_no_micro_word);
        }
        if (this.gdN) {
            contentValues.put("card_bottom_wording", this.field_card_bottom_wording);
        }
        if (this.gdO) {
            contentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
        }
        if (this.gdP) {
            contentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
        }
        if (this.gdQ) {
            contentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
        }
        if (this.gdR) {
            contentValues.put("card_state_name", this.field_card_state_name);
        }
        if (this.gdS) {
            contentValues.put("prompt_info_prompt_text", this.field_prompt_info_prompt_text);
        }
        if (this.gdT) {
            contentValues.put("prompt_info_jump_text", this.field_prompt_info_jump_text);
        }
        if (this.gdU) {
            contentValues.put("prompt_info_jump_url", this.field_prompt_info_jump_url);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
