package com.google.firebase;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c implements BackgroundDetector.BackgroundStateChangeListener {
    c() {
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        AppMethodBeat.i(4106);
        a.xT();
        AppMethodBeat.o(4106);
    }
}
