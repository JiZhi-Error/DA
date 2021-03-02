package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public final class v {
    private static long e(String str, long j2, long j3, long j4) {
        AppMethodBeat.i(118123);
        long e2 = x.e(str, j2, j3, j4);
        AppMethodBeat.o(118123);
        return e2;
    }

    public static /* synthetic */ int h(String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(118122);
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        int e2 = (int) e(str, (long) i2, (long) i3, (long) i4);
        AppMethodBeat.o(118122);
        return e2;
    }

    public static /* synthetic */ long cm(String str, long j2) {
        AppMethodBeat.i(192476);
        long e2 = e(str, j2, 1, MAlarmHandler.NEXT_FIRE_INTERVAL);
        AppMethodBeat.o(192476);
        return e2;
    }
}
