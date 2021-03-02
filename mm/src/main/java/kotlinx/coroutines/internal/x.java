package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, hxF = {"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"})
public final /* synthetic */ class x {
    public static final boolean buD(String str) {
        AppMethodBeat.i(192491);
        String buC = w.buC(str);
        if (buC != null) {
            boolean parseBoolean = Boolean.parseBoolean(buC);
            AppMethodBeat.o(192491);
            return parseBoolean;
        }
        AppMethodBeat.o(192491);
        return true;
    }

    public static final long e(String str, long j2, long j3, long j4) {
        AppMethodBeat.i(192492);
        String buC = w.buC(str);
        if (buC == null) {
            AppMethodBeat.o(192492);
        } else {
            Long buB = n.buB(buC);
            if (buB != null) {
                j2 = buB.longValue();
                if (j3 > j2 || j4 < j2) {
                    IllegalStateException illegalStateException = new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + j2 + '\'').toString());
                    AppMethodBeat.o(192492);
                    throw illegalStateException;
                }
                AppMethodBeat.o(192492);
            } else {
                IllegalStateException illegalStateException2 = new IllegalStateException(("System property '" + str + "' has unrecognized value '" + buC + '\'').toString());
                AppMethodBeat.o(192492);
                throw illegalStateException2;
            }
        }
        return j2;
    }
}
