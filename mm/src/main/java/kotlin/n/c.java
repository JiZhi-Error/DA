package kotlin.n;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\n¨\u0006\b"}, hxF = {"equals", "", "", FacebookRequestErrorClassification.KEY_OTHER, "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, hxG = 1)
public class c extends b {
    public static final boolean a(char c2, char c3, boolean z) {
        AppMethodBeat.i(129450);
        if (c2 == c3) {
            AppMethodBeat.o(129450);
            return true;
        } else if (!z) {
            AppMethodBeat.o(129450);
            return false;
        } else if (Character.toUpperCase(c2) == Character.toUpperCase(c3)) {
            AppMethodBeat.o(129450);
            return true;
        } else if (Character.toLowerCase(c2) == Character.toLowerCase(c3)) {
            AppMethodBeat.o(129450);
            return true;
        } else {
            AppMethodBeat.o(129450);
            return false;
        }
    }

    public static final boolean isSurrogate(char c2) {
        return 55296 <= c2 && 57343 >= c2;
    }
}
