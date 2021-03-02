package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.tav.coremedia.TimeUtil;
import kotlinx.coroutines.internal.u;

public final class bj {
    private static final u TUF = new u("REMOVED_TASK");
    private static final u TUG = new u("CLOSED_EMPTY");

    static {
        AppMethodBeat.i(192386);
        AppMethodBeat.o(192386);
    }

    public static final long Pl(long j2) {
        if (j2 <= 0) {
            return 0;
        }
        if (j2 >= 9223372036854L) {
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        return TimeUtil.SECOND_TO_US * j2;
    }
}
