package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

/* access modifiers changed from: package-private */
public final class zza extends DataHolder.Builder {
    zza(String[] strArr, String str) {
        super(strArr, null, null);
    }

    @Override // com.google.android.gms.common.data.DataHolder.Builder
    public final DataHolder.Builder withRow(ContentValues contentValues) {
        AppMethodBeat.i(11690);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot add data to empty builder");
        AppMethodBeat.o(11690);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.data.DataHolder.Builder
    public final DataHolder.Builder withRow(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(11689);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot add data to empty builder");
        AppMethodBeat.o(11689);
        throw unsupportedOperationException;
    }
}
