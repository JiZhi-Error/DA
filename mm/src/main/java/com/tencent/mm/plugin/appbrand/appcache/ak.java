package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lr;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.launching.as;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class ak {
    private static final byte[] kLI = new byte[0];

    public interface a {
        public static final a kLS = new a() {
            /* class com.tencent.mm.plugin.appbrand.appcache.ak.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.appcache.ak.a
            public final boolean bqX() {
                return false;
            }
        };

        boolean bqX();
    }

    public static void aR(String str, int i2) {
        AppMethodBeat.i(44324);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44324);
            return;
        }
        Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "hit appId:%s,version:%d", str, Integer.valueOf(i2));
        aj ajVar = (aj) n.W(aj.class);
        if (ajVar == null) {
            AppMethodBeat.o(44324);
            return;
        }
        synchronized (kLI) {
            try {
                al alVar = new al();
                alVar.field_appId = str;
                alVar.field_version = i2;
                if (ajVar.get(alVar, al.kJX)) {
                    alVar.field_hit++;
                    alVar.field_hitTimeMS = Util.nowMilliSecond();
                    ajVar.update(alVar, al.kJX);
                } else {
                    alVar.field_hit = 1;
                    alVar.field_hitTimeMS = Util.nowMilliSecond();
                    ajVar.insert(alVar);
                }
            } finally {
                AppMethodBeat.o(44324);
            }
        }
    }

    public enum b {
        NO_NEED,
        TRIMMED,
        TRIM_FAIL;

        public static b valueOf(String str) {
            AppMethodBeat.i(44322);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(44322);
            return bVar;
        }

        static {
            AppMethodBeat.i(44323);
            AppMethodBeat.o(44323);
        }
    }

    public static b a(long j2, a aVar) {
        AppMethodBeat.i(44325);
        if (j2 <= 0) {
            b bVar = b.NO_NEED;
            AppMethodBeat.o(44325);
            return bVar;
        }
        StatFs statFs = new StatFs(az.bwm());
        long blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j2) {
            b bVar2 = b.NO_NEED;
            AppMethodBeat.o(44325);
            return bVar2;
        }
        b b2 = b(j2, aVar);
        AppMethodBeat.o(44325);
        return b2;
    }

    public static b b(long j2, a aVar) {
        LinkedList linkedList;
        long j3;
        AppMethodBeat.i(44326);
        Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginCode sizeOfBytes:%d", Long.valueOf(j2));
        aj ajVar = (aj) n.W(aj.class);
        if (ajVar == null) {
            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, lruStorage NULL", Long.valueOf(j2));
            b bVar = b.TRIM_FAIL;
            AppMethodBeat.o(44326);
            return bVar;
        }
        String format = String.format(Locale.US, " %s, %s ASC", "hit", "hitTimeMS");
        linkedList = new LinkedList();
        synchronized (kLI) {
            try {
                Cursor query = ajVar.db.query("PluginCodeUsageLRURecord", new String[]{"appId", "version"}, null, null, null, null, format, 2);
                if (query == null) {
                    return b.TRIM_FAIL;
                } else if (!query.moveToFirst()) {
                    query.close();
                    b bVar2 = b.TRIM_FAIL;
                    AppMethodBeat.o(44326);
                    return bVar2;
                } else {
                    do {
                        try {
                            linkedList.add(Pair.create(query.getString(0), Integer.valueOf(query.getInt(1))));
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy, read from cursor e = %s", e2);
                            query.close();
                        } catch (Throwable th) {
                            query.close();
                            AppMethodBeat.o(44326);
                            throw th;
                        }
                    } while (query.moveToNext());
                    query.close();
                }
            } finally {
                AppMethodBeat.o(44326);
            }
        }
        Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "plugincode size:%d", Integer.valueOf(linkedList.size()));
        bh buL = n.buL();
        if (buL == null) {
            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "trimBy %d, pkgStorage NULL", Long.valueOf(j2));
            b bVar3 = b.TRIM_FAIL;
            AppMethodBeat.o(44326);
            return bVar3;
        }
        a(aVar);
        Iterator it = linkedList.iterator();
        long j4 = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            for (bd bdVar : buL.b((String) pair.first, ((Integer) pair.second).intValue(), bh.a.ASC, "pkgPath", "versionMd5")) {
                j4 = s.boW(bdVar.field_pkgPath) + j4;
                Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "wxapkg appid:%s,delete path:%s,trimSize:%d", bdVar.field_appId, bdVar.field_pkgPath, Long.valueOf(j4));
                s.deleteFile(bdVar.field_pkgPath);
                cs(bdVar.field_appId, bdVar.field_versionMd5);
                String str = bdVar.field_appId;
                if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId null!");
                } else {
                    String substring = str.substring(0, str.indexOf("$"));
                    if (Util.isNullOrNil(substring)) {
                        Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider null!");
                    } else {
                        ao buD = n.buD();
                        at buF = n.buF();
                        if (buD == null || buF == null) {
                            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission storage null!");
                        } else if (buF.ach(substring) != null) {
                            as asVar = new as();
                            asVar.field_appId = substring;
                            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission provider:%s, ret:%b", substring, Boolean.valueOf(buF.delete(asVar, new String[0])));
                        } else {
                            Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removePluginPermission appId:%s permission null!", substring);
                        }
                    }
                }
                i2++;
                ajVar.aS((String) pair.first, ((Integer) pair.second).intValue());
                a(aVar);
                if (j4 >= j2) {
                    if (i2 > 0) {
                        lr lrVar = new lr();
                        lrVar.eZr = 4;
                        lrVar.eZt = (long) i2;
                        if (v.bvG()) {
                            j3 = 1;
                        } else {
                            j3 = 0;
                        }
                        lrVar.eZp = j3;
                        lrVar.bfK();
                    }
                    b bVar4 = b.TRIMMED;
                    AppMethodBeat.o(44326);
                    return bVar4;
                }
            }
            j4 = j4;
        }
        b bVar5 = b.TRIM_FAIL;
        AppMethodBeat.o(44326);
        return bVar5;
    }

    private static void cs(String str, String str2) {
        AppMethodBeat.i(226358);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId or md5 null or nil!");
            AppMethodBeat.o(226358);
            return;
        }
        String substring = str.substring(0, str.indexOf("$"));
        Log.i("MicroMsg.AppBrand.PluginCodePruneLRULogic", "removeCodeCache appId:%s,versionMd5:%s", str, str2);
        for (e eVar : s.dC(ad.bDt(), false)) {
            if (!Util.isNullOrNil(eVar.name) && eVar.RbJ && eVar.name.startsWith("plugin.js") && eVar.name.endsWith(substring)) {
                for (e eVar2 : s.dC(eVar.NGP, false)) {
                    Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "innerFileName:%s", eVar2.name);
                    if (!Util.isNullOrNil(eVar2.name) && eVar2.name.equals(str2)) {
                        Log.d("MicroMsg.AppBrand.PluginCodePruneLRULogic", "delete codeCache name:%s ret:%b", eVar2.name, Boolean.valueOf(eVar2.hdW()));
                    }
                }
            }
        }
        AppMethodBeat.o(226358);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(44327);
        if (aVar == null || !aVar.bqX()) {
            AppMethodBeat.o(44327);
            return;
        }
        InterruptedException interruptedException = new InterruptedException();
        AppMethodBeat.o(44327);
        throw interruptedException;
    }
}
