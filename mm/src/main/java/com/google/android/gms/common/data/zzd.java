package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd implements TextFilterable.StringFilter {
    zzd() {
    }

    @Override // com.google.android.gms.common.data.TextFilterable.StringFilter
    public final boolean matches(String str, String str2) {
        AppMethodBeat.i(11693);
        boolean startsWith = str.startsWith(str2);
        AppMethodBeat.o(11693);
        return startsWith;
    }
}
