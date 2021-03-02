package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzabx extends IOException {
    zzabx(int i2, int i3) {
        super(new StringBuilder(108).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(i2).append(" limit ").append(i3).append(").").toString());
        AppMethodBeat.i(40270);
        AppMethodBeat.o(40270);
    }
}
