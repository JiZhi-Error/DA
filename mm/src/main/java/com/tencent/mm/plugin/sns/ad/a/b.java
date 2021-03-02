package com.tencent.mm.plugin.sns.ad.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class b {
    public SparseArray<a> DrN;

    public static class a {
        public int DrO;
        public int type;

        static a u(Map<String, String> map, String str) {
            AppMethodBeat.i(201849);
            if (c.isEmpty(map)) {
                AppMethodBeat.o(201849);
                return null;
            }
            int safeParseInt = Util.safeParseInt(map.get(str + ".type"));
            int safeParseInt2 = Util.safeParseInt(map.get(str + ".expireTime")) * 1000;
            if (safeParseInt == 0 || safeParseInt2 == 0) {
                AppMethodBeat.o(201849);
                return null;
            }
            a aVar = new a();
            aVar.type = safeParseInt;
            aVar.DrO = safeParseInt2;
            AppMethodBeat.o(201849);
            return aVar;
        }
    }

    public static b t(Map<String, String> map, String str) {
        b bVar;
        a u;
        AppMethodBeat.i(201850);
        try {
            if (c.isEmpty(map)) {
                AppMethodBeat.o(201850);
                return null;
            }
            SparseArray<a> sparseArray = null;
            for (int i2 = 0; i2 < 20; i2++) {
                if (i2 == 0) {
                    u = a.u(map, str + ".action");
                    if (u != null) {
                        sparseArray = new SparseArray<>();
                    }
                } else {
                    u = a.u(map, str + ".action" + i2);
                }
                if (u == null || sparseArray == null) {
                    break;
                }
                sparseArray.put(u.type, u);
            }
            if (sparseArray == null || sparseArray.size() <= 0) {
                bVar = null;
            } else {
                bVar = new b();
                bVar.DrN = sparseArray;
            }
            AppMethodBeat.o(201850);
            return bVar;
        } catch (Throwable th) {
            Log.e("AdDynamicUpdateInfo", "parse the update info failed!!");
            AppMethodBeat.o(201850);
            return null;
        }
    }
}
