package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public abstract class hl extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int gfo = "wallet_balance".hashCode();
    private static final int ggA = "is_reg".hashCode();
    private static final int ggB = "true_name".hashCode();
    private static final int ggC = "card_num".hashCode();
    private static final int ggD = "isDomesticUser".hashCode();
    private static final int ggE = "cre_type".hashCode();
    private static final int ggF = "main_card_bind_serialno".hashCode();
    private static final int ggG = "ftf_pay_url".hashCode();
    private static final int ggH = "switchConfig".hashCode();
    private static final int ggI = "reset_passwd_flag".hashCode();
    private static final int ggJ = "find_passwd_url".hashCode();
    private static final int ggK = "is_open_touch".hashCode();
    private static final int ggL = "lct_wording".hashCode();
    private static final int ggM = "lct_url".hashCode();
    private static final int ggN = "cre_name".hashCode();
    private static final int ggO = "lqt_state".hashCode();
    private static final int ggP = "paymenu_use_new".hashCode();
    private static final int ggQ = "is_show_lqb".hashCode();
    private static final int ggR = "is_open_lqb".hashCode();
    private static final int ggS = "lqb_open_url".hashCode();
    private static final int ggT = "lqt_cell_is_show".hashCode();
    private static final int ggU = "lqt_cell_icon".hashCode();
    private static final int ggV = "lqt_cell_is_open_lqt".hashCode();
    private static final int ggW = "lqt_cell_lqt_open_url".hashCode();
    private static final int ggX = "lqt_cell_lqt_title".hashCode();
    private static final int ggY = "lqt_cell_lqt_wording".hashCode();
    private static final int ggZ = "forget_passwd_url".hashCode();
    private static final int ggz = OpenSDKTool4Assistant.EXTRA_UIN.hashCode();
    private static final int gha = "unipay_order_state".hashCode();
    private static final int ghb = "bank_priority".hashCode();
    private static final int ghc = "wallet_entrance_balance_switch_state".hashCode();
    private static final int ghd = "soter_pay_open_type".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_bank_priority;
    public int field_card_num;
    public String field_cre_name;
    public int field_cre_type;
    public String field_find_passwd_url;
    public String field_forget_passwd_url;
    public String field_ftf_pay_url;
    public boolean field_isDomesticUser;
    public int field_is_open_lqb;
    public int field_is_open_touch;
    public int field_is_reg;
    public int field_is_show_lqb;
    public String field_lct_url;
    public String field_lct_wording;
    public String field_lqb_open_url;
    public String field_lqt_cell_icon;
    public int field_lqt_cell_is_open_lqt;
    public int field_lqt_cell_is_show;
    public String field_lqt_cell_lqt_open_url;
    public String field_lqt_cell_lqt_title;
    public String field_lqt_cell_lqt_wording;
    public int field_lqt_state;
    public String field_main_card_bind_serialno;
    public int field_paymenu_use_new;
    public String field_reset_passwd_flag;
    public int field_soter_pay_open_type;
    public int field_switchConfig;
    public String field_true_name;
    public String field_uin;
    public int field_unipay_order_state;
    public long field_wallet_balance;
    public int field_wallet_entrance_balance_switch_state;
    private boolean gfU = true;
    private boolean gfV = true;
    private boolean gfW = true;
    private boolean gfX = true;
    private boolean gfY = true;
    private boolean gfZ = true;
    private boolean gfi = true;
    private boolean gga = true;
    private boolean ggb = true;
    private boolean ggc = true;
    private boolean ggd = true;
    private boolean gge = true;
    private boolean ggf = true;
    private boolean ggg = true;
    private boolean ggh = true;
    private boolean ggi = true;
    private boolean ggj = true;
    private boolean ggk = true;
    private boolean ggl = true;
    private boolean ggm = true;
    private boolean ggn = true;
    private boolean ggo = true;
    private boolean ggp = true;
    private boolean ggq = true;
    private boolean ggr = true;
    private boolean ggs = true;
    private boolean ggt = true;
    private boolean ggu = true;
    private boolean ggv = true;
    private boolean ggw = true;
    private boolean ggx = true;
    private boolean ggy = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (ggz == hashCode) {
                    this.field_uin = cursor.getString(i2);
                    this.gfU = true;
                } else if (ggA == hashCode) {
                    this.field_is_reg = cursor.getInt(i2);
                } else if (ggB == hashCode) {
                    this.field_true_name = cursor.getString(i2);
                } else if (ggC == hashCode) {
                    this.field_card_num = cursor.getInt(i2);
                } else if (ggD == hashCode) {
                    this.field_isDomesticUser = cursor.getInt(i2) != 0;
                } else if (ggE == hashCode) {
                    this.field_cre_type = cursor.getInt(i2);
                } else if (ggF == hashCode) {
                    this.field_main_card_bind_serialno = cursor.getString(i2);
                } else if (ggG == hashCode) {
                    this.field_ftf_pay_url = cursor.getString(i2);
                } else if (ggH == hashCode) {
                    this.field_switchConfig = cursor.getInt(i2);
                } else if (ggI == hashCode) {
                    this.field_reset_passwd_flag = cursor.getString(i2);
                } else if (ggJ == hashCode) {
                    this.field_find_passwd_url = cursor.getString(i2);
                } else if (ggK == hashCode) {
                    this.field_is_open_touch = cursor.getInt(i2);
                } else if (ggL == hashCode) {
                    this.field_lct_wording = cursor.getString(i2);
                } else if (ggM == hashCode) {
                    this.field_lct_url = cursor.getString(i2);
                } else if (ggN == hashCode) {
                    this.field_cre_name = cursor.getString(i2);
                } else if (ggO == hashCode) {
                    this.field_lqt_state = cursor.getInt(i2);
                } else if (ggP == hashCode) {
                    this.field_paymenu_use_new = cursor.getInt(i2);
                } else if (ggQ == hashCode) {
                    this.field_is_show_lqb = cursor.getInt(i2);
                } else if (ggR == hashCode) {
                    this.field_is_open_lqb = cursor.getInt(i2);
                } else if (ggS == hashCode) {
                    this.field_lqb_open_url = cursor.getString(i2);
                } else if (ggT == hashCode) {
                    this.field_lqt_cell_is_show = cursor.getInt(i2);
                } else if (ggU == hashCode) {
                    this.field_lqt_cell_icon = cursor.getString(i2);
                } else if (ggV == hashCode) {
                    this.field_lqt_cell_is_open_lqt = cursor.getInt(i2);
                } else if (ggW == hashCode) {
                    this.field_lqt_cell_lqt_open_url = cursor.getString(i2);
                } else if (ggX == hashCode) {
                    this.field_lqt_cell_lqt_title = cursor.getString(i2);
                } else if (ggY == hashCode) {
                    this.field_lqt_cell_lqt_wording = cursor.getString(i2);
                } else if (ggZ == hashCode) {
                    this.field_forget_passwd_url = cursor.getString(i2);
                } else if (gha == hashCode) {
                    this.field_unipay_order_state = cursor.getInt(i2);
                } else if (ghb == hashCode) {
                    this.field_bank_priority = cursor.getString(i2);
                } else if (gfo == hashCode) {
                    this.field_wallet_balance = cursor.getLong(i2);
                } else if (ghc == hashCode) {
                    this.field_wallet_entrance_balance_switch_state = cursor.getInt(i2);
                } else if (ghd == hashCode) {
                    this.field_soter_pay_open_type = cursor.getInt(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.gfU) {
            contentValues.put(OpenSDKTool4Assistant.EXTRA_UIN, this.field_uin);
        }
        if (this.gfV) {
            contentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
        }
        if (this.gfW) {
            contentValues.put("true_name", this.field_true_name);
        }
        if (this.gfX) {
            contentValues.put("card_num", Integer.valueOf(this.field_card_num));
        }
        if (this.gfY) {
            contentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
        }
        if (this.gfZ) {
            contentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
        }
        if (this.gga) {
            contentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
        }
        if (this.ggb) {
            contentValues.put("ftf_pay_url", this.field_ftf_pay_url);
        }
        if (this.ggc) {
            contentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
        }
        if (this.ggd) {
            contentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
        }
        if (this.gge) {
            contentValues.put("find_passwd_url", this.field_find_passwd_url);
        }
        if (this.ggf) {
            contentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
        }
        if (this.ggg) {
            contentValues.put("lct_wording", this.field_lct_wording);
        }
        if (this.ggh) {
            contentValues.put("lct_url", this.field_lct_url);
        }
        if (this.ggi) {
            contentValues.put("cre_name", this.field_cre_name);
        }
        if (this.ggj) {
            contentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
        }
        if (this.ggk) {
            contentValues.put("paymenu_use_new", Integer.valueOf(this.field_paymenu_use_new));
        }
        if (this.ggl) {
            contentValues.put("is_show_lqb", Integer.valueOf(this.field_is_show_lqb));
        }
        if (this.ggm) {
            contentValues.put("is_open_lqb", Integer.valueOf(this.field_is_open_lqb));
        }
        if (this.ggn) {
            contentValues.put("lqb_open_url", this.field_lqb_open_url);
        }
        if (this.ggo) {
            contentValues.put("lqt_cell_is_show", Integer.valueOf(this.field_lqt_cell_is_show));
        }
        if (this.ggp) {
            contentValues.put("lqt_cell_icon", this.field_lqt_cell_icon);
        }
        if (this.ggq) {
            contentValues.put("lqt_cell_is_open_lqt", Integer.valueOf(this.field_lqt_cell_is_open_lqt));
        }
        if (this.ggr) {
            contentValues.put("lqt_cell_lqt_open_url", this.field_lqt_cell_lqt_open_url);
        }
        if (this.ggs) {
            contentValues.put("lqt_cell_lqt_title", this.field_lqt_cell_lqt_title);
        }
        if (this.ggt) {
            contentValues.put("lqt_cell_lqt_wording", this.field_lqt_cell_lqt_wording);
        }
        if (this.ggu) {
            contentValues.put("forget_passwd_url", this.field_forget_passwd_url);
        }
        if (this.ggv) {
            contentValues.put("unipay_order_state", Integer.valueOf(this.field_unipay_order_state));
        }
        if (this.ggw) {
            contentValues.put("bank_priority", this.field_bank_priority);
        }
        if (this.gfi) {
            contentValues.put("wallet_balance", Long.valueOf(this.field_wallet_balance));
        }
        if (this.ggx) {
            contentValues.put("wallet_entrance_balance_switch_state", Integer.valueOf(this.field_wallet_entrance_balance_switch_state));
        }
        if (this.ggy) {
            contentValues.put("soter_pay_open_type", Integer.valueOf(this.field_soter_pay_open_type));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
