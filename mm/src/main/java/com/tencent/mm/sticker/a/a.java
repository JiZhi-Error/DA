package com.tencent.mm.sticker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/sticker/model/LensInfoMemCache;", "", "()V", "Expired", "", "TAG", "", "infoMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invalidList", "get", "lensId", "isInvalid", "", "markInvalid", "", "remove", "update", "info", "plugin-sticker_release"})
public final class a {
    private static final c<String, o<chz, Long>> NNY = new c<>(100);
    private static final c<String, Long> NNZ = new c<>(100);
    public static final a NOa = new a();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(105959);
        AppMethodBeat.o(105959);
    }

    private a() {
    }

    public final synchronized void e(chz chz) {
        AppMethodBeat.i(105955);
        p.h(chz, "info");
        long currentTicks = Util.currentTicks();
        o<chz, Long> oVar = NNY.get(chz.Lso);
        if (oVar == null) {
            oVar = new o<>(chz, Long.valueOf(currentTicks));
        }
        NNY.put(chz.Lso, oVar);
        Log.i(TAG, "update: " + chz.Lso + ", " + currentTicks);
        AppMethodBeat.o(105955);
    }

    public final synchronized chz biy(String str) {
        A a2;
        AppMethodBeat.i(105956);
        p.h(str, "lensId");
        o<chz, Long> oVar = NNY.get(str);
        if (oVar == null) {
            AppMethodBeat.o(105956);
            a2 = null;
        } else if (Util.ticksToNow(oVar.second.longValue()) > 180000) {
            NNY.remove(str);
            Log.i(TAG, "get: expired " + str + ", " + oVar.second.longValue());
            AppMethodBeat.o(105956);
            a2 = null;
        } else {
            Log.i(TAG, "get: from cache " + str + ", " + oVar.second.longValue());
            a2 = oVar.first;
            AppMethodBeat.o(105956);
        }
        return a2;
    }

    public final synchronized boolean biz(String str) {
        boolean z;
        AppMethodBeat.i(105957);
        p.h(str, "lensId");
        Long l = NNZ.get(str);
        if (l != null) {
            long longValue = l.longValue();
            if (Util.ticksToNow(longValue) > 180000) {
                NNZ.remove(str);
                Log.i(TAG, "isInvalid: expired " + str + ", " + longValue);
                AppMethodBeat.o(105957);
                z = false;
            } else {
                Log.i(TAG, "isInvalid: from cache " + str + " invalid");
                z = true;
                AppMethodBeat.o(105957);
            }
        } else {
            AppMethodBeat.o(105957);
            z = false;
        }
        return z;
    }

    public final synchronized void biA(String str) {
        AppMethodBeat.i(105958);
        p.h(str, "lensId");
        long currentTicks = Util.currentTicks();
        Log.i(TAG, "markInvalid: " + str + ", " + currentTicks);
        NNZ.put(str, Long.valueOf(currentTicks));
        AppMethodBeat.o(105958);
    }
}
