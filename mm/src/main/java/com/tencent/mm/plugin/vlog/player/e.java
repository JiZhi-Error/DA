package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;

public final class e {
    public static final e GBH = new e();
    private static final ConcurrentHashMap<String, a> tVA = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(110977);
        AppMethodBeat.o(110977);
    }

    private e() {
    }

    public static /* synthetic */ void p(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(110973);
        p.h(str, "path");
        if (str.length() > 0) {
            Log.i("MicroMsg.VLogMaterialsInfoCache", "putCache, path:" + str + ", width:" + i2 + ", height:height, rotate:" + i4 + ", cropLeft:-1, cropTop:-1" + ", cropRight:-1, cropBottom:-1");
            tVA.put(str, new a(i2, i3, i4));
        }
        AppMethodBeat.o(110973);
    }

    public static /* synthetic */ void a(String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        a aVar;
        AppMethodBeat.i(110974);
        p.h(str, "path");
        if (!(str.length() > 0) || (aVar = tVA.get(str)) == null) {
            AppMethodBeat.o(110974);
            return;
        }
        Log.i("MicroMsg.VLogMaterialsInfoCache", "updateCache, path:" + str + ", width:" + i2 + ", height:height, rotate:-1, cropLeft:" + i4 + ", cropTop:" + i5 + ", cropRight:" + i6 + ", cropBottom:" + i7);
        if (i2 > 0) {
            aVar.width = i2;
        }
        if (i3 > 0) {
            aVar.height = i3;
        }
        if (i4 >= 0) {
            aVar.cropLeft = i4;
        }
        if (i5 >= 0) {
            aVar.cropTop = i5;
        }
        if (i6 >= 0) {
            aVar.cropRight = i6;
        }
        if (i7 >= 0) {
            aVar.cropBottom = i7;
        }
        p.g(aVar, LocaleUtil.ITALIAN);
        tVA.put(str, aVar);
        AppMethodBeat.o(110974);
    }

    public static a aUf(String str) {
        AppMethodBeat.i(110975);
        p.h(str, "path");
        if (str.length() == 0) {
            AppMethodBeat.o(110975);
            return null;
        }
        a aVar = tVA.get(str);
        AppMethodBeat.o(110975);
        return aVar;
    }

    public static void clearCache() {
        AppMethodBeat.i(110976);
        Log.i("MicroMsg.VLogMaterialsInfoCache", "clearCache");
        tVA.clear();
        AppMethodBeat.o(110976);
    }
}
