package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class TMAssistantProfile extends d {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":TMAssistantDownloadSDKService");

    static {
        AppMethodBeat.i(19479);
        AppMethodBeat.o(19479);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(19478);
        a.cc(MMApplicationContext.getContext());
        t.d(false, dkO);
        ab.WH();
        AppMethodBeat.o(19478);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
    }

    public String toString() {
        return dkO;
    }
}
