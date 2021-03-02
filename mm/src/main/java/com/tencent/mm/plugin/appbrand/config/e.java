package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e extends MAutoStorage<d> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(d.iBg, "AppBrandCommonKVData")};
    public final ISQLiteDatabase kLX;

    static {
        AppMethodBeat.i(146960);
        AppMethodBeat.o(146960);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, d.iBg, "AppBrandCommonKVData", null);
        this.kLX = iSQLiteDatabase;
    }

    public final boolean cN(String str, String str2) {
        AppMethodBeat.i(146956);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146956);
            return false;
        }
        d dVar = new d();
        dVar.field_key = str;
        dVar.field_value = str2;
        if (!Util.isNullOrNil(dVar.field_value)) {
            boolean replace = super.replace(dVar);
            AppMethodBeat.o(146956);
            return replace;
        } else if (!super.delete(dVar, new String[0])) {
            AppMethodBeat.o(146956);
            return true;
        } else {
            AppMethodBeat.o(146956);
            return false;
        }
    }

    public final String get(String str, String str2) {
        AppMethodBeat.i(146957);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146957);
            return str2;
        }
        d dVar = new d();
        dVar.field_key = str;
        if (super.get(dVar, new String[0])) {
            String str3 = dVar.field_value;
            AppMethodBeat.o(146957);
            return str3;
        }
        AppMethodBeat.o(146957);
        return str2;
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(146958);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146958);
            return false;
        }
        d dVar = new d();
        dVar.field_key = str;
        dVar.field_value = get(str, "");
        if (TextUtils.isEmpty(dVar.field_value) || super.delete(dVar, new String[0])) {
            AppMethodBeat.o(146958);
            return true;
        }
        AppMethodBeat.o(146958);
        return false;
    }

    public final void WY(String str) {
        AppMethodBeat.i(146959);
        super.execSQL("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", "AppBrandCommonKVData", "key", str));
        AppMethodBeat.o(146959);
    }
}
