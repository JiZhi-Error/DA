package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.IOException;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "PBCache")};

    static {
        AppMethodBeat.i(89952);
        AppMethodBeat.o(89952);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "PBCache", null);
    }

    public final byte[] azn(String str) {
        AppMethodBeat.i(89950);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(89950);
            return null;
        }
        a aVar = new a();
        aVar.field_key = str;
        if (super.get(aVar, new String[0])) {
            byte[] bArr = aVar.field_value;
            AppMethodBeat.o(89950);
            return bArr;
        }
        AppMethodBeat.o(89950);
        return null;
    }

    public final boolean b(String str, a aVar) {
        AppMethodBeat.i(89951);
        if (Util.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(89951);
            return false;
        }
        try {
            boolean r = r(str, aVar.toByteArray());
            AppMethodBeat.o(89951);
            return r;
        } catch (IOException e2) {
            Log.e("MicroMsg.PBCacheStorage", "Saving Failed: %s", e2.getMessage());
            AppMethodBeat.o(89951);
            return false;
        }
    }

    public final boolean r(String str, byte[] bArr) {
        boolean z = false;
        AppMethodBeat.i(184539);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(184539);
        } else {
            a aVar = new a();
            aVar.field_key = str;
            if (super.get(aVar, new String[0])) {
                aVar.field_value = bArr;
                z = super.update(aVar, new String[0]);
            } else {
                aVar.field_value = bArr;
                z = super.insert(aVar);
            }
            if (!z) {
                Log.e("MicroMsg.PBCacheStorage", "Saving cache failed (update or insert)");
            }
            AppMethodBeat.o(184539);
        }
        return z;
    }

    public final void azo(String str) {
        AppMethodBeat.i(184540);
        a aVar = new a();
        aVar.field_key = str;
        super.delete(aVar, new String[0]);
        AppMethodBeat.o(184540);
    }
}
