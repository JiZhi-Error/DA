package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class b {
    private i.a Dud;
    private SnsAdLandingPageFloatView Due;
    private boolean Et = false;

    public b(i.a aVar) {
        this.Dud = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[Catch:{ Throwable -> 0x014f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean C(android.view.ViewGroup r9) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.b.C(android.view.ViewGroup):boolean");
    }

    public final void eXl() {
        AppMethodBeat.i(202011);
        try {
            SnsAdLandingPageFloatView snsAdLandingPageFloatView = this.Due;
            if (snsAdLandingPageFloatView != null) {
                snsAdLandingPageFloatView.flb();
                AppMethodBeat.o(202011);
                return;
            }
            Log.w("SnsAd.FloatPageHelper", "the float view is null, is it attached??");
            AppMethodBeat.o(202011);
        } catch (Throwable th) {
            AppMethodBeat.o(202011);
        }
    }

    public final List<m> getAllComp() {
        AppMethodBeat.i(202012);
        try {
            if (this.Due != null) {
                List<m> allComp = this.Due.getAllComp();
                AppMethodBeat.o(202012);
                return allComp;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202012);
        return null;
    }
}
