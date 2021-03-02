package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lr;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class ac {
    private static final byte[] kLI = new byte[0];

    public interface a {
        public static final a kLJ = new a() {
            /* class com.tencent.mm.plugin.appbrand.appcache.ac.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.appcache.ac.a
            public final boolean bqX() {
                return false;
            }
        };

        boolean bqX();
    }

    public static void aR(String str, int i2) {
        AppMethodBeat.i(44308);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44308);
            return;
        }
        String Xw = y.Xw(str);
        if (Util.isNullOrNil(Xw)) {
            AppMethodBeat.o(44308);
            return;
        }
        ai aiVar = (ai) n.W(ai.class);
        if (aiVar == null) {
            AppMethodBeat.o(44308);
            return;
        }
        synchronized (kLI) {
            try {
                ah ahVar = new ah();
                ahVar.field_appId = Xw;
                ahVar.field_type = i2;
                if (aiVar.get(ahVar, ah.kJX)) {
                    ahVar.field_hit++;
                    ahVar.field_hitTimeMS = Util.nowMilliSecond();
                    aiVar.update(ahVar, ah.kJX);
                } else {
                    ahVar.field_hit = 1;
                    ahVar.field_hitTimeMS = Util.nowMilliSecond();
                    aiVar.insert(ahVar);
                }
            } finally {
                AppMethodBeat.o(44308);
            }
        }
    }

    public enum b {
        NO_NEED,
        TRIMMED,
        TRIM_FAIL;

        public static b valueOf(String str) {
            AppMethodBeat.i(44306);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(44306);
            return bVar;
        }

        static {
            AppMethodBeat.i(44307);
            AppMethodBeat.o(44307);
        }
    }

    public static b a(long j2, a aVar) {
        ai aiVar;
        LinkedList linkedList;
        AppMethodBeat.i(44310);
        if (j2 <= 0) {
            b bVar = b.NO_NEED;
            AppMethodBeat.o(44310);
            return bVar;
        }
        StatFs statFs = new StatFs(az.bwm());
        long blockSize = (long) (statFs.getBlockSize() * statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j2) {
            b bVar2 = b.NO_NEED;
            AppMethodBeat.o(44310);
            return bVar2;
        }
        aiVar = (ai) n.W(ai.class);
        if (aiVar == null) {
            Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", Long.valueOf(j2));
            b bVar3 = b.TRIM_FAIL;
            AppMethodBeat.o(44310);
            return bVar3;
        }
        String format = String.format(Locale.US, " %s, %s ASC", "hit", "hitTimeMS");
        linkedList = new LinkedList();
        synchronized (kLI) {
            try {
                Cursor query = aiVar.db.query("PkgUsageLRURecord", new String[]{"appId", "type"}, null, null, null, null, format, 2);
                if (query == null) {
                    return b.TRIM_FAIL;
                } else if (!query.moveToFirst()) {
                    query.close();
                    b bVar4 = b.TRIM_FAIL;
                    AppMethodBeat.o(44310);
                    return bVar4;
                } else {
                    do {
                        try {
                            linkedList.add(Pair.create(query.getString(0), Integer.valueOf(query.getInt(1))));
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", e2);
                            query.close();
                        } catch (Throwable th) {
                            query.close();
                            AppMethodBeat.o(44310);
                            throw th;
                        }
                    } while (query.moveToNext());
                    query.close();
                }
            } finally {
                AppMethodBeat.o(44310);
            }
        }
        bh buL = n.buL();
        if (buL == null) {
            Log.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", Long.valueOf(j2));
            b bVar5 = b.TRIM_FAIL;
            AppMethodBeat.o(44310);
            return bVar5;
        }
        a(aVar);
        Iterator it = linkedList.iterator();
        long j3 = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            for (bd bdVar : buL.a((String) pair.first, ((Integer) pair.second).intValue(), bh.a.ASC, "pkgPath")) {
                j3 = s.boW(bdVar.field_pkgPath) + j3;
                s.deleteFile(bdVar.field_pkgPath);
                i2++;
                aiVar.aS((String) pair.first, ((Integer) pair.second).intValue());
                a(aVar);
                if (j3 >= j2) {
                    lr lrVar = new lr();
                    lrVar.eZr = 3;
                    lrVar.eZt = (long) i2;
                    lrVar.eZp = 1;
                    lrVar.bfK();
                    b bVar6 = b.TRIMMED;
                    AppMethodBeat.o(44310);
                    return bVar6;
                }
            }
            j3 = j3;
        }
        b bVar7 = b.TRIM_FAIL;
        AppMethodBeat.o(44310);
        return bVar7;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(44311);
        if (aVar == null || !aVar.bqX()) {
            AppMethodBeat.o(44311);
            return;
        }
        InterruptedException interruptedException = new InterruptedException();
        AppMethodBeat.o(44311);
        throw interruptedException;
    }
}
