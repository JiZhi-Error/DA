package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.b.a;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(118031);
        int[] iArr = new int[a.c.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[a.c.PARKING.ordinal()] = 1;
        $EnumSwitchMapping$0[a.c.BLOCKING.ordinal()] = 2;
        $EnumSwitchMapping$0[a.c.CPU_ACQUIRED.ordinal()] = 3;
        $EnumSwitchMapping$0[a.c.DORMANT.ordinal()] = 4;
        $EnumSwitchMapping$0[a.c.TERMINATED.ordinal()] = 5;
        AppMethodBeat.o(118031);
    }
}
