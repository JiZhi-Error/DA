package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class f extends MAutoStorage<z> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(z.info, "WalletFunciontList")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(70614);
        AppMethodBeat.o(70614);
    }

    public f(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, z.info, "WalletFunciontList", null);
        this.db = iSQLiteDatabase;
    }

    public final void b(int i2, String str, String str2, String str3, String str4, int i3) {
        AppMethodBeat.i(70613);
        z zVar = new z();
        zVar.field_wallet_region = i2;
        zVar.field_function_list = str;
        zVar.field_new_list = str2;
        zVar.field_banner_list = str3;
        zVar.field_type_name_list = str4;
        zVar.field_isShowSetting = i3;
        super.replace(zVar);
        AppMethodBeat.o(70613);
    }
}
