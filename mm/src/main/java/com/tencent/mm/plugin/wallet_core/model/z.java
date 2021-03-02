package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hg;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;

public final class z extends hg {
    public static IAutoDBItem.MAutoDBInfo info;
    public ArrayList<MallFunction> zjo = new ArrayList<>();
    private ArrayList<MallNews> zjp = new ArrayList<>();
    private ArrayList<a> zjq = new ArrayList<>();
    public SparseArray<String> zjr = new SparseArray<>();

    public z() {
        AppMethodBeat.i(70416);
        AppMethodBeat.o(70416);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.g.c.hg, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(70417);
        super.convertFrom(cursor);
        String str = this.field_function_list;
        String str2 = this.field_new_list;
        String str3 = this.field_banner_list;
        String str4 = this.field_type_name_list;
        try {
            if (!Util.isNullOrNil(str)) {
                this.zjo = b.R(new JSONArray(str));
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e2, "", new Object[0]);
        }
        try {
            if (!Util.isNullOrNil(str2)) {
                this.zjp = b.O(new JSONArray(str2));
            }
        } catch (Exception e3) {
            this.zjp = null;
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e3, "", new Object[0]);
        }
        try {
            if (!Util.isNullOrNil(str3)) {
                this.zjq = b.P(new JSONArray(str3));
            }
        } catch (Exception e4) {
            this.zjq = null;
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e4, "", new Object[0]);
        }
        try {
            if (!Util.isNullOrNil(str4)) {
                this.zjr = b.Q(new JSONArray(str4));
            }
            AppMethodBeat.o(70417);
        } catch (Exception e5) {
            this.zjr = null;
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e5, "", new Object[0]);
            AppMethodBeat.o(70417);
        }
    }

    static {
        AppMethodBeat.i(70418);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "wallet_region";
        mAutoDBInfo.colsMap.put("wallet_region", "INTEGER PRIMARY KEY ");
        sb.append(" wallet_region INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "wallet_region";
        mAutoDBInfo.columns[1] = "function_list";
        mAutoDBInfo.colsMap.put("function_list", "TEXT");
        sb.append(" function_list TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "new_list";
        mAutoDBInfo.colsMap.put("new_list", "TEXT");
        sb.append(" new_list TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "banner_list";
        mAutoDBInfo.colsMap.put("banner_list", "TEXT");
        sb.append(" banner_list TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "type_name_list";
        mAutoDBInfo.colsMap.put("type_name_list", "TEXT");
        sb.append(" type_name_list TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "isShowSetting";
        mAutoDBInfo.colsMap.put("isShowSetting", "INTEGER");
        sb.append(" isShowSetting INTEGER");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70418);
    }
}
