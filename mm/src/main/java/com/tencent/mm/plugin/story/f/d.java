package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d {
    private static final int FlL = 86400000;
    private static long FlM = 0;
    public static final d FlN = new d();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(118647);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_STORY_ONE_DAY_POST_TIMESTAMP_LONG_SYNC, (Object) 0L);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(118647);
            throw tVar;
        }
        FlM = ((Long) obj).longValue();
        AppMethodBeat.o(118647);
    }

    private d() {
    }

    public static boolean canPostStory() {
        AppMethodBeat.i(118643);
        Log.d(TAG, "lastTimestamp: " + FlM);
        long aWz = cl.aWz();
        if (aWz - FlM > ((long) FlL)) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, (Object) 0);
            FlM = aWz;
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_STORY_ONE_DAY_POST_TIMESTAMP_LONG_SYNC, Long.valueOf(FlM));
            Log.d(TAG, "count reset to 0, lastTimestamp update to now: " + FlM);
        }
        e aAh3 = g.aAh();
        p.g(aAh3, "MMKernel.storage()");
        Object obj = aAh3.azQ().get(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, (Object) 0);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(118643);
            throw tVar;
        }
        int intValue = ((Integer) obj).intValue();
        if (intValue < ((Number) f.Flq.aLT()).intValue()) {
            Log.d(TAG, "pass, count=".concat(String.valueOf(intValue)));
            AppMethodBeat.o(118643);
            return true;
        }
        Log.d(TAG, "goodbye, count=".concat(String.valueOf(intValue)));
        AppMethodBeat.o(118643);
        return false;
    }

    public static void fnK() {
        AppMethodBeat.i(118644);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, (Object) 0);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(118644);
            throw tVar;
        }
        int intValue = ((Integer) obj).intValue();
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(intValue + 1));
        AppMethodBeat.o(118644);
    }

    public static void fnL() {
        AppMethodBeat.i(118645);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, (Object) 0);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(118645);
            throw tVar;
        }
        int intValue = ((Integer) obj).intValue();
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(Math.max(0, intValue - 1)));
        AppMethodBeat.o(118645);
    }

    public static void aaG(int i2) {
        AppMethodBeat.i(118646);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(Math.min(i2, ((Number) f.Flq.aLT()).intValue())));
        AppMethodBeat.o(118646);
    }
}
