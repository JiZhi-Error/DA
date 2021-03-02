package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import junit.framework.Assert;

public final class ih extends h {
    private static HashMap<Integer, h.b> baseDBFactories;
    private static ih gkc = null;

    static {
        AppMethodBeat.i(127419);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.g.c.ih.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(127411);
                String[] strArr = {MAutoStorage.getCreateSQLs(by.ajs(), "FavItemInfo")};
                AppMethodBeat.o(127411);
                return strArr;
            }
        });
        baseDBFactories.put(Integer.valueOf("FavSearchInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.g.c.ih.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(127412);
                String[] strArr = {MAutoStorage.getCreateSQLs(ca.ajs(), "FavSearchInfo")};
                AppMethodBeat.o(127412);
                return strArr;
            }
        });
        baseDBFactories.put(Integer.valueOf("FavEditInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.g.c.ih.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(127413);
                String[] strArr = {MAutoStorage.getCreateSQLs(bx.ajs(), "FavEditInfo")};
                AppMethodBeat.o(127413);
                return strArr;
            }
        });
        baseDBFactories.put(Integer.valueOf("FavCdnInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.g.c.ih.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(127414);
                String[] strArr = {MAutoStorage.getCreateSQLs(bv.ajs(), "FavCdnInfo")};
                AppMethodBeat.o(127414);
                return strArr;
            }
        });
        baseDBFactories.put(Integer.valueOf("FavConfigInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.g.c.ih.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(127415);
                String[] strArr = {MAutoStorage.getCreateSQLs(bw.ajs(), "FavConfigInfo")};
                AppMethodBeat.o(127415);
                return strArr;
            }
        });
        AppMethodBeat.o(127419);
    }

    private ih() {
        boolean z;
        AppMethodBeat.i(127416);
        long currentTimeMillis = System.currentTimeMillis();
        g.aAf();
        if (a.getUin() != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = g.aAh().cachePath + "enFavorite.db";
        Log.d("MicroMsg.FavoriteDataBase", "db path", str);
        g.aAf();
        q.dr(true);
        if (!a("", str, (long) a.getUin(), baseDBFactories)) {
            b bVar = new b((byte) 0);
            AppMethodBeat.o(127416);
            throw bVar;
        }
        String str2 = this.OtE;
        if (!Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.FavoriteDataBase", "dbinit failed :".concat(String.valueOf(str2)));
            CrashReportFactory.reportRawMessage("init db Favorite Failed: [ " + str2 + "]", "DBinit");
        }
        Log.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(127416);
    }

    public static ih ajW() {
        AppMethodBeat.i(127417);
        if (gkc == null) {
            gkc = new ih();
        }
        ih ihVar = gkc;
        AppMethodBeat.o(127417);
        return ihVar;
    }

    @Override // com.tencent.mm.storagebase.h
    public final void CL(String str) {
        AppMethodBeat.i(127418);
        super.CL(str);
        gkc = null;
        AppMethodBeat.o(127418);
    }
}
