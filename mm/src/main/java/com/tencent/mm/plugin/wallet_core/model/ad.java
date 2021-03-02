package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import org.json.JSONObject;

public final class ad extends hh {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public static ad bO(JSONObject jSONObject) {
        AppMethodBeat.i(70429);
        if (jSONObject == null) {
            Log.e("MicroMsg.WalletKindInfo", "json is null");
            AppMethodBeat.o(70429);
            return null;
        }
        ad adVar = new ad();
        adVar.field_wallet_tpa_country = jSONObject.optString("wallet_tpa_country");
        adVar.field_wallet_name = jSONObject.optString("wallet_name");
        adVar.field_wallet_selected = jSONObject.optInt("wallet_selected");
        adVar.field_wallet_type = jSONObject.optInt("wallet_type");
        adVar.field_wallet_balance = jSONObject.optInt("wallet_balance");
        adVar.field_wallet_tpa_country_mask = jSONObject.optInt("wallet_tpa_country_mask");
        if (Util.isNullOrNil(adVar.field_wallet_tpa_country)) {
            Log.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
            AppMethodBeat.o(70429);
            return null;
        }
        AppMethodBeat.o(70429);
        return adVar;
    }

    static {
        AppMethodBeat.i(70430);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "wallet_tpa_country";
        mAutoDBInfo.colsMap.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
        sb.append(" wallet_tpa_country TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "wallet_tpa_country";
        mAutoDBInfo.columns[1] = "wallet_type";
        mAutoDBInfo.colsMap.put("wallet_type", "INTEGER");
        sb.append(" wallet_type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "wallet_name";
        mAutoDBInfo.colsMap.put("wallet_name", "TEXT");
        sb.append(" wallet_name TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "wallet_selected";
        mAutoDBInfo.colsMap.put("wallet_selected", "INTEGER");
        sb.append(" wallet_selected INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "wallet_balance";
        mAutoDBInfo.colsMap.put("wallet_balance", "INTEGER");
        sb.append(" wallet_balance INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "wallet_tpa_country_mask";
        mAutoDBInfo.colsMap.put("wallet_tpa_country_mask", "INTEGER");
        sb.append(" wallet_tpa_country_mask INTEGER");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70430);
    }
}
