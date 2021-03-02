package org.extra.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class f {
    public static boolean isEmpty(CharSequence charSequence) {
        AppMethodBeat.i(236789);
        if (charSequence == null || charSequence.length() == 0) {
            AppMethodBeat.o(236789);
            return true;
        }
        AppMethodBeat.o(236789);
        return false;
    }
}
