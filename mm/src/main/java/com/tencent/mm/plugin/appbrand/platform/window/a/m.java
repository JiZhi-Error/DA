package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class m implements k {
    private final Activity mActivity;

    m(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.k
    public final boolean cz() {
        AppMethodBeat.i(176756);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(176756);
            return false;
        }
        boolean aQ = j.cDv.aQ(this.mActivity);
        AppMethodBeat.o(176756);
        return aQ;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.k
    public final int bTW() {
        AppMethodBeat.i(176757);
        int aP = j.cDv.aP(this.mActivity);
        AppMethodBeat.o(176757);
        return aP;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.k
    public final void c(Configuration configuration) {
    }
}
