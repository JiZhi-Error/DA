package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class al {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(118236);
        int[] iArr = new int[ak.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[ak.DEFAULT.ordinal()] = 1;
        $EnumSwitchMapping$0[ak.ATOMIC.ordinal()] = 2;
        $EnumSwitchMapping$0[ak.UNDISPATCHED.ordinal()] = 3;
        $EnumSwitchMapping$0[ak.LAZY.ordinal()] = 4;
        int[] iArr2 = new int[ak.values().length];
        haE = iArr2;
        iArr2[ak.DEFAULT.ordinal()] = 1;
        haE[ak.ATOMIC.ordinal()] = 2;
        haE[ak.UNDISPATCHED.ordinal()] = 3;
        haE[ak.LAZY.ordinal()] = 4;
        AppMethodBeat.o(118236);
    }
}
