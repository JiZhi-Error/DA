package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc implements TextFilterable.StringFilter {
    zzc() {
    }

    @Override // com.google.android.gms.common.data.TextFilterable.StringFilter
    public final boolean matches(String str, String str2) {
        AppMethodBeat.i(11692);
        boolean contains = str.contains(str2);
        AppMethodBeat.o(11692);
        return contains;
    }
}
