package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class c {
    final e aBH;

    public final String toString() {
        AppMethodBeat.i(52982);
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.aBH.isCancellationRequested()));
        AppMethodBeat.o(52982);
        return format;
    }
}
