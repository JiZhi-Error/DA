package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q {
    private final com.tencent.mm.plugin.sns.ad.landingpage.component.b.e VaJ;

    public e(Context context, com.tencent.mm.plugin.sns.ad.landingpage.component.b.e eVar, ViewGroup viewGroup) {
        super(context, eVar, viewGroup);
        AppMethodBeat.i(259431);
        this.VaJ = eVar;
        this.Edn.kv("finderUsername", this.VaJ.finderUsername);
        AppMethodBeat.o(259431);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void hWL() {
        AppMethodBeat.i(259432);
        try {
            String str = fds().uxInfo;
            String snsId = fds().getSnsId();
            Log.i("AdLandingFinderProfileBtnComp", "doBtnClick, uxInfo=" + str + ", snsId=" + snsId);
            AdLandingPagesProxy.getInstance().doJumpToFinderProfileUI(this.VaJ.finderUsername, str, snsId, 5);
            AppMethodBeat.o(259432);
        } catch (Throwable th) {
            Log.e("AdLandingFinderProfileBtnComp", "doBtnClick, exp=" + th.toString());
            AppMethodBeat.o(259432);
        }
    }
}
