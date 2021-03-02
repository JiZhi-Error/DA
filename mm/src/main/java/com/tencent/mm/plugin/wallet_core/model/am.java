package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hl;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

public final class am extends hl {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean fRk() {
        return this.field_is_reg == 1;
    }

    public final boolean fRl() {
        return this.field_is_reg == 2;
    }

    public final boolean fRm() {
        return this.field_is_reg == 0;
    }

    public final boolean fRn() {
        return this.field_is_reg == -1;
    }

    public final boolean fRo() {
        return this.field_is_open_touch == 1;
    }

    static {
        AppMethodBeat.i(70492);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[32];
        mAutoDBInfo.columns = new String[33];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = OpenSDKTool4Assistant.EXTRA_UIN;
        mAutoDBInfo.colsMap.put(OpenSDKTool4Assistant.EXTRA_UIN, "TEXT PRIMARY KEY ");
        sb.append(" uin TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = OpenSDKTool4Assistant.EXTRA_UIN;
        mAutoDBInfo.columns[1] = "is_reg";
        mAutoDBInfo.colsMap.put("is_reg", "INTEGER");
        sb.append(" is_reg INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "true_name";
        mAutoDBInfo.colsMap.put("true_name", "TEXT");
        sb.append(" true_name TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "card_num";
        mAutoDBInfo.colsMap.put("card_num", "INTEGER");
        sb.append(" card_num INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "isDomesticUser";
        mAutoDBInfo.colsMap.put("isDomesticUser", "INTEGER");
        sb.append(" isDomesticUser INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "cre_type";
        mAutoDBInfo.colsMap.put("cre_type", "INTEGER");
        sb.append(" cre_type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "main_card_bind_serialno";
        mAutoDBInfo.colsMap.put("main_card_bind_serialno", "TEXT");
        sb.append(" main_card_bind_serialno TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "ftf_pay_url";
        mAutoDBInfo.colsMap.put("ftf_pay_url", "TEXT");
        sb.append(" ftf_pay_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "switchConfig";
        mAutoDBInfo.colsMap.put("switchConfig", "INTEGER");
        sb.append(" switchConfig INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "reset_passwd_flag";
        mAutoDBInfo.colsMap.put("reset_passwd_flag", "TEXT");
        sb.append(" reset_passwd_flag TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "find_passwd_url";
        mAutoDBInfo.colsMap.put("find_passwd_url", "TEXT");
        sb.append(" find_passwd_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "is_open_touch";
        mAutoDBInfo.colsMap.put("is_open_touch", "INTEGER");
        sb.append(" is_open_touch INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "lct_wording";
        mAutoDBInfo.colsMap.put("lct_wording", "TEXT");
        sb.append(" lct_wording TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "lct_url";
        mAutoDBInfo.colsMap.put("lct_url", "TEXT");
        sb.append(" lct_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "cre_name";
        mAutoDBInfo.colsMap.put("cre_name", "TEXT");
        sb.append(" cre_name TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "lqt_state";
        mAutoDBInfo.colsMap.put("lqt_state", "INTEGER");
        sb.append(" lqt_state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "paymenu_use_new";
        mAutoDBInfo.colsMap.put("paymenu_use_new", "INTEGER");
        sb.append(" paymenu_use_new INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "is_show_lqb";
        mAutoDBInfo.colsMap.put("is_show_lqb", "INTEGER");
        sb.append(" is_show_lqb INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "is_open_lqb";
        mAutoDBInfo.colsMap.put("is_open_lqb", "INTEGER");
        sb.append(" is_open_lqb INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "lqb_open_url";
        mAutoDBInfo.colsMap.put("lqb_open_url", "TEXT");
        sb.append(" lqb_open_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "lqt_cell_is_show";
        mAutoDBInfo.colsMap.put("lqt_cell_is_show", "INTEGER");
        sb.append(" lqt_cell_is_show INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "lqt_cell_icon";
        mAutoDBInfo.colsMap.put("lqt_cell_icon", "TEXT");
        sb.append(" lqt_cell_icon TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "lqt_cell_is_open_lqt";
        mAutoDBInfo.colsMap.put("lqt_cell_is_open_lqt", "INTEGER");
        sb.append(" lqt_cell_is_open_lqt INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "lqt_cell_lqt_open_url";
        mAutoDBInfo.colsMap.put("lqt_cell_lqt_open_url", "TEXT");
        sb.append(" lqt_cell_lqt_open_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "lqt_cell_lqt_title";
        mAutoDBInfo.colsMap.put("lqt_cell_lqt_title", "TEXT");
        sb.append(" lqt_cell_lqt_title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "lqt_cell_lqt_wording";
        mAutoDBInfo.colsMap.put("lqt_cell_lqt_wording", "TEXT");
        sb.append(" lqt_cell_lqt_wording TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "forget_passwd_url";
        mAutoDBInfo.colsMap.put("forget_passwd_url", "TEXT");
        sb.append(" forget_passwd_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "unipay_order_state";
        mAutoDBInfo.colsMap.put("unipay_order_state", "INTEGER");
        sb.append(" unipay_order_state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[28] = "bank_priority";
        mAutoDBInfo.colsMap.put("bank_priority", "TEXT");
        sb.append(" bank_priority TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[29] = "wallet_balance";
        mAutoDBInfo.colsMap.put("wallet_balance", "LONG");
        sb.append(" wallet_balance LONG");
        sb.append(", ");
        mAutoDBInfo.columns[30] = "wallet_entrance_balance_switch_state";
        mAutoDBInfo.colsMap.put("wallet_entrance_balance_switch_state", "INTEGER");
        sb.append(" wallet_entrance_balance_switch_state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[31] = "soter_pay_open_type";
        mAutoDBInfo.colsMap.put("soter_pay_open_type", "INTEGER");
        sb.append(" soter_pay_open_type INTEGER");
        mAutoDBInfo.columns[32] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70492);
    }
}
