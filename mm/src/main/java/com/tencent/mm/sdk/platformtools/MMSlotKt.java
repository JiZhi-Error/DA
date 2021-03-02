package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"DEFAULT_SLOT_SECONDS", "", "now", "isExpire", "", "seconds", "", "millSeconds", "libcompatible_release"})
public final class MMSlotKt {
    private static final long DEFAULT_SLOT_SECONDS = 900;

    public static final long now() {
        AppMethodBeat.i(215495);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(215495);
        return currentTimeMillis;
    }

    public static final boolean isExpire(long j2, long j3) {
        AppMethodBeat.i(156397);
        if (now() - j2 > j3) {
            AppMethodBeat.o(156397);
            return true;
        }
        AppMethodBeat.o(156397);
        return false;
    }

    public static final boolean isExpire(long j2, int i2) {
        AppMethodBeat.i(156398);
        boolean isExpire = isExpire(j2, ((long) i2) * 1000);
        AppMethodBeat.o(156398);
        return isExpire;
    }
}
