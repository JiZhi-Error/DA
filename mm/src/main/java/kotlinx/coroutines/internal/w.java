package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, hxF = {"AVAILABLE_PROCESSORS", "", "getAVAILABLE_PROCESSORS", "()I", "systemProp", "", "propertyName", "kotlinx-coroutines-core"})
public final /* synthetic */ class w {
    private static final int TWi = Runtime.getRuntime().availableProcessors();

    static {
        AppMethodBeat.i(192472);
        AppMethodBeat.o(192472);
    }

    public static final int hNR() {
        return TWi;
    }

    public static final String buC(String str) {
        String str2;
        AppMethodBeat.i(192471);
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException e2) {
            str2 = null;
        }
        AppMethodBeat.o(192471);
        return str2;
    }
}
