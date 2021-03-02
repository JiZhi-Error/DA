package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.IOException;

public final class w extends MAutoStorage<v> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(v.info, "GamePBCache")};

    static {
        AppMethodBeat.i(41522);
        AppMethodBeat.o(41522);
    }

    public w(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, v.info, "GamePBCache", null);
    }

    public final byte[] azn(String str) {
        AppMethodBeat.i(41519);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41519);
            return null;
        } else if (!LocaleUtil.getApplicationLanguage().equals(e.dUX())) {
            AppMethodBeat.o(41519);
            return null;
        } else {
            v vVar = new v();
            vVar.field_key = str;
            if (super.get(vVar, new String[0])) {
                byte[] bArr = vVar.field_value;
                AppMethodBeat.o(41519);
                return bArr;
            }
            AppMethodBeat.o(41519);
            return null;
        }
    }

    public final boolean b(String str, a aVar) {
        AppMethodBeat.i(41520);
        if (Util.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(41520);
            return false;
        }
        try {
            boolean r = r(str, aVar.toByteArray());
            AppMethodBeat.o(41520);
            return r;
        } catch (IOException e2) {
            Log.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", e2.getMessage());
            AppMethodBeat.o(41520);
            return false;
        }
    }

    public final boolean r(String str, byte[] bArr) {
        boolean z = false;
        AppMethodBeat.i(41521);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(41521);
        } else {
            v vVar = new v();
            vVar.field_key = str;
            if (super.get(vVar, new String[0])) {
                vVar.field_value = bArr;
                z = super.update(vVar, new String[0]);
            } else {
                vVar.field_value = bArr;
                z = super.insert(vVar);
            }
            if (!z) {
                Log.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
            }
            AppMethodBeat.o(41521);
        }
        return z;
    }

    public final boolean aAl(String str) {
        AppMethodBeat.i(204178);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(204178);
            return false;
        }
        v vVar = new v();
        vVar.field_key = str;
        boolean delete = super.delete(vVar, new String[0]);
        AppMethodBeat.o(204178);
        return delete;
    }
}
