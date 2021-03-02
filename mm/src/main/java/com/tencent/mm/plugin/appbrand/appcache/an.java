package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.s;

public class an extends c<am> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(am.iBg, "PredownloadEncryptPkgInfo")};
    private final ISQLiteDatabase kLX;

    static {
        AppMethodBeat.i(90563);
        AppMethodBeat.o(90563);
    }

    public an(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, am.iBg, "PredownloadEncryptPkgInfo", am.INDEX_CREATE);
        this.kLX = iSQLiteDatabase;
    }

    public final am z(String str, int i2, int i3) {
        AppMethodBeat.i(90560);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(90560);
            return null;
        }
        am amVar = new am();
        amVar.field_appId = str;
        amVar.field_type = i2;
        amVar.field_version = i3;
        if (get(amVar, am.kJX)) {
            AppMethodBeat.o(90560);
            return amVar;
        }
        AppMethodBeat.o(90560);
        return null;
    }

    public final am A(String str, int i2, int i3) {
        AppMethodBeat.i(90561);
        am z = z(str, i2, i3);
        if (z == null || !a(z)) {
            AppMethodBeat.o(90561);
            return null;
        }
        AppMethodBeat.o(90561);
        return z;
    }

    static boolean a(am amVar) {
        AppMethodBeat.i(90562);
        if (Util.isNullOrNil(amVar.field_pkgPath)) {
            Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", amVar.toShortString());
            AppMethodBeat.o(90562);
            return false;
        } else if (Util.isNullOrNil(amVar.field_pkgMd5)) {
            Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", amVar.toShortString());
            AppMethodBeat.o(90562);
            return false;
        } else {
            String bhK = s.bhK(amVar.field_pkgPath);
            Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", amVar.toShortString(), bhK, amVar.field_pkgMd5);
            boolean equals = amVar.field_pkgMd5.equals(bhK);
            AppMethodBeat.o(90562);
            return equals;
        }
    }
}
