package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze implements TextFilterable.StringFilter {
    zze() {
    }

    @Override // com.google.android.gms.common.data.TextFilterable.StringFilter
    public final boolean matches(String str, String str2) {
        AppMethodBeat.i(11694);
        if (!str.startsWith(str2)) {
            String valueOf = String.valueOf(str2);
            if (!str.contains(valueOf.length() != 0 ? " ".concat(valueOf) : new String(" "))) {
                AppMethodBeat.o(11694);
                return false;
            }
        }
        AppMethodBeat.o(11694);
        return true;
    }
}
