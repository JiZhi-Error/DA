package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzs extends IOException {
    public zzs(String str) {
        super(str);
    }

    static zzs zzu() {
        AppMethodBeat.i(100759);
        zzs zzs = new zzs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        AppMethodBeat.o(100759);
        return zzs;
    }

    static zzs zzv() {
        AppMethodBeat.i(100760);
        zzs zzs = new zzs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        AppMethodBeat.o(100760);
        return zzs;
    }

    static zzs zzw() {
        AppMethodBeat.i(100761);
        zzs zzs = new zzs("CodedInputStream encountered a malformed varint.");
        AppMethodBeat.o(100761);
        return zzs;
    }
}
