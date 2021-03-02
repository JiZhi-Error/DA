package org.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends b {
    public d(String str, Exception exc) {
        super(String.format("Error while signing string: %s", str), exc);
        AppMethodBeat.i(40505);
        AppMethodBeat.o(40505);
    }
}
