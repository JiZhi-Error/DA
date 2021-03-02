package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwo extends ContentObserver {
    zzwo(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        AppMethodBeat.i(2275);
        zzwn.zzrs().set(true);
        AppMethodBeat.o(2275);
    }
}
